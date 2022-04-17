(ns run-length-encoding)

(defn- encode-partition [[fst & rst :as part]]
  (cond->> fst
    rst (str (count part))
    :else str))

(defn run-length-encode
  "encodes a string using run-length-encoding"
  [plain-text]
  {:pre [(string? plain-text)]}
  (->> plain-text
       (partition-by identity)
       (mapcat encode-partition)
       (apply str)))

(defn- decode-group [[_ how-many item]]
  (cond->> item
    (seq how-many) (repeat (Integer/parseInt how-many))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  {:pre [string? cipher-text]}
  (->> cipher-text
       (re-seq #"(\d*)(\D)")
       (mapcat decode-group)
       (apply str)))
