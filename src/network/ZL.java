package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * a socket application written for my roommates' class design
 */
public class ZL {

    private static final String MSG = "CMD_READ_ALL_END";

    private static final String HOST = "192.168.123.169";

    private static final int PORT = 8080;

    public static String getData() throws IOException {
        Socket client = new Socket(HOST, PORT);
        PrintWriter printWriter = new PrintWriter(client.getOutputStream());
        //发送消息
        printWriter.println(MSG);
        printWriter.flush();

        InputStreamReader streamReader = new InputStreamReader(client.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String data = bufferedReader.readLine();
        bufferedReader.close();
        return data;
    }

}
