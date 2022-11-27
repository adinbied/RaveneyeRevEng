package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.manager.P3.DataBase.DATA_TYPE;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.HashMap;

public class DataFlycGetParamInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private static HashMap<Integer, DataFlycGetParamInfo> hashMap = new HashMap();
  private Integer index;
  
  public DataFlycGetParamInfo(Integer paramInteger)
  {
    this.index = paramInteger;
  }
  
  private static DataFlycGetParamInfo getInstance(Integer paramInteger)
  {
    try
    {
      DataFlycGetParamInfo localDataFlycGetParamInfo2 = (DataFlycGetParamInfo)hashMap.get(paramInteger);
      DataFlycGetParamInfo localDataFlycGetParamInfo1 = localDataFlycGetParamInfo2;
      if (localDataFlycGetParamInfo2 == null)
      {
        localDataFlycGetParamInfo1 = new DataFlycGetParamInfo(paramInteger);
        hashMap.put(paramInteger, localDataFlycGetParamInfo1);
      }
      return localDataFlycGetParamInfo1;
    }
    finally {}
  }
  
  /* Error */
  private void setRange(dji.midware.data.params.P3.RangeModel arg1, Class<? extends Number> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected DataBase.DATA_TYPE getDataType()
  {
    return DataBase.DATA_TYPE.LOCAL;
  }
  
  public ParamInfo getInfo()
  {
    return null;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum Attribute
  {
    private int data;
    
    static
    {
      EEPROM_WRITE = new Attribute("EEPROM_WRITE", 2, 2);
      EEPROM_SPECIFIC = new Attribute("EEPROM_SPECIFIC", 3, 4);
      IMPORT_EXPORT = new Attribute("IMPORT_EXPORT", 4, 8);
      EEPROM_RW = new Attribute("EEPROM_RW", 5, EEPROM_WRITE.value() | READ_WRITE.value());
      EEPROM_RW_IE = new Attribute("EEPROM_RW_IE", 6, EEPROM_WRITE.value() | READ_WRITE.value() | IMPORT_EXPORT.value());
      Attribute localAttribute = new Attribute("OTHER", 7, 100);
      OTHER = localAttribute;
      $VALUES = new Attribute[] { READ_ONLY, READ_WRITE, EEPROM_WRITE, EEPROM_SPECIFIC, IMPORT_EXPORT, EEPROM_RW, EEPROM_RW_IE, localAttribute };
    }
    
    private Attribute(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static Attribute find(int paramInt)
    {
      Attribute localAttribute = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localAttribute;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum TypeId
  {
    private int data;
    
    static
    {
      INT08S = new TypeId("INT08S", 4, 4);
      INT16S = new TypeId("INT16S", 5, 5);
      INT32S = new TypeId("INT32S", 6, 6);
      INT64S = new TypeId("INT64S", 7, 7);
      FLOAT = new TypeId("FLOAT", 8, 8);
      DOUBLE = new TypeId("DOUBLE", 9, 9);
      BYTE = new TypeId("BYTE", 10, 10);
      STRING = new TypeId("STRING", 11, 11);
      TypeId localTypeId = new TypeId("OTHER", 12, 100);
      OTHER = localTypeId;
      $VALUES = new TypeId[] { INT08U, INT16U, INT32U, INT64U, INT08S, INT16S, INT32S, INT64S, FLOAT, DOUBLE, BYTE, STRING, localTypeId };
    }
    
    private TypeId(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TypeId find(int paramInt)
    {
      TypeId localTypeId = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTypeId;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetParamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */