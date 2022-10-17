package com.phone;

import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {
    private int totalCount;

    private List<Contact> results;

    public SearchResponse(int totalCount, List<Contact> results) {
        this.totalCount = totalCount;
        this.results = results;
    }
}
