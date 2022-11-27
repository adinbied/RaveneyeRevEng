package com.google.android.material.internal;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.util.Log;
import java.lang.reflect.Method;

public class DrawableUtils
{
  private static final String LOG_TAG = "DrawableUtils";
  private static Method setConstantStateMethod;
  private static boolean setConstantStateMethodFetched;
  
  public static boolean setContainerConstantState(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    return setContainerConstantStateV9(paramDrawableContainer, paramConstantState);
  }
  
  private static boolean setContainerConstantStateV9(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!setConstantStateMethodFetched) {}
    try
    {
      localMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
      setConstantStateMethod = localMethod;
      localMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      for (;;) {}
    }
    Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
    setConstantStateMethodFetched = true;
    localMethod = setConstantStateMethod;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramDrawableContainer, new Object[] { paramConstantState });
      return true;
    }
    catch (Exception paramDrawableContainer)
    {
      for (;;) {}
    }
    Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\internal\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */