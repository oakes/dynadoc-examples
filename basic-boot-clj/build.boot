(set-env!
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojurescript "1.9.946" :scope "test"]
                  [dynadoc "1.0.0"]])

(require
  '[basic-boot-clj.core]
  '[dynadoc.boot :refer [dynadoc]])

(deftask run-docs []
  (comp
    (wait)
    (dynadoc :port 5000)))

