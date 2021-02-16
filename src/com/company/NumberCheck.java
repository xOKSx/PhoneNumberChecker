package com.company;

public class NumberCheck {

    public static String[] check(String number) {

        String newNumber = "";
        String[] report = new String[]{"", ""};

        char currentChar;

        boolean isCorrected = false;
        boolean bracketsOrSpaces = false;
        boolean badChars = false;
        boolean countryCode = false;

        if (number.isEmpty()) {
            report[0] = "Введен некорректный номер";
            report[1] = "Номер отсутствует";
            return report;
        }

        for (int i = 0; i < number.length(); i++) {
            currentChar = number.charAt(i);
            if (currentChar == ')' || currentChar == '(' || currentChar == ' ') {
                bracketsOrSpaces = true;
                isCorrected = true;
            } else if (currentChar == '+' && newNumber == "") {
                newNumber += currentChar;
            } else if (currentChar > '\u0039' || currentChar < '\u0030') {
                badChars = true;
                isCorrected = true;
            } else {
                newNumber += currentChar;
            }
        }
        if (newNumber.startsWith("+7")) {
            newNumber = newNumber.replace("+7", "8");
            countryCode = true;
            isCorrected = true;
        }

        if (newNumber.length() == 11) {
            report[0] = newNumber;
        } else {
            report[0] = "Введен некорректный номер";
        }

        if (!isCorrected) {
            report[1] += "Не было изменений";
        }
        if (countryCode) {
            if (!report[1].isEmpty()) {
                report[1] += "; ";
            }
            report[1] += "Замена +7 на 8";
        }
        if (bracketsOrSpaces) {
            if (!report[1].isEmpty()) {
                report[1] += "; ";
            }
            report[1] += "В номере есть пробелы и/или скобки";
        }
        if (badChars) {
            if (!report[1].isEmpty()) {
                report[1] += "; ";
            }
            report[1] += "В номере есть неподходящие символы";
        }
        if (newNumber.length() > 11) {
            if (!report[1].isEmpty()) {
                report[1] += "; ";
            }
            report[1] += "Количество символов больше 11";
        } else if (newNumber.length() < 11) {
            if (!report[1].isEmpty()) {
                report[1] += "; ";
            }
            report[1] += "Количество символов меньше 11";
        }

        return report;
    }
}
