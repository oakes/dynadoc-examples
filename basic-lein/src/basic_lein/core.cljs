(ns basic-lein.core
  (:require [reagent.core :as r]
            [dynadoc.core])
  (:require-macros [dynadoc.example :refer [defexample]]))

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

