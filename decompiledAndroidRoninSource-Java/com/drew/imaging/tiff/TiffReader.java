package com.drew.imaging.tiff;

import com.drew.lang.RandomAccessReader;
import com.drew.lang.Rational;
import java.io.IOException;
import java.util.Set;

public class TiffReader
{
  private static int calculateTagOffset(int paramInt1, int paramInt2)
  {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  public static void processIfd(TiffHandler paramTiffHandler, RandomAccessReader paramRandomAccessReader, Set<Integer> paramSet, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    for (;;)
    {
      int j;
      int i;
      long l1;
      int m;
      long l3;
      int n;
      try
      {
        bool = paramSet.contains(Integer.valueOf(paramInt1));
        if (bool)
        {
          paramTiffHandler.endingIFD();
          return;
        }
        localObject1 = localObject3;
        paramSet.add(Integer.valueOf(paramInt1));
        localObject1 = localObject3;
        if ((paramInt1 < paramRandomAccessReader.getLength()) && (paramInt1 >= 0))
        {
          localObject1 = localObject3;
          j = paramRandomAccessReader.getUInt16(paramInt1);
          localObject1 = localObject2;
          i = j;
          if (j > 255)
          {
            localObject1 = localObject2;
            i = j;
            if ((j & 0xFF) == 0)
            {
              localObject1 = localObject3;
              localObject2 = Boolean.valueOf(paramRandomAccessReader.isMotorolaByteOrder());
              i = j >> 8;
              localObject1 = localObject2;
              if (paramRandomAccessReader.isMotorolaByteOrder()) {
                break label944;
              }
              bool = true;
              localObject1 = localObject2;
              paramRandomAccessReader.setMotorolaByteOrder(bool);
              localObject1 = localObject2;
            }
          }
          int k = i;
          l1 = k * 12 + 2 + 4 + paramInt1;
          localObject2 = localObject1;
          try
          {
            long l2 = paramRandomAccessReader.getLength();
            if (l1 > l2)
            {
              localObject2 = localObject1;
              try
              {
                paramTiffHandler.error("Illegally sized IFD");
                return;
              }
              finally
              {
                localObject1 = localObject2;
                continue;
              }
            }
            m = 0;
            i = 0;
            int i1;
            int i2;
            if (m < k)
            {
              localObject2 = localObject1;
              j = calculateTagOffset(paramInt1, m);
              localObject2 = localObject1;
              i1 = paramRandomAccessReader.getUInt16(j);
              localObject2 = localObject1;
              i2 = paramRandomAccessReader.getUInt16(j + 2);
              localObject2 = localObject1;
              localObject3 = TiffDataFormat.fromTiffFormatCode(i2);
              localObject2 = localObject1;
              l3 = paramRandomAccessReader.getUInt32(j + 4);
              if (localObject3 == null)
              {
                localObject2 = localObject1;
                localObject3 = paramTiffHandler.tryCustomProcessFormat(i1, i2, l3);
                if (localObject3 == null)
                {
                  localObject2 = localObject1;
                  paramTiffHandler.error(String.format("Invalid TIFF tag format code %d for tag 0x%04X", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) }));
                  i += 1;
                  if (i > 5)
                  {
                    localObject2 = localObject1;
                    paramTiffHandler.error("Stopping processing as too many errors seen in TIFF IFD");
                    return;
                  }
                  j = i;
                  break label993;
                }
                localObject2 = localObject1;
                l1 = ((Long)localObject3).longValue();
              }
              else
              {
                localObject2 = localObject1;
                n = ((TiffDataFormat)localObject3).getComponentSizeBytes();
                l1 = n * l3;
              }
              if (l1 > 4L)
              {
                localObject2 = localObject1;
                l2 = paramRandomAccessReader.getUInt32(j + 8);
                localObject2 = localObject1;
                long l4 = paramRandomAccessReader.getLength();
                if (l2 + l1 > l4)
                {
                  localObject2 = localObject1;
                  paramTiffHandler.error("Illegal TIFF tag pointer offset");
                  continue;
                }
                l2 = paramInt2 + l2;
              }
              else
              {
                l2 = j + 8;
              }
              if (l2 < 0L) {}
            }
            try
            {
              if (l2 <= paramRandomAccessReader.getLength())
              {
                if (l1 >= 0L)
                {
                  if (l2 + l1 <= paramRandomAccessReader.getLength()) {
                    break label950;
                  }
                  continue;
                  if (n >= l3) {
                    break label980;
                  }
                  if (!paramTiffHandler.tryEnterSubIfd(i1)) {
                    break label971;
                  }
                  processIfd(paramTiffHandler, paramRandomAccessReader, paramSet, paramRandomAccessReader.getInt32((int)(n * 4 + l2)) + paramInt2, paramInt2);
                  j = 1;
                  break label971;
                  j = i;
                  if (n != 0) {
                    continue;
                  }
                  n = (int)l2;
                  j = i;
                  if (paramTiffHandler.customProcessTag(n, paramSet, paramInt2, paramRandomAccessReader, i1, (int)l1)) {
                    break label993;
                  }
                  processTag(paramTiffHandler, i1, n, (int)l3, i2, paramRandomAccessReader);
                  j = i;
                  break label993;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Illegal number of bytes for TIFF tag data: ");
                ((StringBuilder)localObject2).append(l1);
                paramTiffHandler.error(((StringBuilder)localObject2).toString());
                j = i;
                break label993;
              }
              paramTiffHandler.error("Illegal TIFF tag pointer offset");
              j = i;
            }
            finally
            {
              continue;
            }
            localObject2 = localObject1;
            i = paramRandomAccessReader.getInt32(calculateTagOffset(paramInt1, k));
            if (i != 0)
            {
              i += paramInt2;
              l1 = i;
              l2 = paramRandomAccessReader.getLength();
              if (l1 >= l2) {
                return;
              }
              if (i < paramInt1) {
                return;
              }
              if (paramTiffHandler.hasFollowerIfd()) {
                processIfd(paramTiffHandler, paramRandomAccessReader, paramSet, i, paramInt2);
              }
            }
            return;
          }
          finally
          {
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = localObject3;
          paramTiffHandler.error("Ignored IFD marked to start outside data segment");
          paramTiffHandler.endingIFD();
          return;
        }
      }
      finally
      {
        paramTiffHandler.endingIFD();
        if (localObject1 != null) {
          paramRandomAccessReader.setMotorolaByteOrder(((Boolean)localObject1).booleanValue());
        }
      }
      label944:
      boolean bool = false;
      continue;
      label950:
      if (l1 == 4L * l3)
      {
        n = 0;
        j = 0;
        continue;
        label971:
        n += 1;
        continue;
        label980:
        n = j;
      }
      else
      {
        n = 0;
        continue;
        label993:
        m += 1;
        i = j;
      }
    }
  }
  
  private static void processTag(TiffHandler paramTiffHandler, int paramInt1, int paramInt2, int paramInt3, int paramInt4, RandomAccessReader paramRandomAccessReader)
    throws IOException
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i = 0;
    Object localObject;
    switch (paramInt4)
    {
    default: 
      paramTiffHandler.error(String.format("Invalid TIFF tag format code %d for tag 0x%04X", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt1) }));
      return;
    case 12: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setDouble(paramInt1, paramRandomAccessReader.getDouble64(paramInt2));
        return;
      }
      localObject = new double[paramInt3];
      paramInt4 = i;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramRandomAccessReader.getDouble64(paramInt4 * 4 + paramInt2);
        paramInt4 += 1;
      }
      paramTiffHandler.setDoubleArray(paramInt1, (double[])localObject);
      return;
    case 11: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setFloat(paramInt1, paramRandomAccessReader.getFloat32(paramInt2));
        return;
      }
      localObject = new float[paramInt3];
      paramInt4 = j;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramRandomAccessReader.getFloat32(paramInt4 * 4 + paramInt2);
        paramInt4 += 1;
      }
      paramTiffHandler.setFloatArray(paramInt1, (float[])localObject);
      return;
    case 10: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setRational(paramInt1, new Rational(paramRandomAccessReader.getInt32(paramInt2), paramRandomAccessReader.getInt32(paramInt2 + 4)));
        return;
      }
      if (paramInt3 > 1)
      {
        localObject = new Rational[paramInt3];
        paramInt4 = k;
        while (paramInt4 < paramInt3)
        {
          i = paramInt4 * 8;
          localObject[paramInt4] = new Rational(paramRandomAccessReader.getInt32(paramInt2 + i), paramRandomAccessReader.getInt32(paramInt2 + 4 + i));
          paramInt4 += 1;
        }
        paramTiffHandler.setRationalArray(paramInt1, (Rational[])localObject);
        return;
      }
      break;
    case 9: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setInt32s(paramInt1, paramRandomAccessReader.getInt32(paramInt2));
        return;
      }
      localObject = new int[paramInt3];
      paramInt4 = m;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramRandomAccessReader.getInt32(paramInt4 * 4 + paramInt2);
        paramInt4 += 1;
      }
      paramTiffHandler.setInt32sArray(paramInt1, (int[])localObject);
      return;
    case 8: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setInt16s(paramInt1, paramRandomAccessReader.getInt16(paramInt2));
        return;
      }
      localObject = new short[paramInt3];
      paramInt4 = n;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramRandomAccessReader.getInt16(paramInt4 * 2 + paramInt2);
        paramInt4 += 1;
      }
      paramTiffHandler.setInt16sArray(paramInt1, (short[])localObject);
      return;
    case 7: 
      paramTiffHandler.setByteArray(paramInt1, paramRandomAccessReader.getBytes(paramInt2, paramInt3));
      return;
    case 6: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setInt8s(paramInt1, paramRandomAccessReader.getInt8(paramInt2));
        return;
      }
      localObject = new byte[paramInt3];
      paramInt4 = i1;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramRandomAccessReader.getInt8(paramInt2 + paramInt4);
        paramInt4 += 1;
      }
      paramTiffHandler.setInt8sArray(paramInt1, (byte[])localObject);
      return;
    case 5: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setRational(paramInt1, new Rational(paramRandomAccessReader.getUInt32(paramInt2), paramRandomAccessReader.getUInt32(paramInt2 + 4)));
        return;
      }
      if (paramInt3 > 1)
      {
        localObject = new Rational[paramInt3];
        paramInt4 = i2;
        while (paramInt4 < paramInt3)
        {
          i = paramInt4 * 8;
          localObject[paramInt4] = new Rational(paramRandomAccessReader.getUInt32(paramInt2 + i), paramRandomAccessReader.getUInt32(paramInt2 + 4 + i));
          paramInt4 += 1;
        }
        paramTiffHandler.setRationalArray(paramInt1, (Rational[])localObject);
        return;
      }
      break;
    case 4: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setInt32u(paramInt1, paramRandomAccessReader.getUInt32(paramInt2));
        return;
      }
      localObject = new long[paramInt3];
      paramInt4 = i3;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramRandomAccessReader.getUInt32(paramInt4 * 4 + paramInt2);
        paramInt4 += 1;
      }
      paramTiffHandler.setInt32uArray(paramInt1, (long[])localObject);
      return;
    case 3: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setInt16u(paramInt1, paramRandomAccessReader.getUInt16(paramInt2));
        return;
      }
      localObject = new int[paramInt3];
      paramInt4 = i4;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramRandomAccessReader.getUInt16(paramInt4 * 2 + paramInt2);
        paramInt4 += 1;
      }
      paramTiffHandler.setInt16uArray(paramInt1, (int[])localObject);
      return;
    case 2: 
      paramTiffHandler.setString(paramInt1, paramRandomAccessReader.getNullTerminatedStringValue(paramInt2, paramInt3, null));
      return;
    case 1: 
      if (paramInt3 == 1)
      {
        paramTiffHandler.setInt8u(paramInt1, paramRandomAccessReader.getUInt8(paramInt2));
        return;
      }
      localObject = new short[paramInt3];
      paramInt4 = i5;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramRandomAccessReader.getUInt8(paramInt2 + paramInt4);
        paramInt4 += 1;
      }
      paramTiffHandler.setInt8uArray(paramInt1, (short[])localObject);
    }
  }
  
  /* Error */
  public void processTiff(RandomAccessReader arg1, TiffHandler arg2, int arg3)
    throws TiffProcessingException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\tiff\TiffReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */