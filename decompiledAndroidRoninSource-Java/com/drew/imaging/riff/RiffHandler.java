package com.drew.imaging.riff;

public abstract interface RiffHandler
{
  public abstract void processChunk(String paramString, byte[] paramArrayOfByte);
  
  public abstract boolean shouldAcceptChunk(String paramString);
  
  public abstract boolean shouldAcceptRiffIdentifier(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\riff\RiffHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */