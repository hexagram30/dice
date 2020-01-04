(ns hxgm30.dice.cli.util
  (:require
    [clojure.string :as string]))

(defn display
  ([]
    (display ""))
  ([str-data]
    (println str-data)))

(defn str->int
  [val]
  (Integer/parseInt val))

(defn args->data
  [raw-args]
  (let [args-str (string/replace
                   raw-args
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
