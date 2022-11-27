package dji.midware.data.model.hg702;

public class CameraParamTable
{
  RangeType mRangeType;
  int[] mTable;
  
  public RangeType getRangeType()
  {
    return this.mRangeType;
  }
  
  public int[] getTable()
  {
    return this.mTable;
  }
  
  public void setRangeType(RangeType paramRangeType)
  {
    this.mRangeType = paramRangeType;
  }
  
  public void setTable(int[] paramArrayOfInt)
  {
    this.mTable = paramArrayOfInt;
  }
  
  public static enum RangeType
  {
    private int data;
    
    static
    {
      RangeType localRangeType = new RangeType("ENUM", 1, 1);
      ENUM = localRangeType;
      $VALUES = new RangeType[] { CONTINUOUS, localRangeType };
    }
    
    private RangeType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RangeType find(int paramInt)
    {
      RangeType localRangeType = CONTINUOUS;
      RangeType[] arrayOfRangeType = values();
      int i = 0;
      while (i < arrayOfRangeType.length)
      {
        if (arrayOfRangeType[i]._equals(paramInt)) {
          return arrayOfRangeType[i];
        }
        i += 1;
      }
      return localRangeType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\CameraParamTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */