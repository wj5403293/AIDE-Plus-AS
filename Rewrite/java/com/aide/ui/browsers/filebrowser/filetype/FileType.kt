package com.aide.ui.browsers.filebrowser.filetype

import android.graphics.Bitmap


/**
 * @author: 罪慾
 * @github: https://github.com/neu233/
 * @mail: 3115093767@qq.com
 * @createTime: 2025/5/21
 */

interface FileType {
    /**
     * 文件类型
     */
    val fileType: String

    /**
     * 用于文件列表的图标显示
     * */
    val fileIconBitmap: Bitmap
    val fileIconResId: Int

    /**
     * 传入文件名，判断是否为该类型
     * @param fileName String
     * @return Boolean
     */
    fun supportFile(fileName: String): Boolean


    /**
     * 传入文件路径，如不可打开，则调用系统打开该文件
     * @param filePath String
     * @return Boolean
     * */
    fun openFile(filePath: String) : Boolean
}