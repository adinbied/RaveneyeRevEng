package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.experimental.theories.internal.SpecificDataPointsSupplier;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.PARAMETER})
@ParametersSuppliedBy(SpecificDataPointsSupplier.class)
public @interface FromDataPoints
{
  String value();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\theories\FromDataPoints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */