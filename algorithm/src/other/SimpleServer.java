package other;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: _1
 * @description: socket网络编程
 * @author: mooncake
 * @create: 2020-05-31 17:57
 **/
public class SimpleServer {
    public static void main(String[] args){

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                Socket s = serverSocket.accept();
                new Thread(()-> {
                        try {
                            Scanner sc = new Scanner(s.getInputStream());
                            System.out.println(sc.nextLine());
                            PrintWriter pw = new PrintWriter(s.getOutputStream());
                            pw.write("2020.6.1 大礼堂 18:00");
                            pw.flush();pw.close();

                        }catch (Exception e){
                            e.printStackTrace();
                    }
                }).start();
            }catch (Exception e){
                e.printStackTrace();
            }

            }



    }
}
