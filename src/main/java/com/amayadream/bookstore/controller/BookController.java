package com.amayadream.bookstore.controller;

import com.amayadream.bookstore.utils.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping(value = "/book")
public class BookController {

    @RequestMapping(value = "")
    public String index(){
        return "index";
    }

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
                map.put("bookUrl", Constants.ROOT_PATH + item.getElementsByTag("a").first().attr("href"));
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
                map.put("bookUrl", Constants.ROOT_PATH + li.getElementsByClass("s2").first().getElementsByTag("a").first().attr("href"));
                map.put("latestUrl", Constants.ROOT_PATH + li.getElementsByClass("s3").first().getElementsByTag("a").first().attr("href"));
                latest.add(map);
            }
        }
        List<Map<String, String>> good = new ArrayList<Map<String, String>>();
        Elements r = doc.getElementsByClass("l");
        for (Element element : r) {
            Elements ul = element.getElementsByTag("li");
            for (Element li : ul) {
                map = new HashMap<String, String>();
                map.put("s1", li.getElementsByClass("s1").first().text());
                map.put("s2", li.getElementsByClass("s2").first().text());
                map.put("s5", li.getElementsByClass("s5").first().text());
                map.put("bookUrl", Constants.ROOT_PATH + li.getElementsByClass("s2").first().getElementsByTag("a").first().attr("href"));
                good.add(map);
            }
        }
        model.addAttribute("hot", hot);
        model.addAttribute("latest", latest);
        model.addAttribute("good", good);
        return "index";
    }
}
