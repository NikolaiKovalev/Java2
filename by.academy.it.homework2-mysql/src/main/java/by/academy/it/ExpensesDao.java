package by.academy.it;


import java.sql.SQLException;

public interface ExpensesDao {

    int create(ExpensesDto expensesDto) throws SQLException;

    ExpensesDto read(int num) throws SQLException;

    void update(ExpensesDto expensesDto) throws SQLException;

    boolean delete(ExpensesDto expensesDto) throws SQLException;

    boolean delete(int num) throws SQLException;

    int getMaxId() throws SQLException;

}
