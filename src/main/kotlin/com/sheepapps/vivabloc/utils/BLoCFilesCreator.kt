package com.sheepapps.vivabloc.utils

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiDirectory
import com.sheepapps.vivabloc.models.BLoC

interface BLoCFilesCreator {

    fun createFiles(name: String, componentName: String)
}

class BLoCFilesCreatorImpl(private val project: Project,
                           private val directory: PsiDirectory) : BLoCFilesCreator {

    private val projectName = FlutterProject.readProjectName(project)
        ?: throw IllegalStateException("Cannot find Flutter project name")

    override fun createFiles(name: String, componentName: String) {

        val bloc = BLoC.build(name, componentName, projectName)

        if (directory.findSubdirectory(bloc.name) != null) {
            Messages.showErrorDialog("A bloc with the same name already exists", "Viva BLoC")
            return
        }

        WriteCommandAction.runWriteCommandAction(project) {
            val blocDirectory = directory.createSubdirectory(bloc.name)
            TemplateBuilder.build(bloc, project, blocDirectory)
        }
    }
}