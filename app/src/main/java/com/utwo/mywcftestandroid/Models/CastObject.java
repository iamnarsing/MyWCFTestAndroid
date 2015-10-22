package com.utwo.mywcftestandroid.Models;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.Date;

/**
 * Created by ammic on 2015/10/22.
 */
public class CastObject {
    public static KvmSerializable parseToObject(SoapObject soapObject, Class objectClass) throws IllegalAccessException, InstantiationException {

        KvmSerializable result = (KvmSerializable) objectClass.newInstance();

        int numOfAttr = result.getPropertyCount();

        for (int i = 0; i < numOfAttr; i++) {
            PropertyInfo info = new PropertyInfo();
            result.getPropertyInfo(i, null, info);

            //处理property不存在的情况
            try {
                if (info.getType() == PropertyInfo.STRING_CLASS) {
                    result.setProperty(i, soapObject.getPropertySafelyAsString(info.name));
                } else if (info.getType() == PropertyInfo.INTEGER_CLASS) {
                    result.setProperty(i, Integer.parseInt(soapObject.getPropertySafelyAsString(info.name)));
                } else if (info.getType() == PropertyInfo.LONG_CLASS) {
                    result.setProperty(i, Long.parseLong(soapObject.getPropertySafelyAsString(info.name)));
                } else if (info.getType() == PropertyInfo.BOOLEAN_CLASS) {
                    result.setProperty(i, Boolean.parseBoolean(soapObject.getPropertySafelyAsString(info.name)));
                } else if (info.getType() == Float.class) {
                    result.setProperty(i, Float.parseFloat(soapObject.getPropertySafelyAsString(info.name)));
                } else if (info.getType() == Date.class) {
                    //result.setProperty(i, Date.parseFloat(soapObject.getProperty(info.name).toString()));
                }
            } catch (Exception e) {
                continue;
            }
        }

        return result;
    }
}
