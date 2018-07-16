package com.arrowmaker.xml


@XmlTagMarker
abstract class AttributeTag(attributes: Map<String, String>) : Element {
    val attributes  = attributes.toMutableMap()

    protected fun renderAttributes(): String {
        val builder = StringBuilder()
        for ((attr, value) in attributes) {
            builder.append(" $attr=\"$value\"")
        }
        return builder.toString()
    }
}