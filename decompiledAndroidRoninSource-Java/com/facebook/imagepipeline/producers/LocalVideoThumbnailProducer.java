package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Video.Media;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class LocalVideoThumbnailProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  static final String CREATED_THUMBNAIL = "createdThumbnail";
  public static final String PRODUCER_NAME = "VideoThumbnailProducer";
  private final ContentResolver mContentResolver;
  private final Executor mExecutor;
  
  public LocalVideoThumbnailProducer(Executor paramExecutor, ContentResolver paramContentResolver)
  {
    this.mExecutor = paramExecutor;
    this.mContentResolver = paramContentResolver;
  }
  
  private static int calculateKind(ImageRequest paramImageRequest)
  {
    if ((paramImageRequest.getPreferredWidth() <= 96) && (paramImageRequest.getPreferredHeight() <= 96)) {
      return 3;
    }
    return 1;
  }
  
  @Nullable
  private static Bitmap createThumbnailFromContentProvider(ContentResolver paramContentResolver, Uri paramUri)
  {
    if (Build.VERSION.SDK_INT >= 10) {}
    try
    {
      paramContentResolver = paramContentResolver.openFileDescriptor(paramUri, "r");
      paramUri = new MediaMetadataRetriever();
      paramUri.setDataSource(paramContentResolver.getFileDescriptor());
      paramContentResolver = paramUri.getFrameAtTime(-1L);
      return paramContentResolver;
    }
    catch (FileNotFoundException paramContentResolver) {}
    return null;
    return null;
  }
  
  @Nullable
  private String getLocalFilePath(ImageRequest paramImageRequest)
  {
    Object localObject1 = paramImageRequest.getSourceUri();
    if (UriUtil.isLocalFileUri((Uri)localObject1)) {
      return paramImageRequest.getSourceFile().getPath();
    }
    if (UriUtil.isLocalContentUri((Uri)localObject1))
    {
      Object localObject3;
      if ((Build.VERSION.SDK_INT >= 19) && ("com.android.providers.media.documents".equals(((Uri)localObject1).getAuthority())))
      {
        localObject1 = DocumentsContract.getDocumentId((Uri)localObject1);
        paramImageRequest = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        localObject3 = localObject1.split(":")[1];
        localObject1 = "_id=?";
        localObject3 = new String[] { localObject3 };
      }
      else
      {
        paramImageRequest = (ImageRequest)localObject1;
        localObject1 = null;
        localObject3 = localObject1;
      }
      paramImageRequest = this.mContentResolver.query(paramImageRequest, new String[] { "_data" }, (String)localObject1, (String[])localObject3, null);
      if (paramImageRequest != null) {
        try
        {
          if (paramImageRequest.moveToFirst())
          {
            localObject1 = paramImageRequest.getString(paramImageRequest.getColumnIndexOrThrow("_data"));
            return (String)localObject1;
          }
        }
        finally
        {
          if (paramImageRequest != null) {
            paramImageRequest.close();
          }
        }
      }
      if (paramImageRequest != null) {
        paramImageRequest.close();
      }
    }
    return null;
  }
  
  public void produceResults(final Consumer<CloseableReference<CloseableImage>> paramConsumer, final ProducerContext paramProducerContext)
  {
    final ProducerListener2 localProducerListener2 = paramProducerContext.getProducerListener();
    final ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    paramProducerContext.putOriginExtra("local", "video");
    paramConsumer = new StatefulProducerRunnable(paramConsumer, localProducerListener2, paramProducerContext, "VideoThumbnailProducer")
    {
      protected void disposeResult(CloseableReference<CloseableImage> paramAnonymousCloseableReference)
      {
        CloseableReference.closeSafely(paramAnonymousCloseableReference);
      }
      
      protected Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> paramAnonymousCloseableReference)
      {
        boolean bool;
        if (paramAnonymousCloseableReference != null) {
          bool = true;
        } else {
          bool = false;
        }
        return ImmutableMap.of("createdThumbnail", String.valueOf(bool));
      }
      
      @Nullable
      protected CloseableReference<CloseableImage> getResult()
        throws Exception
      {
        try
        {
          localObject = LocalVideoThumbnailProducer.this.getLocalFilePath(localImageRequest);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Object localObject;
          for (;;) {}
        }
        localObject = null;
        if (localObject != null) {
          localObject = ThumbnailUtils.createVideoThumbnail((String)localObject, LocalVideoThumbnailProducer.calculateKind(localImageRequest));
        } else {
          localObject = LocalVideoThumbnailProducer.createThumbnailFromContentProvider(LocalVideoThumbnailProducer.this.mContentResolver, localImageRequest.getSourceUri());
        }
        if (localObject == null) {
          return null;
        }
        localObject = new CloseableStaticBitmap((Bitmap)localObject, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0);
        paramProducerContext.setExtra("image_format", "thumbnail");
        ((CloseableStaticBitmap)localObject).setImageExtras(paramProducerContext.getExtras());
        return CloseableReference.of((Closeable)localObject);
      }
      
      protected void onFailure(Exception paramAnonymousException)
      {
        super.onFailure(paramAnonymousException);
        localProducerListener2.onUltimateProducerReached(paramProducerContext, "VideoThumbnailProducer", false);
        paramProducerContext.putOriginExtra("local");
      }
      
      protected void onSuccess(CloseableReference<CloseableImage> paramAnonymousCloseableReference)
      {
        super.onSuccess(paramAnonymousCloseableReference);
        ProducerListener2 localProducerListener2 = localProducerListener2;
        ProducerContext localProducerContext = paramProducerContext;
        boolean bool;
        if (paramAnonymousCloseableReference != null) {
          bool = true;
        } else {
          bool = false;
        }
        localProducerListener2.onUltimateProducerReached(localProducerContext, "VideoThumbnailProducer", bool);
        paramProducerContext.putOriginExtra("local");
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        paramConsumer.cancel();
      }
    });
    this.mExecutor.execute(paramConsumer);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\LocalVideoThumbnailProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */