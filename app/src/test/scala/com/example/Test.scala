package com.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import java.net.URI
import org.scalatest.FunSuite

case class Foo(v: URI)

class Test extends FunSuite {
  test("Something") {
    new ObjectMapper()
      .registerModule(DefaultScalaModule)
      .readValue("""{"v": "http://a.com"}""", classOf[Foo])
  }
}
