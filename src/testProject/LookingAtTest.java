package testProject;
import java.util.regex.*;

public class LookingAtTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String regex = "港区";
		Pattern p = Pattern.compile(regex);
		
		Matcher m1 = p.matcher("港区市役所");
		System.out.println(m1.lookingAt());
		
		Matcher m2 = p.matcher("東京都港区");
		System.out.println(m2.lookingAt());
		
		
	}

}
