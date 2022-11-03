package com.github.quanuanc.lcrun.action;

import com.github.quanuanc.lcrun.notify.Notifier;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * 3sum
 */
public class GetCode extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        Document document = Objects.requireNonNull(e.getData(CommonDataKeys.EDITOR)).getDocument();
        String titleSlug = setupClassHeader(project, document);
        if (titleSlug != null)
            Notifier.notify(project, "leetcode: " + titleSlug);
    }

    /**
     * setup class header according class comment, then find title slug from comment and return
     *
     * @param project  project
     * @param document document to be setup
     * @return titleSlug
     */
    private String setupClassHeader(Project project, Document document) {
        String source = document.getText();
        String[] split = source.split("\n");
        int commentLine = 0;
        String titleSlug = null;
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith("//")) {
                commentLine = i;
                if (split[i].length() > 2)
                    titleSlug = split[i].substring(2).trim();
                break;
            }
        }
        int start = document.getLineStartOffset(commentLine);
        int end = document.getLineEndOffset(commentLine);
        WriteCommandAction.runWriteCommandAction(project, () ->
                document.replaceString(start, end, "/** \n * hello world \n */")
        );
        return titleSlug;
    }
}
