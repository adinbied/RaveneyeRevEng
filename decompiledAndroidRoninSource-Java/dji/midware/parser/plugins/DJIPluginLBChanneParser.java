package dji.midware.parser.plugins;

public class DJIPluginLBChanneParser
{
  private String TAG = getClass().getSimpleName();
  private int bodyLen = 0;
  private int channelID = 0;
  private int checkSum = 0;
  private final int headerLen = 12;
  private final boolean isDebug = false;
  private final byte[] magic = { 0, 0, 1, -1 };
  private DJIPluginRingBufferParser ringBufferParser;
  private int rseverd = 0;
  private int version = 0;
  
  public DJIPluginLBChanneParser(final DJILBChannelListener paramDJILBChannelListener)
  {
    DJIRingBufferModel localDJIRingBufferModel = new DJIRingBufferModel();
    localDJIRingBufferModel.header = this.magic;
    localDJIRingBufferModel.secondHeaderLen = 8;
    paramDJILBChannelListener = new DJIPluginRingBufferParser(1048576, localDJIRingBufferModel, new DJIPluginRingBufferParser.DJIRingBufferParserListener()
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
    this.ringBufferParser = paramDJILBChannelListener;
    paramDJILBChannelListener.setName("LB");
  }
  
  private int headerXor(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.ringBufferParser.parse(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static enum DJILBChannelID
  {
    private int mValue = 0;
    
    static
    {
      FileDownload = new DJILBChannelID("FileDownload", 1, 18);
      SecondaryLiveView = new DJILBChannelID("SecondaryLiveView", 2, 19);
      ThirdLiveViewZ30 = new DJILBChannelID("ThirdLiveViewZ30", 3, 21);
      FourthLiveViewXT = new DJILBChannelID("FourthLiveViewXT", 4, 23);
      ARPush = new DJILBChannelID("ARPush", 5, 35);
      DJILBChannelID localDJILBChannelID = new DJILBChannelID("FlightLog", 6, 64);
      FlightLog = localDJILBChannelID;
      $VALUES = new DJILBChannelID[] { LiveView, FileDownload, SecondaryLiveView, ThirdLiveViewZ30, FourthLiveViewXT, ARPush, localDJILBChannelID };
    }
    
    private DJILBChannelID(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public int value()
    {
      return this.mValue;
    }
  }
  
  public static abstract interface DJILBChannelListener
  {
    public abstract void onRecv(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\parser\plugins\DJIPluginLBChanneParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */