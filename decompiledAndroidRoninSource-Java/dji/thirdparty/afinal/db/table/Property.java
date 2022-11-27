package dji.thirdparty.afinal.db.table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Property
{
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private String column;
  private Class<?> dataType;
  private String defaultValue;
  private Field field;
  private String fieldName;
  private Method get;
  private Method set;
  
  private static Date stringToDateTime(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = sdf.parse(paramString);
        return paramString;
      }
      catch (ParseException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public String getColumn()
  {
    return this.column;
  }
  
  public Class<?> getDataType()
  {
    return this.dataType;
  }
  
  public String getDefaultValue()
  {
    return this.defaultValue;
  }
  
  public Field getField()
  {
    return this.field;
  }
  
  public String getFieldName()
  {
    return this.fieldName;
  }
  
  public Method getGet()
  {
    return this.get;
  }
  
  public Method getSet()
  {
    return this.set;
  }
  
  public <T> T getValue(Object paramObject)
  {
    return null;
  }
  
  public void setColumn(String paramString)
  {
    this.column = paramString;
  }
  
  public void setDataType(Class<?> paramClass)
  {
    this.dataType = paramClass;
  }
  
  public void setDefaultValue(String paramString)
  {
    this.defaultValue = paramString;
  }
  
  public void setField(Field paramField)
  {
    this.field = paramField;
  }
  
  public void setFieldName(String paramString)
  {
    this.fieldName = paramString;
  }
  
  public void setGet(Method paramMethod)
  {
    this.get = paramMethod;
  }
  
  public void setSet(Method paramMethod)
  {
    this.set = paramMethod;
  }
  
  /* Error */
  public void setValue(Object arg1, android.database.Cursor arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setValue(Object arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\table\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */