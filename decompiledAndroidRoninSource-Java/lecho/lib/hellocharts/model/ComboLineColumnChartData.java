package lecho.lib.hellocharts.model;

public class ComboLineColumnChartData
  extends AbstractChartData
{
  private ColumnChartData columnChartData;
  private LineChartData lineChartData;
  
  public ComboLineColumnChartData()
  {
    this.columnChartData = new ColumnChartData();
    this.lineChartData = new LineChartData();
  }
  
  public ComboLineColumnChartData(ColumnChartData paramColumnChartData, LineChartData paramLineChartData)
  {
    setColumnChartData(paramColumnChartData);
    setLineChartData(paramLineChartData);
  }
  
  public ComboLineColumnChartData(ComboLineColumnChartData paramComboLineColumnChartData)
  {
    super(paramComboLineColumnChartData);
    setColumnChartData(new ColumnChartData(paramComboLineColumnChartData.getColumnChartData()));
    setLineChartData(new LineChartData(paramComboLineColumnChartData.getLineChartData()));
  }
  
  public static ComboLineColumnChartData generateDummyData()
  {
    ComboLineColumnChartData localComboLineColumnChartData = new ComboLineColumnChartData();
    localComboLineColumnChartData.setColumnChartData(ColumnChartData.generateDummyData());
    localComboLineColumnChartData.setLineChartData(LineChartData.generateDummyData());
    return localComboLineColumnChartData;
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ColumnChartData getColumnChartData()
  {
    return this.columnChartData;
  }
  
  public LineChartData getLineChartData()
  {
    return this.lineChartData;
  }
  
  public void setColumnChartData(ColumnChartData paramColumnChartData)
  {
    if (paramColumnChartData == null)
    {
      this.columnChartData = new ColumnChartData();
      return;
    }
    this.columnChartData = paramColumnChartData;
  }
  
  public void setLineChartData(LineChartData paramLineChartData)
  {
    if (paramLineChartData == null)
    {
      this.lineChartData = new LineChartData();
      return;
    }
    this.lineChartData = paramLineChartData;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\ComboLineColumnChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */