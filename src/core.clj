(ns core
    (:use [other])
    (:gen-class))

(defn -main []
      (do (print "Main") (print 2) (other/func_from_another_namespace)))
