package dji.midware.aoabridge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class DJIBaseCommData
{
  public static final int DJIBridgeDataSender_androidCommon = 5;
  public static final int DJIBridgeDataSender_mfiCommon = 2;
  public static final int DJIBridgeDataSender_noUsed = 99;
  public static final int DJIBridgeDataSender_usb = 3;
  public static final int DJIBridgeDataSender_usbVideo = 4;
  private static final byte[] endSignal = { -52, -35 };
  private static final byte[] headerSignal = { -86, -69 };
  public int eventType;
  private HashMap<Integer, byte[]> info = new HashMap();
  public int sender;
  
  private byte[] toPrimitives(Byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public byte[] dataWithTag(int paramInt)
  {
    return null;
  }
  
  public ArrayList<Byte> encodeData()
  {
    return null;
  }
  
  public int numberWithTag(DJIBaseCommDataTag paramDJIBaseCommDataTag)
  {
    return 0;
  }
  
  public byte[] packedData()
  {
    return null;
  }
  
  public boolean parseData(byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  /* Error */
  public void setDataWithTag(byte[] arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setNumberWithTag(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public class DJIBaseCommDataEncodeHeader
    implements Serializable
  {
    public byte[] data;
    public int size;
    public int tag;
    
    public DJIBaseCommDataEncodeHeader() {}
  }
  
  public static enum DJIBaseCommDataTag
  {
    private int tag = 0;
    
    static
    {
      DJIBaseCommData_Event = new DJIBaseCommDataTag("DJIBaseCommData_Event", 2, 2);
      DJIBaseCommDataTag localDJIBaseCommDataTag = new DJIBaseCommDataTag("DJIBaseCommData_Data", 3, 3);
      DJIBaseCommData_Data = localDJIBaseCommDataTag;
      $VALUES = new DJIBaseCommDataTag[] { DJIBaseCommData_Test, DJIBaseCommData_Who, DJIBaseCommData_Event, localDJIBaseCommDataTag };
    }
    
    private DJIBaseCommDataTag(int paramInt)
    {
      this.tag = paramInt;
    }
    
    public int getTag()
    {
      return this.tag;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\aoabridge\DJIBaseCommData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */