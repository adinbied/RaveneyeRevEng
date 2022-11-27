package org.bouncycastle.cms;

import org.bouncycastle.operator.OperatorCreationException;

public abstract interface SignerInformationVerifierProvider
{
  public abstract SignerInformationVerifier get(SignerId paramSignerId)
    throws OperatorCreationException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\SignerInformationVerifierProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */