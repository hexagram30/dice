(ns hxgm30.dice.components.grpcd
  (:require
   [clojusc.twig :as logger]
   [com.stuartsierra.component :as component]
   [hxgm30.dice.cli.util :as util]
   [hxgm30.dice.components.config :as config]
   [hxgm30.dice.grpc.api :as api]
   [hxgm30.dice.version :as version]
   [taoensso.timbre :as log])
  (:import
   (hxgm30.dice.grpc.api DiceRPCServer)
   (hxgm30.dice.pb.api PingReply
                       PingRequest
                       ServiceAPIGrpc
                       ServiceAPIGrpc$ServiceAPIImplBase
                       VersionReply
                       VersionRequest)
   (io.grpc Server ServerBuilder)))

; (defn make-service []
;   (proxy [hxgm30.dice.pb.api.ServiceAPIGrpc$ServiceAPIImplBase] []
;     (ping [^PingRequest ping reply]
;       (log/debug "Got ping request")
;       (let [builder ]
;         (.onNext reply (.build builder))
;         (.onCompleted reply)))
;     ;; do-single-roll
;     (roll [^RollRequest roll-req reply]
;       (let [die (keyword (.getDiceType roll-req))
;             builder (-> (DiceRoll/newBuilder)
;                         (.setResult (do-single-roll die)
;                         (.setDiceType (name die))))]
;         (.onNext reply (.build builder))
;         (.onCompleted reply)))
;     ;; do-repeated-rolls
;     ;; do-various-rolls
;     ;; do-repeated-meta-rolls
;     ;; do-repeated-various-rolls
;     (version [^VersionRequest version reply]
;       (log/debug "Got version request")
;       (let [builder (-> (VersionReply/newBuilder)
;                         (.setVersion version/version)
;                         (.setBuildDate version/build-date)
;                         (.setGitCommit version/git-commit)
;                         (.setGitBranch version/git-branch)
;                         (.setGitSummary version/git-summary))]
;         (.onNext reply (.build builder))
;         (.onCompleted reply)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Lifecycle Implementation   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord GRPCServer [server])

(defn start
  [this]
  (let [dice-server (new DiceRPCServer (into {} this))]
    (log/infof "Starting dice gRPC server component on port %s..." 
               (api/port dice-server))
    (let [s (api/start dice-server)]
    (log/debug "Started dice UDP CLI server component.")
    (assoc this :server s))))

(defn stop
  [this]
  (log/info "Stopping dice gRPC server component ...")
  (when-let [dice-server (:server this)]
    (log/debug "Using server object:" dice-server)
    (api/shutdown dice-server))
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
