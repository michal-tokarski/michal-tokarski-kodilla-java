/*
-------------------------------------------------------------------------------------------
Task 24.3
Zadanie: Dodajemy logowanie żądań do fasady
W submodule 20.1 projektowaliśmy fasadę.
Dopisz do niej aspekty wykonujące zapisy do logów każdego wywołania metody processOrder().
Aby dodać aspekt do klasy OrderFacade musisz usunąć słowo final z jej deklaracji
- nie można tworzyć aspektów dla klas, z których zablokowano dziedziczenie.
-------------------------------------------------------------------------------------------
*/

package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeAspectsWatcher {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderFacadeAspectsWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)")
    public void logEvent(OrderDto order, Long userId, Object object) {
        LOGGER.info(
            "\n Event log : Method call of OrderFacade.processOrder :" +
            "\n 1) Arg Object : " + object.getClass().getName() +
            "\n 2) Arg User : " + userId +
            "\n 3) Arg Order : " + order.toString()
        );
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

}
