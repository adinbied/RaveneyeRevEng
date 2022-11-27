package com.facebook.drawee.backends.pipeline.info;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ImageLoadStatus
{
  public static final int CANCELED = 4;
  public static final int DRAW = 6;
  public static final int ERROR = 5;
  public static final int INTERMEDIATE_AVAILABLE = 2;
  public static final int ORIGIN_AVAILABLE = 1;
  public static final int REQUESTED = 0;
  public static final int SUCCESS = 3;
  public static final int UNKNOWN = -1;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ImageLoadStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */