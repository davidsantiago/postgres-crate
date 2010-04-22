(ns pallet.target-test
  (:use [pallet.target] :reload-all)
  (:use clojure.test
        pallet.test-utils))

(deftest with-target-test
  (with-target nil {:image [:ubuntu]
                    :tag :ubuntu}
    (is (= [:ubuntu] (template)))
    (is (= :ubuntu (tag)))))

(deftest packager-test
  (with-target nil {:image [:ubuntu]}
    (is (= :aptitude (packager))))
  (is (= :aptitude (packager [:ubuntu])))
  (is (= :yum (packager [:centos])))
  (is (= :portage (packager [:gentoo]))))
