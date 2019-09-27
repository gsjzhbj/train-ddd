package com.yonyou.train.support.task;

import java.util.ArrayList;
import java.util.List;

public class DispatchRunnable implements Runnable {

    private int time=1;
    private SourceShare s;
    private String id;
    public DispatchRunnable(SourceShare s){
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
            //中断异常
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
class SourceShare{
    private List<String> list = new ArrayList<String>();
    public synchronized int getListSize(){
        return list.size();
    }
    public synchronized void getSource(){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    public synchronized void setSource(String id){
        list.add(id);
    }
}

class Test{
    public static void main(String []args){
        SourceShare sourceShare = new SourceShare();
        for(int i=0;i<10;i++) {
            DispatchThread dispatchThread = new DispatchThread(sourceShare);
            DispatchRunnable dispatchRunnable = new DispatchRunnable(sourceShare);
            Thread dispatchRunnableThread = new Thread(dispatchRunnable);
            System.out.println("调用线程1");
            dispatchThread.start();
            System.out.println("1-----------"+sourceShare.getListSize());
            sourceShare.getSource();
            System.out.println("调用线程2");
            System.out.println("2-----------"+sourceShare.getListSize());
            dispatchRunnableThread.start();
        }
        System.out.println(sourceShare.getListSize());
    }
}
