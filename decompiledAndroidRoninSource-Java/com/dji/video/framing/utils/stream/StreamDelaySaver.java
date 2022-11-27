package com.dji.video.framing.utils.stream;

import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StreamDelaySaver
{
  public static boolean IS_SAVE_PACKET_DELAY;
  private static StreamDelaySaver instance;
  public BufferedWriter frameDelayFile = null;
  public BufferedWriter packetDelayFile = null;
  
  private StreamDelaySaver()
  {
    if (0 == 0) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(Environment.getExternalStorageDirectory().getPath());
        localStringBuilder1.append("/dji_streamdelay_frame.txt");
        this.frameDelayFile = new BufferedWriter(new FileWriter(localStringBuilder1.toString()));
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    if (this.packetDelayFile == null) {
      try
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(Environment.getExternalStorageDirectory().getPath());
        localStringBuilder2.append("/dji_streamdelay_packet.txt");
        this.packetDelayFile = new BufferedWriter(new FileWriter(localStringBuilder2.toString()));
        return;
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
      }
    }
  }
  
  public static StreamDelaySaver getInstance()
  {
    if (instance == null) {
      instance = new StreamDelaySaver();
    }
    return instance;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\stream\StreamDelaySaver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */