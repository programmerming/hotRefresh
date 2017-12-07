package com.huoji.admin.hotswap;

import java.lang.management.ManagementFactory;

public class TestHotSwap {

	public static void main(String[] args) {
		testStatic t = (new TestHotSwap()).new testStatic();
		while(true){
			try{
				Thread.sleep(5000);
				String name = ManagementFactory.getRuntimeMXBean().getName();
				System.out.println(name);
				//get pid
				String pid = name.split("@")[0];
				System.out.println("Pid is : " + pid);
				t.print();
			}catch(InterruptedException e){
				
			}
		}
	}
	
	class testStatic{
		public void print(){
			LibUtil.printString("did u miss me ?");
		}
	}
}
