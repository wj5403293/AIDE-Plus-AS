package io.github.zeroaicy.aide.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aide.ui.rewrite.databinding.ActivityResourceManagerBinding
import io.github.zeroaicy.aide.base.BaseAppActivity

/**
 * @author: 罪慾
 * @github: https://github.com/neu233/
 * @mail: 3115093767@qq.com
 * @createTime: 2025/6/22
 */


class ResourceManagerActivity : BaseAppActivity<ActivityResourceManagerBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
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
        }


    }
}