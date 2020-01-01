(ns hxgm30.dice.version)

(def version "%%VERSION%%")
(def build-date "%%BUILDDATE%%")
(def git-commit "%%GITCOMMIT%%")
(def git-branch "%%GITBRANCH%%")
(def git-summary "%%GITSUMMARY%%")

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
