(defn get-banner
  []
  (try
    (str
      (slurp "resources/text/banner.txt")
      ;(slurp "resources/text/loading.txt")
      )
    ;; If another project can't find the banner, just skip it;
    ;; this function is really only meant to be used by Dragon itself.
    (catch Exception _ "")))

(defn get-prompt
  [ns]
  (str "\u001B[35m[\u001B[34m"
       ns
       "\u001B[35m]\u001B[33m λ\u001B[m=> "))

(defproject hexagram30/dice "0.1.1-SNAPSHOT"
  :description "An entropy manager, random number generator/seed tracker, and dice-roller for hexagram30 projects"
  :url "https://github.com/hexagram30/dice"
  :license {
    :name "Apache License, Version 2.0"
    :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :exclusions [
    ;; JDK version issues overrides
    [org.clojure/clojure]
    [org.clojure/core.incubator]
    [org.clojure/core.rrb-vector]]
  :dependencies [
    ;; JDK version issues overrides
    [org.clojure/core.incubator "0.1.4"]
    [org.clojure/core.rrb-vector "0.1.1"]
    ;; Regular dependencies
    [clojusc/system-manager "0.3.0"]
    [clojusc/twig "0.4.1"]
    [com.google.protobuf/protobuf-java-util "3.11.1"]
    [hexagram30/common "0.1.0-SNAPSHOT"]
    [io.grpc/grpc-netty "1.26.0"]
    [io.grpc/grpc-protobuf "1.26.0"]
    [io.grpc/grpc-stub "1.26.0"]
    [javax.annotation/javax.annotation-api "1.3.2"]
    [org.clojure/clojure "1.10.1"]]
  :plugins [
    [org.xolstice.maven.plugins/protobuf-maven-plugin "0.6.1"]]
  :source-paths ["src/clj" "src/cljc"]
  :java-source-paths ["src/java"]
  :profiles {
    :ubercompile {
      :aot :all}
    :dev {
      :dependencies [
        [clojusc/trifl "0.4.2"]
        [org.clojure/tools.namespace "0.3.1"]]
      :plugins [
        [lein-shell "0.5.0"]
        [org.clojure/core.rrb-vector "0.1.1"]]
      :source-paths ["dev-resources/src"]
      :main hxgm30.dice.core}
    :lint {
      :source-paths ^:replace ["src"]
      :test-paths ^:replace []
      :plugins [
        [jonase/eastwood "0.3.6"]
        [lein-ancient "0.6.15"]
        [lein-bikeshed "0.5.2"]
        [lein-kibit "0.1.8"]]}
    :repl {
      :repl-options {
        :init-ns hxgm30.dice.repl
        :prompt ~get-prompt
        :init ~(println (get-banner))}
      :middleware [ultra.plugin/middleware]
      :plugins [
        [venantius/ultra "0.6.0"]]}
    :test {
      :plugins [
        [lein-ltest "0.4.0"]]}
    :server {
      :jvm-opts ["-XX:MaxDirectMemorySize=512g"]
      :main hxgm30.dice.server}}
  :aliases {
    ;; Dev Aliases
    "repl" ["do"
      ["clean"]
      ["with-profile" "+dev,+repl" "repl"]]
    "ubercompile" ["do"
      ["clean"]
      ["with-profile" "+ubercompile" "compile"]]
    "check-vers" ["with-profile" "+lint" "ancient" "check" ":all"]
    "check-jars" ["with-profile" "+lint" "do"
      ["deps" ":tree"]
      ["deps" ":plugin-tree"]]
    "check-deps" ["do"
      ["check-jars"]
      ["check-vers"]]
    "kibit" ["with-profile" "+lint" "kibit"]
    "eastwood" ["with-profile" "+lint" "eastwood" "{:namespaces [:source-paths]}"]
    "lint" ["do"
      ["kibit"]
      ; ["eastwood"]
      ]
    "ltest" ["with-profile" "+test" "ltest"]
    "ltest-clean" ["do"
      ["clean"]
      ["ltest"]]
    "build" ["do"
      ["clean"]
      ["check-vers"]
      ["lint"]
      ["ltest" ":all"]
      ["ubercompile"]
      ["clean"]
      ["uberjar"]]
    ;; Script Aliases
    "run" ["with-profile" "+server" "run"]
    "roll" ["run"]})
