package com.sheepapps.vivabloc.ui.newbloc

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.psi.PsiDirectory
import javax.swing.JComponent

class NewBLoCDialog(project: Project, directory: PsiDirectory) : DialogWrapper(true), NewBLoCView {

    private val panel = NewScreenPanel()

    private val presenter: NewBLoCPresenter = NewBLoCPresenter(this, project, directory)

    init {
        this.title = "Create BLoC Template"
        init()
    }

    override fun doOKAction() =
        presenter.onOkClick(
            panel.componentNameTextField.text,
            panel.nameTextField.text)

    override fun createCenterPanel(): JComponent {
        presenter.onLoadView()
        return panel
    }

    override fun showComponentName(componentName: String) {
        panel.componentNameTextField.text = componentName
    }

    override fun close() = close(OK_EXIT_CODE)
}