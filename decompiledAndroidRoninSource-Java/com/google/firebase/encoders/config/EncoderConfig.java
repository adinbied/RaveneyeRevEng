package com.google.firebase.encoders.config;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;

public abstract interface EncoderConfig<T extends EncoderConfig<T>>
{
  public abstract <U> T registerEncoder(Class<U> paramClass, ObjectEncoder<? super U> paramObjectEncoder);
  
  public abstract <U> T registerEncoder(Class<U> paramClass, ValueEncoder<? super U> paramValueEncoder);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\encoders\config\EncoderConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */