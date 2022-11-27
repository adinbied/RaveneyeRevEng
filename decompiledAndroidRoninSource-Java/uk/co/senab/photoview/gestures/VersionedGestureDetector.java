package uk.co.senab.photoview.gestures;

import android.content.Context;
import android.os.Build.VERSION;

public final class VersionedGestureDetector
{
  public static GestureDetector newInstance(Context paramContext, OnGestureListener paramOnGestureListener)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 5) {
      paramContext = new CupcakeGestureDetector(paramContext);
    } else if (i < 8) {
      paramContext = new EclairGestureDetector(paramContext);
    } else {
      paramContext = new FroyoGestureDetector(paramContext);
    }
    paramContext.setOnGestureListener(paramOnGestureListener);
    return paramContext;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar\\uk\co\senab\photoview\gestures\VersionedGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */