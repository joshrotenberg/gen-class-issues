(ns gen-class-issue.core-test
  (:import [stuff MyConcreteThing MyConcreteThing$Builder])
  (:require [clojure.test :refer :all]
            [gen-class-issue.my-concrete-thing :refer :all]))

;; (deftest with-builder
;;   (testing "stuff.MyConcreteThing with builder"
;;     (let [b (MyConcreteThing$Builder.)]
;;       (-> b (.addFoo 20) (.addBar 30))
;;       (let [m (.build b)]
;;         (is (= (.getFoo m) (.getFoo b)))
;;         (is (= (.getBar m) (.getBar b)))
;;         (println m)))))

(deftest without-builder
  (testing "stuff.MyConcreteThing without builder"
    (let [m (stuff.MyConcreteThing. 20 40)]
      (is (= (.getFoo m) 20))
      (is (= (.getBar m) 40))
      (println m))))
