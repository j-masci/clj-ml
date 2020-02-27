(ns core
    (:use [other])
    (:gen-class))

; lets us use the other file with the same ns
(load "core-2")

; test scope
(def a_variable 99)

(defn br [] (print "\r\n"))

; simple loop structure
(defn func_2 [times] (dotimes [x times] (print "func 2. ")))

; alt def.
(def func_3 (fn [p] (print "func_3..." p)))

; variable args
(defn variadic_func
      ([] (print "no args"))
      ([p1] (print "1 arg" p1))
      ; error as expected: (due to p1 & p2)
      ; ([p1 p2] (print "variadic exactly 2 args..." p1 p2))
      ([p1 & p2] (do
                   (print "variadic... p1 & p2")
                   (br)
                   (print p1)
                   (br)
                   (print p2)
                   ))
      )

; higher order
(defn get_adder [amt] (fn [in] (+ in amt)))
(def plus_5 (get_adder 5))

; it works...
(print (plus_5 100))
(br)


(defn -main []
      (do
        (print "main")
        (br)
        (other/func_from_another_namespace)
        (br)
        (func_2 5)
        (br)
        (func_3 a_variable)
        (br)
        (variadic_func)
        (br)
        (variadic_func 1)
        (br)
        (variadic_func 1 5 10)
        (br)
        (func_in_core_ns_in_another_file)
      ))

