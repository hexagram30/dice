(ns hxgm30.dice.components.grpcd
  (:require
   [com.stuartsierra.component :as component]
   [hxgm30.dice.grpc.api :as api]
   [taoensso.timbre :as log])
  (:import
   (hxgm30.dice.grpc.api DiceRPCServer)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Lifecycle Implementation   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord GRPCServer [server])

(defn start
  [this]
  (let [dice-server (new DiceRPCServer (into {} this))]
    (log/infof "Starting dice gRPC server component on port %s..." 
               (api/port dice-server))
    (api/start dice-server)
    (log/debug "Started dice gRPC server component.")
    (assoc this :server dice-server)))

(defn stop
  [this]
  (log/info "Stopping dice gRPC server component ...")
  (when-let [dice-server (:server this)]
    (log/trace "Using server object:" dice-server)
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
