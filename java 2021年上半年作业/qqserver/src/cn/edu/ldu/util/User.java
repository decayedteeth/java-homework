package cn.edu.ldu.util;

import java.net.DatagramPacket;

/**
 * User�࣬�����û����󣬰����û������յ��ı���
 * @author ����־����Ȩ����2016--2018��upsunny2008@163.com
 */
public class User {
    private String userId=null; //�û�id
    private DatagramPacket packet=null; //����
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public DatagramPacket getPacket() {
        return packet;
    }
    public void setPacket(DatagramPacket packet) {
        this.packet = packet;
    }   
}
