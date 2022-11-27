package org.bouncycastle.math.field;

import java.math.BigInteger;
import org.bouncycastle.util.Integers;

class GenericPolynomialExtensionField
  implements PolynomialExtensionField
{
  protected final Polynomial minimalPolynomial;
  protected final FiniteField subfield;
  
  GenericPolynomialExtensionField(FiniteField paramFiniteField, Polynomial paramPolynomial)
  {
    this.subfield = paramFiniteField;
    this.minimalPolynomial = paramPolynomial;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof GenericPolynomialExtensionField)) {
      return false;
    }
    paramObject = (GenericPolynomialExtensionField)paramObject;
    return (this.subfield.equals(((GenericPolynomialExtensionField)paramObject).subfield)) && (this.minimalPolynomial.equals(((GenericPolynomialExtensionField)paramObject).minimalPolynomial));
  }
  
  public BigInteger getCharacteristic()
  {
    return this.subfield.getCharacteristic();
  }
  
  public int getDegree()
  {
    return this.minimalPolynomial.getDegree();
  }
  
  public int getDimension()
  {
    return this.subfield.getDimension() * this.minimalPolynomial.getDegree();
  }
  
  public Polynomial getMinimalPolynomial()
  {
    return this.minimalPolynomial;
  }
  
  public FiniteField getSubfield()
  {
    return this.subfield;
  }
  
  public int hashCode()
  {
    return this.subfield.hashCode() ^ Integers.rotateLeft(this.minimalPolynomial.hashCode(), 16);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\field\GenericPolynomialExtensionField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */