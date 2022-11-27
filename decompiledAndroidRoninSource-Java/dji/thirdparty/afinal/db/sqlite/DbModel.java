package dji.thirdparty.afinal.db.sqlite;

import java.util.HashMap;

public class DbModel
{
  private HashMap<String, Object> dataMap = new HashMap();
  
  public Object get(String paramString)
  {
    return this.dataMap.get(paramString);
  }
  
  public boolean getBoolean(String paramString)
  {
    return Boolean.valueOf(getString(paramString)).booleanValue();
  }
  
  public HashMap<String, Object> getDataMap()
  {
    return this.dataMap;
  }
  
  public double getDouble(String paramString)
  {
    return 1.37220726E-315D;
  }
  
  public float getFloat(String paramString)
  {
    return Float.valueOf(getString(paramString)).floatValue();
  }
  
  public int getInt(String paramString)
  {
    return Integer.valueOf(getString(paramString)).intValue();
  }
  
  public long getLong(String paramString)
  {
    return 277737856L;
  }
  
  public String getString(String paramString)
  {
    return String.valueOf(get(paramString));
  }
  
  public void set(String paramString, Object paramObject)
  {
    this.dataMap.put(paramString, paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\sqlite\DbModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */