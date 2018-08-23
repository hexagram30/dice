(ns hxgm30.dice.components.udp
  (:require
    [billo.udp.server.core :as server]
    [clojusc.twig :as logger]
    [com.stuartsierra.component :as component]
    [hxgm30.dice.components.config :as config]
    [taoensso.timbre :as log]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   UdpServer Component API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn cli-parser
  [data options]
  (log/info "Simple CLI parser got data: " data)
  (log/info "And options: " options)
  (str "Simple cli-parser echoing back data: " data))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Lifecycle Implementation   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord CLIServer [])

(defn start
  [this]
  (let [port (config/rng-udp-server-port this)]
    (log/infof "Starting dice UDP CLI server component on port %s..." port)
    (let [options {:port port
                   :parser-fn cli-parser
                   :parser-opts {}}
          server (server/run options)]
    (log/trace "Using server options:" options)
    (log/debug "Started dice UDP CLI server component.")
    (assoc this :cli server))))

(defn stop
  [this]
  (log/info "Stopping dice UDP CLI server component ...")
  (when-let [server (:cli this)]
    (log/debug "Using server object:" server)
    (server))
  (log/debug "Stopped dice UDP CLI server component.")
  (assoc this :cli nil))

(def lifecycle-behaviour
  {:start start
   :stop stop})

(extend CLIServer
  component/Lifecycle
  lifecycle-behaviour)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Constructor   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create-component
  ""
  []
  (map->CLIServer {}))
