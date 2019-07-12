package zxc.laitooo.chess;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import zxc.laitooo.chess.peaces.Castle;
import zxc.laitooo.chess.peaces.Empty;
import zxc.laitooo.chess.peaces.Horse;
import zxc.laitooo.chess.peaces.King;
import zxc.laitooo.chess.peaces.Minister;
import zxc.laitooo.chess.peaces.Rook;
import zxc.laitooo.chess.peaces.Soldier;

public class PlayActivity extends AppCompatActivity {

    static ChessPeace[] areas;
    static ChessMan[] men;
    static Context c;
    static boolean isSelected;
    static int selectedPosition;
    static boolean isPlayerOne;
    static boolean isPlayerOneChecked = false;
    static boolean isPlayerTwoChecked = false;
    static android.app.FragmentManager fragmentManager;

    char SOLDIER = 's';
    char KING = 'k';
    char MINISTER = 'm';
    char CASTLE = 'c';
    char HORSE = 'h';
    char ROOK = 'r';
    char EMPTY = '-';


    static CheckMate checkMate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        isSelected = false;
        selectedPosition = 111;
        isPlayerOne = true;
        c = PlayActivity.this;
        checkMate = new CheckMate(c,(TextView)findViewById(R.id.check_mate));
        LinearLayout board = (LinearLayout)findViewById(R.id.chess_board);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int dw = dm.widthPixels;
        int dh = dm.heightPixels;
        fragmentManager = getFragmentManager();

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dw,dw);
        layoutParams.setMargins(0,(int)(dh-dw)/2,0,0);
        board.setLayoutParams(layoutParams);


        areas = new ChessPeace[64];
        areas[0] = (ChessPeace)findViewById(R.id.a1);
        areas[1] = (ChessPeace)findViewById(R.id.a2);
        areas[2] = (ChessPeace)findViewById(R.id.a3);
        areas[3] = (ChessPeace)findViewById(R.id.a4);
        areas[4] = (ChessPeace)findViewById(R.id.a5);
        areas[5] = (ChessPeace)findViewById(R.id.a6);
        areas[6] = (ChessPeace)findViewById(R.id.a7);
        areas[7] = (ChessPeace)findViewById(R.id.a8);

        areas[8] = (ChessPeace)findViewById(R.id.b1);
        areas[9] = (ChessPeace)findViewById(R.id.b2);
        areas[10] = (ChessPeace)findViewById(R.id.b3);
        areas[11] = (ChessPeace)findViewById(R.id.b4);
        areas[12] = (ChessPeace)findViewById(R.id.b5);
        areas[13] = (ChessPeace)findViewById(R.id.b6);
        areas[14] = (ChessPeace)findViewById(R.id.b7);
        areas[15] = (ChessPeace)findViewById(R.id.b8);

        areas[16] = (ChessPeace)findViewById(R.id.c1);
        areas[17] = (ChessPeace)findViewById(R.id.c2);
        areas[18] = (ChessPeace)findViewById(R.id.c3);
        areas[19] = (ChessPeace)findViewById(R.id.c4);
        areas[20] = (ChessPeace)findViewById(R.id.c5);
        areas[21] = (ChessPeace)findViewById(R.id.c6);
        areas[22] = (ChessPeace)findViewById(R.id.c7);
        areas[23] = (ChessPeace)findViewById(R.id.c8);

        areas[24] = (ChessPeace)findViewById(R.id.d1);
        areas[25] = (ChessPeace)findViewById(R.id.d2);
        areas[26] = (ChessPeace)findViewById(R.id.d3);
        areas[27] = (ChessPeace)findViewById(R.id.d4);
        areas[28] = (ChessPeace)findViewById(R.id.d5);
        areas[29] = (ChessPeace)findViewById(R.id.d6);
        areas[30] = (ChessPeace)findViewById(R.id.d7);
        areas[31] = (ChessPeace)findViewById(R.id.d8);

        areas[32] = (ChessPeace)findViewById(R.id.e1);
        areas[33] = (ChessPeace)findViewById(R.id.e2);
        areas[34] = (ChessPeace)findViewById(R.id.e3);
        areas[35] = (ChessPeace)findViewById(R.id.e4);
        areas[36] = (ChessPeace)findViewById(R.id.e5);
        areas[37] = (ChessPeace)findViewById(R.id.e6);
        areas[38] = (ChessPeace)findViewById(R.id.e7);
        areas[39] = (ChessPeace)findViewById(R.id.e8);

        areas[40] = (ChessPeace)findViewById(R.id.f1);
        areas[41] = (ChessPeace)findViewById(R.id.f2);
        areas[42] = (ChessPeace)findViewById(R.id.f3);
        areas[43] = (ChessPeace)findViewById(R.id.f4);
        areas[44] = (ChessPeace)findViewById(R.id.f5);
        areas[45] = (ChessPeace)findViewById(R.id.f6);
        areas[46] = (ChessPeace)findViewById(R.id.f7);
        areas[47] = (ChessPeace)findViewById(R.id.f8);

        areas[48] = (ChessPeace)findViewById(R.id.g1);
        areas[49] = (ChessPeace)findViewById(R.id.g2);
        areas[50] = (ChessPeace)findViewById(R.id.g3);
        areas[51] = (ChessPeace)findViewById(R.id.g4);
        areas[52] = (ChessPeace)findViewById(R.id.g5);
        areas[53] = (ChessPeace)findViewById(R.id.g6);
        areas[54] = (ChessPeace)findViewById(R.id.g7);
        areas[55] = (ChessPeace)findViewById(R.id.g8);

        areas[56] = (ChessPeace)findViewById(R.id.h1);
        areas[57] = (ChessPeace)findViewById(R.id.h2);
        areas[58] = (ChessPeace)findViewById(R.id.h3);
        areas[59] = (ChessPeace)findViewById(R.id.h4);
        areas[60] = (ChessPeace)findViewById(R.id.h5);
        areas[61] = (ChessPeace)findViewById(R.id.h6);
        areas[62] = (ChessPeace)findViewById(R.id.h7);
        areas[63] = (ChessPeace)findViewById(R.id.h8);

        men = new ChessMan[64];
        men[0] = new Castle(0,1);
        men[7] = new Castle(7,1);
        men[56] = new Castle(56,2);
        men[63] = new Castle(63,2);
        men[1] = new Horse(1,1);
        men[6] = new Horse(6,1);
        men[57] = new Horse(57,2);
        men[62] = new Horse(62,2);
        men[2] = new Rook(2,1);
        men[5] = new Rook(5,1);
        men[58] = new Rook(58,2);
        men[61] = new Rook(61,2);
        men[3] = new Minister(3,1);
        men[59] = new Minister(59,2);
        men[4] = new King(4,1);
        men[60] = new King(60,2);

        for (int i=0;i<8;i++) {
            men[8 + i] = new Soldier(8 + i, 1);
            men[48 + i] = new Soldier(48 + i, 2);
            men[16 + i] = new Empty(16 + i);
            men[24 + i] = new Empty(24 + i);
            men[32 + i] = new Empty(32 + i);
            men[40 + i] = new Empty(40 + i);
        }

        for (int j=0;j<64;j++){
            areas[j].setChessMan(men[j]);
        }

    }


    public static void move(int position){
        for (int i=0;i<64;i++){
            areas[i].setBackgroundColor(ContextCompat.getColor(c,R.color.black));
        }

        if (isSelected){
            ChessMan man = men[selectedPosition];
            int[] moves = man.getMoves(men);

            boolean moved = false;

            for (int i=0;i<man.getMovesNumber();i++){
                if (moves[i] == position){
                    men[position] = man.getMan(man.getType(),position,man.getPlayer());
                    areas[position].setChessMan(men[position]);
                    men[selectedPosition] = new Empty(selectedPosition);
                    areas[selectedPosition].setChessMan(men[selectedPosition]);
                    isPlayerOne = !isPlayerOne;
                    moved = true;
                    break;
                }
            }

            if (moved) {
                selectedPosition = 111;
                isSelected = false;
                if (isPlayerOne){
                    if (checkMate.isChecked(men,2,isPlayerOneChecked)){
                        isPlayerTwoChecked = true;
                        Log.e("GAME","checked2");
                        if (checkMate.isGameOver(men,2)){
                            Log.e("GAME","OVER2");
                            if (!checkMate.checkIfDefense(men,2,isPlayerOneChecked)) {
                                //Toast.makeText(c, "game over", Toast.LENGTH_SHORT).show();
                                ResultDialog dialog = new ResultDialog("Player 1 Won");
                                dialog.show(fragmentManager, "My Dialog");
                                dialog.setCancelable(false);
                                Log.e("GAME","game finished2");
                            }
                        }
                    }else {
                        isPlayerTwoChecked = false;
                    }

                    if (checkMate.isChecked(men,1,isPlayerTwoChecked)){
                        isPlayerOneChecked = true;
                        Log.e("GAME","checked1");
                        if (checkMate.isGameOver(men,1)){
                            Log.e("GAME","OVER1");
                            if (!checkMate.checkIfDefense(men,1,isPlayerTwoChecked)) {
                                //Toast.makeText(c, "game over", Toast.LENGTH_SHORT).show();
                                ResultDialog dialog = new ResultDialog("Player 2 Won");
                                dialog.show(fragmentManager, "My Dialog");
                                dialog.setCancelable(false);
                                Log.e("GAME","game finished1");
                            }
                        }
                    }else {
                        isPlayerOneChecked = false;
                    }

                }else {
                    if (checkMate.isChecked(men, 1, isPlayerTwoChecked)) {
                        isPlayerOneChecked = true;
                        Log.e("GAME","checked1");
                        if (checkMate.isGameOver(men,1)){
                            Log.e("GAME","OVER1");
                            if (!checkMate.checkIfDefense(men,1,isPlayerTwoChecked)) {
                                //Toast.makeText(c, "game over", Toast.LENGTH_SHORT).show();
                                ResultDialog dialog = new ResultDialog("Player 1 Won");
                                dialog.show(fragmentManager, "My Dialog");
                                dialog.setCancelable(false);
                                Log.e("GAME","game finished1");
                            }
                        }
                    }else {
                        isPlayerOneChecked = false;
                    }

                    if (checkMate.isChecked(men, 2, isPlayerOneChecked)) {
                        Log.e("GAME","checked2");
                        isPlayerTwoChecked = true;
                        if (checkMate.isGameOver(men,2)){
                            Log.e("GAME","OVER2");
                            if (!checkMate.checkIfDefense(men,2,isPlayerOneChecked)) {
                                //Toast.makeText(c, "game over", Toast.LENGTH_SHORT).show();
                                ResultDialog dialog = new ResultDialog("Player 2 Won");
                                dialog.show(fragmentManager, "My Dialog");
                                dialog.setCancelable(false);
                                Log.e("GAME","game finished2");
                            }
                        }
                    }else {
                        isPlayerTwoChecked = false;
                    }
                }
            }else {
                if (areas[position].isEmpty()){
                    selectedPosition = 111;
                    isSelected = false;
                }else {
                    if (isPlayerOne && men[position].getPlayer() == 1) {
                        areas[position].setBackgroundColor(ContextCompat.getColor(c, R.color.minister));
                        isSelected = true;
                        selectedPosition = position;
                    }else if (!isPlayerOne && men[position].getPlayer() == 2) {
                        areas[position].setBackgroundColor(ContextCompat.getColor(c, R.color.soldier));
                        isSelected = true;
                        selectedPosition = position;
                    }
                }
            }



            //Toast.makeText(c, "p:" + man.getPosition() + " x:" + man.getPosition()%8 + " y:" +
            //        man.getPosition()/8, Toast.LENGTH_SHORT).show()
        }else {
            if (areas[position].isEmpty()){
                selectedPosition = 111;
            }else {
                if (isPlayerOne && men[position].getPlayer() == 1) {
                    areas[position].setBackgroundColor(ContextCompat.getColor(c, R.color.minister));
                    isSelected = true;
                    selectedPosition = position;
                }else if (!isPlayerOne && men[position].getPlayer() == 2) {
                    areas[position].setBackgroundColor(ContextCompat.getColor(c, R.color.soldier));
                    isSelected = true;
                    selectedPosition = position;
                }
            }
        }

        for (int i:men[position].getMoves(men)){
            if (i!=119)
                Log.e("NNNNNNN","n" + i);
        }/*
        Toast.makeText(c,"t" + men[position].Type + men[position].getPlayer() + " p:" +
                men[position].getPositionName() + " n:" + men[position].getPosition() +
                " moves: " + men[position].getMoves(men).length, Toast.LENGTH_SHORT).show();
        */
    }

}
