(require
  '[dynadoc.core :as dynadoc]
  '[figwheel.main :as figwheel])

(dynadoc/start {:port 5000})
(figwheel/-main "--build" "docs")

