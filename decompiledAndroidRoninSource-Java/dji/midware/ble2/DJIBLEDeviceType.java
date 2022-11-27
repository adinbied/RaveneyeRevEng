package dji.midware.ble2;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanResult;
import android.os.ParcelUuid;
import dji.midware.ble2.base.BleLog;
import dji.midware.ble2.base.BleScanFilter;
import java.util.ArrayList;
import java.util.List;

public enum DJIBLEDeviceType
  implements BleScanFilter
{
  private int mID;
  
  static
  {
    DJIWATCH = new DJIBLEDeviceType("DJIWATCH", 1, 1);
    RONIN2 = new DJIBLEDeviceType("RONIN2", 2, 2);
    RONINS = new DJIBLEDeviceType("RONINS", 3, 3);
    HG701 = new DJIBLEDeviceType("HG701", 4, 131);
    HG702 = new DJIBLEDeviceType("HG702", 5, 136);
    HG710 = new DJIBLEDeviceType("HG710", 6, 137);
    DJIBLEDeviceType localDJIBLEDeviceType = new DJIBLEDeviceType("OTHER", 7, 255);
    OTHER = localDJIBLEDeviceType;
    $VALUES = new DJIBLEDeviceType[] { HG300, DJIWATCH, RONIN2, RONINS, HG701, HG702, HG710, localDJIBLEDeviceType };
  }
  
  private DJIBLEDeviceType(int paramInt)
  {
    this.mID = paramInt;
  }
  
  public static DJIBLEDeviceType find(int paramInt)
  {
    DJIBLEDeviceType localDJIBLEDeviceType = OTHER;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localDJIBLEDeviceType;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.mID == paramInt;
  }
  
  public boolean filterScanRecord(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    if (paramArrayOfByte == null) {
      return false;
    }
    int k = paramArrayOfByte.length;
    int i = 0;
    while (i < k) {
      if ((i >= 0) && (i < k))
      {
        int m = paramArrayOfByte[i];
        i += 1;
        if ((m > 1) && (i < k) && ((paramArrayOfByte[i] & 0xFF) == 255) && (m >= 4))
        {
          j = i + 3;
          if (j < k)
          {
            k = i + 1;
            if ((((paramArrayOfByte[k] & 0xFF) == 192) && ((paramArrayOfByte[(i + 2)] & 0xFF) == 229)) || (((paramArrayOfByte[k] & 0xFF) == 170) && ((paramArrayOfByte[(i + 2)] & 0xFF) == 8))) {
              i = 1;
            } else {
              i = 0;
            }
            j = paramArrayOfByte[j] & 0xFF;
            k = j >> 4;
            if (k > RONINS.value()) {
              if (j != value()) {}
            }
            for (;;)
            {
              k = 1;
              j = i;
              i = k;
              break;
              do
              {
                k = 0;
                j = i;
                i = k;
                break;
              } while (k != value());
            }
          }
        }
        i += m;
      }
      else
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(i);
        paramArrayOfByte.append(" = filterScanRecord rawData = ");
        paramArrayOfByte.append(k);
        BleLog.logD(paramArrayOfByte.toString());
      }
    }
    i = 0;
    int j = 0;
    boolean bool1 = bool2;
    if (j != 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean filterScanResult(ScanResult paramScanResult)
  {
    return true;
  }
  
  public int getID()
  {
    return this.mID;
  }
  
  public List getScanFilters()
  {
    ScanFilter localScanFilter = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(BleConstants.UUID_SERVICE)).build();
    ArrayList localArrayList = new ArrayList(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getScanFilters : ");
    localStringBuilder.append(localScanFilter);
    BleLog.logD(localStringBuilder.toString());
    localArrayList.add(localScanFilter);
    return localArrayList;
  }
  
  public void setID(int paramInt)
  {
    this.mID = paramInt;
  }
  
  public int value()
  {
    return this.mID;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\DJIBLEDeviceType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */