(ns hxgm30.dice.core
  "This namespace is system-based; before making any function calls, a
  system that includes a `:random` component needs to be started."
  (:require
    [clojusc.system-manager.core :as system-manager]
    [clojusc.twig :as logger]
    [hxgm30.dice.components.core]
    [hxgm30.dice.components.roller :as roller]
    [hxgm30.dice.cli.util :as util])
  (:gen-class))

(def d4 #'roller/d4)
(def d6 #'roller/d6)
(def d8 #'roller/d8)
(def d10 #'roller/d10)
(def d12 #'roller/d12)
(def d20 #'roller/d20)
(def d100 #'roller/d100)

(defn batch-roll
  [system args]
  (->> args
       (roller/roll system)
       (util/format-results args)))

(defn roll
  [system & raw-args]
  (println "\nResults:\n")
  (batch-roll system (partition 2 raw-args))
  :ok)

(defn -main
  [& args]
  (logger/set-level! '[hxgm30] :error)
  (system-manager/setup-manager {:init 'hxgm30.dice.components.core/cli})
  (system-manager/startup)
  (batch-roll (system-manager/system)
              (util/args->data args)))
