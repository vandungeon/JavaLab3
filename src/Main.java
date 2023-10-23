import java.util.Scanner;
class actionsFib {
    static int cycleExecute(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    static int recursionExecute(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recursionExecute(n - 1) + recursionExecute(n - 2);
        }
    }
}

class actionsFact {
    static int cycleExecute(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static int recursionExecute(int n) {
        if (n == 0) {
            return 1; // Factorial of 0 is 1
        } else {
            return n * recursionExecute(n - 1);
        }
    }
}

class action3 {
    static int execute(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + execute(n / 10);
    }
}

class action4 {
    static int execute(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return execute(sum, carry);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value for N: ");
        int n = scanner.nextInt();
        System.out.print("Enter a value for A and B\n");
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();

        if (n < 0 || A < 0 || B < 0) {
            System.out.println("Input should be a non-negative integer.");
            return;
        }

        int Task11 = actionsFact.cycleExecute(n);
        int Task12 = actionsFib.cycleExecute(n);
        int Task21 = actionsFact.recursionExecute(n);
            assert Task11 == Task21: "Different Factorial values";
        int Task22 = actionsFib.recursionExecute(n);
            assert Task22 == Task12: "Different Fibonacci values";
        int Task3 = action3.execute(n);
        int Task4 = action4.execute(A, B);


        System.out.println("[ Cycle ]\n\nFactorial of " + n + " is: " + Task11);
        System.out.println("Fibonacci of " + n + " is: " + Task12);
        System.out.println("\n[ Recursion ]\n\nFactorial of " + n + " is: " + Task21);
        System.out.println("Fibonacci of " + n + " is: " + Task22);
        System.out.println("\n[ Task 3] Sum of numbers:" + Task3);
        System.out.println("\n[ Task 4] Sum of numbers:" + Task4);
    }
}
