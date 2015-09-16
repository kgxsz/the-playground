(defproject the-playground "0.1.0-SNAPSHOT"

  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-core "1.4.0"]
                 [http-kit "2.1.19"]
                 [bidi "1.20.3"]
                 [jarohen/embed-nrepl "0.1.2"]
                 [jarohen/yoyo "0.0.5"]
                 [jarohen/yoyo.http-kit "0.0.4"]]

  :main the-playground.core)
