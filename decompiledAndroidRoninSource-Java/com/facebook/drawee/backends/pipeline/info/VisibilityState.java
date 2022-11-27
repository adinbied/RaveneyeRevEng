package com.facebook.drawee.backends.pipeline.info;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VisibilityState
{
  public static final int INVISIBLE = 2;
  public static final int UNKNOWN = -1;
  public static final int VISIBLE = 1;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\VisibilityState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */