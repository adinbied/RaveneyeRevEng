package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class MinElf
{
  public static final int DT_NEEDED = 1;
  public static final int DT_NULL = 0;
  public static final int DT_STRTAB = 5;
  public static final int ELF_MAGIC = 1179403647;
  public static final int PN_XNUM = 65535;
  public static final int PT_DYNAMIC = 2;
  public static final int PT_LOAD = 1;
  
  public static String[] extract_DT_NEEDED(File paramFile)
    throws IOException
  {
    paramFile = new FileInputStream(paramFile);
    try
    {
      String[] arrayOfString = extract_DT_NEEDED(paramFile.getChannel());
      return arrayOfString;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static String[] extract_DT_NEEDED(FileChannel paramFileChannel)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (getu32(paramFileChannel, localByteBuffer, 0L) == 1179403647L)
    {
      int j = getu8(paramFileChannel, localByteBuffer, 4L);
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      if (getu8(paramFileChannel, localByteBuffer, 5L) == 2) {
        localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      }
      long l2;
      if (i != 0) {
        l2 = getu32(paramFileChannel, localByteBuffer, 28L);
      } else {
        l2 = get64(paramFileChannel, localByteBuffer, 32L);
      }
      if (i != 0) {
        l1 = getu16(paramFileChannel, localByteBuffer, 44L);
      } else {
        l1 = getu16(paramFileChannel, localByteBuffer, 56L);
      }
      if (i != 0) {
        l3 = 42L;
      } else {
        l3 = 54L;
      }
      int m = getu16(paramFileChannel, localByteBuffer, l3);
      long l3 = l1;
      if (l1 == 65535L)
      {
        if (i != 0) {
          l1 = getu32(paramFileChannel, localByteBuffer, 32L);
        } else {
          l1 = get64(paramFileChannel, localByteBuffer, 40L);
        }
        if (i != 0) {
          l1 = getu32(paramFileChannel, localByteBuffer, l1 + 28L);
        } else {
          l1 = getu32(paramFileChannel, localByteBuffer, l1 + 44L);
        }
        l3 = l1;
      }
      long l4 = l2;
      long l5;
      for (long l1 = 0L; l1 < l3; l1 += 1L)
      {
        if (i != 0) {
          l5 = getu32(paramFileChannel, localByteBuffer, l4 + 0L);
        } else {
          l5 = getu32(paramFileChannel, localByteBuffer, l4 + 0L);
        }
        if (l5 == 2L)
        {
          if (i != 0)
          {
            l1 = getu32(paramFileChannel, localByteBuffer, l4 + 4L);
            break label355;
          }
          l1 = get64(paramFileChannel, localByteBuffer, l4 + 8L);
          break label355;
        }
        l4 += m;
      }
      l1 = 0L;
      label355:
      if (l1 != 0L)
      {
        l5 = l1;
        l4 = 0L;
        for (int k = 0;; k = j)
        {
          long l6;
          if (i != 0) {
            l6 = getu32(paramFileChannel, localByteBuffer, l5 + 0L);
          } else {
            l6 = get64(paramFileChannel, localByteBuffer, l5 + 0L);
          }
          if (l6 == 1L)
          {
            if (k != Integer.MAX_VALUE) {
              j = k + 1;
            } else {
              throw new ElfError("malformed DT_NEEDED section");
            }
          }
          else
          {
            j = k;
            if (l6 == 5L)
            {
              if (i != 0) {
                l4 = getu32(paramFileChannel, localByteBuffer, l5 + 4L);
              } else {
                l4 = get64(paramFileChannel, localByteBuffer, l5 + 8L);
              }
              j = k;
            }
          }
          long l7;
          if (i != 0) {
            l7 = 8L;
          } else {
            l7 = 16L;
          }
          l5 += l7;
          if (l6 == 0L)
          {
            if (l4 != 0L)
            {
              k = 0;
              while (k < l3)
              {
                if (i != 0) {
                  l5 = getu32(paramFileChannel, localByteBuffer, l2 + 0L);
                } else {
                  l5 = getu32(paramFileChannel, localByteBuffer, l2 + 0L);
                }
                if (l5 == 1L)
                {
                  if (i != 0) {
                    l5 = getu32(paramFileChannel, localByteBuffer, l2 + 8L);
                  } else {
                    l5 = get64(paramFileChannel, localByteBuffer, l2 + 16L);
                  }
                  if (i != 0) {
                    l6 = getu32(paramFileChannel, localByteBuffer, l2 + 20L);
                  } else {
                    l6 = get64(paramFileChannel, localByteBuffer, l2 + 40L);
                  }
                  if ((l5 <= l4) && (l4 < l6 + l5))
                  {
                    if (i != 0) {
                      l2 = getu32(paramFileChannel, localByteBuffer, l2 + 4L);
                    } else {
                      l2 = get64(paramFileChannel, localByteBuffer, l2 + 8L);
                    }
                    l2 += l4 - l5;
                    break label721;
                  }
                }
                l2 += m;
                k += 1;
              }
              l2 = 0L;
              label721:
              if (l2 != 0L)
              {
                String[] arrayOfString = new String[j];
                k = 0;
                for (;;)
                {
                  l3 = l1 + 0L;
                  if (i != 0) {
                    l3 = getu32(paramFileChannel, localByteBuffer, l3);
                  } else {
                    l3 = get64(paramFileChannel, localByteBuffer, l3);
                  }
                  if (l3 == 1L)
                  {
                    if (i != 0) {
                      l4 = getu32(paramFileChannel, localByteBuffer, l1 + 4L);
                    } else {
                      l4 = get64(paramFileChannel, localByteBuffer, l1 + 8L);
                    }
                    arrayOfString[k] = getSz(paramFileChannel, localByteBuffer, l4 + l2);
                    if (k != Integer.MAX_VALUE) {
                      k += 1;
                    } else {
                      throw new ElfError("malformed DT_NEEDED section");
                    }
                  }
                  if (i != 0) {
                    l4 = 8L;
                  } else {
                    l4 = 16L;
                  }
                  l1 += l4;
                  if (l3 == 0L)
                  {
                    if (k == j) {
                      return arrayOfString;
                    }
                    throw new ElfError("malformed DT_NEEDED section");
                  }
                }
              }
              throw new ElfError("did not find file offset of DT_STRTAB table");
            }
            throw new ElfError("Dynamic section string-table not found");
          }
        }
      }
      throw new ElfError("ELF file does not contain dynamic linking information");
    }
    throw new ElfError("file is not ELF");
  }
  
  private static long get64(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 8, paramLong);
    return paramByteBuffer.getLong();
  }
  
  private static String getSz(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = getu8(paramFileChannel, paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong = 1L + paramLong;
    }
    return localStringBuilder.toString();
  }
  
  private static int getu16(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 2, paramLong);
    return paramByteBuffer.getShort() & 0xFFFF;
  }
  
  private static long getu32(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 4, paramLong);
    return paramByteBuffer.getInt() & 0xFFFFFFFF;
  }
  
  private static short getu8(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 1, paramLong);
    return (short)(paramByteBuffer.get() & 0xFF);
  }
  
  private static void read(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
    throws IOException
  {
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    while (paramByteBuffer.remaining() > 0)
    {
      paramInt = paramFileChannel.read(paramByteBuffer, paramLong);
      if (paramInt == -1) {
        break;
      }
      paramLong += paramInt;
    }
    if (paramByteBuffer.remaining() <= 0)
    {
      paramByteBuffer.position(0);
      return;
    }
    throw new ElfError("ELF file truncated");
  }
  
  private static class ElfError
    extends RuntimeException
  {
    ElfError(String paramString)
    {
      super();
    }
  }
  
  public static enum ISA
  {
    private final String value;
    
    static
    {
      ARM = new ISA("ARM", 2, "armeabi-v7a");
      X86_64 = new ISA("X86_64", 3, "x86_64");
      AARCH64 = new ISA("AARCH64", 4, "arm64-v8a");
      ISA localISA = new ISA("OTHERS", 5, "others");
      OTHERS = localISA;
      $VALUES = new ISA[] { NOT_SO, X86, ARM, X86_64, AARCH64, localISA };
    }
    
    private ISA(String paramString)
    {
      this.value = paramString;
    }
    
    public String toString()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\MinElf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */