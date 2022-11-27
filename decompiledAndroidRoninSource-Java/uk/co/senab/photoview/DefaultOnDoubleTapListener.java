package uk.co.senab.photoview;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;

public class DefaultOnDoubleTapListener
  implements GestureDetector.OnDoubleTapListener
{
  private PhotoViewAttacher photoViewAttacher;
  
  public DefaultOnDoubleTapListener(PhotoViewAttacher paramPhotoViewAttacher)
  {
    setPhotoViewAttacher(paramPhotoViewAttacher);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setPhotoViewAttacher(PhotoViewAttacher paramPhotoViewAttacher)
  {
    this.photoViewAttacher = paramPhotoViewAttacher;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar\\uk\co\senab\photoview\DefaultOnDoubleTapListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */