package uk.co.senab.photoview.gestures;

import android.content.Context;
import android.view.MotionEvent;

public class EclairGestureDetector
  extends CupcakeGestureDetector
{
  private static final int INVALID_POINTER_ID = -1;
  private int mActivePointerId = -1;
  private int mActivePointerIndex = 0;
  
  public EclairGestureDetector(Context paramContext)
  {
    super(paramContext);
  }
  
  float getActiveX(MotionEvent paramMotionEvent)
  {
    return 0.0F;
  }
  
  float getActiveY(MotionEvent paramMotionEvent)
  {
    return 0.0F;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar\\uk\co\senab\photoview\gestures\EclairGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */