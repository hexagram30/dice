(ns hxgm30.dice.components.core
  (:require
    [com.stuartsierra.component :as component]
    [hxgm30.dice.components.config :as config]
    [hxgm30.dice.components.logging :as logging]
    [hxgm30.dice.components.timer :as timer]
    [taoensso.timbre :as log]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Common Configuration Components   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn cfg
  [cfg-data]
  {:config (config/create-component cfg-data)})

(def log
  {:logging (component/using
             (logging/create-component)
             [:config])})

(def pbsb
  {:pubsub (component/using
            (pubsub/create-component tag/subscribers)
            [:config :logging])})

(def tmr
  {:timer (component/using
             (timer/create-component)
             [:config :logging :pubsub])})

(defn basic
  [cfg-data]
  (merge (cfg cfg-data)
         log))

(defn main
  [cfg-data]
  (merge (basic cfg-data)
         pbsb
         tmr))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Initializations   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn initialize-bare-bones
  []
  (-> (config/build-config)
      basic
      component/map->SystemMap))

(defn initialize
  []
  (-> (config/build-config)
      main
      component/map->SystemMap))

(def init-lookup
  {:basic #'initialize-bare-bones
   :main #'initialize})

(defn init
  ([]
    (init :main))
  ([mode]
    ((mode init-lookup))))
