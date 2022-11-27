package com.facebook.imagepipeline.core;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ImageTranscoderType
{
  public static final int JAVA_TRANSCODER = 1;
  public static final int NATIVE_TRANSCODER = 0;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\ImageTranscoderType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */