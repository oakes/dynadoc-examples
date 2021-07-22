(ns cljsjs.rangy-core
  (:require ["@notjosh/rangy-core" :as rangy]
            [goog.object :as gobj]))

(js/goog.exportSymbol "rangy" rangy)
;; in this fork of rangy, init is called automatically
;; but we still need a dummy function with that name
;; so paren-soup doesn't break
(gobj/set js/rangy "init" (fn [& _]))
