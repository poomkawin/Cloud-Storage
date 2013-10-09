package Client;

import java.io.File;

public class listDirectory {
	public static void listDir(File dir) throws Exception{
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					listDir(file);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
