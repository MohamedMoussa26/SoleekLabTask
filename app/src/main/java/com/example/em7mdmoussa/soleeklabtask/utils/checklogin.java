package com.example.em7mdmoussa.soleeklabtask.utils;

import android.text.TextUtils;

public class checklogin {

    public boolean checklogin(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) return false;
        return true;
    }

}
