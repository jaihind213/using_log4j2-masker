package io.github.jaihind213;

import org.apache.logging.log4j.Logger;

import java.util.Properties;

import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * Hello world!
 *
 */
public class Demo
{
    private static final Logger logger = getLogger(Demo.class.getName());
    public static void main( String[] args )
    {
        Properties configs = new Properties();
        //We wish to censor these properties
        configs.put("db.user", "admin");
        configs.put("db.passwd", "startrek123");
        configs.put("aws.access_key", "@12h7$");
        configs.put("aws.client.id", "hellothere@");
        configs.put("threshold_days", "10");

        //pass configs to LogCensor
        LogCensor.detectSensitiveConfigs(configs);

        //You notice The keywords from the configuration parameters are:
        //user (from db.user), passwd(from db.passwd), key (from aws.access_key)
        //client.id (from aws.client.id)
        //These keywords are to be speficied in log4j2.properties

        String dbPasswd = configs.getProperty("db.passwd");
        logger.info("Trying to log the db passwd: " + dbPasswd);

        //try to log it :)
        logger.info("Connecting to database with user: "
                + configs.getProperty("db.user")
                + " and password: " + configs.getProperty("db.passwd"));

        logger.info("Connecting to AWS with access key: " + configs.getProperty("aws.access_key")
                + " and client id: " + configs.getProperty("aws.client.id"));

        logger.info("logging (non-sensitive config) Threshold days: " + configs.getProperty("threshold_days"));
    }
}
