(set-env!
  :source-paths #{"src"}
  :dependencies '[[adzerk/boot-cljs "2.1.4" :scope "test"]
                  [adzerk/boot-reload "0.5.2" :scope "test"]
                  [org.clojure/test.check "0.9.0" :scope "test"]
                  [org.clojure/clojurescript "1.9.946"]
                  [reagent "0.8.0-alpha2"]
                  [dynadoc "1.0.0-SNAPSHOT"]])

(require
  '[adzerk.boot-cljs :refer [cljs]]
  '[adzerk.boot-reload :refer [reload]]
  '[dynadoc.boot :refer [dynadoc]])

(def dynadoc-port 5000)

(deftask run-docs []
  (set-env! :source-paths #{"src"} :resource-paths #{"dev-resources"})
  (comp
    (watch)
    (reload :asset-path "dynadoc-extend")
    (cljs)
    (dynadoc :port dynadoc-port)
    (with-pass-thru _
      (println (str "See the main docs at http://localhost:" dynadoc-port "/cljs/basic-boot.core")))))

