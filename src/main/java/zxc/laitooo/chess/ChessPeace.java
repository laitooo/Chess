package zxc.laitooo.chess;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Laitooo San on 15/06/2019.
 */

public class ChessPeace extends ImageView {

    ChessMan chessMan;
    Context c;
    char SOLDIER = 's';
    char KING = 'k';
    char MINISTER = 'm';
    char CASTLE = 'c';
    char HORSE = 'h';
    char ROOK = 'r';
    char EMPTY = '-';

    public ChessPeace(Context context) {
        super(context);
        c = context;
    }

    public ChessPeace(Context context, AttributeSet attrs) {
        super(context, attrs);
        c = context;
    }

    public ChessPeace(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        c = context;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChessPeace(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        c = context;
    }


    public void setChessMan(ChessMan man){
        chessMan = man;
        setBackgroundColor(ContextCompat.getColor(c,R.color.black));
        switch (chessMan.getType()){
            case 's':
                if (chessMan.getPlayer() == 1)
                    setImageResource(R.drawable.soldier1);
                else
                    setImageResource(R.drawable.soldier2);
                break;
            case 'k':
                if (chessMan.getPlayer() == 1)
                    setImageResource(R.drawable.king1);
                else
                    setImageResource(R.drawable.king2);
                break;
            case 'm':
                if (chessMan.getPlayer() == 1)
                    setImageResource(R.drawable.minister1);
                else
                    setImageResource(R.drawable.minister2);
                break;
            case 'c':
                if (chessMan.getPlayer() == 1)
                    setImageResource(R.drawable.castle1);
                else
                    setImageResource(R.drawable.castle2);
                break;
            case 'h':
                if (chessMan.getPlayer() == 1)
                    setImageResource(R.drawable.horse1);
                else
                    setImageResource(R.drawable.horse2);
                break;
            case 'r':
                if (chessMan.getPlayer() == 1)
                    setImageResource(R.drawable.rook1);
                else
                    setImageResource(R.drawable.rook2);
                break;
            default:
                setImageResource(R.drawable.empty);
                break;

        }

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(c, chessMan.getPositionName() + " " + chessMan.getType()
                //        , Toast.LENGTH_SHORT).show();
                PlayActivity.move(chessMan.getPosition());
            }
        });
    }

    public boolean isEmpty(){
        return chessMan.getType() == '-';
    }


}
