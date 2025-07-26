package MultiThreading;
class Person extends Thread
{
    @Override
    public void run()
    {
        System.out.println("This is person thread");
        try {
            Thread.sleep(2000); // it will stop the thread for given time
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Student implements Runnable
{
    @Override
    public void run() {
        System.out.println("This is student thread");
        Thread.yield(); // This method gives hint that you can give chance to run other thread
    }
}

public class MyThread {

    public static void main(String[] args) throws InterruptedException {

        Person th1 = new Person();
        th1.start();

        Student st = new Student();

        Thread th2 = new Thread(st);
        th2.start();// It will start thread and goes to runnable state
        th1.join(); // Main thread iss(th1) thread ke khatam hone tak wait karega aur jab yah terminate ho jayega tab main fir se chalega
        th2.setName("Ranjan Th");
        th2.setPriority(2); // Range: 1 - 10
        th2.interrupt(); // Jo bhi kar rhe ho sleep ya wait ya kuchh bhi usko interrupt kar dega
        th2.setDaemon(true); // Daemon thread background me run hota hai aur jab main thread terminate hota hai to ye bhi terminate hota hai. Ex - Garbage Collector of JVM

    }
}
