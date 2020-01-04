(ns hxgm30.dice.version)

(def version "0.1.6-SNAPSHOT")
(def build-date "2020-01-04T19:30:43Z")
(def git-commit "59a4d1e")
(def git-branch "feature/9/dice-roll-api")
(def git-summary "v0.1.5-SNAPSHOT-dirty")

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
