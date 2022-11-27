package lecho.lib.hellocharts.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineChartData
  extends AbstractChartData
{
  public static final float DEFAULT_BASE_VALUE = 0.0F;
  private float baseValue = 0.0F;
  private List<Line> lines = new ArrayList();
  
  public LineChartData() {}
  
  public LineChartData(List<Line> paramList)
  {
    setLines(paramList);
  }
  
  public LineChartData(LineChartData paramLineChartData)
  {
    super(paramLineChartData);
    this.baseValue = paramLineChartData.baseValue;
    paramLineChartData = paramLineChartData.lines.iterator();
    while (paramLineChartData.hasNext())
    {
      Line localLine = (Line)paramLineChartData.next();
      this.lines.add(new Line(localLine));
    }
  }
  
  public static LineChartData generateDummyData()
  {
    LineChartData localLineChartData = new LineChartData();
    Object localObject = new ArrayList(4);
    ((List)localObject).add(new PointValue(0.0F, 2.0F));
    ((List)localObject).add(new PointValue(1.0F, 4.0F));
    ((List)localObject).add(new PointValue(2.0F, 3.0F));
    ((List)localObject).add(new PointValue(3.0F, 4.0F));
    localObject = new Line((List)localObject);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(localObject);
    localLineChartData.setLines(localArrayList);
    return localLineChartData;
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float getBaseValue()
  {
    return this.baseValue;
  }
  
  public List<Line> getLines()
  {
    return this.lines;
  }
  
  public LineChartData setBaseValue(float paramFloat)
  {
    this.baseValue = paramFloat;
    return this;
  }
  
  public LineChartData setLines(List<Line> paramList)
  {
    if (paramList == null)
    {
      this.lines = new ArrayList();
      return this;
    }
    this.lines = paramList;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\LineChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */