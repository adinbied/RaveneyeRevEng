package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflater
{
  private static final int[] Animator = { 16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488 };
  private static final int[] AnimatorSet = { 16843490 };
  private static final int AnimatorSet_ordering = 0;
  private static final int Animator_duration = 1;
  private static final int Animator_interpolator = 0;
  private static final int Animator_repeatCount = 3;
  private static final int Animator_repeatMode = 4;
  private static final int Animator_startOffset = 2;
  private static final int Animator_valueFrom = 5;
  private static final int Animator_valueTo = 6;
  private static final int Animator_valueType = 7;
  private static final int[] PropertyAnimator = { 16843489 };
  private static final int PropertyAnimator_propertyName = 0;
  private static final int TOGETHER = 0;
  private static final int VALUE_TYPE_FLOAT = 0;
  
  private static Animator createAnimatorFromXml(Context paramContext, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    return createAnimatorFromXml(paramContext, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0);
  }
  
  private static Animator createAnimatorFromXml(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt)
    throws XmlPullParserException, IOException
  {
    int k = paramXmlPullParser.getDepth();
    Object localObject2 = null;
    Object localObject3 = localObject2;
    int j;
    int i;
    for (;;)
    {
      int m = paramXmlPullParser.next();
      j = 0;
      i = 0;
      if (((m == 3) && (paramXmlPullParser.getDepth() <= k)) || (m == 1)) {
        break label276;
      }
      if (m == 2)
      {
        Object localObject1 = paramXmlPullParser.getName();
        if (((String)localObject1).equals("objectAnimator"))
        {
          localObject1 = loadObjectAnimator(paramContext, paramAttributeSet);
        }
        else if (((String)localObject1).equals("animator"))
        {
          localObject1 = loadAnimator(paramContext, paramAttributeSet, null);
        }
        else
        {
          if (!((String)localObject1).equals("set")) {
            break;
          }
          localObject1 = new AnimatorSet();
          localObject3 = paramContext.obtainStyledAttributes(paramAttributeSet, AnimatorSet);
          TypedValue localTypedValue = new TypedValue();
          ((TypedArray)localObject3).getValue(0, localTypedValue);
          if (localTypedValue.type == 16) {
            i = localTypedValue.data;
          }
          createAnimatorFromXml(paramContext, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject1, i);
          ((TypedArray)localObject3).recycle();
        }
        localObject3 = localObject1;
        if (paramAnimatorSet != null)
        {
          localObject3 = localObject2;
          if (localObject2 == null) {
            localObject3 = new ArrayList();
          }
          ((ArrayList)localObject3).add(localObject1);
          localObject2 = localObject3;
          localObject3 = localObject1;
        }
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("Unknown animator name: ");
    paramContext.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramContext.toString());
    label276:
    if ((paramAnimatorSet != null) && (localObject2 != null))
    {
      paramContext = new Animator[((ArrayList)localObject2).size()];
      paramXmlPullParser = ((ArrayList)localObject2).iterator();
      i = j;
      while (paramXmlPullParser.hasNext())
      {
        paramContext[i] = ((Animator)paramXmlPullParser.next());
        i += 1;
      }
      if (paramInt == 0)
      {
        paramAnimatorSet.playTogether(paramContext);
        return (Animator)localObject3;
      }
      paramAnimatorSet.playSequentially(paramContext);
    }
    return (Animator)localObject3;
  }
  
  /* Error */
  public static Animator loadAnimator(Context paramContext, int paramInt)
    throws Resources.NotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: invokevirtual 182	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: iload_1
    //   12: invokevirtual 188	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   15: astore 5
    //   17: aload 5
    //   19: astore_2
    //   20: aload 5
    //   22: astore_3
    //   23: aload 5
    //   25: astore 4
    //   27: aload_0
    //   28: aload 5
    //   30: invokestatic 190	com/nineoldandroids/animation/AnimatorInflater:createAnimatorFromXml	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)Lcom/nineoldandroids/animation/Animator;
    //   33: astore_0
    //   34: aload 5
    //   36: ifnull +10 -> 46
    //   39: aload 5
    //   41: invokeinterface 195 1 0
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: goto +130 -> 179
    //   52: astore_0
    //   53: aload_3
    //   54: astore_2
    //   55: new 135	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: aload_3
    //   65: astore_2
    //   66: aload 4
    //   68: ldc -59
    //   70: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_3
    //   75: astore_2
    //   76: aload 4
    //   78: iload_1
    //   79: invokestatic 203	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   82: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: astore_2
    //   88: new 178	android/content/res/Resources$NotFoundException
    //   91: dup
    //   92: aload 4
    //   94: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 204	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   100: astore 4
    //   102: aload_3
    //   103: astore_2
    //   104: aload 4
    //   106: aload_0
    //   107: invokevirtual 208	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   110: pop
    //   111: aload_3
    //   112: astore_2
    //   113: aload 4
    //   115: athrow
    //   116: astore_0
    //   117: aload 4
    //   119: astore_2
    //   120: new 135	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   127: astore_3
    //   128: aload 4
    //   130: astore_2
    //   131: aload_3
    //   132: ldc -59
    //   134: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 4
    //   140: astore_2
    //   141: aload_3
    //   142: iload_1
    //   143: invokestatic 203	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   146: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 4
    //   152: astore_2
    //   153: new 178	android/content/res/Resources$NotFoundException
    //   156: dup
    //   157: aload_3
    //   158: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 204	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   164: astore_3
    //   165: aload 4
    //   167: astore_2
    //   168: aload_3
    //   169: aload_0
    //   170: invokevirtual 208	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   173: pop
    //   174: aload 4
    //   176: astore_2
    //   177: aload_3
    //   178: athrow
    //   179: aload_2
    //   180: ifnull +9 -> 189
    //   183: aload_2
    //   184: invokeinterface 195 1 0
    //   189: aload_0
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramContext	Context
    //   0	191	1	paramInt	int
    //   6	178	2	localObject1	Object
    //   1	177	3	localObject2	Object
    //   3	172	4	localObject3	Object
    //   15	25	5	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   7	17	48	finally
    //   27	34	48	finally
    //   55	64	48	finally
    //   66	74	48	finally
    //   76	86	48	finally
    //   88	102	48	finally
    //   104	111	48	finally
    //   113	116	48	finally
    //   120	128	48	finally
    //   131	138	48	finally
    //   141	150	48	finally
    //   153	165	48	finally
    //   168	174	48	finally
    //   177	179	48	finally
    //   7	17	52	java/io/IOException
    //   27	34	52	java/io/IOException
    //   7	17	116	org/xmlpull/v1/XmlPullParserException
    //   27	34	116	org/xmlpull/v1/XmlPullParserException
  }
  
  private static ValueAnimator loadAnimator(Context paramContext, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator)
    throws Resources.NotFoundException
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Animator);
    long l1 = localTypedArray.getInt(1, 0);
    long l2 = localTypedArray.getInt(2, 0);
    int i = localTypedArray.getInt(7, 0);
    if (paramValueAnimator == null) {
      paramAttributeSet = new ValueAnimator();
    } else {
      paramAttributeSet = paramValueAnimator;
    }
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramValueAnimator = localTypedArray.peekValue(5);
    int j;
    if (paramValueAnimator != null) {
      j = 1;
    } else {
      j = 0;
    }
    int m;
    if (j != 0) {
      m = paramValueAnimator.type;
    } else {
      m = 0;
    }
    paramValueAnimator = localTypedArray.peekValue(6);
    int k;
    if (paramValueAnimator != null) {
      k = 1;
    } else {
      k = 0;
    }
    int n;
    if (k != 0) {
      n = paramValueAnimator.type;
    } else {
      n = 0;
    }
    int i1;
    if ((j == 0) || (m < 28) || (m > 31))
    {
      i1 = i;
      if (k != 0)
      {
        i1 = i;
        if (n >= 28)
        {
          i1 = i;
          if (n > 31) {}
        }
      }
    }
    else
    {
      paramAttributeSet.setEvaluator(new ArgbEvaluator());
      i1 = 0;
    }
    if (i1 != 0)
    {
      float f1;
      if (j != 0)
      {
        if (m == 5) {
          f1 = localTypedArray.getDimension(5, 0.0F);
        } else {
          f1 = localTypedArray.getFloat(5, 0.0F);
        }
        if (k != 0)
        {
          float f2;
          if (n == 5) {
            f2 = localTypedArray.getDimension(6, 0.0F);
          } else {
            f2 = localTypedArray.getFloat(6, 0.0F);
          }
          paramAttributeSet.setFloatValues(new float[] { f1, f2 });
        }
        else
        {
          paramAttributeSet.setFloatValues(new float[] { f1 });
        }
      }
      else
      {
        if (n == 5) {
          f1 = localTypedArray.getDimension(6, 0.0F);
        } else {
          f1 = localTypedArray.getFloat(6, 0.0F);
        }
        paramAttributeSet.setFloatValues(new float[] { f1 });
      }
    }
    else if (j != 0)
    {
      if (m == 5) {
        i = (int)localTypedArray.getDimension(5, 0.0F);
      } else if ((m >= 28) && (m <= 31)) {
        i = localTypedArray.getColor(5, 0);
      } else {
        i = localTypedArray.getInt(5, 0);
      }
      if (k != 0)
      {
        if (n == 5) {
          j = (int)localTypedArray.getDimension(6, 0.0F);
        } else if ((n >= 28) && (n <= 31)) {
          j = localTypedArray.getColor(6, 0);
        } else {
          j = localTypedArray.getInt(6, 0);
        }
        paramAttributeSet.setIntValues(new int[] { i, j });
      }
      else
      {
        paramAttributeSet.setIntValues(new int[] { i });
      }
    }
    else if (k != 0)
    {
      if (n == 5) {
        i = (int)localTypedArray.getDimension(6, 0.0F);
      }
      for (;;)
      {
        break;
        if ((n >= 28) && (n <= 31)) {
          i = localTypedArray.getColor(6, 0);
        } else {
          i = localTypedArray.getInt(6, 0);
        }
      }
      paramAttributeSet.setIntValues(new int[] { i });
    }
    paramAttributeSet.setDuration(l1);
    paramAttributeSet.setStartDelay(l2);
    if (localTypedArray.hasValue(3)) {
      paramAttributeSet.setRepeatCount(localTypedArray.getInt(3, 0));
    }
    if (localTypedArray.hasValue(4)) {
      paramAttributeSet.setRepeatMode(localTypedArray.getInt(4, 1));
    }
    i = localTypedArray.getResourceId(0, 0);
    if (i > 0) {
      paramAttributeSet.setInterpolator(AnimationUtils.loadInterpolator(paramContext, i));
    }
    localTypedArray.recycle();
    return paramAttributeSet;
  }
  
  private static ObjectAnimator loadObjectAnimator(Context paramContext, AttributeSet paramAttributeSet)
    throws Resources.NotFoundException
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    loadAnimator(paramContext, paramAttributeSet, localObjectAnimator);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, PropertyAnimator);
    localObjectAnimator.setPropertyName(paramContext.getString(0));
    paramContext.recycle();
    return localObjectAnimator;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroids\animation\AnimatorInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */