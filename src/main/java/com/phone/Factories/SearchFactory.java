package com.phone.Factories;

import com.phone.Search.SearchStrategy.CompleteWordSearchStrategy;
import com.phone.Search.SearchStrategy.PrefixWordSearchSTrategy;
import com.phone.Search.SearchStrategy.SearchStrategy;
import com.phone.Search.SearchStrategy.PartialWordSearchStrategy;
import com.phone.SearchType;

public class SearchFactory {
    public static SearchStrategy getSearchStrategy (SearchType searchType) {
        if(searchType == SearchType.COMPLETE){
            return new CompleteWordSearchStrategy();
        } else if( searchType == SearchType.PARTIAL) {
            return new PrefixWordSearchSTrategy();
        }

        return new PartialWordSearchStrategy();
    }
}
