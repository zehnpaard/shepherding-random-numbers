(ns shepherding-random-numbers.horizontal
  (:require [quil.core :as q]))

(defn make-circle [x]
  {:x x
   :dx 0
   :sdx 0
   :y 0
   :dy 0
   :sdy 0})

(defn setup []
  (q/frame-rate 60)
  (q/color-mode :hsb)
  (q/background 255)
  (map make-circle (range -9 9.1 0.005)))


(defn update-special-velocities [state]
  (let [sdys (reductions + 0 (map :dy state))
        sdxs (reductions + 0 (map :dx state))]
    (->> state
         (map #(assoc %2 :sdy %1) sdys)
         (map #(assoc %2 :sdx %1) sdxs))))

(defn bound [n lower upper]
  (-> n (max lower) (min upper)))

(defn update-circle [circle]
  (let [dy (+ (:dy circle)
              (-> (rand 2) dec (/ 10000)))
        y (bound (+ (:y circle) dy (:sdy circle)) 
                 -1.5 1.5)
        dx (+ (:dx circle)
              (-> (rand 2) dec (/ 10000)))
        x (bound (+ (:x circle) dx (:sdx circle)) 
                 -10 10)]
    (-> circle
        (assoc :dy dy)
        (assoc :y y)
        (assoc :dx dx)
        (assoc :x x))))

(defn update-state [state]
  (->> state
       update-special-velocities
       (map update-circle)))

(defn draw-circle [circle]
  (let [x (* (:x circle) 50)
        y (* (:y circle) 150)]
    (q/no-stroke)
    (q/with-fill [0 0 0 50]
      (q/ellipse x y 1 1))))

(defn draw-state [state]
  (q/with-translation [500 250]
    (doall
      (for [circle state]
        (draw-circle circle)))))


