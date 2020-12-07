package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.library_A.Book_A;
import com.kodilla.patterns2.adapter.bookclassifier.library_A.Classifier_A;
import com.kodilla.patterns2.adapter.bookclassifier.library_B.BookSignature_B;
import com.kodilla.patterns2.adapter.bookclassifier.library_B.Book_B;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter_A extends MedianAdaptee_B implements Classifier_A {

    @Override
    public int publicationYearMedian_A(Set<Book_A> bookSet_A) {

        Map<BookSignature_B, Book_B> books_B = new HashMap<>();

        for (Book_A book_A : bookSet_A) {
            books_B.put(
                    new BookSignature_B(
                            book_A.getSignature()),
                    new Book_B(
                            book_A.getAuthor(),
                            book_A.getTitle(),
                            book_A.getPublicationYear()
                    )
            );
        }

        return medianPublicationYear_B(books_B);
    }

}
