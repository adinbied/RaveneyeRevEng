package com.youth.banner;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.ViewPager.PageTransformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoaderInterface;
import com.youth.banner.view.BannerViewPager;
import java.util.ArrayList;
import java.util.List;

public class Banner
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  private BannerPagerAdapter adapter;
  private int bannerBackgroundImage;
  private ImageView bannerDefaultImage;
  private OnBannerClickListener bannerListener;
  private int bannerStyle = 1;
  private TextView bannerTitle;
  private Context context;
  private int count = 0;
  private int currentItem;
  private int delayTime = 2000;
  private DisplayMetrics dm;
  private int gravity = -1;
  private WeakHandler handler = new WeakHandler();
  private ImageLoaderInterface imageLoader;
  private List imageUrls;
  private List<View> imageViews;
  private LinearLayout indicator;
  private List<ImageView> indicatorImages;
  private LinearLayout indicatorInside;
  private int indicatorSize;
  private boolean isAutoPlay = true;
  private boolean isScroll = true;
  private int lastPosition = 1;
  private OnBannerListener listener;
  private int mIndicatorHeight;
  private int mIndicatorMargin = 5;
  private int mIndicatorSelectedResId = R.drawable.gray_radius;
  private int mIndicatorUnselectedResId = R.drawable.white_radius;
  private int mIndicatorWidth;
  private int mLayoutResId = R.layout.banner;
  private ViewPager.OnPageChangeListener mOnPageChangeListener;
  private BannerScroller mScroller;
  private TextView numIndicator;
  private TextView numIndicatorInside;
  private int scaleType = 1;
  private int scrollTime = 800;
  public String tag = "banner";
  private final Runnable task = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private int titleBackground;
  private int titleHeight;
  private int titleTextColor;
  private int titleTextSize;
  private LinearLayout titleView;
  private List<String> titles;
  private BannerViewPager viewPager;
  
  public Banner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Banner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Banner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    this.titles = new ArrayList();
    this.imageUrls = new ArrayList();
    this.imageViews = new ArrayList();
    this.indicatorImages = new ArrayList();
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.dm = localDisplayMetrics;
    this.indicatorSize = (localDisplayMetrics.widthPixels / 80);
    initView(paramContext, paramAttributeSet);
  }
  
  /* Error */
  private void createIndicator()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handleTypedArray(Context arg1, AttributeSet arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initImages()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initView(Context arg1, AttributeSet arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initViewPagerScroll()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void setBannerStyleUI()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setImageList(List<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setScaleType(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setTitleStyleUI()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public Banner isAutoPlay(boolean paramBoolean)
  {
    this.isAutoPlay = paramBoolean;
    return this;
  }
  
  /* Error */
  public void onPageScrollStateChanged(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onPageScrolled(int arg1, float arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void onPageSelected(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void releaseBanner()
  {
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public Banner setBannerAnimation(Class<? extends ViewPager.PageTransformer> paramClass)
  {
    return null;
  }
  
  public Banner setBannerStyle(int paramInt)
  {
    this.bannerStyle = paramInt;
    return this;
  }
  
  public Banner setBannerTitles(List<String> paramList)
  {
    this.titles = paramList;
    return this;
  }
  
  public Banner setDelayTime(int paramInt)
  {
    this.delayTime = paramInt;
    return this;
  }
  
  public Banner setImageLoader(ImageLoaderInterface paramImageLoaderInterface)
  {
    this.imageLoader = paramImageLoaderInterface;
    return this;
  }
  
  public Banner setImages(List<?> paramList)
  {
    this.imageUrls = paramList;
    this.count = paramList.size();
    return this;
  }
  
  public Banner setIndicatorGravity(int paramInt)
  {
    return null;
  }
  
  public Banner setOffscreenPageLimit(int paramInt)
  {
    BannerViewPager localBannerViewPager = this.viewPager;
    if (localBannerViewPager != null) {
      localBannerViewPager.setOffscreenPageLimit(paramInt);
    }
    return this;
  }
  
  @Deprecated
  public Banner setOnBannerClickListener(OnBannerClickListener paramOnBannerClickListener)
  {
    this.bannerListener = paramOnBannerClickListener;
    return this;
  }
  
  public Banner setOnBannerListener(OnBannerListener paramOnBannerListener)
  {
    this.listener = paramOnBannerListener;
    return this;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public Banner setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    this.viewPager.setPageTransformer(paramBoolean, paramPageTransformer);
    return this;
  }
  
  public Banner setViewPagerIsScroll(boolean paramBoolean)
  {
    this.isScroll = paramBoolean;
    return this;
  }
  
  public Banner start()
  {
    return null;
  }
  
  /* Error */
  public void startAutoPlay()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stopAutoPlay()
  {
    this.handler.removeCallbacks(this.task);
  }
  
  public int toRealPosition(int paramInt)
  {
    return 0;
  }
  
  /* Error */
  public void update(List<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void update(List<?> arg1, List<String> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateBannerStyle(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  class BannerPagerAdapter
    extends PagerAdapter
  {
    BannerPagerAdapter() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return 0;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      return null;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\Banner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */