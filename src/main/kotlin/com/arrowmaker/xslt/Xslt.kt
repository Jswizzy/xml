package com.arrowmaker.xslt

import javax.xml.transform.Source
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamSource

/**
 * Class for doing com.com.com.arrowmaker.xslt.Xslt transformations
 */
object Xslt {
    val factory = TransformerFactory.newInstance()

    fun build(xsl: Source): Transformer {
        return factory.newTransformer(xsl)
    }

    fun build(xsl: String): Transformer {
        val streamSource = StreamSource(xsl)
        return build(streamSource)
    }
}