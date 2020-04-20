package InfoInBoard_pieces;

import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(boolean isWhite) {
        super( isWhite);
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♕";
        }
        return "♛";
    }



    @Override
    public ArrayList possibleMovement(int fromX, int fromY, Pieces pieces) {
        ArrayList<int[]> list = new ArrayList<>();
        int kariX = fromX + 1;
        int kariY = fromY + 1;
        Piece[][] pieceList = pieces.getPieces();
        while (kariX < 8 || kariY < 8) {
            if (pieceList[kariX][kariY] == null) {
                list.add(new int[]{kariX++, kariY++});
            } else {
                if (pieceList[kariX][kariY].getIsWhite() != getIsWhite()) {
                    list.add(new int[]{kariX, kariY});
                }
                break;
            }
        }
        kariX = fromX + 1;
        kariY = fromY - 1;
        while (kariX < 8 || kariY > -1) {
            if (pieceList[kariX][kariY] == null) {
                list.add(new int[]{kariX++, kariY--});
            } else {
                if (pieceList[kariX][kariY].getIsWhite() != getIsWhite()) {
                    list.add(new int[]{kariX, kariY});
                }
                break;
            }
        }
        kariX = fromX - 1;
        kariY = fromY + 1;
        while (kariX > -1 || kariY < 8) {
            if (pieceList[kariX][kariY] == null) {
                list.add(new int[]{kariX--, kariY++});
            } else {
                if (pieceList[kariX][kariY].getIsWhite() != getIsWhite()) {
                    list.add(new int[]{kariX, kariY});
                }
                break;
            }
        }
        kariX = fromX - 1;
        kariY = fromY - 1;
        while (kariX > -1 || kariY > -1) {
            if (pieceList[kariX][kariY] == null) {
                list.add(new int[]{kariX--, kariY--});
            } else {
                if (pieceList[kariX][kariY].getIsWhite() != getIsWhite()) {
                    list.add(new int[]{kariX, kariY});
                }
                break;
            }
        }

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
//
//    @Override
//    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
//        if(!super.isValidMove(fromX, fromY, toX, toY)){
//            return false;
//        }
//        boolean sameX = fromX == toX;
//        boolean sameY = fromY == toY;
//        boolean from = fromX % 2 == 0 && fromY == 0;
//        boolean to = toX % 2 == 0 && toY == 0;
//
//        return (from && to) || (!from && !to) || sameX || sameY;
//    }


}
