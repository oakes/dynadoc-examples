(defproject basic-lein-cljs "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.312"]
                 [reagent "0.8.1"]
                 [javax.xml.bind/jaxb-api "2.3.0" :scope "test"] ; necessary for Java 9 compatibility
                 [dynadoc "RELEASE"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.14"]
            [dynadoc/lein-dynadoc "RELEASE"]]
  :cljsbuild {:builds [{:id "prod"
                        :source-paths ["src"]
                        :compiler {:main "basic-lein-cljs.core"
                                   :optimizations :simple
                                   :output-to "resources/dynadoc-extend/main.js"}}
                       {:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main "basic-lein-cljs.core"
                                   :optimizations :none
                                   :asset-path "/out"
                                   :output-to "resources/dynadoc-extend/main.js"
                                   :output-dir "resources/dynadoc-extend/out"}}]}
  :source-paths ["src" "target/classes"]
  :resource-paths ["resources"]
  :clean-targets ["out" "release"]
  :target-path "target")
