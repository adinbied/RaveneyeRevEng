package kotlin.properties;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\b\002\n\002\020\000\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\bf\030\000*\006\b\000\020\001 \000*\004\b\001\020\0022\0020\003J\"\020\004\032\0028\0012\006\020\005\032\0028\0002\n\020\006\032\006\022\002\b\0030\007H¦\002¢\006\002\020\bJ*\020\t\032\0020\n2\006\020\005\032\0028\0002\n\020\006\032\006\022\002\b\0030\0072\006\020\013\032\0028\001H¦\002¢\006\002\020\f¨\006\r"}, d2={"Lkotlin/properties/ReadWriteProperty;", "R", "T", "", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface ReadWriteProperty<R, T>
{
  public abstract T getValue(R paramR, KProperty<?> paramKProperty);
  
  public abstract void setValue(R paramR, KProperty<?> paramKProperty, T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\properties\ReadWriteProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */