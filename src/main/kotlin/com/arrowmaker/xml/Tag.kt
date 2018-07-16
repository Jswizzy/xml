package com.arrowmaker.xml


abstract class Tag(val name: String, attributes: Map<String, String> = emptyMap()) : Element, AttributeTag(attributes) {
    val children = arrayListOf<Element>()

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit = {}): T {
        tag.init()
        children.add(tag)
        return tag
    }

    protected fun <T: Element> removeTagsOfType(tag: T): Boolean = children.removeIf { tag.javaClass.simpleName == it.javaClass.simpleName }

    override fun render(builder: StringBuilder) {
        builder.append("<$name${renderAttributes()}>")
        for (c in children) {
            c.render(builder)
        }
        builder.append("</$name>")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder)
        return builder.toString()
    }
}