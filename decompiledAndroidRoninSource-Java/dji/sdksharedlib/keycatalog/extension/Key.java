package dji.sdksharedlib.keycatalog.extension;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface Key
{
  int accessType();
  
  Class[] excludedAbstractions() default {};
  
  int expirationDuration() default 100;
  
  Class[] includedAbstractions() default {};
  
  int protectDuration() default 500;
  
  Class type() default Object.class;
  
  Class[] types() default {};
  
  DJISDKCacheUpdateType updateType() default DJISDKCacheUpdateType.DYNAMIC;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\extension\Key.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */