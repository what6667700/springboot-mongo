package com.dc.utils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class CommonUtils {
    private CommonUtils(){}


    public static boolean isNullOrEmpty(Collection<?> collection){
        return Objects.isNull(collection) || collection.isEmpty();
    }

    public static boolean nonNullOrEmpty(Collection<?> collection){
        return Objects.nonNull(collection) && ! collection.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<?,?> map){
        return Objects.isNull(map) || map.isEmpty();
    }

    public static boolean nonNullOrEmpty(Map<?,?> map){
        return Objects.nonNull(map) && !map.isEmpty();
    }

    public static boolean nonNull(Object object){
        return StringUtils.nonEmpty(StringUtils.replaceObjNull(object));
    }

}
