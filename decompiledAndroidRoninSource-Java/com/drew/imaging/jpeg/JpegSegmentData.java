package com.drew.imaging.jpeg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JpegSegmentData
{
  private final HashMap<Byte, List<byte[]>> _segmentDataMap = new HashMap(10);
  
  private List<byte[]> getOrCreateSegmentList(byte paramByte)
  {
    return null;
  }
  
  private List<byte[]> getSegmentList(byte paramByte)
  {
    return null;
  }
  
  public void addSegment(byte paramByte, byte[] paramArrayOfByte)
  {
    getOrCreateSegmentList(paramByte).add(paramArrayOfByte);
  }
  
  public boolean containsSegment(byte paramByte)
  {
    return false;
  }
  
  public boolean containsSegment(JpegSegmentType paramJpegSegmentType)
  {
    return containsSegment(paramJpegSegmentType.byteValue);
  }
  
  public byte[] getSegment(byte paramByte)
  {
    return getSegment(paramByte, 0);
  }
  
  public byte[] getSegment(byte paramByte, int paramInt)
  {
    return null;
  }
  
  public byte[] getSegment(JpegSegmentType paramJpegSegmentType)
  {
    return getSegment(paramJpegSegmentType.byteValue, 0);
  }
  
  public byte[] getSegment(JpegSegmentType paramJpegSegmentType, int paramInt)
  {
    return getSegment(paramJpegSegmentType.byteValue, paramInt);
  }
  
  public int getSegmentCount(byte paramByte)
  {
    List localList = getSegmentList(paramByte);
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getSegmentCount(JpegSegmentType paramJpegSegmentType)
  {
    return getSegmentCount(paramJpegSegmentType.byteValue);
  }
  
  public Iterable<JpegSegmentType> getSegmentTypes()
  {
    return null;
  }
  
  public Iterable<byte[]> getSegments(byte paramByte)
  {
    List localList = getSegmentList(paramByte);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    return (Iterable<byte[]>)localObject;
  }
  
  public Iterable<byte[]> getSegments(JpegSegmentType paramJpegSegmentType)
  {
    return getSegments(paramJpegSegmentType.byteValue);
  }
  
  /* Error */
  public void removeSegment(byte arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void removeSegment(JpegSegmentType paramJpegSegmentType)
  {
    removeSegment(paramJpegSegmentType.byteValue);
  }
  
  /* Error */
  public void removeSegmentOccurrence(byte arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void removeSegmentOccurrence(JpegSegmentType paramJpegSegmentType, int paramInt)
  {
    removeSegmentOccurrence(paramJpegSegmentType.byteValue, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\jpeg\JpegSegmentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */