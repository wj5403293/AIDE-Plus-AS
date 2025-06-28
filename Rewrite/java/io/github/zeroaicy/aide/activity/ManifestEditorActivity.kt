package io.github.zeroaicy.aide.activity

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.aide.ui.rewrite.R
import com.aide.ui.rewrite.databinding.ActivityManifestXmlEditorBinding
import com.aide.ui.rewrite.databinding.LayoutManifestEditItemBinding
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import io.github.zeroaicy.aide.base.BaseAppActivity
import io.github.zeroaicy.aide.bean.ManifestEditBean
import io.github.zeroaicy.aide.fragment.ApplicationEditorFragment
import io.github.zeroaicy.util.Log
import java.io.File


/**
 * @author: 罪慾
 * @github: https://github.com/neu233/
 * @mail: 3115093767@qq.com
 * @createTime: 2025/1/18
 */

const val CLICK_THRESHOLD = 200

class ManifestEditorActivity : BaseAppActivity<ActivityManifestXmlEditorBinding>() {

    private val systemResourceTheme = mutableListOf<String>()
    private val systemResourceThemeID = mutableListOf<Int>()

    private var xmlPath: String? = null

    private lateinit var backCallback: OnBackPressedCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        if (intent != null && intent.hasExtra("path")) {
            xmlPath = intent.getStringExtra("path")
            if (xmlPath != null) {
                if (!File(xmlPath!!).exists()) {
                    showNotFoundDialog()
                }
            }
        } else {
            showNotFoundDialog()
            Log.e("XmlEditorActivity", "No path received in Intent!")
        }

        initData()
        ViewCompat.setOnApplyWindowInsetsListener(_binding.root) { view, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val navigationBarHeight =
                insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
            view.setPadding(0, statusBarHeight, 0, navigationBarHeight)
            ViewCompat.onApplyWindowInsets(view, insets)
        }


        setSupportActionBar(_binding.toolbar)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding.apply {
            toolbar.setNavigationOnClickListener {
                finish()
            }

            recyclerView.linear().setup {
                addType<ManifestEditBean>(R.layout.layout_manifest_edit_item)

                onBind {
                    val model = getModel<ManifestEditBean>()
                    val binding = getBinding<LayoutManifestEditItemBinding>()
                    binding.apply {
                        title.setText(model.title)
                        description.setText(model.description)
                        icon.setImageResource(model.icon)
                    }
                }

                onClick(R.id.container){
                    val model = getModel<ManifestEditBean>()
                    showFragment(model.fragment)
                }

            }.models = mutableListOf(
                ManifestEditBean(
                    R.string.manifest_xml_editor_list_application,
                    R.string.manifest_xml_editor_list_application_description,
                    R.drawable.ic_instant_mix_24px,
                    ApplicationEditorFragment()
                ),
                ManifestEditBean(
                    R.string.manifest_xml_editor_list_permissions,
                    R.string.manifest_xml_editor_list_permissions_description,
                    R.drawable.ic_shield_toggle_24px,
                    ApplicationEditorFragment()
                ),
                ManifestEditBean(
                    R.string.manifest_xml_editor_list_activity,
                    R.string.manifest_xml_editor_list_activity_description,
                    R.drawable.ic_integration_instructions_24px,
                    ApplicationEditorFragment()
                ),
                ManifestEditBean(
                    R.string.manifest_xml_editor_list_components,
                    R.string.manifest_xml_editor_list_components_description,
                    R.drawable.ic_dashboard_customize_24px,
                    ApplicationEditorFragment()
                )
            )


        }

        setupBackPressHandler()







    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.apply {
            clear()
        }


        return super.onCreateOptionsMenu(menu)
    }


    private fun setupBackPressHandler() {
        backCallback = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                if (_binding.fragmentContainer.isVisible) {
                    returnToList()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, backCallback)
        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                returnToList()
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        _binding.recyclerView.visibility = View.GONE
        _binding.fragmentContainer.visibility = View.VISIBLE
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun returnToList() {
        _binding.recyclerView.visibility = View.VISIBLE
        _binding.fragmentContainer.visibility = View.GONE
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }


    private fun showNotFoundDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.manifest_xml_editor_alert_dialog_not_found_title)
            .setMessage(R.string.manifest_xml_editor_alert_dialog_not_found_message)
            .setCancelable(false)
            .setNeutralButton(R.string.command_exit, { i, d ->
                finish()
            })
            .create()
            .show()
    }

    private fun initData() {
        /// 初始化系统的主题名
        val systemThemeClass = android.R.style::class.java
        systemThemeClass.fields.forEach { field ->
            if (field.name.startsWith("Theme")) {
                val resID: Int = field.getInt(null)
                val resourceName = resources.getResourceName(resID)
                systemResourceTheme.add("@$resourceName")
                systemResourceThemeID.add(resID)
            }
        }


    }
}