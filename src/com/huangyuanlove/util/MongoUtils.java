package com.huangyuanlove.util;

import com.huangyuanlove.bean.UserBean;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

/**
 * Created by huangyuan on 16-1-27.
 */
public class MongoUtils {


    private static Mongo mongo = new Mongo();
    private static DB mongoDB;
    private static DBCollection dbCollection;
    public static Mongo getMongo()
    {
        if(mongo == null) {
            mongo = new Mongo();
        }
        return mongo;
    }

    public static DB getMongoDB(String dbName)
    {
        if(mongoDB == null)
        {
            mongoDB = getMongo().getDB(dbName);
        }
        return mongoDB;
    }

    public static DBCollection getDBCollection(String dbName,String collectionName)
    {
        if(dbCollection == null)
        {
            dbCollection = getMongoDB(dbName).getCollection(collectionName);
        }
        return dbCollection;
    }

}
