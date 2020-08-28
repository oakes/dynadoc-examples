(ns basic-lein-cljs.core
  (:require [reagent.core :as r]
            [goog.object :as gobj]
            ;; must require dynadoc.core so dynadoc's frontend can be built
            dynadoc.core)
  (:require-macros [dynadoc.example :refer [defexample]])
  (:import goog.net.XhrIo))

(defn clicks
  "Shows the number of times the user clicked the button."
  [button-text]
  (let [state (r/atom {:clicks 0})]
    (fn []
      [:div
       [:p "You clicked " (:clicks @state) " times"]
       [:button {:on-click (fn []
                             (swap! state update :clicks inc))}
        button-text]])))

(defexample clicks
  {:with-card card
   :with-focus [focus [clicks "Click me!"]]}
  (reagent.core/unmount-component-at-node card)
  (reagent.core/render-component focus card)
  nil)

(defn get-lib-version
  "Queries Clojars for the version of the given library, providing it in a
  callback. If it can't find it, the callback receives an error object."
  [lib-name callback]
  (.send XhrIo
    (str "https://clojars.org/api/artifacts/" lib-name)
    (fn [e]
      (callback
        (or (when (.isSuccess (.-target e))
              (-> e
                  .-target
                  .getResponseText
                  js/JSON.parse
                  (gobj/get "latest_release")))
            (js/Error. (str "Can't find version for: " lib-name)))))
    "GET"))

(defexample get-lib-version
  {:with-callback callback}
  (get-lib-version "dynadoc" callback))

