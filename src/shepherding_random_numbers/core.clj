(ns shepherding-random-numbers.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [shepherding-random-numbers.singleball :as s]))

(q/defsketch shepherding-random-numbers
  :title "Single random circle"
  :size [500 500]
  :setup s/setup
  :update s/update-state
  :draw s/draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
