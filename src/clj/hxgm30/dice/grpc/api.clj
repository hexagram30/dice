(ns hxgm30.dice.grpc.api
  (:require
   [hxgm30.dice.components.config :as config]
   [hxgm30.dice.components.roller :as roller]
   [hxgm30.dice.version :as version]
   [taoensso.timbre :as log])
  (:import
   (clojure.lang Keyword)
   (hxgm30.dice.pb.api DiceRoll
                       DiceRolls
                       MetaRoll
                       MetaRolls
                       PingReply
                       PingRequest
                       RollRequest
                       RollsRequest
                       RollVariousRequest
                       ServiceAPIGrpc
                       ServiceAPIGrpc$ServiceAPIImplBase
                       VariousDiceRolls
                       VersionReply
                       VersionRequest)
   (io.grpc Server ServerBuilder)))

(def PONG "PONG")

(gen-class
    :name hxgm30.dice.grpc.api.DiceRPCServer
    :extends hxgm30.dice.pb.api.ServiceAPIGrpc$ServiceAPIImplBase
    :state state
    :init init
    :constructors {[clojure.lang.PersistentArrayMap] []})

(defn -init
  [system]
  (log/debug "Initializing Dice RPC server with system: " system)
  [[] {:port (config/grpcd-port system)
       :system system}])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Builder Wrappers   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn ping-builder
  []
  (-> (PingReply/newBuilder)
      (.setData PONG)
      (.build)))

(defn roll-builder
  [system ^Keyword die]
  (-> (DiceRoll/newBuilder)
      (.setResult (roller/d* system die 1))
      (.setDiceType (name die))
      (.build)))

(defn version-builder
  []
  (-> (VersionReply/newBuilder)
      (.setVersion version/version)
      (.setBuildDate version/build-date)
      (.setGitCommit version/git-commit)
      (.setGitBranch version/git-branch)
      (.setGitSummary version/git-summary)
      (.build)))

(defn built->reply
  [built reply]
  (.onNext reply built)
  (.onCompleted reply))

(defn port
  [this]
  (:port (.state this)))

(defn system
  [this]
  (:system (.state this)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Java API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn -ping
  [this ^PingRequest request reply]
  (log/debug "Got ping request")
  (built->reply (ping-builder) reply))

(defn -rollOnce
  [this]
  )

(defn -rollRepeated
  [this]
  )

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
  [internal-grpc-server]
  (.shutdown internal-grpc-server))

(defn start
  [dice-server]
  (log/trace "Got port: " (port dice-server))
  (log/trace "Got system: " (system dice-server))
  (let [builder (ServerBuilder/forPort (port dice-server))
        internal-grpc-server (.build builder)]
    (log/debug "Starting internal gRPC server ...")
    (.start internal-grpc-server)
    (log/info "Started internal gRPC server")
    internal-grpc-server))

(defn -version
  [this ^VersionRequest request reply]
  (log/debug "Got version request")
  (built->reply (version-builder) reply))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Clojure API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn roll-once
  [this die]
  (log/warnf "Got die type: %s" die)
  (-> this
      :system
      (roll-builder die)
      built->reply))

(defn new-server
  [port]
  )
