(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins  [[lein-cljsbuild "0.3.2"]
             [lein-ring "0.8.6"]]
  :hooks  [leiningen.cljsbuild]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]]
  :source-paths  ["src-clj"]
  :cljsbuild  {
               :builds  [{:source-paths  ["src-cljs"]
                          :compiler  {:output-to "resources/public/js/main.js"
                                      :optimizations :whitespace
                                      :pretty-print true}}]}
  :ring  {:handler {{ns-name}}.routes/app})
