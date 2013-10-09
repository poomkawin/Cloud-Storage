package Server;

import java.io.*;
import java.net.*;

public class serverSocket extends Thread{
	private ServerSocket sock;
	
	serverSocket(int port) throws Exception{
		sock = new ServerSocket(port);
	}
	public void run(){
		while(true){
			try{
				System.out.println("Waiting for client on port " + sock.getLocalPort() + "...");
				Socket server = sock.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
				server.close();
			}catch(SocketTimeoutException s){
				System.out.println("Socket timed out!");
				break;
			}catch(IOException e){
				e.printStackTrace();
				break;
			}
		}
	}
	public static void main(String [] args){
		int port = 4444;//Integer.parseInt(args[0]);
		try{
			Thread t = new serverSocket(port);
			t.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
