package com.facebook.drawee.backends.pipeline.info;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ImageOrigin
{
  public static final int DISK = 3;
  public static final int LOCAL = 7;
  public static final int MEMORY_BITMAP = 5;
  public static final int MEMORY_BITMAP_SHORTCUT = 6;
  public static final int MEMORY_ENCODED = 4;
  public static final int NETWORK = 2;
  public static final int UNKNOWN = 1;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ImageOrigin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */