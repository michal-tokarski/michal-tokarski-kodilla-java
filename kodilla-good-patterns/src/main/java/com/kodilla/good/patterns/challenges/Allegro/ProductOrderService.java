package com.kodilla.good.patterns.challenges.Allegro;

public class ProductOrderService {

    private ProductOrder productOrder;
    private InfoService_email infoService_email;
    private ProductOrderRepository productOrderRepository;

    public ProductOrderService (
            final ProductOrder productOrder,
            final InfoService_email infoService_email,
            final ProductOrderRepository productOrderRepository
    )
    {
        this.productOrder = productOrder;
        this.infoService_email = infoService_email;
        this.productOrderRepository = productOrderRepository;
    }


    public ProductOrderDTO process(ProductOrder productOrder) {

        if (productOrder.getIsReceived()) {
            infoService_email.notifyCustomer(productOrder, "Your order has been received");
        }

        if (productOrder.getIsPaid()) {
            infoService_email.notifyCustomer(productOrder, "Your order has been paid");
        }

        if (productOrder.getIsAuthorized()) {
            infoService_email.notifyCustomer (productOrder, "Your order has been authorized");
            productOrderRepository.addProductOrder(productOrder);

            productOrder.ship();
            if (productOrder.getIsShipped()) {
                infoService_email.notifyCustomer (productOrder, "Your order has been shipped");
            }
            productOrder.deliver();
            if (productOrder.getIsDelivered()) {
                infoService_email.notifyCustomer (productOrder, "Your order has been delivered");
            }

            return new ProductOrderDTO(productOrder, true);

        } else {

            infoService_email.notifyCustomer (productOrder, "Your order has been rejected");
            return new ProductOrderDTO (productOrder, false);

        }
    }

}


