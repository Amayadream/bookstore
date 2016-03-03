package com.amayadream.test.morphia;

import com.amayadream.test.entity.User;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.EntityInterceptor;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.MappedClass;
import org.mongodb.morphia.mapping.Mapper;

/**
 * @author :  Amayadream
 * @date :  2016.03.03 22:12
 */
public class MorphiaTest {
    private Mongo mongo;
    private Morphia morphia;

    @Before
    public void init(){
        try {
            mongo = new Mongo();
        } catch (MongoException e) {
            e.printStackTrace();
        }
        morphia = new Morphia();
    }
    private void print(Object o){
        System.out.println(o.toString());
    }

    @Test
    public void testMorphia() {
        //设置操作资源对象,这里设置User.class就可以对User进行一系列操作
        //将对象转换成object
        print("toDBObject: " + morphia.toDBObject(new User("asd", "jackson", "22", "123")));
        print("getMapper: " + morphia.getMapper());
        print("isMapped: " + morphia.isMapped(User.class));
    }

    @Test
    public void testMapper(){
        Mapper mapper = morphia.getMapper();
        //添加对象映射
        print("addMappedClass: " + mapper.addMappedClass(User.class));
        //创建实体缓存
        print("createEntityCache: " + mapper.createEntityCache());
        print(mapper.getCollectionName("user"));
        print(mapper.getConverters());
        User user = new User("123", "Jacks", "asd", "ads");
        user.setId("123123123");
        for (EntityInterceptor entityInterceptor : mapper.getInterceptors()) {
            System.out.println("EntityInterceptor: " + entityInterceptor);
        }
        print("getKey: " + mapper.getKey(user));
        for (MappedClass mc : mapper.getMappedClasses()) {
            System.out.println("getMappedClasses: " + mc);
        }
        print("mcMap: " + mapper.getMCMap());
        print("getOptions: " + mapper.getOptions());
        print("keyToRef: " + mapper.keyToDBRef(mapper.getKey(user)));
        print("refToKey:" + mapper.refToKey(mapper.keyToDBRef(mapper.getKey(user))));

    }


}





