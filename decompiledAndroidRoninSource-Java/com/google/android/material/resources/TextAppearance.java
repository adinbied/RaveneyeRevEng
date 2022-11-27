package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import com.google.android.material.R.styleable;

public class TextAppearance
{
  private static final String TAG = "TextAppearance";
  private static final int TYPEFACE_MONOSPACE = 3;
  private static final int TYPEFACE_SANS = 1;
  private static final int TYPEFACE_SERIF = 2;
  private Typeface font;
  public final String fontFamily;
  private final int fontFamilyResourceId;
  private boolean fontResolved = false;
  public final ColorStateList shadowColor;
  public final float shadowDx;
  public final float shadowDy;
  public final float shadowRadius;
  public final boolean textAllCaps;
  public final ColorStateList textColor;
  public final ColorStateList textColorHint;
  public final ColorStateList textColorLink;
  public final float textSize;
  public final int textStyle;
  public final int typeface;
  
  public TextAppearance(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearance);
    this.textSize = localTypedArray.getDimension(R.styleable.TextAppearance_android_textSize, 0.0F);
    this.textColor = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColor);
    this.textColorHint = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColorHint);
    this.textColorLink = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColorLink);
    this.textStyle = localTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, 0);
    this.typeface = localTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
    paramInt = MaterialResources.getIndexWithValue(localTypedArray, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
    this.fontFamilyResourceId = localTypedArray.getResourceId(paramInt, 0);
    this.fontFamily = localTypedArray.getString(paramInt);
    this.textAllCaps = localTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
    this.shadowColor = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.TextAppearance_android_shadowColor);
    this.shadowDx = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    this.shadowDy = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    this.shadowRadius = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTypedArray.recycle();
  }
  
  private void createFallbackTypeface()
  {
    if (this.font == null) {
      this.font = Typeface.create(this.fontFamily, this.textStyle);
    }
    if (this.font == null)
    {
      int i = this.typeface;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            this.font = Typeface.DEFAULT;
          } else {
            this.font = Typeface.MONOSPACE;
          }
        }
        else {
          this.font = Typeface.SERIF;
        }
      }
      else {
        this.font = Typeface.SANS_SERIF;
      }
      Typeface localTypeface = this.font;
      if (localTypeface != null) {
        this.font = Typeface.create(localTypeface, this.textStyle);
      }
    }
  }
  
  public Typeface getFont(Context paramContext)
  {
    if (this.fontResolved) {
      return this.font;
    }
    if (!paramContext.isRestricted()) {}
    try
    {
      try
      {
        paramContext = ResourcesCompat.getFont(paramContext, this.fontFamilyResourceId);
        this.font = paramContext;
        if (paramContext != null) {
          this.font = Typeface.create(paramContext, this.textStyle);
        }
      }
      catch (Exception paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Error loading font ");
        localStringBuilder.append(this.fontFamily);
        Log.d("TextAppearance", localStringBuilder.toString(), paramContext);
      }
    }
    catch (UnsupportedOperationException|Resources.NotFoundException paramContext)
    {
      for (;;) {}
    }
    createFallbackTypeface();
    this.fontResolved = true;
    return this.font;
  }
  
  public void getFontAsync(Context paramContext, final TextPaint paramTextPaint, final ResourcesCompat.FontCallback paramFontCallback)
  {
    if (this.fontResolved)
    {
      updateTextPaintMeasureState(paramTextPaint, this.font);
      return;
    }
    createFallbackTypeface();
    if (paramContext.isRestricted())
    {
      this.fontResolved = true;
      updateTextPaintMeasureState(paramTextPaint, this.font);
      return;
    }
    try
    {
      ResourcesCompat.getFont(paramContext, this.fontFamilyResourceId, new ResourcesCompat.FontCallback()
      {
        public void onFontRetrievalFailed(int paramAnonymousInt)
        {
          TextAppearance.this.createFallbackTypeface();
          TextAppearance.access$102(TextAppearance.this, true);
          paramFontCallback.onFontRetrievalFailed(paramAnonymousInt);
        }
        
        public void onFontRetrieved(Typeface paramAnonymousTypeface)
        {
          TextAppearance localTextAppearance = TextAppearance.this;
          TextAppearance.access$002(localTextAppearance, Typeface.create(paramAnonymousTypeface, localTextAppearance.textStyle));
          TextAppearance.this.updateTextPaintMeasureState(paramTextPaint, paramAnonymousTypeface);
          TextAppearance.access$102(TextAppearance.this, true);
          paramFontCallback.onFontRetrieved(paramAnonymousTypeface);
        }
      }, null);
      return;
    }
    catch (Exception paramContext)
    {
      paramTextPaint = new StringBuilder();
      paramTextPaint.append("Error loading font ");
      paramTextPaint.append(this.fontFamily);
      Log.d("TextAppearance", paramTextPaint.toString(), paramContext);
      return;
    }
    catch (UnsupportedOperationException|Resources.NotFoundException paramContext) {}
  }
  
  public void updateDrawState(Context paramContext, TextPaint paramTextPaint, ResourcesCompat.FontCallback paramFontCallback)
  {
    updateMeasureState(paramContext, paramTextPaint, paramFontCallback);
    paramContext = this.textColor;
    int i;
    if (paramContext != null) {
      i = paramContext.getColorForState(paramTextPaint.drawableState, this.textColor.getDefaultColor());
    } else {
      i = -16777216;
    }
    paramTextPaint.setColor(i);
    float f1 = this.shadowRadius;
    float f2 = this.shadowDx;
    float f3 = this.shadowDy;
    paramContext = this.shadowColor;
    if (paramContext != null) {
      i = paramContext.getColorForState(paramTextPaint.drawableState, this.shadowColor.getDefaultColor());
    } else {
      i = 0;
    }
    paramTextPaint.setShadowLayer(f1, f2, f3, i);
  }
  
  public void updateMeasureState(Context paramContext, TextPaint paramTextPaint, ResourcesCompat.FontCallback paramFontCallback)
  {
    if (TextAppearanceConfig.shouldLoadFontSynchronously())
    {
      updateTextPaintMeasureState(paramTextPaint, getFont(paramContext));
      return;
    }
    getFontAsync(paramContext, paramTextPaint, paramFontCallback);
    if (!this.fontResolved) {
      updateTextPaintMeasureState(paramTextPaint, this.font);
    }
  }
  
  public void updateTextPaintMeasureState(TextPaint paramTextPaint, Typeface paramTypeface)
  {
    paramTextPaint.setTypeface(paramTypeface);
    int i = this.textStyle;
    i = paramTypeface.getStyle() & i;
    boolean bool;
    if ((i & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramTextPaint.setFakeBoldText(bool);
    float f;
    if ((i & 0x2) != 0) {
      f = -0.25F;
    } else {
      f = 0.0F;
    }
    paramTextPaint.setTextSkewX(f);
    paramTextPaint.setTextSize(this.textSize);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\resources\TextAppearance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */