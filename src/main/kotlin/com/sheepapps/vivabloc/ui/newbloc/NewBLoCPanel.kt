package com.sheepapps.vivabloc.ui.newbloc

import java.awt.Dimension
import java.awt.GridLayout
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class NewScreenPanel : JPanel() {

    val nameTextField = JTextField()
    val componentNameTextField = JTextField()

    init {
        layout = GridLayout(0, 2)
        add(JLabel("Name:"))
        add(nameTextField)
        add(JLabel("Component:"))
        add(componentNameTextField)
    }

    override fun getPreferredSize() = Dimension(250, 60)
}
