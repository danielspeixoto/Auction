package util;

import java.util.ArrayList;

public class BackgroundTask {

    private static Thread thread;
    private static ArrayList<Runnable> subscribers = new ArrayList();
    private static ArrayList<Runnable> slowSubscribers = new ArrayList<>();

    static {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        for(int i = 1; i <= 60; i++) {
                            thread.sleep(1000);
                            subscribers.listIterator().forEachRemaining(Runnable::run);
                            if(i == 30) {
                                slowSubscribers.listIterator().forEachRemaining(Runnable::run);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    public static int addSubscriber(Runnable runnable) {
        subscribers.listIterator().add(runnable);
        return subscribers.size() - 1;
    }

    public static int addSlowSubscriber(Runnable runnable) {
        slowSubscribers.listIterator().add(runnable);
        return slowSubscribers.size() - 1;
    }

    public static void removeSubscriber(int backTaskIndex) {
        subscribers.remove(backTaskIndex);
    }
}
