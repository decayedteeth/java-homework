package cn.edu.ldu;

import cn.edu.ldu.util.Message;
import cn.edu.ldu.util.Translate;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 * LoginUI类，客户机登录界面
 * @author 董相志，版权所有2016--2018，upsunny2008@163.com
 */
public class LoginUI extends javax.swing.JDialog {
    /**
     * Creates new form LoginUI
     * @param parent
     * @param modal
     */
    public LoginUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //设置窗体位置到屏幕中央
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width)/2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height)/2;
        this.setLocation(x, y);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnGetPassword = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        chkRemember = new javax.swing.JCheckBox();
        chkAutoLogin = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtRemoteName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRemotePort = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("用户登录--董相志设计，upsunny2008@163.com");
        setIconImage(null);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cn/edu/ldu/images/Login.png"))); // NOI18N

        txtUserId.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N

        btnRegister.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        btnRegister.setText("注册帐号");
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnGetPassword.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        btnGetPassword.setText("找回密码");
        btnGetPassword.setBorderPainted(false);
        btnGetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPassword.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N

        chkRemember.setText("记住密码");
        chkRemember.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        chkAutoLogin.setText("自动登录");
        chkAutoLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnLogin.setBackground(new java.awt.Color(153, 153, 255));
        btnLogin.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        btnLogin.setText("登  录");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel2.setText("服务器主机名：");

        txtRemoteName.setText("127.0.0.1");

        jLabel3.setText("服务器端口：");

        txtRemotePort.setText("50000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtUserId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkRemember, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addGap(13, 13, 13)
                                .addComponent(chkAutoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(btnGetPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRemoteName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRemotePort)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegister))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGetPassword))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkRemember)
                            .addComponent(chkAutoLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblLogo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRemoteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtRemotePort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 处理登录按钮点击事件的逻辑，完成登录步骤
     * @param evt 登录按钮被点击事件
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    try {
        String id=txtUserId.getText();
        String password=String.valueOf(txtPassword.getPassword());       
        if (id.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "帐号或密码不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //获取服务器地址和端口
        String remoteName=txtRemoteName.getText();
        InetAddress remoteAddr=InetAddress.getByName(remoteName);
        int remotePort=Integer.parseInt(txtRemotePort.getText());   
        //创建UDP套接字
        //
        
        //
        clientSocket.setSoTimeout(3000);//设置超时时间
        //构建用户登录消息
        Message msg=new Message();
        //
        
        
        

        //消息对象序列化
        
        
        
        //定义登录报文

//
        //发送登录报文


        
        
        
        //接收服务器回送的报文
       //
        //
        
        
        
        clientSocket.setSoTimeout(0);//取消超时时间
        Message backMsg=(Message)Translate.ByteToObject(data);
        //处理登录结果
        if (backMsg.getType().equalsIgnoreCase("M_SUCCESS")) { //登录成功

        	//关闭登录对话框
        	
        	
             //创建客户机界面
        	
        	
            client.setTitle(msg.getUserId()); //设置标题
            //显示会话窗体       
            
            
        }else { //登录失败
            JOptionPane.showMessageDialog(null, "用户ID或密码错误！\n\n登录失败！\n", "登录失败",JOptionPane.ERROR_MESSAGE);           
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "登录错误", JOptionPane.ERROR_MESSAGE);
    }//end try   
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginUI dialog = new LoginUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetPassword;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JCheckBox chkAutoLogin;
    private javax.swing.JCheckBox chkRemember;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtRemoteName;
    private javax.swing.JTextField txtRemotePort;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables
}
