package com.youth.banner;

import androidx.viewpager.widget.ViewPager.PageTransformer;
import com.youth.banner.transformer.AccordionTransformer;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;
import com.youth.banner.transformer.CubeInTransformer;
import com.youth.banner.transformer.CubeOutTransformer;
import com.youth.banner.transformer.DefaultTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.FlipHorizontalTransformer;
import com.youth.banner.transformer.FlipVerticalTransformer;
import com.youth.banner.transformer.ForegroundToBackgroundTransformer;
import com.youth.banner.transformer.RotateDownTransformer;
import com.youth.banner.transformer.RotateUpTransformer;
import com.youth.banner.transformer.ScaleInOutTransformer;
import com.youth.banner.transformer.StackTransformer;
import com.youth.banner.transformer.TabletTransformer;
import com.youth.banner.transformer.ZoomInTransformer;
import com.youth.banner.transformer.ZoomOutSlideTransformer;
import com.youth.banner.transformer.ZoomOutTranformer;

public class Transformer
{
  public static Class<? extends ViewPager.PageTransformer> Accordion;
  public static Class<? extends ViewPager.PageTransformer> BackgroundToForeground;
  public static Class<? extends ViewPager.PageTransformer> CubeIn = CubeInTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> CubeOut = CubeOutTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> Default = DefaultTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> DepthPage = DepthPageTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> FlipVertical = FlipVerticalTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> ForegroundToBackground;
  public static Class<? extends ViewPager.PageTransformer> RotateDown = RotateDownTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> RotateUp = RotateUpTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> Stack = StackTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> Tablet = TabletTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> ZoomIn = ZoomInTransformer.class;
  public static Class<? extends ViewPager.PageTransformer> ZoomOut = ZoomOutTranformer.class;
  public static Class<? extends ViewPager.PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
  
  static
  {
    Accordion = AccordionTransformer.class;
    BackgroundToForeground = BackgroundToForegroundTransformer.class;
    ForegroundToBackground = ForegroundToBackgroundTransformer.class;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\Transformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */