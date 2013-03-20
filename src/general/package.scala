package object general {
  val headerFormat = "Chapter %1$02d: Exercise %2$02d"
  def exerciseHeader(chapter: Int, exercise: Int) {
    println(headerFormat.format(chapter, exercise))
  }
}
