(ns hxgm30.dice.server
  (:require
   [clojusc.system-manager.core :as system]
   [clojusc.twig :as logger]
   [hxgm30.dice.components.core]
   [trifl.java :as java])
  (:gen-class))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Initial Setup & Utility Functions   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def setup-options {
  :init 'hxgm30.dice.components.core/init
  :throw-errors false})

(defn init
  "This is used to set the options and any other global data.

  This is defined in a function for re-use. For instance, when a REPL is
  reloaded, the options will be lost and need to be re-applied."
  []
  (logger/set-level! '[hxgm30] :debug)
  (system/setup-manager setup-options))

(defn -main
  [& args]
  (init)
  (system/startup)
  (java/join-current-thread))