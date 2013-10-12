package Client;

import java.io.*;
import java.net.*;

public class send extends Thread{
	private Socket sock;
	private String serverName;
	private int port;
	private byte[] sha1hash;
	private byte[] bytes;
	private byte[] output;
	
	send(String serverName, int port, String input){
		this.serverName = serverName;
		this.port = port;
		bytes = input.getBytes();
		try {
			sha1hash = hash.sha1(bytes).getBytes();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		output = new byte[sha1hash.length + bytes.length];						// Constructing buffer
		System.arraycopy(sha1hash, 0, output, 0, sha1hash.length);
		System.arraycopy(bytes, 0, output, sha1hash.length, bytes.length);
	}
	
	send(String serverName, int port, byte[] input){
		this.serverName = serverName;
		this.port = port;
		bytes = input;
		try {
			sha1hash = hash.sha1(bytes).getBytes();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		output = new byte[sha1hash.length + bytes.length];						// Constructing buffer
		System.arraycopy(sha1hash, 0, output, 0, sha1hash.length);
		System.arraycopy(bytes, 0, output, sha1hash.length, bytes.length);
	}
	
	public void run() {
		try {
			while(true){
				sock = new Socket(serverName, port);							// Connecting to server
				System.out.println("Connecting to server");
				OutputStream outToServer = sock.getOutputStream();
				DataOutputStream out = new DataOutputStream(outToServer);
				out.writeInt(output.length);
				out.write(output);												// Sending out
				System.out.println("Sending out");
				InputStream inFromServer = sock.getInputStream();
				DataInputStream in = new DataInputStream(inFromServer);
				if(in.readUTF().equals("Okay")){
					sock.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		try{
			for(int i=0; i<10; i++){
				Thread t = new send("127.0.0.1", 4444, "Hello"+i);
				t.start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
