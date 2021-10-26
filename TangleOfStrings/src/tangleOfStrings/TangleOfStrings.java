package tangleOfStrings;

import java.util.Scanner;

public class TangleOfStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//calls method on start
		System.out.println("(Tangle of Strings)");
		myPassWord();
	}
	
	//method responsible for asking inputs via scanner and calling methods based off input
	public static void picker(Scanner input) {
		input.useDelimiter("\n");
		printline("string: ");
		String str = noSpace(input.next());
		printline("what do you want to do with it?");
		printline("opt: quit, reverse, wordlist, vowels, inverseCase, match, replace");
		String inRes = noSpace(input.next());
		boolean quiting = false;
		switch (inRes) {
			case "quit":
				quiting = true;
				break;
			case "reverse":
				phraseReverse(str, input);
				break;
			case "wordlist":
				printline("select word size(no spaces): ");
				input.reset();
				int lent = input.nextInt();
				wordList(str, input, lent);//lent
				break;
			case "vowels":
				vowels(str);
				break;
			case "inverseCase":
				caseInverse(str);
				break;
			case "match":
				printline("enter second string: ");
				String string2 = noSpace(input.next());
				isMatch(str, string2);
				break;
			case "replace":
				printline("what needs to be replaced?");
				String replaced = noSpace(input.next());
				printline("what are you going to replace it with?");
				String replacement = noSpace(input.next());
				findReplace(str, replaced, replacement);
				break;
		default:
			break;
		}
		if(!quiting) {
			myPassWord();
		}
	}
	//asks for password (me)
	public static void myPassWord() {
		printline("please enter your password:");
		Scanner input = new Scanner(System.in);
		
		input.useDelimiter("\n");
		String inRes = noSpace(input.next());
		
		if (inRes.equals("me")) {
			picker(input);
		}else {
			printline("wrong password");
			myPassWord();
		}
	}
	public static void printline(String s) {
		System.out.println(s);
	}
	public static void printline(int s) {
		System.out.println(s);
	}
	public static void print(char s) {
		System.out.print(s);
	}
	public static void print(String s) {
		System.out.print(s);
	}
	public static String noSpace(String str) {
		return str.replaceAll("\\r|\\n", "");
	}
	
	
	public static void phraseReverse(String str, Scanner input) {
		for (int i = 0; i < str.length(); i++) {
			print(str.charAt((str.length() - i) -1));
		}
		printline("");
	}
	public static void wordList(String str, Scanner input, int åm) {
		
		int origin = 0;
		String strPa;
		for (int j = 0; j < str.length(); j++) {
			
			if(str.charAt(j) == ' ') {
				strPa = str.substring(origin, j);
				origin = j + 1;
				if (strPa.length() == åm) {
					printline(strPa);
				}
			}
			
			
		}
		strPa = str.substring(origin, str.length());
		if (strPa.length() == åm) {
			printline(strPa);
		}
	}
	
	public static void vowels(String str) {
		int indexåm = 0;
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a'|| str.charAt(i) == 'e'|| str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
				indexåm++;
			}
		}
		printline(indexåm);
	}
	public static void caseInverse(String str) {
		char cår[] = str.toCharArray();
		String str2;
		
		for (int i = 0; i < str.length(); i++) {
			str2 = String.valueOf(cår[i]);
			if(Character.isUpperCase(cår[i])) {
				print(str2.toLowerCase());
			}else if(Character.isLowerCase(cår[i])) {
				print(str2.toUpperCase());
			}
		}
		printline("");
	}
	public static void isMatch(String str, String str2) {
		if(str.equals(str2)) {
			printline("strings are equal");
		}else {
			printline("strings are not equal");
		}
	}
	public static void findReplace(String str, String str2, String str3) {
		printline(str.replaceAll(str2, str3));
	}
}


