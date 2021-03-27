package other.mviSetup.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.steewsc.mvisetup.listeners.MyProjectManagerListener.Companion.projectInstance
import other.mviSetup.activity.src.app_package.*
import java.io.File

fun RecipeExecutor.mviSetup(
        moduleData: ModuleTemplateData,
        packageName: String,
        entityName: String,
        layoutName: String
) {
    val (projectData,srcOut, resOut) = moduleData
    val project = projectInstance ?: return
//    addAllKotlinDependencies(moduleData)
    val activityClass = "${entityName}Activity"
    val activityPresenter = "${entityName}Presenter"
    val activityContract = "${entityName}Contract"
    val activityModel = "${entityName}Model"
    val activityModule = "${entityName}Module"
    val activityComponent = "${entityName}Component"
    val activityTitle = "$entityName Activity"
    // This will generate new manifest (with activity) to merge it with existing
    generateManifest(moduleData, "mvp.ui.activity.$activityClass", activityTitle, packageName,
            isLauncher = false, hasNoActionBar = false, generateActivityTitle = false)
    val ktOrJavaExt = projectData.language.extension

    var srcOutActivity = srcOut.path+"/mvp/ui/activity"
    save(someActivity(packageName, entityName, layoutName, projectData), File(srcOutActivity).resolve("${activityClass}.${ktOrJavaExt}"))
    var srcOutPresenter = srcOut.path+"/mvp/presenter"
    save(somePresenter(packageName, entityName, layoutName, projectData), File(srcOutPresenter).resolve("${activityPresenter}.${ktOrJavaExt}"))
    var srcOutContract = srcOut.path+"/mvp/contract"
    save(someContract(packageName, entityName, layoutName, projectData), File(srcOutContract).resolve("${activityContract}.${ktOrJavaExt}"))
    var srcOutModel = srcOut.path+"/mvp/model"
    save(someModel(packageName, entityName, layoutName, projectData), File(srcOutModel).resolve("${activityModel}.${ktOrJavaExt}"))
    var srcOutModule = srcOut.path+"/di/module"
    save(someModule(packageName, entityName, layoutName, projectData), File(srcOutModule).resolve("${activityModule}.${ktOrJavaExt}"))
    var srcOutComponent = srcOut.path+"/di/component"
    save(someComponent(packageName, entityName, layoutName, projectData), File(srcOutComponent).resolve("${activityComponent}.${ktOrJavaExt}"))

    save(someActivityLayout(packageName, entityName), resOut.resolve("layout/${layoutName}.xml"))
}
