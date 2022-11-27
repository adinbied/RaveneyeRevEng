package uk.co.senab.photoview.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class CupcakeGestureDetector
  implements GestureDetector
{
  private static final String LOG_TAG = "CupcakeGestureDetector";
  private boolean mIsDragging;
  float mLastTouchX;
  float mLastTouchY;
  protected OnGestureListener mListener;
  final float mMinimumVelocity;
  final float mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public CupcakeGestureDetector(Context paramContext)
  {
    paramContext = ViewConfiguration.get(paramContext);
    this.mMinimumVelocity = paramContext.getScaledMinimumFlingVelocity();
    this.mTouchSlop = paramContext.getScaledTouchSlop();
  }
  
  float getActiveX(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getX();
  }
  
  float getActiveY(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getY();
  }
  
  public boolean isDragging()
  {
    return this.mIsDragging;
  }
  
  public boolean isScaling()
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setOnGestureListener(OnGestureListener paramOnGestureListener)
  {
    this.mListener = paramOnGestureListener;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar\\uk\co\senab\photoview\gestures\CupcakeGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */