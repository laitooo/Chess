package zxc.laitooo.chess;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import zxc.laitooo.chess.peaces.Empty;
import zxc.laitooo.chess.peaces.King;

/**
 * Created by Laitooo San on 17/06/2019.
 */

public class CheckMate {

    int MAXIMUM_AMOUNT_OF_MOVES = 232;

    Context c;
    TextView result;

    public CheckMate(Context c, TextView result) {
        this.c = c;
        this.result = result;
    }

    public boolean isChecked(ChessMan[] men, int player,boolean tmp){
        if(!tmp)
            result.setText("");
        try {
            King king = getKing(men, player);
            int position = king.getPosition();

            for (int i = 0; i < men.length; i++) {
                if (men[i].getPlayer() != player && men[i].getPlayer() != 3) {
                    int[] moves = men[i].getMoves(men);
                    for (int j = 0; j < moves.length; j++) {
                        if (moves[j] == position) {
                            //Toast.makeText(context,"Player " + player +
                            if (!tmp)
                                result.setText("Check");
                            return true;
                        }
                    }
                }
            }
        }catch (Exception e){
            Log.e("ERRROR","ERERERER");
            return false;
        }

        return false;
    }

    public King getKing(ChessMan[] peaces,int player){
        King king = null;

        for (int i =0; i<peaces.length;i++){
            if (peaces[i].getPlayer() == player && peaces[i].getType() == 'k'){
                king = (King)peaces[i];
            }
        }

        return king;
    }

    public boolean isGameOver(ChessMan[] peaces,int player){
        King man = getKing(peaces,player);
        int[] moves = man.getMoves(peaces);
        for (int i=0;i<moves.length;i++){
            if (moves[i] != 119){
                return false;
            }
        }
        Log.e("GAME","OVER");
        return true;
    }

    public boolean checkIfDefense(ChessMan[] peaces,int player,boolean isTmp){
        Log.e("CHECK","Started");
        //int[] saving = new int[]{119,119,119,119,119,119,119,119,119,119};
        //int counter = 0;
        for (ChessMan man:peaces){

            if ( man.getPlayer() == player && man.getType() != 'k'){
                //int[] moves_enemy = peaces[j].getMoves(peaces);
                for (int move:man.getMoves(peaces)){
                    if (move != 119){
                        ChessMan[] tmp = copyBoard(peaces);
                        tmp[move] = man.getMan(man.getType(),move,man.getPlayer());
                        tmp[man.getPosition()] = new Empty(man.getPosition());

                        if (!isChecked(tmp,player,true)) {
                            Log.e("SAVING MOVE","man:" + man.getPosition() + " type:" + man.getType() + " move:" + move);
                            return true;
                        }
                    }
                }
            }
        }

        if (isTmp)
            result.setText("Check Mate");
        return false;
    }

    public ChessMan[] copyBoard(ChessMan[] peaces){
        ChessMan[] chessMen = new ChessMan[peaces.length];
        for (int i = 0; i < chessMen.length; i++) {
            chessMen[i] = peaces[i];
        }
        return chessMen;
    }
}
