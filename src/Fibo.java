import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }
    static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
    @Override
    public boolean run(Scanner sc) {
        System.out.println("Enter number :");
        int nb = sc.nextInt();
        sc.nextLine();
        System.out.println("Fibo : " + fibo(nb));
        return true;
    }
}