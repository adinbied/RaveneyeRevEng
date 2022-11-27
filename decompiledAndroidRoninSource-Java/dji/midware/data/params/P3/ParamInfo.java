package dji.midware.data.params.P3;

import dji.midware.data.model.P3.DataFlycGetParamInfo.Attribute;
import dji.midware.data.model.P3.DataFlycGetParamInfo.TypeId;

public class ParamInfo
{
  public DataFlycGetParamInfo.Attribute attribute;
  public long hash;
  public int index;
  public String name;
  public RangeModel range;
  public Number setvalue;
  public int size;
  public Class<? extends Number> type;
  public DataFlycGetParamInfo.TypeId typeId;
  public Number value;
  
  public ParamInfoBean getBean()
  {
    return null;
  }
  
  public boolean isCorrect(Number paramNumber)
  {
    return false;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\params\P3\ParamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */