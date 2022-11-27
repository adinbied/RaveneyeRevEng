package dji.midware.media.metadata;

import dji.midware.data.config.P3.ProductType;
import dji.midware.util.BytesUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;

public class OriginalVideoMetadataRetriever
{
  private static final int MDL = -1452448660;
  private static final int MOOV = 1836019574;
  private static final int UDATA = 1969517665;
  private static final int XYZ = -1451722335;
  private int atomSize = 0;
  private int atomType = 0;
  private byte[] buffer = new byte[4];
  private byte[] bufferValue = new byte['Ϩ'];
  private File file;
  private HashMap<String, String> hashMap = new HashMap();
  private int moovlength = 0;
  private long offset = 0L;
  RandomAccessFile randomAccessFile;
  private String typeName = "";
  
  private int get(byte[] paramArrayOfByte)
  {
    return 0;
  }
  
  private String getString(ByteBuffer paramByteBuffer)
  {
    return getStringUTF8(paramByteBuffer.array());
  }
  
  private String getString(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public static String getStringUTF8(byte[] paramArrayOfByte)
  {
    int i = 1;
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i] == 0)
      {
        arrayOfByte = BytesUtil.readBytes(paramArrayOfByte, 0, i);
        break;
      }
      i += 1;
    }
    return new String(arrayOfByte, Charset.forName("GBK"));
  }
  
  private void goNextStep()
    throws IOException
  {
    goNextStep(true);
  }
  
  /* Error */
  private void goNextStep(boolean arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void extract()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Date getCaptureDate()
  {
    return null;
  }
  
  public double[] getGPS()
  {
    return null;
  }
  
  public HashMap<String, String> getMap()
  {
    return this.hashMap;
  }
  
  public ProductType getProductType()
  {
    return null;
  }
  
  /* Error */
  public void setDataSource(String arg1)
    throws java.io.FileNotFoundException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\metadata\OriginalVideoMetadataRetriever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */