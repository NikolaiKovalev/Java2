package by.academy.it;

import java.security.InvalidParameterException;
import java.sql.SQLException;

public class ExpenseDaoFactory {
    private static ExpensesDaoImpl expensesDao;

    public static ExpensesDao getExpensesDao(String database) throws SQLException {
        if ("mysql".equals(database)) {
            if (expensesDao == null) {
                expensesDao = new ExpensesDaoImpl();
            }
            return expensesDao;
        } else if ("mysql_test".equals(database)) {
            if (expensesDao == null) {
                expensesDao = new ExpensesDaoImpl(true);
            }
            return expensesDao;
        }
        throw new InvalidParameterException("No such database implemented " + database);
    }
}
