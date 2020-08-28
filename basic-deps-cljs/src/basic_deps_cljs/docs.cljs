(ns basic-deps-cljs.docs
  (:require [basic-deps-cljs.core :refer [clicks get-lib-version]]
            dynadoc.core)
  (:require-macros [dynadoc.example :refer [defexample]]))

(defexample basic-deps-cljs.core/clicks
  {:with-card card
   :with-focus [focus [clicks "Click me!"]]}
  (reagent.core/unmount-component-at-node card)
  (reagent.core/render-component focus card)
  nil)

(defexample basic-deps-cljs.core/get-lib-version
  {:with-callback callback}
  (get-lib-version "dynadoc" callback))
