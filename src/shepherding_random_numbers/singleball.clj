(ns shepherding-random-numbers.singleball
  (:require [quil.core :as q]))

(defn make-circle [x]
  {:x x
   :y 0
   :dy 0
   :ty 0})

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :hsb)
  (make-circle 0))

(defn set-new-target [circle]
  (let [ty (dec (rand 2))
        dy (-> circle :y (- ty) (/ -15))]
    (-> circle
        (assoc :ty ty)
        (assoc :dy dy))))

(defn update-circle [circle]
  (if (> 0.01 (q/abs (- (:ty circle) (:y circle))))
    (set-new-target circle)
    (update circle :y #(+ % (:dy circle)))))

(defn update-state [state]
  (update-circle state))

(defn draw-circle [circle]
  (q/no-fill)
  (q/with-stroke [0 0 0 360]
    (q/ellipse 
      (-> circle :x (* 100)) 
      (-> circle :ty (* 100)) 
      30 30))
  (q/no-stroke)
  (q/with-fill [0 0 0 180]
    (q/ellipse 
      (-> circle :x (* 100)) 
      (-> circle :y (* 100)) 
      30 30)))

(defn draw-state [state]
  (q/background 255)
  (q/with-translation [250 250]
    (draw-circle state)))


