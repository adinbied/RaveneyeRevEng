package com.facebook.drawee.backends.pipeline.info;

public abstract interface ImagePerfNotifier
{
  public abstract void notifyListenersOfVisibilityStateUpdate(ImagePerfState paramImagePerfState, int paramInt);
  
  public abstract void notifyStatusUpdated(ImagePerfState paramImagePerfState, int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ImagePerfNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */