package com.facebook.imagepipeline.core;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MemoryChunkType
{
  public static final int ASHMEM_MEMORY = 2;
  public static final int BUFFER_MEMORY = 1;
  public static final int NATIVE_MEMORY = 0;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\MemoryChunkType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */