package org.junit.experimental.theories;

import java.util.List;

public abstract class ParameterSupplier
{
  public abstract List<PotentialAssignment> getValueSources(ParameterSignature paramParameterSignature)
    throws Throwable;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\theories\ParameterSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */