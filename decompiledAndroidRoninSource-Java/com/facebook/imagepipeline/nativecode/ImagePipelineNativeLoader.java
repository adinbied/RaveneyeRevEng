package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.nativeloader.NativeLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImagePipelineNativeLoader
{
  public static final List<String> DEPENDENCIES = Collections.unmodifiableList(new ArrayList());
  public static final String DSO_NAME = "imagepipeline";
  
  public static void load()
  {
    NativeLoader.loadLibrary("imagepipeline");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\ImagePipelineNativeLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */