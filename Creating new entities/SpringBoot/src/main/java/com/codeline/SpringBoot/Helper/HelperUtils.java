package com.codeline.SpringBoot.Helper;

import java.util.List;

public class HelperUtils {

    public static <T> Boolean isNull(T str){
        return null==str;
    }

    public static <T> Boolean isNotNull(T str){
        return !isNull(str);
    }

    public static <T> Boolean isNull(List<T> list) {
        return list==null;
    }

    public static <T> Boolean isNotNull(List<T> list) {
        return isNull(list);
    }

    public static <T> Boolean isListEmpty(List<T> list) {
        return list.isEmpty();
    }

    public static <T> Boolean isListNotEmpty(List<T> list) {
        return !isListEmpty(list);
    }
}
