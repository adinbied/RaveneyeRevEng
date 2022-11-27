package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareBy.2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareByDescending.1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={"\000\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\034\n\002\b\002\n\002\020$\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020%\n\002\b\b\n\002\020\006\n\002\020\005\n\002\b\002\n\002\020\007\n\000\n\002\020\b\n\000\n\002\020\t\n\000\n\002\020\n\n\002\b\002\n\002\020 \n\002\b\003\n\002\030\002\n\002\b\022\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\037\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020\000\n\002\b\022\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\004\n\002\020!\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\r\n\002\b\006\n\002\020\016\n\002\b\f\n\002\020\017\n\002\b\006\n\002\030\002\n\002\030\002\n\002\b\007\n\002\020\021\n\002\b!\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020#\n\000\n\002\020\"\n\002\b\004\n\002\030\002\n\002\b\006\032-\020\000\032\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b\032\026\020\006\032\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032-\020\006\032\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b\032\034\020\007\032\b\022\004\022\002H\0020\b\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032\037\020\t\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\003H\b\032Q\020\n\032\016\022\004\022\002H\f\022\004\022\002H\r0\013\"\004\b\000\020\002\"\004\b\001\020\f\"\004\b\002\020\r*\b\022\004\022\002H\0020\0032\036\020\016\032\032\022\004\022\002H\002\022\020\022\016\022\004\022\002H\f\022\004\022\002H\r0\0170\005H\b\032?\020\020\032\016\022\004\022\002H\f\022\004\022\002H\0020\013\"\004\b\000\020\002\"\004\b\001\020\f*\b\022\004\022\002H\0020\0032\022\020\021\032\016\022\004\022\002H\002\022\004\022\002H\f0\005H\b\032Y\020\020\032\016\022\004\022\002H\f\022\004\022\002H\r0\013\"\004\b\000\020\002\"\004\b\001\020\f\"\004\b\002\020\r*\b\022\004\022\002H\0020\0032\022\020\021\032\016\022\004\022\002H\002\022\004\022\002H\f0\0052\022\020\022\032\016\022\004\022\002H\002\022\004\022\002H\r0\005H\b\032Z\020\023\032\002H\024\"\004\b\000\020\002\"\004\b\001\020\f\"\030\b\002\020\024*\022\022\006\b\000\022\002H\f\022\006\b\000\022\002H\0020\025*\b\022\004\022\002H\0020\0032\006\020\026\032\002H\0242\022\020\021\032\016\022\004\022\002H\002\022\004\022\002H\f0\005H\b¢\006\002\020\027\032t\020\023\032\002H\024\"\004\b\000\020\002\"\004\b\001\020\f\"\004\b\002\020\r\"\030\b\003\020\024*\022\022\006\b\000\022\002H\f\022\006\b\000\022\002H\r0\025*\b\022\004\022\002H\0020\0032\006\020\026\032\002H\0242\022\020\021\032\016\022\004\022\002H\002\022\004\022\002H\f0\0052\022\020\022\032\016\022\004\022\002H\002\022\004\022\002H\r0\005H\b¢\006\002\020\030\032l\020\031\032\002H\024\"\004\b\000\020\002\"\004\b\001\020\f\"\004\b\002\020\r\"\030\b\003\020\024*\022\022\006\b\000\022\002H\f\022\006\b\000\022\002H\r0\025*\b\022\004\022\002H\0020\0032\006\020\026\032\002H\0242\036\020\016\032\032\022\004\022\002H\002\022\020\022\016\022\004\022\002H\f\022\004\022\002H\r0\0170\005H\b¢\006\002\020\027\032?\020\032\032\016\022\004\022\002H\f\022\004\022\002H\r0\013\"\004\b\000\020\f\"\004\b\001\020\r*\b\022\004\022\002H\f0\0032\022\020\033\032\016\022\004\022\002H\f\022\004\022\002H\r0\005H\b\032Z\020\034\032\002H\024\"\004\b\000\020\f\"\004\b\001\020\r\"\030\b\002\020\024*\022\022\006\b\000\022\002H\f\022\006\b\000\022\002H\r0\025*\b\022\004\022\002H\f0\0032\006\020\026\032\002H\0242\022\020\033\032\016\022\004\022\002H\f\022\004\022\002H\r0\005H\b¢\006\002\020\027\032\027\020\035\032\0020\036*\b\022\004\022\0020\0370\003H\007¢\006\002\b \032\027\020\035\032\0020\036*\b\022\004\022\0020\0360\003H\007¢\006\002\b!\032\027\020\035\032\0020\036*\b\022\004\022\0020\"0\003H\007¢\006\002\b#\032\027\020\035\032\0020\036*\b\022\004\022\0020$0\003H\007¢\006\002\b%\032\027\020\035\032\0020\036*\b\022\004\022\0020&0\003H\007¢\006\002\b'\032\027\020\035\032\0020\036*\b\022\004\022\0020(0\003H\007¢\006\002\b)\032,\020*\032\016\022\n\022\b\022\004\022\002H\0020+0\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020,\032\0020$H\007\032F\020*\032\b\022\004\022\002H-0\003\"\004\b\000\020\002\"\004\b\001\020-*\b\022\004\022\002H\0020\0032\006\020,\032\0020$2\030\020\016\032\024\022\n\022\b\022\004\022\002H\0020+\022\004\022\002H-0\005H\007\032+\020.\032\0020\001\"\t\b\000\020\002¢\006\002\b/*\b\022\004\022\002H\0020\0032\006\0200\032\002H\002H\002¢\006\002\0201\032\026\0202\032\0020$\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032-\0202\032\0020$\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b\032\034\0203\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\0326\0204\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002\"\004\b\001\020\f*\b\022\004\022\002H\0020\0032\022\0205\032\016\022\004\022\002H\002\022\004\022\002H\f0\005\032$\0206\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\0207\032\0020$\0320\0208\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005\032#\0209\032\002H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020:\032\0020$¢\006\002\020;\0327\020<\032\002H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020:\032\0020$2\022\020=\032\016\022\004\022\0020$\022\004\022\002H\0020\005¢\006\002\020>\032%\020?\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020:\032\0020$¢\006\002\020;\0320\020@\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005\032E\020A\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032'\020\004\032#\022\023\022\0210$¢\006\f\bC\022\b\bD\022\004\b\b(:\022\004\022\002H\002\022\004\022\0020\0010B\032a\020E\032\002HF\"\004\b\000\020\002\"\020\b\001\020F*\n\022\006\b\000\022\002H\0020G*\b\022\004\022\002H\0020\0032\006\020\026\032\002HF2'\020\004\032#\022\023\022\0210$¢\006\f\bC\022\b\bD\022\004\b\b(:\022\004\022\002H\002\022\004\022\0020\0010BH\b¢\006\002\020H\032$\020I\032\r\022\t\022\007H-¢\006\002\bJ0\003\"\006\b\000\020-\030\001*\006\022\002\b\0030\003H\b\0328\020K\032\002HF\"\006\b\000\020-\030\001\"\020\b\001\020F*\n\022\006\b\000\022\002H-0G*\006\022\002\b\0030\0032\006\020\026\032\002HFH\b¢\006\002\020L\0320\020M\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005\032\"\020N\032\b\022\004\022\002H\0020\003\"\b\b\000\020\002*\0020O*\n\022\006\022\004\030\001H\0020\003\032;\020P\032\002HF\"\020\b\000\020F*\n\022\006\b\000\022\002H\0020G\"\b\b\001\020\002*\0020O*\n\022\006\022\004\030\001H\0020\0032\006\020\026\032\002HF¢\006\002\020L\032L\020Q\032\002HF\"\004\b\000\020\002\"\020\b\001\020F*\n\022\006\b\000\022\002H\0020G*\b\022\004\022\002H\0020\0032\006\020\026\032\002HF2\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020R\032L\020S\032\002HF\"\004\b\000\020\002\"\020\b\001\020F*\n\022\006\b\000\022\002H\0020G*\b\022\004\022\002H\0020\0032\006\020\026\032\002HF2\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020R\0324\020T\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020U\0324\020V\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020U\032\033\020W\032\002H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\003¢\006\002\020X\0322\020W\032\002H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020U\032\035\020Y\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\003¢\006\002\020X\0324\020Y\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020U\032<\020Z\032\b\022\004\022\002H-0\003\"\004\b\000\020\002\"\004\b\001\020-*\b\022\004\022\002H\0020\0032\030\020\016\032\024\022\004\022\002H\002\022\n\022\b\022\004\022\002H-0\0030\005\032X\020[\032\002HF\"\004\b\000\020\002\"\004\b\001\020-\"\020\b\002\020F*\n\022\006\b\000\022\002H-0G*\b\022\004\022\002H\0020\0032\006\020\026\032\002HF2\030\020\016\032\024\022\004\022\002H\002\022\n\022\b\022\004\022\002H-0\0030\005H\b¢\006\002\020R\032U\020\\\032\002H-\"\004\b\000\020\002\"\004\b\001\020-*\b\022\004\022\002H\0020\0032\006\020]\032\002H-2'\020^\032#\022\023\022\021H-¢\006\f\bC\022\b\bD\022\004\b\b(_\022\004\022\002H\002\022\004\022\002H-0BH\b¢\006\002\020`\032j\020a\032\002H-\"\004\b\000\020\002\"\004\b\001\020-*\b\022\004\022\002H\0020\0032\006\020]\032\002H-2<\020^\0328\022\023\022\0210$¢\006\f\bC\022\b\bD\022\004\b\b(:\022\023\022\021H-¢\006\f\bC\022\b\bD\022\004\b\b(_\022\004\022\002H\002\022\004\022\002H-0bH\b¢\006\002\020c\032-\020d\032\0020e\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020f\032\016\022\004\022\002H\002\022\004\022\0020e0\005H\b\032B\020g\032\0020e\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032'\020f\032#\022\023\022\0210$¢\006\f\bC\022\b\bD\022\004\b\b(:\022\004\022\002H\002\022\004\022\0020e0BH\b\032E\020h\032\024\022\004\022\002H\f\022\n\022\b\022\004\022\002H\0020+0\013\"\004\b\000\020\002\"\004\b\001\020\f*\b\022\004\022\002H\0020\0032\022\020\021\032\016\022\004\022\002H\002\022\004\022\002H\f0\005H\b\032_\020h\032\024\022\004\022\002H\f\022\n\022\b\022\004\022\002H\r0+0\013\"\004\b\000\020\002\"\004\b\001\020\f\"\004\b\002\020\r*\b\022\004\022\002H\0020\0032\022\020\021\032\016\022\004\022\002H\002\022\004\022\002H\f0\0052\022\020\022\032\016\022\004\022\002H\002\022\004\022\002H\r0\005H\b\032^\020i\032\002H\024\"\004\b\000\020\002\"\004\b\001\020\f\"\034\b\002\020\024*\026\022\006\b\000\022\002H\f\022\n\022\b\022\004\022\002H\0020j0\025*\b\022\004\022\002H\0020\0032\006\020\026\032\002H\0242\022\020\021\032\016\022\004\022\002H\002\022\004\022\002H\f0\005H\b¢\006\002\020\027\032x\020i\032\002H\024\"\004\b\000\020\002\"\004\b\001\020\f\"\004\b\002\020\r\"\034\b\003\020\024*\026\022\006\b\000\022\002H\f\022\n\022\b\022\004\022\002H\r0j0\025*\b\022\004\022\002H\0020\0032\006\020\026\032\002H\0242\022\020\021\032\016\022\004\022\002H\002\022\004\022\002H\f0\0052\022\020\022\032\016\022\004\022\002H\002\022\004\022\002H\r0\005H\b¢\006\002\020\030\032A\020k\032\016\022\004\022\002H\002\022\004\022\002H\f0l\"\004\b\000\020\002\"\004\b\001\020\f*\b\022\004\022\002H\0020\0032\024\b\004\020\021\032\016\022\004\022\002H\002\022\004\022\002H\f0\005H\b\032(\020m\032\0020$\"\t\b\000\020\002¢\006\002\b/*\b\022\004\022\002H\0020\0032\006\0200\032\002H\002¢\006\002\020n\032-\020o\032\0020$\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b\032-\020p\032\0020$\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b\032{\020q\032\002Hr\"\004\b\000\020\002\"\f\b\001\020r*\0060sj\002`t*\b\022\004\022\002H\0020\0032\006\020u\032\002Hr2\b\b\002\020v\032\0020w2\b\b\002\020x\032\0020w2\b\b\002\020y\032\0020w2\b\b\002\020z\032\0020$2\b\b\002\020{\032\0020w2\026\b\002\020\016\032\020\022\004\022\002H\002\022\004\022\0020w\030\0010\005¢\006\002\020|\032`\020}\032\0020~\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\b\b\002\020v\032\0020w2\b\b\002\020x\032\0020w2\b\b\002\020y\032\0020w2\b\b\002\020z\032\0020$2\b\b\002\020{\032\0020w2\026\b\002\020\016\032\020\022\004\022\002H\002\022\004\022\0020w\030\0010\005\032\033\020\032\002H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\003¢\006\002\020X\0322\020\032\002H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020U\032)\020\001\032\0020$\"\t\b\000\020\002¢\006\002\b/*\b\022\004\022\002H\0020\0032\006\0200\032\002H\002¢\006\002\020n\032\036\020\001\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\003¢\006\002\020X\0325\020\001\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020U\0327\020\001\032\b\022\004\022\002H-0\003\"\004\b\000\020\002\"\004\b\001\020-*\b\022\004\022\002H\0020\0032\022\020\016\032\016\022\004\022\002H\002\022\004\022\002H-0\005\032L\020\001\032\b\022\004\022\002H-0\003\"\004\b\000\020\002\"\004\b\001\020-*\b\022\004\022\002H\0020\0032'\020\016\032#\022\023\022\0210$¢\006\f\bC\022\b\bD\022\004\b\b(:\022\004\022\002H\002\022\004\022\002H-0B\032R\020\001\032\b\022\004\022\002H-0\003\"\004\b\000\020\002\"\b\b\001\020-*\0020O*\b\022\004\022\002H\0020\0032)\020\016\032%\022\023\022\0210$¢\006\f\bC\022\b\bD\022\004\b\b(:\022\004\022\002H\002\022\006\022\004\030\001H-0B\032n\020\001\032\002HF\"\004\b\000\020\002\"\b\b\001\020-*\0020O\"\020\b\002\020F*\n\022\006\b\000\022\002H-0G*\b\022\004\022\002H\0020\0032\006\020\026\032\002HF2)\020\016\032%\022\023\022\0210$¢\006\f\bC\022\b\bD\022\004\b\b(:\022\004\022\002H\002\022\006\022\004\030\001H-0BH\b¢\006\002\020H\032h\020\001\032\002HF\"\004\b\000\020\002\"\004\b\001\020-\"\020\b\002\020F*\n\022\006\b\000\022\002H-0G*\b\022\004\022\002H\0020\0032\006\020\026\032\002HF2'\020\016\032#\022\023\022\0210$¢\006\f\bC\022\b\bD\022\004\b\b(:\022\004\022\002H\002\022\004\022\002H-0BH\b¢\006\002\020H\032=\020\001\032\b\022\004\022\002H-0\003\"\004\b\000\020\002\"\b\b\001\020-*\0020O*\b\022\004\022\002H\0020\0032\024\020\016\032\020\022\004\022\002H\002\022\006\022\004\030\001H-0\005\032Y\020\001\032\002HF\"\004\b\000\020\002\"\b\b\001\020-*\0020O\"\020\b\002\020F*\n\022\006\b\000\022\002H-0G*\b\022\004\022\002H\0020\0032\006\020\026\032\002HF2\024\020\016\032\020\022\004\022\002H\002\022\006\022\004\030\001H-0\005H\b¢\006\002\020R\032S\020\001\032\002HF\"\004\b\000\020\002\"\004\b\001\020-\"\020\b\002\020F*\n\022\006\b\000\022\002H-0G*\b\022\004\022\002H\0020\0032\006\020\026\032\002HF2\022\020\016\032\016\022\004\022\002H\002\022\004\022\002H-0\005H\b¢\006\002\020R\032*\020\001\032\004\030\001H\002\"\017\b\000\020\002*\t\022\004\022\002H\0020\001*\b\022\004\022\002H\0020\003¢\006\003\020\001\032\033\020\001\032\004\030\0010\036*\b\022\004\022\0020\0360\003H\007¢\006\003\020\001\032\033\020\001\032\004\030\0010\"*\b\022\004\022\0020\"0\003H\007¢\006\003\020\001\032F\020\001\032\004\030\001H\002\"\004\b\000\020\002\"\017\b\001\020-*\t\022\004\022\002H-0\001*\b\022\004\022\002H\0020\0032\022\0205\032\016\022\004\022\002H\002\022\004\022\002H-0\005H\b¢\006\002\020U\032>\020\001\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\035\020\001\032\030\022\006\b\000\022\002H\0020\001j\013\022\006\b\000\022\002H\002`\001¢\006\003\020\001\032*\020\001\032\004\030\001H\002\"\017\b\000\020\002*\t\022\004\022\002H\0020\001*\b\022\004\022\002H\0020\003¢\006\003\020\001\032\033\020\001\032\004\030\0010\036*\b\022\004\022\0020\0360\003H\007¢\006\003\020\001\032\033\020\001\032\004\030\0010\"*\b\022\004\022\0020\"0\003H\007¢\006\003\020\001\032F\020\001\032\004\030\001H\002\"\004\b\000\020\002\"\017\b\001\020-*\t\022\004\022\002H-0\001*\b\022\004\022\002H\0020\0032\022\0205\032\016\022\004\022\002H\002\022\004\022\002H-0\005H\b¢\006\002\020U\032>\020\001\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\035\020\001\032\030\022\006\b\000\022\002H\0020\001j\013\022\006\b\000\022\002H\002`\001¢\006\003\020\001\032.\020\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\0200\032\002H\002H\002¢\006\003\020\001\0328\020\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\020\020\001\032\013\022\006\b\001\022\002H\0020\001H\002¢\006\003\020\001\032/\020\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\r\020\001\032\b\022\004\022\002H\0020\bH\002\032/\020\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\r\020\001\032\b\022\004\022\002H\0020\003H\002\032.\020\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\0200\032\002H\002H\b¢\006\003\020\001\032\027\020\001\032\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032.\020\001\032\0020\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b\0323\020\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020f\032\016\022\004\022\002H\002\022\004\022\0020e0\005H\007\032F\020 \001\032\032\022\n\022\b\022\004\022\002H\0020+\022\n\022\b\022\004\022\002H\0020+0\017\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b\032.\020¡\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\0200\032\002H\002H\002¢\006\003\020\001\0328\020¡\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\020\020\001\032\013\022\006\b\001\022\002H\0020\001H\002¢\006\003\020\001\032/\020¡\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\r\020\001\032\b\022\004\022\002H\0020\bH\002\032/\020¡\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\r\020\001\032\b\022\004\022\002H\0020\003H\002\032.\020¢\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\0200\032\002H\002H\b¢\006\003\020\001\032X\020£\001\032\003H¤\001\"\005\b\000\020¤\001\"\t\b\001\020\002*\003H¤\001*\b\022\004\022\002H\0020\0032)\020^\032%\022\024\022\022H¤\001¢\006\f\bC\022\b\bD\022\004\b\b(_\022\004\022\002H\002\022\005\022\003H¤\0010BH\b¢\006\003\020¥\001\032m\020¦\001\032\003H¤\001\"\005\b\000\020¤\001\"\t\b\001\020\002*\003H¤\001*\b\022\004\022\002H\0020\0032>\020^\032:\022\023\022\0210$¢\006\f\bC\022\b\bD\022\004\b\b(:\022\024\022\022H¤\001¢\006\f\bC\022\b\bD\022\004\b\b(_\022\004\022\002H\002\022\005\022\003H¤\0010bH\b¢\006\003\020§\001\032#\020¨\001\032\b\022\004\022\002H\0020\003\"\b\b\000\020\002*\0020O*\n\022\006\022\004\030\001H\0020\003\032\034\020©\001\032\002H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\003¢\006\002\020X\0323\020©\001\032\002H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020U\032\036\020ª\001\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\003¢\006\002\020X\0325\020ª\001\032\004\030\001H\002\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005H\b¢\006\002\020U\032(\020«\001\032\b\022\004\022\002H\0020\003\"\017\b\000\020\002*\t\022\004\022\002H\0020\001*\b\022\004\022\002H\0020\003\032I\020¬\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002\"\017\b\001\020-*\t\022\004\022\002H-0\001*\b\022\004\022\002H\0020\0032\026\b\004\0205\032\020\022\004\022\002H\002\022\006\022\004\030\001H-0\005H\b\032I\020­\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002\"\017\b\001\020-*\t\022\004\022\002H-0\001*\b\022\004\022\002H\0020\0032\026\b\004\0205\032\020\022\004\022\002H\002\022\006\022\004\030\001H-0\005H\b\032(\020®\001\032\b\022\004\022\002H\0020\003\"\017\b\000\020\002*\t\022\004\022\002H\0020\001*\b\022\004\022\002H\0020\003\032<\020¯\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\035\020\001\032\030\022\006\b\000\022\002H\0020\001j\013\022\006\b\000\022\002H\002`\001\032\031\020°\001\032\0020$*\b\022\004\022\0020\0370\003H\007¢\006\003\b±\001\032\031\020°\001\032\0020\036*\b\022\004\022\0020\0360\003H\007¢\006\003\b²\001\032\031\020°\001\032\0020\"*\b\022\004\022\0020\"0\003H\007¢\006\003\b³\001\032\031\020°\001\032\0020$*\b\022\004\022\0020$0\003H\007¢\006\003\b´\001\032\031\020°\001\032\0020&*\b\022\004\022\0020&0\003H\007¢\006\003\bµ\001\032\031\020°\001\032\0020$*\b\022\004\022\0020(0\003H\007¢\006\003\b¶\001\032.\020·\001\032\0020$\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\0205\032\016\022\004\022\002H\002\022\004\022\0020$0\005H\b\032.\020¸\001\032\0020\036\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\0205\032\016\022\004\022\002H\002\022\004\022\0020\0360\005H\b\032%\020¹\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\0207\032\0020$\0321\020º\001\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\0020\0010\005\0326\020»\001\032\002HF\"\004\b\000\020\002\"\020\b\001\020F*\n\022\006\b\000\022\002H\0020G*\b\022\004\022\002H\0020\0032\006\020\026\032\002HF¢\006\002\020L\032)\020¼\001\032\024\022\004\022\002H\0020½\001j\t\022\004\022\002H\002`¾\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032\035\020¿\001\032\b\022\004\022\002H\0020+\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032\035\020À\001\032\b\022\004\022\002H\0020j\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032\036\020Á\001\032\t\022\004\022\002H\0020Â\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032\036\020Ã\001\032\t\022\004\022\002H\0020Ä\001\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032C\020Å\001\032\016\022\n\022\b\022\004\022\002H\0020+0\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020,\032\0020$2\t\b\002\020Æ\001\032\0020$2\t\b\002\020Ç\001\032\0020\001H\007\032]\020Å\001\032\b\022\004\022\002H-0\003\"\004\b\000\020\002\"\004\b\001\020-*\b\022\004\022\002H\0020\0032\006\020,\032\0020$2\t\b\002\020Æ\001\032\0020$2\t\b\002\020Ç\001\032\0020\0012\030\020\016\032\024\022\n\022\b\022\004\022\002H\0020+\022\004\022\002H-0\005H\007\032$\020È\001\032\017\022\013\022\t\022\004\022\002H\0020É\0010\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\003\032A\020Ê\001\032\024\022\020\022\016\022\004\022\002H\002\022\004\022\002H-0\0170\003\"\004\b\000\020\002\"\004\b\001\020-*\b\022\004\022\002H\0020\0032\r\020Ë\001\032\b\022\004\022\002H-0\003H\004\032r\020Ê\001\032\b\022\004\022\002H\r0\003\"\004\b\000\020\002\"\004\b\001\020-\"\004\b\002\020\r*\b\022\004\022\002H\0020\0032\r\020Ë\001\032\b\022\004\022\002H-0\00328\020\016\0324\022\024\022\022H\002¢\006\r\bC\022\t\bD\022\005\b\b(Ì\001\022\024\022\022H-¢\006\r\bC\022\t\bD\022\005\b\b(Í\001\022\004\022\002H\r0B\032+\020Î\001\032\024\022\020\022\016\022\004\022\002H\002\022\004\022\002H\0020\0170\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\003H\007\032_\020Î\001\032\b\022\004\022\002H-0\003\"\004\b\000\020\002\"\004\b\001\020-*\b\022\004\022\002H\0020\00328\020\016\0324\022\024\022\022H\002¢\006\r\bC\022\t\bD\022\005\b\b(Ì\001\022\024\022\022H\002¢\006\r\bC\022\t\bD\022\005\b\b(Í\001\022\004\022\002H-0BH\007¨\006Ï\001"}, d2={"all", "", "T", "Lkotlin/sequences/Sequence;", "predicate", "Lkotlin/Function1;", "any", "asIterable", "", "asSequence", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "average", "", "", "averageOfByte", "averageOfDouble", "", "averageOfFloat", "", "averageOfInt", "", "averageOfLong", "", "averageOfShort", "chunked", "", "size", "R", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Z", "count", "distinct", "distinctBy", "selector", "drop", "n", "dropWhile", "elementAt", "index", "(Lkotlin/sequences/Sequence;I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Lkotlin/sequences/Sequence;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "findLast", "first", "(Lkotlin/sequences/Sequence;)Ljava/lang/Object;", "firstOrNull", "flatMap", "flatMapTo", "fold", "initial", "operation", "acc", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "forEach", "", "action", "forEachIndexed", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOf", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "(Lkotlin/sequences/Sequence;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "maxBy", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "minus", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "elements", "", "(Lkotlin/sequences/Sequence;[Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "minusElement", "none", "onEach", "partition", "plus", "plusElement", "reduce", "S", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "requireNoNulls", "single", "singleOrNull", "sorted", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "sum", "sumOfByte", "sumOfDouble", "sumOfFloat", "sumOfInt", "sumOfLong", "sumOfShort", "sumBy", "sumByDouble", "take", "takeWhile", "toCollection", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toMutableSet", "", "toSet", "", "windowed", "step", "partialWindows", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/sequences/SequencesKt")
class SequencesKt___SequencesKt
  extends SequencesKt___SequencesJvmKt
{
  public static final <T> boolean all(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      if (!((Boolean)paramFunction1.invoke(paramSequence.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  public static final <T> boolean any(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$any");
    return paramSequence.iterator().hasNext();
  }
  
  public static final <T> boolean any(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      if (((Boolean)paramFunction1.invoke(paramSequence.next())).booleanValue()) {
        return true;
      }
    }
    return false;
  }
  
  public static final <T> Iterable<T> asIterable(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$asIterable");
    (Iterable)new Iterable()
    {
      public Iterator<T> iterator()
      {
        return this.$this_asIterable$inlined.iterator();
      }
    };
  }
  
  private static final <T> Sequence<T> asSequence(Sequence<? extends T> paramSequence)
  {
    return paramSequence;
  }
  
  public static final <T, K, V> Map<K, V> associate(Sequence<? extends T> paramSequence, Function1<? super T, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Pair localPair = (Pair)paramFunction1.invoke(paramSequence.next());
      localMap.put(localPair.getFirst(), localPair.getSecond());
    }
    return localMap;
  }
  
  public static final <T, K> Map<K, T> associateBy(Sequence<? extends T> paramSequence, Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      localMap.put(paramFunction1.invoke(localObject), localObject);
    }
    return localMap;
  }
  
  public static final <T, K, V> Map<K, V> associateBy(Sequence<? extends T> paramSequence, Function1<? super T, ? extends K> paramFunction1, Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      localMap.put(paramFunction1.invoke(localObject), paramFunction11.invoke(localObject));
    }
    return localMap;
  }
  
  public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(Sequence<? extends T> paramSequence, M paramM, Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      paramM.put(paramFunction1.invoke(localObject), localObject);
    }
    return paramM;
  }
  
  public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(Sequence<? extends T> paramSequence, M paramM, Function1<? super T, ? extends K> paramFunction1, Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      paramM.put(paramFunction1.invoke(localObject), paramFunction11.invoke(localObject));
    }
    return paramM;
  }
  
  public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(Sequence<? extends T> paramSequence, M paramM, Function1<? super T, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Pair localPair = (Pair)paramFunction1.invoke(paramSequence.next());
      paramM.put(localPair.getFirst(), localPair.getSecond());
    }
    return paramM;
  }
  
  public static final <K, V> Map<K, V> associateWith(Sequence<? extends K> paramSequence, Function1<? super K, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateWith");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      ((Map)localLinkedHashMap).put(localObject, paramFunction1.invoke(localObject));
    }
    return (Map)localLinkedHashMap;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(Sequence<? extends K> paramSequence, M paramM, Function1<? super K, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$associateWithTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      paramM.put(localObject, paramFunction1.invoke(localObject));
    }
    return paramM;
  }
  
  public static final double averageOfByte(Sequence<Byte> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    paramSequence = paramSequence.iterator();
    double d1 = 0.0D;
    int i = 0;
    while (paramSequence.hasNext())
    {
      double d2 = d1 + ((Number)paramSequence.next()).byteValue();
      int j = i + 1;
      d1 = d2;
      i = j;
      if (j < 0)
      {
        CollectionsKt.throwCountOverflow();
        d1 = d2;
        i = j;
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d1 / i;
  }
  
  public static final double averageOfDouble(Sequence<Double> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    paramSequence = paramSequence.iterator();
    double d1 = 0.0D;
    int i = 0;
    while (paramSequence.hasNext())
    {
      double d2 = d1 + ((Number)paramSequence.next()).doubleValue();
      int j = i + 1;
      d1 = d2;
      i = j;
      if (j < 0)
      {
        CollectionsKt.throwCountOverflow();
        d1 = d2;
        i = j;
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d1 / i;
  }
  
  public static final double averageOfFloat(Sequence<Float> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    paramSequence = paramSequence.iterator();
    double d1 = 0.0D;
    int i = 0;
    while (paramSequence.hasNext())
    {
      double d2 = d1 + ((Number)paramSequence.next()).floatValue();
      int j = i + 1;
      d1 = d2;
      i = j;
      if (j < 0)
      {
        CollectionsKt.throwCountOverflow();
        d1 = d2;
        i = j;
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d1 / i;
  }
  
  public static final double averageOfInt(Sequence<Integer> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    paramSequence = paramSequence.iterator();
    double d1 = 0.0D;
    int i = 0;
    while (paramSequence.hasNext())
    {
      double d2 = d1 + ((Number)paramSequence.next()).intValue();
      int j = i + 1;
      d1 = d2;
      i = j;
      if (j < 0)
      {
        CollectionsKt.throwCountOverflow();
        d1 = d2;
        i = j;
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d1 / i;
  }
  
  public static final double averageOfLong(Sequence<Long> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    paramSequence = paramSequence.iterator();
    double d1 = 0.0D;
    int i = 0;
    while (paramSequence.hasNext())
    {
      double d2 = d1 + ((Number)paramSequence.next()).longValue();
      int j = i + 1;
      d1 = d2;
      i = j;
      if (j < 0)
      {
        CollectionsKt.throwCountOverflow();
        d1 = d2;
        i = j;
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d1 / i;
  }
  
  public static final double averageOfShort(Sequence<Short> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$average");
    paramSequence = paramSequence.iterator();
    double d1 = 0.0D;
    int i = 0;
    while (paramSequence.hasNext())
    {
      double d2 = d1 + ((Number)paramSequence.next()).shortValue();
      int j = i + 1;
      d1 = d2;
      i = j;
      if (j < 0)
      {
        CollectionsKt.throwCountOverflow();
        d1 = d2;
        i = j;
      }
    }
    if (i == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d1 / i;
  }
  
  public static final <T> Sequence<List<T>> chunked(Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$chunked");
    return SequencesKt.windowed(paramSequence, paramInt, paramInt, true);
  }
  
  public static final <T, R> Sequence<R> chunked(Sequence<? extends T> paramSequence, int paramInt, Function1<? super List<? extends T>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$chunked");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return SequencesKt.windowed(paramSequence, paramInt, paramInt, true, paramFunction1);
  }
  
  public static final <T> boolean contains(Sequence<? extends T> paramSequence, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$contains");
    return SequencesKt.indexOf(paramSequence, paramT) >= 0;
  }
  
  public static final <T> int count(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$count");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      paramSequence.next();
      int j = i + 1;
      i = j;
      if (j < 0)
      {
        CollectionsKt.throwCountOverflow();
        i = j;
      }
    }
    return i;
  }
  
  public static final <T> int count(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext()) {
      if (((Boolean)paramFunction1.invoke(paramSequence.next())).booleanValue())
      {
        int j = i + 1;
        i = j;
        if (j < 0) {
          if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0))
          {
            CollectionsKt.throwCountOverflow();
            i = j;
          }
          else
          {
            throw ((Throwable)new ArithmeticException("Count overflow has happened."));
          }
        }
      }
    }
    return i;
  }
  
  public static final <T> Sequence<T> distinct(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$distinct");
    return SequencesKt.distinctBy(paramSequence, (Function1)distinct.1.INSTANCE);
  }
  
  public static final <T, K> Sequence<T> distinctBy(Sequence<? extends T> paramSequence, Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return (Sequence)new DistinctSequence(paramSequence, paramFunction1);
  }
  
  public static final <T> Sequence<T> drop(Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$drop");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt == 0) {
        return paramSequence;
      }
      if ((paramSequence instanceof DropTakeSequence)) {
        return ((DropTakeSequence)paramSequence).drop(paramInt);
      }
      return (Sequence)new DropSequence(paramSequence, paramInt);
    }
    paramSequence = new StringBuilder();
    paramSequence.append("Requested element count ");
    paramSequence.append(paramInt);
    paramSequence.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramSequence.toString().toString()));
  }
  
  public static final <T> Sequence<T> dropWhile(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return (Sequence)new DropWhileSequence(paramSequence, paramFunction1);
  }
  
  public static final <T> T elementAt(Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$elementAt");
    (T)SequencesKt.elementAtOrElse(paramSequence, paramInt, (Function1)new Lambda(paramInt)
    {
      public final Void invoke(int paramAnonymousInt)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Sequence doesn't contain element at index ");
        localStringBuilder.append(this.$index);
        localStringBuilder.append('.');
        throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
      }
    });
  }
  
  public static final <T> T elementAtOrElse(Sequence<? extends T> paramSequence, int paramInt, Function1<? super Integer, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$elementAtOrElse");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "defaultValue");
    if (paramInt < 0) {
      return (T)paramFunction1.invoke(Integer.valueOf(paramInt));
    }
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (paramInt == i) {
        return (T)localObject;
      }
      i += 1;
    }
    return (T)paramFunction1.invoke(Integer.valueOf(paramInt));
  }
  
  public static final <T> T elementAtOrNull(Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$elementAtOrNull");
    if (paramInt < 0) {
      return null;
    }
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (paramInt == i) {
        return (T)localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public static final <T> Sequence<T> filter(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return (Sequence)new FilteringSequence(paramSequence, true, paramFunction1);
  }
  
  public static final <T> Sequence<T> filterIndexed(Sequence<? extends T> paramSequence, Function2<? super Integer, ? super T, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    (Sequence)new TransformingSequence((Sequence)new FilteringSequence((Sequence)new IndexingSequence(paramSequence), true, (Function1)new Lambda(paramFunction2)
    {
      public final boolean invoke(IndexedValue<? extends T> paramAnonymousIndexedValue)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousIndexedValue, "it");
        return ((Boolean)this.$predicate.invoke(Integer.valueOf(paramAnonymousIndexedValue.getIndex()), paramAnonymousIndexedValue.getValue())).booleanValue();
      }
    }), (Function1)filterIndexed.2.INSTANCE);
  }
  
  public static final <T, C extends Collection<? super T>> C filterIndexedTo(Sequence<? extends T> paramSequence, C paramC, Function2<? super Integer, ? super T, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        } else {
          throw ((Throwable)new ArithmeticException("Index overflow has happened."));
        }
      }
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), localObject)).booleanValue()) {
        paramC.add(localObject);
      }
      i += 1;
    }
    return paramC;
  }
  
  public static final <T> Sequence<T> filterNot(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return (Sequence)new FilteringSequence(paramSequence, false, paramFunction1);
  }
  
  public static final <T> Sequence<T> filterNotNull(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterNotNull");
    paramSequence = SequencesKt.filterNot(paramSequence, (Function1)filterNotNull.1.INSTANCE);
    if (paramSequence != null) {
      return paramSequence;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
  }
  
  public static final <C extends Collection<? super T>, T> C filterNotNullTo(Sequence<? extends T> paramSequence, C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  public static final <T, C extends Collection<? super T>> C filterNotTo(Sequence<? extends T> paramSequence, C paramC, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (!((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  public static final <T, C extends Collection<? super T>> C filterTo(Sequence<? extends T> paramSequence, C paramC, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  private static final <T> T find(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return (T)localObject;
      }
    }
    return null;
  }
  
  private static final <T> T findLast(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Iterator localIterator = paramSequence.iterator();
    paramSequence = null;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        paramSequence = (Sequence<? extends T>)localObject;
      }
    }
    return paramSequence;
  }
  
  public static final <T> T first(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$first");
    paramSequence = paramSequence.iterator();
    if (paramSequence.hasNext()) {
      return (T)paramSequence.next();
    }
    throw ((Throwable)new NoSuchElementException("Sequence is empty."));
  }
  
  public static final <T> T first(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return (T)localObject;
      }
    }
    throw ((Throwable)new NoSuchElementException("Sequence contains no element matching the predicate."));
  }
  
  public static final <T> T firstOrNull(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$firstOrNull");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    return (T)paramSequence.next();
  }
  
  public static final <T> T firstOrNull(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return (T)localObject;
      }
    }
    return null;
  }
  
  public static final <T, R> Sequence<R> flatMap(Sequence<? extends T> paramSequence, Function1<? super T, ? extends Sequence<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return (Sequence)new FlatteningSequence(paramSequence, paramFunction1, (Function1)flatMap.1.INSTANCE);
  }
  
  public static final <T, R, C extends Collection<? super R>> C flatMapTo(Sequence<? extends T> paramSequence, C paramC, Function1<? super T, ? extends Sequence<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      CollectionsKt.addAll(paramC, (Sequence)paramFunction1.invoke(paramSequence.next()));
    }
    return paramC;
  }
  
  public static final <T, R> R fold(Sequence<? extends T> paramSequence, R paramR, Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      paramR = paramFunction2.invoke(paramR, paramSequence.next());
    }
    return paramR;
  }
  
  public static final <T, R> R foldIndexed(Sequence<? extends T> paramSequence, R paramR, Function3<? super Integer, ? super R, ? super T, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        } else {
          throw ((Throwable)new ArithmeticException("Index overflow has happened."));
        }
      }
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, localObject);
      i += 1;
    }
    return paramR;
  }
  
  public static final <T> void forEach(Sequence<? extends T> paramSequence, Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      paramFunction1.invoke(paramSequence.next());
    }
  }
  
  public static final <T> void forEachIndexed(Sequence<? extends T> paramSequence, Function2<? super Integer, ? super T, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        } else {
          throw ((Throwable)new ArithmeticException("Index overflow has happened."));
        }
      }
      paramFunction2.invoke(Integer.valueOf(i), localObject);
      i += 1;
    }
  }
  
  public static final <T, K> Map<K, List<T>> groupBy(Sequence<? extends T> paramSequence, Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramSequence.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramFunction1.invoke(localObject2);
      Object localObject1 = localMap.get(localObject3);
      paramSequence = (Sequence<? extends T>)localObject1;
      if (localObject1 == null)
      {
        paramSequence = new ArrayList();
        localMap.put(localObject3, paramSequence);
      }
      ((List)paramSequence).add(localObject2);
    }
    return localMap;
  }
  
  public static final <T, K, V> Map<K, List<V>> groupBy(Sequence<? extends T> paramSequence, Function1<? super T, ? extends K> paramFunction1, Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramSequence.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramFunction1.invoke(localObject2);
      Object localObject1 = localMap.get(localObject3);
      paramSequence = (Sequence<? extends T>)localObject1;
      if (localObject1 == null)
      {
        paramSequence = new ArrayList();
        localMap.put(localObject3, paramSequence);
      }
      ((List)paramSequence).add(paramFunction11.invoke(localObject2));
    }
    return localMap;
  }
  
  public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(Sequence<? extends T> paramSequence, M paramM, Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Iterator localIterator = paramSequence.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramFunction1.invoke(localObject2);
      Object localObject1 = paramM.get(localObject3);
      paramSequence = (Sequence<? extends T>)localObject1;
      if (localObject1 == null)
      {
        paramSequence = new ArrayList();
        paramM.put(localObject3, paramSequence);
      }
      ((List)paramSequence).add(localObject2);
    }
    return paramM;
  }
  
  public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(Sequence<? extends T> paramSequence, M paramM, Function1<? super T, ? extends K> paramFunction1, Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Iterator localIterator = paramSequence.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramFunction1.invoke(localObject2);
      Object localObject1 = paramM.get(localObject3);
      paramSequence = (Sequence<? extends T>)localObject1;
      if (localObject1 == null)
      {
        paramSequence = new ArrayList();
        paramM.put(localObject3, paramSequence);
      }
      ((List)paramSequence).add(paramFunction11.invoke(localObject2));
    }
    return paramM;
  }
  
  public static final <T, K> Grouping<T, K> groupingBy(Sequence<? extends T> paramSequence, final Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$groupingBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    (Grouping)new Grouping()
    {
      public K keyOf(T paramAnonymousT)
      {
        return (K)paramFunction1.invoke(paramAnonymousT);
      }
      
      public Iterator<T> sourceIterator()
      {
        return this.$this_groupingBy.iterator();
      }
    };
  }
  
  public static final <T> int indexOf(Sequence<? extends T> paramSequence, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$indexOf");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      if (Intrinsics.areEqual(paramT, localObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final <T> int indexOfFirst(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        } else {
          throw ((Throwable)new ArithmeticException("Index overflow has happened."));
        }
      }
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final <T> int indexOfLast(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    int j = -1;
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        } else {
          throw ((Throwable)new ArithmeticException("Index overflow has happened."));
        }
      }
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        j = i;
      }
      i += 1;
    }
    return j;
  }
  
  public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> paramSequence, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, Function1<? super T, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    paramSequence = paramSequence.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (!paramSequence.hasNext()) {
        break;
      }
      paramCharSequence2 = paramSequence.next();
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        j = i;
        if (i > paramInt) {
          break;
        }
      }
      StringsKt.appendElement(paramA, paramCharSequence2, paramFunction1);
    }
    if ((paramInt >= 0) && (j > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  public static final <T> String joinToString(Sequence<? extends T> paramSequence, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, Function1<? super T, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramSequence = ((StringBuilder)SequencesKt.joinTo(paramSequence, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramSequence, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramSequence;
  }
  
  public static final <T> T last(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$last");
    Iterator localIterator = paramSequence.iterator();
    if (localIterator.hasNext())
    {
      for (paramSequence = localIterator.next(); localIterator.hasNext(); paramSequence = localIterator.next()) {}
      return paramSequence;
    }
    throw ((Throwable)new NoSuchElementException("Sequence is empty."));
  }
  
  public static final <T> T last(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Iterator localIterator = paramSequence.iterator();
    paramSequence = null;
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue())
      {
        paramSequence = (Sequence<? extends T>)localObject;
        i = 1;
      }
    }
    if (i != 0) {
      return paramSequence;
    }
    throw ((Throwable)new NoSuchElementException("Sequence contains no element matching the predicate."));
  }
  
  public static final <T> int lastIndexOf(Sequence<? extends T> paramSequence, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$lastIndexOf");
    paramSequence = paramSequence.iterator();
    int j = -1;
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      if (Intrinsics.areEqual(paramT, localObject)) {
        j = i;
      }
      i += 1;
    }
    return j;
  }
  
  public static final <T> T lastOrNull(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$lastOrNull");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    for (paramSequence = localIterator.next(); localIterator.hasNext(); paramSequence = localIterator.next()) {}
    return paramSequence;
  }
  
  public static final <T> T lastOrNull(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Iterator localIterator = paramSequence.iterator();
    paramSequence = null;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        paramSequence = (Sequence<? extends T>)localObject;
      }
    }
    return paramSequence;
  }
  
  public static final <T, R> Sequence<R> map(Sequence<? extends T> paramSequence, Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return (Sequence)new TransformingSequence(paramSequence, paramFunction1);
  }
  
  public static final <T, R> Sequence<R> mapIndexed(Sequence<? extends T> paramSequence, Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    return (Sequence)new TransformingIndexedSequence(paramSequence, paramFunction2);
  }
  
  public static final <T, R> Sequence<R> mapIndexedNotNull(Sequence<? extends T> paramSequence, Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapIndexedNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    return SequencesKt.filterNotNull((Sequence)new TransformingIndexedSequence(paramSequence, paramFunction2));
  }
  
  public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(Sequence<? extends T> paramSequence, C paramC, Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapIndexedNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        } else {
          throw ((Throwable)new ArithmeticException("Index overflow has happened."));
        }
      }
      localObject = paramFunction2.invoke(Integer.valueOf(i), localObject);
      if (localObject != null) {
        paramC.add(localObject);
      }
      i += 1;
    }
    return paramC;
  }
  
  public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(Sequence<? extends T> paramSequence, C paramC, Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (i < 0) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        } else {
          throw ((Throwable)new ArithmeticException("Index overflow has happened."));
        }
      }
      paramC.add(paramFunction2.invoke(Integer.valueOf(i), localObject));
      i += 1;
    }
    return paramC;
  }
  
  public static final <T, R> Sequence<R> mapNotNull(Sequence<? extends T> paramSequence, Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return SequencesKt.filterNotNull((Sequence)new TransformingSequence(paramSequence, paramFunction1));
  }
  
  public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(Sequence<? extends T> paramSequence, C paramC, Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramFunction1.invoke(paramSequence.next());
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  public static final <T, R, C extends Collection<? super R>> C mapTo(Sequence<? extends T> paramSequence, C paramC, Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      paramC.add(paramFunction1.invoke(paramSequence.next()));
    }
    return paramC;
  }
  
  public static final <T extends Comparable<? super T>> T max(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$max");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    paramSequence = (Comparable)localIterator.next();
    while (localIterator.hasNext())
    {
      Comparable localComparable = (Comparable)localIterator.next();
      if (paramSequence.compareTo(localComparable) < 0) {
        paramSequence = localComparable;
      }
    }
    return paramSequence;
  }
  
  public static final Double max(Sequence<Double> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$max");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    double d2 = ((Number)paramSequence.next()).doubleValue();
    double d1 = d2;
    if (Double.isNaN(d2)) {
      return Double.valueOf(d2);
    }
    while (paramSequence.hasNext())
    {
      d2 = ((Number)paramSequence.next()).doubleValue();
      if (Double.isNaN(d2)) {
        return Double.valueOf(d2);
      }
      if (d1 < d2) {
        d1 = d2;
      }
    }
    return Double.valueOf(d1);
  }
  
  public static final Float max(Sequence<Float> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$max");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    float f2 = ((Number)paramSequence.next()).floatValue();
    float f1 = f2;
    if (Float.isNaN(f2)) {
      return Float.valueOf(f2);
    }
    while (paramSequence.hasNext())
    {
      f2 = ((Number)paramSequence.next()).floatValue();
      if (Float.isNaN(f2)) {
        return Float.valueOf(f2);
      }
      if (f1 < f2) {
        f1 = f2;
      }
    }
    return Float.valueOf(f1);
  }
  
  public static final <T, R extends Comparable<? super R>> T maxBy(Sequence<? extends T> paramSequence, Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    Object localObject2 = localIterator.next();
    if (!localIterator.hasNext()) {
      return (T)localObject2;
    }
    paramSequence = (Comparable)paramFunction1.invoke(localObject2);
    Object localObject3;
    do
    {
      Object localObject4 = localIterator.next();
      Comparable localComparable = (Comparable)paramFunction1.invoke(localObject4);
      localObject3 = localObject2;
      Object localObject1 = paramSequence;
      if (paramSequence.compareTo(localComparable) < 0)
      {
        localObject3 = localObject4;
        localObject1 = localComparable;
      }
      localObject2 = localObject3;
      paramSequence = (Sequence<? extends T>)localObject1;
    } while (localIterator.hasNext());
    return (T)localObject3;
  }
  
  public static final <T> T maxWith(Sequence<? extends T> paramSequence, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    paramSequence = localIterator.next();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (paramComparator.compare(paramSequence, localObject) < 0) {
        paramSequence = (Sequence<? extends T>)localObject;
      }
    }
    return paramSequence;
  }
  
  public static final <T extends Comparable<? super T>> T min(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$min");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    paramSequence = (Comparable)localIterator.next();
    while (localIterator.hasNext())
    {
      Comparable localComparable = (Comparable)localIterator.next();
      if (paramSequence.compareTo(localComparable) > 0) {
        paramSequence = localComparable;
      }
    }
    return paramSequence;
  }
  
  public static final Double min(Sequence<Double> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$min");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    double d2 = ((Number)paramSequence.next()).doubleValue();
    double d1 = d2;
    if (Double.isNaN(d2)) {
      return Double.valueOf(d2);
    }
    while (paramSequence.hasNext())
    {
      d2 = ((Number)paramSequence.next()).doubleValue();
      if (Double.isNaN(d2)) {
        return Double.valueOf(d2);
      }
      if (d1 > d2) {
        d1 = d2;
      }
    }
    return Double.valueOf(d1);
  }
  
  public static final Float min(Sequence<Float> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$min");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    float f2 = ((Number)paramSequence.next()).floatValue();
    float f1 = f2;
    if (Float.isNaN(f2)) {
      return Float.valueOf(f2);
    }
    while (paramSequence.hasNext())
    {
      f2 = ((Number)paramSequence.next()).floatValue();
      if (Float.isNaN(f2)) {
        return Float.valueOf(f2);
      }
      if (f1 > f2) {
        f1 = f2;
      }
    }
    return Float.valueOf(f1);
  }
  
  public static final <T, R extends Comparable<? super R>> T minBy(Sequence<? extends T> paramSequence, Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    Object localObject2 = localIterator.next();
    if (!localIterator.hasNext()) {
      return (T)localObject2;
    }
    paramSequence = (Comparable)paramFunction1.invoke(localObject2);
    Object localObject3;
    do
    {
      Object localObject4 = localIterator.next();
      Comparable localComparable = (Comparable)paramFunction1.invoke(localObject4);
      localObject3 = localObject2;
      Object localObject1 = paramSequence;
      if (paramSequence.compareTo(localComparable) > 0)
      {
        localObject3 = localObject4;
        localObject1 = localComparable;
      }
      localObject2 = localObject3;
      paramSequence = (Sequence<? extends T>)localObject1;
    } while (localIterator.hasNext());
    return (T)localObject3;
  }
  
  public static final <T> T minWith(Sequence<? extends T> paramSequence, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    Iterator localIterator = paramSequence.iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    paramSequence = localIterator.next();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (paramComparator.compare(paramSequence, localObject) > 0) {
        paramSequence = (Sequence<? extends T>)localObject;
      }
    }
    return paramSequence;
  }
  
  public static final <T> Sequence<T> minus(Sequence<? extends T> paramSequence, final Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    (Sequence)new Sequence()
    {
      public Iterator<T> iterator()
      {
        Collection localCollection = CollectionsKt.convertToSetForSetOperation(paramIterable);
        if (localCollection.isEmpty()) {
          return this.$this_minus.iterator();
        }
        SequencesKt.filterNot(this.$this_minus, (Function1)new Lambda(localCollection)
        {
          public final boolean invoke(T paramAnonymous2T)
          {
            return this.$other.contains(paramAnonymous2T);
          }
        }).iterator();
      }
    };
  }
  
  public static final <T> Sequence<T> minus(Sequence<? extends T> paramSequence, final T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minus");
    (Sequence)new Sequence()
    {
      public Iterator<T> iterator()
      {
        final Ref.BooleanRef localBooleanRef = new Ref.BooleanRef();
        localBooleanRef.element = false;
        SequencesKt.filter(this.$this_minus, (Function1)new Lambda(localBooleanRef)
        {
          public final boolean invoke(T paramAnonymous2T)
          {
            boolean bool3 = localBooleanRef.element;
            boolean bool2 = true;
            boolean bool1 = bool2;
            if (!bool3)
            {
              bool1 = bool2;
              if (Intrinsics.areEqual(paramAnonymous2T, this.this$0.$element))
              {
                localBooleanRef.element = true;
                bool1 = false;
              }
            }
            return bool1;
          }
        }).iterator();
      }
    };
  }
  
  public static final <T> Sequence<T> minus(Sequence<? extends T> paramSequence1, final Sequence<? extends T> paramSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence1, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramSequence2, "elements");
    (Sequence)new Sequence()
    {
      public Iterator<T> iterator()
      {
        HashSet localHashSet = SequencesKt.toHashSet(paramSequence2);
        if (localHashSet.isEmpty()) {
          return this.$this_minus.iterator();
        }
        SequencesKt.filterNot(this.$this_minus, (Function1)new Lambda(localHashSet)
        {
          public final boolean invoke(T paramAnonymous2T)
          {
            return this.$other.contains(paramAnonymous2T);
          }
        }).iterator();
      }
    };
  }
  
  public static final <T> Sequence<T> minus(Sequence<? extends T> paramSequence, final T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    int i;
    if (paramArrayOfT.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramSequence;
    }
    (Sequence)new Sequence()
    {
      public Iterator<T> iterator()
      {
        HashSet localHashSet = ArraysKt.toHashSet(paramArrayOfT);
        SequencesKt.filterNot(this.$this_minus, (Function1)new Lambda(localHashSet)
        {
          public final boolean invoke(T paramAnonymous2T)
          {
            return this.$other.contains(paramAnonymous2T);
          }
        }).iterator();
      }
    };
  }
  
  private static final <T> Sequence<T> minusElement(Sequence<? extends T> paramSequence, T paramT)
  {
    return SequencesKt.minus(paramSequence, paramT);
  }
  
  public static final <T> boolean none(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$none");
    return paramSequence.iterator().hasNext() ^ true;
  }
  
  public static final <T> boolean none(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      if (((Boolean)paramFunction1.invoke(paramSequence.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  public static final <T> Sequence<T> onEach(Sequence<? extends T> paramSequence, Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$onEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    SequencesKt.map(paramSequence, (Function1)new Lambda(paramFunction1)
    {
      public final T invoke(T paramAnonymousT)
      {
        this.$action.invoke(paramAnonymousT);
        return paramAnonymousT;
      }
    });
  }
  
  public static final <T> Pair<List<T>, List<T>> partition(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        localArrayList1.add(localObject);
      } else {
        localArrayList2.add(localObject);
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  public static final <T> Sequence<T> plus(Sequence<? extends T> paramSequence, Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    return SequencesKt.flatten(SequencesKt.sequenceOf(new Sequence[] { paramSequence, CollectionsKt.asSequence(paramIterable) }));
  }
  
  public static final <T> Sequence<T> plus(Sequence<? extends T> paramSequence, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$plus");
    return SequencesKt.flatten(SequencesKt.sequenceOf(new Sequence[] { paramSequence, SequencesKt.sequenceOf(new Object[] { paramT }) }));
  }
  
  public static final <T> Sequence<T> plus(Sequence<? extends T> paramSequence1, Sequence<? extends T> paramSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramSequence2, "elements");
    return SequencesKt.flatten(SequencesKt.sequenceOf(new Sequence[] { paramSequence1, paramSequence2 }));
  }
  
  public static final <T> Sequence<T> plus(Sequence<? extends T> paramSequence, T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    return SequencesKt.plus(paramSequence, (Iterable)ArraysKt.asList(paramArrayOfT));
  }
  
  private static final <T> Sequence<T> plusElement(Sequence<? extends T> paramSequence, T paramT)
  {
    return SequencesKt.plus(paramSequence, paramT);
  }
  
  public static final <S, T extends S> S reduce(Sequence<? extends T> paramSequence, Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Iterator localIterator = paramSequence.iterator();
    if (localIterator.hasNext())
    {
      for (paramSequence = localIterator.next(); localIterator.hasNext(); paramSequence = paramFunction2.invoke(paramSequence, localIterator.next())) {}
      return paramSequence;
    }
    throw ((Throwable)new UnsupportedOperationException("Empty sequence can't be reduced."));
  }
  
  public static final <S, T extends S> S reduceIndexed(Sequence<? extends T> paramSequence, Function3<? super Integer, ? super S, ? super T, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Iterator localIterator = paramSequence.iterator();
    if (localIterator.hasNext())
    {
      paramSequence = localIterator.next();
      int i = 1;
      while (localIterator.hasNext())
      {
        if (i < 0) {
          if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            CollectionsKt.throwIndexOverflow();
          } else {
            throw ((Throwable)new ArithmeticException("Index overflow has happened."));
          }
        }
        paramSequence = paramFunction3.invoke(Integer.valueOf(i), paramSequence, localIterator.next());
        i += 1;
      }
      return paramSequence;
    }
    throw ((Throwable)new UnsupportedOperationException("Empty sequence can't be reduced."));
  }
  
  public static final <T> Sequence<T> requireNoNulls(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$requireNoNulls");
    SequencesKt.map(paramSequence, (Function1)new Lambda(paramSequence)
    {
      public final T invoke(T paramAnonymousT)
      {
        if (paramAnonymousT != null) {
          return paramAnonymousT;
        }
        paramAnonymousT = new StringBuilder();
        paramAnonymousT.append("null element found in ");
        paramAnonymousT.append(this.$this_requireNoNulls);
        paramAnonymousT.append('.');
        throw ((Throwable)new IllegalArgumentException(paramAnonymousT.toString()));
      }
    });
  }
  
  public static final <T> T single(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$single");
    paramSequence = paramSequence.iterator();
    if (paramSequence.hasNext())
    {
      Object localObject = paramSequence.next();
      if (!paramSequence.hasNext()) {
        return (T)localObject;
      }
      throw ((Throwable)new IllegalArgumentException("Sequence has more than one element."));
    }
    throw ((Throwable)new NoSuchElementException("Sequence is empty."));
  }
  
  public static final <T> T single(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Iterator localIterator = paramSequence.iterator();
    paramSequence = null;
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue()) {
        if (i == 0)
        {
          paramSequence = (Sequence<? extends T>)localObject;
          i = 1;
        }
        else
        {
          throw ((Throwable)new IllegalArgumentException("Sequence contains more than one matching element."));
        }
      }
    }
    if (i != 0) {
      return paramSequence;
    }
    throw ((Throwable)new NoSuchElementException("Sequence contains no element matching the predicate."));
  }
  
  public static final <T> T singleOrNull(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$singleOrNull");
    paramSequence = paramSequence.iterator();
    if (!paramSequence.hasNext()) {
      return null;
    }
    Object localObject = paramSequence.next();
    if (paramSequence.hasNext()) {
      return null;
    }
    return (T)localObject;
  }
  
  public static final <T> T singleOrNull(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Iterator localIterator = paramSequence.iterator();
    int i = 0;
    paramSequence = null;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((Boolean)paramFunction1.invoke(localObject)).booleanValue())
      {
        if (i != 0) {
          return null;
        }
        i = 1;
        paramSequence = (Sequence<? extends T>)localObject;
      }
    }
    if (i == 0) {
      return null;
    }
    return paramSequence;
  }
  
  public static final <T extends Comparable<? super T>> Sequence<T> sorted(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sorted");
    (Sequence)new Sequence()
    {
      public Iterator<T> iterator()
      {
        List localList = SequencesKt.toMutableList(this.$this_sorted);
        CollectionsKt.sort(localList);
        return localList.iterator();
      }
    };
  }
  
  public static final <T, R extends Comparable<? super R>> Sequence<T> sortedBy(Sequence<? extends T> paramSequence, Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return SequencesKt.sortedWith(paramSequence, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  public static final <T, R extends Comparable<? super R>> Sequence<T> sortedByDescending(Sequence<? extends T> paramSequence, Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return SequencesKt.sortedWith(paramSequence, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  public static final <T extends Comparable<? super T>> Sequence<T> sortedDescending(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sortedDescending");
    return SequencesKt.sortedWith(paramSequence, ComparisonsKt.reverseOrder());
  }
  
  public static final <T> Sequence<T> sortedWith(Sequence<? extends T> paramSequence, final Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    (Sequence)new Sequence()
    {
      public Iterator<T> iterator()
      {
        List localList = SequencesKt.toMutableList(this.$this_sortedWith);
        CollectionsKt.sortWith(localList, paramComparator);
        return localList.iterator();
      }
    };
  }
  
  public static final <T> int sumBy(Sequence<? extends T> paramSequence, Function1<? super T, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext()) {
      i += ((Number)paramFunction1.invoke(paramSequence.next())).intValue();
    }
    return i;
  }
  
  public static final <T> double sumByDouble(Sequence<? extends T> paramSequence, Function1<? super T, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    paramSequence = paramSequence.iterator();
    for (double d = 0.0D; paramSequence.hasNext(); d += ((Number)paramFunction1.invoke(paramSequence.next())).doubleValue()) {}
    return d;
  }
  
  public static final int sumOfByte(Sequence<Byte> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext()) {
      i += ((Number)paramSequence.next()).byteValue();
    }
    return i;
  }
  
  public static final double sumOfDouble(Sequence<Double> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (double d = 0.0D; paramSequence.hasNext(); d += ((Number)paramSequence.next()).doubleValue()) {}
    return d;
  }
  
  public static final float sumOfFloat(Sequence<Float> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (float f = 0.0F; paramSequence.hasNext(); f += ((Number)paramSequence.next()).floatValue()) {}
    return f;
  }
  
  public static final int sumOfInt(Sequence<Integer> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext()) {
      i += ((Number)paramSequence.next()).intValue();
    }
    return i;
  }
  
  public static final long sumOfLong(Sequence<Long> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (long l = 0L; paramSequence.hasNext(); l += ((Number)paramSequence.next()).longValue()) {}
    return l;
  }
  
  public static final int sumOfShort(Sequence<Short> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    int i = 0;
    while (paramSequence.hasNext()) {
      i += ((Number)paramSequence.next()).shortValue();
    }
    return i;
  }
  
  public static final <T> Sequence<T> take(Sequence<? extends T> paramSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$take");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt == 0) {
        return SequencesKt.emptySequence();
      }
      if ((paramSequence instanceof DropTakeSequence)) {
        return ((DropTakeSequence)paramSequence).take(paramInt);
      }
      return (Sequence)new TakeSequence(paramSequence, paramInt);
    }
    paramSequence = new StringBuilder();
    paramSequence.append("Requested element count ");
    paramSequence.append(paramInt);
    paramSequence.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramSequence.toString().toString()));
  }
  
  public static final <T> Sequence<T> takeWhile(Sequence<? extends T> paramSequence, Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return (Sequence)new TakeWhileSequence(paramSequence, paramFunction1);
  }
  
  public static final <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> paramSequence, C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      paramC.add(paramSequence.next());
    }
    return paramC;
  }
  
  public static final <T> HashSet<T> toHashSet(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toHashSet");
    return (HashSet)SequencesKt.toCollection(paramSequence, (Collection)new HashSet());
  }
  
  public static final <T> List<T> toList(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toList");
    return CollectionsKt.optimizeReadOnlyList(SequencesKt.toMutableList(paramSequence));
  }
  
  public static final <T> List<T> toMutableList(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toMutableList");
    return (List)SequencesKt.toCollection(paramSequence, (Collection)new ArrayList());
  }
  
  public static final <T> Set<T> toMutableSet(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      localLinkedHashSet.add(paramSequence.next());
    }
    return (Set)localLinkedHashSet;
  }
  
  public static final <T> Set<T> toSet(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toSet");
    return SetsKt.optimizeReadOnlySet((Set)SequencesKt.toCollection(paramSequence, (Collection)new LinkedHashSet()));
  }
  
  public static final <T> Sequence<List<T>> windowed(Sequence<? extends T> paramSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$windowed");
    return SlidingWindowKt.windowedSequence(paramSequence, paramInt1, paramInt2, paramBoolean, false);
  }
  
  public static final <T, R> Sequence<R> windowed(Sequence<? extends T> paramSequence, int paramInt1, int paramInt2, boolean paramBoolean, Function1<? super List<? extends T>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$windowed");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return SequencesKt.map(SlidingWindowKt.windowedSequence(paramSequence, paramInt1, paramInt2, paramBoolean, true), paramFunction1);
  }
  
  public static final <T> Sequence<IndexedValue<T>> withIndex(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$withIndex");
    return (Sequence)new IndexingSequence(paramSequence);
  }
  
  public static final <T, R> Sequence<Pair<T, R>> zip(Sequence<? extends T> paramSequence, Sequence<? extends R> paramSequence1)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramSequence1, "other");
    return (Sequence)new MergingSequence(paramSequence, paramSequence1, (Function2)zip.1.INSTANCE);
  }
  
  public static final <T, R, V> Sequence<V> zip(Sequence<? extends T> paramSequence, Sequence<? extends R> paramSequence1, Function2<? super T, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramSequence1, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    return (Sequence)new MergingSequence(paramSequence, paramSequence1, paramFunction2);
  }
  
  public static final <T> Sequence<Pair<T, T>> zipWithNext(Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$zipWithNext");
    return SequencesKt.zipWithNext(paramSequence, (Function2)zipWithNext.1.INSTANCE);
  }
  
  public static final <T, R> Sequence<R> zipWithNext(Sequence<? extends T> paramSequence, final Function2<? super T, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$zipWithNext");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    SequencesKt.sequence((Function2)new RestrictedSuspendLambda(paramSequence, paramFunction2)
    {
      Object L$0;
      Object L$1;
      Object L$2;
      Object L$3;
      int label;
      private SequenceScope p$;
      
      public final Continuation<Unit> create(Object paramAnonymousObject, Continuation<?> paramAnonymousContinuation)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousContinuation, "completion");
        paramAnonymousContinuation = new 2(this.$this_zipWithNext, paramFunction2, paramAnonymousContinuation);
        paramAnonymousContinuation.p$ = ((SequenceScope)paramAnonymousObject);
        return paramAnonymousContinuation;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return ((2)create(paramAnonymousObject1, (Continuation)paramAnonymousObject2)).invokeSuspend(Unit.INSTANCE);
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Object localObject1;
        Iterator localIterator;
        SequenceScope localSequenceScope;
        if (i != 0)
        {
          if (i == 1)
          {
            localObject1 = this.L$3;
            localIterator = (Iterator)this.L$1;
            localSequenceScope = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = localObject1;
          }
          else
          {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          ResultKt.throwOnFailure(paramAnonymousObject);
          localSequenceScope = this.p$;
          localIterator = this.$this_zipWithNext.iterator();
          if (!localIterator.hasNext()) {
            return Unit.INSTANCE;
          }
        }
        for (paramAnonymousObject = localIterator.next(); localIterator.hasNext(); paramAnonymousObject = localObject1)
        {
          localObject1 = localIterator.next();
          Object localObject3 = paramFunction2.invoke(paramAnonymousObject, localObject1);
          this.L$0 = localSequenceScope;
          this.L$1 = localIterator;
          this.L$2 = paramAnonymousObject;
          this.L$3 = localObject1;
          this.label = 1;
          if (localSequenceScope.yield(localObject3, this) == localObject2) {
            return localObject2;
          }
        }
        return Unit.INSTANCE;
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\sequences\SequencesKt___SequencesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */