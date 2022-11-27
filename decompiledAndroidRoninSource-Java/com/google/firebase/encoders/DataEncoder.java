package com.google.firebase.encoders;

import java.io.IOException;
import java.io.Writer;

public abstract interface DataEncoder
{
  public abstract String encode(Object paramObject);
  
  public abstract void encode(Object paramObject, Writer paramWriter)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\encoders\DataEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */