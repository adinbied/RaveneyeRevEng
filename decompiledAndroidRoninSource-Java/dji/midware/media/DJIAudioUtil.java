package dji.midware.media;

import java.nio.ByteBuffer;

public class DJIAudioUtil
{
  public static final int AAC_FRAME_MAX_SIZE = 20480;
  public static final int AAC_PACKET_MAX_SIZE = 102400;
  private static final int[] samplingFreq = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000 };
  
  public static ByteBuffer makeAudioCsd0(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = samplingFreq;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt2 == arrayOfInt[i]) {
        break label34;
      }
      i += 1;
    }
    i = -1;
    label34:
    return ByteBuffer.wrap(new byte[] { (byte)(paramInt1 + 1 << 3 | i >> 1), (byte)(i << 7 & 0x80 | (paramInt3 & 0xF) << 3) });
  }
  
  public static enum AVSampleFormat
  {
    static
    {
      AV_SAMPLE_FMT_S16 = new AVSampleFormat("AV_SAMPLE_FMT_S16", 1);
      AV_SAMPLE_FMT_S32 = new AVSampleFormat("AV_SAMPLE_FMT_S32", 2);
      AV_SAMPLE_FMT_FLT = new AVSampleFormat("AV_SAMPLE_FMT_FLT", 3);
      AV_SAMPLE_FMT_DBL = new AVSampleFormat("AV_SAMPLE_FMT_DBL", 4);
      AV_SAMPLE_FMT_U8P = new AVSampleFormat("AV_SAMPLE_FMT_U8P", 5);
      AV_SAMPLE_FMT_S16P = new AVSampleFormat("AV_SAMPLE_FMT_S16P", 6);
      AV_SAMPLE_FMT_S32P = new AVSampleFormat("AV_SAMPLE_FMT_S32P", 7);
      AV_SAMPLE_FMT_FLTP = new AVSampleFormat("AV_SAMPLE_FMT_FLTP", 8);
      AV_SAMPLE_FMT_DBLP = new AVSampleFormat("AV_SAMPLE_FMT_DBLP", 9);
      AVSampleFormat localAVSampleFormat = new AVSampleFormat("AV_SAMPLE_FMT_NB", 10);
      AV_SAMPLE_FMT_NB = localAVSampleFormat;
      $VALUES = new AVSampleFormat[] { AV_SAMPLE_FMT_U8, AV_SAMPLE_FMT_S16, AV_SAMPLE_FMT_S32, AV_SAMPLE_FMT_FLT, AV_SAMPLE_FMT_DBL, AV_SAMPLE_FMT_U8P, AV_SAMPLE_FMT_S16P, AV_SAMPLE_FMT_S32P, AV_SAMPLE_FMT_FLTP, AV_SAMPLE_FMT_DBLP, localAVSampleFormat };
    }
    
    private AVSampleFormat() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\DJIAudioUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */