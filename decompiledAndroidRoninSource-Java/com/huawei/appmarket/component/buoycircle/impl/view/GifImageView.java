package com.huawei.appmarket.component.buoycircle.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GifImageView
  extends ImageView
{
  private int image;
  private float mScale;
  private Movie movie;
  private long movieStart = 0L;
  
  public GifImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public GifImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  /* Error */
  private void drawGifImage(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void init(AttributeSet arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    drawGifImage(paramCanvas);
  }
  
  /* Error */
  protected void onMeasure(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\view\GifImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */