package dji.midware.media.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DJIAudioStreamPlayer
  implements AudioManager.OnAudioFocusChangeListener
{
  private static final int Buffer_Size = 16384;
  private static final boolean DEBUG = false;
  private static final int Max_AAC_Frame_Size = 4096;
  private static final int ReadOutputTryMaxTimes = 3;
  private static final int ReadOutputWaitDurationUsEachTime = 5;
  private static final String TAG = "DJIAudioStreamPlayer";
  private static final int[] samplingFreq = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000 };
  private static final boolean saveFileToggle = false;
  private AudioTrack at = null;
  AudioManager audioManager = null;
  private File dataFile = new File("/sdcard/mydjiaudio.aac");
  private MediaCodec decoder = null;
  private boolean initialized = false;
  private boolean isPlay = true;
  private MediaCodec.BufferInfo outputBufferInfo = new MediaCodec.BufferInfo();
  private short[] outputShortArray = new short['က'];
  private FileOutputStream outputStream = null;
  private PacketFormat packetFormat;
  
  public DJIAudioStreamPlayer(PacketFormat paramPacketFormat)
  {
    this.packetFormat = paramPacketFormat;
  }
  
  public DJIAudioStreamPlayer(PacketFormat paramPacketFormat, Context paramContext)
  {
    this.packetFormat = paramPacketFormat;
    this.audioManager = ((AudioManager)paramContext.getSystemService("audio"));
    requestFocus();
    try
    {
      this.outputStream = new FileOutputStream(this.dataFile);
      return;
    }
    catch (FileNotFoundException paramPacketFormat)
    {
      paramPacketFormat.printStackTrace();
    }
  }
  
  public boolean abandonFocus()
  {
    return false;
  }
  
  public void init() {}
  
  /* Error */
  public void init(int arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void init(android.media.MediaFormat arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onAudioFocusChange(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onFrameReceive(java.nio.ByteBuffer arg1, int arg2, int arg3, long arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean requestFocus()
  {
    return false;
  }
  
  public void setPlaying(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.isPlay = true;
      return;
    }
    this.isPlay = false;
  }
  
  public void setVolume(double paramDouble1, double paramDouble2) {}
  
  public static enum PacketFormat
  {
    static
    {
      AAC = new PacketFormat("AAC", 1);
      PacketFormat localPacketFormat = new PacketFormat("PCM", 2);
      PCM = localPacketFormat;
      $VALUES = new PacketFormat[] { ADTS, AAC, localPacketFormat };
    }
    
    private PacketFormat() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\player\DJIAudioStreamPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */