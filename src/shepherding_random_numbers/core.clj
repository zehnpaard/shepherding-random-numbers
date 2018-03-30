(ns shepherding-random-numbers.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [shepherding-random-numbers.singleball :as sb]
            [shepherding-random-numbers.multiball :as mb]
            [shepherding-random-numbers.memory :as mem]
            [shepherding-random-numbers.memspeed :as ms]
            [shepherding-random-numbers.specspeed :as ss]
            [shepherding-random-numbers.many :as mn]
            [shepherding-random-numbers.mark :as mark]
            [shepherding-random-numbers.horizontal :as hz]
            [shepherding-random-numbers.circle :as cc]))

(q/defsketch shepherding-random-numbers
  :title "Single random circle"
  :size [600 600]
  :setup cc/setup
  :update cc/update-state
  :draw cc/draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
