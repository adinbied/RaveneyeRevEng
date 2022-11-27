package com.squareup.wire;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface WireField
{
  String adapter();
  
  String keyAdapter() default "";
  
  Label label() default Label.OPTIONAL;
  
  boolean redacted() default false;
  
  int tag();
  
  public static enum Label
  {
    static
    {
      OPTIONAL = new Label("OPTIONAL", 1);
      REPEATED = new Label("REPEATED", 2);
      ONE_OF = new Label("ONE_OF", 3);
      Label localLabel = new Label("PACKED", 4);
      PACKED = localLabel;
      $VALUES = new Label[] { REQUIRED, OPTIONAL, REPEATED, ONE_OF, localLabel };
    }
    
    private Label() {}
    
    boolean isOneOf()
    {
      return this == ONE_OF;
    }
    
    boolean isPacked()
    {
      return this == PACKED;
    }
    
    boolean isRepeated()
    {
      return (this == REPEATED) || (this == PACKED);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\WireField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */