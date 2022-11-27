package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;

public class ca
  extends cd.e
{
  private String a = "MessageInsertJob";
  
  public ca(String paramString1, ContentValues paramContentValues, String paramString2)
  {
    super(paramString1, paramContentValues);
    this.a = paramString2;
  }
  
  public static ca a(Context paramContext, String paramString, hs paramhs)
  {
    byte[] arrayOfByte = iy.a(paramhs);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(0));
      localContentValues.put("messageId", "");
      localContentValues.put("messageItemId", paramhs.d());
      localContentValues.put("messageItem", arrayOfByte);
      localContentValues.put("appId", br.a(paramContext).b());
      localContentValues.put("packageName", br.a(paramContext).a());
      localContentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("uploadTimestamp", Integer.valueOf(0));
      return new ca(paramString, localContentValues, "a job build to insert message to db");
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */