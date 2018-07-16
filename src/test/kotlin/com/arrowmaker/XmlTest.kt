package com.arrowmaker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.arrowmaker.xml.XML


class XmlTest {

    @Test
    fun `xml declaration`() {
        val declaration = """<?document version='1.0' standalone='yes'?>"""

        XML.document(declaration).also {
            assertEquals(declaration, "$it")
        }
    }

    @Test
    fun `empty element`() {
        XML.document {
            emptyTag("empty") {
                attributes["empty"] = "0"
            }
        }.also {
            assertEquals("""<empty empty="0"/>""", "$it")
        }
    }

    @Test
    fun `empty element with attributes`() {
        XML.document {
            tag("outer") {
                emptyTag("empty", mapOf("one" to "one")) {
                    attributes["two"] = "two"
                }
            }
        }.also {
            assertEquals("""<outer><empty one="one" two="two"/></outer>""", "$it")
        }
    }

    @Test
    fun element() {
        XML.document {
            tag("single") {
                +"hello"
            }
        }.also {
            assertEquals("""<single>hello</single>""", "$it")
        }
    }

    @Test
    fun `element with Attributes`() {
        XML.document {
            tag("one", mapOf("one" to "one")) {
                attributes["two"] = "two"
                tag("two", mapOf("one" to "one")) {
                    attributes["two"] = "two"
                }
            }
        }.also {
            assertEquals("""<one one="one" two="two"><two one="one" two="two"></two></one>""", "$it")
        }
    }

    @Test
    fun `nest element with Attributes`() {
        XML.document {
            tag("one") {
                tag("two", mapOf("one" to "one")) {
                    attributes["two"] = "two"
                }
            }
        }.also {
            assertEquals("""<one><two one="one" two="two"></two></one>""", "$it")
        }
    }

    @Test
    fun `string builder property`() {

        XML.document {
            val a = stringBuilder
            tag("one")
            emptyTag("two")
            assertEquals("""<one></one><two/>""", "$a")
        }
    }
}

