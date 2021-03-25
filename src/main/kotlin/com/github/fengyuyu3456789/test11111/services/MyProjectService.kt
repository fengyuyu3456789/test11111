package com.github.fengyuyu3456789.test11111.services

import com.github.fengyuyu3456789.test11111.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
