package kotlin.reflect;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\f\n\002\030\002\n\002\020\020\n\002\b\006\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005j\002\b\006¨\006\007"}, d2={"Lkotlin/reflect/KVisibility;", "", "(Ljava/lang/String;I)V", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public enum KVisibility
{
  static
  {
    KVisibility localKVisibility1 = new KVisibility("PUBLIC", 0);
    PUBLIC = localKVisibility1;
    KVisibility localKVisibility2 = new KVisibility("PROTECTED", 1);
    PROTECTED = localKVisibility2;
    KVisibility localKVisibility3 = new KVisibility("INTERNAL", 2);
    INTERNAL = localKVisibility3;
    KVisibility localKVisibility4 = new KVisibility("PRIVATE", 3);
    PRIVATE = localKVisibility4;
    $VALUES = new KVisibility[] { localKVisibility1, localKVisibility2, localKVisibility3, localKVisibility4 };
  }
  
  private KVisibility() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\reflect\KVisibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */