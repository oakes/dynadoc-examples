(ns basic-deps-clj.core
  (:require [clojure.string :as str]
            [dynadoc.example :refer [defexample defexamples]]
            [clojure.data.json :as json]))

(defn get-extension
  "Returns the extension in the given path name."
  [^String path]
  (->> (.lastIndexOf path ".")
       (+ 1)
       (subs path)
       str/lower-case))

(defexample get-extension
  (get-extension "myfile.txt"))

(defn get-lib-version
  "Queries Clojars for the version of the given library, providing it in a
  callback. If it can't find it, the callback receives an error object."
  [lib-name callback]
  (future
    (try
      (callback
        (or (some-> (str "https://clojars.org/api/artifacts/" lib-name)
                    slurp
                    json/read-str
                    (get "latest_release"))
            (Exception. (str "Can't find version for: " lib-name))))
      (catch Exception e (callback e)))))

(defexample get-lib-version
  {:with-callback callback}
  (get-lib-version "dynadoc" callback))

(defexamples clojure.core/conj
  ["Add a name to a vector"
   (conj ["Alice" "Bob"] "Charlie")]
  ["Add a number to a list"
   (conj '(2 3) 1)]
  ["Add a key-val pair to a hash map"
   (conj {:name "Alice"} [:age 30])])

