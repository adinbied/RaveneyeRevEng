package com.dji.video.framing.internal.audio;

import android.media.AudioRecord;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class DJIAudioRecordWrapper
{
  private static final String AudioName = "/sdcard/rawpcm.raw";
  static final int BIT_RATE = 64000;
  private static final String NewAudioName = "/sdcard/new.wav";
  public static final int SAMPLE_RATE = 44100;
  private static final String TAG = "DJIAudioRecordWrapper";
  static final int VOLUME_REFRESH_INTERVAL = 200;
  private static DJIAudioRecordWrapper instance;
  private volatile boolean cancel = true;
  private ByteBuffer dataBuffer;
  private int dataSize;
  FileOutputStream fos = null;
  private int frequency;
  private List<DJIAudioRecordListenter> listenerList = new LinkedList();
  private Object lock = new Object();
  private AudioRecord recorder;
  private Thread thread;
  private volatile double volume;
  private Thread volumeThread;
  private int writeTestFileCount = 0;
  
  /* Error */
  private void WriteWaveFileHeader(FileOutputStream arg1, long arg2, long arg4, long arg6, int arg8, long arg9)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void copyWaveFile(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static DJIAudioRecordWrapper getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DJIAudioRecordWrapper();
      }
      DJIAudioRecordWrapper localDJIAudioRecordWrapper = instance;
      return localDJIAudioRecordWrapper;
    }
    finally {}
  }
  
  private boolean init(int paramInt)
  {
    return false;
  }
  
  /* Error */
  private void invokeOnAudioDataRead(ByteBuffer arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void invokeOnVolumeRefresh(double arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  private boolean start()
  {
    return false;
  }
  
  public byte[] ShortArray2ByteArray(short[] paramArrayOfShort, int paramInt)
  {
    return null;
  }
  
  public boolean addListener(DJIAudioRecordListenter paramDJIAudioRecordListenter)
  {
    return false;
  }
  
  /* Error */
  public void clearListeners()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean isRecorderInitiated()
  {
    return false;
  }
  
  public boolean isRecorderPermissionGet()
  {
    return false;
  }
  
  public boolean isRecorderRecording()
  {
    return false;
  }
  
  public boolean isRunning()
  {
    return this.cancel ^ true;
  }
  
  /* Error */
  public void recordThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void removeListener(DJIAudioRecordListenter arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract interface DJIAudioRecordListenter
  {
    public abstract void onAudioDataRead(ByteBuffer paramByteBuffer, int paramInt);
    
    public abstract void onVolumeRefresh(double paramDouble);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\audio\DJIAudioRecordWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */