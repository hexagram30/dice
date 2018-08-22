(ns hxgm30.dice.config
  (:require
   [hxgm30.common.file :as common]))

(def config-file "hexagram30-config/dice.edn")

(defn data
  ([]
    (data config-file))
  ([filename]
    (common/read-edn-resource filename)))
