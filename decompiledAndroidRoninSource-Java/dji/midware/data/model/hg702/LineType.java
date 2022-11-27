package dji.midware.data.model.hg702;

public enum LineType
{
  private int data;
  
  static
  {
    RSS = new LineType("RSS", 1, 1);
    MULTI = new LineType("MULTI", 2, 2);
    AUDIO = new LineType("AUDIO", 3, 3);
    LineType localLineType = new LineType("OTHER", 4, 255);
    OTHER = localLineType;
    $VALUES = new LineType[] { USB, RSS, MULTI, AUDIO, localLineType };
  }
  
  private LineType(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static LineType find(int paramInt)
  {
    LineType localLineType = OTHER;
    LineType[] arrayOfLineType = values();
    int i = 0;
    while (i < arrayOfLineType.length)
    {
      if (arrayOfLineType[i]._equals(paramInt)) {
        return arrayOfLineType[i];
      }
      i += 1;
    }
    return localLineType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\LineType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */