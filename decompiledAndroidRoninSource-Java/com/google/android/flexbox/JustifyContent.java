package com.google.android.flexbox;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface JustifyContent
{
  public static final int CENTER = 2;
  public static final int FLEX_END = 1;
  public static final int FLEX_START = 0;
  public static final int SPACE_AROUND = 4;
  public static final int SPACE_BETWEEN = 3;
  public static final int SPACE_EVENLY = 5;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\flexbox\JustifyContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */