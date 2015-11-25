package me.ddzq.android.deerconvetor.lib.anno;

import java.lang.annotation.*;

/**
 * Created by dzq on 15/8/24.
 */

/**
 * 用来给范型标注类型
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CollectionInitBy {
    Class value();
}
