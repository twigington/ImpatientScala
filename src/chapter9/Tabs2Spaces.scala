package chapter9

/**
 *
 */
object Tabs2Spaces extends App {
  for (anArg <- args) {
    import scala.io.Source
    val source = Source.fromFile(anArg)
    val inputLines = source.getLines()
    source.close()

    val outputLines = inputLines map replaceTabs

    writeFile(anArg, outputLines)
  }

  def replaceTabs(text: String) = text.replaceAll("\t", "  ")

  def writeFile(filename: String, lines: Iterator[String]) {
    import java.io.PrintWriter
    val out = new PrintWriter(filename)
    for (line <- lines) out.println(line)
    out.close()
  }
}
