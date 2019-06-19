package com.company;

import java.util.concurrent.*;



class threading extends Thread{

	// write your code here

        public void run (){


            do {
                ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
                Future<Integer> future = exec.submit(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        long newVar = (long)(Math.random()*1000);
                        int var = (int)(newVar);
                        try {
                            Thread.sleep(newVar);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        return var;

                    }

                });

                exec.shutdown();
                try {
                    System.out.println(future.get());
                    System.out.println(Thread.currentThread().getName());

                    if (future.get() == 10) {
                        System.out.println("10 generated !!\n");
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            } while(true);
        }
}

public class Main{
    public static void main(String[] args){

        threading obj1 = new threading();
        threading obj2 = new threading();
        threading obj3 = new threading();


        obj1.start();
        obj2.start();
        obj3.start();


        }
}
