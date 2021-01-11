(ns cat-facts.delivery.api
  (:require [cat-facts.core.entity :as e]
            [clj-http.client :as http]
            [clojure.data.json :as json]))

(def ^:private api-url "https://catfact.ninja/fact")

(defn parse-fact [body]
  (let [json (json/read-str body)]
    (get json "fact")))

(defn- get-fact []
  (let [resp (http/get api-url)
        status (:status resp)]
    (if-not (= status 200)
      :error-request-failed
      (parse-fact (:body resp)))))

(defrecord WebCatProvider []
  e/CatFactProvider
  (-get-fact [this] (get-fact)))

(defn make-provider []
  (->WebCatProvider))
