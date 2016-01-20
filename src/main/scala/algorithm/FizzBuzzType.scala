package algorithm

object Main extends App {

  trait Nat {}
  trait Zero extends Nat
  trait Succ[N <: Nat] extends Nat
  trait ToInt[N <: Nat] { def apply(): Int }

  object ToInt { def apply[N <: Nat](implicit toInt: ToInt[N]): Int = toInt() }

  type _0 = Zero
  type _1 = Succ[_0]
  type _2 = Succ[_1]
  type _3 = Succ[_2]
  type _4 = Succ[_3]
  type _5 = Succ[_4]
  type _6 = Succ[_5]
  type _7 = Succ[_6]
  type _8 = Succ[_7]
  type _9 = Succ[_8]
  type _10 = Succ[_9]
  type _11 = Succ[_10]
  type _12 = Succ[_11]
  type _13 = Succ[_12]
  type _14 = Succ[_13]
  type _15 = Succ[_14]

  implicit def zero: ToInt[Zero] = {
    new ToInt[Zero] { def apply(): Int = 0 }
  }

  implicit def succ[N <: Nat](implicit toInt: ToInt[N]) = {
    new ToInt[Succ[N]] { def apply(): Int = toInt() + 1 }
  }

  assert(ToInt[_9] == 9)
}
