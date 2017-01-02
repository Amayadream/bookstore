package com.amayadream.bookstore.controller;

import com.amayadream.bookstore.utils.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :  Amayadream
 * @date :  2017.01.02 13:50
 */
@Controller
@RequestMapping(value = "")
public class BookController {

    /**
     * 各频道主页
     */
    @RequestMapping(value = "/{channel}")
    public String channel(@PathVariable String channel, Model model) throws IOException {
        if(!channel.endsWith("/")) channel = channel + "/";
        URL url = new URL(Constants.ROOT_PATH + "/" + channel);
        Document doc = Jsoup.parse(url, 5000);
        Elements ll = doc.getElementsByClass("ll");
        List<Map<String, String>> hot = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        for (Element element : ll) {
            Elements items = element.getElementsByClass("item");
            for (Element item : items) {
                map = new HashMap<String, String>();
                map.put("bookName", item.getElementsByTag("img").first().attr("alt"));
                map.put("bookImage", Constants.ROOT_PATH + item.getElementsByTag("img").first().attr("src"));
                map.put("author", item.getElementsByTag("span").first().text().trim());
                map.put("description", item.getElementsByTag("dd").first().text().trim());
                map.put("bookUrl", item.getElementsByTag("a").first().attr("href"));
                hot.add(map);
            }
        }
        List<Map<String, String>> latest = new ArrayList<Map<String, String>>();
        Elements l = doc.getElementsByClass("l");
        for (Element element : l) {
            Elements ul = element.getElementsByTag("li");
            for (Element li : ul) {
                map = new HashMap<String, String>();
                map.put("s1", li.getElementsByClass("s1").first().text());
                map.put("s2", li.getElementsByClass("s2").first().text());
                map.put("s3", li.getElementsByClass("s3").first().text());
                map.put("s4", li.getElementsByClass("s4").first().text());
                map.put("s5", li.getElementsByClass("s5").first().text());
                map.put("bookUrl", li.getElementsByClass("s2").first().getElementsByTag("a").first().attr("href"));
                map.put("latestUrl", li.getElementsByClass("s3").first().getElementsByTag("a").first().attr("href").replaceAll("\\.html", ""));
                latest.add(map);
            }
        }
        List<Map<String, String>> good = new ArrayList<Map<String, String>>();
        Elements r = doc.getElementsByClass("r");
        for (Element element : r) {
            Elements ul = element.getElementsByTag("li");
            for (Element li : ul) {
                map = new HashMap<String, String>();
                map.put("s1", li.getElementsByClass("s1").first().text());
                map.put("s2", li.getElementsByClass("s2").first().text());
                map.put("s5", li.getElementsByClass("s5").first().text());
                map.put("bookUrl", li.getElementsByClass("s2").first().getElementsByTag("a").first().attr("href"));
                good.add(map);
            }
        }
        model.addAttribute("hot", hot);
        model.addAttribute("latest", latest);
        model.addAttribute("good", good);
        return "index";
    }

    /**
     * 章节列表
     */
    @RequestMapping(value = "/book/{bookId}")
    public String profile(@PathVariable String bookId, Model model, HttpServletRequest request) throws IOException {
        if (!bookId.endsWith("/")) bookId = bookId + "/";
        URL url = new URL(Constants.ROOT_PATH + "/" + bookId);
        Document doc = Jsoup.parse(url, 5000);
        Element info = doc.getElementsByClass("box_con").first();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bookName", info.getElementsByTag("h1").first().text());
        map.put("bookImage", Constants.ROOT_PATH + info.getElementById("fmimg").getElementsByTag("img").attr("src"));
        map.put("author", info.getElementById("info").getElementsByTag("p").first().text().split("：")[1]);
        map.put("description", info.getElementById("intro").html());
        Element l = info.getElementById("info").getElementsByTag("p").last().getElementsByTag("a").first();
        map.put("latestChapter", l.text());
        map.put("latestUrl", bookId + l.attr("href").replaceAll("\\.html", ""));
        info.getElementById("info").getElementsByTag("p").last().remove();
        map.put("latestTime", info.getElementById("info").getElementsByTag("p").last().text().split("：")[1]);

        List<Map<String, Object>> latest = new ArrayList<Map<String, Object>>();
        Element list = doc.getElementById("list").getElementsByTag("dl").first();
        for (Element dd : list.getElementsByTag("dd")) {
            dd.getElementsByTag("a").attr("href", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/book" + dd.getElementsByTag("a").attr("href").replaceAll("\\.html", ""));
        }
        map.put("list", list.html());
        model.addAttribute("info", map);
        return "profile";
    }

    /**
     * 内容页
     */
    @RequestMapping(value = "/book/{bookId}/{chapterId}")
    public String content(@PathVariable String bookId, @PathVariable String chapterId, Model model) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        URL url = new URL(Constants.ROOT_PATH + "/" + bookId + "/" + chapterId + ".html");
        Document doc = Jsoup.parse(url, 5000);
        Element element = doc.getElementsByClass("bookname").first();
        map.put("title", element.getElementsByTag("h1").first().text());
        Elements tools = element.getElementsByClass("bottem1").first().getElementsByTag("a");
        for (int i = 0; i < tools.size(); i++) {
            String btn = tools.get(i).attr("href");
            if(i == 0){
                if(btn.contains("html")){
                    map.put("previous", tools.get(i).attr("href").split("\\.")[0]);
                }else if("./".equalsIgnoreCase(btn)){
                    map.put("previous", "");
                }
            }else if (i == 1){
                map.put("list", tools.get(i).attr("href").replaceAll("/", ""));
            }else if(i == 2){
                if(btn.contains("html")){
                    map.put("next", tools.get(i).attr("href").split("\\.")[0]);
                }else if("./".equalsIgnoreCase(btn)){
                    map.put("next", "");
                }
            }
        }
        map.put("content", doc.getElementById("content").html());
        model.addAttribute("info", map);
        return "content";
    }

}
