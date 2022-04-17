(ns armstrong-numbers)

(defn- my-pow [base exp]
  {:pre [(int? base) (int? exp) (not (neg? exp))]}
  (->>
   (repeat exp base)
   (apply *)))

(defn- digits [num]
  {:pre (int? num)}
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(rem % 10))))

(defn- powers [digits]
  {:pre [(seq? digits) (or (empty? digits) (int? (first digits)))]}
  (let [count-digits (count digits)]
    (map #(my-pow % count-digits) digits)))

(defn armstrong? [num]
  {:pre [(int? num) (>= num 0)]}
  (->>
   num
   digits
   powers
   (apply - num)
   zero?))
