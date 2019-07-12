package zxc.laitooo.chess.peaces;

import android.util.Log;

import zxc.laitooo.chess.ChessMan;

/**
 * Created by Laitooo San on 15/06/2019.
 */

public class King extends ChessMan {
    int MAXIMUM_AMOUNT_OF_MOVES = 232;

    public King(int position, int player) {
        super('k',position, player);
    }

    @Override
    public int[] getMoves(ChessMan[] peaces) {
        int p = getPosition();
        int[] moves = new int[]{p+1,p+7,p+8,p+9,p-1,p-7,p-8,p-9};
        int x = getPosition()%8;
        int y = getPosition()/8;

        int[] enemy_moves = getAllMoves(peaces);

        for (int i=0;i<8;i++){
            if (moves[i] < 0 || moves[i] > 63){
                moves[i] = 119;
            }else {
                if (peaces[moves[i]].getPlayer() == getPlayer()){
                    moves[i] = 119;
                }else {
                    if (isWrong(x,y,moves[i])){
                        moves[i] = 119;
                    }else {
                        if (contain(enemy_moves,moves[i])){
                            moves[i] = 119;
                        }
                    }
                }
            }
        }

        return moves;

    }

    public boolean contain(int[] ints,int i){
        for (int a:ints){
            if (a == i){
                return true;
            }
        }
        return false;
    }

    public int[] getAllMoves(ChessMan[] peaces){
        int[] moves = new int[MAXIMUM_AMOUNT_OF_MOVES];
        int counter = 0;
        for (int j=0;j<peaces.length;j++){
            if (peaces[j].getPlayer() != 3 && peaces[j].getPlayer() != getPlayer() && peaces[j].getType() != 'k'){
                //int[] moves_enemy = peaces[j].getMoves(peaces);
                for (int move:peaces[j].getMoves(peaces)){
                    if (move != 119){
                        moves[counter] = move;
                        counter++;
                    }
                }
            }
        }
        //moves[counter] = 119;
        //Log.e("CO","c" + counter);
        return moves;
    }

    private boolean isWrong(int x1,int y1,int position2){
        int x2 = position2%8;
        int y2 = position2/8;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2) > 2;
    }

    @Override
    public int getMovesNumber() {
        return 8;
    }

}
