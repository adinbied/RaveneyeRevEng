package com.google.android.gms.common.util;

public final class HexDumpUtils
{
  public static String dump(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0) && (paramInt1 >= 0) && (paramInt2 > 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length))
    {
      int i = 57;
      if (paramBoolean) {
        i = 75;
      }
      StringBuilder localStringBuilder = new StringBuilder(i * ((paramInt2 + 16 - 1) / 16));
      int k = paramInt2;
      i = 0;
      int j;
      for (int m = 0; k > 0; m = j)
      {
        if (i == 0)
        {
          if (paramInt2 < 65536) {
            localStringBuilder.append(String.format("%04X:", new Object[] { Integer.valueOf(paramInt1) }));
          } else {
            localStringBuilder.append(String.format("%08X:", new Object[] { Integer.valueOf(paramInt1) }));
          }
          j = paramInt1;
        }
        else
        {
          j = m;
          if (i == 8)
          {
            localStringBuilder.append(" -");
            j = m;
          }
        }
        localStringBuilder.append(String.format(" %02X", new Object[] { Integer.valueOf(paramArrayOfByte[paramInt1] & 0xFF) }));
        k -= 1;
        m = i + 1;
        if ((paramBoolean) && ((m == 16) || (k == 0)))
        {
          int n = 16 - m;
          if (n > 0)
          {
            i = 0;
            while (i < n)
            {
              localStringBuilder.append("   ");
              i += 1;
            }
          }
          if (n >= 8) {
            localStringBuilder.append("  ");
          }
          localStringBuilder.append("  ");
          i = 0;
          while (i < m)
          {
            char c = (char)paramArrayOfByte[(j + i)];
            if ((c < ' ') || (c > '~')) {
              c = '.';
            }
            localStringBuilder.append(c);
            i += 1;
          }
        }
        if (m != 16)
        {
          i = m;
          if (k != 0) {}
        }
        else
        {
          localStringBuilder.append('\n');
          i = 0;
        }
        paramInt1 += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\HexDumpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */