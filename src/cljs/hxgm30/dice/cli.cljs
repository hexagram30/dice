(ns hxgm30.dice.cli
  (:require
    [billo.udp.client.core :as udp]
    [billo.udp.client.util :as util]
    [cljs.nodejs :as node]
    [cljs.reader :refer [read-string]]
    [hxgm30.dice.cli.util :as dice-util :include-macros true :refer [slurp]]
    [taoensso.timbre :as log]))

;;; CLI setup and functions

(node/enable-util-print!)

(def cfg (-> "resources/hexagram30-config/dice.edn"
             (slurp)
             (cljs.reader/read-string)))

;;; UDP Callback

(defn handle-receive
  [client args buffer]
  (let [results (read-string (.toString buffer))]
    (log/debug "Received data.")
    (log/trace "Data: " results)
    (dice-util/format-results (dice-util/args->data args) results)
    (udp/close client)
    (log/debug "Disconnected.")
    (.exit node/process)))

;;; Main

(defn -main
  [& args]
  (print (slurp "resources/text/banner.txt"))
  (util/set-log-level :error)
  (log/trace (str "Got args: " args))
  (let [client (udp/client)
        port (get-in cfg [:rng :udp-server :port])
        data (util/args->str args)]
    (udp/on-receive client #(handle-receive client args %))
    (udp/send client port data)
    (util/wait)))

(set! *main-cli-fn* -main)
