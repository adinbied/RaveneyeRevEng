package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class BaseBitmapReferenceDataSubscriber
  extends BaseDataSubscriber<CloseableReference<CloseableImage>>
{
  protected abstract void onNewResultImpl(@Nullable CloseableReference<Bitmap> paramCloseableReference);
  
  public void onNewResultImpl(@Nonnull DataSource<CloseableReference<CloseableImage>> paramDataSource)
  {
    if (!paramDataSource.isFinished()) {
      return;
    }
    CloseableReference localCloseableReference = (CloseableReference)paramDataSource.getResult();
    Object localObject1 = null;
    paramDataSource = (DataSource<CloseableReference<CloseableImage>>)localObject1;
    if (localCloseableReference != null)
    {
      paramDataSource = (DataSource<CloseableReference<CloseableImage>>)localObject1;
      if ((localCloseableReference.get() instanceof CloseableStaticBitmap)) {
        paramDataSource = ((CloseableStaticBitmap)localCloseableReference.get()).cloneUnderlyingBitmapReference();
      }
    }
    try
    {
      onNewResultImpl(paramDataSource);
      return;
    }
    finally
    {
      CloseableReference.closeSafely(paramDataSource);
      CloseableReference.closeSafely(localCloseableReference);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\datasource\BaseBitmapReferenceDataSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */