package com.arrowmaker.xml


abstract class EmptyTag(val name: String, attributes: Map<String, String> = emptyMap()) : Element, AttributeTag(attributes) {

    override fun render(builder: StringBuilder) {
        builder.append("<$name${renderAttributes()}/>")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder)
        return builder.toString()
    }
}