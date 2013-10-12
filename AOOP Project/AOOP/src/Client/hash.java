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

	    	Formatter formatter = new Formatter();
	    	for (final byte b : messageDigest.digest()) {
	    		formatter.format("%02x", b);
	    	}
	    	return formatter.toString();
	    }catch(Exception e){
	    	return null;
	    }
	}
	
	public static String sha1(String input) throws Exception {
		final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

	    try{
	    	InputStream is = new ByteArrayInputStream(input.getBytes());
	    	final byte[] buffer = new byte[1024];
	    	for (int read = 0; (read = is.read(buffer)) != -1;) {
	    		messageDigest.update(buffer, 0, read);
	    	}

	    	Formatter formatter = new Formatter();
	    	for (final byte b : messageDigest.digest()) {
	    		formatter.format("%02x", b);
	    	}
	    	return formatter.toString();
	    }catch(Exception e){
	    	return null;
	    }
	}
	
	public static String sha1(byte[] bytes) throws Exception {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
		Formatter formatter = new Formatter();
	    for (byte b : messageDigest.digest(bytes)) {
	        formatter.format("%02x", b);
	    }
		return formatter.toString();
	}
}
