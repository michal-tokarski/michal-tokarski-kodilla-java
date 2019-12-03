package com.kodilla.good.patterns.challenges.Allegro;

public class ProductOrderDTO {

    public ProductOrder productOrder;
    public boolean isProcessed;

    public ProductOrderDTO (final ProductOrder productOrder, final boolean isProcessed) {
        this.productOrder = productOrder;
        this.isProcessed = isProcessed;
    }

}
