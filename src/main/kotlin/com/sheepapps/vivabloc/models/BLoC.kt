package com.sheepapps.vivabloc.models

import com.sheepapps.vivabloc.utils.toSnakeCase

data class BLoC(
    val name: String,
    val className: String,
    val componentName: String,
    val projectName: String,
    val screenFilename: String,
    val blocFilename: String,
    val extrasFilename: String
) {

    companion object {
        fun build(name: String, componentName: String, projectName: String): BLoC {
            val nameSnakeCase = name.toSnakeCase()
            val component = componentName.toLowerCase()
            return BLoC(
                nameSnakeCase,
                name,
                componentName,
                projectName,
                "${nameSnakeCase}_${component}.dart",
                "${nameSnakeCase}_bloc.dart",
                "${nameSnakeCase}_extras.dart"
            )
        }
    }
}