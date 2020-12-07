package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.library_B.BookSignature_B;
import com.kodilla.patterns2.adapter.bookclassifier.library_B.BookStatistics_B;
import com.kodilla.patterns2.adapter.bookclassifier.library_B.Book_B;
import com.kodilla.patterns2.adapter.bookclassifier.library_B.Statistics_B;

import java.util.Map;

public class MedianAdaptee_B implements BookStatistics_B {


    @Override
    public int averagePublicationYear_B(Map<BookSignature_B, Book_B> books_B) {
        Statistics_B statistics_B = new Statistics_B();
        return statistics_B.averagePublicationYear_B(books_B);
    }

    @Override
    public int medianPublicationYear_B(Map<BookSignature_B, Book_B> books_B) {
        Statistics_B statistics_B = new Statistics_B();
        return statistics_B.medianPublicationYear_B(books_B);
    }
}
