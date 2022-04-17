(ns rna-transcription)

(def transcription
  {\G \C, \C \G, \T \A, \A \U})

(defn to-rna
  "Transcribes DNA to RNA"
  [dna]
  {:pre [(string? dna)]}
  (let [rna (apply str (mapv transcription dna))]
    (assert (= (count rna) (count dna)) "Invalid nucleotide(s) detected")
    rna))
