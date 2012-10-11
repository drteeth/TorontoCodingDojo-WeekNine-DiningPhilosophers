(ns DinningPhilosophers.core)

(defn create-philosopher [left-fork right-fork] {
    :right-fork right-fork
    :left-fork left-fork
  })

(defn create-fork []
  (ref {:used false}))

(defn pick-up [fork]
  (dosync
    (ref-set fork {:used true})))

(defn put-down [fork]
  {:used false})

(defn busy? [fork]
  (= true (:used fork)))