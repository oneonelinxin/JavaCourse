package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {
        Object o = new HelloClassLoader().findClass("com.Hello").newInstance();

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            File file = new File("E:\\work_time\\HelloClassLoader\\src\\com\\Hello.xlass");
            FileInputStream is = new FileInputStream(file);
            int length = is.available();
            bytes = new byte[length];
            for (int i = 0;i<length;i++){
                bytes[i]= (byte) (255 - bytes[i]);
            }
            is.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,bytes,0,bytes.length);
    }
}
