package oop_class;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		boolean success = false;
		Double total = null;
		while (!success) {
			System.out.println("\nPlease enter simple equation: ");
			try {

				double[] operands = new double[2];

				String line = in.nextLine();
				char[] input = line.toCharArray();
				StringBuilder str;
				int j = 0;
				int i = 0;
				while (i < operands.length) {
					str = new StringBuilder();

					if (input[j] <= 57 && input[j] >= 48 || input[j] == 46) {

						while (input[j] <= 57 && input[j] >= 48 || input[j] == 46) {

							str.append(String.valueOf(input[j]));
							if (j + 1 < input.length) {
								j++;
							} else {
								break;
							}

						}

						operands[i] = Double.parseDouble(str.toString());
						i++;

					} else {
						j++;
					}
				}

		

				for (int o = 0; o < input.length; o++) {

					switch (input[o]) {
					case 43:
						total = operands[0] + operands[1];
						break;
					case 45:
						total = operands[0] - operands[1];
						break;
					case 42:
						total = operands[0] * operands[1];
						break;
					case 47:
						total = operands[0] / operands[1];
					}
				}

				if (total != null) {
					System.out.println(line + " = " + total);
				}else{
					System.out.println("Your input is incorrect! Please enter a valid equation");
					System.out.println("Ex. 1 + 1");
				}

			} catch (Exception e) {

				System.out.println("Your input is incorrect! Please enter a valid equation");
				System.out.println("Ex. 1 + 1");

				continue;
			}

		}

	}
}