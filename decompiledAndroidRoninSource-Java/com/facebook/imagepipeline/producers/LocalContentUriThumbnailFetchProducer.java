package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class LocalContentUriThumbnailFetchProducer
  extends LocalFetchProducer
  implements ThumbnailProducer<EncodedImage>
{
  private static final Rect MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);
  private static final Rect MINI_THUMBNAIL_DIMENSIONS;
  private static final int NO_THUMBNAIL = 0;
  public static final String PRODUCER_NAME = "LocalContentUriThumbnailFetchProducer";
  private static final String[] PROJECTION;
  private static final Class<?> TAG = LocalContentUriThumbnailFetchProducer.class;
  private static final String[] THUMBNAIL_PROJECTION;
  private final ContentResolver mContentResolver;
  
  static
  {
    PROJECTION = new String[] { "_id", "_data" };
    THUMBNAIL_PROJECTION = new String[] { "_data" };
    MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, 384);
  }
  
  public LocalContentUriThumbnailFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mContentResolver = paramContentResolver;
  }
  
  @Nullable
  private EncodedImage getCameraImage(Uri paramUri, @Nullable ResizeOptions paramResizeOptions)
    throws IOException
  {
    if (paramResizeOptions == null) {
      return null;
    }
    paramUri = this.mContentResolver.query(paramUri, PROJECTION, null, null, null);
    if (paramUri == null) {
      return null;
    }
    try
    {
      if (paramUri.moveToFirst())
      {
        paramResizeOptions = getThumbnail(paramResizeOptions, paramUri.getLong(paramUri.getColumnIndex("_id")));
        if (paramResizeOptions != null)
        {
          paramResizeOptions.setRotationAngle(getRotationAngle(paramUri.getString(paramUri.getColumnIndex("_data"))));
          return paramResizeOptions;
        }
      }
      return null;
    }
    finally
    {
      paramUri.close();
    }
  }
  
  private static int getLength(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return (int)new File(paramString).length();
  }
  
  private static int getRotationAngle(String paramString)
  {
    if (paramString != null) {
      try
      {
        int i = JfifUtil.getAutoRotateAngleFromOrientation(new ExifInterface(paramString).getAttributeInt("Orientation", 1));
        return i;
      }
      catch (IOException localIOException)
      {
        FLog.e(TAG, localIOException, "Unable to retrieve thumbnail rotation for %s", new Object[] { paramString });
      }
    }
    return 0;
  }
  
  @Nullable
  private EncodedImage getThumbnail(ResizeOptions paramResizeOptions, long paramLong)
    throws IOException
  {
    int i = getThumbnailKind(paramResizeOptions);
    if (i == 0) {
      return null;
    }
    paramResizeOptions = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, paramLong, i, THUMBNAIL_PROJECTION);
    if (paramResizeOptions == null) {
      return null;
    }
    try
    {
      if (paramResizeOptions.moveToFirst())
      {
        Object localObject1 = paramResizeOptions.getString(paramResizeOptions.getColumnIndex("_data"));
        if (new File((String)localObject1).exists())
        {
          localObject1 = getEncodedImage(new FileInputStream((String)localObject1), getLength((String)localObject1));
          return (EncodedImage)localObject1;
        }
      }
      return null;
    }
    finally
    {
      paramResizeOptions.close();
    }
  }
  
  private static int getThumbnailKind(ResizeOptions paramResizeOptions)
  {
    if (ThumbnailSizeChecker.isImageBigEnough(MICRO_THUMBNAIL_DIMENSIONS.width(), MICRO_THUMBNAIL_DIMENSIONS.height(), paramResizeOptions)) {
      return 3;
    }
    if (ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), paramResizeOptions)) {
      return 1;
    }
    return 0;
  }
  
  public boolean canProvideImageForSize(ResizeOptions paramResizeOptions)
  {
    return ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), paramResizeOptions);
  }
  
  @Nullable
  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    Uri localUri = paramImageRequest.getSourceUri();
    if (UriUtil.isLocalCameraUri(localUri)) {
      return getCameraImage(localUri, paramImageRequest.getResizeOptions());
    }
    return null;
  }
  
  protected String getProducerName()
  {
    return "LocalContentUriThumbnailFetchProducer";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\LocalContentUriThumbnailFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */