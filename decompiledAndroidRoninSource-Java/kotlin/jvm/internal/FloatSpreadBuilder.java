package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\030\002\n\002\020\024\n\000\n\002\020\b\n\002\b\003\n\002\020\002\n\000\n\002\020\007\n\002\b\003\030\0002\b\022\004\022\0020\0020\001B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\016\020\007\032\0020\b2\006\020\t\032\0020\nJ\006\020\013\032\0020\002J\f\020\f\032\0020\004*\0020\002H\024R\016\020\006\032\0020\002X\004¢\006\002\n\000¨\006\r"}, d2={"Lkotlin/jvm/internal/FloatSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class FloatSpreadBuilder
  extends PrimitiveSpreadBuilder<float[]>
{
  private final float[] values;
  
  public FloatSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new float[paramInt];
  }
  
  public final void add(float paramFloat)
  {
    float[] arrayOfFloat = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfFloat[i] = paramFloat;
  }
  
  protected int getSize(float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$getSize");
    return paramArrayOfFloat.length;
  }
  
  public final float[] toArray()
  {
    return (float[])toArray(this.values, new float[size()]);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\FloatSpreadBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */