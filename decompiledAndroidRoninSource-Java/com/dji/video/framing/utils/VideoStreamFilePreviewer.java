package com.dji.video.framing.utils;

import com.dji.video.framing.internal.parser.VideoStreamParseController;
import java.io.File;
import java.io.IOException;

public class VideoStreamFilePreviewer
{
  private static final String TAG = "VideoStreamFilePreviewe";
  private boolean isRunning = false;
  
  public void runReadData(File paramFile, VideoStreamParseController paramVideoStreamParseController)
    throws IOException, InterruptedException
  {
    runReadData(paramFile, paramVideoStreamParseController, true);
  }
  
  /* Error */
  public void runReadData(File arg1, VideoStreamParseController arg2, boolean arg3)
    throws IOException, InterruptedException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stopReadData()
  {
    this.isRunning = false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\VideoStreamFilePreviewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */