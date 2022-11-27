package org.bouncycastle.crypto.params;

public class CramerShoupKeyParameters
  extends AsymmetricKeyParameter
{
  private CramerShoupParameters params;
  
  protected CramerShoupKeyParameters(boolean paramBoolean, CramerShoupParameters paramCramerShoupParameters)
  {
    super(paramBoolean);
    this.params = paramCramerShoupParameters;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof CramerShoupKeyParameters;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject = (CramerShoupKeyParameters)paramObject;
    paramObject = this.params;
    localObject = ((CramerShoupKeyParameters)localObject).getParameters();
    if (paramObject == null)
    {
      if (localObject == null) {
        bool1 = true;
      }
      return bool1;
    }
    return ((CramerShoupParameters)paramObject).equals(localObject);
  }
  
  public CramerShoupParameters getParameters()
  {
    return this.params;
  }
  
  public int hashCode()
  {
    int k = isPrivate() ^ true;
    CramerShoupParameters localCramerShoupParameters = this.params;
    int i = k;
    int j;
    if (localCramerShoupParameters != null) {
      j = k ^ localCramerShoupParameters.hashCode();
    }
    return j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\CramerShoupKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */