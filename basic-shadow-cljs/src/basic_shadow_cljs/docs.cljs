(ns basic-shadow-cljs.docs
  (:require [basic-shadow-cljs.core :refer [clicks get-lib-version]]
            ;; must require dynadoc.core so dynadoc's frontend can be built
            dynadoc.core)
  (:require-macros [dynadoc.example :refer [defexample]]))

(defexample basic-shadow-cljs.core/clicks
  {:with-card card
   :with-focus [focus [clicks "Click me!"]]}
  (reagent.core/unmount-component-at-node card)
  (reagent.core/render-component focus card)
  nil)

(defexample basic-shadow-cljs.core/get-lib-version
  {:with-callback callback}
  (get-lib-version "dynadoc" callback))
