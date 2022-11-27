package dji.midware.parser.plugins;

public class DJIPlaybackChanneParser
{
  private String TAG = getClass().getSimpleName();
  private int bodyLen = 0;
  private final byte[] header = { 68, 74, 65, 86 };
  private final boolean isDebug = false;
  private int packType = 0;
  private int packVer = 0;
  byte[] plenBuffer = new byte[4];
  private byte[] ptsBuffer = new byte[8];
  private DJIPluginRingBufferParser ringBufferParser;
  
  public DJIPlaybackChanneParser()
  {
    Object localObject = new DJIRingBufferModel();
    ((DJIRingBufferModel)localObject).header = this.header;
    ((DJIRingBufferModel)localObject).secondHeaderLen = 16;
    localObject = new DJIPluginRingBufferParser(1048576, (DJIRingBufferModel)localObject, new DJIPluginRingBufferParser.DJIRingBufferParserListener()
    {
      /* Error */
      public void onGetBody(byte[] arg1, int arg2, int arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public int parseSecondHeader(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
    });
    this.ringBufferParser = ((DJIPluginRingBufferParser)localObject);
    ((DJIPluginRingBufferParser)localObject).setName("Playback");
  }
  
  public void parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.ringBufferParser.parse(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static enum DJIPlaybackType
  {
    private int mValue = 0;
    
    static
    {
      DJIPlaybackType localDJIPlaybackType = new DJIPlaybackType("Audio", 1, 2);
      Audio = localDJIPlaybackType;
      $VALUES = new DJIPlaybackType[] { Video, localDJIPlaybackType };
    }
    
    private DJIPlaybackType(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public int value()
    {
      return this.mValue;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\parser\plugins\DJIPlaybackChanneParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */