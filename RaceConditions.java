import java.util.concurrent.locks.*;

public class RaceConditions {
    public static void main(String[] args) {
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();
        Bank bank3 = new Bank();

        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new RaceConditionRunnable(bank1));
        Thread t2 = new Thread(new RaceConditionRunnable(bank1));
        t1.start();
        t2.start();
        try { Thread.sleep(5000); } catch (Exception e) {}
        System.out.println(bank1.getBalance());

        t1 = new Thread(new LockedRunnable(bank2, lock));
        t2 = new Thread(new LockedRunnable(bank2, lock));
        t1.start();
        t2.start();
        try { Thread.sleep(5000); } catch (Exception e) {}
        System.out.println(bank2.getBalance());

        t1 = new Thread(new SynchronizedRunnable(bank3));
        t2 = new Thread(new SynchronizedRunnable(bank3));
        t1.start();
        t2.start();
        try { Thread.sleep(5000); } catch (Exception e) {}
        System.out.println(bank3.getBalance());
    }
}

class Bank {
    private double balance;
    public Bank() { this.balance = 0; }

    // overloaded
    public void deposit(double amt) { this.balance += amt; }
    public void deposit(double amt, Lock lock) {
        lock.lock();
        this.balance += amt;
        lock.unlock();
    }
    synchronized public void synchronizedDeposit(double amt) {
        this.balance += amt;
    }
    public double getBalance() { return this.balance; }
}

class RaceConditionRunnable implements Runnable {
    private Bank bank;

    public RaceConditionRunnable(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId());
        for(int i = 0; i < 100000; i++) {
            bank.deposit(1);
        }
    }
}

class LockedRunnable implements Runnable {
    private Bank bank;
    private Lock lock;

    public LockedRunnable(Bank bank, Lock lock) {
        this.bank = bank;
        this.lock = lock;
    }

    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId());
        for(int i = 0; i < 100000; i++) {
            bank.deposit(1, lock);
        }
    }
}

class SynchronizedRunnable implements Runnable {
    private Bank bank;

    public SynchronizedRunnable(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId());
        for(int i = 0; i < 100000; i++) {
            bank.synchronizedDeposit(1);
        }
    }
}