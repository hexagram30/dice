(ns hxgm30.dice.version)

(def version "0.1.4-SNAPSHOT")
(def build-date "2020-01-04T17:22:14Z")
(def git-commit "f7e3044")
(def git-branch "feature/9/dice-roll-api")
(def git-summary "f7e3044-dirty")

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
