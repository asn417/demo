package com.asn.se.thread;

import java.util.concurrent.*;

/**
 * @Author: wangsen
 * @Date: 2020/11/1 15:18
 * @Description:
 **/
public class SaleTicketsByCallable implements Callable {

    private int tickets = 100;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SaleTicketsByCallable saleTicketsByCallable = new SaleTicketsByCallable();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future submit = executorService.submit(saleTicketsByCallable);
        System.out.println(submit.get());
        executorService.shutdown();
    }

    @Override
    public Object call() throws Exception {
        while (true) {
            if (tickets > 0) {
                return Thread.currentThread().getName() + "卖出了第 " + tickets-- + " 张票";
            } else {
                break;
            }
        }
        return null;
    }
}
