package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.mviSetup.activity.mviSetupTemplateActivity
import other.mviSetup.fragment.mviSetupTemplateFragment

class WizardTemplateProviderImpl  : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
            mviSetupTemplateActivity,
            mviSetupTemplateFragment)
}
