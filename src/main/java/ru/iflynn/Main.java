package ru.iflynn;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner scanner;
    public static Random random;
    public static String heroName;
    public static String monsterName;

    public static int heroHealth;
    public static int monsterHealth;

    public static int heroAttack;
    public static int monsterAttack;

    public static void main(String[] args) {
        initGame();




        while (true) {


            //ход героя
            heroMove();
            isGameOver();
            //ход монстра
            monsterMove();
            isGameOver();


            System.out.println("Ходит монстр");

            System.out.println("Game Over");

        }

    }

    public static void initGame() {
        System.out.println("Гуляя по лесу наш герой  " + heroName + "  повстречал злодея по имени  " + monsterName);
        System.out.println("Завязался бой...");
        System.out.println("Введите имя героя");
        heroName = scanner.nextLine();

        System.out.println("Вашего героя зовут: " + heroName);
        heroHealth = 10;
        monsterHealth = 10;

    }

    public static void monsterMove() {

        int monsterCommand = random.nextInt(3);

        if (monsterCommand == 0) {
            heroHealth -= monsterAttack;
            System.out.println("Монстр атакует, после атаки у " + heroName + " осталось " + heroHealth + " ед. здоровья");



        } else if (monsterCommand == 1) {
            monsterHealth += 2;
            System.out.println("Монстр отступил и выпил зелье, пополнив свое здоровье на " + monsterHealth + " ед. здоровья");
            System.out.println();
        }

    }

    public static void heroMove() {

        System.out.println("Ход героя " + heroName);
        System.out.println(" 1 - Атаковать, 2 - Защита ");
        int command = scanner.nextInt();

        if (command == 1) {
            System.out.println("Монстр " + monsterName + " получил " + heroAttack + " урона");
            monsterHealth -= heroAttack;

            if (random.nextInt(100) < 50) {
                System.out.println("===Герой смог нанести дополнительные " + heroAttack + " очки урона===");
            }

            System.out.println("У монстра осталось " + monsterHealth);


        } else if (command == 2) {
            heroHealth += 2;
            System.out.println("Герой отступил и пополнил свое здоровье на 2 единицы, стало " + heroHealth);

        } else {
            System.out.println("Ваш выбор не ясен, вы пропускаете ход");
        }
    }

    public static boolean isGameOver() {
        if (monsterHealth <= 0) {
            System.out.println("Герой победил");
            return monsterHealth <= 0;
        } else
            System.out.println("Монстр победил");
        return heroHealth <= 0;
    }
}



