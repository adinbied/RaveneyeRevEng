package org.bouncycastle.crypto.tls;

import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.crypto.agreement.srp.SRP6StandardGroups;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class DefaultTlsSRPGroupVerifier
  implements TlsSRPGroupVerifier
{
  protected static final Vector DEFAULT_GROUPS;
  protected Vector groups;
  
  static
  {
    Vector localVector = new Vector();
    DEFAULT_GROUPS = localVector;
    localVector.addElement(SRP6StandardGroups.rfc5054_1024);
    DEFAULT_GROUPS.addElement(SRP6StandardGroups.rfc5054_1536);
    DEFAULT_GROUPS.addElement(SRP6StandardGroups.rfc5054_2048);
    DEFAULT_GROUPS.addElement(SRP6StandardGroups.rfc5054_3072);
    DEFAULT_GROUPS.addElement(SRP6StandardGroups.rfc5054_4096);
    DEFAULT_GROUPS.addElement(SRP6StandardGroups.rfc5054_6144);
    DEFAULT_GROUPS.addElement(SRP6StandardGroups.rfc5054_8192);
  }
  
  public DefaultTlsSRPGroupVerifier()
  {
    this(DEFAULT_GROUPS);
  }
  
  public DefaultTlsSRPGroupVerifier(Vector paramVector)
  {
    this.groups = paramVector;
  }
  
  public boolean accept(SRP6GroupParameters paramSRP6GroupParameters)
  {
    int i = 0;
    while (i < this.groups.size())
    {
      if (areGroupsEqual(paramSRP6GroupParameters, (SRP6GroupParameters)this.groups.elementAt(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected boolean areGroupsEqual(SRP6GroupParameters paramSRP6GroupParameters1, SRP6GroupParameters paramSRP6GroupParameters2)
  {
    return (paramSRP6GroupParameters1 == paramSRP6GroupParameters2) || ((areParametersEqual(paramSRP6GroupParameters1.getN(), paramSRP6GroupParameters2.getN())) && (areParametersEqual(paramSRP6GroupParameters1.getG(), paramSRP6GroupParameters2.getG())));
  }
  
  protected boolean areParametersEqual(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    return (paramBigInteger1 == paramBigInteger2) || (paramBigInteger1.equals(paramBigInteger2));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DefaultTlsSRPGroupVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */