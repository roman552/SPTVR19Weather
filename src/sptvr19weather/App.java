/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19weather;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
class App {
    public void run() {
        System.out.println("---Project Weather---");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = 0, min=-50, max=50, minDay = 50, maxDay = -50;
        //Создаем зубчатый массив
        int[][] tInYear = new int[12][];
        for (int i = 0; i < 12; i++) {
            //Иницируем количество дней, максимум и минимум температуры в месяце
            switch (i) {
                case 0: min=-25; max=-5; n=31; break;
                case 1: min=-25; max=-5; n=28; break;
                case 2: min=-15; max=10; n=31; break;
                case 3: min=-5; max=15; n=30; break;
                case 4: min=0; max=20; n=31; break;
                case 5: min=10; max=25; n=30; break;
                case 6: min=15; max=30; n=31; break;
                case 7: min=10; max=25; n=31; break;
                case 8: min=5; max=15; n=30; break;
                case 9: min=0; max=10; n=31; break;
                case 10: min=-5; max=5; n=30; break;
                case 11: min=-15; max=0; n=31; break;
              
            }
            //Создаем массив с колличеством дней в i-ом месяце
            tInYear[i] = new int[n];
            for (int j = 0; j < tInYear[i].length; j++) {
                //Заполняем массив месяца диапозоном температур
                tInYear[i][j] = random.nextInt(max-min+1)+min;
                //Выводим на консоль значения температур в i-ом месяце
                System.out.printf("%4d",tInYear[i][j]);
                
            }
            //Переходим на новую строчку (новый месяц)
            System.out.println("");

        }
            System.out.print("Введите месяц: ");
            int month = scanner.nextInt();
            System.out.print("Введите день: ");
            int day = scanner.nextInt();
            System.out.println("В этот день была температура: "+tInYear[month-1][day-1]);
            
            for (int i = 0; i < tInYear[month-1].length; i++) {
                
                if (minDay > tInYear[month-1][i]) {
                    minDay = tInYear[month-1][i];
                    
                }
                if (maxDay < tInYear[month-1][i]) {
                    maxDay = tInYear[month-1][i];
                    
                }
            }
            System.out.println("В этом месяце самая холодная температура была "+minDay+" градусов");
            System.out.println("В этом месяце самая теплая температура была "+maxDay+" градусов");
            
    }      
}
