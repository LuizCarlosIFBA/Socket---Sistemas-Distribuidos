import java.io.*;
import java.net.*;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Conexão estabelecida.");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
            String inputLine;
            while ((inputLine = stdIn.readLine()) != null) {
                out.println(inputLine);
                String response = in.readLine();
                System.out.println("Resposta do servidor: " + response);
                
                if (inputLine.equals("exit")) {
                    break;
                }
            }
            
            System.out.println("Conexão encerrada.");
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro ao conectar ao servidor: " + e.getMessage());
        }
    }
}
