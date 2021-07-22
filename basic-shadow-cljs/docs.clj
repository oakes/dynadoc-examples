(require '[dynadoc.core :as dynadoc])
(dynadoc/start {:port 5000})

(require
  '[shadow.cljs.devtools.api :as shadow]
  '[shadow.cljs.devtools.server :as server])
(server/start!)
(shadow/watch :main {:verbose true})
;(shadow/release :main {:verbose true})

(require '[clojure.java.browse :as browse])
(browse/browse-url "http://localhost:5000/cljs/basic-shadow-cljs.core")
