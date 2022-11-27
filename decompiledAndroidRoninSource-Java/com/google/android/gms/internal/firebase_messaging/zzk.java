package com.google.android.gms.internal.firebase_messaging;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzk
{
  private static final Logger zza = Logger.getLogger(zzk.class.getName());
  
  public static void zza(@NullableDecl InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramInputStream)
      {
        try
        {
          zza.logp(Level.WARNING, "com.google.common.io.Closeables", "close", "IOException thrown while closing Closeable.", paramInputStream);
          return;
        }
        catch (IOException paramInputStream)
        {
          throw new AssertionError(paramInputStream);
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\firebase_messaging\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */