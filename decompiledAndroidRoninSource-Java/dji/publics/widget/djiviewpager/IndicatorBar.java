package dji.publics.widget.djiviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public class IndicatorBar
  extends LinearLayout
{
  private static final int DEFAULT_ITEM_DISTANCE = 0;
  private static final int DEFAULT_ITEM_SIZE = 30;
  private Context context;
  private boolean isResourceColor;
  private int itemDistance;
  private int itemSize;
  private ViewPager mViewPager;
  private int nonSelectedResource;
  private int selectedIndex;
  private int selectedResource;
  
  public IndicatorBar(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public IndicatorBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public IndicatorBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  /* Error */
  private void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initSelectState()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initStyle()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCount(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setIndicatorColor(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setIndicatorResource(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void setItemDisatance(int paramInt)
  {
    this.itemDistance = paramInt;
    initStyle();
  }
  
  public void setItemSize(int paramInt)
  {
    this.itemSize = paramInt;
    initStyle();
  }
  
  /* Error */
  public void setSelectedIndex(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setViewPager(ViewPager arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\djiviewpager\IndicatorBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */