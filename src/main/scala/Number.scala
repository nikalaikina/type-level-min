
trait Number

class Zero                 extends Number
class PlusOne[X <: Number] extends Number

type One   = PlusOne[Zero]
type Two   = PlusOne[One]
type Three = PlusOne[Two]
type Four  = PlusOne[Three]
