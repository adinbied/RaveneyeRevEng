package org.bouncycastle.crypto.params;

public class DHKeyParameters
  extends AsymmetricKeyParameter
{
  private DHParameters params;
  
  protected DHKeyParameters(boolean paramBoolean, DHParameters paramDHParameters)
  {
    super(paramBoolean);
    this.params = paramDHParameters;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof DHKeyParameters;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject = (DHKeyParameters)paramObject;
    paramObject = this.params;
    localObject = ((DHKeyParameters)localObject).getParameters();
    if (paramObject == null)
    {
      if (localObject == null) {
        bool1 = true;
      }
      return bool1;
    }
    return ((DHParameters)paramObject).equals(localObject);
  }
  
  public DHParameters getParameters()
  {
    return this.params;
  }
  
  public int hashCode()
  {
    int k = isPrivate() ^ true;
    DHParameters localDHParameters = this.params;
    int i = k;
    int j;
    if (localDHParameters != null) {
      j = k ^ localDHParameters.hashCode();
    }
    return j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DHKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */