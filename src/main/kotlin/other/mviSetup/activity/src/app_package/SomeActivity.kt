package other.mviSetup.activity.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun someActivity(
        packageName: String,
        entityName: String,
        layoutName: String,
        projectData: ProjectTemplateData
) = """package $packageName.mvp.ui.activity

import com.hlw.movie.common.base.HLWBaseActivity
import com.jess.arms.di.component.AppComponent

import ${packageName}.di.component.Dagger${entityName}Component
import ${packageName}.di.module.${entityName}Module
import ${packageName}.mvp.contract.${entityName}Contract
import ${packageName}.mvp.presenter.${entityName}Presenter

import ${packageName}.R

class ${entityName}Activity : HLWBaseActivity<${entityName}Presenter>() , ${entityName}Contract.View {

    override fun setupActivityComponent(appComponent:AppComponent) {
        Dagger${entityName}Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .${entityName[0].toLowerCase()}${entityName.subSequence(1,entityName.length)}Module(${entityName}Module(this))
                .build()
                .inject(this)
    }


    override fun getLayoutId():Int {
              return R.layout.${layoutName} //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }
    
    override fun initTitleBarView(){

    }
    
    override fun initWidget(){
        super.initWidget()
    }

    override fun killMyself() {
        finish()
    }
}

"""