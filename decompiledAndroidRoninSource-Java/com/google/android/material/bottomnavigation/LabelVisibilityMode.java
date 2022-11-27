package com.google.android.material.bottomnavigation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LabelVisibilityMode
{
  public static final int LABEL_VISIBILITY_AUTO = -1;
  public static final int LABEL_VISIBILITY_LABELED = 1;
  public static final int LABEL_VISIBILITY_SELECTED = 0;
  public static final int LABEL_VISIBILITY_UNLABELED = 2;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\bottomnavigation\LabelVisibilityMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */