package com.phone.CustomDataStructure;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class TrieNode {
    int size;
    Map<Character, TrieNode> next;

    Set<String> partialWordIds;
    Set<String> completeWordIds;

    TrieNode() {
        partialWordIds = new HashSet<>();
        completeWordIds = new HashSet<>();
        this.next = new HashMap<>();
    }

}
