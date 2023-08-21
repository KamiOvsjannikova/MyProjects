package de.telran.lesson24.practice2;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    public static final char PLUS_SIGN = '+';
    public static final char MINUS_SIGN = '-';
    public static final char MULTIPLY_SIGN = '*';
    public static final char DIVIDE_SIGN = '/';
    public static final char REST_SIGN = '%';
    public static final String ANSWER_YES = "y";
    public static final String ANSWER_NO = "n";
    public static final int HISTORY_SIZE = 3;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        String needNextCalculation;
        String[] resultsHistory = new String[HISTORY_SIZE]; // Массив для запоминания истории 5 последних вычислений
        do {

            int argumentsNumber;
            do {
                System.out.print("Введите количество аргументов (2 или более) ");
                argumentsNumber = scanner.nextInt();
            } while (argumentsNumber < 2);

            double[] arguments = new double[argumentsNumber]; // Массив для хранения аргументов
            char[] signs = new char[argumentsNumber - 1]; // Массив для хранения знаков математических операций

            for(int i = 0; i < arguments.length; i++) {
                System.out.println(String.format("Введите значение %d аргумента (разделитель целой и дробной части - точка):", i+1));
                arguments[i] = scanner.nextDouble();
                if (i < arguments.length - 1) { // Ввод знаков математической операции для аргументов с первого до предпоследнего
                    do {
                        System.out.print("Введите знак математической операции (+, -, *, /): ");
                        signs[i] = scanner.next().charAt(0); // Сохранение введенного знака в массив знаков операций
                    } while (signs[i] != PLUS_SIGN && signs[i] != MINUS_SIGN && signs[i] != MULTIPLY_SIGN
                            && signs[i] != DIVIDE_SIGN && signs[i] != REST_SIGN);
                }
            }
            // Это наш технический долг !!! :)
//            double argumentTwo;
//            do {
//                System.out.println("Введите значение второго аргумента (разделитель целой и дробной части - точка):");
//                argumentTwo = scanner.nextDouble();
//            } while (argumentTwo == 0 && (sign == DIVIDE_SIGN || sign == REST_SIGN));

            double result = arguments[0];
            for(int i = 1; i<arguments.length; i++) {
                switch (signs[i - 1]) { // Выполнение математической операции в зависимости от введенного знака
                    case PLUS_SIGN: // Если пользователь ввёл знак + ...
                        result += arguments[i]; // ... выполняется операция сложения
                        break;
                    case MINUS_SIGN: // Если пользователь ввёл знак - ...
                        result -= arguments[i]; // ... выполняется операция вычитания
                        break;
                    case MULTIPLY_SIGN: // Если пользователь ввёл знак * ...
                        result *= arguments[i]; // ... выполняется операция умножения
                        break;
                    case DIVIDE_SIGN: // Если пользователь ввёл знак / ...
                        result /= arguments[i]; // ... выполняется операция деления
                        break;
                    case REST_SIGN: // Если пользователь ввёл знак % ...
                        result %= arguments[i]; // ... выполняется операция деления по модулю (получение остатка от деления)
                }
            }

            StringBuilder resultMessage = new StringBuilder();
            for (int i=0; i<arguments.length; i++) {
                resultMessage.append(String.format("%.2f",arguments[i]));
                if(i < arguments.length-1) resultMessage.append(signs[i]);
            }
            resultMessage.append("=").append(String.format("%.2f",result));

            // Освобождаем первую ячейку массива для сохранения последнего результата работы программы, сдвигая значения на 1 ячейку вперёд, начиная с конца
            for (int i = resultsHistory.length - 1; i > 0; i--) {
                resultsHistory[i] = resultsHistory[i - 1];
            }
            resultsHistory[0] = resultMessage.toString(); //заносим в историю результат текущего выражения

            System.out.println("История выполненных вычислений:");
            System.out.println(Arrays.toString(resultsHistory)); //вывожу на экран историю результатов
            System.out.println();

            do {
                System.out.println("Выполнить еще одно вычисление? (Y/N):");
                needNextCalculation = scanner.next();
            } while (!ANSWER_YES.equalsIgnoreCase(needNextCalculation) && !ANSWER_NO.equalsIgnoreCase(needNextCalculation));

        } while(ANSWER_YES.equalsIgnoreCase(needNextCalculation));

    }

}


 /*
1) Вводить знак математической операции перед вводом каждого следующего аргумента.
   Например, пользователь указывает, что хочет выполнить операцию над тремя аргументами.
   Программа просит последовательно ввести первый аргумент, знак математической операции,
     который будет выполнен над значениями первого и второго аргумента, значение второго аргумента,
     знак математической операции, который будет выполнен над результатом операции между первым и
     вторым аргументом и третьим аргументом.
     В результате, программа должна позволять вычислить следующее выражение: 3 * 4 - 10.5 + 2 = 3.5
2) Выводить на экран историю последних 3 вычислений.
*/
