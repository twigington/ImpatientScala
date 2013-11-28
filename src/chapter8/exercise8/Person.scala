package chapter8.exercise8

/**
8. Compile the Person and SecretAgent classes in Section 8.6 "Overriding Fields", on page 89 and analyze the class
files with javap.
    How many name fields are there? 1 in Person, 2 in SecretAgent
    How many name getter methods are there? none.
    What do they get? nothing.
    (Hint: Use the -c and -private options.)
 */
class Person(val name: String) {
  override def toString = getClass.getName + s"[name=${name}]"
}

class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret" // don't want to reveal name...
  override val toString = "secret" // or class name
}
