(ns series)

(defn slices [string length]
  (map #(take length (drop % string))
       (range (- (inc (count string)) length))))

(slices "helloworld" 2)