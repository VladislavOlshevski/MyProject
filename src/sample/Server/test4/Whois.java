package sample.Server.test4;

import java.net.*;
import java.io.*;

class Whois {
    public static void main(String args[]) throws Exception {
        int c;
//создать сокетное соединение с веб-сайтом verisigngrs.        com через порт 43
        Socket s = new Socket("whois.verisign-grs.com", 43);
// получить потоки ввода-вывода
        InputStream socketInputStream = s.getInputStream();
        OutputStream socketOutputStream = s.getOutputStream();
// сформровать строку запроса
        String str = (args.length == 0 ? "GOOGLE.COM" : args[0]) + "\n";
        byte buf[] = str.getBytes();//преобразовать строку в байты
        socketOutputStream.write(buf); //отправить запрос
// прочитать ответ и вывести его на экран
        while ((c = socketInputStream.read()) != -1) {
            System.out.print((char) c);
        }
        s.close();
    }
}