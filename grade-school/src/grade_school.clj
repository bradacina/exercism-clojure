(ns grade-school)

(defn grade [school g]
  (into [] (school g)))

(defn add [school name grade]
  (merge-with into school (hash-map grade [name])))

(defn sorted [school]
  (->> school
       (into (sorted-map))
       (#(zipmap (keys %) (map sort (vals %))))))
