package io.reactivex.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
public @interface SchedulerSupport
{
  public static final String COMPUTATION = "io.reactivex:computation";
  public static final String CUSTOM = "custom";
  public static final String IO = "io.reactivex:io";
  public static final String NEW_THREAD = "io.reactivex:new-thread";
  public static final String NONE = "none";
  public static final String SINGLE = "io.reactivex:single";
  public static final String TRAMPOLINE = "io.reactivex:trampoline";
  
  String value();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\annotations\SchedulerSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */