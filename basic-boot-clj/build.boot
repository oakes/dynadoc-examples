(set-env!
  :source-paths #{"src"}
  :dependencies '[[dynadoc "1.1.2"]])

(require
  '[basic-boot-clj.core]
  '[dynadoc.boot :refer [dynadoc]])

(deftask run-docs []
  (comp
    (wait)
    (dynadoc :port 5000)))

