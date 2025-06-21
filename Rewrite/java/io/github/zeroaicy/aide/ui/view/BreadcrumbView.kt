package io.github.zeroaicy.aide.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aide.ui.rewrite.databinding.ItemBreadcrumbBinding


class BreadcrumbView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val recyclerView: RecyclerView = RecyclerView(context).apply {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        overScrollMode = View.OVER_SCROLL_NEVER
    }
    private val items = mutableListOf<BreadcrumbItem>()
    private var adapter: BreadcrumbAdapter? = null

    init {
        addView(recyclerView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
    }

    fun setPath(path: List<BreadcrumbItem>, onClick: (BreadcrumbItem, Int) -> Unit) {
        items.clear()
        items.addAll(path)
        adapter = BreadcrumbAdapter(items, onClick)
        recyclerView.adapter = adapter
        recyclerView.scrollToPosition(items.size - 1)

    }

    fun setFullPath(fullPath: String, onClick: (BreadcrumbItem, Int) -> Unit) {
        val cleanedPath = fullPath.trim('/')

        val segments = if (cleanedPath.isEmpty()) emptyList() else cleanedPath.split("/")
        val breadcrumbList = mutableListOf<BreadcrumbItem>()
        var currentPath = ""

        for (segment in segments) {
            currentPath += "/$segment"
            breadcrumbList.add(BreadcrumbItem(segment, currentPath))
        }

        setPath(breadcrumbList, onClick)
    }

}


class BreadcrumbAdapter(
    private val items: List<BreadcrumbItem>,
    private val onClick: (BreadcrumbItem, Int) -> Unit
) : RecyclerView.Adapter<BreadcrumbAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBreadcrumbBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBreadcrumbBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.text.text = item.name
        holder.binding.divider.visibility = if (position == items.lastIndex) View.GONE else View.VISIBLE

        holder.binding.text.setOnClickListener {
            onClick(item, position)
        }
    }
}


data class BreadcrumbItem(
    val name: String,
    val fullPath: String
)
