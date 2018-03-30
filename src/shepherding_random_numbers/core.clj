(ns shepherding-random-numbers.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [shepherding-random-numbers.singleball :as sb]
            [shepherding-random-numbers.multiball :as mb]))

(q/defsketch shepherding-random-numbers
  :title "Single random circle"
  :size [500 500]
  :setup sb/setup
  :update sb/update-state
  :draw sb/draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
