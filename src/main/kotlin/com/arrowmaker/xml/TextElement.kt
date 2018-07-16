package com.arrowmaker.xml


class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder) {
        builder.append(text)
    }
}