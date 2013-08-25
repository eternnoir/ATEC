package atec.net.atec.analyzer;

import java.io.DataOutputStream;

public class ServiceCenter {
	/**
	 * 
	 * @param filePath
	 */
	public static void copyEventType(String filePath){
		Process p;
		try {
			// Preform su to get root privledges
			p = Runtime.getRuntime().exec("su", null, null);
			DataOutputStream os = new DataOutputStream(p.getOutputStream());
			String mkdircmd = "mkdir /mnt/sdcard/tmp\n";
			os.writeBytes(mkdircmd);
			// Attempt to write a file to a root-only
			String cmd = "getevent -lp >> "+filePath+"/et1\n";
			os.write(cmd.getBytes());
			os.flush();cmd = "getevent -p >> "+filePath+"/et2\n";
			os.write(cmd.getBytes());
			os.flush();
			os.writeBytes("exit\n");
			os.flush();
			os.close();
			p.waitFor();
		} catch (Exception e) {
			// TODO Code to run in input/output exception
			// return false;
			e.printStackTrace();
		}
	}
	/**
	 * copy event format to tmp file
	 *	/sdcard/tmp/
	 */
	public static void copyEventType(){
		copyEventType("/sdcard/tmp");
	}
	
}
