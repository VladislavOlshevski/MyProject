package sample.Server.test10;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServerMain {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8071, 10, InetAddress.getLocalHost());
            System.out.println("initialized: " + server.getInetAddress() + "," + server.getLocalPort());
            while (true) {
                Socket socket = server.accept();//ожидание подключения клиента
                System.out.println(socket.getInetAddress() + " connected" + "," + socket.getPort());
//создание отдельного потока для обмена данными с соединившимся клиентом
                ServerThread thread = new ServerThread(socket);
                thread.start();// запуск потока
                System.out.println(socket.getInetAddress() + " № " + ServerThread.getCounter() + " started");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}