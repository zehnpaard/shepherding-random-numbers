(ns shepherding-random-numbers.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [shepherding-random-numbers.singleball :as sb]
            [shepherding-random-numbers.multiball :as mb]
            [shepherding-random-numbers.memory :as mem]
            [shepherding-random-numbers.memspeed :as ms]
            [shepherding-random-numbers.specspeed :as ss]))

(q/defsketch shepherding-random-numemers
  :title "Single random circle"
  :size [1000 500]
  :setup ms/setup
  :update ms/update-state
  :draw ms/draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
