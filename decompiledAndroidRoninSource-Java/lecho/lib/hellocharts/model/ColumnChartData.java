package lecho.lib.hellocharts.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColumnChartData
  extends AbstractChartData
{
  public static final float DEFAULT_BASE_VALUE = 0.0F;
  public static final float DEFAULT_FILL_RATIO = 0.75F;
  private float baseValue = 0.0F;
  private List<Column> columns = new ArrayList();
  private float fillRatio = 0.75F;
  private boolean isStacked = false;
  
  public ColumnChartData() {}
  
  public ColumnChartData(List<Column> paramList)
  {
    setColumns(paramList);
  }
  
  public ColumnChartData(ColumnChartData paramColumnChartData)
  {
    super(paramColumnChartData);
    this.isStacked = paramColumnChartData.isStacked;
    this.fillRatio = paramColumnChartData.fillRatio;
    paramColumnChartData = paramColumnChartData.columns.iterator();
    while (paramColumnChartData.hasNext())
    {
      Column localColumn = (Column)paramColumnChartData.next();
      this.columns.add(new Column(localColumn));
    }
  }
  
  public static ColumnChartData generateDummyData()
  {
    ColumnChartData localColumnChartData = new ColumnChartData();
    ArrayList localArrayList1 = new ArrayList(4);
    int i = 1;
    while (i <= 4)
    {
      ArrayList localArrayList2 = new ArrayList(4);
      localArrayList2.add(new SubcolumnValue(i));
      localArrayList1.add(new Column(localArrayList2));
      i += 1;
    }
    localColumnChartData.setColumns(localArrayList1);
    return localColumnChartData;
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
  
  public List<Column> getColumns()
  {
    return this.columns;
  }
  
  public float getFillRatio()
  {
    return this.fillRatio;
  }
  
  public boolean isStacked()
  {
    return this.isStacked;
  }
  
  public ColumnChartData setBaseValue(float paramFloat)
  {
    this.baseValue = paramFloat;
    return this;
  }
  
  public ColumnChartData setColumns(List<Column> paramList)
  {
    if (paramList == null)
    {
      this.columns = new ArrayList();
      return this;
    }
    this.columns = paramList;
    return this;
  }
  
  public ColumnChartData setFillRatio(float paramFloat)
  {
    return null;
  }
  
  public ColumnChartData setStacked(boolean paramBoolean)
  {
    this.isStacked = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\ColumnChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */