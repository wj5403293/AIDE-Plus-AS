@file:Suppress("MISSING_DEPENDENCY_SUPERCLASS_WARNING")

package com.aide.ui.browsers

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.Keep
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.aide.common.KeyStrokeDetector
import com.aide.ui.AppCommands
import com.aide.ui.GlobalKeyCommand
import com.aide.ui.QuickActionMenu
import com.aide.ui.ServiceContainer
import com.aide.ui.command.FileBrowserCommand
import com.aide.ui.rewrite.R
import com.aide.ui.rewrite.databinding.*
import com.aide.ui.services.FileBrowserService
import com.aide.ui.util.FileSystem
import com.drake.brv.BindingAdapter
import com.drake.brv.item.ItemBind
import com.drake.brv.utils.bindingAdapter
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.mixiaoxiao.fastscroll.FastScrollRecyclerView
import com.topjohnwu.superuser.io.SuFile
import java.io.File


/**
 * @author: 罪慾
 * @github: https://github.com/neu233/
 * @mail: 3115093767@qq.com
 * @createTime: 2025/5/21
 */

@SuppressLint("ViewConstructor")
class FileBrowser
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int
) : LinearLayoutCompat(
    context, attrs, defStyleAttr
), FileBrowserService.a, a {

    private lateinit var binding: LayoutFilebrowserBinding

    private val WB: QuickActionMenu =
        QuickActionMenu(ServiceContainer.getMainActivity(), R.menu.filebrowser_context_menu)

    @Suppress("MISSING_DEPENDENCY_SUPERCLASS_WARNING")
    private val jw: KeyStrokeDetector.KeyStrokeHandler =
        GlobalKeyCommand(AppCommands.VH()) as KeyStrokeDetector.KeyStrokeHandler

    private val mb: QuickActionMenu = QuickActionMenu(ServiceContainer.getMainActivity(), R.menu.git_context_menu)

    private var fY: View? = null

    init {
        EQ()
    }


    fun initializeViewsAndListeners() {

        setLayoutParams(LinearLayout.LayoutParams(-1, -1))
        val from = LayoutInflater.from(context)

        binding = LayoutFilebrowserBinding.inflate(from, this, true)
        removeAllViews()
        addView(binding.root)
        ServiceContainer.getFileBrowserService().Zo(this)


        binding.apply {
            smartRefresh.setEnableHeaderTranslationContent(true)

            recyclerView.setOnKeyEventListener(object : FastScrollRecyclerView.OnKeyEventListener {
                override fun onKeyDown(i: Int, keyEvent: KeyEvent?): Boolean {
                    return ServiceContainer.getMainActivity().getKeyStrokeDetector().onKeyDown(i, keyEvent, jw)
                }

                override fun onKeyUp(i: Int, keyEvent: KeyEvent?): Boolean {
                    return ServiceContainer.getMainActivity().getKeyStrokeDetector().onKeyUp(i, keyEvent, jw)
                }

            })

            recyclerView.linear().setup {
                addType<ItemHeader>(R.layout.browser_header_new)
                addType<ItemMenu>(R.layout.filebrowser_entry)
                addType<ItemFile>(R.layout.item_filebrowser_entry)
                onBind {
                    when (val model = getModel<Any>()) {
                        is ItemHeader -> {
                           getBinding<BrowserHeaderNewBinding>().apply {
                               browserHeaderBreadcrumb.setupBreadcrumb()
                               browserHeaderIcon.setImageResource(R.drawable.folder_open)
                               browserHeaderMenuButton.setOnClickListener {
                                   ServiceContainer.getFileBrowserService().VH(null)
                                   XL(it, true)
                               }
                            }
                        }

                        is ItemMenu -> {
                            val binding = getBinding<FilebrowserEntryBinding>()

                        }

                        is ItemFile -> {
                            val binding = getBinding<ItemFilebrowserEntryBinding>()

                        }
                    }

                }
            }

            smartRefresh.onRefresh {

                val currentPath = ServiceContainer.getFileBrowserService().j6()


            }.autoRefresh()

            recyclerView.bindingAdapter.run {
                addHeader(ItemHeader(ServiceContainer.getFileBrowserService().j6()), index = 0, animation = false)
            }

        }


    }

    fun gotoDirectory(newPath: String) {
        ServiceContainer.getFileBrowserService().Hw(resolveFinalPath(newPath))
    }

    fun resolveFinalPath(initialPath: String): String {
        var path = initialPath
        if (ServiceContainer.getProjectService().isInCurrentProjectDirectory(path)) {
            while (true) {
                val listFiles = FileSystem.listFiles(path)
                val singleFile = listFiles.singleOrNull()
                if (singleFile == null || !FileSystem.notPreProcessorFile(singleFile)) {
                    break
                }
                path = singleFile
            }
        }
        return path
    }
    fun RecyclerView.setupBreadcrumb(){
        linear(RecyclerView.HORIZONTAL).setup {
            addType<BreadcrumbItem>(R.layout.item_breadcrumb)
            onBind {
                getBinding<ItemBreadcrumbBinding>().apply {
                    val model = getModel<BreadcrumbItem>()
                    text.text = model.name
                    divider.visibility = if (modelPosition == this@setup._data?.size) GONE else VISIBLE
                }
            }
        }.models = createList(ServiceContainer.getFileBrowserService().j6())
        bindingAdapter._data?.let { scrollToPosition(it.size - 1) }
    }

    fun createList(fullPath: String?): List<BreadcrumbItem> {
        if (fullPath.isNullOrEmpty()) return emptyList()

        var currentPath = ""
        return fullPath.trimStart('/').split('/').map { segment ->
            currentPath += "/$segment"
            BreadcrumbItem(segment, currentPath)
        }
    }



    fun refreshFileList() {
        binding.smartRefresh.autoRefresh()
    }

    fun listRequestFocus() {
        binding.recyclerView.requestFocus()
    }

    fun XL(view: View?, z: Boolean) {
        this.WB.QX(view, z)
    }

    private fun aM(view: View?) {
        this.mb.QX(view, true)
    }


    @Keep /* 外部请求使用了该api */
    fun Ws() {
        aM(this.fY)
    }

    @Keep /* 外部请求使用了该api */
    fun QX() {
        refreshFileList()
    }

    @Keep /* 显示pop menu用的 */
    fun J0() {
        /*val selectedItem: Any? = getListView().getSelectedItem()
        if (selectedItem is FileBrowser1.Data) {
            Mr(selectedItem)
            XL(getListView().getSelectedView(), false)
        }*/
    }

    fun EQ() {
        initializeViewsAndListeners()
    }

    override fun DW() {
        listRequestFocus()
    }

    override fun FH() {
    }

    override fun j6() {
        QX()
    }

    override fun onKeyDown(i: Int, keyEvent: KeyEvent?): Boolean {
        if (ServiceContainer.getMainActivity().getKeyStrokeDetector().onKeyDown(i, keyEvent, jw)) {
            return true
        }
        return super.onKeyDown(i, keyEvent)
    }

    override fun onKeyUp(i: Int, keyEvent: KeyEvent?): Boolean {
        if (ServiceContainer.getMainActivity().getKeyStrokeDetector().onKeyUp(i, keyEvent, jw)) {
            return true
        }
        return super.onKeyUp(i, keyEvent)
    }
}

