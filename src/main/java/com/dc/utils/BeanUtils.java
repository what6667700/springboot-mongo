package com.dc.utils;

import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class BeanUtils {

    public static Object getObjectFieldValue(Object object,String clazzName,String fieldName){
        try {
            Class<?> clazz = ClassUtils.forName(clazzName,ClassUtils.getDefaultClassLoader());
            if(ClassUtils.isAssignableValue(clazz,object)){
                Field field = object.getClass().getDeclaredField(fieldName);
                return getObjectFieldValue(object,field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getObjectFieldValue(Object object, Field field) {
        try {
            ReflectionUtils.makeAccessible(field);
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
