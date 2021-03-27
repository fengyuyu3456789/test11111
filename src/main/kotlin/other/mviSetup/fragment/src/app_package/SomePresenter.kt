package other.mviSetup.fragment.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun somePresenter(
        packageName: String,
        entityName: String,
        layoutName: String,
        projectData: ProjectTemplateData
) = """package $packageName.mvp.presenter

import com.jess.arms.di.scope.FragmentScope
import android.content.Intent
import javax.inject.Inject
import com.hlw.movie.common.base.HLWBasePresenter
import ${packageName}.mvp.contract.${entityName}Contract

@FragmentScope
class ${entityName}Presenter
@Inject
constructor(model: ${entityName}Contract.Model, rootView: ${entityName}Contract.View) :
HLWBasePresenter<${entityName}Contract.Model, ${entityName}Contract.View>(model,rootView) {

    override fun init(dataBundle: Bundle?) {
        super.init(dataBundle)
    }
}
"""