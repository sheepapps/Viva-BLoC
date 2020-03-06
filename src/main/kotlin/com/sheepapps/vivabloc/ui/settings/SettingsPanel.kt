package com.sheepapps.vivabloc.ui.settings

import com.intellij.ui.IdeBorderFactory
import com.intellij.ui.components.labels.LinkLabel
import java.awt.*
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class SettingsPanel() : JPanel() {

    val componentNameTextField = JTextField()
    val injectorFullPathTextField = JTextField()

    private lateinit var defaultSettingsPanel: JPanel

    init {
        layout = BorderLayout()
    }

    fun create(onHelpClick: () -> Unit) {
        defaultSettingsPanel = createDefaultSettingsPanel(onHelpClick)
        add(defaultSettingsPanel, BorderLayout.NORTH)
    }

    private fun createDefaultSettingsPanel(onHelpClick: () -> Unit) = JPanel().apply {
        border = IdeBorderFactory.createTitledBorder("Default settings", false)
        layout = GridBagLayout()
        add(JLabel("Component Name:"), constraintsLeft(0, 0))
        add(componentNameTextField, constraintsRight(1, 0))
        add(JLabel("Injector Full Path:"), constraintsLeft(0, 1))
        add(injectorFullPathTextField, constraintsRight(1, 1))
        add(LinkLabel.create("Help", onHelpClick), constraintsHelp(2, 2))
    }

    private fun constraintsLeft(x: Int, y: Int) = GridBagConstraints().apply {
        weightx = 0.15
        gridx = x
        gridy = y
        insets = Insets(0, 8, 0, 0)
        fill = GridBagConstraints.HORIZONTAL
    }

    private fun constraintsRight(x: Int, y: Int) = GridBagConstraints().apply {
        weightx = 0.85
        gridx = x
        gridy = y
        gridwidth = 2
        fill = GridBagConstraints.HORIZONTAL
    }

    private fun constraintsHelp(x: Int, y: Int) = GridBagConstraints().apply {
        weightx = 0.85
        gridx = x
        gridy = y
        gridwidth = 1
        fill = GridBagConstraints.LAST_LINE_END
        anchor = GridBagConstraints.LINE_END
    }
}