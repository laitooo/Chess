package zxc.laitooo.chess.peaces;

import zxc.laitooo.chess.ChessMan;

/**
 * Created by Laitooo San on 15/06/2019.
 */

public class Soldier extends ChessMan{


    public Soldier(int position, int player) {
        super('s',position, player);
    }

    @Override
    public int[] getMoves(ChessMan[] peaces) {
        int[] moves = new int[]{119,119,119,119,119,119,119,119,119,119};
        int counter = 0;
        int x = getPosition()%8;
        int y = getPosition()/8;


        if (getPlayer() == 1 ){
            if (y != 7){
                if (x == 0){
                    if (peaces[getPosition()+9].getPlayer() == 2){
                        moves[counter] = getPosition()+9;
                        counter++;
                    }
                    if (peaces[getPosition()+8].getPlayer() == 3){
                        moves[counter] = getPosition()+8;
                        counter++;
                    }
                }else if (x == 7){
                    if (peaces[getPosition()+7].getPlayer() == 2){
                        moves[counter] = getPosition()+7;
                        counter++;
                    }
                    if (peaces[getPosition()+8].getPlayer() == 3){
                        moves[counter] = getPosition()+8;
                        counter++;
                    }
                }else {
                    if (peaces[getPosition()+7].getPlayer() == 2){
                        moves[counter] = getPosition()+7;
                        counter++;
                    }
                    if (peaces[getPosition()+8].getPlayer() == 3){
                        moves[counter] = getPosition()+8;
                        counter++;
                    }
                    if (peaces[getPosition()+9].getPlayer() == 2){
                        moves[counter] = getPosition()+9;
                        counter++;
                    }
                }
            }

            if (y == 1){
                if (peaces[getPosition()+16].getPlayer() == 3 && peaces[getPosition()+8].getPlayer() == 3) {
                    moves[counter] = getPosition() + 16;
                }
            }
        }


        if (getPlayer()== 2){
            if (y != 0){
                if (x == 0){
                    if (peaces[getPosition()-7].getPlayer() == 1){
                        moves[counter] = getPosition()-7;
                        counter++;
                    }
                    if (peaces[getPosition()-8].getPlayer() == 3){
                        moves[counter] = getPosition()-8;
                        counter++;
                    }
                }else if (x == 7){
                    if (peaces[getPosition()-9].getPlayer() == 1){
                        moves[counter] = getPosition()-9;
                        counter++;
                    }
                    if (peaces[getPosition()-8].getPlayer() == 3){
                        moves[counter] = getPosition()-8;
                        counter++;
                    }
                }else {
                    if (peaces[getPosition()-7].getPlayer() == 1){
                        moves[counter] = getPosition()-7;
                        counter++;
                    }
                    if (peaces[getPosition()-8].getPlayer() == 3){
                        moves[counter] = getPosition()-8;
                        counter++;
                    }
                    if (peaces[getPosition()-9].getPlayer() == 1){
                        moves[counter] = getPosition()-9;
                        counter++;
                    }
                }
            }

            if (y == 6){
                if (peaces[getPosition()-16].getPlayer() == 3 && peaces[getPosition()-16].getPlayer() == 3) {
                    moves[counter] = getPosition() - 16;
                }
            }
        }
        return moves;

    }

    @Override
    public int getMovesNumber() {
        return 10;
    }
}
