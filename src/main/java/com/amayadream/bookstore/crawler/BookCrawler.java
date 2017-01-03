package com.amayadream.bookstore.crawler;

import com.amayadream.bookstore.model.Book;
import com.amayadream.bookstore.model.Chapter;
import com.amayadream.bookstore.utils.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * 针对http://www.bxwx.com/
 * @author :  Amayadream
 * @date :  2017.01.03 21:02
 */
@Controller
@RequestMapping(value = "/test")
public class BookCrawler {

    @Resource
    private MongoTemplate template;

    public static final String ROOT_PATH = "http://www.bxwx.com";

    @RequestMapping(value = "/1")
    public void test() throws IOException {
        String root = "http://www.bxwx.com/shuku/quanbu_default_0_0_0_0_0_0_";
        String path = "";
        for (int i = 1; i <= 1358; i ++){
            System.out.println("状态: 爬取, 正在爬取第" + i + "页");
            path = root + i + ".html";
            URL url = new URL(path);
            Document doc = Jsoup.parse(url, 10000);
            Elements lis = doc.getElementsByClass("listconl").first().getElementsByClass("clearfix").first().getElementsByTag("li");
            for (Element li : lis) {
                String type = li.getElementsByClass("jhfd").first().text();
                Book book = new Book();
                book.setBookId(StringUtil.getGuid());
                book.setBookName(li.getElementsByTag("a").first().text().replaceAll("全集", ""));
                book.setBookType(type.substring(1, type.indexOf("]")));
                book.setAuthor(li.getElementsByClass("nichen").first().text());
                book.setStatus(li.getElementsByClass("width85").first().text());
                book.setUpdateTime(new Date());
                template.save(book);
                String u = li.getElementsByTag("a").first().attr("href");
                Document d = Jsoup.parse(new URL(u), 10000);
                String listUrl = d.getElementsByClass("viewalllinks").first().attr("href");
                Document chapters = Jsoup.parse(new URL(listUrl), 10000);
                Elements elements = chapters.getElementsByClass("chapters").first().getElementsByTag("li");
                for (Element element : elements) {
                    String chapterUrl = ROOT_PATH + element.getElementsByTag("a").attr("href");
                    Document c = Jsoup.parse(new URL(chapterUrl), 10000);
                    Chapter chapter = new Chapter();
                    chapter.setBookId(book.getBookId());
                    chapter.setChapterId(StringUtil.getGuid());
                    chapter.setTitle(c.getElementsByTag("h1").first().text());
                    chapter.setContent(c.getElementById("BookText").html());
                    chapter.setUpdateTime(new Date());
                    template.save(chapter);
                }
            }
            System.out.println("状态: 完成, 已经爬取第" + i + "页");
        }
    }


}
