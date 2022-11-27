package com.facebook.binaryresource;

import java.io.IOException;
import java.io.InputStream;

public abstract interface BinaryResource
{
  public abstract InputStream openStream()
    throws IOException;
  
  public abstract byte[] read()
    throws IOException;
  
  public abstract long size();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\binaryresource\BinaryResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */