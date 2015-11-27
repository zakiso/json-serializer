package me.ddzq.android.deerconvetor.lib.serializer;

/**
 * Created by dzq on 15/9/8.
 */
public interface Serializer<T> {

    String serialization(T t);

    T deserialization(String s);

}
