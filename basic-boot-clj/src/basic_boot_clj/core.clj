(ns basic-boot-cljs.core
  (:require [clojure.string :as str]
            [dynadoc.example :refer [defexample]]))

(defn get-extension
  "Returns the extension in the given path name."
  [^String path]
  (->> (.lastIndexOf path ".")
       (+ 1)
       (subs path)
       str/lower-case))

(defexample get-extension
  (get-extension "myfile.txt"))

