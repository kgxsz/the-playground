(ns the-playground.schema
  (:require [schema.core :as s]))

(s/defschema User {:user-id s/Uuid :name s/Str})

(s/defschema Template {:template {:data [{:prompt s/Str :name s/Str :value s/Str}]}})

(s/defschema Collection {:collection {:version s/Num
                                      :href s/Str
                                      :items [{:href s/Str
                                               :data [{:name s/Str :value s/Str}]
                                               (s/optional-key :links) [s/Str]}]
                                      (s/optional-key :links) [{:href s/Str :rel s/Str :render s/Str}]
                                      (s/optional-key :queries) [{:href s/Str :rel s/Str :prompt s/Str :data [{:name s/Str :value s/Str}]}]
                                      (s/optional-key :template) {:data [{:prompt s/Str :name s/Str :value s/Str}]}
                                      (s/optional-key :error) {:title s/Str :code s/Str :message s/Str}}})

