package sample.Server.test2;

import java.net.*;

class InetAddressTest {
    public static void main(String args[]) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        address = InetAddress.getByName("www.gmail.com");
        System.out.println(address);
        InetAddress addressTUTBy = InetAddress.getByName("www.tut.by");
        System.out.println(addressTUTBy);
        System.out.println("----------------------------------------------------------");
        InetAddress addressArrayTUTBy[] = InetAddress.getAllByName("www.tut.by");
        for (int i = 0; i < addressArrayTUTBy.length; i++)
            System.out.println(addressArrayTUTBy[i]);
        InetAddress addressArrayMAILRu[] = InetAddress.getAllByName("www.mail.ru");
        for (InetAddress inetAddress : addressArrayMAILRu)
            System.out.println(inetAddress);
        InetAddress addressArraygmail[] = InetAddress.getAllByName("www.gmail.com");
        for (int i = 0; i < addressArraygmail.length; i++)
            System.out.println(addressArraygmail[i]);
    }
}