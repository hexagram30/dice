(ns hxgm30.dice.components.config
  (:require
   [com.stuartsierra.component :as component]
   [hxgm30.dice.config :as config]
   [taoensso.timbre :as log]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Utility Functions   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn build-config
  []
  (config/data))

(defn- get-cfg
  [system]
  (get-in system [:config :data]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Config Component API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn day-divisions
  [system]
  (get-in (get-cfg system) [:almanac :event :day :divisions]))

(defn day-messages
  [system]
  (get-in (get-cfg system) [:almanac :event :day :messages]))

(defn day-states
  [system]
  (get-in (get-cfg system) [:almanac :event :day :states]))

(defn day-transitions
  [system]
  (get-in (get-cfg system) [:almanac :event :day :transitions]))

(defn day-transition
  [system idx]
  {:state (nth (day-states system) idx)
   :transition (nth (day-transitions system) idx)
   :message (nth (day-messages system) idx)})

(defn year-divisions
  [system]
  (get-in (get-cfg system) [:almanac :event :year :divisions]))

(defn year-messages
  [system]
  (get-in (get-cfg system) [:almanac :event :year :messages]))

(defn year-states
  [system]
  (get-in (get-cfg system) [:almanac :event :year :states]))

(defn year-transitions
  [system]
  (get-in (get-cfg system) [:almanac :event :year :transitions]))

(defn year-transition
  [system idx]
  {:state (nth (year-states system) idx)
   :transition (nth (year-transitions system) idx)
   :message (nth (year-messages system) idx)})

(defn time-multiplier
  [system]
  (get-in (get-cfg system) [:almanac :time :multiplier]))

(defn log-level
  [system]
  (get-in (get-cfg system) [:logging :level]))

(defn log-nss
  [system]
  (get-in (get-cfg system) [:logging :nss]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Lifecycle Implementation   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord Config [data])

(defn start
  [this]
  (log/info "Starting config component ...")
  (log/debug "Using configuration:" (:data this))
  (log/debug "Started config component.")
  this)

(defn stop
  [this]
  (log/info "Stopping config component ...")
  (log/debug "Stopped config component.")
  (assoc this :data nil))

(def lifecycle-behaviour
  {:start start
   :stop stop})

(extend Config
  component/Lifecycle
  lifecycle-behaviour)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Constructor   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create-component
  ""
  [cfg-data]
  (map->Config {:data cfg-data}))
