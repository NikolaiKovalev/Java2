package by.academy.it;

import java.security.InvalidParameterException;
import java.sql.SQLException;

public class ReceiversDaoFactory {
    private static ReceiversDaoImpl receiversDao;

    public static ReceiversDao getReceiversDao(String database) throws SQLException {
        if ("mysql".equals(database)) {
            if (receiversDao == null) {
                receiversDao = new ReceiversDaoImpl();
            }
            return receiversDao;
        } else if ("mysql_test".equals(database)) {
            if (receiversDao == null) {
                receiversDao = new ReceiversDaoImpl(true);
            }
            return receiversDao;
        }
        throw new InvalidParameterException("No such database implemented " + database);
    }
}
