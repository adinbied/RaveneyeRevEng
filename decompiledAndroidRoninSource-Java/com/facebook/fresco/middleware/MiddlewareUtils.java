package com.facebook.fresco.middleware;

import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.fresco.ui.common.ControllerListener2.Extras;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class MiddlewareUtils
{
  public static ControllerListener2.Extras obtainExtras(Map<String, Object> paramMap1, Map<String, Object> paramMap2, @Nullable Map<String, Object> paramMap3, @Nullable Rect paramRect, @Nullable String paramString, @Nullable PointF paramPointF, @Nullable Map<String, Object> paramMap4, @Nullable Object paramObject, @Nullable Uri paramUri)
  {
    ControllerListener2.Extras localExtras = new ControllerListener2.Extras();
    localExtras.view = new HashMap();
    localExtras.view.putAll(paramMap1);
    if (paramRect != null)
    {
      localExtras.view.put("viewport_width", Integer.valueOf(paramRect.width()));
      localExtras.view.put("viewport_height", Integer.valueOf(paramRect.height()));
    }
    else
    {
      localExtras.view.put("viewport_width", Integer.valueOf(-1));
      localExtras.view.put("viewport_height", Integer.valueOf(-1));
    }
    localExtras.view.put("scale_type", paramString);
    if (paramPointF != null)
    {
      localExtras.view.put("focus_point_x", Float.valueOf(paramPointF.x));
      localExtras.view.put("focus_point_y", Float.valueOf(paramPointF.y));
    }
    localExtras.view.put("caller_context", paramObject);
    if (paramUri != null) {
      localExtras.view.put("uri_main", paramUri);
    }
    if (paramMap3 != null)
    {
      localExtras.pipe = paramMap3;
      if (paramMap4 != null)
      {
        localExtras.pipe.putAll(paramMap4);
        return localExtras;
      }
    }
    else
    {
      localExtras.pipe = paramMap4;
      localExtras.view.putAll(paramMap2);
    }
    return localExtras;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\fresco\middleware\MiddlewareUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */