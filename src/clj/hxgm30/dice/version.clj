(ns hxgm30.dice.version)

(def version "0.1.1-SNAPSHOT")
(def build-date "2020-01-01T08:14:28Z")
(def git-commit "81b8fa4")
(def git-branch "feature/9/dice-roll-api")
(def git-summary "81b8fa4-dirty")

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
