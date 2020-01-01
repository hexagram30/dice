(ns hxgm30.dice.cli.util
  (:require
    [clojure.string :as string])
  (:refer-clojure :exclude [slurp]))

(defmacro slurp [file]
  (clojure.core/slurp file))

(defn display
  ([]
    (display ""))
  ([str-data]
    #?(:clj (println str-data))
    #?(:cljs (print str-data))))

(defn str->int
  [val]
  #?(:clj (Integer/parseInt val))
  #?(:cljs (js/parseInt val)))

(defn args->data
  [raw-args]
  (let [args-str (string/replace
                   #?(:clj raw-args)
                   #?(:cljs (str raw-args))
                   #"[^0-9A-Za-z ]" "")
        args (string/split args-str #" ")]
    (->> args
        (partition 2)
        (map (fn [[k v]] [(keyword k) (str->int v)])))))

(defn grouped-results
  [roll-data results]
  (->> results
       (interleave (map first roll-data))
       (partition 2)
       (group-by first)))

(defn format-results
  [roll-data results]
  (doall
    (for [[group data] (grouped-results roll-data results)]
      (do
        (display (str (name group) ":"))
        (display (str "    " (string/join " " (mapv second data)))))))
  (display "\n"))
