import java.util.*;

public class Boxes {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(theBoxRR(new boolean[] {false, false, false, false, false, false, false}, 0, 0));
  }

  public static int theBoxRR(boolean[] state, int move, int score) {
    ArrayList<Integer> scores = new ArrayList<>();
 
    for (int i = 0; i < state.length; i++) {
      if (state[i] == false) {
        boolean[] newState = state.clone();
        newState[i] = true;
        int scoreChange = check(newState, i, move);
        int thisScore = scoreChange != 0 ? theBoxRR(newState, move, score + scoreChange) : theBoxRR(newState, move + 1, score);
        scores.add(thisScore);
      }
    }
    
    if (scores.isEmpty()) {
      return score;
    } else {
      int win = scores.get(0);
      if (move % 2 == 0) {
        for (int i = 1; i < scores.size(); i++) {
          int curScore = scores.get(i);
          if (curScore > win) {
            win = curScore;
          }
        }
      } else {
        for (int i = 1; i < scores.size(); i++) {
          int curScore = scores.get(i);
          if (curScore < win) {
            win = curScore;
          }
        }
      }
      return win;
    }
  }
  private static int check(boolean[] state, int add, int move) {
    int val = 0;
    switch(add) {
    case 0: { 
      if (state[1] == true && state[2] == true && state[3] == true) {
        val++;
      }
      break;
    }
    case 1: {
      if (state[0] == true && state[2] == true && state[3] == true) {
        val++;
      }
      break;
    }
    case 2: { 
      if (state[0] == true && state[1] == true && state[3] == true) {
        val++;
      }
      break;
    }
    case 3: { 
      if (state[0] == true && state[1] == true && state[2] == true) {
        val++;
      }
      if (state[4] == true && state[5] == true && state[6] == true) {
        val++;
      }
      break;
    }
    case 4: {
      if (state[3] == true && state[5] == true && state[6] == true) {
        val++;
      }
      break;
    }
    case 5: { 
      if (state[3] == true && state[4] == true && state[6] == true) {
        val++;
      }
      break;
    }
    case 6: {
      if (state[3] == true && state[4] == true && state[5] == true) {
        val++;
      }
      break;
    }
    }
    return move % 2 == 0 ? val : -val;
  }
}
