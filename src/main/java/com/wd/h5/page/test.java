package com.wd.h5.page;

/**
 * Created by ike on 16/7/26.
 */
public class test {

    public String getName(){

        return this.getClass().getPackage().getName();
//        return this.getClass().getSimpleName();

    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        int i = new test().getName().indexOf("h5");
        if (i>0){
            System.out.println(new test().getName());
        }

    }
}
