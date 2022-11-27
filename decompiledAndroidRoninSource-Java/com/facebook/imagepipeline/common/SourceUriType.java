package com.facebook.imagepipeline.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SourceUriType
{
  public static final int SOURCE_TYPE_DATA = 7;
  public static final int SOURCE_TYPE_LOCAL_ASSET = 5;
  public static final int SOURCE_TYPE_LOCAL_CONTENT = 4;
  public static final int SOURCE_TYPE_LOCAL_FILE = 1;
  public static final int SOURCE_TYPE_LOCAL_IMAGE_FILE = 3;
  public static final int SOURCE_TYPE_LOCAL_RESOURCE = 6;
  public static final int SOURCE_TYPE_LOCAL_VIDEO_FILE = 2;
  public static final int SOURCE_TYPE_NETWORK = 0;
  public static final int SOURCE_TYPE_QUALIFIED_RESOURCE = 8;
  public static final int SOURCE_TYPE_UNKNOWN = -1;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\common\SourceUriType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */