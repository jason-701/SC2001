import java.util.Arrays;

import java.util.*;
import java.io.File;
import java.io.FileOutputStream;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Main
{
    public static int key_comparisons=0;
    public static void print_Rand_array(int[] arr){
        for (int i=0;i<arr.length;i++){

            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void create_array(int[] arr, int largest){
        Random rand= new Random(System.currentTimeMillis());
        for(int i=0; i<arr.length; i++)
        {
            arr[i]= rand.nextInt(largest);
        }
    }
    public static void main(String[] args) throws Exception
    {
        // an array that takes in randostmised values
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the max size of the elements: ");
        int largest = scanner.nextInt();
        System.out.print("Enter the size of the array: ");
        int SIZE = scanner.nextInt();
        System.out.print("Enter the size threshold: ");
        int S = scanner.nextInt();
        int[] numarray= new int[SIZE];
        create_array(numarray,largest);

        int choice;
        System.out.println("Sorting algorithms: ");
        System.out.println("1: Insertion sort");
        System.out.println("2: Mergesort");
        System.out.println("3: Hybrid sort");
        System.out.println("4: Change threshold");
        System.out.println("5: Change max element size");
        choice = scanner.nextInt();
        int[] arr = Arrays.copyOfRange(numarray,0,numarray.length);
        while(choice>0 && choice<6){
            if (choice==1){
                long start, end, timecomplex;
                start= System.nanoTime();
                arr = Arrays.copyOfRange(numarray,0,numarray.length);
                //call the function here
                insertion_sort.sort(arr,arr.length);
                end= System.nanoTime();
                timecomplex= end-start;
                System.out.println("Insertion Sort");
                //print_Rand_array(arr);
                System.out.println("Array Size: " + SIZE); // test and change from 1000 to 10 million
                System.out.println("Threshold (S): "+ S);
                System.out.println("Time Complexity (ns): "+ timecomplex );
                System.out.println("Key Comparisons: " + key_comparisons);
                key_comparisons=0;
            }
            if (choice==2){
                long start, end, timecomplex;
                start= System.nanoTime();
                arr = Arrays.copyOfRange(numarray,0,numarray.length);
                //call the function here
                merge_sort.sort(arr,0,arr.length-1);
                end= System.nanoTime();
                timecomplex= end-start;
                System.out.println("Merge Sort");
                //print_Rand_array(arr);
                System.out.println("Array Size: " + SIZE); // test and change from 1000 to 10 million
                System.out.println("Threshold (S): "+ S);
                System.out.println("Time Complexity (ns): "+ timecomplex );
                System.out.println("Key Comparisons: " + key_comparisons);
                key_comparisons=0;
            }
            if (choice==3){
                long start, end, timecomplex;
                start= System.nanoTime();
                arr = Arrays.copyOfRange(numarray,0,numarray.length);
                //call the function here
                new_sort.sort(arr,S);
                end= System.nanoTime();
                timecomplex= end-start;
                System.out.println("Hybrid Sort");
                //print_Rand_array(arr);
                System.out.println("Array Size: " + SIZE); // test and change from 1000 to 10 million
                System.out.println("Threshold (S): "+ S);
                System.out.println("Time Complexity (ns): "+ timecomplex );
                System.out.println("Key Comparisons: " + key_comparisons);
                key_comparisons=0;
            }
            if (choice==4){
                System.out.print("Enter new threshold: ");
                S = scanner.nextInt();
            }
            if (choice==5){
                largest = scanner.nextInt();
                create_array(numarray,largest);
            }
            choice = scanner.nextInt();
        }*/
        int[] numarray = new int[10000000];
        int count,threshold;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet( "hybrid sort");
        XSSFRow row;
        Map < String, Object[] > data = new TreeMap < String, Object[] >();
        count = 1;
        data.put( String.valueOf(count), new Object[] {
                "Key comparisons"});
        Set < String > keyid = data.keySet();
        int rowid = 0;  //starting row

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = data.get(key);
            int cellid = 0;  //starting column

            for (Object obj : objectArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        while (count<=100){
            create_array(numarray,100000000);
            new_sort.sort(numarray,25);
            data.put( String.valueOf(count), new Object[] {
                    String.valueOf(key_comparisons)});
            keyid = data.keySet();
            rowid = 1;  //starting row

            for (String key : keyid) {
                row = spreadsheet.createRow(rowid++);
                Object [] objectArr = data.get(key);
                int cellid = 0;  //starting column

                for (Object obj : objectArr){
                    Cell cell = row.createCell(cellid++);
                    cell.setCellValue((String)obj);
                }
            }
            key_comparisons=0;
            count++;
        }

        FileOutputStream out = new FileOutputStream(
                new File("C:/Users/ROG//Desktop/results/threshold_25_changing_array_size/size10000000threshold25.xlsx"));

        workbook.write(out);
        out.close();
    }


}