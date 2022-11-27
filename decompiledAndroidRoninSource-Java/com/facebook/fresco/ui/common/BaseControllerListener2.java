package com.facebook.fresco.ui.common;

import javax.annotation.Nullable;

@Deprecated
public class BaseControllerListener2<INFO>
  implements ControllerListener2<INFO>
{
  private static final ControllerListener2 NO_OP_LISTENER = new BaseControllerListener2();
  
  public static <I> ControllerListener2<I> getNoOpListener()
  {
    return NO_OP_LISTENER;
  }
  
  public void onFailure(String paramString, Throwable paramThrowable, ControllerListener2.Extras paramExtras) {}
  
  public void onFinalImageSet(String paramString, @Nullable INFO paramINFO, ControllerListener2.Extras paramExtras) {}
  
  public void onIntermediateImageFailed(String paramString) {}
  
  public void onIntermediateImageSet(String paramString, @Nullable INFO paramINFO) {}
  
  public void onRelease(String paramString, ControllerListener2.Extras paramExtras) {}
  
  public void onSubmit(String paramString, Object paramObject, @Nullable ControllerListener2.Extras paramExtras) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\fresc\\ui\common\BaseControllerListener2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */