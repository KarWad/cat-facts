(ns cat-facts.core.entity)

(defprotocol CatFactProvider
  (-get-fact [this] "Get a random cat fact"))

(defprotocol Presenter
  (-present-fact [this fact] "Present a piece of information"))

(defn get-fact [provider] (-get-fact provider))
(defn present-fact [presenter fact] (-present-fact presenter fact))
