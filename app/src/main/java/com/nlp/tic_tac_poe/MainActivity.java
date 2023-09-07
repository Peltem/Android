package com.nlp.tic_tac_poe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private ActivityMainBinding binding;
    private LinearLayout board;
    private ArrayList<Button> squares = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View.OnClickListener listener = (view)->{
            Button btn = (Button) view;
            if (!btn.getText().toString().equals("")) return;
            if(GameInfo.isTurn) btn.setText(GameInfo.firstSymbol);
            else  btn.setText(GameInfo.secondSymbol);

            if (GameInfo.isTurn)
            {
                btn.setText(GameInfo.firstSymbol);
                int [] com = CheckWin(GameInfo.firstSymbol);
                if(com!=null) Toast.makeText(getApplicationContext(), "win lol " + GameInfo.firstSymbol,
                        Toast.LENGTH_LONG).show();
                highlightWinComb(com);

            }
            else
            { btn.setText(GameInfo.secondSymbol);
                int [] com = CheckWin(GameInfo.secondSymbol);
                if(com!=null) Toast.makeText(getApplicationContext(), "win lol " + GameInfo.secondSymbol,
                        Toast.LENGTH_LONG).show();
                highlightWinComb(com);
            }
            GameInfo.isTurn = !GameInfo.isTurn;


        };
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());

        board = findViewById(R.id.board);
        generateBoard(3, 3, board);
        setListenerToSquares(listener);
        inintClearBtn();

    }

    public void generateBoard(int rowCount, int columnCount, LinearLayout board) {
        //Генерация строчек от 0 до rowCount
        for (int row = 0; row < rowCount; row++) {
            //Создаем контейнер(нашу строку) и вносим ее в board
            LinearLayout rowContainer = generateRow(columnCount);
            board.addView(rowContainer);
        }
    }

    private void setListenerToSquares(View.OnClickListener listener)
    {
        for (int i=0; i<squares.size();i++)
        squares.get(i).setOnClickListener(listener);
    }
    //метод генерации строк для board
    private LinearLayout generateRow(int squaresCount) {
        //Созданный контейнер (стоока) который будет возвращен с кнопками
        LinearLayout rowContainer = new LinearLayout(getApplicationContext());
        rowContainer.setOrientation(LinearLayout.HORIZONTAL);
        rowContainer.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        for (int square = 0; square < squaresCount; square++) {
            //Создаем кнопку для добавления в строку
            Button button = new Button(getApplicationContext());
            //Устанавливаем цвет с помощью tint
            button.setBackgroundTintList(
                    ContextCompat.getColorStateList(
                            getApplicationContext(),
                            R.color.green));
            button.setWidth(convertToPixel(90));
            button.setHeight(convertToPixel(90));
            rowContainer.addView(button);
            squares.add(button);


        }
        return rowContainer;
    }
    public int convertToPixel (int digit)
    {
        float density = getApplicationContext().getResources().getDisplayMetrics().density;
        return (int)(digit*density+0.5);
    }
    public int [] CheckWin(String symbol)
    {

        for(int i = 0; i< GameInfo.winCombination.length;i++)
        {
            boolean findC=true;
            for(int j = 0; j<GameInfo.winCombination[0].length; j++)
            {
                int index = GameInfo.winCombination[i][j];
                if(!squares.get(index).getText().toString().equals(symbol))
                { findC = false; break;}

            }
            if (findC) return GameInfo.winCombination[i];
        }
       return null;
    }
    public void highlightWinComb(int[] comb){
        if(comb == null) return;
        for (int i = 0; i < comb.length;i++){
            squares.get(comb[i]).setBackgroundTintList(ContextCompat.getColorStateList(
                    getApplicationContext(),
                    R.color.purple_200));
        }

    }
    private void inintClearBtn(){
        Button clearBtn = findViewById(R.id.clear_board_value);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Новая игра", Toast.LENGTH_LONG).show();
                for (Button square : squares) {
                    square.setText("");
                    square.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.green));
                }
            }
        });

    }

}

