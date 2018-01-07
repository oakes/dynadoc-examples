(ns basic-lein-clj.core
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

(defn call-fn-after-delay
  "Runs the given function after a three second delay."
  [thunk]
  (future
    (Thread/sleep 3000)
    (thunk)))

(defexample call-fn-after-delay
  {:doc "This is an example of how to display a value that is asynchronous."
   :with-callback callback}
  (call-fn-after-delay (fn [] (callback "Hello world!"))))

(defexamples clojure.core/conj
  ["Add a name to a vector"
   (conj ["Alice" "Bob"] "Charlie")]
  ["Add a number to a list"
   (conj '(2 3) 1)]
  ["Add a key-val pair to a hash map"
   (conj {:name "Alice"} [:age 30])])

