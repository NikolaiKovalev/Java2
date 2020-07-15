package by.academy.it;


import java.sql.SQLException;

public interface ReceiversDao {

    int create(ReceiversDto receiversDto) throws SQLException;

    ReceiversDto read(int num) throws SQLException;

    void update(ReceiversDto receiversDto) throws SQLException;

    boolean delete(ReceiversDto receiversDto) throws SQLException;

    boolean delete(int num) throws SQLException;

    int getMaxId() throws SQLException;

}
