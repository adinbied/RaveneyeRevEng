package com.google.firebase.encoders;

import java.io.IOException;

public abstract interface ValueEncoderContext
{
  public abstract ValueEncoderContext add(double paramDouble)
    throws IOException;
  
  public abstract ValueEncoderContext add(int paramInt)
    throws IOException;
  
  public abstract ValueEncoderContext add(long paramLong)
    throws IOException;
  
  public abstract ValueEncoderContext add(String paramString)
    throws IOException;
  
  public abstract ValueEncoderContext add(boolean paramBoolean)
    throws IOException;
  
  public abstract ValueEncoderContext add(byte[] paramArrayOfByte)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\encoders\ValueEncoderContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */