import java.util.*;
import java.util.ArrayList;

//This code constructs juggling sequences based on parameters such as: min length, max length, and max height

public class Juggling
{
  private static int minL;
  private static int maxL;
  private static int maxH;
  private static int[][] arr;
  private static int[][] mini;
  public Juggling (int minLength, int maxLength, int maxHeight)
  {
    minL = minLength;
    maxL = maxLength;
    maxH = maxHeight;
  }
  public static int[][] jugglingArray(int L)
  {
    if (minL > maxL)
    {
      System.out.println("Minimum length cannot be greater than maximum length");
      System.exit(0);
    }
    arr = new int[L][L];
    for (int i = 0; i < L; i++)
    {
      for (int j = 0; j < L; j++)
      {
        arr[i][j] = (j-i + L)%L;
      }
    }
    return arr;
  }
  public static int[][] sizeDown(int[][] A, int c)
  {
    mini = new int[A.length-1][A.length-1];
    for (int i = 0; i < A.length; i++)
    {
      for (int j = 0; j < A.length; j++)
      {
        if (i>0 && j<c) mini[i-1][j] = A[i][j];
        if (i>0 && j>c) mini[i-1][j-1] = A[i][j];
      }
    }
    return mini;
  }
  
  public int rookPlace(int[][] board, ArrayList <Integer> sequence1)
  {
    if (board.length == 1) 
    {
        ArrayList<Integer> completed = new ArrayList<>(sequence1);
        completed.add(board[0][0]);
        if (board[0][0] < maxH)
        {
          int count = countExpansions(completed);
          System.out.println("Mod sequence "+completed+"->"+count+" valid expansions");
          return count;
        }
        return 0;
    }
    int subtotal = 0;
    for (int i = 0; i < board.length; i++)
     {
        ArrayList<Integer> sequence2 = new ArrayList<>(sequence1);
        sequence2.add(board[0][i]);
        int[][] smaller = sizeDown(board, i);
        if (board[0][i] < maxH)
          subtotal += rookPlace(smaller, sequence2);
    }
    return subtotal;
  }

  public void createSequences()
  {
    int total = 0;
    for (int i = minL; i < maxL + 1; i++)
    {
      jugglingArray(i);
      total += rookPlace(arr, new ArrayList<>());
    }
     System.out.println("Total number of valid juggling sequences (with max height < " + maxH + "): " + total);
  }

  public int countExpansions(ArrayList<Integer> modSeq) 
  {
    int n = 0;
    int m = 1;
    for (int i = 0; i < modSeq.size(); i++)
    {
      n = 0;
      int x = modSeq.get(i);
      while (x < maxH)
      {
        x = x + modSeq.size();
        n++;
      }
      m = m * n;
    }
    return m;
  }

  public void printArray(int[][]A)
  {
    for (int i = 0; i < A.length; i++)
    {
      for (int j = 0; j < A.length; j++)
      {
        System.out.print(A[i][j]);
        System.out.print(" ");
      }
      System.out.println("");
    }
  }

  public void listExpansions(ArrayList<Integer> modS)
  {
    System.out.println("Expansions of mod sequence: " + modS);
    listHelper(modS, 0, new ArrayList<>());
  }

  private void listHelper(ArrayList<Integer> modS, int i, ArrayList<Integer> current)
  {
    int d = modS.size();
    if (i == d) {
        System.out.println(current);
        return;
    }

    int target = modS.get(i);
    for (int h = 0; h < maxH; h++)
    {
        if (h % d == target)
        {
            ArrayList<Integer> next = new ArrayList<>(current);
            next.add(h);
            listHelper(modS, i + 1, next);
        }
    }
  }

  public static void main(String args[])
  {
    /*Juggling c = new Juggling(3, 4, 7);
    c.jugglingArray(minL);
    c.printArray(arr);
    System.out.println("");
    c.createSequences();
    c.listExpansions(new ArrayList<>(Arrays.asList(2,0,1,1)));*/

    if (args.length >= 3 && !args[0].equals("expand"))
    {
    int minL = Integer.parseInt(args[0]);
    int maxL = Integer.parseInt(args[1]);
    int maxH = Integer.parseInt(args[2]);

    Juggling c = new Juggling(minL, maxL, maxH);
    c.jugglingArray(minL);
    System.out.println("");
    c.createSequences();
    } 
    else if (args.length >= 2 && args[0].equals("expand"))
    {
    ArrayList<Integer> modSeq = new ArrayList<>();
       for (int i = 1; i < args.length - 1; i++)
        {
        modSeq.add(Integer.parseInt(args[i]));
        }
    int maxH = Integer.parseInt(args[args.length - 1]);
    Juggling c = new Juggling(modSeq.size(), modSeq.size(), maxH);
    c.listExpansions(modSeq);
    } 
    else
    {
    System.out.println("Invalid arguments.");
    }
  }
}
