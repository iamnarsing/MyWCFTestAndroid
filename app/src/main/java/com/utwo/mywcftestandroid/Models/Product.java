package com.utwo.mywcftestandroid.Models;

import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

/**
 * Created by ammic on 2015/10/22.
 */
public class Product extends BaseModel {
    public static Class PRODUCT_CLASS = Product.class;

    private int ProductID;
    private String ProductName;

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    @Override
    public Object getProperty(int index) {
        switch (index) {
            case 0:
                return ProductID;
            case 1:
                return ProductName;
            default:
                return null;
        }
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
        switch (i)
        {
            case 0:
                propertyInfo.type = PropertyInfo.INTEGER_CLASS;
                propertyInfo.name = "ProductID";
                break;
            case 1:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "ProductName";
                break;
            default:
                break;
        }
    }

    @Override
    public void setProperty(int index, Object value) {
        switch (index) {
            case 0:
                ProductID = (Integer) value;
                break;
            case 1:
                ProductName = (String) value;
                break;
            default:
                return;
        }
    }

    @Override
    public String getInnerText() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInnerText(String arg0) {
        // TODO Auto-generated method stub
    }
}
