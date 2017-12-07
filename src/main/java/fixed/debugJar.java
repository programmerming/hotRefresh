package fixed;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

public class debugJar {

	public static void agentmain(String arg, Instrumentation inst) throws Exception {
		Class<?> libUtil = Class.forName("com.huoji.admin.hotswap.LibUtil");
		// copy the contents of typo.fix into abyte array
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		InputStream input = null;
		try {
			input = new FileInputStream("D:\\LibUtil.class");// 包名类名都要与原来的一致
			byte[] buffer = new byte[1024];
			int length;
			while ((length = input.read(buffer)) != -1) {
				output.write(buffer, 0, length);
			}
		} catch (Exception e) {
			if (input == null)
				System.out.println("class input is null");
			else
				e.printStackTrace();
		}

		// Apply the redefinition
		inst.redefineClasses(new ClassDefinition(libUtil, output.toByteArray()));
	}
}
