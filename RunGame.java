package com.example.project;

import java.util.Random;

public class RunGame {
        int usertries;             // user times of tried in game
        int inputtries;            // user inputted tries
        int value;                 // system random number
        int bonus;                 // a bonus for difficulty score
        int score;                 // a total score of the game
        String result;             // result of user`s guess


        public RunGame(int inputtries, String mode) {
            this.inputtries = inputtries;
            this.usertries = 0;
            this.score = 100;
            if (mode.equals("easy")) {
                Random rand = new Random();
                this.value = rand.nextInt(10) + 1;
                this.bonus = 1;
            } else if (mode.equals("normal")) {
                Random rand = new Random();
                this.value = rand.nextInt(50) + 1;
                this.bonus = 5;
            } else if (mode.equals("hard")) {
                Random rand = new Random();
                this.value = rand.nextInt(100) + 1;
                this.bonus = 10;
            }
        }

        public String UserGuessNumber (int m) {
            this.usertries++;
            if (this.usertries <= this.inputtries) {
                if (this.value == m) {
                    result = "win";
                }else if(this.value < m){
                    result = "too high"; // will be change to show a toohigh pic
                }else {
                    result = "too low";  // will be change to show a toolow pic
                }
            }return result;
        }

        public int getScore(){
            if(this.usertries >= this.inputtries){
                this.score = 0;
            }else{
                this.score = (int) ((1/ this.usertries) * this.score * this.bonus);
            }
            return this.score;
        }
        public int getUsertries(){
            return this.usertries;
        }
        public int getInputtries(){
            return this.inputtries;
        }
        public int getValue(){
            return this.value;
        }
}
