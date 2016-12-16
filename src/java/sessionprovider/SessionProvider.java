/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionprovider;

import br.com.persistor.enums.DB_TYPE;
import br.com.persistor.generalClasses.DBConfig;
import br.com.persistor.interfaces.Session;
import br.com.persistor.sessionManager.SessionFactory;
import loggers.PersistenceLogger;

/**
 *
 * @author marcosvinicius
 */
public class SessionProvider
{

    private static String database = "agenda";
    private static String host = "localhost";
    private static int port = 3306;
    private static String user = "root";
    private static String password = "81547686";
    private static DB_TYPE db_type = DB_TYPE.MySQL;

    private static SessionFactory factory = null;

    public static Session openSession()
    {
        try
        {
            if (factory == null)
                factory = new SessionFactory();

            DBConfig config = new DBConfig();
            config.setDatabase(database);
            config.setHost(host);
            config.setPort(port);
            config.setDb_type(db_type);
            config.setUser(user);
            config.setPassword(password);
            config.setPersistenceLogger(PersistenceLogger.class);

            return factory.getSession(config);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
