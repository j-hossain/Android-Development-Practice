package com.example.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public class Game{
        int[][] grid = new int[4][4];
        boolean turn;
        int win;
        public void resetGame(){
            turn = false;
            win  = -1;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    grid[i][j] = -1;
                }
            }
        }
        public Game(){
            resetGame();
        }
        public int getTurn(){
            return turn?2:1;
        }

        public int makeMove(int row, int col){
            if(win!=-1) return 0;
            if(grid[row][col]!=-1) return 0;
            grid[row][col] = turn?1:0;
            turn ^= true;
            return turn?1:2;
        }
        public int checkWin(){
            //checking win for red in ith row
            for(int i=0;i<3;i++){
                if(grid[i][0]==0 && grid[i][1]==0 && grid[i][2]==0) return win = 1;
            }
            //checking win for red in ith column
            for(int i=0;i<3;i++){
                if(grid[0][i]==0 && grid[1][i]==0 && grid[2][i]==0) return win = 1;
            }
            // checking for red win in 1st diagonal
            if(grid[0][0]==0 && grid[1][1]==0 &&grid[2][2]==0) return win = 1;
            // checking for red win in 2nd diagonal
            if(grid[0][2]==0 && grid[1][1]==0 &&grid[2][0]==0) return win = 1;

            //checking win for yellow in ith row
            for(int i=0;i<3;i++){
                if(grid[i][0]==1 && grid[i][1]==1 && grid[i][2]==1) return win = 2;
            }
            //checking win for yellow in ith column
            for(int i=0;i<3;i++){
                if(grid[0][i]==1 && grid[1][i]==1 && grid[2][i]==1) return win = 2;
            }
            // checking for yellow win in 1st diagonal
            if(grid[0][0]==1 && grid[1][1]==1 &&grid[2][2]==1) return win = 2;
            // checking for yellow win in 2nd diagonal
            if(grid[0][2]==1 && grid[1][1]==1 &&grid[2][0]==1) return win = 2;

            // no one won
            return 0;
        }

    }
    Game theGame = new Game();

    public void resetGame(View view){
        theGame.resetGame();
        androidx.gridlayout.widget.GridLayout gameBox = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.gridLayoutGameBox);
        for(int i=0;i<gameBox.getChildCount();i++){
            ImageView imageViewCoin = (ImageView) gameBox.getChildAt(i);
            imageViewCoin.setImageDrawable(null);
        }
    }
    public void dropCoinAction(ImageView imageViewCoin, int turn){
        imageViewCoin.setTranslationY(-1500);
        if(turn == 2){
            imageViewCoin.setImageResource(R.drawable.yellowcoin);
        }
        else{
            imageViewCoin.setImageResource(R.drawable.redcoin);
        }
        imageViewCoin.animate().translationYBy(1500).setDuration(300);
    }
    public void dropCoin(View view){
        ImageView imageViewCoin = (ImageView) view;
        String coinTag = imageViewCoin.getTag().toString();
        int row = Integer.parseInt(coinTag);
        int col = row%10;
        row/=10;
        int turn = theGame.makeMove(row,col);
        if(turn!=0){
            dropCoinAction(imageViewCoin,turn);
            int winner = theGame.checkWin();
            if(winner==1){
                Toast.makeText(this, "Red Wins The Game", Toast.LENGTH_SHORT).show();
            }
            else if(winner==2){
                Toast.makeText(this, "Yellow Wins The Game", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}