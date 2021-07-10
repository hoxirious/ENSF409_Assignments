import java.util.Scanner;

public class TwoDArray {
	
	static void reChar(char [] arg1) {
		char [] temp = new char [arg1.length];
		
		for (int i = 0, j = arg1.length - 1; i < arg1.length; i++, j--) {
			temp[i] = arg1[j];
		}
		
		for (int i = 0; i < arg1.length; i++) {
			arg1[i] = temp[i];
		}
		
	}
	
	static void reWord(char [] arg2) {
		String argS = String.valueOf(arg2);
		String [] words = argS.split(" ");
		String tempS = "";
		for (int i = words.length -1; i > 0; i--) {
			tempS += words[i] + " ";
		}
		char [] tempc = tempS.toCharArray();
		for (int i = 0; i < tempc.length; i++) {
			arg2[i] = tempc[i];
		}
	}
	
	static void UpperCase(char [] arg3) {
		for (int i = 0; i < arg3.length; i++) {
			if (i % 5 == 0) arg3[i] = Character.toUpperCase(arg3[i]);
		}
	}
	
	public static void main(String [] args) {
		String sentences[];
        
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the three sentences for this program (In the same line - don't use Enter between sentences): ");
		
		String name = scan.nextLine();
		
		sentences = name.split("(?<=[.!?:])\\s"); 
		
		char [][] ch = new char [3][60];
		
		ch[0] = sentences[0].toCharArray();
		ch[1] = sentences[1].toCharArray();
		ch[2] = sentences[2].toCharArray();
		
        reChar(ch[0]);
        reWord(ch[1]);
        UpperCase(ch[2]);
        
        sentences[0] = String.valueOf(ch[0]);
        sentences[1] = String.valueOf(ch[1]);
        sentences[2] = String.valueOf(ch[2]);
        
        System.out.printf("The first sentence after reversing order of characters: %s\n", sentences[0]);
        System.out.printf("The second sentence after reversing order of words: %s\n", sentences[1]);
        System.out.printf("The third sentence after upper case letters: %s\n", sentences[2]);

		  scan.close();
		
	}
}
