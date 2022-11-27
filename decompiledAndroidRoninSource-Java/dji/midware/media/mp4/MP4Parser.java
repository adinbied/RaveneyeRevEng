package dji.midware.media.mp4;

import android.content.Context;
import dji.log.RoninLog;
import java.io.File;
import java.io.RandomAccessFile;

public class MP4Parser
{
  private static final int LENGTH_BOX_SIZE = 4;
  private static final int LENGTH_BOX_TYPE = 4;
  private static final int LENGTH_PRE_READ = 100;
  private static final String TAG = MP4Parser.class.getName();
  private static MP4Parser instance;
  private boolean debug = false;
  private RandomAccessFile debugAccessFile;
  private String filePath;
  private boolean findMoov = false;
  private File h264file;
  private RandomAccessFile mAccessFile;
  private byte[] moov;
  private int offset_moov = -1;
  public MP4Info videoInfo;
  
  public static MP4Parser getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new MP4Parser();
      }
      MP4Parser localMP4Parser = instance;
      return localMP4Parser;
    }
    finally {}
  }
  
  public static byte[] getSPSPPSData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + 8];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    arrayOfByte[2] = 0;
    arrayOfByte[3] = 1;
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, paramArrayOfByte1.length);
    int i = 4 + paramArrayOfByte1.length;
    arrayOfByte[i] = 0;
    i += 1;
    arrayOfByte[i] = 0;
    i += 1;
    arrayOfByte[i] = 0;
    i += 1;
    arrayOfByte[i] = 1;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i + 1, paramArrayOfByte2.length);
    i = paramArrayOfByte2.length;
    return arrayOfByte;
  }
  
  private boolean parseMoovData()
  {
    return false;
  }
  
  public static void replaceSliceHeader(byte[] paramArrayOfByte)
  {
    int j;
    for (int i = 0; (i < paramArrayOfByte.length) && (i >= 0); i = i + 1 + j)
    {
      Object localObject;
      if (i > paramArrayOfByte.length - 4)
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("transform 264 error: index=");
        localStringBuilder.append(i);
        localStringBuilder.append(" frame.length=");
        localStringBuilder.append(paramArrayOfByte.length);
        RoninLog.e((String)localObject, localStringBuilder.toString(), new Object[0]);
        return;
      }
      j = MP4BytesUtil.getInt(paramArrayOfByte, i);
      if (j < 0)
      {
        paramArrayOfByte = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("transform 264 error: index=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" slice_length=");
        ((StringBuilder)localObject).append(j);
        RoninLog.e(paramArrayOfByte, ((StringBuilder)localObject).toString(), new Object[0]);
        return;
      }
      paramArrayOfByte[i] = 0;
      i += 1;
      paramArrayOfByte[i] = 0;
      i += 1;
      paramArrayOfByte[i] = 0;
      i += 1;
      paramArrayOfByte[i] = 1;
    }
  }
  
  public int findMoovOffset(byte[] paramArrayOfByte)
  {
    return 0;
  }
  
  public void loadFile(String paramString)
  {
    this.filePath = paramString;
  }
  
  public byte[] loadVideoFrame(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  /* Error */
  public void locateMoovData()
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void parseMoov(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void parseMp4File()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void prepareLoading()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public byte[] putIFrame(Context paramContext)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\mp4\MP4Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */