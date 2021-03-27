package other.mviSetup.activity.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun someModel(
        packageName: String,
        entityName: String,
        layoutName: String,
        projectData: ProjectTemplateData
) = """package $packageName.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.hlw.movie.common.model.HBaseModel
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject
import ${packageName}.mvp.contract.${entityName}Contract

@ActivityScope
class ${entityName}Model
@Inject
constructor(repositoryManager: IRepositoryManager) : HBaseModel(repositoryManager), ${entityName}Contract.Model{
    @Inject
    lateinit var mGson:Gson
    @Inject
    lateinit var mApplication:Application

    override fun onDestroy() {
          super.onDestroy()
    }
}
"""