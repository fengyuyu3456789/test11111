package other.mviSetup.activity.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun someComponent(
        packageName: String,
        entityName: String,
        layoutName: String,
        projectData: ProjectTemplateData
) = """package $packageName.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import ${packageName}.di.module.${entityName}Module
import com.jess.arms.di.scope.ActivityScope
import ${packageName}.mvp.ui.activity.${entityName}Activity

@ActivityScope
@Component(modules = arrayOf(${entityName}Module::class),dependencies = arrayOf(AppComponent::class))
interface ${entityName}Component {
    fun inject(activity:${entityName}Activity)
}
"""