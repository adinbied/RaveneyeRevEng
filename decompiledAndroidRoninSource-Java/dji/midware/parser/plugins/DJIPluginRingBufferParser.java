package dji.midware.parser.plugins;

public class DJIPluginRingBufferParser
{
  private String TAG = getClass().getSimpleName();
  private byte[] buffer;
  private DJIRingBufferModel bufferModel;
  private int byteOffset = 0;
  private int expendSize = 0;
  private final boolean isDebug = false;
  private boolean isGettedHeader = false;
  private DJIRingBufferParserListener listener;
  private int myHeaderIndex = 0;
  private String name = "default";
  
  public DJIPluginRingBufferParser(int paramInt, DJIRingBufferModel paramDJIRingBufferModel, DJIRingBufferParserListener paramDJIRingBufferParserListener)
  {
    this.bufferModel = paramDJIRingBufferModel;
    this.buffer = new byte[paramInt];
    this.listener = paramDJIRingBufferParserListener;
  }
  
  /* Error */
  private void findPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void resetBuffer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getName()
  {
    return this.name;
  }
  
  /* Error */
  public void parse(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public static abstract interface DJIRingBufferParserListener
  {
    public abstract void onGetBody(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract int parseSecondHeader(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\parser\plugins\DJIPluginRingBufferParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */