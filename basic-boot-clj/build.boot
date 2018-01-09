(set-env!
  :source-paths #{"src"}
  :dependencies '[[dynadoc "1.4.1"]
                  [org.clojure/data.json "0.2.6"]])

(require
  '[basic-boot-clj.core]
  '[dynadoc.boot :refer [dynadoc]])

(deftask run-docs []
  (comp
    (wait)
    (dynadoc :port 5000)))

