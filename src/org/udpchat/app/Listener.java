package org.udpchat.app;

import org.udpchat.security.AES;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

class Listener implements Runnable
{
    private MulticastSocket socket;
    private InetAddress group;
    private int port;
    private static final int MAX_LEN = 1000;

    Listener(MulticastSocket socket, InetAddress group, int port)
    {
        this.socket = socket;
        this.group = group;
        this.port = port;
    }

    @Override
    public void run()
    {
        while(true)
        {
            byte[] buffer = new byte[Listener.MAX_LEN];
            DatagramPacket datagrampacket = new DatagramPacket(buffer,buffer.length, group, port);
            try
            {
                socket.receive(datagrampacket);
                String message = new String(buffer, 0, datagrampacket.getLength(), StandardCharsets.UTF_8);
                IP_Chat.app.jTextArea1.append(AES.decrypt(message));
            }
            catch(IOException e)
            {
                System.exit(0);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}