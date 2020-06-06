package com.singleton;

/**
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 两个时间的线程同时访问时，会造成创建了两个实例
 */
public class Mgr02 {
    private  static Mgr02 INSTANCE;

    private Mgr02(){};

    public synchronized static Mgr02 getInstance(){

        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
//            lamda表达式
            new Thread(()->{//判断对象的hashcode是否是一个
                System.out.println(Mgr02.getInstance().hashCode());
            }).start();
        }
    }
}
