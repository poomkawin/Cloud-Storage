package Server;

import java.io.*;
import java.net.*;

public class clientHandler implements Runnable {
	Socket socket;
	
	clientHandler(Socket sock){
		socket = sock;
	}
	
	@Override
	public void run(){
		String recv;
		String recvHash;
		String content;
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Just connected to " + socket.getRemoteSocketAddress());
			int byteLength = in.readInt();
			byte[] bytes = new byte[byteLength];
			in.readFully(bytes);
			recv = new String(bytes, "UTF-8");
			recvHash = recv.substring(0, 40);
			content = recv.substring(40);
			
			if(hash.sha1(content).equals(recvHash)){
				out.writeUTF("Okay");
				System.out.println(recv);
			}else{
				out.writeUTF("Error");
				System.out.println("Okay");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	protected void finalize(){
		try {
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
