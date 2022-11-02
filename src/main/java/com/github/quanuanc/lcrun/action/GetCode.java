package com.github.quanuanc.lcrun.action;

import com.github.quanuanc.lcrun.notify.Notifier;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class GetCode extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project currentProject = e.getProject();
        Notifier.notify(currentProject, "Get Code");
    }
}
