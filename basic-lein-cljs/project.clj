(defproject basic-lein-cljs "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [reagent "0.8.0-alpha2"]
                 [dynadoc "1.1.5"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-cljsbuild "1.1.7"]
            [dynadoc/lein-dynadoc "1.1.5"]]
  :cljsbuild {:builds [
                       {:source-paths ["src"]
                        :compiler {:output-to "resources/dynadoc-extend/main.js"
                                   :optimizations :simple}}
                       ]}
  :source-paths ["src" "target/classes"]
  :resource-paths ["resources"]
  :clean-targets ["out" "release"]
  :target-path "target")
