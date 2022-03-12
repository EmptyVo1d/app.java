import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans;
        int count = 0;
        char[] arr = s.toCharArray();
        if (s.length() != 0) {
            for (int i = 0; i < s.length(); i++) {
                if (arr[i] == ' ') count++;
            }
        }
        if (count != 2) {
            System.out.println("error");
            System.exit(1);
        }
        String[] str;
        String del = " ";
        str = s.split(del);
        String number1 = str[0];
        String operator = str[1];
        String number2 = str[2];

        int num1 = check1(number1);
        int num2 = check2(number2);
        if ((num1 != -1 && num2 == -1) || (num1 == -1 && num2 != -1)) System.out.println("error");
        else if (num1 != -1 && num2 != -1) {
            ans = calculator(num1, operator, num2);
            System.out.println(ans);
        } else if (num1 == -1 && num2 == -1) {
            num1 = checkRoman1(number1);
            num2 = checkRoman2(number2);
            if (num1 == -1 || num2 == -1) {
                System.out.println("error");
                System.exit(1);
            }
            ans = calculator(num1, operator, num2);
            if (ans < 1) {
                System.out.println("error");
            } else {
                String ans1 = convertor_RimArab(ans);
                System.out.println(ans1);
            }
        }
    }

    static String convertor_RimArab(int ans) {
        String[] alph = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String s = alph[ans];
        return s;
    }

    static int check1(String number1) {
        String[] alph = {"-1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i <= 10; i++) {
            if (number1.equals(alph[i])) return i;
        }
        return -1;
    }

    static int check2(String number2) {
        String[] alph = {"-1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i <= 10; i++) {
            if (number2.equals(alph[i])) return i;
        }
        return -1;
    }

    static int checkRoman1(String number1) {
        String[] alph = {"-1", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i <= 10; i++) {
            if (number1.equals(alph[i])) return i;
        }
        return -1;
    }

    static int checkRoman2(String number2) {
        String[] alph = {"-1", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i <= 10; i++) {
            if (number2.equals(alph[i])) return i;
        }
        return -1;
    }

    static int calculator(int num1, String operator, int num2) {
        int ans = 0;
        if (operator.equals("+")) ans = num1 + num2;
        if (operator.equals("-")) ans = num1 - num2;
        if (operator.equals("*")) ans = num1 * num2;
        if (operator.equals("/")) ans = num1 / num2;
        return ans;
    }
}
