package io.flutter.embedding.engine.loader;

import android.content.Context;
import java.io.File;
import java.io.IOException;

class ResourcePaths
{
  public static final String TEMPORARY_RESOURCE_PREFIX = ".org.chromium.Chromium.";
  
  public static File createTempFile(Context paramContext, String paramString)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return File.createTempFile(".org.chromium.Chromium.", localStringBuilder.toString(), paramContext.getCacheDir());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\loader\ResourcePaths.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */