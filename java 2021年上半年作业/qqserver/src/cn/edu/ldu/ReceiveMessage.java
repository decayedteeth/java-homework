package cn.edu.ldu;

import cn.edu.ldu.util.Message;
import cn.edu.ldu.util.Translate;
import cn.edu.ldu.util.User;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * ReceiveMessage��������������Ϣ�ʹ�����Ϣ���߳���
 * @author ����־����Ȩ����2016--2018��upsunny2008@163.com
 */
public class ReceiveMessage extends Thread {
    private DatagramSocket serverSocket; //�������׽���
    private DatagramPacket packet;  //����
    private List<User> userList=new ArrayList<User>(); //�û��б�
    private byte[] data=new byte[8096]; //8K�ֽ�����
    private ServerUI parentUI; //��Ϣ����  
	private int i;
    
    /**
     * ���캯��
     * @param socket �Ự�׽���
     * @param parentUI ����
     */
    public ReceiveMessage(DatagramSocket socket,ServerUI parentUI) {
        serverSocket=socket;
        this.parentUI=parentUI;
    }
    @Override
    public void run() {  
        while (true) { //ѭ�������յ��ĸ�����Ϣ
            try {
            //�������ձ���
            packet=new DatagramPacket(data,data.length);
            //���տͻ�������
            serverSocket.receive(packet);	
            //�յ�������תΪ��Ϣ����
           Message msg=(Message)Translate.ByteToObject(packet.getData());
            String userId= msg.getUserId() ;//��ǰ��Ϣ�����û���id            
            if (msg.getType().equalsIgnoreCase("M_LOGIN")) { //��M_LOGIN��Ϣ 
                Message backMsg=new Message();
                //�ٶ�ֻ��2000��3000��8000�����ʺſ��Ե�¼
                if (!userId.equals("2000") && !userId.equals("3000") && !userId.equals("8000")) {//��¼���ɹ�
                    backMsg.setType("M_FAILURE");
                    byte[] buf=Translate.ObjectToByte(backMsg);
                    DatagramPacket backPacket=new DatagramPacket(buf,buf.length,packet.getAddress(),packet.getPort());//���¼�û����͵ı���
                    serverSocket.send(backPacket); //����                  
                }else { //��¼�ɹ�
                    backMsg.setType("M_SUCCESS");
                    byte[] buf=Translate.ObjectToByte(backMsg);
                    DatagramPacket backPacket=new DatagramPacket(buf,buf.length,packet.getAddress(),packet.getPort());//���¼�û����͵ı���
                    serverSocket.send(backPacket); //����   
                    
                    User user=new User();
                    user.setUserId(userId); //�û���
                    user.setPacket(packet); //�����յ��ı���
                    userList.add(user); //�����û������û��б�
                    
                    //���·����������Ҵ���
                    parentUI.txtArea.append(userId+" ��¼��\n");
                    
                    //���������������û�����M_LOGIN��Ϣ�����µ�¼�߷��������û��б�
                    for(int i =0;i<userList.size();i++);
                    {
                    if(!userId.equalsIgnoreCase(userList.get(i) .getUserId()));                
                    	DatagramPacket oldPacket=userList.get(i).getPacket();
                    	DatagramPacket newPacket=newDatagramPacket(data,data.length,oldPacket.getAddress(),oldPacket.getPort());
                    	serverSocket.send(newPacket);  //����
                       
                }//end if     
                //��ǰ�û�������Ϣ������i���û�id�����û��б�
                Message other =new Message();
                other.setUserId(userList.get(i).getUserId());
                other.setType("M_ACK");
                byte[] buffer=Translate.ObjectToByte(other);
                DatagramPacket newPacket=newDatagramPacket(buffer,buffer.length,packet.getAddress(),packet.getPort());
                serverSocket.send(newPacket); 
            //end for  
                }//end if
                
                
            }else if (msg.getType().equalsIgnoreCase("M_MSG")) { //��M_MSG��Ϣ
                //������ʾ
                parentUI.txtArea.append(userId+" ˵��"+msg.getText()+"\n");
                //ת����Ϣ
                for(int i =0;i<userList.size();i++);{
                	DatagramPacket oldPacket=userList.get(i).getPacket();
                	DatagramPacket newPacket=newDatagramPacket(data,data.length,oldPacket.getAddress(),oldPacket.getPort());
                	serverSocket.send(newPacket);
                }
    
            }else if (msg.getType().equalsIgnoreCase("M_QUIT")) { //��M_QUIT��Ϣ
                //������ʾ
                parentUI.txtArea.append(userId+" ���ߣ�\n");
                //ɾ���û�
                for(int i=0;i<userList.size();i++) {
                    if (userList.get(i).getUserId().equals(userId)) {
                        userList.remove(i);
                        break;
                    }
                }//end for
                //�������û�ת��������Ϣ
                for(int i =0;i<userList.size();i++);{
                	DatagramPacket oldPacket=userList.get(i).getPacket();
                	DatagramPacket newPacket=newDatagramPacket(data,data.length,oldPacket.getAddress(),oldPacket.getPort());
                	serverSocket.send(newPacket);
                }
                //end for 
            }//end if
            } catch (IOException | NumberFormatException ex) {  }
        }//end while
    }//end run
	private DatagramPacket newDatagramPacket(byte[] data2, int length,
			InetAddress address, int port) {
		// TODO Auto-generated method stub
		return null;
	}
}//end class
