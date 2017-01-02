package com.amayadream.bookstore.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

/**
 * @author :  Amayadream
 * @date :  2017.01.02 13:22
 */
@Document(collection = "book")
@Repository
public class Book {

    /** 书名 */
    private String bookName;
    /** 缩略图 */
    private String bookImage;
    /** 作者 */
    private String author;
    /** 简介 */
    private String profile;
    /** 最新章节 */
    private String lastChapter;
    /** 更新时间 */
    private String modifyTime;


}
