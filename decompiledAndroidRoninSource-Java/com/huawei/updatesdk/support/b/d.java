package com.huawei.updatesdk.support.b;

import android.content.Context;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class d
{
  public static String a(int paramInt)
  {
    NumberFormat localNumberFormat = NumberFormat.getPercentInstance();
    double d = paramInt / 100.0F;
    localNumberFormat.setMinimumFractionDigits(0);
    return localNumberFormat.format(d);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    if (paramLong == 0L) {
      return paramContext.getString(com.huawei.updatesdk.support.e.d.b(paramContext, "upsdk_storage_utils"), new Object[] { "0" });
    }
    DecimalFormat localDecimalFormat = null;
    if (paramLong > 104857L) {
      localDecimalFormat = new DecimalFormat("###.#");
    } else if (paramLong > 10485L) {
      localDecimalFormat = new DecimalFormat("###.##");
    }
    if (localDecimalFormat != null)
    {
      double d = paramLong / 1024.0D / 1024.0D;
      return paramContext.getString(com.huawei.updatesdk.support.e.d.b(paramContext, "upsdk_storage_utils"), new Object[] { localDecimalFormat.format(d) });
    }
    return paramContext.getString(com.huawei.updatesdk.support.e.d.b(paramContext, "upsdk_storage_utils"), new Object[] { "0.01" });
  }
  
  public static byte[] a(String paramString)
  {
    paramString = paramString.toCharArray();
    int m = paramString.length / 2;
    byte[] arrayOfByte = new byte[m];
    int i = 0;
    while (i < m)
    {
      int j = i * 2;
      int k = Character.digit(paramString[j], 16);
      k = Character.digit(paramString[(j + 1)], 16) | k << 4;
      j = k;
      if (k > 127) {
        j = k - 256;
      }
      arrayOfByte[i] = ((byte)j);
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */