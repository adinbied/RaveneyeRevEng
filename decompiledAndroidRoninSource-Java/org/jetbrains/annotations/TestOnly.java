package org.jetbrains.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
public @interface TestOnly {}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\jetbrains\annotations\TestOnly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */