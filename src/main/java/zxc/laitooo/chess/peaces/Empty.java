package zxc.laitooo.chess.peaces;

import zxc.laitooo.chess.ChessMan;

/**
 * Created by Laitooo San on 15/06/2019.
 */

public class Empty extends ChessMan {

    public Empty(int position) {
        super('-',position,3);
    }

    @Override
    public int[] getMoves(ChessMan[] peaces) {
        int[] moves = new int[]{};
        int x = getPosition()%8;
        int y = getPosition()/8;
        if (getPlayer()==1){
            if (y != 0){
                if (x == 0){
                    if (peaces[getPosition()-7].getPlayer() == 2){
                        moves[moves.length] = getPosition()-7;
                    }
                    if (peaces[getPosition()-8].getPlayer() != 1){
                        moves[moves.length] = getPosition()-8;
                    }
                }else if (x == 7){
                    if (peaces[getPosition()-9].getPlayer() == 2){
                        moves[moves.length] = getPosition()-9;
                    }
                    if (peaces[getPosition()-8].getPlayer() != 1){
                        moves[moves.length] = getPosition()-8;
                    }
                }else {
                    if (peaces[getPosition()-7].getPlayer() == 2){
                        moves[moves.length] = getPosition()-7;
                    }
                    if (peaces[getPosition()-8].getPlayer() != 1){
                        moves[moves.length] = getPosition()-8;
                    }
                    if (peaces[getPosition()-9].getPlayer() == 2){
                        moves[moves.length] = getPosition()-9;
                    }
                }
            }

            if (y == 6){
                if (peaces[getPosition()-16].getPlayer() != 1) {
                    moves[moves.length] = getPosition() - 16;
                }
            }
        }
        return moves;

    }
}
