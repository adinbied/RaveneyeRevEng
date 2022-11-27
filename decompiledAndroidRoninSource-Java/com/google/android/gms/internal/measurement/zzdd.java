package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

public final class zzdd
{
  private final Map<String, Map<String, String>> zza;
  
  zzdd(Map<String, Map<String, String>> paramMap)
  {
    this.zza = paramMap;
  }
  
  @Nullable
  public final String zza(@Nullable Uri paramUri, @Nullable String paramString1, @Nullable String paramString2, String paramString3)
  {
    if (paramUri != null)
    {
      paramUri = paramUri.toString();
      paramString1 = (Map)this.zza.get(paramUri);
      if (paramString1 == null) {
        return null;
      }
      paramUri = paramString3;
      if (paramString2 != null)
      {
        paramUri = String.valueOf(paramString2);
        paramString2 = String.valueOf(paramString3);
        if (paramString2.length() != 0) {
          paramUri = paramUri.concat(paramString2);
        } else {
          paramUri = new String(paramUri);
        }
      }
      return (String)paramString1.get(paramUri);
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */