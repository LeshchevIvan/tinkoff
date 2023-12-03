package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class Client1 {

    private static Socket socket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 1000; i++) {
            try {
                socket = new Socket("localhost",8080);
                var reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                String request ="0";
                while (!request.isBlank()) {
                    request = reader.readLine();

                    out.write(request + '\n');
                    out.flush();
                    in.read();
                    while (in.ready()) {
                        String response = in.readLine();
                        System.out.println(response);
                    }
                }
                in.close();
                out.close();
                socket.close();
                break;
            }
            catch (IOException e){
                Thread.sleep(1000);
            }


        }





    }
}
