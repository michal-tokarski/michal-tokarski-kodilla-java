package com.kodilla.patterns2.adapter.bookclassifier.library_B;

import java.util.Map;

public interface BookStatistics_B {

    int averagePublicationYear_B(Map<BookSignature_B, Book_B> books_B);
    int medianPublicationYear_B(Map<BookSignature_B, Book_B> books_B);

}
