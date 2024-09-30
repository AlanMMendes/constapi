package com.example.constapi.service;

import com.example.constapi.crawler.CrawlerObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CrawlerService {
    public List<CrawlerObject> searchMagnets(String url) {
        List<CrawlerObject> item = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();

            Element tabela = doc.select("table").first();
            for (Element linha : tabela.select("tr")) {

                Elements celulas = linha.select("td");

                for (Element celula : celulas) {
                    Elements links = celula.select("a.detLink");
                    for (Element link : links) {
                        String href = link.attr("href");
                        String title = link.attr("title");
                        item.add(new CrawlerObject(title, href));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return item;
    }
}
