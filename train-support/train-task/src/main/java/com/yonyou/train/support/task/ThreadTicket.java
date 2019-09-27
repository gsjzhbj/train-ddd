package com.yonyou.train.support.task;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ThreadTicket {
    public static void main(String[] args) {
        testThread();
    }
    public static void testExecutor(){
//        ExecutorService executorService= Executors.newFixedThreadPool(30);
//        ExecutorService executorService= Executors.newCachedThreadPool();
        ExecutorService executorService= Executors.newScheduledThreadPool(30);
        Booking b1 = new Booking("军人售票口");
        Booking b2 = new Booking("学生售票口");
        Booking b3 = new Booking("老年人售票口");
        Booking b4 = new Booking("网上售票口-004");
        Booking b5 = new Booking("网上售票口-005");
        Booking b6 = new Booking("网上售票口-006");
        Booking b7 = new Booking("网上售票口-007");
        Booking b8 = new Booking("网上售票口-008");
        Booking b9 = new Booking("网上售票口-009");
        Booking B0 = new Booking("网上售票口-B0");
        Booking A0 = new Booking("网上售票口-A0");
        Future<?> future=executorService.submit(b1);
        executorService.submit(b2);
        //future.interrupt();
        executorService.submit(b3);
        executorService.submit(b4);

        executorService.submit(b5);
        executorService.submit(b6);
        executorService.submit(b7);
        executorService.submit(b8);
        executorService.submit(b9);
        executorService.submit(B0);
        executorService.submit(A0);

    }
    public static void testThread(){
        Booking b1 = new Booking("军人售票口");
        Booking b2 = new Booking("学生售票口");
        Booking b3 = new Booking("老年人售票口");
        Booking b4 = new Booking("网上售票口");
        b1.start();
        b2.start();
        b3.start();
        b4.start();
    }
}

/*
 * 多窗口卖票系统。多线程
 * 票数为静态的，共享数据
 * synchronized(对象){}代码块中的内容是加锁的，
 * 即当一个线程在使用时，其他线程不可以进入。
 * 使得共享资源数据的安全。
 */
class Booking extends Thread{
    public  Booking(String name){
        super(name);
    }
//    private static  volatile int ticket = 50;//票数共50张

    private static  volatile AtomicInteger ticket = new AtomicInteger(30);
    Lock lock = new ReentrantLock();// 明锁(死锁）
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
/*
* ReentrantLock根据传入构造方法的布尔型参数实例化出Sync的实现类FairSync和NonfairSync
* ，分别表示公平的Sync和非公平的Sync。
* 由于ReentrantLock我们用的比较多的是非公平锁

ReentrantLock 和synchronized 均为重入锁

*
1. ReenTrantLock可以指定是公平锁还是非公平锁。而synchronized只能是非公平锁。所谓的公平锁就是先等待的线程先获得锁。

2. ReenTrantLock提供了一个Condition（条件）类，用来实现分组唤醒需要唤醒的线程们，而不是像synchronized要么随机唤醒一个线程要么唤醒全部线程。

3. ReenTrantLock提供了一种能够中断等待锁的线程的机制，通过lock.lockInterruptibly()来实现这个机制。

 对ReentrantLock的可重入锁这篇博客使用简单的例子进行讲解，  http://blog.csdn.net/yanyan19880509/article/details/52345422

     * Lock是个接口，只能实例化它的子类
     * 明锁适合高并发，上万
     * 暗锁适合并发率不高时，效率高
     */

    //重写run方法，
    public void run(){
        while(ticket.get()>0){
            synchronized (Booking.class) {
                    if (ticket.get()>0) {
                        System.out.println(super.getName()+"窗口---->卖出的车票号No."+ticket);
                        ticket.decrementAndGet();
                    }else {
                        System.out.println(super.getName()+"票已售罄！！!");
                    }
                 try {
                    sleep(100);//睡100毫秒，抛出多线程异常
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            lock.lock();//加锁，锁定以下代码
//            //System.out.println(ticket);
//            if (ticket.get()>0) {
//                System.out.println(Thread.currentThread().getName()+" "+super.getName()+" #票号："+ticket.get());
//                ticket.decrementAndGet();
//            }else {
//                System.out.println(Thread.currentThread().getName()+" "+super.getName()+"票已售罄！！！");
//            }
////            try {
////                Thread.sleep(10);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//            lock.unlock();
      }
        if(ticket.get()==0) {
            System.out.println("票已全部售完。" + ticket);
        }

    }
}