data class BreadcrumbItem(
    val name: String = "/",
    val fullPath: String = "/"
) : ItemBind {
    override fun onBind(vh: BindingAdapter.BindingViewHolder) {}
}

@SuppressLint("UseCompatLoadingForDrawables")
data class ItemFile(
    val context: Context,
    val path: String = "/",
    var title: String = "/",
    var isZip: Boolean = FileSystem.KD(path),
    var isDirectory: Boolean = SuFile(path).isDirectory,
    var isHidden: Boolean = isSpecialDir(SuFile(path)),
    var icon: Bitmap = context.getDrawable(R.drawable.folder)!!.toBitmap(),
    var smallIcon: Bitmap? = null
) : ItemBind {
    override fun onBind(vh: BindingAdapter.BindingViewHolder) {}
}

data class ItemMenu(
    val context: Context,
    val fileBrowserCommand: FileBrowserCommand,
    val title: String = context.getString(fileBrowserCommand.nameId),
    val iconId: Int = fileBrowserCommand.iconId
) : ItemBind {
    override fun onBind(vh: BindingAdapter.BindingViewHolder) {}
}

data class ItemHeader(
    var fullPath: String = "",
) : ItemBind {
    override fun onBind(vh: BindingAdapter.BindingViewHolder) {}
}


fun isCommonDirectory(name: String): Boolean {
    return name.startsWith(".") || name == "bin" || name == "obj" || name == "build" || name == "gradle"
}


fun isSpecialDir(file: File): Boolean {
    val name = file.name
    val parent = file.parentFile ?: return false

    return when (name) {
        "bin" -> {
            val grandParent = parent.parentFile
            File(parent, ".classpath").exists() || File(parent, "AndroidManifest.xml").exists() || File(
                grandParent, "build.gradle"
            ).exists() || File(grandParent, "build.gradle.kts").exists()
        }

        "obj" -> File(parent, "AndroidManifest.xml").exists()
        "build" -> File(parent, "build.gradle").exists() || File(parent, "build.gradle.kts").exists()
        else -> false
    }
}
