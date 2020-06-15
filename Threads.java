public class Threads {
    public static void main(String[] args) {
        Thread t1 = new SleepThread();
        t1.start();
        try { t1.join(); } catch (Exception e) {}
        Thread t2 = new SleepThread();
        Thread t3 = new Thread(new SleepRunnable());
        t2.start();
        t3.start();
    }
}

class SleepThread extends Thread {
    public void run() {
        System.out.println("Sleeping for 5 seconds...");
        try { Thread.sleep(5000); } catch (Exception e) {}
    }
}

class SleepRunnable implements Runnable {
    public void run() {
        System.out.println("Sleeping for 5 seconds...");
        try { Thread.sleep(5000); } catch (Exception e) {}
    }
}