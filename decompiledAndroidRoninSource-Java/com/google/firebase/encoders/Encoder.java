package com.google.firebase.encoders;

import java.io.IOException;

abstract interface Encoder<TValue, TContext>
{
  public abstract void encode(TValue paramTValue, TContext paramTContext)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\encoders\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */