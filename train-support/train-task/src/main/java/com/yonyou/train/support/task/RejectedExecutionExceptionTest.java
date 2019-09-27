package com.yonyou.train.support.task;

import java.util.concurrent.TimeUnit;

/**
 * @author gaoshja
 * @version V1.0
 * @Description: 分析抛出RejectedExecutionException问题
 * @date 2019/5/30
 */
public class RejectedExecutionExceptionTest {

    public static void main(String[] args) {
        test1();
//        test2();
    }

    /**
     * 提交的任务数量超过其本身最大能处理的任务量
     */
    public static void test1() {
        CustomThreadPoolExecutor customThreadPoolExecutor =
                new CustomThreadPoolExecutor();
        customThreadPoolExecutor.init();

        for (int i = 0; i < 13; i++) {
            customThreadPoolExecutor.getCustomThreadPoolExecutor().execute((new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(60 * 60);
                        System.out.println("线程" + Thread.currentThread().getName()
                                + "正在执行...");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }));

            if (i == 12) {
                // throw RejectedExectionException
                customThreadPoolExecutor.getCustomThreadPoolExecutor().submit(new DispatchTask("B",1));
            } else {
                customThreadPoolExecutor.getCustomThreadPoolExecutor().submit(new DispatchTask("A",1));
            }
        }
        customThreadPoolExecutor.getCustomThreadPoolExecutor().shutdown();
    }

//    /**
//     * 当线程池shutdown()后，会中断空闲线程。但是正在运行的线程和处于阻塞队列等待执行的线程不会中断。
//     * shutdown(),不会接收新的线程。
//     */
//    public static void test2() {
//        CustomThreadPoolExecutor customThreadPoolExecutor =
//                new CustomThreadPoolExecutor(2, 2,
//                        0L,
//                        TimeUnit.SECONDS,
//                        new ArrayBlockingQueue<Runnable>(10));
//
//        for (int i = 0; i < 2; i++) {
//            CustomThreadPoolExecutor.CustomTask customTask
//                    = new CustomThreadPoolExecutor.CustomTask(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        TimeUnit.SECONDS.sleep(60 * 60);
//                        System.out.println("线程" + Thread.currentThread().getName()
//                                + "正在执行...");
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }, "success");
//            customThreadPoolExecutor.submit(customTask);
//        }
//        customThreadPoolExecutor.shutdown();
//
//        CustomThreadPoolExecutor.CustomTask customTask
//                = new CustomThreadPoolExecutor.CustomTask(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(60 * 60);
//                    System.out.println("线程" + Thread.currentThread().getName()
//                            + "正在执行...");
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }, "success");
//
//        customThreadPoolExecutor.submit(customTask);
//    }

}
