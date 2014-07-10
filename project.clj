(defproject org.dthume/data.interval-treeset "0.1.0-SNAPSHOT"
  :description "Interval Tree"

  :plugins [[codox "0.8.9"]
            [lein-midje "3.0.0"]
            [perforate "0.3.3"]]

  :codox {:defaults {:doc/format :markdown}}

  :dependencies [[clj-tuple "0.1.5"]
                 [org.clojure/clojure "1.6.0"]
                 [org.clojure/data.finger-tree "0.0.2"]]

  :javac-options ["-target" "1.6" "-source" "1.6"]

  :perforate
  {:benchmark-paths ["src/benchmark/clj"]}

  :profiles
  {:dev
   {:source-paths ["src/dev/clj"]
    :dependencies [[midje "1.6.3"]
                   [perforate "0.3.3"]]}

   :benchmark
   {:jvm-opts ^:replace
    ["-XX:+DoEscapeAnalysis"
     "-XX:+UseBiasedLocking"]}}

  :aliases
  {"dev-bench"
   ^{:doc "Run development benchmarks"}
   ["with-profile" "benchmark" "perforate"]

   "dev-repl"
   ^{:doc "Start a clean development NREPL session"}
   ["do" ["clean"] ["repl"]]

   "dev-test"
   ^{:doc "Run development unit tests"}
   ["do" ["clean"] ["midje"]]})