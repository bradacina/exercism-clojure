(ns phone-number)

(defn number [num-string]
  {:pre [(string? num-string)]}
  (let [digits (take 11 (filter #(Character/isDigit %) num-string))
        first-digit (first digits)
        count-digits (count digits)]
    (cond
      (and
       (= \1 first-digit)
       (= 11 count-digits)) (apply str (drop 1 digits))
      (= 10 count-digits) (apply str digits)
      :else "0000000000")))

(defn extract [to-drop to-take num-string]
  (apply str (take to-take (drop to-drop (number num-string)))))

(defn area-code [num-string]
  (extract 0 3 num-string))

(defn exchange [num-string]
  (extract 3 3 num-string))

(defn subscriber [num-string]
  (extract 6 4 num-string))

(defn pretty-print [num-string]
  (format  "(%s) %s-%s" (area-code num-string) (exchange num-string) (subscriber num-string)))