(ns the-playground.schema
  (:require [schema.core :as s]))

(s/defschema Datum {:name s/Str :value s/Str})

(s/defschema Collection {:collection {:version s/Num
                                      :href s/Str
                                      :items [{:href s/Str
                                               :data [Datum]
                                               :links [s/Str]}]
                                      (s/optional-key :links) [{:href s/Str :rel s/Str :render s/Str}]
                                      (s/optional-key :queries) [{:href s/Str :rel s/Str :prompt s/Str :data [Datum]}]
                                      (s/optional-key :template) {:data [{:prompt s/Str :name s/Str :value s/Str}]}
                                      (s/optional-key :errors) [{:name s/Str :message s/Str}]}})


(s/defschema CreateUserTemplate {:template {:data [{:prompt (s/eq "the user's name") :name (s/eq "name") :value s/Str}]}})
