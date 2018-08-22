(ns hxgm30.dice.components.core
  (:require
    [com.stuartsierra.component :as component]
    [hxgm30.dice.components.config :as config]
    [hxgm30.dice.components.logging :as logging]
    [hxgm30.dice.components.random :as random]
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

(def rnd
  {:random (component/using
            (random/create-component)
            [:config :logging])})

(def rnd-without-logging
  {:random (component/using
            (random/create-component)
            [:config])})

(defn basic
  [cfg-data]
  (merge (cfg cfg-data)
         log))

(defn main
  [cfg-data]
  (merge (basic cfg-data)
         rnd))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Initializations   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn initialize-bare-bones
  []
  (-> (config/build-config)
      basic
      component/map->SystemMap))

(defn initialize-for-testing
  []
  (-> (config/build-config)
      cfg
      (merge rnd-without-logging)
      component/map->SystemMap))

(defn initialize
  []
  (-> (config/build-config)
      main
      component/map->SystemMap))

(def init-lookup
  {:basic #'initialize-bare-bones
   :main #'initialize
   :testing #'initialize-for-testing})

(defn init
  ([]
    (init :main))
  ([mode]
    ((mode init-lookup))))
