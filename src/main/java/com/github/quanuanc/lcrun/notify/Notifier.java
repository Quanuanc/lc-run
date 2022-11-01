package com.github.quanuanc.lcrun.notify;

import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;

public class Notifier {
    public static void notify(@Nullable Project project, String content) {
        NotificationGroupManager.getInstance()
                .getNotificationGroup("LCRun Notification Group")
                .createNotification(content, NotificationType.INFORMATION)
                .notify(project);
    }
}
