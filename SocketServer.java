import java.io.*;
import java.net.*;
import java.util.*;

public class SocketServer {
    private static List<Integer> lista = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Socket servidor iniciado na porta 1234.");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Conexão estabelecida.");
                
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    String[] tokens = inputLine.split(" ");
                    String command = tokens[0];
                    
                    if (command.equals("add")) {
                        int index = Integer.parseInt(tokens[1]);
                        int value = Integer.parseInt(tokens[2]);
                        lista.add(index, value);
                        out.println("Elemento adicionado à lista.");
                    } else if (command.equals("list")) {
                        out.println("Lista: " + lista.toString());
                    } else if (command.equals("remove")) {
                        int index = Integer.parseInt(tokens[1]);
                        int value = lista.remove(index);
                        out.println("Elemento removido da lista: " + value);
                    } else if (command.equals("exit")) {
                        break;
                    }
                }
                
                System.out.println("Conexão encerrada.");
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
