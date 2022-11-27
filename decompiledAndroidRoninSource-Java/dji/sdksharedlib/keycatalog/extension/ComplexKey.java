package dji.sdksharedlib.keycatalog.extension;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ComplexKey
{
  Key[] value() default {};
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\extension\ComplexKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */