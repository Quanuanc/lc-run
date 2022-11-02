package com.github.quanuanc.lcrun.group;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LeetCodeGroup extends ActionGroup {

    @Override
    public AnAction @NotNull [] getChildren(@Nullable AnActionEvent e) {
        ActionManager manager = ActionManager.getInstance();
        return new AnAction[]{
                manager.getAction("LCRun.GetCode"),
                manager.getAction("LCRun.RunCode"),
                manager.getAction("LCRun.Submit")
        };
    }
}
