package com.facebook.drawee.backends.pipeline.info;

import java.util.Collection;
import java.util.Iterator;

public class ForwardingImagePerfDataListener
  implements ImagePerfDataListener
{
  private final Collection<ImagePerfDataListener> mListeners;
  
  public ForwardingImagePerfDataListener(Collection<ImagePerfDataListener> paramCollection)
  {
    this.mListeners = paramCollection;
  }
  
  public void onImageLoadStatusUpdated(ImagePerfData paramImagePerfData, int paramInt)
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((ImagePerfDataListener)localIterator.next()).onImageLoadStatusUpdated(paramImagePerfData, paramInt);
    }
  }
  
  public void onImageVisibilityUpdated(ImagePerfData paramImagePerfData, int paramInt)
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((ImagePerfDataListener)localIterator.next()).onImageVisibilityUpdated(paramImagePerfData, paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ForwardingImagePerfDataListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */