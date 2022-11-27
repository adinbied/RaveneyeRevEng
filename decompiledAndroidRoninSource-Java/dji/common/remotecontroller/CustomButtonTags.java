package dji.common.remotecontroller;

public class CustomButtonTags
{
  private short c1ButtonTag;
  private short c2ButtonTag;
  
  private CustomButtonTags(Builder paramBuilder)
  {
    this.c1ButtonTag = paramBuilder.c1ButtonTag;
    this.c2ButtonTag = paramBuilder.c2ButtonTag;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public short getC1ButtonTag()
  {
    return this.c1ButtonTag;
  }
  
  public short getC2ButtonTag()
  {
    return this.c2ButtonTag;
  }
  
  public int hashCode()
  {
    return this.c1ButtonTag * 31 + this.c2ButtonTag;
  }
  
  public static final class Builder
  {
    private short c1ButtonTag;
    private short c2ButtonTag;
    
    public CustomButtonTags build()
    {
      return new CustomButtonTags(this, null);
    }
    
    public Builder c1ButtonTag(short paramShort)
    {
      this.c1ButtonTag = paramShort;
      return this;
    }
    
    public Builder c2ButtonTag(short paramShort)
    {
      this.c2ButtonTag = paramShort;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\CustomButtonTags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */