package com.sheepapps.vivabloc.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.psi.PsiDirectory
import com.sheepapps.vivabloc.utils.FlutterProject
import com.sheepapps.vivabloc.ui.newbloc.NewBLoCDialog

class NewBLoCAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project
            ?: throw IllegalStateException("Cannot find project")

        val directory = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory

        NewBLoCDialog(project, directory).show()
    }
}