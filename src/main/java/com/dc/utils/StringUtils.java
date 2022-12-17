package com.dc.utils;

import java.util.Arrays;
import java.util.Objects;

public class StringUtils {

    private StringUtils(){

    }

    public static String toString(Object obj){
        return Objects.isNull(obj) ? (String) obj :obj.getClass().isArray() ? obj instanceof byte[] ? new String((byte[])obj) :
                Arrays.toString((Object[]) obj) : obj.toString();
    }

    public static boolean nonEmpty(CharSequence cs){
        return !isEmpty(cs);
    }

    public static String replaceObjNull(Object o){
        return Objects.nonNull(o) ? o.toString() : null;
    }

    public static boolean isNumberic(CharSequence cs){
        if(isEmpty(cs)){
            return false;
        }
        final int sz =cs.length();
        for(int i=0;i < sz; i++){
            if(!Character.isDigit(cs.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence){
        return isNull(charSequence) || charSequence.length() ==0;
    }

    public static boolean isNull(Object obj){
        return obj == null;
    }

    public final static  boolean nonBlank(final CharSequence cs){
        return !isBlank(cs);
    }

    public final static boolean isBlank(final CharSequence cs){
        int strLen;
        if(cs == null || (strLen = cs.length()) == 0){
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if(!Character.isWhitespace(cs.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
