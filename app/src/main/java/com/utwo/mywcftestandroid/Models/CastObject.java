package com.utwo.mywcftestandroid.Models;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

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
                    result.setProperty(i, soapObject.getProperty(info.name).toString());
                } else if (info.getType() == PropertyInfo.INTEGER_CLASS) {
                    result.setProperty(i, Integer.parseInt(soapObject.getProperty(info.name).toString()));
                }
            } catch (Exception e) {
                continue;
            }
        }

        return result;
    }
}
