package com.mixiaoxiao.fastscroll.helper;


import androidx.recyclerview.widget.RecyclerView;

/**
 * Listener for manual initiation of a drag.
 */
public interface OnStartDragListener {


    void onStartDrag(RecyclerView.ViewHolder viewHolder);

}
