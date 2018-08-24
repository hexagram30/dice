(ns hxgm30.dice.core
  "This namespace is system-based; before making any function calls, a
  system that includes a `:random` component needs to be started."
  (:require
    [clojusc.system-manager.core :as system-manager]
    [clojusc.twig :as logger]
    [hxgm30.dice.components.core]
    [hxgm30.dice.cli.util :as util]
    [hxgm30.dice.roller :as roller])
  (:gen-class))

(defn -main
  [& args]
  (logger/set-level! '[hxgm30] :error)
  (system-manager/setup-manager {:init 'hxgm30.dice.components.core/cli})
  (system-manager/startup)
  (let [roll-data (util/args->data args)
        results (roller/roll (system-manager/system) roll-data)]
    (util/format-results roll-data results)))
