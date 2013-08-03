(ns leiningen.new.cljs-init
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "cljs-init"))

(defn cljs-init
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data 
             ["project.clj" (render "project.clj" data)]
             ["src-clj/{{sanitized}}/routes.clj" (render "routes.clj" data)]
             ["src-clj/{{sanitized}}/views.clj" (render "views.clj" data)]
             ["test/{{sanitized}}/core_test.clj" (render "core_test.clj" data)]
             ["src-cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             )))
