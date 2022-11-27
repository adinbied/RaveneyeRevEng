package org.bouncycastle.asn1.x509;

public abstract interface NameConstraintValidator
{
  public abstract void addExcludedSubtree(GeneralSubtree paramGeneralSubtree);
  
  public abstract void checkExcluded(GeneralName paramGeneralName)
    throws NameConstraintValidatorException;
  
  public abstract void checkPermitted(GeneralName paramGeneralName)
    throws NameConstraintValidatorException;
  
  public abstract void intersectEmptyPermittedSubtree(int paramInt);
  
  public abstract void intersectPermittedSubtree(GeneralSubtree paramGeneralSubtree);
  
  public abstract void intersectPermittedSubtree(GeneralSubtree[] paramArrayOfGeneralSubtree);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\NameConstraintValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */