(ns hxgm30.dice.components.random
  (:require
    [com.stuartsierra.component :as component]
    [hxgm30.dice.components.config :as config]
    [taoensso.timbre :as log])
  (:refer-clojure :exclude [float bigdec bigint double int long nth])
  (:import
    (java.security SecureRandom)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Globals & Utility Functions   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn get-algorithm
  [system]
  (case (config/rng-algorithm system)
    :non-blocking "NativePRNGNonBlocking"
    :blocking "NativePRNGBlocking"
    :pkcs11 "PKCS11"
    :default "NativePRNG"
    :unsupported-secure-random-algorithm))

(defn create-secure-random-instance
  [system]
  (SecureRandom/getInstance (get-algorithm system)))

(def get-gen #(get-in % [:random :generator]))

(defn set-seed
  [system rand-gen]
  (.setSeed rand-gen (byte-array (config/rng-seed-bytes system))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Random Component API   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def float #(.nextFloat (get-gen %)))
(def bigdec #(clojure.core/bigdec (.nextDouble (get-gen %))))
(def bigint #(clojure.core/bigint (.nextLong (get-gen %))))
(def double #(.nextDouble (get-gen %)))
(def gaussian #(.nextGaussian (get-gen %)))

(defn int
  ([system]
    (.nextInt (get-gen system)))
  ([system limit]
    (.nextInt (get-gen system) limit)))

(def long #(.nextLong (get-gen %)))

(defn nth
  [system coll]
  (clojure.core/nth coll (int system (count coll))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Lifecycle Implementation   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord Random [])

(defn start
  [this]
  (log/info "Starting random component ...")
  (log/debug "Started random component.")
  (let [rand-gen (create-secure-random-instance this)]
    (set-seed this rand-gen)
    (assoc this :generator rand-gen)))

(defn stop
  [this]
  (log/info "Stopping random component ...")
  (log/debug "Stopped random component.")
  (assoc this :generator nil))

(def lifecycle-behaviour
  {:start start
   :stop stop})

(extend Random
  component/Lifecycle
  lifecycle-behaviour)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Component Constructor   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create-component
  ""
  []
  (->Random))
