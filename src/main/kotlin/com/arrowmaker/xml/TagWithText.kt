package com.arrowmaker.xml


abstract class TagWithText(name: String, attributes: Map<String, String> = emptyMap()) : Tag(name, attributes) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}