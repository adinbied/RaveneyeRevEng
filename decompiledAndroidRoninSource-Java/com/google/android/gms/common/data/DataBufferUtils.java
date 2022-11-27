package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils
{
  public static final String KEY_NEXT_PAGE_TOKEN = "next_page_token";
  public static final String KEY_PREV_PAGE_TOKEN = "prev_page_token";
  
  public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> paramDataBuffer)
  {
    ArrayList localArrayList = new ArrayList(paramDataBuffer.getCount());
    try
    {
      Iterator localIterator = paramDataBuffer.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Freezable)localIterator.next()).freeze());
      }
      return localArrayList;
    }
    finally
    {
      paramDataBuffer.close();
    }
  }
  
  public static boolean hasData(DataBuffer<?> paramDataBuffer)
  {
    return (paramDataBuffer != null) && (paramDataBuffer.getCount() > 0);
  }
  
  public static boolean hasNextPage(DataBuffer<?> paramDataBuffer)
  {
    paramDataBuffer = paramDataBuffer.getMetadata();
    return (paramDataBuffer != null) && (paramDataBuffer.getString("next_page_token") != null);
  }
  
  public static boolean hasPrevPage(DataBuffer<?> paramDataBuffer)
  {
    paramDataBuffer = paramDataBuffer.getMetadata();
    return (paramDataBuffer != null) && (paramDataBuffer.getString("prev_page_token") != null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\data\DataBufferUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */