package lecho.lib.hellocharts.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lecho.lib.hellocharts.formatter.ColumnChartValueFormatter;
import lecho.lib.hellocharts.formatter.SimpleColumnChartValueFormatter;

public class Column
{
  private ColumnChartValueFormatter formatter = new SimpleColumnChartValueFormatter();
  private boolean hasLabels = false;
  private boolean hasLabelsOnlyForSelected = false;
  private List<SubcolumnValue> values = new ArrayList();
  
  public Column() {}
  
  public Column(List<SubcolumnValue> paramList)
  {
    setValues(paramList);
  }
  
  public Column(Column paramColumn)
  {
    this.hasLabels = paramColumn.hasLabels;
    this.hasLabelsOnlyForSelected = paramColumn.hasLabelsOnlyForSelected;
    this.formatter = paramColumn.formatter;
    paramColumn = paramColumn.values.iterator();
    while (paramColumn.hasNext())
    {
      SubcolumnValue localSubcolumnValue = (SubcolumnValue)paramColumn.next();
      this.values.add(new SubcolumnValue(localSubcolumnValue));
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
  
  public ColumnChartValueFormatter getFormatter()
  {
    return this.formatter;
  }
  
  public List<SubcolumnValue> getValues()
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
  
  public Column setFormatter(ColumnChartValueFormatter paramColumnChartValueFormatter)
  {
    if (paramColumnChartValueFormatter != null) {
      this.formatter = paramColumnChartValueFormatter;
    }
    return this;
  }
  
  public Column setHasLabels(boolean paramBoolean)
  {
    this.hasLabels = paramBoolean;
    if (paramBoolean) {
      this.hasLabelsOnlyForSelected = false;
    }
    return this;
  }
  
  public Column setHasLabelsOnlyForSelected(boolean paramBoolean)
  {
    this.hasLabelsOnlyForSelected = paramBoolean;
    if (paramBoolean) {
      this.hasLabels = false;
    }
    return this;
  }
  
  public Column setValues(List<SubcolumnValue> paramList)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\Column.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */