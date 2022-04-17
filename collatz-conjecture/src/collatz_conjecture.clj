(ns collatz-conjecture)

(defn collatz
  ([num]
   (collatz num 0))
  ([num steps]
   (cond (= num 1) steps
         (even? num) (collatz (quot num 2) (inc steps))
         :else (collatz (inc (* num 3)) (inc steps)))))

(range)