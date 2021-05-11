package testProject;
import java.util.regex.*;


public class RegixTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String regex = "g..d";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher("good");
		System.out.println(m.matches());
		
		regex="a.b";
		p = Pattern.compile(regex);
		Matcher m1 = p.matcher("a.b");
		System.out.println(m1.matches());
		Matcher m2 = p.matcher("axb");
		System.out.println(m2.matches());
		
		regex="a\\.b";
		p = Pattern.compile(regex);
		m1 = p.matcher("a.b");
		System.out.println(m1.matches());
		m2 = p.matcher("axb");
		System.out.println(m2.matches());
	}

}
