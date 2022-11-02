package com.company;

import java.util.Scanner;


public class Main {

 /*   Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() {
            try {
                Thread.sleep(200);
                System.out.println("Shutting down ...");
                //some cleaning up code...

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    });*/

    static int matrix(){
        Scanner scan = new Scanner(System.in);
        String n = scan.next();
        try {
            if (Integer.parseInt(n) >= 2 && Integer.parseInt(n) <= 5) {
                return Integer.parseInt(n);
            }
            else{
                System.out.println("Неверный ввод, попробуйте ещё раз");
                return matrix();
            }
        }
        catch (Exception e){
            System.out.println("Неверный ввод, попробуйте ещё раз");
            return matrix();
        }
    }
    static int rand(){
        Scanner s = new Scanner(System.in);
        String t = s.next();
        try {
            if (Integer.parseInt(t) == 0 || Integer.parseInt(t) == 1) {
                return Integer.parseInt(t);
            } else {
                System.out.println("Неверный ввод, попробуйте ещё раз");
                return rand();
            }
        }
        catch (Exception e){
            System.out.println("Неверный ввод, попробуйте ещё раз");
            return rand();
        }
    }

    static int proof(){
        Scanner s = new Scanner(System.in);
        String x = s.next();
        try {
            if (Integer.parseInt(x) >= 1 && Integer.parseInt(x) <= 100) {
                return Integer.parseInt(x);
            }
            else{
                System.out.println("Неверный ввод, попробуйте ещё раз");
                return proof();
            }
        }
        catch (Exception e){
            System.out.println("Неверный ввод, попробуйте ещё раз");
            return proof();
        }
    }

    static int min(){
        Scanner s = new Scanner(System.in);
        try {
            int h = s.nextInt();
            return h;
        }
        catch (Exception e){
            System.out.println("Неверный ввод, попробуйте ещё раз");
            return min();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер матрицы от 2 до 5");
        int n = matrix();
        int[][] array = new int[n][n];
        System.out.println("Введите 1, если хотите заполнить матрицу рандомными числами, иначе - 0");
        int proof = rand();
        if(proof == 1){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    array[i][j] = 1 + (int) (Math.random() * 99);
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = proof();
                }
            }
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(array[i][n - i - 1] > array[j][n - j - 1]){
                    int swap = array[i][n - i - 1];
                    array[i][n - i - 1] = array[j][n - j - 1];
                    array[j][n - j - 1] = swap;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == n - i - 1){
                    continue;
                }
                else{
                    array[i][j] *= -1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Введите номер минимума, который вы желаете найти");
        int flag = 0;
        int p = min();
        while (flag != 1){
            if(p >= 1 && p <= n){
                for(int i = 0; i < n; i++){
                    if(array[n - p][i] > 0){
                        System.out.println("Ваш минимум - " + array[n - p][i]);
                        flag = 1;
                    }
                }
            }
            else{
                System.out.println("Неверный ввод, попробуйте ещё раз");
                p = min();
            }
        }
    }
}


