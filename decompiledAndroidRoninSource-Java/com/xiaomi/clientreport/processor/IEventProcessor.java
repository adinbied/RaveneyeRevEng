package com.xiaomi.clientreport.processor;

import com.xiaomi.clientreport.data.a;
import java.util.ArrayList;
import java.util.HashMap;

public abstract interface IEventProcessor
  extends c, d
{
  public abstract String bytesToString(byte[] paramArrayOfByte);
  
  public abstract void setEventMap(HashMap<String, ArrayList<a>> paramHashMap);
  
  public abstract byte[] stringToBytes(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\clientreport\processor\IEventProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */