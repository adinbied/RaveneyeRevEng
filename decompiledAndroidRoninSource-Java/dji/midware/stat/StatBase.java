package dji.midware.stat;

public abstract class StatBase
{
  private final String name;
  
  public StatBase(String paramString)
  {
    if (paramString != null)
    {
      this.name = paramString;
      return;
    }
    throw new RuntimeException("name should not be null");
  }
  
  public abstract void addEvent(double paramDouble);
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public abstract double getValue();
  
  public abstract double getValueAndReset();
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\stat\StatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */