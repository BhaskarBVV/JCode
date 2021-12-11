import java.util.*;
public class Main
{
	public static void main(String[] args) {
		String res = "a";
		char temp = res.charAt(res.length()-1);
		String num = "24";
		int val = Integer.parseInt(num);
		res += (char)(temp + val);
		System.out.println(res);
	}
}
