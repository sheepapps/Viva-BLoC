package com.sheepapps.vivabloc.utils

import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.sheepapps.vivabloc.models.BLoC

object TemplateBuilder {

    enum class Template {
        Screen, Bloc, Extras
    }

    private object Properties {
        const val Name = "NAME"
        const val ProjectName = "PROJECT_NAME"
        const val ClassName = "CLASS_NAME"
    }

    fun build(bloc: BLoC, project: Project, destinationDirectory: PsiDirectory) {
        val manager = FileTemplateManager.getInstance(project)
        val properties = buildProperties(manager.defaultProperties, bloc)

        mapTemplates(bloc).forEach { template ->
            val fileTemplate = manager.getInternalTemplate(template.key.name.toLowerCase())
            FileTemplateUtil.createFromTemplate(fileTemplate, template.value, properties, destinationDirectory)
        }
    }

    private fun mapTemplates(bloc: BLoC) = Template.values().associate {
        when (it) {
            Template.Screen -> Pair(it, bloc.screenFilename)
            Template.Extras -> Pair(it, bloc.extrasFilename)
            Template.Bloc -> Pair(it, bloc.blocFilename)
        }
    }

    private fun buildProperties(properties: java.util.Properties, bloc: BLoC) = properties.apply {
        put(Properties.Name, bloc.name)
        put(Properties.ProjectName, bloc.projectName)
        put(Properties.ClassName, bloc.className)
    }
}