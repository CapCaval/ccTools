package org.capcaval.tools.pair.misc;

import java.util.List;

public class TestTool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> list = Tool.newList(1,2,3,4,5,6,6);
		System.out.println(list);
		
		
		List<String> listStr = Tool.newList("1","2","3","4","cinq","six");
		System.out.println(listStr);
		

	}

}
