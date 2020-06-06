package com.singleton;

/**
 * 枚举单例
 * 不仅可以解决线程同步，还可以防止反序列化
 */
public enum Mgr04 {

    INSTANCE;

    public void m(){}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            lamda表达式
            new Thread(()->{//判断对象的hashcode是否是一个
                System.out.println(Mgr04.INSTANCE.hashCode());
            }).start();
        }
    }


}
