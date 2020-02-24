package ui.settings

import data.repository.SettingsRepository
import model.Settings

class SettingsPresenter(private val view: SettingsView,
                        private val settingsRepository: SettingsRepository) {

    var isModified = false
    lateinit var initialSettings: Settings
    lateinit var currentComponentName: String
    lateinit var currentInjectorFullPath: String

    fun onLoadView() {
        initialSettings = settingsRepository.loadSettings()
        resetToInitialSettings()
        view.showComponentName(currentComponentName)
        view.showInjectorFullPath(currentInjectorFullPath)
        view.addDefaultSettingsTextChangeListeners()
    }

    private fun resetToInitialSettings() {
        currentComponentName = initialSettings.defaultComponentName
        currentInjectorFullPath = initialSettings.defaultInjectorFullPath
    }

    fun onApplySettings() {
        initialSettings = Settings(currentComponentName, currentInjectorFullPath)
        resetToInitialSettings()
        settingsRepository.update(initialSettings)
        isModified = false
    }

    fun onResetSettings() {
        resetToInitialSettings()
        view.removeDefaultSettingsTextChangeListeners()
        view.showComponentName(currentComponentName)
        view.showInjectorFullPath(currentInjectorFullPath)
        view.addDefaultSettingsTextChangeListeners()
        isModified = false
    }

    fun onComponentNameChange(text: String) {
        currentComponentName = text
        isModified = true
    }

    fun onInjectorFullPathChange(text: String) {
        currentInjectorFullPath = text
        isModified = true
    }

    fun onHelpClick() = view.showHelp()
}