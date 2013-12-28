import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

/**
 * 
 * Main class for the Code Eval challenge problem Reverse and Add.
 * @author Brian Ha
 *
 */
public class Main {

	private static Reader input;
	private static PrintWriter output;
	private static Scanner sc;
	private static String result = "";
	
	/** main method for class. */
	public static void main(String[] args) {
		if (args.length >= 2) {
            System.out.println("Invalid length.");
            System.exit(0);
        }
		try {
			if (args.length > 0)
				input = new FileReader(new File(args[0]));
			else
				input = new FileReader("C:\\Users\\Brian\\workspace\\reverse_and_add\\src\\test.txt");
            output = new PrintWriter(System.out);
            sc = new Scanner(input);
            access();
            output.close();
            
		} catch (IOException e) {
            System.out.println("Invalid input file(s).");
            System.exit(0);
            return;
        }
	}
	
	/** method that goes accesses each test case. */
	public static void access() {
		while (sc.hasNextLine()) {
			int count = 0;
			String str = sc.nextLine();			
			while (!isPalindrome(str)) {
				count++;
				String reverse = new StringBuffer(str).reverse().toString();
				int temp = Integer.parseInt(str) + Integer.parseInt(reverse);
				str = Integer.toString(temp);
			}
			result = result + count + " " + str + "\n";
		}
		output.print(result);
	}
	
	/** checks if input is a palindrome or not and returns result. */
	public static boolean isPalindrome(String inp) {
		int len = inp.length();
		if (len == 1) {
			return true;
		}
		for (int i = 0; i < len / 2; i++) {
			if (!(inp.charAt(i) == inp.charAt(len - i - 1))) {
				return false;
			}
		}
		return true;
	}

}
