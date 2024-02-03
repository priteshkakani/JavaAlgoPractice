package practice;

public class Interview3{
    public static void main(String[] args){
        int[] arr = {1,0,0,0,1,0,0,0,1};
        int[] arr1 = {1,0,0,0,1,0,0,-1,1};
        int[] arr2 = {1,0,0,0,1,0,0,0,1,0,0,1};
        // to convert into matrix
        // matrix[i][j] == matrix[j][i]
        // O(n2) time complexity
        int flag = 0;
        int iterator = 0;
        int len = 0;
        for(int i =1;i<arr2.length/2;i++){
            if(i*i == arr2.length) {
                len = i;
                flag = 0;
                break;
            }
            else {
                flag = -1;
            }
        }
        int[][] matrix = new int[len][len];
        for(int i =0;i<len;i++){
            for(int j =0;j<len;j++) {
                matrix[i][j] = arr2[iterator++];
            }
        }
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] != matrix[j][i]) {
                    flag = -1;
                }
            }
        }
        if(flag == 0)
            System.out.println("Symmetric");
        else
            System.out.println("Not Symmetric");
    }
}
