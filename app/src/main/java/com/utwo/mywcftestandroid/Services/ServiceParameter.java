package com.utwo.mywcftestandroid.Services;

/**
 * Created by ammic on 2015/10/22.
 */
public class ServiceParameter {
    private String Name;
    private Object Value;
    private Object Type;
    public ServiceParameter(String Name, Object Value, Object type){
        this.Name = Name;
        this.Value = Value;
        this.Type = type;
    }
    public ServiceParameter(String Name, String Value){
        this(Name, Value, String.class);
    }
    public String getName(){
        return Name;
    }
    public Object getValue(){
        return Value;
    }
    public Object getType(){
        return Type;
    }
}
