(ns hxgm30.dice.core
  "This namespace is system-based; before making any function calls, a
  system that includes a `:random` component needs to be started."
  (:require
    [clojure.string :as string]
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
    (if (= 1 rolls)
      (first results)
      results)))

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
    (if (= 2 rolls)
      (let [results (map dec (d* system 10 rolls))]
        (cond (= [0 0] results) 100
              (= 0 (first results)) (last results)
              :else (Integer/parseInt (string/join "" results))))
      (d* system 10 rolls))))

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
  [system roll-data]
  (mapv #(apply d* %) (map (fn [[s r]] [system (sides s) r]) roll-data)))

(defn sum
  [results]
  (reduce + (flatten results)))
