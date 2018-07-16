package com.arrowmaker.xslt

import java.io.StringWriter
import javax.xml.transform.Result
import javax.xml.transform.Source
import javax.xml.transform.Transformer
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

fun Transformer.transform(source: String, result: Result = StreamResult(System.out)) = transform(StreamSource(source), result)

fun Transformer.transformToString(source: String): String = transformToString(StreamSource(source))

fun Transformer.transformToString(source: Source): String {
    val result = StreamResult(StringWriter())
    this.transform(source, result)
    return result.writer.toString()
}

