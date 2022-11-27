package dji.thirdparty.afinal.db.sqlite;

import java.util.LinkedList;

public class SqlInfo
{
  private LinkedList<Object> bindArgs;
  private String sql;
  
  /* Error */
  public void addValue(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public LinkedList<Object> getBindArgs()
  {
    return this.bindArgs;
  }
  
  public Object[] getBindArgsAsArray()
  {
    return null;
  }
  
  public String[] getBindArgsAsStringArray()
  {
    return null;
  }
  
  public String getSql()
  {
    return this.sql;
  }
  
  public void setBindArgs(LinkedList<Object> paramLinkedList)
  {
    this.bindArgs = paramLinkedList;
  }
  
  public void setSql(String paramString)
  {
    this.sql = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\sqlite\SqlInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */