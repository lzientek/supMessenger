package com.supinfo.supMessaging.helpers;

import com.supinfo.supMessaging.entities.Message;

import java.util.Comparator;

public class ValueComparator implements Comparator<Message> {


    // Note: this comparator imposes orderings that are inconsistent with equals.
    public int compare(Message a, Message b) {
        if (a.getSendDate().compareTo(b.getSendDate()) > 0) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
