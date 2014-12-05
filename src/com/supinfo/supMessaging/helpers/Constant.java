package com.supinfo.supMessaging.helpers;

import com.supinfo.supMessaging.entities.User;

public class Constant {
    public static final String userSession = "userId";

    public static User getAnonymousUser() {
        User anonim = new User();
        anonim.setMail("");
        anonim.setUserName("Anonymous");
        anonim.setId((long) -1);
        return anonim;
    }
}
