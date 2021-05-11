package testProject;
import java.util.regex.*;

public class RegexGroup {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String regex = "区";
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher("東京都港区赤坂");
		if(m.find()){
			System.out.println(m.start());
			System.out.println(m.end());
			System.out.println(m.group());
		}
	}

}
