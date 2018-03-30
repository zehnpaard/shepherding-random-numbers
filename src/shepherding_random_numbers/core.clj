(ns shepherding-random-numbers.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [shepherding-random-numbers.singleball :as sb]
            [shepherding-random-numbers.multiball :as mb]))

(q/defsketch shepherding-random-numbers
  :title "Single random circle"
  :size [1000 500]
  :setup mb/setup
  :update mb/update-state
  :draw mb/draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
