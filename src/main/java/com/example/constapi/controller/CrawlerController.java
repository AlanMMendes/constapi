package com.example.constapi.controller;


import com.example.constapi.crawler.CrawlerObject;
import com.example.constapi.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrawlerController {

    @Autowired
    private CrawlerService webCrawlerServiceService;

    @GetMapping("/crawl")
    public List<CrawlerObject> crawl(@RequestParam String url) {
        return webCrawlerServiceService.searchMagnets(url);
    }

}