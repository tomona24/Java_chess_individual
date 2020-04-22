package InfoInBoard_pieces;
import InfoInBoard_board.Pieces;
import java.util.HashSet;

public class PossibleMovementHelper {
    public PossibleMovementHelper() {}

    public HashSet<int[]> possibleMovementRook(int fromX, int fromY, boolean isWhite, Pieces pieces) {
        HashSet<int[]> list = new HashSet<>();
        // forward
        for (int i = fromY + 1; i < 8; i++) {
            if (pieces.getPieces()[fromX][i] != null) {
                if (pieces.getPieces()[fromX][i].getIsWhite() != isWhite) {
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
                if (pieces.getPieces()[fromX][i].getIsWhite() != isWhite) {
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
                if (pieces.getPieces()[i][fromY].getIsWhite() != isWhite) {
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
                if (pieces.getPieces()[i][fromY].getIsWhite() != isWhite) {
                    list.add(new int[]{i, fromY});
                }
                break;
            } else {
                list.add(new int[]{i, fromY});
            }
        }
        return list;
    }

    public HashSet possibleMovementBishop(int fromX, int fromY,  boolean isWhite, Pieces pieces) {
        HashSet<int[]> list = new HashSet<>();
        Piece[][] pieceList = pieces.getPieces();
        int kariX = fromX + 1;
        int kariY = fromY + 1;
        while (kariX < 8 && kariX > -1 && kariY > -1 && kariY < 8) {
            if (pieceList[kariX][kariY] == null) {
                list.add(new int[]{kariX++, kariY++});
            } else {
                if (pieceList[kariX][kariY].getIsWhite() != isWhite) {
                    list.add(new int[]{kariX, kariY});
                }
                break;
            }
        }
        kariX = fromX + 1;
        kariY = fromY - 1;
        while (kariX < 8 && kariX > -1 && kariY > -1 && kariY < 8) {
            if (pieceList[kariX][kariY] == null) {
                list.add(new int[]{kariX++, kariY--});
            } else {
                if (pieceList[kariX][kariY].getIsWhite() != isWhite) {
                    list.add(new int[]{kariX, kariY});
                }
                break;
            }
        }
        kariX = fromX - 1;
        kariY = fromY + 1;
        while (kariX < 8 && kariX > -1 && kariY > -1 && kariY < 8) {
            if (pieceList[kariX][kariY] == null) {
                list.add(new int[]{kariX--, kariY++});
            } else {
                if (pieceList[kariX][kariY].getIsWhite() != isWhite) {
                    list.add(new int[]{kariX, kariY});
                }
                break;
            }
        }
        kariX = fromX - 1;
        kariY = fromY - 1;
        while (kariX < 8 && kariX > -1 && kariY > -1 && kariY < 8) {
            if (pieceList[kariX][kariY] == null) {
                list.add(new int[]{kariX--, kariY--});
            } else {
                if (pieceList[kariX][kariY].getIsWhite() != isWhite) {
                    list.add(new int[]{kariX, kariY});
                }
                break;
            }
        }
        return list;
    }

}
