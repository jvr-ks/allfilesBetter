/************************************************
* allfilesBetter.scala
*
* License see MIT-License.txt
*
* GraalVM Community Java 11.0.8
*
* scala 2.13.5
*
************************************************/
// ü force UTF-8


package de.jvr

import better.files._
//import better.files.Dsl._ 
import java.io.{File => JFile}
import java.nio.charset.Charset


object AllfilesBetter {

  def times(c: Char, n: Int): String = c.toString * n
  
  def main(args: Array[String]): Unit = {
    
    val version = "0.023"
    val appname = "allfilesBetter"
    
    var inDirName = ""
    var outDirName = ""
    
    // no args
    inDirName = "." + JFile.separator
    outDirName = inDirName
    
    if (args.length == 1){
      inDirName = args(0)
      outDirName = inDirName 
    }
    
    val inFile = inDirName.toFile
    if (inFile.exists){
      val generatedOutFileName = inFile.toString.replace(":","_").replace(JFile.separator,"_")
      
      val file: JFile = new JFile(outDirName)
      val parentPath: String = file.getAbsoluteFile().getParent()

      val outFile = (parentPath + JFile.separator + generatedOutFileName + ".txt").toFile
      
      outFile.clear()
      
      println("\n\nScanning directory: " + inDirName)
      println("Output-file is: " + generatedOutFileName)
      println("Written to directory: " + parentPath)
      
      val sourceExclude = (parentPath + JFile.separator + "allfilesBetterExclude.txt").toFile

      var fileExcludeContent = List.empty[String]
      if (!sourceExclude.isEmpty) {
        println("Exclude-definition file found:\n" + sourceExclude)
        val c = sourceExclude.contentAsString
        if (!c.isEmpty) {
          println("Exclude: " + c)
          fileExcludeContent = (c.trim().replace(JFile.separator,"").split(",")).toList
        }
      }
      
      val sourceExtensions = (parentPath + JFile.separator + "allfilesBetterExtensions.txt").toFile
      var fileExtensionsContent = "txt,bat,ssc,sc,scala,java,php,css,js,ahk,md,conf,ini,sql,c,cpp,py,vbs"
      if (!sourceExtensions.isEmpty) {
        println("Extensions-definition file found:\n" + sourceExtensions)
        val c = sourceExtensions.contentAsString
        if (!c.isEmpty) {
          println("Extensions: " + c)
          fileExtensionsContent = c.trim()
        }
      }
      val d = inFile.glob("**/*.{" + fileExtensionsContent + "}", includePath = false)

      val prepend = "* file:///"
      d.foreach (x => {
        val filePath = x.toString
        if (fileExcludeContent.foldLeft(false)(_ || filePath.contains(_))){
          println("Jumpover: " + filePath)
        } else {
          val l = filePath.length + prepend.length
          outFile.appendLines("/" + times('*',l + 3))
          outFile.appendLines("* " + filePath)
          outFile.appendLines(prepend + filePath)
          outFile.appendLines(times('*',l + 3) + "/")
          
          var cSet = "UTF-8"
          var r = ""
          r = (util.Try{x.contentAsString(charset = Charset.forName(cSet))}) getOrElse ""
          if (r == ""){
            cSet = "ISO-8859-1"
            r = (util.Try{x.contentAsString(charset = Charset.forName(cSet))}) getOrElse ""
          }
            
            // TODO UTF-16BE UTF-16LE UTF-16
            
          if (r == ""){
            outFile.append(s"\nCould not read file: $filePath!\n")
          } else {
            outFile.append(x.contentAsString(charset = Charset.forName("UTF-8"))) // better UTF-16
            outFile.append("\n")
          }
          print(".")
        }
      })
      outFile.appendLine()
      outFile.appendLine()
    } else {
      println("\n\nERROR, reading the directory: " + inDirName + " failed!\n\n")
    }
    
    println("\n\n" + appname + " " + version + " finished!")
    Thread.sleep(2000)
  }
}




