package com.aide.ui

import android.os.Handler
import android.os.Looper
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import com.aide.engine.SyntaxError
import com.aide.ui.command.MenuCommand
import com.aide.ui.firebase.FireBaseLogEvent
import androidx.core.view.get
import androidx.core.view.size
import com.aide.ui.rewrite.R

class QuickActionMenu(private val DW: MainActivity, private val j6: Int) {
    private var FH: ActionMode? = null
    private var Hw: PopupMenu? = null
    private var v5 = false


    private fun EQ(menuItem: MenuItem): Boolean {
        val itemId = menuItem.itemId
        val iU7 = u7(itemId)
        val menuItemCommandU7 = AppCommands.u7(itemId)
        if (iU7 < 0) {
            if (menuItemCommandU7 == null) {
                return false
            }
            FireBaseLogEvent.tp("Quick Action Menu: " + menuItem.title)
            return menuItemCommandU7.run()
        }
        val syntaxErrorGn = gn()
        if (syntaxErrorGn?.AL == null || syntaxErrorGn.AL.size <= iU7) {
            return true
        }
        ServiceContainer.getMainActivity().delayedShowAnalyzingProgressDialog()
        ServiceContainer.getEngineService().j3(syntaxErrorGn, iU7)
        return true
    }

    private fun J0(menu: Menu): Boolean {
        for (i in 0 until menu.size) {
            val item = menu[i]
            we(item)
            if (item.subMenu != null) {
                J0(item.subMenu!!)
            }
        }
        return true
    }

    private fun gn(): SyntaxError? {
        val currentFileSpan = ServiceContainer.getMainActivity().aideEditorPager.currentFileSpan
        return ServiceContainer.getErrorService().vy(
            currentFileSpan.j6,
            currentFileSpan.DW,
            currentFileSpan.FH,
            currentFileSpan.Hw,
            currentFileSpan.v5
        )
    }

    private fun u7(i: Int): Int {
        return when (i) {
            R.id.editorMenuFix0 -> 0
            R.id.editorMenuFix1 -> 1
            R.id.editorMenuFix2 -> 2
            R.id.editorMenuFix3 -> 3
            R.id.editorMenuFix4 -> 4
            R.id.editorMenuFix5 -> 5
            else -> -1
        }
    }

    private fun we(menuItem: MenuItem) {
        val itemId = menuItem.itemId
        val iU7 = u7(itemId)
        val menuItemCommandU7 = AppCommands.u7(itemId)
        var z = true
        if (itemId == R.id.editorMenuFix) {
            val syntaxErrorGn = gn()
            if (syntaxErrorGn?.AL == null || syntaxErrorGn.AL.isEmpty()) {
                z = false
            }
            menuItem.isVisible = z
            return
        }
        if (iU7 >= 0) {
            val syntaxErrorGn2 = gn()
            if (syntaxErrorGn2?.AL == null || syntaxErrorGn2.AL.size <= iU7) {
                menuItem.isVisible = false
                return
            } else {
                menuItem.title = syntaxErrorGn2.AL[iU7]
                menuItem.isVisible = true
                return
            }
        }
        if (menuItemCommandU7 != null) {
            menuItem.isEnabled = menuItemCommandU7.isEnabled
            if (menuItemCommandU7 is MenuCommand) {
                if (v5) {
                    z = false
                }
                menuItem.isVisible = menuItemCommandU7.isVisible(z)
            }
        }
    }

    fun J8() {
        FH?.invalidate()
    }

    fun QX(view: View, z: Boolean) {
        tp()
        v5 = z
        Hw?.dismiss()
        Handler(Looper.getMainLooper()).post {
            Hw = PopupMenu(DW, view)
            Hw!!.menuInflater.inflate(this@QuickActionMenu.j6, Hw!!.menu)
            this@QuickActionMenu.J0(Hw!!.menu)
            Hw!!.setOnMenuItemClickListener { menuItem ->
                this@QuickActionMenu.EQ(menuItem)
                true
            }
            Hw!!.show()

        }
    }

    fun Ws(z: Boolean) {
        if (FH == null) {
            v5 = z
            FH = DW.startActionMode(object : ActionMode.Callback {
                override fun onActionItemClicked(actionMode: ActionMode, menuItem: MenuItem): Boolean {
                    if (!this@QuickActionMenu.EQ(menuItem)) {
                        return true
                    }
                    actionMode.finish()
                    return true
                }

                override fun onCreateActionMode(actionMode: ActionMode, menu: Menu): Boolean {
                    actionMode.menuInflater.inflate(this@QuickActionMenu.j6, menu)
                    this@QuickActionMenu.J0(menu)
                    return true
                }

                override fun onDestroyActionMode(actionMode: ActionMode) {
                    FH = null
                    DW.oY(false)
                    ServiceContainer.getMainActivity().getAIDEEditorPager().jJ()
                }

                override fun onPrepareActionMode(actionMode: ActionMode, menu: Menu): Boolean {
                    this@QuickActionMenu.J0(menu)
                    return true
                }
            })
            DW.oY(true)
        }
    }

    fun tp() {
        FH?.finish()
        FH = null
    }




}