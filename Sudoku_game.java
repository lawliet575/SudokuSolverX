import java.util.Scanner;

/**
 * Sudoku
 */
public class Sudoku {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arr={  
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9} 
    };

         while (checkifgridfull(arr)) {
            System.out.println("Updated grid is : ");
            showgrid(arr);
            System.out.println("Input row and column");
            int row= input.nextInt();
            int col= input.nextInt();
            if(arr[row][col]!=0){ 
                System.out.println("Enter valid row and column");
                continue; //aage loop nahi chalega instead loop goes back to while statement
            }
            
            System.out.println("Enter number");
            int n=input.nextInt();
            if(issafe(row,col,arr,n)){ // test rowcheck colcheck 3x3 check teeno sahi toh true wrna false
                arr[row][col]=n;
            }
            else System.out.println("Wrong number, try another number");
                
         }


    }

   public static boolean checkifgridfull(int[][] currentarray){ //checking whether grid full or not
     for(int i=0;i<currentarray.length;i++){ 
        for(int j=0;j<currentarray[0].length;j++){ 
            if(currentarray[i][j]==0)
            return true; // 0 mil gaya yani while loop chalta rahega
        }
     }
     return false; // 0 nahi mila while loop breaks and sudoku game completes
   }

  public static void showgrid(int[][] currentarray){ //to output sudoku grid
     for (int i=0;i<currentarray.length;i++){ 
        for(int j=0;j<currentarray[0].length;j++){ 
            System.out.print(currentarray[i][j]+","+" ");
        }
        System.out.println();
     }
     
  }

  public static boolean issafe(int row, int col,int arr[][], int number){ 
        for(int i=0;i<arr.length;i++) // vertical line check --> |
          if(arr[i][col]==number)
          return false;
        
        
        for(int j=0;j<arr[col].length;j++)
            if(arr[row][j]==number)   // horizontal line check --> -----
            return false;
  
            int startRow = row - row % 3, startCol= col - col % 3; //3x3 box check
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (arr[i + startRow][j + startCol] == number)
                    return false;
        
        return true;
    
  }


}