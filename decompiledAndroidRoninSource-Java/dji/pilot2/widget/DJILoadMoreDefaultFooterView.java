package dji.pilot2.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import in.srain.cube.views.loadmore.LoadMoreContainer;
import in.srain.cube.views.loadmore.LoadMoreUIHandler;

public class DJILoadMoreDefaultFooterView
  extends RelativeLayout
  implements LoadMoreUIHandler
{
  private AnimationDrawable mAnimationDrawable;
  private ImageView mImageView;
  
  public DJILoadMoreDefaultFooterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DJILoadMoreDefaultFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DJILoadMoreDefaultFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setupViews();
  }
  
  /* Error */
  private void setupViews()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onLoadError(LoadMoreContainer paramLoadMoreContainer, int paramInt, String paramString)
  {
    setVisibility(4);
  }
  
  public void onLoadFinish(LoadMoreContainer paramLoadMoreContainer, boolean paramBoolean1, boolean paramBoolean2)
  {
    setVisibility(4);
  }
  
  public void onLoading(LoadMoreContainer paramLoadMoreContainer)
  {
    setVisibility(0);
    this.mAnimationDrawable.start();
  }
  
  public void onWaitToLoadMore(LoadMoreContainer paramLoadMoreContainer)
  {
    setVisibility(0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot2\widget\DJILoadMoreDefaultFooterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */