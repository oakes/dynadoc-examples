This repo contains a few minimal examples of projects configured with [Dynadoc](https://github.com/oakes/Dynadoc).

* To run `basic-boot-clj` or `basic-boot-cljs`, go into the their folders and do `boot run-docs`
* To run `basic-deps-clj` or `basic-deps-cljs`, go into their folders and do `clj -M:docs`
* To run `basic-lein-clj`, go into its folder and do `lein dynadoc --port 5000`
* To run `basic-lein-cljs`, go into its folder and do `lein cljsbuild once prod && lein dynadoc --port 5000` (you can also run `lein figwheel dev` in a separate terminal for live-reloading)

Here is a static page generated by one of these example projects:

https://oakes.github.io/dynadoc-examples/
