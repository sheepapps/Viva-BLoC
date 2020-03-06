package com.sheepapps.vivabloc.utils

import javax.swing.JTextField
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import com.google.common.base.CaseFormat

fun JTextField.addTextChangeListener(onChange: (String) -> Unit) =
    object : DocumentListener {
        override fun changedUpdate(e: DocumentEvent?) = onChange(text)
        override fun insertUpdate(e: DocumentEvent?) = onChange(text)
        override fun removeUpdate(e: DocumentEvent?) = onChange(text)
    }.apply { document.addDocumentListener(this) }

fun String.toSnakeCase(): String = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, this)