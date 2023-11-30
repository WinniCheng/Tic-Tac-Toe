package hk.edu.hkmu.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardClass {
    private int[] boxPositions; //9 zero
    final static int PLAYER_ONE = 1;
    final static int PLAYER_TWO = 2;
    private final List<int[]> combinationList = new ArrayList<>();

    public BoardClass() {
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0};
        combinationList.add(new int[] {0,1,2});
        combinationList.add(new int[] {3,4,5});
        combinationList.add(new int[] {6,7,8});
        combinationList.add(new int[] {0,3,6});
        combinationList.add(new int[] {1,4,7});
        combinationList.add(new int[] {2,5,8});
        combinationList.add(new int[] {2,4,6});
        combinationList.add(new int[] {0,4,8});
    }

    public void setBoxPosition(int selectedBoxPosition, int playerTurn) {
        boxPositions[selectedBoxPosition] = playerTurn;
    }

    public int getBoxPosition(int selectedBoxPosition) {
        return boxPositions[selectedBoxPosition];
    }

    public boolean isBoxSelectable(int selectedBoxPosition) {
        return boxPositions[selectedBoxPosition] == 0;
    }

    public boolean checkResults() {
        for (int[] combination : combinationList) {
            if (boxPositions[combination[0]] == boxPositions[combination[1]] && boxPositions[combination[1]] == boxPositions[combination[2]] && boxPositions[combination[0]] != 0) {
                return true;
            }
        }
        return false;
    }

    public void restartMatch() {
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0};
    }
}
