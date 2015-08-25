package me.ddzq.android.deerconvetor.lib.anno;

import java.lang.annotation.*;

/**
 * Created by dzq on 15/8/24.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenericType {
    Class instantiate();
}
