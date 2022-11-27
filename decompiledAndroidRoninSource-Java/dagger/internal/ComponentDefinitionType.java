package dagger.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE})
public @interface ComponentDefinitionType
{
  Class<?> value();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\ComponentDefinitionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */