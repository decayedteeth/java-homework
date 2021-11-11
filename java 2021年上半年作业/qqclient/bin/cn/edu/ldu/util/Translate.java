package cn.edu.ldu.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Translate，对象的序列化和反序列化
 * @author 董相志，版权所有2016--2018，upsunny2008@163.com
 */
public class Translate {
    /**
     * 对象转化为字节数组形式，实现对象序列化
     * @param obj 待转化的对象
     * @return 字节数组
     */
    public static byte[] ObjectToByte(Object obj) {
       byte[] buffer=null;
        try {
             //字节数组输出流
             //对象输出流
             //输出对象
        	
        	
        	
            buffer=; //对象序列化
        }catch(IOException ex) {}
        return buffer;
    } 
    
    /**
     * 字节数组转化为Object对象形式，实现对象反序列化
     * @param buffer 字节数组
     * @return Object对象
     */
    public static Object ByteToObject(byte[] buffer) {
        Object obj=null;
        try {
           //字节数组输入流
             //对象输入流
        	
        	
        	
        	
            obj=; //转为对象
        }catch(IOException | ClassNotFoundException ex) { }
        return obj;
    } 
}
