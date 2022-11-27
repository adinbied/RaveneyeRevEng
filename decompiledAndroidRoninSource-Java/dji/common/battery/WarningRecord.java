package dji.common.battery;

public class WarningRecord
{
  private boolean currentOverloaded;
  private boolean customDischargeEnabled;
  private short damagedCellIndex;
  private boolean lowTemperature;
  private short lowVoltageCellIndex;
  private boolean overHeated;
  private boolean shortCircuited;
  
  public WarningRecord(int paramInt)
  {
    boolean bool2 = false;
    if (((paramInt & 0x1) != 1) && ((paramInt & 0x2) != 2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.currentOverloaded = bool1;
    if (((paramInt & 0x4) != 4) && ((paramInt & 0x8) != 8)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.overHeated = bool1;
    if (((paramInt & 0x10) != 16) && ((paramInt & 0x20) != 32)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.lowTemperature = bool1;
    if ((paramInt & 0x40) == 64) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.shortCircuited = bool1;
    boolean bool1 = bool2;
    if ((paramInt & 0x20000) == 131072) {
      bool1 = true;
    }
    this.customDischargeEnabled = bool1;
    this.lowVoltageCellIndex = ((short)((paramInt >> 7 & 0x8) - 1));
    this.damagedCellIndex = ((short)((paramInt >> 10 & 0x8) - 1));
  }
  
  public WarningRecord(long paramLong)
  {
    boolean bool2 = false;
    if (((paramLong & 1L) != 1L) && ((paramLong & 0x2) != 2L)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.currentOverloaded = bool1;
    if (((paramLong & 0x4) != 4L) && ((paramLong & 0x8) != 8L)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.overHeated = bool1;
    if (((paramLong & 0x10) != 16L) && ((paramLong & 0x20) != 32L)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.lowTemperature = bool1;
    if ((paramLong & 0x40) == 64L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.shortCircuited = bool1;
    boolean bool1 = bool2;
    if ((paramLong & 0x200000) == 2097152L) {
      bool1 = true;
    }
    this.customDischargeEnabled = bool1;
    this.lowVoltageCellIndex = ((short)(int)((0xF80 & paramLong) - 1L));
    this.damagedCellIndex = ((short)(int)((paramLong & 0x1F000) - 1L));
  }
  
  public WarningRecord(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, short paramShort1, short paramShort2)
  {
    this.currentOverloaded = paramBoolean1;
    this.overHeated = paramBoolean2;
    this.lowTemperature = paramBoolean3;
    this.shortCircuited = paramBoolean4;
    this.customDischargeEnabled = paramBoolean5;
    this.lowVoltageCellIndex = ((short)(paramShort1 - 1));
    this.damagedCellIndex = ((short)(paramShort2 - 1));
  }
  
  public int getDamagedCellIndex()
  {
    return this.damagedCellIndex;
  }
  
  public int getLowVoltageCellIndex()
  {
    return this.lowVoltageCellIndex;
  }
  
  public boolean hasError()
  {
    return false;
  }
  
  public boolean isCurrentOverloaded()
  {
    return this.currentOverloaded;
  }
  
  public boolean isCustomDischargeEnabled()
  {
    return this.customDischargeEnabled;
  }
  
  public boolean isLowTemperature()
  {
    return this.lowTemperature;
  }
  
  public boolean isOverHeated()
  {
    return this.overHeated;
  }
  
  public boolean isShortCircuited()
  {
    return this.shortCircuited;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\battery\WarningRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */