(ns cat-facts.state
  (:require [mount.core :refer [defstate]]
            [cat-facts.delivery.api :refer [make-provider]]
            [cat-facts.delivery.cmd :refer [make-presenter]]
            [cat-facts.core.use-cases :as uc]))

(defstate fact-provider :start (make-provider))
(defstate fact-presenter :start (make-presenter))
(defstate print-cat-fact :start (partial uc/print-cat-fact
                                         fact-provider
                                         fact-presenter))
