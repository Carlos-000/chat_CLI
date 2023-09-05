import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Client Chat");
        try (
                Socket socket = new Socket(SERVER_ADRESS, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));) {
            String userMessage;
            while ((userMessage = userInput.readLine()) != null) {
                out.println(userMessage);
                String serverResponse = in.readLine();
                System.out.println("Servidor: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
