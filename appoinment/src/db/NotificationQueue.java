package db;

import java.util.LinkedList;
import java.util.Queue;

public class NotificationQueue {
    private static Queue<String> notificationQueue = new LinkedList<>();

    public static void addNotification(String message) {
        notificationQueue.offer(message);
    }

    public static String pollNotification() {
        return notificationQueue.poll();
    }

    public static boolean hasNotifications() {
        return !notificationQueue.isEmpty();
    }
}