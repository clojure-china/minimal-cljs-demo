
(set-env!
  :asset-paths #{"assets"}
  :resource-paths #{"src"}

  :dependencies '[
    [org.clojure/clojure  "1.8.0"       :scope "provided"]
    [adzerk/boot-cljs     "1.7.228-1"   :scope "test"]
    [adzerk/boot-reload   "0.4.6"       :scope "test"]
    ])

(require
  '[adzerk.boot-cljs :refer [cljs]]
  '[adzerk.boot-reload :refer [reload]])

(deftask compile-cljs []
  (cljs))

(deftask build-advanced []
  (cljs :optimizations :advanced))

(deftask watch-cljs []
  (comp
    (watch)
    (reload :on-jsload 'boot-demo.core/on-jsload)
    (cljs)))
