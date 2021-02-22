package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {

    @Test
    public void test1_UpdateVipLevels() throws SQLException {

        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL = 'Not set' ";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        // When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        // Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL = 'Not set' ";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        Assert.assertEquals(0, howMany);

    }

    // W katalogu src/test/java, w pakiecie com.kodilla.jdbc, ...
    // ... w klasie StoredProcTestSuite przygotuj nowy test o nazwie testUpdateBestsellers.
    // W teście sprawdź działanie procedury składowanej UpdateBestsellers().
    @Test
    public void test2_UpdateBestsellers() throws SQLException {

        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = NULL";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        // When
        String sqlProceedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProceedureCall);

        // Then #1
        String sqlCheckTable1 = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = 1";
        ResultSet rs1 = statement.executeQuery(sqlCheckTable1);
        int howMany1 = 0;
        if (rs1.next()) {
            howMany1 = rs1.getInt("HOW_MANY");
        }
        Assert.assertEquals(4, howMany1);

        // Then #2
        String sqlCheckTable0 = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = 0";
        ResultSet rs0 = statement.executeQuery(sqlCheckTable0);
        int howMany0 = 0;
        if (rs0.next()) {
            howMany0 = rs0.getInt("HOW_MANY");
        }
        Assert.assertEquals(1, howMany0);

        // Then #3
        String sqlCheckTableNull = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER IS NULL";
        ResultSet rsNull = statement.executeQuery(sqlCheckTableNull);
        int howManyNull = -1;
        if (rsNull.next()) {
            howManyNull = rsNull.getInt("HOW_MANY");
        }
        Assert.assertEquals(0, howManyNull);
    }


}
