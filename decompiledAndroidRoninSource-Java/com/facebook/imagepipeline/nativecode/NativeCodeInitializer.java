package com.facebook.imagepipeline.nativecode;

import android.content.Context;
import com.facebook.soloader.SoLoader;
import java.io.IOException;

public class NativeCodeInitializer
{
  public static void init(Context paramContext)
    throws IOException
  {
    SoLoader.init(paramContext, 0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\NativeCodeInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */