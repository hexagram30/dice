(ns hxgm30.dice.version)

(def version "0.1.1-SNAPSHOT")
(def build-date "2020-01-01T02:12:25Z")
(def git-commit "7d32a4b")
(def git-branch "feature/8/grpc-support")
(def git-summary "v0.1.1-SNAPSHOT-7-g7d32a4b-dirty")

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
