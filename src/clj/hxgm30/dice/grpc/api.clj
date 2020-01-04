(ns hxgm30.dice.grpc.api
  (:require
   [hxgm30.dice.components.config :as config]
   [hxgm30.dice.components.roller :as roller]
   [hxgm30.dice.version :as version]
   [taoensso.timbre :as log])
  (:import
   (clojure.lang Keyword)
   (hxgm30.dice.pb.api DiceRoll
                       DiceRepeatedRolls
                       DiceRollStats
                       DiceVariousRolls
                       MetaRoll
                       MetaRolls
                       RollRequest
                       RollsRequest
                       RollVariousRequest
                       ServiceAPIGrpc
                       ServiceAPIGrpc$ServiceAPIImplBase)
   (hxgm30.proto.buf.common PingReply
                            PingRequest
                            VersionReply
                            VersionRequest)
   (io.grpc Server ServerBuilder)))

(def PONG "PONG")
(def state (atom {}))

(gen-class
    :name hxgm30.dice.grpc.api.DiceRPCServer
    :extends hxgm30.dice.pb.api.ServiceAPIGrpc$ServiceAPIImplBase
    :state state
    :init init
    :constructors {[clojure.lang.PersistentArrayMap] []})

(defn -init
  [system]
  (log/debug "Initializing Dice RPC server ...")
  (log/trace "Using system: " system)
  (let [port (config/grpcd-port system)
        builder (ServerBuilder/forPort port)]
    [[] (reset! state {:port port
                       :builder builder
                       :system system})]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   State Wrappers   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn built->reply
  [built reply]
  (.onNext reply built)
  (.onCompleted reply))

(defn port
  [this]
  (:port (.state this)))

(defn builder
  [this]
  (:builder (.state this)))

(defn server
  [this]
  (:server @state))

(defn system
  [this]
  (:system (.state this)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Builder Wrappers   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn ping-builder
  []
  (-> (PingReply/newBuilder)
      (.setData PONG)
      (.build)))

(defn roll-once-builder
  [system ^Keyword die]
  (-> (DiceRoll/newBuilder)
      (.setResult (roller/roll-once system die))
      (.setDiceType (name die))
      (.build)))

(defn roll-repeated-builder
  [system ^Keyword die n]
  (let [rolls (mapv int (roller/roll-repeated system die n))]
    (-> (DiceRepeatedRolls/newBuilder)
        (.addAllResults rolls)
        (.setDiceType (name die))
        (.build))))

(defn version-builder
  []
  (-> (VersionReply/newBuilder)
      (.setVersion version/version)
      (.setBuildDate version/build-date)
      (.setGitCommit version/git-commit)
      (.setGitBranch version/git-branch)
      (.setGitSummary version/git-summary)
      (.build)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Java API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn -ping
  [this ^PingRequest request ^PingReply reply]
  (log/debug "Got ping request")
  (built->reply (ping-builder) reply))

(defn -rollOnce
  [this ^RollRequest request ^DiceRoll reply]
  (log/debug "Got roll-once request")
  (built->reply
    (roll-once-builder (system this) 
                       (keyword (.getDiceType request)))
    reply))

(defn -rollRepeated
  [this ^RollsRequest request ^DiceRepeatedRolls reply]
  (log/debug "Got roll-repeated request")
  (built->reply
    (roll-repeated-builder (system this) 
                           (keyword (.getDiceType request))
                           (.getRollCount request))
    reply))

(defn -rollVarious
  [this]
  )

(defn -rollMetaRepeated
  [this]
  )

(defn -rollMetaVarious
  [this]
  )

(defn shutdown
  [this]
  (.shutdown (server this)))

(defn -version
  [this ^VersionRequest request ^VersionReply reply]
  (log/debug "Got version request")
  (built->reply (version-builder) reply))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Netty Wrappers   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn add-service
  [this]
  (log/debug "Adding dice RPC service to server builder ...")
  (.addService (builder this) this))

(defn start
  [this]
  (log/trace "Got port: " (port this))
  (log/trace "Got system: " (system this))
  (add-service this)
  (let [netty-server (.build (builder this))]
    (log/debug "Starting internal gRPC server ...")
    (.start netty-server)
    (log/info "Started internal gRPC server")
    (swap! state assoc-in [:server] netty-server)))
