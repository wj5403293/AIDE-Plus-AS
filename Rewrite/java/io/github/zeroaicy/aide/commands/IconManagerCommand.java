package io.github.zeroaicy.aide.commands;

import android.content.Context;
import android.content.Intent;

import com.aide.ui.ServiceContainer;
import com.aide.ui.command.FileBrowserCommand;
import com.aide.ui.project.internal.GradleTools;
import com.aide.ui.rewrite.R;
import com.topjohnwu.superuser.io.SuFile;

import io.github.zeroaicy.aide.activity.ResourceManagerActivity;
import io.github.zeroaicy.aide.preference.ZeroAicySetting;
import io.github.zeroaicy.util.ContextUtil;

public class IconManagerCommand implements FileBrowserCommand {
    @Override
    public int getIconId() {
        return R.drawable.ic_resource_manager_24px;
    }

    @Override
    public int getNameId() {
        return R.string.command_files_icon_manager;
    }

    @Override
    public boolean isVisible(boolean b) {
        String currentDir = ServiceContainer.getFileBrowserService().j6();
        String currentAppHome = ZeroAicySetting.getCurrentAppHome();

        String resDir = GradleTools.yS(currentAppHome);
        SuFile resFile = new SuFile(resDir);
        SuFile currentFile = new SuFile(currentDir);


        if (!resFile.exists() || !resFile.isDirectory()) {
            return false;
        }
        return currentFile.equals(resFile);
    }

    @Override
    public boolean run() {
        try {
            Context context = ContextUtil.getContext();
            Intent intent = new Intent(context, ResourceManagerActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }



    }
}
