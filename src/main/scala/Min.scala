import Min.Aux

trait Min[L <: List] {
  type Result <: Number
}

trait LowPriorityInstances {
  implicit def minT[Head <: Number, Tail <: List, TailMin <: Number](
    implicit tailMin: Aux[Tail, TailMin]
  ): Aux[Head :: Tail, TailMin] = {
    new Min[Head :: Tail] {
      type Result = TailMin
    }
  }
}

object Min extends LowPriorityInstances {
  type Aux[L <: List, R <: Number] = Min[L] { type Result = R }
  def apply[L <: List](implicit min: Min[L]): Aux[L, min.Result] = min

  implicit def minOne[Head <: Number]: Aux[Head :: Nil, Head] = {
    new Min[Head :: Nil] {
      type Result = Head
    }
  }

  implicit def minH[Head <: Number, Tail <: List, TailMin <: Number](
    implicit tailMin: Aux[Tail, TailMin],
    lessOrEqual: LessOrEqual[Head, TailMin]
  ): Aux[Head :: Tail, Head] = {
    new Min[Head :: Tail] {
      type Result = Head
    }
  }

  Min[Two :: Four :: Three :: Three :: Nil]
}
