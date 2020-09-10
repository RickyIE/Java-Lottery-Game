import java.io.*;
import java.util.*;




public class LotteryGameAlex2 {

	static int randomNumber(int a) { // method to generate random numbers
		Random randomNumberGenerotor = new Random(); // random numbers generator
		int randomNumber = randomNumberGenerotor.nextInt(a) + 1; // generates random number
		return randomNumber; // returns random number

	}
	
	

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in); // user input
		BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> numbersPool = new ArrayList<Integer>(); // generates 100 random numbers

		int tenRandomNumbers[] = new int[10]; // stores 10 unique random numebrs

		int sum = 0, userGuessedSum = 0; // sum of all the 10 numbers and the users guess

		int bonusGameChance[] = { randomNumber(1000), randomNumber(1000), randomNumber(1000), randomNumber(1000) }; // randomly
																													// generates
																													// chances
																													// for
																													// bonus
																													// game

		int bonusGamePrize[] = new int[5]; // determines which prize will be won if any

		int bonusGameWin = 0; // bonus game win

		int userEnteredNumbers[] = new int[5]; // stores user guesses

		int userWinnings = 0; // prize pool

		int sequence[] = new int[2]; // tracks siquencess for prize

		int sequenceBonus = 0; // 
		
		ArrayList<Integer> stats = new ArrayList <Integer>();
		
		
		/*
		 * - 0 9- ten wining numebrs
		 * - 10 11 12 - sum / user guessed sum / bonus
		 * - 2 4 - prize chances
		 * - 3 0 - bonus prize
		 * - 4 4 - user guesed numbers
		 * - 5 5  - sequence and prize
		 * */

		for (int i = 0; i < 100; i++) { // fills number pull with 100 random numbers
			numbersPool.add(randomNumber(99));
		}

		for (int i = 0; i < numbersPool.size(); i++) { // cleans up duplicates
			for (int j = i + 1; j < numbersPool.size(); j++) { // 2 loops check for duplicates
				if (numbersPool.get(i) == numbersPool.get(j)) {
					numbersPool.remove(j);
					if (j > 0) {
						j = j - 1; // resets j to avoid missing dupcates after previous removal
					}
				}
			}
		}
		System.out.println("---------- The Winning Numbers Are----------\n");

		for (int i = 0; i < 10; i++) { // prints out the 10 random numbers
			tenRandomNumbers[i] = numbersPool.get(i);
			stats.add(tenRandomNumbers[i]);
			sum += tenRandomNumbers[i];
			if (tenRandomNumbers[i] < 10)
				System.out.print("0" + tenRandomNumbers[i] + " ");
			else
				System.out.print(tenRandomNumbers[i] + " ");
		}
		stats.add(sum);
		System.out.println("\n\nThe sum of wining numbers is " + sum);

		for (int i = 0; i < bonusGameChance.length; i++) { //
			if (bonusGameChance[i] > 0 && bonusGameChance[i] <= 600) {
				bonusGamePrize[0] += 1;
				stats.add(10);
			} else if (bonusGameChance[i] > 600 && bonusGameChance[i] <= 800) {
				bonusGamePrize[1] += 1;
				stats.add(20);
			} else if (bonusGameChance[i] > 800 && bonusGameChance[i] <= 900) {
				bonusGamePrize[2] += 1;
				stats.add(50);
			} else if (bonusGameChance[i] > 900 && bonusGameChance[i] <= 975) {
				bonusGamePrize[3] += 1;
				stats.add(200);
			} else if (bonusGameChance[i] > 975 && bonusGameChance[i] <= 1000) {
				bonusGamePrize[4] += 1;
				stats.add(1000);
			}
		}

		System.out.println("\n----------- The Bonus Winings Are ----------");

		for (int i = bonusGamePrize.length - 1; i >= 0; i--) { // starts looking for matches backwords in order to take
																// in to account higher winings for bonus game
			if (bonusGamePrize[i] >= 2) {
				switch (i) {
				case 0:
					System.out.println("\nYou won 10€");
					bonusGameWin = 10;
					break;
				case 1:
					System.out.println("\nYou won 20€");
					bonusGameWin = 20;
					break;
				case 2:
					System.out.println("\nYou won 50€");
					bonusGameWin = 50;
					break;
				case 3:
					System.out.println("\nYou won 200€");
					bonusGameWin = 200;
					break;
				case 4:
					System.out.println("\nYou won 1000€");
					bonusGameWin = 1000;
					break;
				default:
					System.out.println("No Bonus");
				}
				break;
			}

		}
		stats.add(bonusGameWin);
		userWinnings += bonusGameWin;
		System.out.println("\n----------- Guess the Five Numbers ---------");

		for (int i = 0; i < userEnteredNumbers.length; i++) { // user will attempt to guess the five winning numbers
																// which get stored inside an array
			System.out.println("Enter number " + (i + 1));
			int userChoice = input.nextInt();
			for (int k = 0; k < userEnteredNumbers.length; k++) {
				if (userChoice < 1 || userChoice > 99) {
					System.out.println("Please enter number betwean 1 - 99 !");
					i = i - 1;
					break;
				}
				if (userChoice == userEnteredNumbers[k]) {
					System.out.println("Number already entered");
					i = i - 1;
					break;
				}
				if (k == (userEnteredNumbers.length - 1)) {
					userEnteredNumbers[i] = userChoice;
					stats.add(userEnteredNumbers[i]);
					break;
				}
			}

		}
		

		System.out.println("\nWhat is the sum of all wining numbers ?");
		userGuessedSum = input.nextInt();
		stats.add(userGuessedSum);
		if (userGuessedSum == sum) {
			int temp = 300000;
			userWinnings += temp;
			stats.add(temp);
		}

		System.out.println("\n--------------- Results ---------------\n");
		System.out.println("The Winning Numbers Are !!!");
		for (int i = 0; i < tenRandomNumbers.length; i++) {
			if (tenRandomNumbers[i] < 10)
				System.out.print("0" + tenRandomNumbers[i] + " ");
			else
				System.out.print(tenRandomNumbers[i] + " ");
		}

		System.out.println("\nYou chose the numbers !!!");
		for (int i = 0; i < userEnteredNumbers.length; i++) {
			if (userEnteredNumbers[i] < 10)
				System.out.print("0" + userEnteredNumbers[i] + " ");
			else
				System.out.print(userEnteredNumbers[i] + " ");
		}

		int matchingNumber = 0;
		int seq = 0;

		for (int i = 0; i < userEnteredNumbers.length; i++) {
			for (int j = 0; j < tenRandomNumbers.length; j++) {
				if (userEnteredNumbers[i] == tenRandomNumbers[j]) {
					matchingNumber += 1;
					sequence[seq] += 1;
					break;
				}
				if (j == tenRandomNumbers.length - 1 && sequence[seq] > 0) {
					if (sequence[seq] == 1) {
						sequence[seq] = 0;
					} else if (sequence[seq] > 1) {
						seq += 1;
					}
				}
			}
		}
		
		stats.add(matchingNumber);
		int hit=0;
		if (sequence[0] > sequence[1]) {
			sequenceBonus = sequence[0];
		} else if (sequence[0] < sequence[1]) {
			sequenceBonus = sequence[1];
		}


		switch (matchingNumber) {
		case 1:
			userWinnings += 1000;
			stats.add(1000);
			break;
		case 2:
			userWinnings += 5000;
			stats.add(5000);
			break;
		case 3:
			userWinnings += 20000;
			stats.add(20000);
			break;
		case 4:
			userWinnings += 100000;
			stats.add(100000);
			break;
		case 5:
			userWinnings += 700000;
			stats.add(700000);
			break;
		}
		
		

		switch (sequenceBonus) {
		case 2:
			userWinnings += 50000;
			stats.add(50000);
			break;
		case 3:
			userWinnings += 300000;
			stats.add(300000);
			break;
		case 4:
			userWinnings += 800000;
			stats.add(800000);
			break;
		case 5:
			stats.add(3000000);
			stats.add(3000000);
			break;
		}
		
		stats.add(userWinnings);

		System.out.println("\nYour total winnings are " + userWinnings + "€\n");
		
		System.out.println("----------------- Break down ------------------");
		

	}

}
