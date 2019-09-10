package org.udpchat.app;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import org.udpchat.security.AES;

public class IP_Chat extends javax.swing.JFrame {


    private IP_Chat() {
        initComponents();
    }

    private String ip, name, port, msg;
    static IP_Chat app;

    private void initComponents() {

        JPanel jPanel3 = new JPanel();
        JLabel jLabel1 = new JLabel();
        jTextField1 = new javax.swing.JTextField();
        JLabel jLabel2 = new JLabel();
        jTextField2 = new javax.swing.JTextField();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        JButton jButton1 = new JButton();
        JLabel jLabel3 = new JLabel();
        jTextField4 = new javax.swing.JTextField();
        JLabel jLabel4 = new JLabel();
        jPasswordField1 = new JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(89, 92, 94));

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", Font.PLAIN, 13)); // NOI18N
        jLabel1.setText("IP");

        jTextField1.setFont(new java.awt.Font("Bitstream Vera Sans", Font.PLAIN, 13)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("224.0.0.1");
        jTextField1.setToolTipText("IP should be in multicast range");
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans", Font.PLAIN, 13)); // NOI18N
        jLabel2.setText("Port");

        jTextField2.setFont(new java.awt.Font("Bitstream Vera Sans", Font.PLAIN, 13)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("1234");
        jTextField2.setToolTipText("port number > 1024 are preferrable");
        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 15)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(74, 246, 38));
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("Chat History");
        jScrollPane1.setViewportView(jTextArea1);

        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 16)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(74, 246, 38));
        jTextField3.setToolTipText("Enter your text..");
        jTextField3.addActionListener(this::jTextField3ActionPerformed);

        jButton1.setBackground(new java.awt.Color(104, 107, 109));
        jButton1.setFont(new java.awt.Font("Bitstream Vera Sans", Font.PLAIN, 14)); // NOI18N
        jButton1.setText("Send");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans", Font.PLAIN, 13)); // NOI18N
        jLabel3.setText("Name");

        jTextField4.setFont(new java.awt.Font("Bitstream Vera Sans", Font.PLAIN, 13)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("anonymous");
        jTextField4.setToolTipText("an unique name for join the chat");
        jTextField4.addActionListener(this::jTextField4ActionPerformed);

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans", Font.PLAIN, 13)); // NOI18N
        jLabel4.setText("Password");

        jPasswordField1.setFont(new java.awt.Font("Bitstream Vera Sans", Font.PLAIN, 13)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setText(AES.initVector);
        jPasswordField1.setToolTipText("length must be less than or equal 16");
        jPasswordField1.addActionListener(this::jPasswordField1ActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4)
                                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        app.ip = app.jTextField1.getText();
    }
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        app.port = app.jTextField2.getText();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        msg = jTextField3.getText();
        jTextField3.setText("");
    }
    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        msg = jTextField3.getText();
        jTextField3.setText("");
    }
    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {
        String psd = String.valueOf(jPasswordField1.getPassword());
        int len = psd.length();

        if(len < 16) {
            AES.password = psd + AES.initVector.substring(len);
        } else if(len > 16) {
            AES.password = psd.substring(0,16);
        } else {
            AES.password = psd;
        }
    }
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        app.name = app.jTextField4.getText();
    }

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IP_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        app = new IP_Chat();
        app.setResizable(false);
        app.ip = app.jTextField1.getText();
        app.port = app.jTextField2.getText();
        app.msg = app.jTextField3.getText();
        app.name = app.jTextField4.getText();
        AES.password = String.valueOf(app.jPasswordField1.getPassword());

        java.awt.EventQueue.invokeLater(() -> app.setVisible(true));

        try
        {
            InetAddress group = InetAddress.getByName(app.ip);
            MulticastSocket socket = new MulticastSocket(Integer.parseInt(app.port));
            socket.setTimeToLive(255);
            socket.joinGroup(group);
            Thread t = new Thread(new Listener(socket,group,Integer.parseInt(app.port)));
            t.start();
            while(true)
            {
                if(app.msg.equalsIgnoreCase("Exit"))
                {
                    socket.leaveGroup(group);
                    socket.close();
                    t.interrupt();
                    break;
                }
                if(!app.msg.equals("")) {
                    if(app.msg.equals("Enter your text..")) {
                        app.msg = "";
                    } else {
                        app.msg = AES.encrypt(app.name + ": " + app.msg + "\n");
                        assert app.msg != null;
                        byte[] buffer = app.msg.getBytes();
                        DatagramPacket datagrampacket = new DatagramPacket(buffer,buffer.length,group,Integer.parseInt(app.port));
                        socket.send(datagrampacket);
                        app.msg = "";
                    }
                }
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        catch(SocketException se)
        {
            System.out.println("Error creating socket");
            se.printStackTrace();
        }
        catch(IOException ie)
        {
            System.out.println("Error reading/writing from/to socket");
            ie.printStackTrace();
        }
    }

    private JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    javax.swing.JTextArea jTextArea1;
}