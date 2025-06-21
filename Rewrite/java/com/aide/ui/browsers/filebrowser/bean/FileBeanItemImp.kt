package com.aide.ui.browsers.filebrowser.bean

import com.aide.ui.browsers.filebrowser.filetype.FileType


/**
 * @author: 罪慾
 * @github: https://github.com/neu233/
 * @mail: 3115093767@qq.com
 * @createTime: 2025/5/21
 */

class FileItemBeanImpl(
    override var fileName: String,
    override var filePath: String,
    var fileType: FileType?,
    val isDir: Boolean,
    var isHide: Boolean,
    var isCurrentOpenFile: Boolean,
) : FileBean