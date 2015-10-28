package com.utwo.mywcftestandroid.Services;

/**
 * Created by ammic on 2015/10/22.
 */
public class ServiceParameter {
    private String Name;
    private Object Value;
    private Object Type;
    private String ItemName;
    private Object ItemType;

    public ServiceParameter(String name, Object value, Object type) {
        this.Name = name;
        this.Value = value;
        this.Type = type;
    }

    public ServiceParameter(String name, Object value, Object type, String itemName, Object itemType) {
        this(name, value, type);
        this.ItemName = itemName;
        this.ItemType = itemType;
    }

    public String getName() {
        return Name;
    }

    public Object getValue() {
        return Value;
    }

    public Object getType() {
        return Type;
    }

    public String getItemName() {
        return ItemName;
    }

    public Object getItemType() {
        return ItemType;
    }
}
