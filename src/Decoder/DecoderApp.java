package Decoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Calendar;
import  java.util.Date;
import java.util.Locale;

public class DecoderApp {
    public void start() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ведите ваш номер ИНН:");
        String per = reader.readLine();

        String firstFiveChars = per.substring(0, 5);
        String secondFourChars = per.substring(5, 9);
        String sex = per.substring(8);

        SimpleDateFormat birth = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(00, 00, 00));
        calendar.add(Calendar.DATE, Integer.parseInt(firstFiveChars));
        String output = birth.format(calendar.getTime());

        SimpleDateFormat todayDate = new SimpleDateFormat("dd.MM.yyyy");
        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(new Date());
        String out = todayDate.format(todayCalendar.getTime());

        int todayYear = todayCalendar.get(todayCalendar.YEAR);
        int year = calendar.get(calendar.YEAR);

        System.out.println("Дата рождения: " + " " + output);
        System.out.println("Полных лет:" + " " + (todayYear - year));

        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            System.out.println("Вы родились в: Высокосный год!!!!");
        } else {
            System.out.println("Ваш год: Невысокосный");
        }
        System.out.println("Ваш порядковый номер регистрации:" + " " + secondFourChars);
        if (Integer.parseInt(sex) % 2 == 0) {
            System.out.println("Пол: женский");
        } else {
            System.out.println("Пол: мужской");
        }

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        if (month == Calendar.MARCH && day >= 21 || month == Calendar.APRIL && day <= 19) {
            System.out.println("Ваш знак зодиака: Овен");
        } else if (month == Calendar.APRIL && day >= 20 || month == Calendar.MAY && day <= 20) {
            System.out.println("Ваш знак зодиака: Телец");
        } else if (month == Calendar.MAY && day >= 21 || month == Calendar.JUNE && day <= 21) {
            System.out.println("Ваш знак зодиака: Близнеци");
        } else if (month == Calendar.JUNE && day >= 22 || month == Calendar.JULY && day <= 22) {
            System.out.println("Ваш знак зодиака: Рак");
        } else if (month == Calendar.JULY && day >= 23 || month == Calendar.AUGUST && day <= 22) {
            System.out.println("Ваш знак зодиака: Лев");
        } else if (month == Calendar.AUGUST && day >= 23 || month == Calendar.SEPTEMBER && day <= 22) {
            System.out.println("Ваш знак зодиака: Дева");
        } else if (month == Calendar.SEPTEMBER && day >= 23 || month == Calendar.OCTOBER && day <= 23) {
            System.out.println("Ваш знак зодиака: Весы");
        } else if (month == Calendar.OCTOBER && day >= 24 || month == Calendar.NOVEMBER && day <= 22) {
            System.out.println("Ваш знак зодиака: Скорпион");
        } else if (month == Calendar.NOVEMBER && day >= 23 || month == Calendar.DECEMBER && day <= 21) {
            System.out.println("Ваш знак зодиака: Стрелец");
        } else if (month == Calendar.DECEMBER && day >= 22 || month == Calendar.JANUARY && day <= 20) {
            System.out.println("Ваш знак зодиака: Козерог");
        } else if (month == Calendar.JANUARY && day >= 21 || month == Calendar.FEBRUARY && day <= 18) {
            System.out.println("Ваш знак зодиака: Водолей");
        } else if (month >= Calendar.FEBRUARY && day >= 19 || month >= Calendar.MARCH && day <= 20) {
            System.out.println("Ваш знак зодиака: Рыбы");
        }

            int controlSummOf10 = (((
                    -1 * Integer.parseInt(per.substring(0,1)) + 5 * Integer.parseInt(per.substring(1,2)) +
                            7 * Integer.parseInt(per.substring(2,3)) +
                            9 * Integer.parseInt(per.substring(3,4)) +
                            4 * Integer.parseInt(per.substring(4,5)) +
                            6 * Integer.parseInt(per.substring(5,6)) +
                            10 * Integer.parseInt(per.substring(6,7)) +
                            5 * Integer.parseInt(per.substring(7,8)) +
                            7 * Integer.parseInt(per.substring(8,9))) % 11) % 10);
            if (Integer.parseInt(per.substring(9,10)) == controlSummOf10) {
                System.out.println("Введённый ИНН: Валидный");
            } else {
                System.out.println("Введённый ИНН: не прошёл проверку по контрольным цифрам");

            }
    }
}


