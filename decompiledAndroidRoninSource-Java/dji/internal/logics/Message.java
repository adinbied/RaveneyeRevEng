package dji.internal.logics;

public class Message
{
  private final String description;
  private final long flag;
  private final boolean shouldBlink;
  private final String title;
  private final Type type;
  
  public Message(Type paramType, String paramString1, String paramString2)
  {
    this(paramType, false, paramString1, paramString2, 0L);
  }
  
  public Message(Type paramType, boolean paramBoolean, String paramString, long paramLong)
  {
    this(paramType, paramBoolean, paramString, null, paramLong);
  }
  
  public Message(Type paramType, boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    this.type = paramType;
    this.title = paramString1;
    this.description = paramString2;
    this.shouldBlink = paramBoolean;
    this.flag = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public long getFlag()
  {
    return this.flag;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public Type getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean shouldBlink()
  {
    return this.shouldBlink;
  }
  
  public static enum Type
  {
    private final int value;
    
    static
    {
      GOOD = new Type("GOOD", 1, 1);
      WARNING = new Type("WARNING", 2, 2);
      Type localType = new Type("ERROR", 3, 3);
      ERROR = localType;
      $VALUES = new Type[] { OFFLINE, GOOD, WARNING, localType };
    }
    
    private Type(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */