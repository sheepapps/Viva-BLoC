package com.sheepapps.vivabloc.models

import java.io.Serializable

private const val DEFAULT_COMPONENT_NAME = "Page"
private const val DEFAULT_INJECTOR_FULL_PATH = "my_app/framework/di/injector.dart"

data class Settings(var defaultComponentName: String = DEFAULT_COMPONENT_NAME,
                   var defaultInjectorFullPath: String = DEFAULT_INJECTOR_FULL_PATH) : Serializable