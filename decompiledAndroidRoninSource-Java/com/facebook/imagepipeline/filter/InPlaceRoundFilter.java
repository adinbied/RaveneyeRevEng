package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

public final class InPlaceRoundFilter
{
  public static void roundBitmapInPlace(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    int i9 = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int i1 = Math.min(i9, m) / 2;
    int i2 = i9 / 2;
    int n = m / 2;
    if (i1 == 0) {
      return;
    }
    boolean bool;
    if (i1 >= 1) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if ((i9 > 0) && (i9 <= 2048.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if ((m > 0) && (m <= 2048.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if ((i2 > 0) && (i2 < i9)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if ((n > 0) && (n < m)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    int[] arrayOfInt1 = new int[i9 * m];
    paramBitmap.getPixels(arrayOfInt1, 0, i9, 0, 0, i9, m);
    int i4 = i1 - 1;
    if ((i2 - i4 >= 0) && (n - i4 >= 0) && (i2 + i4 < i9) && (n + i4 < m)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    int i3 = -i1 * 2;
    int[] arrayOfInt2 = new int[i9];
    int j = i3 + 1;
    int i6 = 0;
    int i = 1;
    int i7;
    for (int i5 = 1; i4 >= i6; i5 = i7)
    {
      i7 = i2 + i4;
      int i8 = i2 - i4;
      int k = i2 + i6;
      int i10 = i2 - i6;
      int i11 = n + i6;
      int i12 = n - i6;
      if ((i4 >= 0) && (k < i9) && (i10 >= 0) && (i11 < m) && (i12 >= 0)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      i11 *= i9;
      int i14 = i9 * i12;
      i12 = i9 * (n + i4);
      int i13 = i9 * (n - i4);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i11, i8);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i14, i8);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i12, i10);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i13, i10);
      i8 = i9 - i7;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i11 + i7, i8);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i14 + i7, i8);
      i7 = i9 - k;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i12 + k, i7);
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i13 + k, i7);
      k = j;
      i8 = i6;
      i7 = i5;
      if (j <= 0)
      {
        i8 = i6 + 1;
        i7 = i5 + 2;
        k = j + i7;
      }
      if (k > 0)
      {
        i4 -= 1;
        i += 2;
        j = k + (i + i3);
      }
      else
      {
        j = k;
      }
      i6 = i8;
    }
    i = n - i1;
    while (i >= 0)
    {
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i * i9, i9);
      i -= 1;
    }
    i = n + i1;
    while (i < m)
    {
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i * i9, i9);
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i9, 0, 0, i9, m);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\filter\InPlaceRoundFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */