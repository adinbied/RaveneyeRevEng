package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\002\b\007\b&\030\000*\004\b\000\020\0012\020\022\006\022\004\030\0010\003\022\004\022\002H\0010\002B\r\022\006\020\004\032\0028\000¢\006\002\020\005J)\020\b\032\0020\t2\n\020\n\032\006\022\002\b\0030\0132\006\020\f\032\0028\0002\006\020\r\032\0028\000H\024¢\006\002\020\016J)\020\017\032\0020\0202\n\020\n\032\006\022\002\b\0030\0132\006\020\f\032\0028\0002\006\020\r\032\0028\000H\024¢\006\002\020\021J$\020\022\032\0028\0002\b\020\023\032\004\030\0010\0032\n\020\n\032\006\022\002\b\0030\013H\002¢\006\002\020\024J,\020\025\032\0020\t2\b\020\023\032\004\030\0010\0032\n\020\n\032\006\022\002\b\0030\0132\006\020\006\032\0028\000H\002¢\006\002\020\026R\020\020\006\032\0028\000X\016¢\006\004\n\002\020\007¨\006\027"}, d2={"Lkotlin/properties/ObservableProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "beforeChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class ObservableProperty<T>
  implements ReadWriteProperty<Object, T>
{
  private T value;
  
  public ObservableProperty(T paramT)
  {
    this.value = paramT;
  }
  
  protected void afterChange(KProperty<?> paramKProperty, T paramT1, T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
  }
  
  protected boolean beforeChange(KProperty<?> paramKProperty, T paramT1, T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    return true;
  }
  
  public T getValue(Object paramObject, KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    return (T)this.value;
  }
  
  public void setValue(Object paramObject, KProperty<?> paramKProperty, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    paramObject = this.value;
    if (!beforeChange(paramKProperty, paramObject, paramT)) {
      return;
    }
    this.value = paramT;
    afterChange(paramKProperty, paramObject, paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\properties\ObservableProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */