package com.accenture.domaincrawler;

import java.util.ArrayList;
import java.util.List;

public class DomainList {
    List<Domain> domains = new ArrayList<>();

    public DomainList() {
    }


    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    public DomainList(List<Domain> domains) {
        this.domains = domains;
    }
}
