package com.kodilla.patterns2.adapter.bookclassifier.library_B;

import java.util.Arrays;
import java.util.Map;

public class Statistics_B implements BookStatistics_B {

    @Override
    public int averagePublicationYear_B(Map<BookSignature_B, Book_B> books_B) {
        if (books_B.size() == 0) return 0;
        int sum = 0;
        for (Map.Entry<BookSignature_B, Book_B> entry : books_B.entrySet()) {
            sum += entry.getValue().getYearOfPublication();
        }
        return sum / books_B.size();
    }

    @Override
    public int medianPublicationYear_B(Map<BookSignature_B, Book_B> books_B) {
        if (books_B.size() == 0) return 0;
        int[] years = new int[books_B.size()];
        int n = 0;
        for (Map.Entry<BookSignature_B, Book_B> entry : books_B.entrySet()) {
            years[n] = entry.getValue().getYearOfPublication();
            n++;
        }
        Arrays.sort(years);
        if (years.length % 2 == 0) {
            return years[(int) (years.length / 2 + 0.5)];
        } else {
            return years[years.length / 2];
        }
    }

}
