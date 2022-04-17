(ns beer-song)
(require '(clojure.string))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (cond
    (= num 2) "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
    (= num 1) "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    (= num 0) "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    :else (str num " bottles of beer on the wall, " num " bottles of beer.\nTake one down and pass it around, " (dec num) " bottles of beer on the wall.\n")))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end]
   (let [num-bottles (range start (dec end) -1)
         all-verses (map verse num-bottles)]
     (clojure.string/join "\n" all-verses))))
