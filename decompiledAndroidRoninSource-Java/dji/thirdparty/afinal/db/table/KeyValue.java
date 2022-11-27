package dji.thirdparty.afinal.db.table;

public class KeyValue
{
  private String key;
  private Object value;
  
  public KeyValue() {}
  
  public KeyValue(String paramString, Object paramObject)
  {
    this.key = paramString;
    this.value = paramObject;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public Object getValue()
  {
    return null;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setValue(Object paramObject)
  {
    this.value = paramObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\table\KeyValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */