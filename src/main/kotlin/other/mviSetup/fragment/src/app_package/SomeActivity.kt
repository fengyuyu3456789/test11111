package other.mviSetup.fragment.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun someActivity(
        packageName: String,
        entityName: String,
        layoutName: String,
        projectData: ProjectTemplateData
) = """package $packageName.mvp.ui.fragment

import com.hlw.movie.common.base.HLWBaseFragment
import com.jess.arms.di.component.AppComponent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ${packageName}.di.component.Dagger${entityName}Component
import ${packageName}.di.module.${entityName}Module
import ${packageName}.mvp.contract.${entityName}Contract
import ${packageName}.mvp.presenter.${entityName}Presenter

import ${packageName}.R

class ${entityName}Fragment : HLWBaseFragment<${entityName}Presenter>() , ${entityName}Contract.View {

    override fun setupFragmentComponent(appComponent:AppComponent) {
        Dagger${entityName}Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .${entityName[0].toLowerCase()}${entityName.subSequence(1,entityName.length)}Module(${entityName}Module(this))
                .build()
                .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.${layoutName}, container, false);
    }
   
    override fun initTitleBarView(){
    }
    
    override fun setData(data: Any?) {
    }
}

"""