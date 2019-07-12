package zxc.laitooo.chess.peaces;

import zxc.laitooo.chess.ChessMan;

/**
 * Created by Laitooo San on 15/06/2019.
 */

public class Castle extends ChessMan {

    public Castle(int position, int player) {
        super('c', position, player);
    }

    @Override
    public int[] getMoves(ChessMan[] peaces) {
        int p = getPosition();
        int[] moves = new int[]{p+8,p+16,p+24,p+32,p+40,p+48,p+56,p+1,p+2,p+3,p+4,p+5,p+6,p+7,
                p-8,p-16,p-24,p-32,p-40,p-48,p-56,p-1,p-2,p-3,p-4,p-5,p-6,p-7};
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

        return !(Math.abs(x1 - x2) == 0 || Math.abs(y1 - y2) == 0);
    }

    @Override
    public int getMovesNumber() {
        return 28;
    }
}
