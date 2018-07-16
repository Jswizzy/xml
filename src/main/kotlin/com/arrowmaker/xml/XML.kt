package com.arrowmaker.xml


@XmlTagMarker
class XML(declaration: String? = null) {
    val stringBuilder = if (declaration != null) StringBuilder(declaration) else StringBuilder()

    inline fun tag(name: String, attributes: Map<String, String> = emptyMap(), init: XmlTag.() -> Unit = {}) = XmlTag(name, attributes).apply {
        init()
        render(this@XML.stringBuilder)
    }

    inline fun emptyTag(name: String, attributes: Map<String, String> = emptyMap(), init: XmlEmptyTag.() -> Unit = {}) = XmlEmptyTag(name, attributes).apply {
        init()
        render(this@XML.stringBuilder)
    }

    override fun toString(): String {
        return stringBuilder.toString()
    }

    companion object {
        inline fun document(declaration: String? = null, init: XML.() -> Unit = {}): XML =
                XML(declaration).apply {
                    init()
                }
    }
}

