package chapter7

/**
9: Write a program that imports the java.lang.System class, reads the user name from user.name system property,
  reads a password from the Console object, and prints a message to the standard error stream if the password is not
  "secret". Otherwise print a greeting to the standard output stream. Do not use any other imports, and do not use
  any qualified names (with dots).
 */
object Exercise9 extends App {
  import java.lang.System._

  val userName = getProperty("user.name")

  val password = Console.readLine("Password:")
  if (password == "secret") {
    println(s"Greetings Starfighter ${userName}")
  } else {
    Console.err.println("WRONG!")
  }
}
