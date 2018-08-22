(ns hxgm30.dice.components.timer
  (:require
    [clojure.core.async :as async]
    [clojusc.twig :as logger]
    [com.stuartsierra.component :as component]
    [hxgm30.dice.components.config :as config]
    [hxgm30.dice.const :as const]
    [taoensso.timbre :as log]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Globals & Utility Functions   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def ^:dynamic *day-period-counter* (atom 0))
(def ^:dynamic *season-counter* (atom 0))

(defn create-timer
  [component period event-type side-effect-fn msg-fn]
  (async/go-loop []
    (do
      (side-effect-fn component)
      (pubsub/publish component :world event-type (msg-fn component))
      (async/<! (async/timeout (* 1000 period)))
      (recur))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Timer Component API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; TBD

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Lifecycle Implementation   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord Timer [])

(defn start
  [this]
  (log/info "Starting timer component ...")
  (log/debug "Started timer component.")
  ; (assoc this :day (create-day-timer this)
  ;             :year (create-year-timer this))
  this)

(defn stop
  [this]
  (log/info "Stopping timer component ...")
  (log/debug "Stopped timer component.")
  ; (assoc this :day nil
  ;             :year nil)
  this)

(def lifecycle-behaviour
  {:start start
   :stop stop})

(extend Timer
  component/Lifecycle
  lifecycle-behaviour)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Constructor   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create-component
  ""
  []
  (map->Timer
    {:day-period-counter (atom 0)
     :season-counter (atom 0)}))
