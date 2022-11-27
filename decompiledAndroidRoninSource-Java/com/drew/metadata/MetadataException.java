package com.drew.metadata;

import com.drew.lang.CompoundException;

public class MetadataException
  extends CompoundException
{
  private static final long serialVersionUID = 8612756143363919682L;
  
  public MetadataException(String paramString)
  {
    super(paramString);
  }
  
  public MetadataException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MetadataException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\MetadataException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */