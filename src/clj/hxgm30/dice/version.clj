(ns hxgm30.dice.version)

(def version "0.2.0")
(def build-date "2020-01-06T04:00:59Z")
(def git-commit "431700b")
(def git-branch "master")
(def git-summary "431700b-dirty")

(defn build-info
  []
  (format "%s, %s@%s, %s" version git-branch git-commit build-date))

(defn version-info
  []
  {:version version
   :build-date build-date
   :git-commit git-commit
   :git-branch git-branch
   :git-summary git-summary
   :build-info (build-info)})
