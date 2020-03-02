package com.sheepapps.vivabloc.data.repository

import com.intellij.openapi.project.Project
import com.sheepapps.vivabloc.data.component.VivaBLoCComponent
import com.sheepapps.vivabloc.models.Settings

interface SettingsRepository {
    fun loadSettings(): Settings
    fun update(settings: Settings)
}

class SettingsRepositoryImpl(private val project: Project) : SettingsRepository {

    override fun loadSettings() = VivaBLoCComponent.getInstance(project).settings

    override fun update(settings: Settings) = VivaBLoCComponent.getInstance(project).run {
        this.settings = settings
    }
}