(ns hxgm30.dice.version)

(def version "0.2.0-SNAPSHOT")
(def build-date "2020-01-06T03:56:40Z")
(def git-commit "7d2095b")
(def git-branch "feature/9/dice-roll-api")
(def git-summary "7d2095b")

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
