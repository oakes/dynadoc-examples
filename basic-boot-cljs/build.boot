(set-env!
  :source-paths #{"src"}
  :dependencies '[[adzerk/boot-cljs "2.1.4" :scope "test"]
                  [adzerk/boot-reload "0.5.2" :scope "test"]
                  [org.clojure/test.check "0.9.0" :scope "test"]
                  [org.clojure/clojurescript "1.9.946" :scope "test"]
                  [reagent "0.8.0-alpha2"]
                  [dynadoc "1.1.4"]])

(require
  '[adzerk.boot-cljs :refer [cljs]]
  '[adzerk.boot-reload :refer [reload]]
  '[dynadoc.boot :refer [dynadoc]])

(deftask run-docs []
  (set-env! :resource-paths #{"dev-resources"})
  (comp
    (watch)
    (reload :asset-path "dynadoc-extend")
    (cljs)
    (dynadoc :port 5000)))

