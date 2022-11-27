package com.facebook.fresco.ui.common;

import java.util.Map;
import javax.annotation.Nullable;

@Deprecated
public abstract interface ControllerListener2<INFO>
{
  public abstract void onFailure(String paramString, Throwable paramThrowable, @Nullable Extras paramExtras);
  
  public abstract void onFinalImageSet(String paramString, @Nullable INFO paramINFO, Extras paramExtras);
  
  public abstract void onIntermediateImageFailed(String paramString);
  
  public abstract void onIntermediateImageSet(String paramString, @Nullable INFO paramINFO);
  
  public abstract void onRelease(String paramString, @Nullable Extras paramExtras);
  
  public abstract void onSubmit(String paramString, Object paramObject, @Nullable Extras paramExtras);
  
  public static class Extras
  {
    @Nullable
    public Map<String, Object> pipe;
    @Nullable
    public Map<String, Object> view;
    
    public static Extras of(@Nullable Map<String, Object> paramMap1, @Nullable Map<String, Object> paramMap2)
    {
      Extras localExtras = new Extras();
      localExtras.pipe = paramMap1;
      localExtras.view = paramMap2;
      return localExtras;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pipe: ");
      localStringBuilder.append(this.pipe);
      localStringBuilder.append(", view: ");
      localStringBuilder.append(this.view);
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\fresc\\ui\common\ControllerListener2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */