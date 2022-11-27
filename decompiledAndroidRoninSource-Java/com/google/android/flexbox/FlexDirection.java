package com.google.android.flexbox;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface FlexDirection
{
  public static final int COLUMN = 2;
  public static final int COLUMN_REVERSE = 3;
  public static final int ROW = 0;
  public static final int ROW_REVERSE = 1;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\flexbox\FlexDirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */