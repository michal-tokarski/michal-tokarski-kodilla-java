package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {
    private int invoiceID;
    private String invoiceNumber;
    private List<Item> items = new ArrayList<>();
    private BigDecimal totalValue;

    public Invoice() {
    }

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        this.items = items;
    }

    // Getters :
    // -------------------------------

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "INVOICE_ID", unique = true)
    public int getInvoiceID() {
        return invoiceID;
    }

    @NotNull
    @Column(name = "INVOICE_NUMBER", unique = true)
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public List<Item> getItems() {
        return items;
    }

    @Column(name = "TOTAL_VALUE")
    public BigDecimal getTotalValue() {
        BigDecimal totalValue = BigDecimal.valueOf(0);

        for(Item item : items) {
            totalValue = totalValue.add(item.getValue());
        }
        return totalValue;
    }

    // Setters :
    // -------------------------------

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    // toString :
    // -------------------------------

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceID=" + invoiceID +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", items=" + items +
                ", totalValue=" + totalValue +
                '}';
    }

}