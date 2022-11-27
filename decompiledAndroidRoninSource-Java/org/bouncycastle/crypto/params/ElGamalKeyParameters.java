package org.bouncycastle.crypto.params;

public class ElGamalKeyParameters
  extends AsymmetricKeyParameter
{
  private ElGamalParameters params;
  
  protected ElGamalKeyParameters(boolean paramBoolean, ElGamalParameters paramElGamalParameters)
  {
    super(paramBoolean);
    this.params = paramElGamalParameters;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof ElGamalKeyParameters;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject = (ElGamalKeyParameters)paramObject;
    paramObject = this.params;
    localObject = ((ElGamalKeyParameters)localObject).getParameters();
    if (paramObject == null)
    {
      if (localObject == null) {
        bool1 = true;
      }
      return bool1;
    }
    return ((ElGamalParameters)paramObject).equals(localObject);
  }
  
  public ElGamalParameters getParameters()
  {
    return this.params;
  }
  
  public int hashCode()
  {
    ElGamalParameters localElGamalParameters = this.params;
    if (localElGamalParameters != null) {
      return localElGamalParameters.hashCode();
    }
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ElGamalKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */