(ns hxgm30.dice.version)

(def version "0.1.8-SNAPSHOT")
(def build-date "2020-01-05T03:21:42Z")
(def git-commit "d93aace")
(def git-branch "feature/9/dice-roll-api")
(def git-summary "d93aace-dirty")

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
