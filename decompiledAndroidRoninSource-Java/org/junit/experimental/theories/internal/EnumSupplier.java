package org.junit.experimental.theories.internal;

import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class EnumSupplier
  extends ParameterSupplier
{
  private Class<?> enumType;
  
  public EnumSupplier(Class<?> paramClass)
  {
    this.enumType = paramClass;
  }
  
  public List<PotentialAssignment> getValueSources(ParameterSignature paramParameterSignature)
  {
    paramParameterSignature = this.enumType.getEnumConstants();
    ArrayList localArrayList = new ArrayList();
    int j = paramParameterSignature.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramParameterSignature[i];
      localArrayList.add(PotentialAssignment.forValue(localObject.toString(), localObject));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\theories\internal\EnumSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */