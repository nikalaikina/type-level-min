
trait List

class Nil                              extends List
class ::[Head <: Number, Tail <: List] extends List

type X   = ::[One, ::[Two, Nil]]
type X_2 = One :: Two :: Nil
