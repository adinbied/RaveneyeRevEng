package dji.midware.data.model.hg702;

public enum EVMode
{
  private int data;
  
  static
  {
    A = new EVMode("A", 3, 3);
    M = new EVMode("M", 4, 4);
    EVMode localEVMode = new EVMode("UNKNOWN", 5, 255);
    UNKNOWN = localEVMode;
    $VALUES = new EVMode[] { AUTO, P, S, A, M, localEVMode };
  }
  
  private EVMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static EVMode find(int paramInt)
  {
    EVMode localEVMode = UNKNOWN;
    EVMode[] arrayOfEVMode = values();
    int i = 0;
    while (i < arrayOfEVMode.length)
    {
      if (arrayOfEVMode[i]._equals(paramInt)) {
        return arrayOfEVMode[i];
      }
      i += 1;
    }
    return localEVMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\EVMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */