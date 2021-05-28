package com.accenture.domaincrawler;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domain")
public class DomainCrawlerController {

    private final DomainCrawlerService domainCrawlerService;

    public DomainCrawlerController(DomainCrawlerService domainCrawlerService) {
        this.domainCrawlerService = domainCrawlerService;
    }

    @PostMapping("/add")
    public void add(@RequestBody Domain domain){
        domainCrawlerService.add(domain);
    }

    @GetMapping("/lookup/{name}")
    public String lookUp(@PathVariable(name = "name") String name){
    domainCrawlerService.crawl(name);
    return "Domain crawler has scrapped your data";
    }
}
