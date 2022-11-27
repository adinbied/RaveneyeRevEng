package com.facebook.fresco.ui.common;

import android.net.Uri;
import com.facebook.common.internal.Fn;
import java.util.function.Function;
import javax.annotation.Nullable;

public abstract class MultiUriHelper
{
  Function<Integer, Integer> f;
  
  public static <T> Uri getMainUri(@Nullable T paramT1, @Nullable T paramT2, @Nullable T[] paramArrayOfT, Fn<T, Uri> paramFn)
  {
    if (paramT1 != null)
    {
      paramT1 = (Uri)paramFn.apply(paramT1);
      if (paramT1 != null) {
        return paramT1;
      }
    }
    if ((paramArrayOfT != null) && (paramArrayOfT.length > 0) && (paramArrayOfT[0] != null))
    {
      paramT1 = (Uri)paramFn.apply(paramArrayOfT[0]);
      if (paramT1 != null) {
        return paramT1;
      }
    }
    if (paramT2 != null) {
      return (Uri)paramFn.apply(paramT2);
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\fresc\\ui\common\MultiUriHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */