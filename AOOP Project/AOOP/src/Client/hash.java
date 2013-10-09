package Client;

import java.io.*;
import java.security.*;
import java.util.*;

public class hash {
	public static String sha1(final File file) throws Exception {
		final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

	    try{
	    	InputStream is = new BufferedInputStream(new FileInputStream(file));
	    	final byte[] buffer = new byte[1024];
	    	for (int read = 0; (read = is.read(buffer)) != -1;) {
	    		messageDigest.update(buffer, 0, read);
	    	}
	    }catch(Exception e){
	    	
	    }

	    // Convert the byte to hex format
	    try{
	    	Formatter formatter = new Formatter();
	    	for (final byte b : messageDigest.digest()) {
	    		formatter.format("%02x", b);
	    	}
	    	return formatter.toString();
	    }catch(Exception e){
	    	return null;
	    }
	}

	public static void main(String[] args) {
		File f = new File("/Users/Sinderella/Desktop/test");
		try {
			System.out.println(sha1(f));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
