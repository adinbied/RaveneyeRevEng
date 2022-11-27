package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bc;
import com.xiaomi.push.h;
import com.xiaomi.push.ho;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.if;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.it;
import com.xiaomi.push.iv;
import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.iz;
import java.nio.ByteBuffer;

public class ap
{
  protected static <T extends iz<T, ?>> ik a(Context paramContext, T paramT, ho paramho)
  {
    return a(paramContext, paramT, paramho, paramho.equals(ho.a) ^ true, paramContext.getPackageName(), b.a(paramContext).a());
  }
  
  protected static <T extends iz<T, ?>> ik a(Context paramContext, T paramT, ho paramho, boolean paramBoolean, String paramString1, String paramString2)
  {
    byte[] arrayOfByte = iy.a(paramT);
    if (arrayOfByte == null) {}
    ik localik;
    for (paramContext = "invoke convertThriftObjectToBytes method, return null.";; paramContext = "regSecret is empty, return null")
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramContext);
      return null;
      localik = new ik();
      paramT = arrayOfByte;
      if (!paramBoolean) {
        break label80;
      }
      paramContext = b.a(paramContext).d();
      if (!TextUtils.isEmpty(paramContext)) {
        break;
      }
    }
    paramContext = bc.a(paramContext);
    try
    {
      paramT = h.b(paramContext, arrayOfByte);
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
    paramT = arrayOfByte;
    label80:
    paramContext = new id();
    paramContext.jdField_a_of_type_Long = 5L;
    paramContext.jdField_a_of_type_JavaLangString = "fakeid";
    localik.a(paramContext);
    localik.a(ByteBuffer.wrap(paramT));
    localik.a(paramho);
    localik.b(true);
    localik.b(paramString1);
    localik.a(paramBoolean);
    localik.a(paramString2);
    return localik;
  }
  
  public static iz a(Context paramContext, ik paramik)
  {
    if (paramik.b())
    {
      paramContext = bc.a(b.a(paramContext).d());
      try
      {
        paramContext = h.a(paramContext, paramik.a());
      }
      catch (Exception paramContext)
      {
        throw new t("the aes decrypt failed.", paramContext);
      }
    }
    else
    {
      paramContext = paramik.a();
    }
    paramik = a(paramik.a(), paramik.b);
    if (paramik != null) {
      iy.a(paramik, paramContext);
    }
    return paramik;
  }
  
  private static iz a(ho paramho, boolean paramBoolean)
  {
    switch (aq.a[paramho.ordinal()])
    {
    default: 
      return null;
    case 10: 
      return new ij();
    case 9: 
      if (paramBoolean) {
        return new in();
      }
      paramho = new if();
      paramho.a(true);
      return paramho;
    case 8: 
      return new iq();
    case 7: 
      return new ij();
    case 6: 
      return new ie();
    case 5: 
      return new ir();
    case 4: 
      return new ix();
    case 3: 
      return new it();
    case 2: 
      return new iv();
    }
    return new ip();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */