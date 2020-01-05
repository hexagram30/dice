(ns hxgm30.dice.version)

(def version "0.1.10-SNAPSHOT")
(def build-date "2020-01-05T04:50:09Z")
(def git-commit "9b9f1a6")
(def git-branch "feature/9/dice-roll-api")
(def git-summary "v0.1.9-SNAPSHOT-dirty")

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
