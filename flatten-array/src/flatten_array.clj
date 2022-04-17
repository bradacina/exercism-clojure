(ns flatten-array)

(defn- flatten-internal [arr acc]
  {:pre [(vector? acc) (coll? arr)]}
  (cond (empty? arr) acc
        (nil? (first arr)) (flatten-internal (rest arr) acc)
        (vector? (first arr)) (flatten-internal (rest arr) (flatten-internal (first arr) acc))
        :else (flatten-internal (rest arr) (conj acc (first arr)))))

(defn flatten [arr]
  {:pre [(vector? arr)]}
  (flatten-internal arr []))