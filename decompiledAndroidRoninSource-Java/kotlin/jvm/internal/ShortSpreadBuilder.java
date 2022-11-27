package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\030\002\n\002\020\027\n\000\n\002\020\b\n\002\b\003\n\002\020\002\n\000\n\002\020\n\n\002\b\003\030\0002\b\022\004\022\0020\0020\001B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\016\020\007\032\0020\b2\006\020\t\032\0020\nJ\006\020\013\032\0020\002J\f\020\f\032\0020\004*\0020\002H\024R\016\020\006\032\0020\002X\004¢\006\002\n\000¨\006\r"}, d2={"Lkotlin/jvm/internal/ShortSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class ShortSpreadBuilder
  extends PrimitiveSpreadBuilder<short[]>
{
  private final short[] values;
  
  public ShortSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new short[paramInt];
  }
  
  public final void add(short paramShort)
  {
    short[] arrayOfShort = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfShort[i] = paramShort;
  }
  
  protected int getSize(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$getSize");
    return paramArrayOfShort.length;
  }
  
  public final short[] toArray()
  {
    return (short[])toArray(this.values, new short[size()]);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\ShortSpreadBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */