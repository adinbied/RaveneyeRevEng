package lecho.lib.hellocharts.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lecho.lib.hellocharts.formatter.BubbleChartValueFormatter;
import lecho.lib.hellocharts.formatter.SimpleBubbleChartValueFormatter;

public class BubbleChartData
  extends AbstractChartData
{
  public static final float DEFAULT_BUBBLE_SCALE = 1.0F;
  public static final int DEFAULT_MIN_BUBBLE_RADIUS_DP = 6;
  private float bubbleScale = 1.0F;
  private BubbleChartValueFormatter formatter = new SimpleBubbleChartValueFormatter();
  private boolean hasLabels = false;
  private boolean hasLabelsOnlyForSelected = false;
  private int minBubbleRadius = 6;
  private List<BubbleValue> values = new ArrayList();
  
  public BubbleChartData() {}
  
  public BubbleChartData(List<BubbleValue> paramList)
  {
    setValues(paramList);
  }
  
  public BubbleChartData(BubbleChartData paramBubbleChartData)
  {
    super(paramBubbleChartData);
    this.formatter = paramBubbleChartData.formatter;
    this.hasLabels = paramBubbleChartData.hasLabels;
    this.hasLabelsOnlyForSelected = paramBubbleChartData.hasLabelsOnlyForSelected;
    this.minBubbleRadius = paramBubbleChartData.minBubbleRadius;
    this.bubbleScale = paramBubbleChartData.bubbleScale;
    paramBubbleChartData = paramBubbleChartData.getValues().iterator();
    while (paramBubbleChartData.hasNext())
    {
      BubbleValue localBubbleValue = (BubbleValue)paramBubbleChartData.next();
      this.values.add(new BubbleValue(localBubbleValue));
    }
  }
  
  public static BubbleChartData generateDummyData()
  {
    BubbleChartData localBubbleChartData = new BubbleChartData();
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(new BubbleValue(0.0F, 20.0F, 15000.0F));
    localArrayList.add(new BubbleValue(3.0F, 22.0F, 20000.0F));
    localArrayList.add(new BubbleValue(5.0F, 25.0F, 5000.0F));
    localArrayList.add(new BubbleValue(7.0F, 30.0F, 30000.0F));
    localArrayList.add(new BubbleValue(11.0F, 22.0F, 10.0F));
    localBubbleChartData.setValues(localArrayList);
    return localBubbleChartData;
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float getBubbleScale()
  {
    return this.bubbleScale;
  }
  
  public BubbleChartValueFormatter getFormatter()
  {
    return this.formatter;
  }
  
  public int getMinBubbleRadius()
  {
    return this.minBubbleRadius;
  }
  
  public List<BubbleValue> getValues()
  {
    return this.values;
  }
  
  public boolean hasLabels()
  {
    return this.hasLabels;
  }
  
  public boolean hasLabelsOnlyForSelected()
  {
    return this.hasLabelsOnlyForSelected;
  }
  
  public void setBubbleScale(float paramFloat)
  {
    this.bubbleScale = paramFloat;
  }
  
  public BubbleChartData setFormatter(BubbleChartValueFormatter paramBubbleChartValueFormatter)
  {
    if (paramBubbleChartValueFormatter != null) {
      this.formatter = paramBubbleChartValueFormatter;
    }
    return this;
  }
  
  public BubbleChartData setHasLabels(boolean paramBoolean)
  {
    this.hasLabels = paramBoolean;
    if (paramBoolean) {
      this.hasLabelsOnlyForSelected = false;
    }
    return this;
  }
  
  public BubbleChartData setHasLabelsOnlyForSelected(boolean paramBoolean)
  {
    this.hasLabelsOnlyForSelected = paramBoolean;
    if (paramBoolean) {
      this.hasLabels = false;
    }
    return this;
  }
  
  public void setMinBubbleRadius(int paramInt)
  {
    this.minBubbleRadius = paramInt;
  }
  
  public BubbleChartData setValues(List<BubbleValue> paramList)
  {
    if (paramList == null)
    {
      this.values = new ArrayList();
      return this;
    }
    this.values = paramList;
    return this;
  }
  
  /* Error */
  public void update(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\BubbleChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */