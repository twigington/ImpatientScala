package chapter5

class PersonE7(_fullName: String) {
  //val firstName,lastName = _fullName.split(" ")
  val firstName: String = _fullName.split(" ")(0)
  val lastName: String = _fullName.split(" ")(1)
}
