package com.sheepapps.vivabloc.data.component

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil
import com.sheepapps.vivabloc.models.Settings
import java.io.Serializable

@State(name = "VivaBLoCConfiguration",
    storages = [Storage(value = "vivaBLoCConfiguration.xml")])
class VivaBLoCComponent : Serializable, PersistentStateComponent<VivaBLoCComponent> {

    companion object {
        fun getInstance(project: Project) = ServiceManager.getService(project, VivaBLoCComponent::class.java)
    }

    var settings: Settings = Settings()

    override fun getState(): VivaBLoCComponent = this

    override fun loadState(state: VivaBLoCComponent) {
        XmlSerializerUtil.copyBean(state, this)
    }
}