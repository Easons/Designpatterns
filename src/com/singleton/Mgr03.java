package com.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类是不会加载内部类，这样可以实现懒加载
 */
public class Mgr03 {

    private  Mgr03(){}

    private static class Mgr03Holder{
        private  final  static Mgr03 INSTANCE = new Mgr03();
    }

    public static Mgr03 getInstance(){
        return Mgr03Holder.INSTANCE;
    }

    public void m(){System.out.println("m");}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            lamda表达式
            new Thread(()->{//判断对象的hashcode是否是一个
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }

}
