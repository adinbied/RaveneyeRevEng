package dji.midware.sdr.log;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import dji.log.RoninLog;
import dji.midware.MidWare;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DJISdrLogDataReciever
{
  private static boolean DEBUG = true;
  private static final int LOG_CACHE_SIZE = 819200;
  private static String TAG = "DJISdrLogDataReciever";
  private static SimpleDateFormat fileNameFormat;
  private static FileOutputStream fosLogFilePort1 = null;
  private static FileOutputStream fosLogFilePort2 = null;
  private static FileOutputStream fosLogFilePort3 = null;
  private static DJISdrLogDataReciever instance;
  private static final boolean isOpenSdrLog = false;
  private static boolean isRecieveLog = false;
  private static WeakReference<Context> mContext;
  private static final String sdCardRoot = Environment.getExternalStorageDirectory().getAbsolutePath();
  private static final String sdrFileEnd = "-Port";
  private static final String sdrFilePrex = "SdrLog-";
  private static final String sdrLogDirName;
  private static String sdr_port1_fileName;
  private static String sdr_port2_fileName;
  private static String sdr_port3_fileName;
  private int log1_cur_size = 0;
  private int log2_cur_size = 0;
  private int log3_cur_size = 0;
  private byte[] port1_log_cache = new byte[819200];
  private byte[] port2_log_cache = new byte[819200];
  private byte[] port3_log_cache = new byte[819200];
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/DJI/SDR_LOG/");
    sdrLogDirName = localStringBuilder.toString();
    fileNameFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
    isRecieveLog = false;
  }
  
  public static void checkStorage()
  {
    String str = System.getenv("EXTERNAL_STORAGE");
    File localFile = new File(str);
    Object localObject;
    StringBuilder localStringBuilder;
    if (DEBUG)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkStorage extStore= ");
      localStringBuilder.append(str);
      RoninLog.d((String)localObject, localStringBuilder.toString(), new Object[0]);
      str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkStorage f_exts= ");
      ((StringBuilder)localObject).append(localFile.exists());
      RoninLog.d(str, ((StringBuilder)localObject).toString(), new Object[0]);
    }
    str = System.getenv("SECONDARY_STORAGE");
    localFile = new File(str);
    if (DEBUG)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkStorage secStore= ");
      localStringBuilder.append(str);
      RoninLog.d((String)localObject, localStringBuilder.toString(), new Object[0]);
      str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkStorage f_secs= ");
      ((StringBuilder)localObject).append(localFile.exists());
      RoninLog.d(str, ((StringBuilder)localObject).toString(), new Object[0]);
    }
  }
  
  private static long getAvailableStore(String paramString)
  {
    paramString = new StatFs(paramString);
    long l = paramString.getBlockSize();
    l = paramString.getAvailableBlocks() * l / 1024L / 1024L;
    if (DEBUG)
    {
      paramString = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAvailableStore size= ");
      localStringBuilder.append(l);
      RoninLog.d(paramString, localStringBuilder.toString(), new Object[0]);
    }
    return l;
  }
  
  public static DJISdrLogDataReciever getInstance()
  {
    try
    {
      if (instance == null)
      {
        instance = new DJISdrLogDataReciever();
        if ((MidWare.context != null) && (MidWare.context.get() != null)) {
          mContext = new WeakReference(((Context)MidWare.context.get()).getApplicationContext());
        }
        initLogFile();
      }
      DJISdrLogDataReciever localDJISdrLogDataReciever = instance;
      return localDJISdrLogDataReciever;
    }
    finally {}
  }
  
  private static void initLogFile() {}
  
  public void createLogFiles() {}
  
  public boolean getIsRecieveFlag()
  {
    return isRecieveLog;
  }
  
  public void onAoaRecvLogPort1(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void onAoaRecvLogPort2(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void onAoaRecvLogPort3(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void onRecvLogPort1(byte[] paramArrayOfByte, int paramInt)
  {
    onAoaRecvLogPort1(paramArrayOfByte, 0, paramInt);
  }
  
  public void onRecvLogPort2(byte[] paramArrayOfByte, int paramInt)
  {
    onAoaRecvLogPort2(paramArrayOfByte, 0, paramInt);
  }
  
  public void onRecvLogPort3(byte[] paramArrayOfByte, int paramInt)
  {
    onAoaRecvLogPort3(paramArrayOfByte, 0, paramInt);
  }
  
  /* Error */
  public void scanLogFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sdr\log\DJISdrLogDataReciever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */