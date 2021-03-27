package other.mviSetup.fragment.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun someModule(
        packageName: String,
        entityName: String,
        layoutName: String,
        projectData: ProjectTemplateData
) = """package $packageName.di.module

import com.jess.arms.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

import ${packageName}.mvp.contract.${entityName}Contract
import ${packageName}.mvp.model.${entityName}Model


@Module
class ${entityName}Module(private val view:${entityName}Contract.View) {
@FragmentScope
@Provides
    fun provide${entityName}View():${entityName}Contract.View{
        return this.view
    }
    @ActivityScope
    @Provides
    fun provide${entityName}Model(model:${entityName}Model):${entityName}Contract.Model{
        return model
    }
}
"""