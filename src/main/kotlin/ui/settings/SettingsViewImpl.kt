package ui.settings

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import data.repository.SettingsRepositoryImpl
import ui.help.HelpDialog
import util.addTextChangeListener
import javax.swing.JComponent
import javax.swing.event.DocumentListener

class SettingsViewImpl(private val project: Project) : Configurable, SettingsView {

    private var panel: SettingsPanel? = null
    private val presenter = SettingsPresenter(this, SettingsRepositoryImpl(project))
    private var componentNameDocumentListener: DocumentListener? = null
    private var injectorFullPathDocumentListener: DocumentListener? = null

    override fun isModified() = presenter.isModified

    override fun getDisplayName() = "Viva BLoC Plugin"

    override fun apply() = presenter.onApplySettings()

    override fun reset() = presenter.onResetSettings()

    override fun createComponent(): JComponent? {
        panel = SettingsPanel()
        presenter.onLoadView()
        onPanel {
            create(presenter::onHelpClick)
        }
        return panel
    }

    override fun showComponentName(text: String) = onPanel {
        componentNameTextField.text = text
    }

    override fun showInjectorFullPath(text: String) = onPanel {
        injectorFullPathTextField.text = text
    }

    override fun addDefaultSettingsTextChangeListeners() = onPanel {
        componentNameDocumentListener = componentNameTextField.addTextChangeListener(presenter::onComponentNameChange)
        injectorFullPathDocumentListener = injectorFullPathTextField.addTextChangeListener(presenter::onInjectorFullPathChange)
    }

    override fun removeDefaultSettingsTextChangeListeners() = onPanel {
        componentNameDocumentListener?.let { componentNameTextField.document.removeDocumentListener(it) }
        componentNameDocumentListener = null
        injectorFullPathDocumentListener?.let { injectorFullPathTextField.document.removeDocumentListener(it) }
        injectorFullPathDocumentListener = null
    }

    override fun showHelp() = HelpDialog().show()

    private inline fun onPanel(function: SettingsPanel.() -> Unit) = panel?.run { function() } ?: Unit
}