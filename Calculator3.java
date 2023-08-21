package de.telran.lesson24.practice3;

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
    public static final int HISTORY_SIZE = 5;

// 3
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] resultsHistory = new String[HISTORY_SIZE]; // Массив для запоминания истории 5 последних вычислений

    public static void main(String[] args) {
        String needNextCalculation;
        do {
            String expression = inputExpression();
            double[] arguments = parseArguments(expression);
            char[] signs = parseSigns(expression);
            double result = arguments[0];
            for(int i = 1; i<arguments.length; i++) {
                result = calculate(result, signs[i-1], arguments[i]);
            }
            printResult(expression, result);
            addResultToHistory(expression, result);
            printHistory();
            needNextCalculation = askUserForNextCalculation();
        } while(ANSWER_YES.equalsIgnoreCase(needNextCalculation));
    }

    /**
     * Ввод с клавиатуры вычисляемого математического выражения
     */
    private static String inputExpression() {
        System.out.println("Введите математическое выражение. Например, 10.5*5+1-7.1 : ");
        return scanner.next();
    }

    /**
     * Проверка является ли символ знаком математической операции
     */
    private static boolean isSign(char symbol) {
        return symbol == PLUS_SIGN || symbol == MINUS_SIGN || symbol == MULTIPLY_SIGN || symbol == DIVIDE_SIGN || symbol == REST_SIGN;
    }

    /**
     * Подсчет количества аргументов в математическом выражении
     */
    private static int countArgumentsNumber(String expression) {
        int argumentsNumber = 1; // Счётчик количества аргументов в математическом выражении

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (isSign(symbol))
                argumentsNumber++; // Если в математическом выражении встречается очередной знак математической операции, увеличиваем счетчик аргументов на единицу
        }
        return argumentsNumber;
    }

    /**
     * Метод получает массив значений аргументов из строки, введенной пользователем
     */
    private static double[] parseArguments(String expression) {
        int argumentsNumber = countArgumentsNumber(expression);
        double[] arguments = new double[argumentsNumber]; // Массив для хранения аргументов

        // Получение значений аргументов из строки математического выражения, приведение их к дробному типу данных, и сохранение значений в массиве
        StringBuilder argumentAsString = new StringBuilder(); // Переменная для посимвольного накопления очередного значения аргумента из введенного пользователем матемаатического выражения
        int currentArgumentNumber = 0; // Счётчик количества аргументов, добавленных в массив аргументов
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (!isSign(symbol)) { // Если текущий символ строки - не знак математической операции, значит это одна из цифр, составляющая значение аргумента, добавляем её в переменную, в которой цифра за цифрой накапливается значение текущего аргумента
                argumentAsString.append(symbol);
            }
            if (isSign(symbol) || i == expression.length() - 1) { // Если текущий символ строки является знаком математической операции или мы дошли до последнего символа в строке - то мы закончили получать значение цифр одного из аргументов, добавляем его в массив
                double argument = Double.parseDouble(argumentAsString.toString()); // Преобразование представления числа из формата строки в тип число с дробной частью
                arguments[currentArgumentNumber++] = argument;
                argumentAsString.delete(0, argumentAsString.length()); // Очистка значения записанного в массив аргумента для накопления символов следующего значения
            }
        }

        return arguments;
    }
    /**
     * Метод получает массив знаков математических операций из строки, введенной пользователем
     */
    private static char[] parseSigns(String expression) {
        int argumentsNumber = countArgumentsNumber(expression);
        char[] signs = new char[argumentsNumber - 1]; // Массив для хранения знаков математических операций

        // Получение знаков математических операций из строки математического выражения и сохранение значений в массиве
        int currentSignNumber = 0;
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (isSign(symbol)) { // Если текущий символ строки - знак математической операции - то добавляем его в массив
                signs[currentSignNumber++] = symbol;
            }
        }
        return signs;
    }

    /**
     * Метод выполняет математическую операцию sign над парой аргументов argumentOne и argumentTwo
     */
    private static double calculate(double argumentOne, char sign, double argumentTwo) {
        double resultLocal = 0;

        switch (sign) { // Выполнение математической операции в зависимости от введенного знака
            case PLUS_SIGN: // Если пользователь ввёл знак + ...
                resultLocal = argumentOne + argumentTwo; // ... выполняется операция сложения
                break;
            case MINUS_SIGN: // Если пользователь ввёл знак - ...
                resultLocal = argumentOne - argumentTwo; // ... выполняется операция вычитания
                break;
            case MULTIPLY_SIGN: // Если пользователь ввёл знак * ...
                resultLocal = argumentOne * argumentTwo; // ... выполняется операция умножения
                break;
            case DIVIDE_SIGN: // Если пользователь ввёл знак / ...
                resultLocal = argumentOne / argumentTwo; // ... выполняется операция деления
                break;
            case REST_SIGN: // Если пользователь ввёл знак % ...
                resultLocal = argumentOne % argumentTwo; // ... выполняется операция деления по модулю (получение остатка от деления)
        }
        return resultLocal;
    }

    /**
     * Метод выводит на экран результат вычислений
     */
    private static void printResult(String expression, double result) {
        System.out.printf("%s=%.2f%n", expression, result); // Ограничиваем значение результата при выводе на экран до двух цифр после запятой
        System.out.println();
    }

    /**
     * Метод добавляет результат вычислений в историю вычислений
     */
    private static void addResultToHistory(String expression, double result) {
        // Освобождаем первую ячейку массива для сохранения последнего результата работы программы, сдвигая значения на 1 ячейку вперёд, начиная с конца
        for (int i = resultsHistory.length - 1; i > 0; i--) {
            resultsHistory[i] = resultsHistory[i - 1];
        }

        resultsHistory[0] = String.format("%s=%.2f", expression, result);
    }

    /**
     * Метод выводит на экран историю вычислений
     */
    private static void printHistory() {
        System.out.println("История выполненных вычислений:");
        System.out.println(Arrays.toString(resultsHistory));
        System.out.println();
    }

    /**
     * Метод выводит на экран интерактивное меню и завершает программу по команде пользователя
     */
    private static String askUserForNextCalculation() {
        String needNextCalculation;
        do {
           System.out.println("Выполнить еще одно вычисление? (Y/N):");
           needNextCalculation = scanner.next();
        } while (!ANSWER_YES.equalsIgnoreCase(needNextCalculation) && !ANSWER_NO.equalsIgnoreCase(needNextCalculation));
        return needNextCalculation; // Получение введенного значения - требуется ли калькулятору выполнить еще одно вычисление
   }


}


 /*
выполнить рефакторинг программного кода "Калькулятора" таким образом, чтобы каждый логический шаг алгоритма был бы реализован в отдельном методе.
создать отдельные методы для выполнения следующих шагов:
1) String inputExpression() - для ввода строки (вычисляемого математического выражения) с клавиатуры
2) double[] parseArguments(String expression) - для получения из строки математического выражения значений аргументов
3) char[] parseSigns(String expression) - для получения из строки математического выражения знаков математических операций
4) double calculate(double argumentOne, char sign, double argumentTwo) - для выполнения математической операции над парой аргументов
5) void printResult(String expression, double result) - для вывода результата вычисления на экран
Убедитесь, что приложение работает корректно.
Соберите дистрибутив приложения (calculator.jar), согласно инструкции:
https://www.jetbrains.com/help/idea/compiling-applications.html#package_into_jar
запустите полученный дистрибутив из командной строки своей операционной системы командой:
 java -jar calculator.jar

*/
