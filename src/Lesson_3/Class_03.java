package Lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Class_03 {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //System.out.println(Arrays.toString(words));
        Random rand1 = new Random();
        String answer = words[rand1.nextInt(words.length)];
        String useranswer = ""; //
        //System.out.println(answer);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Это игра \"УГАДАЙ ЕДУ\". Введите пустую строку, если сдаётесь.");
        while (!(answer.equals(useranswer))) {
            System.out.println("Подсказка - " + showTip(answer,useranswer));
            System.out.print("Введите слово : ");
            useranswer =sc1.nextLine();
            if (useranswer.equals("")) break;
        }
        System.out.println(useranswer.equals("") ? "Сожалею, но вы проиграли!" : "Поздравляем, вы выиграли!");
        }


    public static String showTip(String s1, String s2){
        String returnStr = "";
        int lmin = s1.length() > s2.length() ? s2.length() : s1.length();
        for (int i=0; i< lmin; i++){
            returnStr += s1.charAt(i)==s2.charAt(i) ? s1.charAt(i) : '#';
        }
        while (returnStr.length()<15) returnStr += '#';
        return returnStr;
    }

}
