package org.bouncycastle.asn1.x509;

import java.util.Vector;

public class GeneralNamesBuilder
{
  private Vector names = new Vector();
  
  public GeneralNamesBuilder addName(GeneralName paramGeneralName)
  {
    this.names.addElement(paramGeneralName);
    return this;
  }
  
  public GeneralNamesBuilder addNames(GeneralNames paramGeneralNames)
  {
    paramGeneralNames = paramGeneralNames.getNames();
    int i = 0;
    while (i != paramGeneralNames.length)
    {
      this.names.addElement(paramGeneralNames[i]);
      i += 1;
    }
    return this;
  }
  
  public GeneralNames build()
  {
    int j = this.names.size();
    GeneralName[] arrayOfGeneralName = new GeneralName[j];
    int i = 0;
    while (i != j)
    {
      arrayOfGeneralName[i] = ((GeneralName)this.names.elementAt(i));
      i += 1;
    }
    return new GeneralNames(arrayOfGeneralName);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\GeneralNamesBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */