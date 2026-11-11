package dz.univ.calculatrice;

import java.util.Scanner;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Operation addition = new AddOperation();
        final Operation subtraction = new SubtractOperation();
        boolean running = true;

        while (running) {
            System.out.println("=== CALCULATRICE ===");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            final String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    displayResult(scanner, addition);
                    break;
                case "2":
                    displayResult(scanner, subtraction);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }

        scanner.close();
    }

    private static void displayResult(
            final Scanner scanner,
            final Operation operation) {
        final Double firstNumber = readNumber(scanner, "Premier nombre : ");
        final Double secondNumber = readNumber(scanner, "Deuxième nombre : ");

        if (firstNumber != null && secondNumber != null) {
            final double result = operation.calculate(firstNumber, secondNumber);
            System.out.println("Résultat : " + result);
        }
    }

    private static Double readNumber(
            final Scanner scanner,
            final String prompt) {
        System.out.print(prompt);
        final String value = scanner.nextLine().trim();

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            System.out.println("Nombre invalide.");
            return null;
        }
    }
}
