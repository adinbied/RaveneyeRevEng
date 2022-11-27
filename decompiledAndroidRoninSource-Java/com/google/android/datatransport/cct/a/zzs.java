package com.google.android.datatransport.cct.a;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.Reader;

public abstract class zzs
{
  public static zzs zza(Reader paramReader)
    throws IOException
  {
    paramReader = new JsonReader(paramReader);
    try
    {
      paramReader.beginObject();
      while (paramReader.hasNext())
      {
        Object localObject1 = paramReader.nextName();
        if (((String)localObject1).equals("nextRequestWaitMillis"))
        {
          if (paramReader.peek() == JsonToken.STRING)
          {
            localObject1 = new zzl(Long.parseLong(paramReader.nextString()));
            return (zzs)localObject1;
          }
          localObject1 = new zzl(paramReader.nextLong());
          return (zzs)localObject1;
        }
        paramReader.skipValue();
      }
      throw new IOException("Response is missing nextRequestWaitMillis field.");
    }
    finally
    {
      paramReader.close();
    }
  }
  
  public abstract long zza();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */