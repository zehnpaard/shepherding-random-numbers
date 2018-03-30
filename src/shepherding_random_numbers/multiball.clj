(ns shepherding-random-numbers.multiball
  (:require [quil.core :as q]))

(defn make-circle [x]
  {:t 0
   :x x
   :y 0
   :dy 0
   :ty 0})

(defn setup []
  (q/frame-rate 60)
  (q/color-mode :hsb)
  (map make-circle (range -9 9.1 0.3)))

(defn set-new-target [circle]
  (let [ty (dec (rand 2))
        dy (-> circle :y (- ty) (/ -30))]
    (-> circle
        (assoc :t 100)
        (assoc :ty ty))))

(defn update-circle [circle]
  (if (zero? (:t circle))
    (set-new-target circle)
    (-> circle
        (update :t dec)
        (assoc :dy (-> circle :ty (- (:y circle)) (/ 30)))
        (update :y #(+ % (:dy circle))))))

(defn update-state [state]
  (map update-circle state))

(defn draw-circle [circle]
  (q/no-fill)
  (q/with-stroke [0 0 0 360]
    (q/ellipse 
      (-> circle :x (* 50)) 
      (-> circle :ty (* 150)) 
      10 10))
  (q/no-stroke)
  (q/with-fill [0 0 0 180]
    (q/ellipse 
      (-> circle :x (* 50)) 
      (-> circle :y (* 150)) 
      10 10)))

(defn draw-state [state]
  (q/background 255)
  (q/with-translation [500 250]
    (doall
      (for [circle state]
        (draw-circle circle)))))


