(ns clock)

(defn clock->string [clock]
  (format "%02d:%02d" (first clock) (second clock)))

;; todo: use only minutes to keep track of time
;; and convert to hours:minutes just when printing

(defn clock [hours minutes]
  (let [hours-from-mins (quot minutes 60)
        wrapped-minutes (rem minutes 60)
        total-hours (+ hours hours-from-mins)
        wrapped-hours (mod total-hours 24)]
    (if (neg-int? wrapped-minutes)
      (list (mod (dec wrapped-hours) 24) (+ 60 wrapped-minutes))
      (list wrapped-hours wrapped-minutes))))

(defn add-time [clk time]
  (clock (first clk) (+ (second clk) time)))
