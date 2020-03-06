package com.sheepapps.vivabloc.models

enum class Variable(val value: String, val description: String) {
    COMPONENT_NAME("%componentName%", "Component's name, e.g. Page, Screen or Fragment"),
    INJECTOR_FULL_PATH("%injectorFullPath%", "Injector file full path, e.g. my_app/framework/di/injector.dart")
}