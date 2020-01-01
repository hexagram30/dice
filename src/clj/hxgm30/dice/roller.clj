(ns hxgm30.dice.roller
  (:require
    [clojure.pprint :as pprint]
    [clojure.string :as string]
    [clojusc.twig :as logger]
    [hxgm30.dice.components.random :as random])
  (:import
    (clojure.lang Keyword)))

(defn sides
  [^Keyword dice]
  (case dice
    :d4 4
    :d6 6
    :d8 8
    :d10 10
    :d12 12
    :d20 20
    :d100 100))

(defn d*
  [system sides rolls]
  (let [results (mapv (fn [_] (inc (random/int system sides))) (range rolls))]
    (cond (= 1 rolls)
          (first results)

          (and (= 10 sides) (= 2 rolls))
          (let [results (map dec results)]
            (cond (= [0 0] results) 100
                  (zero? (first results)) (last results)
                  :else (Integer/parseInt (string/join "" results))))

          :else results)))

(defn d4
  ([system]
    (d4 system 1))
  ([system rolls]
    (d* system 4 rolls)))

(defn d6
  ([system]
    (d6 system 1))
  ([system rolls]
    (d* system 6 rolls)))

(defn d8
  ([system]
    (d8 system 1))
  ([system rolls]
    (d* system 8 rolls)))

(defn d10
  ([system]
    (d10 system 1))
  ([system rolls]
    (d* system 10 rolls)))

(defn d12
  ([system]
    (d12 system 1))
  ([system rolls]
    (d* system 12 rolls)))

(defn d20
  ([system]
    (d20 system 1))
  ([system rolls]
    (d* system 20 rolls)))

(defn d100
  ([system]
    (d100 system 1))
  ([system rolls]
    (d* system 100 rolls)))

(defn roll
  "Usage:

    (roller/roll system {:d6 10})
    (roller/roll system {:d4 2 :d6 2 :d8 4 :d20 1})
  "
  [system roll-data]
  (mapv #(apply d* %) (map (fn [[s r]] [system (sides s) r]) roll-data)))

(defn stats
  [results]
  (let [s (reduce + results)
        c (count results)]
    {:sum s
     :count c
     :low (apply min results)
     :high (apply max results)
     :avg (float (/ s c))}))

(defn metaroll
  "Usage:

    (roller/metaroll (system) {:d4 20 :d6 12 :d8 18 :d20 1})
  "
  [system roll-data]
  (let [results (roll system roll-data)]
    (mapv (fn [r] (if (coll? r)
                    {:rolls r :stats (stats r)}
                    {:roll r}))
          results)))