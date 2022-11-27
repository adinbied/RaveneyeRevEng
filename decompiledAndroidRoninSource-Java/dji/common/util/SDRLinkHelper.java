package dji.common.util;

import dji.common.airlink.ChannelSelectionMode;
import dji.common.airlink.OcuSyncBandwidth;

public class SDRLinkHelper
{
  public static final float ORIGINAL_NF_START_INDEX = 2400.5F;
  public static final int RANGE_SIZE_10MHZ = 5;
  public static final int RANGE_SIZE_20MHZ = 10;
  
  public static float convertFrequencyFormFrequencyPointIndex(int paramInt)
  {
    if ((paramInt >= 1001) && (paramInt <= 1084)) {
      return paramInt - 1001 + 2400.5F;
    }
    return -1.0F;
  }
  
  public static int convertFrequencyPointIndexFromFrequency(float paramFloat)
  {
    if ((paramFloat >= 2400.5F) && (paramFloat <= 2483.5D))
    {
      float f2 = paramFloat - 2400.5F + 1001.0F;
      float f1 = f2;
      if (f2 < 0.0D) {
        f1 = 0.0F;
      }
      double d = f1;
      int i = (int)Math.floor(d);
      int j = (int)Math.ceil(d);
      if (i == j) {
        return (int)f1;
      }
      f1 = convertFrequencyFormFrequencyPointIndex(i);
      f2 = convertFrequencyFormFrequencyPointIndex(j);
      if (Math.abs(f1 - paramFloat) <= Math.abs(f2 - paramFloat)) {
        return i;
      }
      return j;
    }
    return 0;
  }
  
  public static float[] convertValidIndexRange(OcuSyncBandwidth paramOcuSyncBandwidth, ChannelSelectionMode paramChannelSelectionMode)
  {
    float[] arrayOfFloat = new float[2];
    float[] tmp5_4 = arrayOfFloat;
    tmp5_4[0] = 2400.5F;
    float[] tmp10_5 = tmp5_4;
    tmp10_5[1] = 2481.5F;
    tmp10_5;
    if ((paramOcuSyncBandwidth != null) && (paramChannelSelectionMode != null))
    {
      if ((paramOcuSyncBandwidth.equals(OcuSyncBandwidth.Bandwidth10MHz)) && (paramChannelSelectionMode.equals(ChannelSelectionMode.MANUAL)))
      {
        arrayOfFloat[0] = convertFrequencyFormFrequencyPointIndex(1007);
        arrayOfFloat[1] = convertFrequencyFormFrequencyPointIndex(1072);
        return arrayOfFloat;
      }
      if ((paramOcuSyncBandwidth.equals(OcuSyncBandwidth.Bandwidth20MHz)) && (paramChannelSelectionMode.equals(ChannelSelectionMode.MANUAL)))
      {
        arrayOfFloat[0] = convertFrequencyFormFrequencyPointIndex(1012);
        arrayOfFloat[1] = convertFrequencyFormFrequencyPointIndex(1067);
      }
    }
    return arrayOfFloat;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\SDRLinkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */