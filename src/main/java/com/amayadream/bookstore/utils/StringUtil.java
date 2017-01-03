package com.amayadream.bookstore.utils;

import java.util.UUID;

/**
 * @author :  Amayadream
 * @date :  2017.01.03 21:47
 */
public class StringUtil {

    public static String getGuid(){
        return UUID.randomUUID().toString().trim().replaceAll("-", "").toLowerCase();
    }

}
