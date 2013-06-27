package general;



public class GeneralTest {
	public static void main(String[] args) {
		int spaceCounts = 0;

		String topic = "你是我的" + "@space@" + "，你是我的" 
				+ "@space@" + "，你是我的" + "@space@"
				+ "，是我的" + "@space@";

		int curTemp = 0;
		while(curTemp != -1){
			curTemp = topic.indexOf("@space@", curTemp + "@space@".length());
			spaceCounts++;
		}

		System.out.println(spaceCounts);		
	}
	
}
