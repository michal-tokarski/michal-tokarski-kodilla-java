package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){

        // Given
        Invoice invoice1 = new Invoice("Invoice w/ 1 items");
        Invoice invoice2 = new Invoice("Invoice w/ 0 items");
        Invoice invoice3 = new Invoice("Invoice w/ 3 item");

        List<Item> items1 = new ArrayList<>();
        List<Item> items2 = new ArrayList<>();
        List<Item> items3 = new ArrayList<>();

        Product product1 = new Product("screwdriver");
        Product product2 = new Product("chainsaw");
        Product product3 = new Product("10 inch nails");

        items1.add(new Item(product1, new BigDecimal(10), 3));
        items3.add(new Item(product1, new BigDecimal(10), 9));
        items3.add(new Item(product2, new BigDecimal(2000), 1));
        items3.add(new Item(product3, new BigDecimal(2), 400));

        invoice1.setItems(items1);
        invoice2.setItems(items2);
        invoice3.setItems(items3);

        // When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        invoiceDao.save(invoice3);

        int retrievedID_1 = invoice1.getInvoiceID();
        int retrievedID_2 = invoice2.getInvoiceID();
        int retrievedID_3 = invoice3.getInvoiceID();

        Invoice retrievedInvoice_1 = invoiceDao.findById(retrievedID_1);
        Invoice retrievedInvoice_2 = invoiceDao.findById(retrievedID_2);
        Invoice retrievedInvoice_3 = invoiceDao.findById(retrievedID_3);

        // Then
        // - Check for invoice's number of items
        Assert.assertEquals(1, retrievedInvoice_1.getItems().size());
        Assert.assertEquals(0, retrievedInvoice_2.getItems().size());
        Assert.assertEquals(3, retrievedInvoice_3.getItems().size());

        // Then
        // - Check for invoice's total value
        Assert.assertTrue(BigDecimal.valueOf(30).compareTo(retrievedInvoice_1.getTotalValue()) == 0);
        Assert.assertTrue(BigDecimal.valueOf(0).compareTo(retrievedInvoice_2.getTotalValue()) == 0);
        Assert.assertTrue(BigDecimal.valueOf(2890).compareTo(retrievedInvoice_3.getTotalValue()) == 0);

        // CleanUp
        invoiceDao.deleteById(retrievedID_1);
        invoiceDao.deleteById(retrievedID_2);
        invoiceDao.deleteById(retrievedID_3);

    }

}
