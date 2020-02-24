package util

import javax.swing.JTextField
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

fun JTextField.addTextChangeListener(onChange: (String) -> Unit) =
    object : DocumentListener {
        override fun changedUpdate(e: DocumentEvent?) = onChange(text)
        override fun insertUpdate(e: DocumentEvent?) = onChange(text)
        override fun removeUpdate(e: DocumentEvent?) = onChange(text)
    }.apply { document.addDocumentListener(this) }

fun String.toSnakeCase() = replace(Regex("([^_A-Z])([A-Z])"), "$1_$2").toLowerCase()