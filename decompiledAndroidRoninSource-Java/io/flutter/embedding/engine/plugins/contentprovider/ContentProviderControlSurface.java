package io.flutter.embedding.engine.plugins.contentprovider;

import android.content.ContentProvider;
import androidx.lifecycle.Lifecycle;

public abstract interface ContentProviderControlSurface
{
  public abstract void attachToContentProvider(ContentProvider paramContentProvider, Lifecycle paramLifecycle);
  
  public abstract void detachFromContentProvider();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\contentprovider\ContentProviderControlSurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */