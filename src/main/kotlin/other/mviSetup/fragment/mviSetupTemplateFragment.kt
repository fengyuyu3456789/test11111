package other.mviSetup.fragment

import com.android.tools.idea.wizard.template.*

val mviSetupTemplateFragment
    get() = template {
        revision = 3
        name = "Fragment 模版"
        description = "Creates a new Fragment along layout file."
        minApi = 19
        minBuildApi = 19
        category = Category.Other // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry,
                WizardUiContext.NewProject, WizardUiContext.NewModule)

        val packageNameParam = defaultPackageNameParameter
        val entityName = stringParameter {
            name = "Entity Name"
            default = "Main"
            help = "The name of the entity class to create and use in fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "The name of the layout to create for the fragment"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(entityName.value.toLowerCase())}" }
        }

        widgets(
                TextFieldWidget(entityName),
                TextFieldWidget(layoutName),
                PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            mviSetup(
                    data as ModuleTemplateData,
                    packageNameParam.value,
                    entityName.value,
                    layoutName.value
            )
        }
    }

val defaultPackageNameParameter
    get() = stringParameter {
    name = "Package name"
    visible = { !isNewModule }
    default = "com.mycompany.myapp"
    constraints = listOf(Constraint.PACKAGE)
    suggest = { packageName }
}