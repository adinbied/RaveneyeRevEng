package kotlin.properties;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\020\013\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\036\020\003\032\020\022\006\022\004\030\0010\001\022\004\022\002H\0050\004\"\b\b\000\020\005*\0020\001J}\020\006\032\020\022\006\022\004\030\0010\001\022\004\022\002H\0050\004\"\004\b\000\020\0052\006\020\007\032\002H\0052Q\b\004\020\b\032K\022\027\022\025\022\002\b\0030\n¢\006\f\b\013\022\b\b\f\022\004\b\b(\r\022\023\022\021H\005¢\006\f\b\013\022\b\b\f\022\004\b\b(\016\022\023\022\021H\005¢\006\f\b\013\022\b\b\f\022\004\b\b(\017\022\004\022\0020\0200\tH\b¢\006\002\020\021J}\020\022\032\020\022\006\022\004\030\0010\001\022\004\022\002H\0050\004\"\004\b\000\020\0052\006\020\007\032\002H\0052Q\b\004\020\b\032K\022\027\022\025\022\002\b\0030\n¢\006\f\b\013\022\b\b\f\022\004\b\b(\r\022\023\022\021H\005¢\006\f\b\013\022\b\b\f\022\004\b\b(\016\022\023\022\021H\005¢\006\f\b\013\022\b\b\f\022\004\b\b(\017\022\004\022\0020\0230\tH\b¢\006\002\020\021¨\006\024"}, d2={"Lkotlin/properties/Delegates;", "", "()V", "notNull", "Lkotlin/properties/ReadWriteProperty;", "T", "observable", "initialValue", "onChange", "Lkotlin/Function3;", "Lkotlin/reflect/KProperty;", "Lkotlin/ParameterName;", "name", "property", "oldValue", "newValue", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/properties/ReadWriteProperty;", "vetoable", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class Delegates
{
  public static final Delegates INSTANCE = new Delegates();
  
  public final <T> ReadWriteProperty<Object, T> notNull()
  {
    return (ReadWriteProperty)new NotNullVar();
  }
  
  public final <T> ReadWriteProperty<Object, T> observable(final T paramT, Function3<? super KProperty<?>, ? super T, ? super T, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "onChange");
    (ReadWriteProperty)new ObservableProperty(paramFunction3)
    {
      protected void afterChange(KProperty<?> paramAnonymousKProperty, T paramAnonymousT1, T paramAnonymousT2)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousKProperty, "property");
        this.$onChange.invoke(paramAnonymousKProperty, paramAnonymousT1, paramAnonymousT2);
      }
    };
  }
  
  public final <T> ReadWriteProperty<Object, T> vetoable(final T paramT, Function3<? super KProperty<?>, ? super T, ? super T, Boolean> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "onChange");
    (ReadWriteProperty)new ObservableProperty(paramFunction3)
    {
      protected boolean beforeChange(KProperty<?> paramAnonymousKProperty, T paramAnonymousT1, T paramAnonymousT2)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousKProperty, "property");
        return ((Boolean)this.$onChange.invoke(paramAnonymousKProperty, paramAnonymousT1, paramAnonymousT2)).booleanValue();
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\properties\Delegates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */