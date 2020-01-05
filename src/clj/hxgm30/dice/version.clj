(ns hxgm30.dice.version)

(def version "0.1.10-SNAPSHOT")
(def build-date "2020-01-05T20:16:39Z")
(def git-commit "88e8f83")
(def git-branch "feature/9/dice-roll-api")
(def git-summary "88e8f83-dirty")

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
