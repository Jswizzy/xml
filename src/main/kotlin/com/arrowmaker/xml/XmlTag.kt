package com.arrowmaker.xml

class XmlTag(name: String, attributes: Map<String, String> = mutableMapOf()): TagWithText(name, attributes) {
    fun tag(name: String, attributes: Map<String, String> = emptyMap(), init: XmlTag.() -> Unit = {}) = initTag(XmlTag(name, attributes), init)
    fun emptyTag(name: String, attributes: Map<String, String> = emptyMap(), init: EmptyTag.() -> Unit = {}) = initTag(XmlEmptyTag(name, attributes), init)
}