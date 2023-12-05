/*
* File: MainController.java
* Author: Nagy József
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
*
*/

/**
 * 2021-09-11 Létrejött a round és card. Már van turn és river állapot.
 * 2021-09-04 A Controller készítése
 */

package controllers;

import java.util.Random;
import views.MainWindow;

public class MainController {

    /* A roundban tároljuk az állapotokat. Az első állapot FIRST */
    enum Round {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
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
    }// A getRandom vége

    /*************** Eseménykezelő kezdete *********************/
    // TODO: A stopBtn majd a következő kört (round) generálja
    public void initEvent() {
        this.mainWindow.startBtn.addActionListener(
                event -> {
                    Random random = new Random();
                    // Az ember első kártyája
                    int hcard1 = random.nextInt(13);
                    // Az ember második kártyája
                    int hcard2 = random.nextInt(13);

                    // A számítógép első kártyája
                    int ccard1 = random.nextInt(13);
                    // A számítógép második kártyája
                    int ccard2 = random.nextInt(13);
                    random = null;
                    String humanCard1Str = cards[hcard1];
                    String humanCard2Str = cards[hcard2];
                    this.mainWindow.humanCard1Btn.setText(humanCard1Str);
                    this.mainWindow.humanCard2Btn.setText(humanCard2Str);

                    System.out.printf(
                            "%d %d\n", hcard1, hcard2);

                });
        this.mainWindow.stopBtn.addActionListener(
                event -> {
                    System.out.println("Állj");
                });
        /**
         * Egy névtelen függvényben megvizsgáljuk, hogy
         * a játék melyik állapotában vagyunk, ami a
         * this.round változó tárol. Állapttól függően
         * generálunk három vagy egy véletlen számot.
         * A véletlenszámgenerátor külön függvénybe került.
         */
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
                        // flop generálása
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
                        this.mainWindow.flop1Btn.setVisible(true);
                        this.mainWindow.flop2Btn.setVisible(true);
                        this.mainWindow.flop3Btn.setVisible(true);
                        this.round = Round.FLOP;
                        return; // Kilépünk, mert végrehajtódik következő is
                    } // if vége PREFLOP esetén
                    if (this.round == Round.FLOP) {
                        // turn generálása
                        int turn = getRandom();
                        this.mainWindow.turnButton.setText(cards[turn]);
                        this.mainWindow.turnButton.setVisible(true);
                        this.round = Round.TURN;
                        return; // Kilépünk, mert végrehajtódik következő is
                    } // if vége FLOP esetén
                    if (this.round == Round.TURN) {
                        // river generálása
                        int river = getRandom();
                        this.mainWindow.riverButton.setText(cards[river]);
                        this.mainWindow.riverButton.setVisible(true);
                        this.round = Round.RIVER;
                    } // if vége TURN esetén
                      // System.out.println(round);
                    /**
                     * A return nélkül jól felbosszantott a kód.
                     * Végigment az összes állapoton egyszerre.
                     */
                });

    }

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.initEvent();
    }

    MainWindow mainWindow;
    String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "D", "K", "A" };
    Round round = Round.PREFLOP;

}