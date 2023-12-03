package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Server {
    public static void main(String[] args)
        throws IOException, InterruptedException {

        StringBuilder lineBuilder = new StringBuilder();
        FileChannel fileChannel = FileChannel.open(Path.of("src/main/java/edu/hw8/Task1/spicyPhrases.txt"));
        ByteBuffer buffer = ByteBuffer.allocate(20000);
        int bytesRead = fileChannel.read(buffer);
        while (bytesRead != -1) {
            bytesRead = fileChannel.read(buffer);
        }
        buffer.flip();
        String str1 = new String(buffer.array(), StandardCharsets.UTF_8);

        List<String> spicyPhrases = new ArrayList<>();

        for (char c : str1.toCharArray()) {
            if (c != '\r' && c != '\n') {
                lineBuilder.append(c);
            } else if (c == '\n') {
                spicyPhrases.addLast(lineBuilder.toString());
                lineBuilder.delete(0, lineBuilder.length());
            }
        }



        ServerSocket serverSocket = new ServerSocket(8080);

        Callable<String> callable = () -> {
            Socket socket = serverSocket.accept();
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            var out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String request="0";
            while (!request.isBlank()) {
                request = in.readLine();
                System.out.println(request);

                var pattern = Pattern.compile(request);
                Matcher matcher;
                for (String s : spicyPhrases) {
                    matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        System.out.println(s);
                        out.write("Сервер: " + s + '\n');
                        out.flush();
                    } else {
                        System.out.println("---");
                    }
                }
            }

            in.close();
            out.close();
            socket.close();

            return "";

        };
        ExecutorService executorServices = Executors.newFixedThreadPool(6);
        var tasks = Stream.generate(() -> callable).limit(1000).toList();
        executorServices.invokeAll(tasks);
        executorServices.shutdown();
        serverSocket.close();

    }
}
