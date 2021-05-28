package com.accenture.domaincrawler;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DomainCrawlerService {
    private final String KAFKA_TOPIC = "web-domains";

    public DomainCrawlerService(KafkaTemplate<String, Domain> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String,Domain> kafkaTemplate;

    public void crawl(String name) {
       DomainList domainList = populateDomainList();
       domainList.domains
                   .forEach(domain ->{
                       kafkaTemplate.send(KAFKA_TOPIC,domain);
                       System.out.println("Domain message = " + domain.getDomain());
                   });

    }






    private DomainList populateDomainList() {

        DomainList domainList = new DomainList();
        Domain domain = new Domain("facebook-repair.com"
                ,"2020-07-24T11:04:23.630715"
                ,"2020-07-26T11:04:23.630715"
                ,null
        ,false
        ,null
        ,null
        ,null
        ,null
        ,null);

        domainList.domains.add(domain);

        domain = new Domain("google-save.com"
                ,"2020-07-24T11:04:23.630715"
                ,"2020-07-5T11:04:23.630715"
                ,null
                ,false
                ,null
                ,null
                ,null
                ,null
                ,null);
        domainList.domains.add(domain);
        domain = new Domain("twitter-save.com"
                ,"2020-07-24T11:04:23.630715"
                ,"2020-07-5T11:04:23.630715"
                ,null
                ,true
                ,null
                ,null
                ,null
                ,null
                ,null);
        domainList.domains.add(domain);

        domain = new Domain("facebook-support-covid.com"
                ,"2020-07-24T11:04:23.630715"
                ,"2020-07-5T11:04:23.630715"
                ,null
                ,false
                ,null
                ,null
                ,null
                ,null
                ,null);

        domainList.domains.add(domain);
        domain = new Domain("yahoo-support-covid.com"
                ,"2020-07-24T11:04:23.630715"
                ,"2020-07-5T11:04:23.630715"
                ,null
                ,true
                ,null
                ,null
                ,null
                ,null
                ,null);

        domainList.domains.add(domain);
        return domainList;
    }

    public void add(Domain domain) {
        kafkaTemplate.send(KAFKA_TOPIC,domain);
        System.out.println("Domain message = " + domain.getDomain());
    }
          /* Mono<DomainList> domainListMono =
               WebClient.create()
                .get()
                .uri("https://api.domainsdb.info/v1/domains/search?domain="+name+"&zone=com")
                .accept(PageAttributes.MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(DomainList.class);

        domainListMono.subscribe(domainList -> {
            domainList.domains
                    .forEach(domain ->{
                        kafkaTemplate.send(KAFKA_TOPIC,domain);
                        System.out.println("Domain message = " + domain.getDomain());
                    });
        });*/
}
