package com.facebook.imagepipeline.transcoder;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TranscodeStatus
{
  public static final int TRANSCODING_ERROR = 2;
  public static final int TRANSCODING_NO_RESIZING = 1;
  public static final int TRANSCODING_SUCCESS = 0;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\transcoder\TranscodeStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */