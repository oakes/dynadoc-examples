(set-env!
  :source-paths #{"src"}
  :dependencies '[[org.clojure/test.check "0.9.0" :scope "test"]
                  [org.clojure/clojurescript "1.9.946"]
                  [dynadoc "1.0.0"]])

(require
  '[basic-boot-clj.core]
  '[dynadoc.boot :refer [dynadoc]])

(deftask run-docs []
  (comp
    (wait)
    (dynadoc :port 5000)))

