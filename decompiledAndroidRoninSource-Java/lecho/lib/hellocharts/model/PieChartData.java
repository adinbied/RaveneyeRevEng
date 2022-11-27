package lecho.lib.hellocharts.model;

import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lecho.lib.hellocharts.formatter.PieChartValueFormatter;
import lecho.lib.hellocharts.formatter.SimplePieChartValueFormatter;

public class PieChartData
  extends AbstractChartData
{
  public static final float DEFAULT_CENTER_CIRCLE_SCALE = 0.6F;
  public static final int DEFAULT_CENTER_TEXT1_SIZE_SP = 42;
  public static final int DEFAULT_CENTER_TEXT2_SIZE_SP = 16;
  private static final int DEFAULT_SLICE_SPACING_DP = 2;
  private int centerCircleColor = 0;
  private float centerCircleScale = 0.6F;
  private String centerText1;
  private int centerText1Color = -16777216;
  private int centerText1FontSize = 42;
  private Typeface centerText1Typeface;
  private String centerText2;
  private int centerText2Color = -16777216;
  private int centerText2FontSize = 16;
  private Typeface centerText2Typeface;
  private PieChartValueFormatter formatter = new SimplePieChartValueFormatter();
  private boolean hasCenterCircle = false;
  private boolean hasLabels = false;
  private boolean hasLabelsOnlyForSelected = false;
  private boolean hasLabelsOutside = false;
  private int slicesSpacing = 2;
  private List<SliceValue> values = new ArrayList();
  
  public PieChartData()
  {
    setAxisXBottom(null);
    setAxisYLeft(null);
  }
  
  public PieChartData(List<SliceValue> paramList)
  {
    setValues(paramList);
    setAxisXBottom(null);
    setAxisYLeft(null);
  }
  
  public PieChartData(PieChartData paramPieChartData)
  {
    super(paramPieChartData);
    this.formatter = paramPieChartData.formatter;
    this.hasLabels = paramPieChartData.hasLabels;
    this.hasLabelsOnlyForSelected = paramPieChartData.hasLabelsOnlyForSelected;
    this.hasLabelsOutside = paramPieChartData.hasLabelsOutside;
    this.hasCenterCircle = paramPieChartData.hasCenterCircle;
    this.centerCircleColor = paramPieChartData.centerCircleColor;
    this.centerCircleScale = paramPieChartData.centerCircleScale;
    this.centerText1Color = paramPieChartData.centerText1Color;
    this.centerText1FontSize = paramPieChartData.centerText1FontSize;
    this.centerText1Typeface = paramPieChartData.centerText1Typeface;
    this.centerText1 = paramPieChartData.centerText1;
    this.centerText2Color = paramPieChartData.centerText2Color;
    this.centerText2FontSize = paramPieChartData.centerText2FontSize;
    this.centerText2Typeface = paramPieChartData.centerText2Typeface;
    this.centerText2 = paramPieChartData.centerText2;
    paramPieChartData = paramPieChartData.values.iterator();
    while (paramPieChartData.hasNext())
    {
      SliceValue localSliceValue = (SliceValue)paramPieChartData.next();
      this.values.add(new SliceValue(localSliceValue));
    }
  }
  
  public static PieChartData generateDummyData()
  {
    PieChartData localPieChartData = new PieChartData();
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(new SliceValue(40.0F));
    localArrayList.add(new SliceValue(20.0F));
    localArrayList.add(new SliceValue(30.0F));
    localArrayList.add(new SliceValue(50.0F));
    localPieChartData.setValues(localArrayList);
    return localPieChartData;
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getCenterCircleColor()
  {
    return this.centerCircleColor;
  }
  
  public float getCenterCircleScale()
  {
    return this.centerCircleScale;
  }
  
  public String getCenterText1()
  {
    return this.centerText1;
  }
  
  public int getCenterText1Color()
  {
    return this.centerText1Color;
  }
  
  public int getCenterText1FontSize()
  {
    return this.centerText1FontSize;
  }
  
  public Typeface getCenterText1Typeface()
  {
    return this.centerText1Typeface;
  }
  
  public String getCenterText2()
  {
    return this.centerText2;
  }
  
  public int getCenterText2Color()
  {
    return this.centerText2Color;
  }
  
  public int getCenterText2FontSize()
  {
    return this.centerText2FontSize;
  }
  
  public Typeface getCenterText2Typeface()
  {
    return this.centerText2Typeface;
  }
  
  public PieChartValueFormatter getFormatter()
  {
    return this.formatter;
  }
  
  public int getSlicesSpacing()
  {
    return this.slicesSpacing;
  }
  
  public List<SliceValue> getValues()
  {
    return this.values;
  }
  
  public boolean hasCenterCircle()
  {
    return this.hasCenterCircle;
  }
  
  public boolean hasLabels()
  {
    return this.hasLabels;
  }
  
  public boolean hasLabelsOnlyForSelected()
  {
    return this.hasLabelsOnlyForSelected;
  }
  
  public boolean hasLabelsOutside()
  {
    return this.hasLabelsOutside;
  }
  
  public void setAxisXBottom(Axis paramAxis)
  {
    super.setAxisXBottom(null);
  }
  
  public void setAxisYLeft(Axis paramAxis)
  {
    super.setAxisYLeft(null);
  }
  
  public PieChartData setCenterCircleColor(int paramInt)
  {
    this.centerCircleColor = paramInt;
    return this;
  }
  
  public PieChartData setCenterCircleScale(float paramFloat)
  {
    this.centerCircleScale = paramFloat;
    return this;
  }
  
  public PieChartData setCenterText1(String paramString)
  {
    this.centerText1 = paramString;
    return this;
  }
  
  public PieChartData setCenterText1Color(int paramInt)
  {
    this.centerText1Color = paramInt;
    return this;
  }
  
  public PieChartData setCenterText1FontSize(int paramInt)
  {
    this.centerText1FontSize = paramInt;
    return this;
  }
  
  public PieChartData setCenterText1Typeface(Typeface paramTypeface)
  {
    this.centerText1Typeface = paramTypeface;
    return this;
  }
  
  public PieChartData setCenterText2(String paramString)
  {
    this.centerText2 = paramString;
    return this;
  }
  
  public PieChartData setCenterText2Color(int paramInt)
  {
    this.centerText2Color = paramInt;
    return this;
  }
  
  public PieChartData setCenterText2FontSize(int paramInt)
  {
    this.centerText2FontSize = paramInt;
    return this;
  }
  
  public PieChartData setCenterText2Typeface(Typeface paramTypeface)
  {
    this.centerText2Typeface = paramTypeface;
    return this;
  }
  
  public PieChartData setFormatter(PieChartValueFormatter paramPieChartValueFormatter)
  {
    if (paramPieChartValueFormatter != null) {
      this.formatter = paramPieChartValueFormatter;
    }
    return this;
  }
  
  public PieChartData setHasCenterCircle(boolean paramBoolean)
  {
    this.hasCenterCircle = paramBoolean;
    return this;
  }
  
  public PieChartData setHasLabels(boolean paramBoolean)
  {
    this.hasLabels = paramBoolean;
    if (paramBoolean) {
      this.hasLabelsOnlyForSelected = false;
    }
    return this;
  }
  
  public PieChartData setHasLabelsOnlyForSelected(boolean paramBoolean)
  {
    this.hasLabelsOnlyForSelected = paramBoolean;
    if (paramBoolean) {
      this.hasLabels = false;
    }
    return this;
  }
  
  public PieChartData setHasLabelsOutside(boolean paramBoolean)
  {
    this.hasLabelsOutside = paramBoolean;
    return this;
  }
  
  public PieChartData setSlicesSpacing(int paramInt)
  {
    this.slicesSpacing = paramInt;
    return this;
  }
  
  public PieChartData setValues(List<SliceValue> paramList)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\PieChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */