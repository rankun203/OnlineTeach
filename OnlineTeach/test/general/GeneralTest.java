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
		String s = "下面名字中谁是猴子？@newline@A.孙悟空@newline@B.猪八戒@newline@C.沙悟净@newline@D.唐僧";
		System.out.println(s.substring(s.indexOf("A" + "."), s.indexOf("B" + ".")));
	}
}
