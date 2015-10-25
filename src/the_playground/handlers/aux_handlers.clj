(ns the-playground.handlers.aux-handlers
  (:require [bidi.bidi :as b]
            [ring.swagger.swagger2 :as rs]
            [schema.core :as sc]))

(defn make-api-docs-handler
  [api-handler-mapping route-mapping]
  (fn [req]
    {:status 200
     :body (sc/with-fn-validation
             (rs/swagger-json
               {:info {:version "1.0.0"
                       :title "The Playground"
                       :description "A place to explore"}
                :tags [{:name "User"
                        :description "User stuff"}]
                :paths (apply
                        merge-with
                        merge
                        (for [[handler-key _] api-handler-mapping
                              request-method [:get :post :put :delete :head :options]
                              :let [path (b/path-for route-mapping handler-key)]
                              :when (= handler-key (:handler (b/match-route route-mapping path :request-method request-method)))]
                          {path {request-method (:docs (meta (handler-key api-handler-mapping)))}}))}))}))

(defn make-not-found-handler
  []
  (fn [req] {:status 404}))