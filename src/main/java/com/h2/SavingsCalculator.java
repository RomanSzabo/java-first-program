package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {

    private static float[] credits;
    private static float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        SavingsCalculator.credits = credits;
        SavingsCalculator.debits = debits;
    }

    public static void main(String[] args) {
        String[] creditsString = args[0].split(",");
        String[] debitsString = args[1].split(",");
        float[] credits = new float[creditsString.length];
        float[] debits = new float[debitsString.length];
        for (int i = 0; i < credits.length; i++) {
            credits[i] = Float.parseFloat(creditsString[i]);
        }
        for (int i = 0; i < debits.length; i++) {
            debits[i] = Float.parseFloat(debitsString[i]);
        }
        SavingsCalculator savingsCalculator = new SavingsCalculator(credits, debits);
        float netSavings = savingsCalculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }

    private float sumOfCredits() {
        float sum = 0.0f;
        for(float credit: credits) {
            sum = sum + credit;
        }
        return sum;
    }

    private float sumOfDebits() {
        float sum = 0.0f;
        for(float debit: debits) {
            sum = sum + debit;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        return totalDaysInMonth - date.getDayOfMonth();
    }

}
