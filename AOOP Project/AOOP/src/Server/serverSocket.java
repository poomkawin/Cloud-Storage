package Server;

import java.io.*;
import java.net.*;

public class serverSocket extends Thread{
	private ServerSocket sock;
	private String recv;
	private String recvHash;
	private String content;
	
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
				int byteLength = in.readInt();
				byte[] bytes = new byte[byteLength];
				in.readFully(bytes);
				recv = new String(bytes, "UTF-8");
				recvHash = recv.substring(0, 40);
				content = recv.substring(40);
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				if(hash.sha1(content).equals(recvHash)){
					out.writeUTF("Okay");
					System.out.println("Okay");
//					out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
					server.close();
				}else{
					out.writeUTF("Error");
				}
			} catch (Exception e) {
				e.printStackTrace();
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
