package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

public class DraweeHolder<DH extends DraweeHierarchy>
  implements VisibilityCallback
{
  private DraweeController mController = null;
  private final DraweeEventTracker mEventTracker = DraweeEventTracker.newInstance();
  private DH mHierarchy;
  private boolean mIsControllerAttached = false;
  private boolean mIsHolderAttached = false;
  private boolean mIsVisible = true;
  
  public DraweeHolder(@Nullable DH paramDH)
  {
    if (paramDH != null) {
      setHierarchy(paramDH);
    }
  }
  
  private void attachController()
  {
    if (this.mIsControllerAttached) {
      return;
    }
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
    this.mIsControllerAttached = true;
    DraweeController localDraweeController = this.mController;
    if ((localDraweeController != null) && (localDraweeController.getHierarchy() != null)) {
      this.mController.onAttach();
    }
  }
  
  private void attachOrDetachController()
  {
    if ((this.mIsHolderAttached) && (this.mIsVisible))
    {
      attachController();
      return;
    }
    detachController();
  }
  
  public static <DH extends DraweeHierarchy> DraweeHolder<DH> create(@Nullable DH paramDH, Context paramContext)
  {
    paramDH = new DraweeHolder(paramDH);
    paramDH.registerWithContext(paramContext);
    return paramDH;
  }
  
  private void detachController()
  {
    if (!this.mIsControllerAttached) {
      return;
    }
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
    this.mIsControllerAttached = false;
    if (isControllerValid()) {
      this.mController.onDetach();
    }
  }
  
  private void setVisibilityCallback(@Nullable VisibilityCallback paramVisibilityCallback)
  {
    Drawable localDrawable = getTopLevelDrawable();
    if ((localDrawable instanceof VisibilityAwareDrawable)) {
      ((VisibilityAwareDrawable)localDrawable).setVisibilityCallback(paramVisibilityCallback);
    }
  }
  
  @Nullable
  public DraweeController getController()
  {
    return this.mController;
  }
  
  protected DraweeEventTracker getDraweeEventTracker()
  {
    return this.mEventTracker;
  }
  
  public DH getHierarchy()
  {
    return (DraweeHierarchy)Preconditions.checkNotNull(this.mHierarchy);
  }
  
  @Nullable
  public Drawable getTopLevelDrawable()
  {
    DraweeHierarchy localDraweeHierarchy = this.mHierarchy;
    if (localDraweeHierarchy == null) {
      return null;
    }
    return localDraweeHierarchy.getTopLevelDrawable();
  }
  
  public boolean hasHierarchy()
  {
    return this.mHierarchy != null;
  }
  
  public boolean isAttached()
  {
    return this.mIsHolderAttached;
  }
  
  public boolean isControllerValid()
  {
    DraweeController localDraweeController = this.mController;
    return (localDraweeController != null) && (localDraweeController.getHierarchy() == this.mHierarchy);
  }
  
  public void onAttach()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
    this.mIsHolderAttached = true;
    attachOrDetachController();
  }
  
  public void onDetach()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_DETACH);
    this.mIsHolderAttached = false;
    attachOrDetachController();
  }
  
  public void onDraw()
  {
    if (this.mIsControllerAttached) {
      return;
    }
    FLog.w(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", new Object[] { Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mController)), toString() });
    this.mIsHolderAttached = true;
    this.mIsVisible = true;
    attachOrDetachController();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isControllerValid()) {
      return false;
    }
    return this.mController.onTouchEvent(paramMotionEvent);
  }
  
  public void onVisibilityChange(boolean paramBoolean)
  {
    if (this.mIsVisible == paramBoolean) {
      return;
    }
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    DraweeEventTracker.Event localEvent;
    if (paramBoolean) {
      localEvent = DraweeEventTracker.Event.ON_DRAWABLE_SHOW;
    } else {
      localEvent = DraweeEventTracker.Event.ON_DRAWABLE_HIDE;
    }
    localDraweeEventTracker.recordEvent(localEvent);
    this.mIsVisible = paramBoolean;
    attachOrDetachController();
  }
  
  public void registerWithContext(Context paramContext) {}
  
  public void setController(@Nullable DraweeController paramDraweeController)
  {
    boolean bool = this.mIsControllerAttached;
    if (bool) {
      detachController();
    }
    if (isControllerValid())
    {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
      this.mController.setHierarchy(null);
    }
    this.mController = paramDraweeController;
    if (paramDraweeController != null)
    {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_CONTROLLER);
      this.mController.setHierarchy(this.mHierarchy);
    }
    else
    {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
    }
    if (bool) {
      attachController();
    }
  }
  
  public void setHierarchy(DH paramDH)
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_HIERARCHY);
    boolean bool2 = isControllerValid();
    setVisibilityCallback(null);
    Object localObject = (DraweeHierarchy)Preconditions.checkNotNull(paramDH);
    this.mHierarchy = ((DraweeHierarchy)localObject);
    localObject = ((DraweeHierarchy)localObject).getTopLevelDrawable();
    boolean bool1;
    if ((localObject != null) && (!((Drawable)localObject).isVisible())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    onVisibilityChange(bool1);
    setVisibilityCallback(this);
    if (bool2) {
      this.mController.setHierarchy(paramDH);
    }
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("controllerAttached", this.mIsControllerAttached).add("holderAttached", this.mIsHolderAttached).add("drawableVisible", this.mIsVisible).add("events", this.mEventTracker.toString()).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\view\DraweeHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */