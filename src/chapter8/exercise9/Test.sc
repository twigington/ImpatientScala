import chapter8.exercise9._

val aCreature = new CreatureA()
val aAnt = new AntA()

println(s"aCreature(range=${aCreature.range},env.length=${aCreature.env.length})")
println(s"aAnt(range=${aAnt.range},env.length=${aAnt.env.length})")
assert(aCreature.range == 10)
assert(aCreature.env.length == 10)
assert(aAnt.range == 2)
assert(aAnt.env.length == 0)
val bCreature = new CreatureB()
val bAnt = new AntB()
println(s"bCreature(range=${bCreature.range},env.length=${bCreature.env.length})")
println(s"bAnt(range=${bAnt.range},env.length=${bAnt.env.length})")
assert(bCreature.range == 10)
assert(bCreature.env.length == 10)
assert(bAnt.range == 2)
assert(bAnt.env.length == 0)
val cCreature = new CreatureC()
val cAnt = new AntC()
println(s"cCreature(range=${cCreature.range},env.length=${cCreature.env.length})")
println(s"cAnt(range=${cAnt.range},env.length=${cAnt.env.length})")
assert(cCreature.range == 10)
assert(cCreature.env.length == 10)
assert(cAnt.range == 2)
assert(cAnt.env.length == 2)







