package com.canermastan.game;

import com.canermastan.utilities.Utilities;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Game {
    private Random random;
    public int randomNumber;
    private int guessNumber;
    public int remainingRight = 10;

    
    public void startGame(JTextField txtGuess,JLabel lblRemainingRight,JLabel lblUpDown){
        try {
            guessNumber = Integer.parseUnsignedInt(txtGuess.getText());
            if (guessNumber > 0 && guessNumber < 100) {
                if (guessNumber != randomNumber) {
                    remainingRight--;
                    lblRemainingRight.setText(Integer.toString(remainingRight));
                    if (guessNumber > randomNumber) {
                        lblUpDown.setText("TOO HIGH!");
                    } else {
                        lblUpDown.setText("TOO LOW");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "YOU ARE WIN!! " + (10 - remainingRight) + " TRIES", "YOU ARE WIN", JOptionPane.DEFAULT_OPTION);
                    
                    resetGame(txtGuess, lblUpDown, lblRemainingRight);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please enter the 1-100 number", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtGuess.setText("");
            }
            if (remainingRight == 0){
                JOptionPane.showMessageDialog(null, "Game is the end. Number: " + randomNumber, "The End", JOptionPane.ERROR_MESSAGE);
                resetGame(txtGuess, lblUpDown, lblRemainingRight);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter the 1-100 number", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtGuess.setText("");
        }
    }
    public void resetGame(JTextField txtGuess, JLabel lblUpDown, JLabel lblRemainingRight) {
        txtGuess.setText("");
        randomNumber = Utilities.generateRandomNumber(randomNumber);
        lblUpDown.setText("START");
        remainingRight = 10;
        lblRemainingRight.setText(Integer.toString(remainingRight));
    
    }
}
