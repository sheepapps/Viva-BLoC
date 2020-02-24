package data.repository

import com.intellij.openapi.project.Project
import data.component.VivaBLoCComponent
import model.Settings

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