import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Getting the input from the user
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        // Write your condition here using the ternary operator
        String result = (input%3==0 && input%5==0) ? "FizzBuzz":
                        input%5==0 ? "Fizz":
                        input%3==0 ? "Buzz": String.valueOf(input);

        System.out.println(result);
    }
}
