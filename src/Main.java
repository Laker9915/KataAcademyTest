import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int num1;
        int num2;
        int answer;

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение в формате '1 + 2' или 'I + II':");

        String userInput = scan.nextLine();
        String[] array = userInput.split(" ", 3);
        if (array.length < 3)
            throw new IOException ("Ошибка! Строка не является математической операцией.");
        String firstValue = array[0];
        String oper = array[1];
        String thirdValue = array[2];
        char operator = oper.charAt(0);
        int operatorLength = oper.length();
        if (operatorLength > 1) {
            throw new IOException("Ошибка! Оператор не распознан.");
        }

        if ((firstValue.contains("I") || (firstValue.contains("V")) || (firstValue.contains("X"))) &&
                ((thirdValue.contains("I") || (thirdValue.contains("V")) || (thirdValue.contains("X"))))) {
            num1 = convert(firstValue);
            num2 = convert(thirdValue);
            if ( num1 == 0 || num1 > 10 || num2 == 0 || num2 > 10) {
                throw new IOException("Ошибка! Введенные числа должны быть от I до X.");}
            answer = calculated(num1, num2, operator);
            if ( answer <= 0 ) {
                throw new IOException("Ошибка! Результат не может быть отрицательным или 0."); }
            String resultRoman = NumToRoman(answer);
            System.out.println(resultRoman); System.exit(0);

        }
        else if(!firstValue.contains("I") & !firstValue.contains("V") & !firstValue.contains("X") &
                !thirdValue.contains("I") & !thirdValue.contains("V") & !thirdValue.contains("X")) {
            num1 = Integer.parseInt(firstValue);
            num2 = Integer.parseInt(thirdValue);
        }
        else throw new IOException("Ошибка! Введенные числа должны быть в одной системе счисления");
        if (num1 > 10 || num1 <= 0 || num2 <= 0 || num2>10) {
            throw new IOException("Ошибка! Введенные числа должны быть от 1 до 10.");}
        answer = calculated(num1, num2, operator);
        System.out.println(answer); System.exit(0);
    }

    private static int convert(String a) {
        return switch (a) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }

    private static int calculated(int num1, int num2, char mainOperation) throws IOException {
        int result;
        switch (mainOperation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> throw new IOException("Ошибка! Оператор не соответствует заданию. ");

        }
        return result;
    }

    private static String NumToRoman (int numArabian) {
        String[] roman = {"N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
                "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV",
                "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
                "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI",
                "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
}