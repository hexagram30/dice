(ns hxgm30.dice.version)

(def version "0.2.0")
(def build-date "2020-01-06T05:40:14Z")
(def git-commit "3b351ee")
(def git-branch "master")
(def git-summary "v0.2.0-dirty")

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
