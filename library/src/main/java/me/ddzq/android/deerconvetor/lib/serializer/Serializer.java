package me.ddzq.android.deerconvetor.lib.serializer;

/**
 * Created by dzq on 15/9/8.
 */
public interface Serializer<T> {

    public String serialization(T t);

    public T deserialization(String s);

}
