package com.google.firebase.encoders;

import java.io.IOException;

public abstract interface ObjectEncoderContext
{
  public abstract ObjectEncoderContext add(String paramString, double paramDouble)
    throws IOException;
  
  public abstract ObjectEncoderContext add(String paramString, int paramInt)
    throws IOException;
  
  public abstract ObjectEncoderContext add(String paramString, long paramLong)
    throws IOException;
  
  public abstract ObjectEncoderContext add(String paramString, Object paramObject)
    throws IOException;
  
  public abstract ObjectEncoderContext add(String paramString, boolean paramBoolean)
    throws IOException;
  
  public abstract ObjectEncoderContext inline(Object paramObject)
    throws IOException;
  
  public abstract ObjectEncoderContext nested(String paramString)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\encoders\ObjectEncoderContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */