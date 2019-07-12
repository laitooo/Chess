package zxc.laitooo.chess;

import zxc.laitooo.chess.peaces.Castle;
import zxc.laitooo.chess.peaces.Empty;
import zxc.laitooo.chess.peaces.Horse;
import zxc.laitooo.chess.peaces.King;
import zxc.laitooo.chess.peaces.Minister;
import zxc.laitooo.chess.peaces.Rook;
import zxc.laitooo.chess.peaces.Soldier;

/**
 * Created by Laitooo San on 15/06/2019.
 */

public class ChessMan {

    char Type;
    int Position;
    int Player;


    public ChessMan(char type, int position, int player) {
        Type = type;
        Position = position;
        Player = player;
    }

    public char getType() {
        return Type;
    }

    public void setType(char type) {
        Type = type;
    }

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public int getPlayer() {
        return Player;
    }

    public void setPlayer(int player) {
        Player = player;
    }

    public String getPositionName(){
        char[] b = {'a','b','c','d','e','f','g','h'};
        return String.valueOf(b[Position%8]) + ((Position/8)+1);
        //return String.valueOf(b[getxPosition()-1]) + getyPosition() ;
    }

    public int[] getMoves(ChessMan[] peaces){
        return null;
    }

    public ChessMan getMan(char type,int position,int player){
        switch (type){
            case 's':
                return new Soldier(position,player);
            case 'c':
                return new Castle(position,player);
            case 'k':
                return new King(position,player);
            case 'm':
                return new Minister(position,player);
            case 'h':
                return new Horse(position,player);
            case 'r':
                return new Rook(position,player);
            default:
                return new Empty(position);

        }
    }

    public boolean hasMoves(ChessMan[] peaces){
        int[] a = getMoves(peaces);
        for (int anA : a) {
            if (anA != 119)
                return true;
        }
        return false;
    }

    public int getMovesNumber(){
        return 10;
    }

    public int getAnotherPlayer(){
        if (getPlayer()==1)
            return 2;
        return 1;
    }

    @Override
    public String toString() {
        return "type:" + getType() + " position:" + getPosition() + " player:" + getPlayer();
    }
}
