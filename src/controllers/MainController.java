/*
* File: MainController.java
* Author: Nagy József
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
* Refactored by: Borbély Gergő Árpád
*/

package controllers;

import java.util.Random;

import javax.swing.JButton;

import views.MainWindow;

public class MainController {
    MainWindow mainWindow;
    String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "D", "K", "A" };
    Round round = Round.PREFLOP;

    enum Round {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
    }

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.initEvent();
    }

    /**
     * Return a random number from 0 to 12
     * We have 13 card
     * 
     * @return int Random card selection
     * @see java.util.Random
     */
    private int getRandom() {
        Random random = new Random();
        return random.nextInt(13);
    }

    // TODO: A stopBtn majd a következő kört (round) generálja
    public void initEvent() {
        this.mainWindow.startBtn.addActionListener(
                event -> {
                    int humanCard1 = getRandom();
                    int humanCard2 = getRandom();
                    int computerCard1 = getRandom();
                    int computerCard2 = getRandom();
                    String humanCard1Str = cards[humanCard1];
                    String humanCard2Str = cards[humanCard2];
                    this.mainWindow.humanCard1Btn.setText(humanCard1Str);
                    this.mainWindow.humanCard2Btn.setText(humanCard2Str);

                    System.out.printf(
                            "%d %d\n", humanCard1, humanCard2);

                });
        this.mainWindow.stopBtn.addActionListener(
                event -> {
                    System.out.println("Állj");
                });

        this.mainWindow.nextBtn.addActionListener(
                event -> {
                    String flop1Str;
                    String flop2Str;
                    String flop3Str;

                    /*
                     * TODO: A kártya színeket is le kell generálni
                     * ♠ ♥ ♦ ♣
                     */
                    if (this.round == Round.PREFLOP) {
                        int flop1 = getRandom();
                        int flop2 = getRandom();
                        int flop3 = getRandom();

                        // TODO: a jobb oldal mehet rögtön a setText()-be
                        flop1Str = cards[flop1];
                        flop2Str = cards[flop2];
                        flop3Str = cards[flop3];

                        this.mainWindow.flop1Btn.setText("♦" + flop1Str);
                        this.mainWindow.flop2Btn.setText(flop2Str);
                        this.mainWindow.flop3Btn.setText(flop3Str);
                        setFlopButtonVisibility(true);
                        this.round = Round.FLOP;
                        return;
                    }
                    if (this.round == Round.FLOP) {
                        setRound(this.mainWindow.turnButton, Round.TURN);
                        return;
                    }
                    if (this.round == Round.TURN) {
                        setRound(this.mainWindow.riverButton, Round.RIVER);
                    }
                });
    }

    private void setFlopButtonVisibility(boolean visible) {
        this.mainWindow.flop1Btn.setVisible(visible);
        this.mainWindow.flop2Btn.setVisible(visible);
        this.mainWindow.flop3Btn.setVisible(visible);
    }

    private void setRound(JButton button, Round nextRound) {
        int randomNumber = getRandom();
        button.setText(cards[randomNumber]);
        button.setVisible(true);
        this.round = nextRound;
    }
}
