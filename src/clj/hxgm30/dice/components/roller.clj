(ns hxgm30.dice.components.roller
  (:require
    [clojure.pprint :as pprint]
    [clojure.string :as string]
    [clojusc.twig :as logger]
    [hxgm30.dice.components.random :as random]
    [taoensso.timbre :as log])
  (:import
    (clojure.lang Keyword)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Support Functions   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

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

(defn stats
  [results]
  (let [s (reduce + results)
        c (count results)]
    {:sum s
     :count c
     :low (apply min results)
     :high (apply max results)
     :avg (float (/ s c))}))

(defn add-meta
  [results]
  (mapv (fn [r] (if (coll? r)
                  {:rolls r :stats (stats r)}
                  {:roll r}))
        results))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Dice API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Roll API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn roll-once
  [system ^Keyword die]
  (d* system (sides die) 1))

(defn roll-repeated
  [system ^Keyword die n]
  (d* system (sides die) n))

(defn roll-various
  [system die-counts]
  (log/debug "Got die-counts:" die-counts)
  (mapv #(apply d* %) (map (fn [[s r]] [system (sides s) r]) die-counts)))

(defn roll-meta-repeated
  [system ^Keyword die n]
  (add-meta [(roll-repeated system die n)]))

(defn roll-meta-various
  [system die-counts]
  (add-meta (roll-various system die-counts)))

(defn roll
  "Usage:

    (roller/roll system :d6)

    (roller/roll system :d6 10)
    (roller/roll system {:d6 10}) ; same as above

    (roller/roll system {:d4 2 :d6 2 :d8 4 :d20 1})
  "
  ([system arg]
    (if (keyword? arg)
      (roll-once system arg)
      (roll-various system arg)))
  ([system die n]
    (roll-repeated system die n)))

(defn roll-meta
  "Usage:
    (roller/roll-meta (system) :d4 20)
    (roller/roll-meta (system) {:d4 20 :d6 12 :d8 18 :d20 1})
  "
  ([system die-counts]
    (roll-meta-various system die-counts))
  ([system ^Keyword die n]
    (roll-meta-repeated system die n)))
