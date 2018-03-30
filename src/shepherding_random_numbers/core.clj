(ns shepherding-random-numbers.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [shepherding-random-numbers.singleball :as sb]
            [shepherding-random-numbers.multiball :as mb]
            [shepherding-random-numbers.memory :as mem]
            [shepherding-random-numbers.memspeed :as ms]
            [shepherding-random-numbers.specspeed :as ss]
            [shepherding-random-numbers.many :as mn]))

(q/defsketch shepherding-random-numemers
  :title "Single random circle"
  :size [1000 500]
  :setup mn/setup
  :update mn/update-state
  :draw mn/draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
