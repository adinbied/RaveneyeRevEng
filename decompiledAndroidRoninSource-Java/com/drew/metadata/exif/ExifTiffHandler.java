package com.drew.metadata.exif;

import com.drew.lang.Charsets;
import com.drew.lang.RandomAccessReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import com.drew.metadata.exif.makernotes.CasioType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.KodakMakernoteDirectory;
import com.drew.metadata.exif.makernotes.KyoceraMakernoteDirectory;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PentaxMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxUltraFireMakernoteDirectory;
import com.drew.metadata.exif.makernotes.RicohMakernoteDirectory;
import com.drew.metadata.exif.makernotes.SanyoMakernoteDirectory;
import com.drew.metadata.exif.makernotes.SonyType1MakernoteDirectory;
import com.drew.metadata.tiff.DirectoryTiffHandler;
import java.io.IOException;
import java.util.Set;

public class ExifTiffHandler
  extends DirectoryTiffHandler
{
  public ExifTiffHandler(Metadata paramMetadata, Directory paramDirectory)
  {
    super(paramMetadata);
    if (paramDirectory != null) {
      this._currentDirectory.setParent(paramDirectory);
    }
  }
  
  private static Boolean HandlePrintIM(Directory paramDirectory, int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if (paramInt == 50341) {
      return localBoolean;
    }
    if ((paramInt == 3584) && (((paramDirectory instanceof CasioType2MakernoteDirectory)) || ((paramDirectory instanceof KyoceraMakernoteDirectory)) || ((paramDirectory instanceof NikonType2MakernoteDirectory)) || ((paramDirectory instanceof OlympusMakernoteDirectory)) || ((paramDirectory instanceof PanasonicMakernoteDirectory)) || ((paramDirectory instanceof PentaxMakernoteDirectory)) || ((paramDirectory instanceof RicohMakernoteDirectory)) || ((paramDirectory instanceof SanyoMakernoteDirectory)) || ((paramDirectory instanceof SonyType1MakernoteDirectory)))) {
      return localBoolean;
    }
    return Boolean.valueOf(false);
  }
  
  private static void ProcessBinary(Directory paramDirectory, int paramInt1, RandomAccessReader paramRandomAccessReader, int paramInt2, Boolean paramBoolean, int paramInt3)
    throws IOException
  {
    int j;
    for (int i = 0; i < paramInt2; i = j + 1)
    {
      j = i;
      if (paramDirectory.hasTagName(i)) {
        if ((i < paramInt2 - 1) && (paramDirectory.hasTagName(i + 1)))
        {
          if (paramBoolean.booleanValue())
          {
            paramDirectory.setObject(i, Short.valueOf(paramRandomAccessReader.getInt16(i * 2 + paramInt1)));
            j = i;
          }
          else
          {
            paramDirectory.setObject(i, Integer.valueOf(paramRandomAccessReader.getUInt16(i * 2 + paramInt1)));
            j = i;
          }
        }
        else
        {
          Object localObject;
          if (paramBoolean.booleanValue())
          {
            localObject = new short[paramInt3];
            j = 0;
            while (j < paramInt3)
            {
              localObject[j] = paramRandomAccessReader.getInt16((i + j) * 2 + paramInt1);
              j += 1;
            }
            paramDirectory.setObjectArray(i, localObject);
          }
          else
          {
            localObject = new int[paramInt3];
            j = 0;
            while (j < paramInt3)
            {
              localObject[j] = paramRandomAccessReader.getUInt16((i + j) * 2 + paramInt1);
              j += 1;
            }
            paramDirectory.setObjectArray(i, localObject);
          }
          j = i + (paramInt3 - 1);
        }
      }
    }
  }
  
  private static void ProcessPrintIM(PrintIMDirectory paramPrintIMDirectory, int paramInt1, RandomAccessReader paramRandomAccessReader, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0)
    {
      paramPrintIMDirectory.addError("Empty PrintIM data");
      return;
    }
    if (paramInt2 <= 15)
    {
      paramPrintIMDirectory.addError("Bad PrintIM data");
      return;
    }
    String str = paramRandomAccessReader.getString(paramInt1, 12, Charsets.UTF_8);
    if (!str.startsWith("PrintIM"))
    {
      paramPrintIMDirectory.addError("Invalid PrintIM header");
      return;
    }
    int j = paramInt1 + 14;
    int i = paramRandomAccessReader.getUInt16(j);
    Boolean localBoolean;
    if (paramInt2 < i * 6 + 16)
    {
      localBoolean = Boolean.valueOf(paramRandomAccessReader.isMotorolaByteOrder());
      paramRandomAccessReader.setMotorolaByteOrder(paramRandomAccessReader.isMotorolaByteOrder() ^ true);
      j = paramRandomAccessReader.getUInt16(j);
      i = j;
      if (paramInt2 < j * 6 + 16) {
        paramPrintIMDirectory.addError("Bad PrintIM size");
      }
    }
    else
    {
      localBoolean = null;
    }
    str = str.substring(8, 12);
    paramInt2 = 0;
    paramPrintIMDirectory.setObject(0, str);
    while (paramInt2 < i)
    {
      j = paramInt1 + 16 + paramInt2 * 6;
      paramPrintIMDirectory.setObject(paramRandomAccessReader.getUInt16(j), Long.valueOf(paramRandomAccessReader.getUInt32(j + 2)));
      paramInt2 += 1;
    }
    if (localBoolean != null) {
      paramRandomAccessReader.setMotorolaByteOrder(localBoolean.booleanValue());
    }
  }
  
  private static void processKodakMakernote(KodakMakernoteDirectory paramKodakMakernoteDirectory, int paramInt, RandomAccessReader paramRandomAccessReader)
  {
    paramInt += 8;
    try
    {
      paramKodakMakernoteDirectory.setStringValue(0, paramRandomAccessReader.getStringValue(paramInt, 8, Charsets.UTF_8));
      paramKodakMakernoteDirectory.setInt(9, paramRandomAccessReader.getUInt8(paramInt + 9));
      paramKodakMakernoteDirectory.setInt(10, paramRandomAccessReader.getUInt8(paramInt + 10));
      paramKodakMakernoteDirectory.setInt(12, paramRandomAccessReader.getUInt16(paramInt + 12));
      paramKodakMakernoteDirectory.setInt(14, paramRandomAccessReader.getUInt16(paramInt + 14));
      paramKodakMakernoteDirectory.setInt(16, paramRandomAccessReader.getUInt16(paramInt + 16));
      paramKodakMakernoteDirectory.setByteArray(18, paramRandomAccessReader.getBytes(paramInt + 18, 2));
      paramKodakMakernoteDirectory.setByteArray(20, paramRandomAccessReader.getBytes(paramInt + 20, 4));
      paramKodakMakernoteDirectory.setInt(24, paramRandomAccessReader.getUInt16(paramInt + 24));
      paramKodakMakernoteDirectory.setInt(27, paramRandomAccessReader.getUInt8(paramInt + 27));
      paramKodakMakernoteDirectory.setInt(28, paramRandomAccessReader.getUInt8(paramInt + 28));
      paramKodakMakernoteDirectory.setInt(29, paramRandomAccessReader.getUInt8(paramInt + 29));
      paramKodakMakernoteDirectory.setInt(30, paramRandomAccessReader.getUInt16(paramInt + 30));
      paramKodakMakernoteDirectory.setLong(32, paramRandomAccessReader.getUInt32(paramInt + 32));
      paramKodakMakernoteDirectory.setInt(36, paramRandomAccessReader.getInt16(paramInt + 36));
      paramKodakMakernoteDirectory.setInt(56, paramRandomAccessReader.getUInt8(paramInt + 56));
      paramKodakMakernoteDirectory.setInt(64, paramRandomAccessReader.getUInt8(paramInt + 64));
      paramKodakMakernoteDirectory.setInt(92, paramRandomAccessReader.getUInt8(paramInt + 92));
      paramKodakMakernoteDirectory.setInt(93, paramRandomAccessReader.getUInt8(paramInt + 93));
      paramKodakMakernoteDirectory.setInt(94, paramRandomAccessReader.getUInt16(paramInt + 94));
      paramKodakMakernoteDirectory.setInt(96, paramRandomAccessReader.getUInt16(paramInt + 96));
      paramKodakMakernoteDirectory.setInt(98, paramRandomAccessReader.getUInt16(paramInt + 98));
      paramKodakMakernoteDirectory.setInt(100, paramRandomAccessReader.getUInt16(paramInt + 100));
      paramKodakMakernoteDirectory.setInt(102, paramRandomAccessReader.getUInt16(paramInt + 102));
      paramKodakMakernoteDirectory.setInt(104, paramRandomAccessReader.getUInt16(paramInt + 104));
      paramKodakMakernoteDirectory.setInt(107, paramRandomAccessReader.getInt8(paramInt + 107));
      return;
    }
    catch (IOException paramRandomAccessReader)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error processing Kodak makernote data: ");
      localStringBuilder.append(paramRandomAccessReader.getMessage());
      paramKodakMakernoteDirectory.addError(localStringBuilder.toString());
    }
  }
  
  private boolean processMakernote(int paramInt1, Set<Integer> paramSet, int paramInt2, RandomAccessReader paramRandomAccessReader)
    throws IOException
  {
    return false;
  }
  
  private static void processReconyxHyperFireMakernote(ReconyxHyperFireMakernoteDirectory paramReconyxHyperFireMakernoteDirectory, int paramInt, RandomAccessReader paramRandomAccessReader)
    throws IOException
  {
    paramReconyxHyperFireMakernoteDirectory.setObject(0, Integer.valueOf(paramRandomAccessReader.getUInt16(paramInt)));
    int i = paramInt + 2;
    int j = paramRandomAccessReader.getUInt16(i);
    int k = paramRandomAccessReader.getUInt16(i + 2);
    int m = paramRandomAccessReader.getUInt16(i + 4);
    Object localObject = String.format("%04X", new Object[] { Integer.valueOf(paramRandomAccessReader.getUInt16(i + 6)) });
    String str = String.format("%04X", new Object[] { Integer.valueOf(paramRandomAccessReader.getUInt16(i + 8)) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    try
    {
      localObject = Integer.valueOf(Integer.parseInt(str));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i1;
      int n;
      for (;;) {}
    }
    localObject = null;
    if (localObject != null)
    {
      paramReconyxHyperFireMakernoteDirectory.setString(2, String.format("%d.%d.%d.%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), localObject }));
    }
    else
    {
      paramReconyxHyperFireMakernoteDirectory.setString(2, String.format("%d.%d.%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error processing Reconyx HyperFire makernote data: build '");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("' is not in the expected format and will be omitted from Firmware Version.");
      paramReconyxHyperFireMakernoteDirectory.addError(((StringBuilder)localObject).toString());
    }
    paramReconyxHyperFireMakernoteDirectory.setString(12, String.valueOf((char)paramRandomAccessReader.getUInt16(paramInt + 12)));
    i = paramInt + 14;
    paramReconyxHyperFireMakernoteDirectory.setIntArray(14, new int[] { paramRandomAccessReader.getUInt16(i), paramRandomAccessReader.getUInt16(i + 2) });
    i = paramInt + 18;
    paramReconyxHyperFireMakernoteDirectory.setInt(18, (paramRandomAccessReader.getUInt16(i) << 16) + paramRandomAccessReader.getUInt16(i + 2));
    i1 = paramInt + 22;
    i = paramRandomAccessReader.getUInt16(i1);
    j = paramRandomAccessReader.getUInt16(i1 + 2);
    k = paramRandomAccessReader.getUInt16(i1 + 4);
    m = paramRandomAccessReader.getUInt16(i1 + 6);
    n = paramRandomAccessReader.getUInt16(i1 + 8);
    i1 = paramRandomAccessReader.getUInt16(i1 + 10);
    if ((i >= 0) && (i < 60) && (j >= 0) && (j < 60) && (k >= 0) && (k < 24) && (m >= 1) && (m < 13) && (n >= 1) && (n < 32) && (i1 >= 1) && (i1 <= 9999))
    {
      paramReconyxHyperFireMakernoteDirectory.setString(22, String.format("%4d:%2d:%2d %2d:%2d:%2d", new Object[] { Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error processing Reconyx HyperFire makernote data: Date/Time Original ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" is not a valid date/time.");
      paramReconyxHyperFireMakernoteDirectory.addError(((StringBuilder)localObject).toString());
    }
    paramReconyxHyperFireMakernoteDirectory.setInt(36, paramRandomAccessReader.getUInt16(paramInt + 36));
    paramReconyxHyperFireMakernoteDirectory.setInt(38, paramRandomAccessReader.getInt16(paramInt + 38));
    paramReconyxHyperFireMakernoteDirectory.setInt(40, paramRandomAccessReader.getInt16(paramInt + 40));
    paramReconyxHyperFireMakernoteDirectory.setStringValue(42, new StringValue(paramRandomAccessReader.getBytes(paramInt + 42, 28), Charsets.UTF_16LE));
    paramReconyxHyperFireMakernoteDirectory.setInt(72, paramRandomAccessReader.getUInt16(paramInt + 72));
    paramReconyxHyperFireMakernoteDirectory.setInt(74, paramRandomAccessReader.getUInt16(paramInt + 74));
    paramReconyxHyperFireMakernoteDirectory.setInt(76, paramRandomAccessReader.getUInt16(paramInt + 76));
    paramReconyxHyperFireMakernoteDirectory.setInt(78, paramRandomAccessReader.getUInt16(paramInt + 78));
    paramReconyxHyperFireMakernoteDirectory.setInt(80, paramRandomAccessReader.getUInt16(paramInt + 80));
    paramReconyxHyperFireMakernoteDirectory.setInt(82, paramRandomAccessReader.getUInt16(paramInt + 82));
    paramReconyxHyperFireMakernoteDirectory.setDouble(84, paramRandomAccessReader.getUInt16(paramInt + 84) / 1000.0D);
    paramReconyxHyperFireMakernoteDirectory.setString(86, paramRandomAccessReader.getNullTerminatedString(paramInt + 86, 44, Charsets.UTF_8));
  }
  
  private static void processReconyxUltraFireMakernote(ReconyxUltraFireMakernoteDirectory paramReconyxUltraFireMakernoteDirectory, int paramInt, RandomAccessReader paramRandomAccessReader)
    throws IOException
  {
    paramReconyxUltraFireMakernoteDirectory.setString(0, paramRandomAccessReader.getString(paramInt, 9, Charsets.UTF_8));
    paramReconyxUltraFireMakernoteDirectory.setString(52, paramRandomAccessReader.getString(paramInt + 52, 1, Charsets.UTF_8));
    int i = paramInt + 53;
    paramReconyxUltraFireMakernoteDirectory.setIntArray(53, new int[] { paramRandomAccessReader.getByte(i), paramRandomAccessReader.getByte(i + 1) });
    i = paramInt + 59;
    paramRandomAccessReader.getByte(i);
    paramRandomAccessReader.getByte(i + 1);
    paramRandomAccessReader.getByte(i + 2);
    paramRandomAccessReader.getByte(i + 3);
    paramRandomAccessReader.getByte(i + 4);
    paramReconyxUltraFireMakernoteDirectory.setInt(67, paramRandomAccessReader.getByte(paramInt + 67));
    paramReconyxUltraFireMakernoteDirectory.setInt(72, paramRandomAccessReader.getByte(paramInt + 72));
    paramReconyxUltraFireMakernoteDirectory.setStringValue(75, new StringValue(paramRandomAccessReader.getBytes(paramInt + 75, 14), Charsets.UTF_8));
    paramReconyxUltraFireMakernoteDirectory.setString(80, paramRandomAccessReader.getNullTerminatedString(paramInt + 80, 20, Charsets.UTF_8));
  }
  
  public boolean customProcessTag(int paramInt1, Set<Integer> paramSet, int paramInt2, RandomAccessReader paramRandomAccessReader, int paramInt3, int paramInt4)
    throws IOException
  {
    return false;
  }
  
  public boolean hasFollowerIfd()
  {
    return false;
  }
  
  /* Error */
  public void setTiffMarker(int arg1)
    throws com.drew.imaging.tiff.TiffProcessingException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public Long tryCustomProcessFormat(int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt2 == 13) {
      return Long.valueOf(paramLong * 4L);
    }
    if (paramInt2 == 0) {
      return Long.valueOf(0L);
    }
    return null;
  }
  
  public boolean tryEnterSubIfd(int paramInt)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\ExifTiffHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */