package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class BooleanSupplier
  extends ParameterSupplier
{
  public List<PotentialAssignment> getValueSources(ParameterSignature paramParameterSignature)
  {
    return Arrays.asList(new PotentialAssignment[] { PotentialAssignment.forValue("true", Boolean.valueOf(true)), PotentialAssignment.forValue("false", Boolean.valueOf(false)) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\theories\internal\BooleanSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */