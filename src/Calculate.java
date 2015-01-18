public class Calculate {

	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("<number1> <operator> <number2>");
		} else {

			final int num1 = Integer.parseInt(args[0]);
			final int num2 = Integer.parseInt(args[2]);
			switch (args[1]) {
			case "+":
				System.out.println("Result: " + (num1 + num2));
				break;
			case "-":
				System.out.println("Result: " + (num1 - num2));
				break;
			case "*":
				System.out.println("Result: " + (num1 * num2));
				break;
			case "/":
				System.out.println("Result: " + (num1 / num2));
				break;
			}
			System.out.println("\n");
		}
	}

}
