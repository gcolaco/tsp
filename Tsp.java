import java.util.Scanner;
import java.util.*;

public class Tsp {

    static int dist = 0;
    static boolean visited[];

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int tam = scan.nextInt();

        visited = new boolean[tam];
        int[][] adjMatrix = new int[tam][tam];
        
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                adjMatrix[i][j] = scan.nextInt();
            }
            visited[i] = false;
        }
        
       // showQuadMatrix(adjMatrix, tam);


        min_dist(adjMatrix, 0, tam);

        System.out.println("valor: " + dist);
        
        scan.close();

    }
    
    public static void showQuadMatrix(int matrix[][], int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int min_dist(int matrix[][], int c, int tam){
        int near_city;
        visited[c] = true;

        near_city = nearest_city(matrix, c, tam);

        if(near_city != Integer.MAX_VALUE){
            near_city = 0;
            
            dist += matrix[c][near_city];
            return 0;
        }

        min_dist(matrix, near_city, tam);

        return 0;
    }

    public static int nearest_city(int matrix[][], int c, int tam){

        int nearest = Integer.MAX_VALUE, min = Integer.MAX_VALUE, temp = 0;

        for(int i = 0; i < tam; i++){
            
            if((matrix[c][i] != 0) && !visited[i]){
                
                if(matrix[c][i] < min){
                    min = matrix[i][c] + matrix[c][i];
                    nearest = i;
                }
                temp = matrix[c][i];
            }
        }

        if(min != Integer.MAX_VALUE){
            dist += temp;
        }

        return nearest;
    }


}






















