package com.sheepapps.vivabloc.ui.settings

interface SettingsView {
    fun showComponentName(text: String)
    fun showInjectorFullPath(text: String)
    fun addDefaultSettingsTextChangeListeners()
    fun removeDefaultSettingsTextChangeListeners()
    fun showHelp()
}