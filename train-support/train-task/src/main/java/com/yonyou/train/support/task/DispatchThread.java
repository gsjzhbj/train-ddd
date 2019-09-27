package com.yonyou.train.support.task;

public class DispatchThread extends Thread{
    private int time=1;
    private SourceShare s;//多线程共享资源
    private String id = "001";
    public DispatchThread(SourceShare s){
        this.s = s;
    }
    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        try {
            System.out.println("i will sleep"+ time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized(s){
            s.notify();
            System.out.println(this.getClass()+"唤醒了002！");
            System.out.println("我存入了id"+id);
            s.setSource(id);
        }
    }
}
