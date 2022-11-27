package lecho.lib.hellocharts.model;

public class SelectedValue
{
  private int firstIndex;
  private int secondIndex;
  private SelectedValueType type = SelectedValueType.NONE;
  
  public SelectedValue()
  {
    clear();
  }
  
  public SelectedValue(int paramInt1, int paramInt2, SelectedValueType paramSelectedValueType)
  {
    set(paramInt1, paramInt2, paramSelectedValueType);
  }
  
  public void clear()
  {
    set(Integer.MIN_VALUE, Integer.MIN_VALUE, SelectedValueType.NONE);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getFirstIndex()
  {
    return this.firstIndex;
  }
  
  public int getSecondIndex()
  {
    return this.secondIndex;
  }
  
  public SelectedValueType getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isSet()
  {
    return false;
  }
  
  public void set(int paramInt1, int paramInt2, SelectedValueType paramSelectedValueType)
  {
    this.firstIndex = paramInt1;
    this.secondIndex = paramInt2;
    if (paramSelectedValueType != null)
    {
      this.type = paramSelectedValueType;
      return;
    }
    this.type = SelectedValueType.NONE;
  }
  
  /* Error */
  public void set(SelectedValue arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setFirstIndex(int paramInt)
  {
    this.firstIndex = paramInt;
  }
  
  public void setSecondIndex(int paramInt)
  {
    this.secondIndex = paramInt;
  }
  
  public void setType(SelectedValueType paramSelectedValueType)
  {
    this.type = paramSelectedValueType;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static enum SelectedValueType
  {
    static
    {
      LINE = new SelectedValueType("LINE", 1);
      SelectedValueType localSelectedValueType = new SelectedValueType("COLUMN", 2);
      COLUMN = localSelectedValueType;
      $VALUES = new SelectedValueType[] { NONE, LINE, localSelectedValueType };
    }
    
    private SelectedValueType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\SelectedValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */