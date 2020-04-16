import java.util.*;

public class boxes {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    //part a
    System.out.println(fAndT(new String[] {"T", "T", "x", "F", "F"}, 0));
    //would print 0, which means toad won.

    //part b
    System.out.println(fAndT(new String[] {"T", "T", "T", "x", "x", "F", "F", "F"}, 0));
    //would print 0, which means toad won.

    //part 3
    System.out.println(fAndT(new String[] {"T", "T", "T", "T", "x", "x", "x", "F", "F", "F", "F"}, 0));
    //would print 0, which means toad won.

  }
  
  public static int fAndT(String[] state, int move) {
    //toad turn
    ArrayList<String[]> moves = new ArrayList<>();
    if (move % 2 == 0) {
      for (int i = 0; i < state.length - 1; i++) {
        if (state[i] == "T") {
          if (state[i + 1] == "x") {
            String[] newState = state.clone();
            newState[i] = "x";
            newState[i + 1] = "T";
            moves.add(newState);
          } else if (i < state.length - 2 && state[i + 1] == "F" && state[i + 2] == "x") {
            String[] newState = state.clone();
            newState[i] = "x";
            newState[i + 2] = "T";
            moves.add(newState);
          }
        }
      }
    //frog turn
    } else {
      for (int i = 1; i < state.length; i++) {
        if (state[i] == "F") {
          if (state[i - 1] == "x") {
            String[] newState = state.clone();
            newState[i] = "x";
            newState[i - 1] = "F";
            moves.add(newState);
          } else if (i > 1 && state[i - 1] == "T" && state[i - 2] == "x") {
            String[] newState = state.clone();
            newState[i] = "x";
            newState[i - 2] = "F";
            moves.add(newState);
          }
        }
      }
    }
    if (moves.isEmpty()) {
      return move % 2 == 0 ? 1 : 0;
    } else {
      if (move % 2 == 0) {
        for (int i = 0; i < moves.size(); i++) {
          if (fAndT(moves.get(i), move + 1) == 0) {
            return 0;
          }
        }
        return 1;
      } else {
        for (int i = 0; i < moves.size(); i++) {
          if (fAndT(moves.get(i), move + 1) == 1) {
            return 1;
          }
        }
        return 0;
      }
    }
  }
}