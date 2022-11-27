package dji.midware.ble2.base;

import android.bluetooth.le.ScanResult;
import java.util.List;

public abstract interface BleScanFilter
{
  public abstract boolean filterScanRecord(byte[] paramArrayOfByte);
  
  public abstract boolean filterScanResult(ScanResult paramScanResult);
  
  public abstract int getID();
  
  public abstract List getScanFilters();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleScanFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */