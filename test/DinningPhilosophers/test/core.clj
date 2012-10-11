(ns DinningPhilosophers.test.core
  (:use [DinningPhilosophers.core])
  (:use [clojure.test]))

(def fork1 (create-fork))
(def fork2 (create-fork))

(deftest forks
  (is (= false (:used @fork1)))

  (testing "picking up a fork changes it's state to true"
    (is (= true (:used (pick-up fork1)))))

  (testing "putting down a fork changes it's state to false"
    (is (= false (:used (put-down fork1)))))

  (testing "can we tell if a fork is busy."
    (is (= false (busy? (create-fork)))))

  (testing "cannot pick up twice"
    (let [fork (create-fork)]
      (is (= false (busy? @fork)))
      (is (= true (:used (pick-up fork))))
      (is (= true (busy? @fork)))))
)

(deftest philosophers
  (testing "philosopher has a left fork"
    (is (= fork1
          (:left-fork
              (create-philosopher fork1 fork2)))))

  (testing "philosopher has a right fork"
    (is (= fork2
          (:right-fork
              (create-philosopher fork1 fork2)))))

)