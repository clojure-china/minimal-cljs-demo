
(ns boot-demo.core
  (:require
    [clojure.string :as string]))

(defonce counts (atom 0))

(defn render-page []
  (set! (-> js/document (.querySelector "#app") .-innerText) @counts))

(defn increase-counter []
  (swap! counts inc)
  (render-page))

(defn -main []
  (enable-console-print!)
  (render-page)
  (println "render page 2"))

(set! (.-onload js/window) -main)
(set! (.-onclick js/window) increase-counter)

(defn on-jsload []
  (swap! counts + 10)
  (render-page)
  (println "reload 3 on change..."))
