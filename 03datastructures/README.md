03datastructures
================

Solutions for chapter 3.

How to Test
-----------

Put the answer into `List` or `Tree` object, compile, and run REPL:

(For `List` and `Tree` object, see the [official repository][official])

```text
$ scalac List.scala && scala
scala> import fpinscala.datastructures.List

scala> List.tail(List(1,2,3))
val res0: fpinscala.datastructures.List[Int] = Cons(2,Cons(3,Nil))
```

[official]: https://github.com/fpinscala/fpinscala/tree/first-edition/answers/src/main/scala/fpinscala/datastructures