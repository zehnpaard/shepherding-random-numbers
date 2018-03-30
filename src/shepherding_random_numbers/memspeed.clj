(ns shepherding-random-numbers.memspeed
  (:require [quil.core :as q]))

(defn make-circle [x]
  {:x x
   :y 0
   :dy 0})

(defn setup []
  (q/frame-rate 60)
  (q/color-mode :hsb)
  (map make-circle (range -9 9.1 0.3)))

(defn bound [n lower upper]
  (-> n (max lower) (min upper)))

(defn update-circle [circle]
  (let [dy (+ (:dy circle)
              (-> (rand 2) dec (/ 2000)))
        y (bound (+ (:y circle) dy) 
                 -1.5 1.5)]
    (-> circle
        (assoc :dy dy)
        (assoc :y y))))

(defn update-state [state]
  (map update-circle state))

(defn draw-circle [circle]
  (let [x (* (:x circle) 50)
        y (* (:y circle) 150)]
    (q/no-stroke)
    (q/with-fill [0 0 0]
      (q/ellipse x y 10 10))
    (q/stroke 0 0 0 180)
    (q/stroke-weight 2)
    (q/line x y x (+ y (* (:dy circle) 2000)))))

(defn draw-state [state]
  (q/background 255)
  (q/with-translation [500 250]
    (doall
      (for [circle state]
        (draw-circle circle)))))


