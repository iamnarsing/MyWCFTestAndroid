package com.utwo.mywcftestandroid.Models;

import org.ksoap2.serialization.PropertyInfo;

import java.util.Date;
import java.util.Hashtable;

/**
 * Created by ammic on 2015/10/22.
 */
public class Product extends BaseModel {
    public static Class PRODUCT_CLASS = Product.class;

    private int ProductID;
    private String ProductName;
    private Date SoldOutDate;//DateTime放
    private float UnitPrice;
    private boolean IsSoldOut;

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

    public Date getSoldOutDate() {
        return SoldOutDate;
    }

    public void setSoldOutDate(Date soldOutDate) {
        SoldOutDate = soldOutDate;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        UnitPrice = unitPrice;
    }

    public boolean isSoldOut() {
        return IsSoldOut;
    }

    public void setIsSoldOut(boolean isSoldOut) {
        IsSoldOut = isSoldOut;
    }


    @Override
    public Object getProperty(int index) {
        switch (index) {
            case 0:
                return ProductID;
            case 1:
                return ProductName;
            case 2:
                return SoldOutDate;
            case 3:
                return UnitPrice;
            case 4:
                return IsSoldOut;
            default:
                return null;
        }
    }

    @Override
    public int getPropertyCount() {
        return 5;
    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
        switch (i) {
            case 0:
                propertyInfo.type = PropertyInfo.INTEGER_CLASS;
                propertyInfo.name = "ProductID";
                break;
            case 1:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "ProductName";
                break;
            case 2:
                propertyInfo.type = Date.class;
                propertyInfo.name = "SoldOutDate";
                break;
            case 3:
                propertyInfo.type = Float.class;
                propertyInfo.name = "UnitPrice";
                break;
            case 4:
                propertyInfo.type = PropertyInfo.BOOLEAN_CLASS;
                propertyInfo.name = "IsSoldOut";
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
            case 2:
                SoldOutDate = (Date) value;
                break;
            case 3:
                UnitPrice = (Float) value;;
                break;
            case 4:
                IsSoldOut = (Boolean) value;
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
