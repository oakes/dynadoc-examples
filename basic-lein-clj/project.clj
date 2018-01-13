(defproject basic-lein-clj "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [dynadoc "RELEASE"]
                 [javax.xml.bind/jaxb-api "2.3.0" :scope "test"] ; necessary for Java 9 compatibility
                 [org.clojure/data.json "0.2.6"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[dynadoc/lein-dynadoc "RELEASE"]]
  :source-paths ["src" "target/classes"]
  :resource-paths ["resources"]
  :target-path "target"
  :main basic-lein-clj.core)
