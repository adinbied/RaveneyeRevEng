package dji.common.airlink;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AirLinkUtils
{
  private static final List<Integer> CHANNEL_2_4G_LIST;
  private static final Integer[] CHANNEL_2_4G_VALUES;
  private static final List<Integer> CHANNEL_5G_LIST;
  private static final Integer[] CHANNEL_5G_VALUES;
  private static final List<Integer> CHANNEL_DUAL_LIST;
  private static final Integer[] CHANNEL_DUAL_VALUES;
  private static final float ORIGINAL_NF_START_INDEX = 2400.5F;
  
  static
  {
    Integer localInteger1 = Integer.valueOf(11);
    Object localObject = new Integer[11];
    Integer localInteger2 = Integer.valueOf(1);
    localObject[0] = localInteger2;
    Integer localInteger3 = Integer.valueOf(2);
    localObject[1] = localInteger3;
    Integer localInteger4 = Integer.valueOf(3);
    localObject[2] = localInteger4;
    Integer localInteger5 = Integer.valueOf(4);
    localObject[3] = localInteger5;
    Integer localInteger6 = Integer.valueOf(5);
    localObject[4] = localInteger6;
    Integer localInteger7 = Integer.valueOf(6);
    localObject[5] = localInteger7;
    Integer localInteger8 = Integer.valueOf(7);
    localObject[6] = localInteger8;
    Integer localInteger9 = Integer.valueOf(8);
    localObject[7] = localInteger9;
    Integer localInteger10 = Integer.valueOf(9);
    localObject[8] = localInteger10;
    Integer localInteger11 = Integer.valueOf(10);
    localObject[9] = localInteger11;
    localObject[10] = localInteger1;
    CHANNEL_2_4G_VALUES = (Integer[])localObject;
    CHANNEL_2_4G_LIST = Arrays.asList((Object[])localObject);
    Integer[] arrayOfInteger = new Integer[5];
    localObject = Integer.valueOf(149);
    arrayOfInteger[0] = localObject;
    Integer localInteger12 = Integer.valueOf(153);
    arrayOfInteger[1] = localInteger12;
    Integer localInteger13 = Integer.valueOf(157);
    arrayOfInteger[2] = localInteger13;
    Integer localInteger14 = Integer.valueOf(161);
    arrayOfInteger[3] = localInteger14;
    arrayOfInteger[4] = Integer.valueOf(165);
    CHANNEL_5G_VALUES = arrayOfInteger;
    CHANNEL_5G_LIST = Arrays.asList(arrayOfInteger);
    arrayOfInteger = new Integer[16];
    arrayOfInteger[0] = localInteger2;
    arrayOfInteger[1] = localInteger3;
    arrayOfInteger[2] = localInteger4;
    arrayOfInteger[3] = localInteger5;
    arrayOfInteger[4] = localInteger6;
    arrayOfInteger[5] = localInteger7;
    arrayOfInteger[6] = localInteger8;
    arrayOfInteger[7] = localInteger9;
    arrayOfInteger[8] = localInteger10;
    arrayOfInteger[9] = localInteger11;
    arrayOfInteger[10] = localInteger1;
    arrayOfInteger[11] = localObject;
    arrayOfInteger[12] = localInteger12;
    arrayOfInteger[13] = localInteger13;
    arrayOfInteger[14] = localInteger14;
    arrayOfInteger[15] = Integer.valueOf(165);
    CHANNEL_DUAL_VALUES = arrayOfInteger;
    CHANNEL_DUAL_LIST = Arrays.asList(arrayOfInteger);
  }
  
  public static int convertOcuSyncSignalQuality(int paramInt)
  {
    float f1;
    if (paramInt <= 6)
    {
      f1 = 0.0F;
    }
    else
    {
      if (paramInt <= 16) {
        paramInt = (paramInt - 7) * 2 + 1;
      }
      for (;;)
      {
        f1 = paramInt;
        break label116;
        float f2;
        if (paramInt <= 30)
        {
          f2 = (paramInt - 17) * 1.4615384F;
          f1 = 21.0F;
        }
        for (;;)
        {
          f1 = f2 + f1;
          break label116;
          if (paramInt <= 55)
          {
            f2 = (paramInt - 31) * 0.7916667F;
            f1 = 41.0F;
          }
          else
          {
            if (paramInt > 70) {
              break;
            }
            f2 = (paramInt - 56) * 1.3571428F;
            f1 = 61.0F;
          }
        }
        if (paramInt > 90) {
          break;
        }
        paramInt += 10;
      }
      f1 = 100.0F;
    }
    label116:
    return (int)f1;
  }
  
  public static float convertSDRFrequencyFromFrequencyPointIndex(int paramInt)
  {
    if ((paramInt >= 1001) && (paramInt <= 1084)) {
      return paramInt - 1001 + 2400.5F;
    }
    return -1.0F;
  }
  
  public static List<Integer> getValidChannelsForFrequencyBand(WiFiFrequencyBand paramWiFiFrequencyBand)
  {
    int i = 1.$SwitchMap$dji$common$airlink$WiFiFrequencyBand[paramWiFiFrequencyBand.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return CHANNEL_DUAL_LIST;
      }
      return CHANNEL_5G_LIST;
    }
    return CHANNEL_2_4G_LIST;
  }
  
  public static WiFiFrequencyBand getValidFrequencyBandForChannel(int paramInt)
  {
    if (CHANNEL_2_4G_LIST.indexOf(Integer.valueOf(paramInt)) >= 0) {
      return WiFiFrequencyBand.FREQUENCY_BAND_2_DOT_4_GHZ;
    }
    if (CHANNEL_5G_LIST.indexOf(Integer.valueOf(paramInt)) >= 0) {
      return WiFiFrequencyBand.FREQUENCY_BAND_5_GHZ;
    }
    return WiFiFrequencyBand.UNKNOWN;
  }
  
  public static int transformRadioSignal(int paramInt)
  {
    if (paramInt != 0)
    {
      paramInt = 101 - (int)Math.sqrt(Math.pow(10.0D, (Math.abs(paramInt) - 53) / 10.0F));
      if (paramInt > 100) {
        return 100;
      }
      if (paramInt < 5) {
        return 5;
      }
      return paramInt;
    }
    return 0;
  }
  
  public static boolean verifySSID(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() > 30) {
        return true;
      }
      return Pattern.compile("[A-Za-z0-9-_]{1,32}").matcher(paramString).matches() ^ true;
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\AirLinkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */