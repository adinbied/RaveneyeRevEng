package lecho.lib.hellocharts.model;

import android.graphics.PathEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lecho.lib.hellocharts.formatter.LineChartValueFormatter;
import lecho.lib.hellocharts.formatter.SimpleLineChartValueFormatter;
import lecho.lib.hellocharts.util.ChartUtils;

public class Line
{
  private static final int DEFAULT_AREA_TRANSPARENCY = 64;
  private static final int DEFAULT_LINE_STROKE_WIDTH_DP = 3;
  private static final int DEFAULT_POINT_RADIUS_DP = 6;
  public static final int UNINITIALIZED = 0;
  private int areaTransparency = 64;
  private int color = ChartUtils.DEFAULT_COLOR;
  private int darkenColor = ChartUtils.DEFAULT_DARKEN_COLOR;
  private LineChartValueFormatter formatter = new SimpleLineChartValueFormatter();
  private boolean hasLabels = false;
  private boolean hasLabelsOnlyForSelected = false;
  private boolean hasLines = true;
  private boolean hasPoints = true;
  private boolean isCubic = false;
  private boolean isFilled = false;
  private boolean isSquare = false;
  private PathEffect pathEffect;
  private int pointColor = 0;
  private int pointRadius = 6;
  private ValueShape shape = ValueShape.CIRCLE;
  private int strokeWidth = 3;
  private List<PointValue> values = new ArrayList();
  
  public Line() {}
  
  public Line(List<PointValue> paramList)
  {
    setValues(paramList);
  }
  
  public Line(Line paramLine)
  {
    this.color = paramLine.color;
    this.pointColor = paramLine.pointColor;
    this.darkenColor = paramLine.darkenColor;
    this.areaTransparency = paramLine.areaTransparency;
    this.strokeWidth = paramLine.strokeWidth;
    this.pointRadius = paramLine.pointRadius;
    this.hasPoints = paramLine.hasPoints;
    this.hasLines = paramLine.hasLines;
    this.hasLabels = paramLine.hasLabels;
    this.hasLabelsOnlyForSelected = paramLine.hasLabelsOnlyForSelected;
    this.isSquare = paramLine.isSquare;
    this.isCubic = paramLine.isCubic;
    this.isFilled = paramLine.isFilled;
    this.shape = paramLine.shape;
    this.pathEffect = paramLine.pathEffect;
    this.formatter = paramLine.formatter;
    paramLine = paramLine.values.iterator();
    while (paramLine.hasNext())
    {
      PointValue localPointValue = (PointValue)paramLine.next();
      this.values.add(new PointValue(localPointValue));
    }
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getAreaTransparency()
  {
    return this.areaTransparency;
  }
  
  public int getColor()
  {
    return this.color;
  }
  
  public int getDarkenColor()
  {
    return this.darkenColor;
  }
  
  public LineChartValueFormatter getFormatter()
  {
    return this.formatter;
  }
  
  public PathEffect getPathEffect()
  {
    return this.pathEffect;
  }
  
  public int getPointColor()
  {
    int j = this.pointColor;
    int i = j;
    if (j == 0) {
      i = this.color;
    }
    return i;
  }
  
  public int getPointRadius()
  {
    return this.pointRadius;
  }
  
  public ValueShape getShape()
  {
    return this.shape;
  }
  
  public int getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public List<PointValue> getValues()
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
  
  public boolean hasLines()
  {
    return this.hasLines;
  }
  
  public boolean hasPoints()
  {
    return this.hasPoints;
  }
  
  public boolean isCubic()
  {
    return this.isCubic;
  }
  
  public boolean isFilled()
  {
    return this.isFilled;
  }
  
  public boolean isSquare()
  {
    return this.isSquare;
  }
  
  public Line setAreaTransparency(int paramInt)
  {
    this.areaTransparency = paramInt;
    return this;
  }
  
  public Line setColor(int paramInt)
  {
    return null;
  }
  
  public Line setCubic(boolean paramBoolean)
  {
    this.isCubic = paramBoolean;
    if (this.isSquare) {
      setSquare(false);
    }
    return this;
  }
  
  public Line setFilled(boolean paramBoolean)
  {
    this.isFilled = paramBoolean;
    return this;
  }
  
  public Line setFormatter(LineChartValueFormatter paramLineChartValueFormatter)
  {
    if (paramLineChartValueFormatter != null) {
      this.formatter = paramLineChartValueFormatter;
    }
    return this;
  }
  
  public Line setHasLabels(boolean paramBoolean)
  {
    this.hasLabels = paramBoolean;
    if (paramBoolean) {
      this.hasLabelsOnlyForSelected = false;
    }
    return this;
  }
  
  public Line setHasLabelsOnlyForSelected(boolean paramBoolean)
  {
    this.hasLabelsOnlyForSelected = paramBoolean;
    if (paramBoolean) {
      this.hasLabels = false;
    }
    return this;
  }
  
  public Line setHasLines(boolean paramBoolean)
  {
    this.hasLines = paramBoolean;
    return this;
  }
  
  public Line setHasPoints(boolean paramBoolean)
  {
    this.hasPoints = paramBoolean;
    return this;
  }
  
  public void setPathEffect(PathEffect paramPathEffect)
  {
    this.pathEffect = paramPathEffect;
  }
  
  public Line setPointColor(int paramInt)
  {
    this.pointColor = paramInt;
    if (paramInt == 0)
    {
      this.darkenColor = ChartUtils.darkenColor(this.color);
      return this;
    }
    this.darkenColor = ChartUtils.darkenColor(paramInt);
    return this;
  }
  
  public Line setPointRadius(int paramInt)
  {
    this.pointRadius = paramInt;
    return this;
  }
  
  public Line setShape(ValueShape paramValueShape)
  {
    this.shape = paramValueShape;
    return this;
  }
  
  public Line setSquare(boolean paramBoolean)
  {
    this.isSquare = paramBoolean;
    if (this.isCubic) {
      setCubic(false);
    }
    return this;
  }
  
  public Line setStrokeWidth(int paramInt)
  {
    this.strokeWidth = paramInt;
    return this;
  }
  
  public void setValues(List<PointValue> paramList)
  {
    if (paramList == null)
    {
      this.values = new ArrayList();
      return;
    }
    this.values = paramList;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\Line.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */