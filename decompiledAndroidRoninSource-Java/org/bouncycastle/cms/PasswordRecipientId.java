package org.bouncycastle.cms;

public class PasswordRecipientId
  extends RecipientId
{
  public PasswordRecipientId()
  {
    super(3);
  }
  
  public Object clone()
  {
    return new PasswordRecipientId();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject instanceof PasswordRecipientId);
  }
  
  public int hashCode()
  {
    return 3;
  }
  
  public boolean match(Object paramObject)
  {
    return (paramObject instanceof PasswordRecipientInformation);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\PasswordRecipientId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */