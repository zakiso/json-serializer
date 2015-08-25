package me.ddzq.android.deerconvetor.lib;

/**
 * Created by dzq on 15/8/25.
 */
public interface Transformer {
    public Class<?> getDeserializedType();

    public Class<?> getSerializedType();

    public Object serialize(Object data);

    public Object deserialize(Object data);

}
