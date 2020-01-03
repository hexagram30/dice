(ns ^:system hxgm30.dice.tests.system.roller
  (:require
    [clojure.set :as set]
    [clojure.test :refer :all]
    [hxgm30.dice.components.roller :as roller]
    [hxgm30.dice.testing.system :as test-system :refer [system]]))

(use-fixtures :once test-system/with-system)

(deftest d4
  (is (= #{1 2 3 4}
         (set (mapv (fn [_] (roller/d4 (system))) (range 1000)))))
  (is (= #{1 2 3 4}
         (->> (range 1000)
              (mapv (fn [_] (set (roller/d4 (system) 100))))
              (apply set/union)))))

(deftest d6
  (is (= #{1 2 3 4 5 6}
         (set (mapv (fn [_] (roller/d6 (system))) (range 1000)))))
  (is (= #{1 2 3 4 5 6}
         (apply set/union (mapv (fn [_] (set (roller/d6 (system) 100))) (range 1000))))))

(deftest d8
  (is (= #{1 2 3 4 5 6 7 8}
         (set (mapv (fn [_] (roller/d8 (system))) (range 1000)))))
  (is (= #{1 2 3 4 5 6 7 8}
         (apply set/union (mapv (fn [_] (set (roller/d8 (system) 100))) (range 1000))))))

(deftest d10
  (is (= #{1 2 3 4 5 6 7 8 9 10}
         (set (mapv (fn [_] (roller/d10 (system))) (range 1000)))))
  (is (= #{ 1  2  3  4  5  6  7  8  9 10
           11 12 13 14 15 16 17 18 19 20
           21 22 23 24 25 26 27 28 29 30
           31 32 33 34 35 36 37 38 39 40
           41 42 43 44 45 46 47 48 49 50
           51 52 53 54 55 56 57 58 59 60
           61 62 63 64 65 66 67 68 69 70
           71 72 73 74 75 76 77 78 79 80
           81 82 83 84 85 86 87 88 89 90
           91 92 93 94 95 96 97 98 99 100}
         (set (mapv (fn [_] (roller/d10 (system) 2)) (range 10000)))))
  (is (= #{1 2 3 4 5 6 7 8 9 10}
         (apply set/union (mapv (fn [_] (set (roller/d10 (system) 100))) (range 1000))))))

(deftest d12
  (is (= #{1 2 3 4 5 6 7 8 9 10 11 12}
         (set (mapv (fn [_] (roller/d12 (system))) (range 1000)))))
  (is (= #{1 2 3 4 5 6 7 8 9 10 11 12}
         (apply set/union (mapv (fn [_] (set (roller/d12 (system) 100))) (range 1000))))))

(deftest d20
  (is (= #{1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20}
         (set (mapv (fn [_] (roller/d20 (system))) (range 1000)))))
  (is (= #{1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20}
         (apply set/union (mapv (fn [_] (set (roller/d20 (system) 100))) (range 1000))))))

(deftest roll
  (let [roll-count 10000
        results (roller/roll (system) {:d10 roll-count})]
    (is (= [5] (map (comp int #(/ % roll-count) #(reduce + %)) results)))
    (let [rolls (into {} (map #(vector % roll-count) [:d4 :d6 :d8 :d10 :d12 :d20 :d100]))
          expected (map #(* (/ % 2) roll-count) [4 6 8 10 12 20 100])
          results (map (comp #(* % roll-count)
                             #(Math/round %)
                             float
                             #(/ % roll-count)
                             #(reduce + %))
                       (roller/roll (system) rolls))
          paired (partition 2 (interleave expected results))]
      (is (= #{0 1}
             (->> paired
                  (map (comp int
                             #(Math/abs %)
                             float
                             #(/ (- (first %) (second %)) roll-count)))
                  (into #{})))))))
