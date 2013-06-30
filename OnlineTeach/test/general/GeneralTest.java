package general;

import org.junit.Test;



public class GeneralTest {
	public static void main(String[] args) {
		int spaceCounts = 0;

		String topic = "你是我的" + "@space@" + "，你是我的" 
				+ "@space@" + "，你是我的" + "@space@"
				+ "，是我的" + "@space@";
		int curTemp = 0;
		while(curTemp != -1){
			System.out.println(curTemp);
			curTemp = topic.indexOf("@space@", curTemp + "@space@".length());
			spaceCounts++;
		}

		System.out.println(spaceCounts);		
	}
	@Test
	public void test() {
//		String s = "我今天[早上]没有吃早饭";
//		System.out.println(s.replaceAll("\\[[^\\[]*\\]", "@place@"));
		String s = "我今天@space@没有吃@space@饭";
		System.out.println(s.replaceAll("@space@", "_______"));
	}
}
