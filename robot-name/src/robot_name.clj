(ns robot-name)

(def alphabet (mapv char (take 26 (iterate inc 65))))
(def digits (apply vector (range 0 10)))
(def robots (atom #{}))

(defn- newid []
  (apply format "%c%c%d%d%d"
         (concat (repeatedly 2 #(rand-nth alphabet))
                 (repeatedly 3 #(rand-nth digits)))))

(defn- gen-id []
  (loop []
    (let [id (newid)]
      (if (contains? @robots id)
        (recur)
        id))))

(defn- gen-id-and-update []
  (let [id (gen-id)]
    (reset! robots (conj @robots id))
    id))

(defn- replace-id [old]
  (let [id (gen-id-and-update)]
    (reset! robots (disj @robots old))
    id))

(defn robot [] {:name (atom (gen-id-and-update))})

(defn robot-name [robot] @(:name robot))

(defn reset-name [robot]
  (let [newid (replace-id (robot-name robot))]
    (reset! (:name robot) newid)))