package com.amayadream.test.mongodb;

import com.amayadream.test.entity.User;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.junit.Test;

/**
 * @author :  Amayadream
 * @date :  2016.03.03 21:31
 */
public class MongoTest {

    @Test
    public void test(){
        Mongo mongo = new Mongo();
        System.out.println("查询所有Database");
        for (String name : mongo.getDatabaseNames()){
            System.out.println("dbName: " + name);
        }
        System.out.println("查询Amayadream库中的所有collection集合名词");
        DB db = mongo.getDB("Amayadream");
        for (String name : db.getCollectionNames()) {
            System.out.println("collectionName: " + name);
        }
        System.out.println("添加测试数据");
        DBCollection users = db.getCollection("user");
        try {
            DBObject user = BasicDBObjectUtils.castModel2DBObject(new User("123456", "Jack", "asd", "123456"));
            users.insert(user);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("游标查询所有users集合数据");
        DBCursor cursor = users.find();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        System.out.println("查询游标相关内容");
        System.out.println(cursor.count());
        System.out.println(cursor.getCursorId());
        System.out.println(cursor.getOptions());
        System.out.println(cursor.getQuery());
        System.out.println(cursor.itcount());
        System.out.println(cursor.length());
        System.out.println(cursor.size());
        System.out.println(cursor.curr());
        System.out.println("显示游标查询到的所有内容: " + JSON.serialize(cursor));

    }
}
