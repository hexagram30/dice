(ns hxgm30.dice.components.grpcd
  (:require
   [clojusc.twig :as logger]
   [com.stuartsierra.component :as component]
   [hxgm30.dice.cli.util :as util]
   [hxgm30.dice.components.config :as config]
   [hxgm30.dice.roller :as roller]
   [hxgm30.dice.version :as version]
   [taoensso.timbre :as log])
  (:import
   (hxgm30.dice.pb.api PingReply
                       PingRequest
                       ServiceAPIGrpc
                       ServiceAPIGrpc$ServiceAPIImplBase
                       VersionReply
                       VersionRequest)
   (io.grpc Server ServerBuilder)))

(defn do-single-roll
  [die]
  (log/warnf "Got die type: %s" die))

(defn do-repeated-rolls
  [die count]
  )

(defn do-various-rolls
  [die-count-tuples]
  )

(defn do-repeated-meta-rolls
  [die-count]
  )

(defn do-repeated-various-rolls
  [die-count-tuples]
  )

(defn make-service []
  (proxy [hxgm30.dice.pb.api.ServiceAPIGrpc$ServiceAPIImplBase] []
    (ping [^PingRequest ping reply]
      (log/debug "Got ping request")
      (let [builder (.setData (PingReply/newBuilder) "PONG")]
        (.onNext reply (.build builder))
        (.onCompleted reply)))
    ;; do-single-roll
    (roll [^RollRequest roll-req reply]
      (let [die (keyword (.getDiceType roll-req))
            builder (-> (DiceRoll/newBuilder)
                        (.setResult (do-single-roll die)
                        (.setDiceType (name die))))]
        (.onNext reply (.build builder))
        (.onCompleted reply)))
    ;; do-repeated-rolls
    (rollN [^RollRequest roll-req reply]
      (let [die (keyword (.getDiceType roll-req))
            n (.getRollCount roll-req)
            builder (.setResult (DiceRolls/newBuilder)
                                (do-single-roll die))]
        (.onNext reply (.build builder))
        (.onCompleted reply)))
    ;; do-various-rolls
    ;; do-repeated-meta-rolls
    ;; do-repeated-various-rolls
    (version [^VersionRequest version reply]
      (log/debug "Got version request")
      (let [builder (-> (VersionReply/newBuilder)
                        (.setVersion version/version)
                        (.setBuildDate version/build-date)
                        (.setGitCommit version/git-commit)
                        (.setGitBranch version/git-branch)
                        (.setGitSummary version/git-summary))]
        (.onNext reply (.build builder))
        (.onCompleted reply)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Lifecycle Implementation   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord GRPCServer [
  server])

(defn start
  [this]
  (let [port (config/grpcd-port this)
        builder (ServerBuilder/forPort port)
        service (make-service)
        _       (.addService builder service)
        server  (.build builder)]
    (log/infof "Starting dice gRPC server component on port %d..." port)
    (.start server)
    (log/debug "Started dice UDP CLI server component.")
    (assoc this :server server)))

(defn stop
  [this]
  (log/info "Stopping dice gRPC server component ...")
  (when-let [server (:server this)]
    (log/debug "Using server object:" server)
    (.shutdown server))
  (log/debug "Stopped dice gRPC server component.")
  (assoc this :server nil))

(def lifecycle-behaviour
  {:start start
   :stop stop})

(extend GRPCServer
        component/Lifecycle
        lifecycle-behaviour)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Constructor   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create-component
  ""
  []
  (map->GRPCServer {}))
