(ns etl)

(defn transpose [[k v]]
  (let [v-lower (map clojure.string/lower-case v)]
    (zipmap v-lower (repeat k))))

(defn transform [source]
  (->> source
       seq
       (map transpose)
       (apply merge)))
