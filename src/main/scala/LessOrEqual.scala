
class LessOrEqual[A <: Number, B <: Number]

implicit def compareWithZero[B <: Number]: LessOrEqual[Zero, B] = {
  new LessOrEqual[Zero, B]
}

implicit def compareOther[A <: Number, B <: Number](
  implicit exists: LessOrEqual[A, B]
): LessOrEqual[PlusOne[A], PlusOne[B]] = {
  new LessOrEqual[PlusOne[A], PlusOne[B]]
}
