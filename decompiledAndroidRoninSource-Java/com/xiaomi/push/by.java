package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class by
  extends cd.b<Long>
{
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString;
  
  public by(String paramString1, List<String> paramList, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    super(paramString1, paramList, paramString2, paramArrayOfString, paramString3, paramString4, paramString5, paramInt);
    this.jdField_a_of_type_JavaLangString = paramString6;
  }
  
  public static by a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("count(*)");
    return new by(paramString, localArrayList, null, null, null, null, null, 0, "job to get count of all message");
  }
  
  public Long a(Context paramContext, Cursor paramCursor)
  {
    return Long.valueOf(paramCursor.getLong(0));
  }
  
  public Object a()
  {
    return Long.valueOf(this.jdField_a_of_type_Long);
  }
  
  public void a(Context paramContext, List<Long> paramList)
  {
    if ((paramContext != null) && (paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_Long = ((Long)paramList.get(0)).longValue();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */