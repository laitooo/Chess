package zxc.laitooo.chess.peaces;

import android.util.Log;

import zxc.laitooo.chess.ChessMan;

/**
 * Created by Laitooo San on 15/06/2019.
 */

public class Rook extends ChessMan {

    public Rook(int position, int player) {
        super('r', position, player);
    }

    @Override
    public int[] getMoves(ChessMan[] peaces) {
        int p = getPosition();
        int[] moves = new int[]{p+7,p+14,p+21,p+28,p+35,p+42,p+49,p+9,p+18,p+27,p+36,p+45,p+54,p+63,
        p-7,p-14,p-21,p-28,p-35,p-42,p-49,p-9,p-18,p-27,p-36,p-45,p-54,p-63};
        int x = getPosition()%8;
        int y = getPosition()/8;

        for (int j=0;j<4;j++) {
            boolean blocked = false;
            for (int i = 7*j; i < 7*j+7; i++) {
                if (moves[i] < 0 || moves[i] > 63) {
                    moves[i] = 119;
                } else {
                    if (isWrong(x,y,moves[i])){
                        moves[i] = 119;
                    }else {
                        if (peaces[moves[i]].getPlayer() == getPlayer() || blocked) {
                            if (peaces[moves[i]].getPlayer() != 3) {
                                blocked = true;
                            }
                            moves[i] = 119;
                        }else {
                            if (peaces[moves[i]].getPlayer() != 3) {
                                blocked = true;
                            }
                        }

                    }
                }

            }
        }
        return moves;
    }

    private boolean isWrong(int x1,int y1,int position2){
        int x2 = position2%8;
        int y2 = position2/8;

        if (Math.abs(x1-x2) != Math.abs(y1-y2))
            return true;
        return false;
    }

    @Override
    public int getMovesNumber() {
        return 28;
    }
}
