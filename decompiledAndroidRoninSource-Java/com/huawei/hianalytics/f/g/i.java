package com.huawei.hianalytics.f.g;

import android.text.TextUtils;
import com.huawei.hianalytics.g.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class i
{
  public static long a(String paramString, long paramLong)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.getDefault());
      paramLong = paramString.parse(paramString.format(Long.valueOf(paramLong))).getTime();
      return paramLong;
    }
    catch (ParseException paramString)
    {
      for (;;) {}
    }
    b.c("HiAnalytics/event/stringUtil", "getMillisOfDate(): Time conversion Exception !");
    return 0L;
  }
  
  public static String a()
  {
    return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039";
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "allType";
          }
          return "diffprivacy";
        }
        return "preins";
      }
      return "maint";
    }
    return "oper";
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() <= paramInt) {
        return paramString;
      }
      int j = paramString.length();
      int i = 0;
      for (;;)
      {
        str = paramString;
        if (i >= paramInt) {
          break;
        }
        int k = j - 1;
        str = paramString.substring(0, k);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.substring(k));
        localStringBuilder.append(str);
        paramString = localStringBuilder.toString();
        i += 1;
      }
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = e.a(paramString1);
    paramString2 = e.a(paramString2);
    paramString3 = e.a(paramString3);
    paramString4 = e.a(paramString4);
    int j = paramString1.length;
    int i = j;
    if (j > paramString2.length) {
      i = paramString2.length;
    }
    j = i;
    if (i > paramString3.length) {
      j = paramString3.length;
    }
    i = j;
    if (j > paramString4.length) {
      i = paramString4.length;
    }
    char[] arrayOfChar = new char[i];
    j = 0;
    while (j < i)
    {
      arrayOfChar[j] = ((char)(paramString1[j] ^ paramString2[j] ^ paramString3[j] ^ paramString4[j]));
      j += 1;
    }
    return a(arrayOfChar, e.a(paramString5));
  }
  
  private static String a(char[] paramArrayOfChar, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfChar = new PBEKeySpec(paramArrayOfChar, paramArrayOfByte, 10000, 128);
      paramArrayOfChar = e.a(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(paramArrayOfChar).getEncoded());
      return paramArrayOfChar;
    }
    catch (InvalidKeySpecException paramArrayOfChar)
    {
      for (;;) {}
    }
    catch (NoSuchAlgorithmException paramArrayOfChar)
    {
      label45:
      for (;;) {}
    }
    paramArrayOfChar = "getAuthToken() encryptPBKDF2 No such algorithm!";
    break label45;
    paramArrayOfChar = "getAuthToken() encryptPBKDF2 Invalid key specification !";
    b.d("HiAnalytics/event/stringUtil", paramArrayOfChar);
    return null;
  }
  
  public static Set<String> a(Set<String> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() != 0))
    {
      HashSet localHashSet = new HashSet(paramSet.size());
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str = (String)paramSet.next();
        if (!str.equals("_default_config_tag"))
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append("oper");
          localObject1 = ((StringBuilder)localObject1).toString();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("-");
          ((StringBuilder)localObject2).append("maint");
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("-");
          localStringBuilder.append("diffprivacy");
          str = localStringBuilder.toString();
          localHashSet.add(localObject1);
          localHashSet.add(localObject2);
          localHashSet.add(str);
        }
        else
        {
          localHashSet.add("_default_config_tag");
        }
      }
      return localHashSet;
    }
    return new HashSet();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */