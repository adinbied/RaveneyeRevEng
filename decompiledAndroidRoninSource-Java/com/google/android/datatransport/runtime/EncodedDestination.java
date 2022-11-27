package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Set;

public abstract interface EncodedDestination
  extends Destination
{
  public abstract Set<Encoding> getSupportedEncodings();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\EncodedDestination.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */