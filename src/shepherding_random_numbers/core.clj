(ns shepherding-random-numbers.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :hsb)
  {})

(defn update-state [state]
  state)

(defn draw-state [state]
  (q/background 240)
  (q/fill (:color state) 255 255))

(q/defsketch shepherding-random-numbers
  :title "You spin my circle right round"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
