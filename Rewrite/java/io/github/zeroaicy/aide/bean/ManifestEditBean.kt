package io.github.zeroaicy.aide.bean

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.drake.brv.BindingAdapter
import com.drake.brv.item.ItemBind

/**
 * @author: 罪慾
 * @github: https://github.com/neu233/
 * @mail: 3115093767@qq.com
 * @createTime: 2025/6/23
 */


data class ManifestEditBean(
    @param:StringRes
    val title : Int,
    @param:StringRes
    val description : Int,
    @param:DrawableRes
    val icon : Int,
    val fragment: Fragment
) : ItemBind {
    override fun onBind(vh: BindingAdapter.BindingViewHolder) {}
}