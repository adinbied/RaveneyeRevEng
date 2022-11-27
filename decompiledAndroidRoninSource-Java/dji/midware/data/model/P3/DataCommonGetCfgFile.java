package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;
import java.util.List;

public class DataCommonGetCfgFile
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonGetCfgFile instance;
  private long length = 0L;
  private int mReceiveId = 0;
  private DeviceType mReceiveType = DeviceType.DM368;
  private long offset = 0L;
  private DJIUpgradeFileType type;
  
  public static DataCommonGetCfgFile getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonGetCfgFile();
      }
      DataCommonGetCfgFile localDataCommonGetCfgFile = instance;
      return localDataCommonGetCfgFile;
    }
    finally {}
  }
  
  private List<CFGModulePackage> getModuleCFGList(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getBuffer(byte[] paramArrayOfByte)
  {
    return 0;
  }
  
  public CFGCompletePackage getCFGVersionDesc(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public int getRelLength()
  {
    return 0;
  }
  
  public int getRemainLength()
  {
    return 0;
  }
  
  public DataCommonGetCfgFile setLength(long paramLong)
  {
    this.length = paramLong;
    return this;
  }
  
  public DataCommonGetCfgFile setOffset(long paramLong)
  {
    this.offset = paramLong;
    return this;
  }
  
  public DataCommonGetCfgFile setReceiveId(int paramInt)
  {
    this.mReceiveId = paramInt;
    return this;
  }
  
  public DataCommonGetCfgFile setReceiveType(DeviceType paramDeviceType)
  {
    this.mReceiveType = paramDeviceType;
    return this;
  }
  
  public DataCommonGetCfgFile setType(DJIUpgradeFileType paramDJIUpgradeFileType)
  {
    this.type = paramDJIUpgradeFileType;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class CFGCompletePackage
  {
    private List<DataCommonGetCfgFile.CFGModulePackage> mCFGModulePackages = new ArrayList();
    private int mCompleteFlag;
    private int mDescVersion;
    private int mModulePackCount;
    private byte[] mProductName = new byte[8];
    private int mProductVersion;
    private int mSize;
    private int mUpgradeFlag;
    
    public int getByteSize()
    {
      return 0;
    }
    
    public List<DataCommonGetCfgFile.CFGModulePackage> getCFGModulePackages()
    {
      return this.mCFGModulePackages;
    }
    
    public int getCompleteFlag()
    {
      return this.mCompleteFlag;
    }
    
    public int getDescVersion()
    {
      return this.mDescVersion;
    }
    
    public int getModulePackCount()
    {
      return this.mModulePackCount;
    }
    
    public byte[] getProductName()
    {
      return this.mProductName;
    }
    
    public int getProductVersion()
    {
      return this.mProductVersion;
    }
    
    public int getSize()
    {
      return this.mSize;
    }
    
    public int getUpgradeFlag()
    {
      return this.mUpgradeFlag;
    }
    
    public void setCFGModulePackages(List<DataCommonGetCfgFile.CFGModulePackage> paramList)
    {
      this.mCFGModulePackages = paramList;
    }
    
    public void setCompleteFlag(int paramInt)
    {
      this.mCompleteFlag = paramInt;
    }
    
    public void setDescVersion(int paramInt)
    {
      this.mDescVersion = paramInt;
    }
    
    public void setModulePackCount(int paramInt)
    {
      this.mModulePackCount = paramInt;
    }
    
    public void setProductName(byte[] paramArrayOfByte)
    {
      this.mProductName = paramArrayOfByte;
    }
    
    public void setProductVersion(int paramInt)
    {
      this.mProductVersion = paramInt;
    }
    
    public void setSize(int paramInt)
    {
      this.mSize = paramInt;
    }
    
    public void setUpgradeFlag(int paramInt)
    {
      this.mUpgradeFlag = paramInt;
    }
    
    public byte[] toByteArray()
    {
      return null;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static class CFGModulePackage
  {
    public static final int BYTE_SIZE = 30;
    private int mDeviceId;
    private int mDeviceSubId;
    private int mLength;
    private byte[] mMD5 = new byte[16];
    private int mOffset;
    private int mVersion;
    
    public int getByteSize()
    {
      return 30;
    }
    
    public int getDeviceId()
    {
      return this.mDeviceId;
    }
    
    public int getDeviceSubId()
    {
      return this.mDeviceSubId;
    }
    
    public int getLength()
    {
      return this.mLength;
    }
    
    public byte[] getMD5()
    {
      return this.mMD5;
    }
    
    public int getOffset()
    {
      return this.mOffset;
    }
    
    public int getVersion()
    {
      return this.mVersion;
    }
    
    public void setDeviceId(int paramInt)
    {
      this.mDeviceId = paramInt;
    }
    
    public void setDeviceSubId(int paramInt)
    {
      this.mDeviceSubId = paramInt;
    }
    
    public void setLength(int paramInt)
    {
      this.mLength = paramInt;
    }
    
    public void setMD5(byte[] paramArrayOfByte)
    {
      this.mMD5 = paramArrayOfByte;
    }
    
    public void setOffset(int paramInt)
    {
      this.mOffset = paramInt;
    }
    
    public void setVersion(int paramInt)
    {
      this.mVersion = paramInt;
    }
    
    public byte[] toByteArray()
    {
      return null;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static enum DJIUpgradeFileType
  {
    private int data;
    
    static
    {
      DJIUpgradeFileType localDJIUpgradeFileType = new DJIUpgradeFileType("OTHER", 2, 100);
      OTHER = localDJIUpgradeFileType;
      $VALUES = new DJIUpgradeFileType[] { CFG, LOG, localDJIUpgradeFileType };
    }
    
    private DJIUpgradeFileType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJIUpgradeFileType find(int paramInt)
    {
      DJIUpgradeFileType localDJIUpgradeFileType = OTHER;
      DJIUpgradeFileType[] arrayOfDJIUpgradeFileType = values();
      int j = arrayOfDJIUpgradeFileType.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDJIUpgradeFileType[i]._equals(paramInt)) {
          return arrayOfDJIUpgradeFileType[i];
        }
        i += 1;
      }
      return localDJIUpgradeFileType;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonGetCfgFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */