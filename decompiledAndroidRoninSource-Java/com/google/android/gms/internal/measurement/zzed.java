package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzed
{
  private static String zza(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    try
    {
      String str1 = paramObject.toString();
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = paramObject.getClass().getName();
      paramObject = Integer.toHexString(System.identityHashCode(paramObject));
      Object localObject = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(paramObject).length());
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append('@');
      ((StringBuilder)localObject).append((String)paramObject);
      str2 = ((StringBuilder)localObject).toString();
      localObject = Logger.getLogger("com.google.common.base.Strings");
      Level localLevel = Level.WARNING;
      paramObject = String.valueOf(str2);
      if (((String)paramObject).length() != 0) {
        paramObject = "Exception during lenientFormat for ".concat((String)paramObject);
      } else {
        paramObject = new String("Exception during lenientFormat for ");
      }
      ((Logger)localObject).logp(localLevel, "com.google.common.base.Strings", "lenientToString", (String)paramObject, localException);
      paramObject = localException.getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str2).length() + 9 + String.valueOf(paramObject).length());
      localStringBuilder.append("<");
      localStringBuilder.append(str2);
      localStringBuilder.append(" threw ");
      localStringBuilder.append((String)paramObject);
      localStringBuilder.append(">");
      return localStringBuilder.toString();
    }
  }
  
  public static String zza(@NullableDecl String paramString, @NullableDecl Object... paramVarArgs)
  {
    paramString = String.valueOf(paramString);
    int k = 0;
    int i = 0;
    while (i < paramVarArgs.length)
    {
      paramVarArgs[i] = zza(paramVarArgs[i]);
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramVarArgs.length * 16);
    int j = 0;
    i = k;
    while (i < paramVarArgs.length)
    {
      k = paramString.indexOf("%s", j);
      if (k == -1) {
        break;
      }
      localStringBuilder.append(paramString, j, k);
      localStringBuilder.append(paramVarArgs[i]);
      j = k + 2;
      i += 1;
    }
    localStringBuilder.append(paramString, j, paramString.length());
    if (i < paramVarArgs.length)
    {
      localStringBuilder.append(" [");
      j = i + 1;
      localStringBuilder.append(paramVarArgs[i]);
      i = j;
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
      localStringBuilder.append(']');
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */