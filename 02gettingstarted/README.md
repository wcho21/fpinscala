02gettingstarted
================

Solutions for chapter 2.

How to Test
-----------

Put the answer into a dummy class, compile, and run REPL:

```scala
object DummyClass {
    def fib(n: Int): Int = {
        // ...
    }
}
```

```text
$ scalac DummyClass.scala && scala
scala> DummyClass.fib(5)
val res0: Int = 5
```