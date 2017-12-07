package fixed;

import java.io.File;

import com.sun.tools.attach.VirtualMachine;

public class classtestFixBug {

	static{
		System.loadLibrary("attach");
	}
	
	public static void main(String[] args) {
		String processId = "8708";
		String jarFileName = "D:\\hotswap.jar";
		File f = new File(jarFileName);
		System.out.println(f.getAbsolutePath());
		VirtualMachine virtualMachine;
		try{
			virtualMachine = VirtualMachine.attach(processId);
			virtualMachine.loadAgent(jarFileName);
			virtualMachine.detach();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
