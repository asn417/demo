package com.asn.se.thread;

/**
 * @Author: wangsen
 * @Date: 2020/11/1 14:55
 * @Description: 需求：模拟龟兔赛跑，假设赛道长度1000米，兔子的速度是乌龟的2倍，正常情况下兔子跑的快，但通过休眠让乌龟先跑完
 **/
public class TortoiseAndRabbit implements Runnable {
    private Boolean isOver = false;

    public static void main(String[] args) {
        TortoiseAndRabbit tortoiseAndRabbit = new TortoiseAndRabbit();

        new Thread(tortoiseAndRabbit, "兔子").start();
        new Thread(tortoiseAndRabbit, "乌龟").start();

    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("兔子")) {
            for (int i = 0; i <= 1000; ) {
                if (isOver) {
                    break;
                } else {
                    i += 2;
                    System.out.println(Thread.currentThread().getName() + "跑了 " + i + " 米！");
                    try {
                        Thread.sleep(1);//这里让兔子每次跑完一步后休息1毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i >= 1000) {
                        isOver = true;
                        System.out.println("兔子胜利");
                    }
                }
            }
        } else {
            for (int i = 0; i <= 1000; ) {
                if (isOver) {
                    break;
                } else {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "跑了 " + i + " 米！");
                    if (i >= 1000) {
                        isOver = true;
                        System.out.println("乌龟胜利");
                    }
                }
            }
        }

    }
}
