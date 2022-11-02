public class recursive {
    public static int knapSackRecursive(int[] weight, int[] profit, int capacity, int object){
        if (object<0 || capacity==0)
            return 0;
        if (weight[object]>capacity)
            return knapSackRecursive(weight,profit,capacity,object-1);
        else {
            return maxOf3(knapSackRecursive(weight,profit,capacity,object-1),knapSackRecursive(weight,profit,capacity-weight[object],object-1)+profit[object],knapSackRecursive(weight,profit,capacity-weight[object],object)+profit[object]);
        }
    }

    public static int maxOf3(int a, int b, int c){
        if (a>b && a>c)
            return a;
        else if (b>a && b>c)
            return b;
        else
            return c;
    }
}
