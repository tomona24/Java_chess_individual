package InfoInBoard_pieces;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♖";
        }
        return "♜";
    }

    @Override
    public ArrayList<int[]> possibleMovement(int fromX, int fromY, Pieces pieces) {
        ArrayList<int[]> list = new ArrayList<>();
        // forward
        for (int i = fromY + 1; i < 8; i++) {
            if (pieces.getPieces()[fromX][i] != null) {
                if (pieces.getPieces()[fromX][i].getIsWhite() != getIsWhite()) {
                    list.add(new int[]{fromX, i});
                }
                break;
            } else {
                list.add(new int[]{fromX, i});
            }
        }
        // back
        for (int i = fromY - 1; i > -1; i--) {
            if (pieces.getPieces()[fromX][i] != null) {
                if (pieces.getPieces()[fromX][i].getIsWhite() != getIsWhite()) {
                    list.add(new int[]{fromX, i});
                }
                break;
            } else {
                list.add(new int[]{fromX, i});
            }
        }
        // right
        for (int i = fromX + 1; i < 8; i++) {
            if (pieces.getPieces()[i][fromY] != null) {
                if (pieces.getPieces()[i][fromY].getIsWhite() != getIsWhite()) {
                    list.add(new int[]{i, fromY});
                }
                break;
            } else {
                list.add(new int[]{i, fromY});
            }
        }

        // left
        for (int i = fromX - 1; i > -1; i--) {
            if (pieces.getPieces()[i][fromY] != null) {
                if (pieces.getPieces()[i][fromY].getIsWhite() != getIsWhite()) {
                    list.add(new int[]{i, fromY});
                }
                    break;
                } else {
                list.add(new int[]{i, fromY});
            }
        }
        return list;
    }

}
