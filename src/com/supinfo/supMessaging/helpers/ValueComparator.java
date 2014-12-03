package com.supinfo.supMessaging.helpers;

import com.supinfo.supMessaging.entities.Message;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Long> {

    Map<Long, Message> base;

    public ValueComparator(Map<Long, Message> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    public int compare(Long a, Long b) {
        if (base.get(a).getSendDate().compareTo(base.get(b).getSendDate()) > 0) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
