(ns basic-boot-clj.core
  (:require [clojure.string :as str]
            [dynadoc.example :refer [defexample defexamples]]))

(defn get-extension
  "Returns the extension in the given path name."
  [^String path]
  (->> (.lastIndexOf path ".")
       (+ 1)
       (subs path)
       str/lower-case))

(defexample get-extension
  (get-extension "myfile.txt"))

(defexamples clojure.core/conj
  ["Add a name to a vector"
   (conj ["Alice" "Bob"] "Charlie")]
  ["Add a number to a list"
   (conj '(2 3) 1)]
  ["Add a key-val pair to a hash map"
   (conj {:name "Alice"} [:age 30])])

