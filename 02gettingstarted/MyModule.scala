object MyModule {
  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 1) acc
      else go(n-1, n*acc)
    }

    go(n, 1)
  }

  // 2.1: implement fibonacci function with tail recursion
  def fib(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, cur: Int, next: Int): Int = {
      if (n <= 1) cur
      else go(n-1, next, cur+next)
    }

    go(n, 0, 1)
  }

  private def formatAbs(x: Int): String = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(n: Int): String = {
    val msg = "The factorial of %d is %d"
    msg.format(n, factorial(n))
  }

  private def formatResult(name: String, n: Int, f: Int => Int): String = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)
    }

    loop(0)
  }

  // 2.2: implement isSorted function from the signature
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean = {
      if (n >= as.length) true
      else if (ordered(as(n-1), as(n))) loop(n+1)
      else false
    }

    loop(1)
  }

  def partial1[A,B,C](a: A, f: (A, B) => C): B => C = {
    (b: B) => f(a, b)
  }

  // 2.3: implement curry function from the signature
  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    (a: A) => ((b: B) => f(a, b))
  }

  // 2.5: implement compose function from the signature
  // note: there is a built-in function 'compose'
  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 7, factorial))
    println(formatResult("fibonacci", 5, fib))
    println(findFirst(Array(1, 2, 4, 5, 7, 8, 10), (x: Int) => x == 4)) // 2
    println(isSorted(Array(1, 2, 3, 4, 5), (x: Int, y: Int) => x < y)) // true
    println(partial1(3, (a: Int, b: Int) => a + b)(4)) // 7; (3 + 4)
    println(curry((a: Int, b: Int) => a * b)(3)(4)) // 12; (3 * 4)
    println(compose((a: Int) => a+1, (a: Int) => a*2)(3)) // 7; ((3*2)+1)
    println((((a: Int) => a+1) compose ((a: Int) => a*2))(3)) // 7; same as above
    println((((a: Int) => a*2) andThen ((a: Int) => a+1))(3)) // 7; same as above
  }
}
