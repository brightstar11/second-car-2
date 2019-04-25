package com.xh.common;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class py {
    private String url = "https://www.renrenche.com";
    private Map<String, List<String>> xilie = new HashMap<>();

    public py() {
    }

    public void crawle() {
        try {
            System.out.println("*********开始爬虫*********");
            Document doc = Jsoup.connect(url + "/cd/ershouche/").get();
            Element content = doc.getElementById("filter_brand");

            if (null != content) {
                Elements elements = content.getElementsByClass("js-filter");
                for (int j = 0; j < elements.size(); j++) {
                    if (!"不限".equals(elements.get(j).attr("rrc-event-name"))) {
                        xilie.put(elements.get(j).attr("rrc-event-name"),new ArrayList<>());
                        System.out.println("车型：" + "--------------" + elements.get(j).attr("rrc-event-name"));
                        Document doc1 = Jsoup.connect(url + elements.get(j).attr("data-href")).get();
                        Element content1 = doc1.getElementById("filter_series");
                        if (null != content1) {
                            Elements elements1 = content1.getElementsByClass("js-filter");
                            for (int i = 0; i < elements1.size(); i++) {
                                if (!"不限".equals(elements1.get(i).attr("rrc-event-name"))) {
                                    xilie.get(elements.get(j).attr("rrc-event-name")).add(elements1.get(i).attr("rrc-event-name"));
                                    System.out.println("系列：" + "--------------" + elements1.get(i).attr("rrc-event-name"));
                                    for (int page = 1; page <= 2; page++) {
                                        Document doc2 = Jsoup.connect(url + elements1.get(j).attr("data-href") + "p" + page + "/?" + elements.get(j).attr("data-key") + "=" + elements.get(j).attr("data-value") + "&" + elements1.get(i).attr("data-key") + "=" + elements1.get(i).attr("data-value")).get();
                                        Elements content2 = doc2.select(".thumbnail");
                                        if (null != content2) {
                                            for (int x = 0; x < content2.size(); x++) {
                                                Document doc3 = Jsoup.connect(url + content2.get(x).attr("href")).get();
                                                Elements e = doc3.select(".module-base-content-item.clearfixnew");
                                                if (e == null) continue;
                                                Map map = new HashMap();
                                                for (Element e1 : e) {
                                                    map.put(e1.select(".module-base-content-key").text(), e1.select(".module-base-content-value").text());
                                                }
                                                e = doc3.select(".row-fluid.list-unstyled.box-list-primary-detail li");
                                                if (e == null) continue;
                                                for (Element e1 : e) {
                                                    map.put(e1.select(".small-title").size() == 0 ? "无数据" : e1.select(".small-title").text(), e1.select(".car-summary").text());
                                                }
                                                map.put("价格", doc3.select(".price.detail-title-right-tagP").text() + "万");
                                                map.put("新车价格", doc3.select(".new-car-price.detail-title-right-tagP span").text());

                                                System.out.println(url + content2.get(x).attr("href") + "--" + map.toString());
                                            }
                                        }

                                    }
                                }
                            }
                        }

                    }

                }
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    public static void main(String[] args) {
        py jHtml = new py();
        jHtml.crawle();
        System.out.println(jHtml.xilie);

    }
}