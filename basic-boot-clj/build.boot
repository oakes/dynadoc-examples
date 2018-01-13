(set-env!
  :source-paths #{"src"}
  :dependencies '[[dynadoc "RELEASE"]
                  [javax.xml.bind/jaxb-api "2.3.0" :scope "test"] ; necessary for Java 9 compatibility
                  [org.clojure/data.json "0.2.6"]])

(require
  '[basic-boot-clj.core]
  '[dynadoc.boot :refer [dynadoc]])

(deftask run-docs []
  (comp
    (wait)
    (dynadoc :port 5000)))

