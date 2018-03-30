(ns shepherding-random-numbers.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [shepherding-random-numbers.singleball :as sb]
            [shepherding-random-numbers.multiball :as mb]
            [shepherding-random-numbers.memory :as mem]))

(q/defsketch shepherding-random-numemers
  :title "Single random circle"
  :size [1000 500]
  :setup mem/setup
  :update mem/update-state
  :draw mem/draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
