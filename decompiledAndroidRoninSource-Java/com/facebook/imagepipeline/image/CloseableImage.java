package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public abstract class CloseableImage
  implements Closeable, ImageInfo, HasImageMetadata
{
  private static final String TAG = "CloseableImage";
  private static final String[] mImageExtrasList = { "encoded_size", "encoded_width", "encoded_height", "uri_source", "image_format", "bitmap_config" };
  private Map<String, Object> mExtras = new HashMap();
  
  public abstract void close();
  
  protected void finalize()
    throws Throwable
  {
    if (isClosed()) {
      return;
    }
    FLog.w("CloseableImage", "finalize: %s %x still open.", new Object[] { getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)) });
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  @Nonnull
  public Map<String, Object> getExtras()
  {
    return this.mExtras;
  }
  
  public QualityInfo getQualityInfo()
  {
    return ImmutableQualityInfo.FULL_QUALITY;
  }
  
  public abstract int getSizeInBytes();
  
  public abstract boolean isClosed();
  
  public boolean isStateful()
  {
    return false;
  }
  
  public void setImageExtras(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    String[] arrayOfString = mImageExtrasList;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Object localObject = paramMap.get(str);
      if (localObject != null) {
        this.mExtras.put(str, localObject);
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\image\CloseableImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */