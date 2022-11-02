import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int objNum;
        System.out.print("Enter the number of objects: ");
        objNum = scanner.nextInt();
        int[] objectArray = new int[objNum];

        int[] weightArray = new int[objNum];
        for (int i = 0; i < objNum; i++) {
            System.out.print("Enter the weight for object " + (i+1) + ": ");
            weightArray[i] = scanner.nextInt();
        }
    }
}