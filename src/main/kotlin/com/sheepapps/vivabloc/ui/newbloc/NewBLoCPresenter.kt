package com.sheepapps.vivabloc.ui.newbloc

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiDirectory
import com.sheepapps.vivabloc.utils.BLoCFilesCreatorImpl

class NewBLoCPresenter(private val view: NewBLoCView, project: Project, directory: PsiDirectory) {

    private val filesCreator = BLoCFilesCreatorImpl(project, directory)

    fun onOkClick(componentName: String, name: String) {

        if (name.isBlank() || componentName.isBlank()) {
            Messages.showErrorDialog("Please, fill all fields", "Viva BLoC")
            return
        }

        if (!name.matches(Regex("[A-Z][a-zA-Z]+")) ||
            !componentName.matches(Regex("[A-Z][a-zA-Z]+"))) {
            Messages.showErrorDialog("Please, enter values in CamelCase", "Viva BLoC")
            return
        }

        view.close()
        filesCreator.createFiles(name, componentName)
    }
}