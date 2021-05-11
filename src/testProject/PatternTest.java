package testProject;
import java.util.regex.*;

public class PatternTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String regex = "jpg$";
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher("profile.jpg");
		if(m.find()) {
			System.out.println("パターンにマッチしました");
			System.out.println("マッチした部分は"+m.group() + "です");
		}
		else {
			System.out.println("パターンにマッチしません");
		}
	}

}
