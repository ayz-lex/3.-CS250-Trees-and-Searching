import java.util.*;

public class uniform_cost_search {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    //Implementation of Uniform Cost Search in order 
    int [][] matrix = new int[8][8];
    matrix[0][1] = 16;
    matrix[0][5] = 21;
    matrix[1][0] = 16;
    matrix[1][2] = 15;
    matrix[1][4] = 15;
    matrix[2][1] = 15;
    matrix[2][4] = 11;
    matrix[2][3] = 17;
    matrix[2][6] = 23;
    matrix[3][2] = 17;
    matrix[3][6] = 16;
    matrix[4][1] = 15;
    matrix[4][2] = 11;
    matrix[4][5] = 10;
    matrix[4][7] = 11;
    matrix[5][0] = 21;
    matrix[5][4] = 10;
    matrix[5][7] = 11;
    matrix[6][2] = 23;
    matrix[6][3] = 16;
    matrix[6][7] = 10;
    matrix[7][5] = 11;
    matrix[7][4] = 11;
    matrix[7][6] = 10;
    PriorityQueue<Town> pq = new PriorityQueue<Town>(new comparatorTown());
    boolean [] found = new boolean[8];
    int checker = 0;
    pq.add(new Town(0, 0));
    checker++;
    while (checker <= 8) {
      printString(pq.iterator());
      Town cur = pq.remove();
      int[] row = matrix[cur.town];
      for (int i = 0; i < row.length; i++) {
        int dist = row[i];
        if (dist != 0) {
          pq.add(new Town(i, dist + cur.distance));
        }
      }
      System.out.println("Removed the Town " + cur.town);
            
      if (!found[cur.town]) {
        found[cur.town] = true;
        checker++;
        System.out.println("Town " + cur.town + " is " + cur.distance + " away. FIRST TIME REMOVED");
      }
    }
  }
  
  public static void printString(Iterator<Town> iterator) {
    while(iterator.hasNext()) {
      Town cur = iterator.next();
      System.out.print(cur.town + ": " + cur.distance + ", ");
    }
    System.out.println();
  }
}

class comparatorTown implements Comparator<Town> {
  public int compare(Town first, Town second) {
    if (first.distance > second.distance) { 
      return 1; 
    } else if (first.distance == second.distance){
      return 0;
    } else {
      return -1;
    }
  }
}

class Town {
  public int town; 
  public int distance;
  public Town(int town, int distance) {
    this.town = town;
    this.distance = distance;
  }
}