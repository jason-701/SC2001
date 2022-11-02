import java.lang.Math;
public class bottomUp {
    static int[][] knapSackBottomUp(int[] weight, int capacity,int[] profit, int objNum){
        int[][] array = new int[objNum+1][capacity+1];
        for (int i = 0; i < capacity+1; i++) {
            array[0][i]=0;
        }
        for (int i = 0; i < objNum + 1; i++) {
            array[i][0]=0;
        }
        for (int i = 1; i < objNum+1; i++) {
            for (int j = 1; j < capacity+1; j++) {
                array[i][j] = array[i-1][j];
                if (j>=weight[i-1]){
                    if (array[i][j]<array[i-1][j-weight[i-1]]+profit[i-1]){
                        array[i][j]=array[i-1][j-weight[i-1]]+profit[i-1];
                    }
                }
            }
        }
        return array;
    }

}
