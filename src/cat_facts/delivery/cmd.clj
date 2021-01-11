(ns cat-facts.delivery.cmd
  (:require [cat-facts.core.entity :as e]))

(defn- present-fact [fact] (println fact))

(defrecord CmdPresenter []
  e/Presenter
  (-present-fact [_ fact] (present-fact fact)))

(defn make-presenter []
  (->CmdPresenter))