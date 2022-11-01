package com.github.quanuanc.lcrun.group;

import com.github.quanuanc.lcrun.action.GetCode;
import com.github.quanuanc.lcrun.action.RunCode;
import com.github.quanuanc.lcrun.action.Submit;
import com.github.quanuanc.lcrun.icons.LCRunIcons;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LeetCodeGroup extends ActionGroup {

    @Override
    public AnAction @NotNull [] getChildren(@Nullable AnActionEvent e) {
        return new AnAction[]{
                new GetCode("Get Code", "Get code", LCRunIcons.GET_ICON),
                new RunCode("Run Code", "Run code", LCRunIcons.RUN_ICON),
                new Submit("Submit", "Submit code", LCRunIcons.SUBMIT_ICON),
        };
    }
}
