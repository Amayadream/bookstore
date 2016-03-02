package com.amayadream.bookstore.test;

import com.mongodb.*;
import org.junit.Test;

/**
 * @author :  Amayadream
 * @date :  2016.03.01 22:41
 */
public class MongoTest {

    @Test
    public void asd(){
        try {
            Mongo mongo = new Mongo("localhost", 27017);

            DB db = mongo.getDB("Amayadream");

            DBCollection collection = db.getCollection("col");

            BasicDBObject employee = new BasicDBObject();
            employee.put("name", "Hannah");
            employee.put("no", 2);

            collection.insert(employee);

            BasicDBObject searchEmployee = new BasicDBObject();
            searchEmployee.put("no", 2);

            DBCursor cursor = collection.find(searchEmployee);

            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            System.out.println("The Search Query has Executed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
