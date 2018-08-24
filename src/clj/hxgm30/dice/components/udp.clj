(ns hxgm30.dice.components.udp
  (:require
    [billo.udp.server.core :as server]
    [clojusc.twig :as logger]
    [com.stuartsierra.component :as component]
    [hxgm30.dice.cli.util :as util]
    [hxgm30.dice.components.config :as config]
    [hxgm30.dice.roller :as roller]
    [taoensso.timbre :as log]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   UdpServer Component API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn cli-parser
  [args options]
  (let [data (util/args->data args)]
    (log/debug "Parsed args from UDP client: " (vec data))
    (format "%s" (roller/roll (:system options) data))))

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
                   :parser-opts {:system this}}
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
