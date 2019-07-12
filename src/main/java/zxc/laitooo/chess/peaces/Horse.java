package zxc.laitooo.chess.peaces;

import zxc.laitooo.chess.ChessMan;

/**
 * Created by Laitooo San on 15/06/2019.
 */

public class Horse extends ChessMan {

    public Horse(int position, int player) {
        super('h', position, player);
    }

    @Override
    public int[] getMoves(ChessMan[] peaces) {
        int p = getPosition();
        int[] moves = new int[]{p+10,p+17,p+6,p+15,p-6,p-15,p-10,p-17};
        int x = getPosition()%8;
        int y = getPosition()/8;

        for (int i=0;i<8;i++){
            if (moves[i] < 0 || moves[i] > 63){
                moves[i] = 119;
            }else {
                if (peaces[moves[i]].getPlayer() == getPlayer()){
                    moves[i] = 119;
                }
            }

            if (isWrong(x,y,moves[i])){
                moves[i] = 119;
            }
        }

        return moves;

    }

    private boolean isWrong(int x1,int y1,int position2){
        int x2 = position2%8;
        int y2 = position2/8;

        if (Math.abs(x1-x2) + Math.abs(y1-y2) >3)
            return true;
        return false;
    }

    @Override
    public int getMovesNumber() {
        return 8;
    }
}
