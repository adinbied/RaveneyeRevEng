package dji.midware.media.colors;

import dji.midware.media.MediaLogger;
import dji.midware.natives.FPVController;

public class ColorFormatConvFactory
{
  public static byte[] YV12toYUV420PackedSemiPlanar(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 * paramInt2;
    int i = paramInt2 / 4;
    paramInt1 = 0;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramInt2);
    while (paramInt1 < i)
    {
      int j = paramInt1 * 2 + paramInt2;
      int k = paramInt2 + paramInt1;
      paramArrayOfByte2[j] = paramArrayOfByte1[(k + i)];
      paramArrayOfByte2[(j + 1)] = paramArrayOfByte1[k];
      paramInt1 += 1;
    }
    return paramArrayOfByte2;
  }
  
  public static byte[] YV12toYUV420Planar(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    paramInt1 *= paramInt2;
    paramInt2 = paramInt1 / 4;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramInt1);
    int i = paramInt1 + paramInt2;
    System.arraycopy(paramArrayOfByte1, paramInt1, paramArrayOfByte2, i, paramInt2);
    System.arraycopy(paramArrayOfByte1, i, paramArrayOfByte2, paramInt1, paramInt2);
    return paramArrayOfByte2;
  }
  
  public static int convertFromYUVXToAnyYUV(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2, int paramInt3)
  {
    return FPVController.native_transcodeYUVConvert(paramObject1, paramObject2, paramInt1, paramInt2, paramInt3);
  }
  
  public static ColorFormatConv createColorFormatConv(int paramInt1, int paramInt2)
  {
    ColorFormatConv local1;
    if ((paramInt1 == 21) && (paramInt2 == 19)) {
      local1 = new ColorFormatConv()
      {
        /* Error */
        public void convert(byte[] arg1, byte[] arg2, int arg3, int arg4)
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      };
    } else {
      local1 = null;
    }
    if (local1 == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("color convertor missing:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      MediaLogger.show(new Exception(localStringBuilder.toString()));
    }
    return local1;
  }
  
  public static void swapYV12toI420(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    int i = 0;
    int k;
    for (;;)
    {
      k = paramInt1 * paramInt2;
      if (i >= k) {
        break;
      }
      paramArrayOfByte2[i] = paramArrayOfByte1[i];
      i += 1;
    }
    i = k;
    int n;
    int j;
    for (;;)
    {
      n = paramInt1 / 2 * paramInt2 / 2;
      int m = k + n;
      j = m;
      if (i >= m) {
        break;
      }
      paramArrayOfByte2[i] = paramArrayOfByte1[(n + i)];
      i += 1;
    }
    while (j < n * 2 + k)
    {
      paramArrayOfByte2[j] = paramArrayOfByte1[(j - n)];
      j += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\colors\ColorFormatConvFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */