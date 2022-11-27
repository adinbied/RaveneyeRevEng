package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.ArrayMap;

public final class zzde
{
  private static final ArrayMap<String, Uri> zza = new ArrayMap();
  
  public static Uri zza(String paramString)
  {
    try
    {
      Uri localUri = (Uri)zza.get(paramString);
      Object localObject = localUri;
      if (localUri == null)
      {
        localObject = String.valueOf(Uri.encode(paramString));
        if (((String)localObject).length() != 0) {
          localObject = "content://com.google.android.gms.phenotype/".concat((String)localObject);
        } else {
          localObject = new String("content://com.google.android.gms.phenotype/");
        }
        localObject = Uri.parse((String)localObject);
        zza.put(paramString, localObject);
      }
      return (Uri)localObject;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */