package arraysAndStrings.Q1_06_String_Compression;

public class Tester {

	public static void main(String[] args) {
		String str = "aaaaabbbbaaaabbddc";
		System.out.println(str);
		System.out.println(StringCompression.compressBad(str));
		System.out.println(QuestionB.compress(str));
		System.out.println(QuestionC.compress(str));
		System.out.println(compressOwn(str));
	}


	public static String compressOwn(String str){
		int count = 1;
		StringBuilder builder = new StringBuilder(str.length());
		for (int i = 0 ; i < str.length() ; i++){
			if(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
				count++;
			} else {
				builder.append(str.charAt(i)).append(count);
				count = 1;
			}
		}
		return str.length() > builder.length() ? builder.toString() : str;
	}
}
