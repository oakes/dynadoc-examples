(defproject basic-lein-clj "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [dynadoc "1.1.4"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[dynadoc/lein-dynadoc "1.1.4"]]
  :source-paths ["src" "target/classes"]
  :resource-paths ["resources"]
  :target-path "target"
  :main basic-lein-clj.core)
