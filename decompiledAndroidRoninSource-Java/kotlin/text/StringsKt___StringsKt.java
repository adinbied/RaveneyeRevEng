package kotlin.text;

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
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.random.Random;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv={1, 0, 3}, d1={"\000Ü\001\n\000\n\002\020\013\n\002\020\r\n\000\n\002\030\002\n\002\020\f\n\002\b\002\n\002\020\034\n\000\n\002\030\002\n\000\n\002\020$\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020%\n\002\b\b\n\002\020 \n\002\020\016\n\000\n\002\020\b\n\002\b\017\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\r\n\002\020\037\n\002\b\007\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\006\n\002\020!\n\000\n\002\030\002\n\002\b\007\n\002\020\000\n\002\b\b\n\002\020\017\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\002\n\002\020\006\n\002\b\007\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\"\n\002\b\005\n\002\030\002\n\002\b\006\032!\020\000\032\0020\001*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\n\020\006\032\0020\001*\0020\002\032!\020\006\032\0020\001*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\020\020\007\032\b\022\004\022\0020\0050\b*\0020\002\032\020\020\t\032\b\022\004\022\0020\0050\n*\0020\002\032E\020\013\032\016\022\004\022\002H\r\022\004\022\002H\0160\f\"\004\b\000\020\r\"\004\b\001\020\016*\0020\0022\036\020\017\032\032\022\004\022\0020\005\022\020\022\016\022\004\022\002H\r\022\004\022\002H\0160\0200\004H\b\0323\020\021\032\016\022\004\022\002H\r\022\004\022\0020\0050\f\"\004\b\000\020\r*\0020\0022\022\020\022\032\016\022\004\022\0020\005\022\004\022\002H\r0\004H\b\032M\020\021\032\016\022\004\022\002H\r\022\004\022\002H\0160\f\"\004\b\000\020\r\"\004\b\001\020\016*\0020\0022\022\020\022\032\016\022\004\022\0020\005\022\004\022\002H\r0\0042\022\020\023\032\016\022\004\022\0020\005\022\004\022\002H\0160\004H\b\032N\020\024\032\002H\025\"\004\b\000\020\r\"\030\b\001\020\025*\022\022\006\b\000\022\002H\r\022\006\b\000\022\0020\0050\026*\0020\0022\006\020\027\032\002H\0252\022\020\022\032\016\022\004\022\0020\005\022\004\022\002H\r0\004H\b¢\006\002\020\030\032h\020\024\032\002H\025\"\004\b\000\020\r\"\004\b\001\020\016\"\030\b\002\020\025*\022\022\006\b\000\022\002H\r\022\006\b\000\022\002H\0160\026*\0020\0022\006\020\027\032\002H\0252\022\020\022\032\016\022\004\022\0020\005\022\004\022\002H\r0\0042\022\020\023\032\016\022\004\022\0020\005\022\004\022\002H\0160\004H\b¢\006\002\020\031\032`\020\032\032\002H\025\"\004\b\000\020\r\"\004\b\001\020\016\"\030\b\002\020\025*\022\022\006\b\000\022\002H\r\022\006\b\000\022\002H\0160\026*\0020\0022\006\020\027\032\002H\0252\036\020\017\032\032\022\004\022\0020\005\022\020\022\016\022\004\022\002H\r\022\004\022\002H\0160\0200\004H\b¢\006\002\020\030\0323\020\033\032\016\022\004\022\0020\005\022\004\022\002H\0160\f\"\004\b\000\020\016*\0020\0022\022\020\034\032\016\022\004\022\0020\005\022\004\022\002H\0160\004H\b\032N\020\035\032\002H\025\"\004\b\000\020\016\"\030\b\001\020\025*\022\022\006\b\000\022\0020\005\022\006\b\000\022\002H\0160\026*\0020\0022\006\020\027\032\002H\0252\022\020\034\032\016\022\004\022\0020\005\022\004\022\002H\0160\004H\b¢\006\002\020\030\032\032\020\036\032\b\022\004\022\0020 0\037*\0020\0022\006\020!\032\0020\"H\007\0324\020\036\032\b\022\004\022\002H#0\037\"\004\b\000\020#*\0020\0022\006\020!\032\0020\"2\022\020\017\032\016\022\004\022\0020\002\022\004\022\002H#0\004H\007\032\032\020$\032\b\022\004\022\0020 0\n*\0020\0022\006\020!\032\0020\"H\007\0324\020$\032\b\022\004\022\002H#0\n\"\004\b\000\020#*\0020\0022\006\020!\032\0020\"2\022\020\017\032\016\022\004\022\0020\002\022\004\022\002H#0\004H\007\032\r\020%\032\0020\"*\0020\002H\b\032!\020%\032\0020\"*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\022\020&\032\0020\002*\0020\0022\006\020'\032\0020\"\032\022\020&\032\0020 *\0020 2\006\020'\032\0020\"\032\022\020(\032\0020\002*\0020\0022\006\020'\032\0020\"\032\022\020(\032\0020 *\0020 2\006\020'\032\0020\"\032!\020)\032\0020\002*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032!\020)\032\0020 *\0020 2\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032!\020*\032\0020\002*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032!\020*\032\0020 *\0020 2\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032)\020+\032\0020\005*\0020\0022\006\020,\032\0020\"2\022\020-\032\016\022\004\022\0020\"\022\004\022\0020\0050\004H\b\032\034\020.\032\004\030\0010\005*\0020\0022\006\020,\032\0020\"H\b¢\006\002\020/\032!\0200\032\0020\002*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032!\0200\032\0020 *\0020 2\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\0326\0201\032\0020\002*\0020\0022'\020\003\032#\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\004\022\0020\00102H\b\0326\0201\032\0020 *\0020 2'\020\003\032#\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\004\022\0020\00102H\b\032Q\0205\032\002H6\"\f\b\000\0206*\00607j\002`8*\0020\0022\006\020\027\032\002H62'\020\003\032#\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\004\022\0020\00102H\b¢\006\002\0209\032!\020:\032\0020\002*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032!\020:\032\0020 *\0020 2\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032<\020;\032\002H6\"\f\b\000\0206*\00607j\002`8*\0020\0022\006\020\027\032\002H62\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b¢\006\002\020<\032<\020=\032\002H6\"\f\b\000\0206*\00607j\002`8*\0020\0022\006\020\027\032\002H62\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b¢\006\002\020<\032(\020>\032\004\030\0010\005*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b¢\006\002\020?\032(\020@\032\004\030\0010\005*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b¢\006\002\020?\032\n\020A\032\0020\005*\0020\002\032!\020A\032\0020\005*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\021\020B\032\004\030\0010\005*\0020\002¢\006\002\020C\032(\020B\032\004\030\0010\005*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b¢\006\002\020?\0323\020D\032\b\022\004\022\002H#0\037\"\004\b\000\020#*\0020\0022\030\020\017\032\024\022\004\022\0020\005\022\n\022\b\022\004\022\002H#0\b0\004H\b\032L\020E\032\002H6\"\004\b\000\020#\"\020\b\001\0206*\n\022\006\b\000\022\002H#0F*\0020\0022\006\020\027\032\002H62\030\020\017\032\024\022\004\022\0020\005\022\n\022\b\022\004\022\002H#0\b0\004H\b¢\006\002\020G\032I\020H\032\002H#\"\004\b\000\020#*\0020\0022\006\020I\032\002H#2'\020J\032#\022\023\022\021H#¢\006\f\b3\022\b\b4\022\004\b\b(K\022\004\022\0020\005\022\004\022\002H#02H\b¢\006\002\020L\032^\020M\032\002H#\"\004\b\000\020#*\0020\0022\006\020I\032\002H#2<\020J\0328\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\023\022\021H#¢\006\f\b3\022\b\b4\022\004\b\b(K\022\004\022\0020\005\022\004\022\002H#0NH\b¢\006\002\020O\032I\020P\032\002H#\"\004\b\000\020#*\0020\0022\006\020I\032\002H#2'\020J\032#\022\004\022\0020\005\022\023\022\021H#¢\006\f\b3\022\b\b4\022\004\b\b(K\022\004\022\002H#02H\b¢\006\002\020L\032^\020Q\032\002H#\"\004\b\000\020#*\0020\0022\006\020I\032\002H#2<\020J\0328\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\023\022\021H#¢\006\f\b3\022\b\b4\022\004\b\b(K\022\004\022\002H#0NH\b¢\006\002\020O\032!\020R\032\0020S*\0020\0022\022\020T\032\016\022\004\022\0020\005\022\004\022\0020S0\004H\b\0326\020U\032\0020S*\0020\0022'\020T\032#\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\004\022\0020S02H\b\032)\020V\032\0020\005*\0020\0022\006\020,\032\0020\"2\022\020-\032\016\022\004\022\0020\"\022\004\022\0020\0050\004H\b\032\031\020W\032\004\030\0010\005*\0020\0022\006\020,\032\0020\"¢\006\002\020/\0329\020X\032\024\022\004\022\002H\r\022\n\022\b\022\004\022\0020\0050\0370\f\"\004\b\000\020\r*\0020\0022\022\020\022\032\016\022\004\022\0020\005\022\004\022\002H\r0\004H\b\032S\020X\032\024\022\004\022\002H\r\022\n\022\b\022\004\022\002H\0160\0370\f\"\004\b\000\020\r\"\004\b\001\020\016*\0020\0022\022\020\022\032\016\022\004\022\0020\005\022\004\022\002H\r0\0042\022\020\023\032\016\022\004\022\0020\005\022\004\022\002H\0160\004H\b\032R\020Y\032\002H\025\"\004\b\000\020\r\"\034\b\001\020\025*\026\022\006\b\000\022\002H\r\022\n\022\b\022\004\022\0020\0050Z0\026*\0020\0022\006\020\027\032\002H\0252\022\020\022\032\016\022\004\022\0020\005\022\004\022\002H\r0\004H\b¢\006\002\020\030\032l\020Y\032\002H\025\"\004\b\000\020\r\"\004\b\001\020\016\"\034\b\002\020\025*\026\022\006\b\000\022\002H\r\022\n\022\b\022\004\022\002H\0160Z0\026*\0020\0022\006\020\027\032\002H\0252\022\020\022\032\016\022\004\022\0020\005\022\004\022\002H\r0\0042\022\020\023\032\016\022\004\022\0020\005\022\004\022\002H\0160\004H\b¢\006\002\020\031\0325\020[\032\016\022\004\022\0020\005\022\004\022\002H\r0\\\"\004\b\000\020\r*\0020\0022\024\b\004\020\022\032\016\022\004\022\0020\005\022\004\022\002H\r0\004H\b\032!\020]\032\0020\"*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032!\020^\032\0020\"*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\n\020_\032\0020\005*\0020\002\032!\020_\032\0020\005*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\021\020`\032\004\030\0010\005*\0020\002¢\006\002\020C\032(\020`\032\004\030\0010\005*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b¢\006\002\020?\032-\020a\032\b\022\004\022\002H#0\037\"\004\b\000\020#*\0020\0022\022\020\017\032\016\022\004\022\0020\005\022\004\022\002H#0\004H\b\032B\020b\032\b\022\004\022\002H#0\037\"\004\b\000\020#*\0020\0022'\020\017\032#\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\004\022\002H#02H\b\032H\020c\032\b\022\004\022\002H#0\037\"\b\b\000\020#*\0020d*\0020\0022)\020\017\032%\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\006\022\004\030\001H#02H\b\032a\020e\032\002H6\"\b\b\000\020#*\0020d\"\020\b\001\0206*\n\022\006\b\000\022\002H#0F*\0020\0022\006\020\027\032\002H62)\020\017\032%\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\006\022\004\030\001H#02H\b¢\006\002\020f\032[\020g\032\002H6\"\004\b\000\020#\"\020\b\001\0206*\n\022\006\b\000\022\002H#0F*\0020\0022\006\020\027\032\002H62'\020\017\032#\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\004\022\002H#02H\b¢\006\002\020f\0323\020h\032\b\022\004\022\002H#0\037\"\b\b\000\020#*\0020d*\0020\0022\024\020\017\032\020\022\004\022\0020\005\022\006\022\004\030\001H#0\004H\b\032L\020i\032\002H6\"\b\b\000\020#*\0020d\"\020\b\001\0206*\n\022\006\b\000\022\002H#0F*\0020\0022\006\020\027\032\002H62\024\020\017\032\020\022\004\022\0020\005\022\006\022\004\030\001H#0\004H\b¢\006\002\020G\032F\020j\032\002H6\"\004\b\000\020#\"\020\b\001\0206*\n\022\006\b\000\022\002H#0F*\0020\0022\006\020\027\032\002H62\022\020\017\032\016\022\004\022\0020\005\022\004\022\002H#0\004H\b¢\006\002\020G\032\021\020k\032\004\030\0010\005*\0020\002¢\006\002\020C\0328\020l\032\004\030\0010\005\"\016\b\000\020#*\b\022\004\022\002H#0m*\0020\0022\022\020n\032\016\022\004\022\0020\005\022\004\022\002H#0\004H\b¢\006\002\020?\032-\020o\032\004\030\0010\005*\0020\0022\032\020p\032\026\022\006\b\000\022\0020\0050qj\n\022\006\b\000\022\0020\005`r¢\006\002\020s\032\021\020t\032\004\030\0010\005*\0020\002¢\006\002\020C\0328\020u\032\004\030\0010\005\"\016\b\000\020#*\b\022\004\022\002H#0m*\0020\0022\022\020n\032\016\022\004\022\0020\005\022\004\022\002H#0\004H\b¢\006\002\020?\032-\020v\032\004\030\0010\005*\0020\0022\032\020p\032\026\022\006\b\000\022\0020\0050qj\n\022\006\b\000\022\0020\005`r¢\006\002\020s\032\n\020w\032\0020\001*\0020\002\032!\020w\032\0020\001*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\0320\020x\032\002Hy\"\b\b\000\020y*\0020\002*\002Hy2\022\020T\032\016\022\004\022\0020\005\022\004\022\0020S0\004H\b¢\006\002\020z\032-\020{\032\016\022\004\022\0020\002\022\004\022\0020\0020\020*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032-\020{\032\016\022\004\022\0020 \022\004\022\0020 0\020*\0020 2\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\r\020|\032\0020\005*\0020\002H\b\032\024\020|\032\0020\005*\0020\0022\006\020|\032\0020}H\007\0326\020~\032\0020\005*\0020\0022'\020J\032#\022\023\022\0210\005¢\006\f\b3\022\b\b4\022\004\b\b(K\022\004\022\0020\005\022\004\022\0020\00502H\b\032K\020\032\0020\005*\0020\0022<\020J\0328\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\023\022\0210\005¢\006\f\b3\022\b\b4\022\004\b\b(K\022\004\022\0020\005\022\004\022\0020\0050NH\b\0327\020\001\032\0020\005*\0020\0022'\020J\032#\022\004\022\0020\005\022\023\022\0210\005¢\006\f\b3\022\b\b4\022\004\b\b(K\022\004\022\0020\00502H\b\032L\020\001\032\0020\005*\0020\0022<\020J\0328\022\023\022\0210\"¢\006\f\b3\022\b\b4\022\004\b\b(,\022\004\022\0020\005\022\023\022\0210\005¢\006\f\b3\022\b\b4\022\004\b\b(K\022\004\022\0020\0050NH\b\032\013\020\001\032\0020\002*\0020\002\032\016\020\001\032\0020 *\0020 H\b\032\013\020\001\032\0020\005*\0020\002\032\"\020\001\032\0020\005*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\022\020\001\032\004\030\0010\005*\0020\002¢\006\002\020C\032)\020\001\032\004\030\0010\005*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b¢\006\002\020?\032\032\020\001\032\0020\002*\0020\0022\r\020\001\032\b\022\004\022\0020\"0\b\032\025\020\001\032\0020\002*\0020\0022\b\020\001\032\0030\001\032\035\020\001\032\0020 *\0020 2\r\020\001\032\b\022\004\022\0020\"0\bH\b\032\025\020\001\032\0020 *\0020 2\b\020\001\032\0030\001\032\"\020\001\032\0020\"*\0020\0022\022\020n\032\016\022\004\022\0020\005\022\004\022\0020\"0\004H\b\032$\020\001\032\0030\001*\0020\0022\023\020n\032\017\022\004\022\0020\005\022\005\022\0030\0010\004H\b\032\023\020\001\032\0020\002*\0020\0022\006\020'\032\0020\"\032\023\020\001\032\0020 *\0020 2\006\020'\032\0020\"\032\023\020\001\032\0020\002*\0020\0022\006\020'\032\0020\"\032\023\020\001\032\0020 *\0020 2\006\020'\032\0020\"\032\"\020\001\032\0020\002*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\"\020\001\032\0020 *\0020 2\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\"\020\001\032\0020\002*\0020\0022\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032\"\020\001\032\0020 *\0020 2\022\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0010\004H\b\032+\020\001\032\002H6\"\020\b\000\0206*\n\022\006\b\000\022\0020\0050F*\0020\0022\006\020\027\032\002H6¢\006\003\020\001\032\035\020\001\032\024\022\004\022\0020\0050\001j\t\022\004\022\0020\005`\001*\0020\002\032\021\020\001\032\b\022\004\022\0020\0050\037*\0020\002\032\021\020\001\032\b\022\004\022\0020\0050Z*\0020\002\032\022\020\001\032\t\022\004\022\0020\0050\001*\0020\002\0321\020\001\032\b\022\004\022\0020 0\037*\0020\0022\006\020!\032\0020\"2\t\b\002\020\001\032\0020\"2\t\b\002\020\001\032\0020\001H\007\032K\020\001\032\b\022\004\022\002H#0\037\"\004\b\000\020#*\0020\0022\006\020!\032\0020\"2\t\b\002\020\001\032\0020\"2\t\b\002\020\001\032\0020\0012\022\020\017\032\016\022\004\022\0020\002\022\004\022\002H#0\004H\007\0321\020\001\032\b\022\004\022\0020 0\n*\0020\0022\006\020!\032\0020\"2\t\b\002\020\001\032\0020\"2\t\b\002\020\001\032\0020\001H\007\032K\020\001\032\b\022\004\022\002H#0\n\"\004\b\000\020#*\0020\0022\006\020!\032\0020\"2\t\b\002\020\001\032\0020\"2\t\b\002\020\001\032\0020\0012\022\020\017\032\016\022\004\022\0020\002\022\004\022\002H#0\004H\007\032\030\020\001\032\017\022\013\022\t\022\004\022\0020\0050\0010\b*\0020\002\032)\020\001\032\024\022\020\022\016\022\004\022\0020\005\022\004\022\0020\0050\0200\037*\0020\0022\007\020\001\032\0020\002H\004\032]\020\001\032\b\022\004\022\002H\0160\037\"\004\b\000\020\016*\0020\0022\007\020\001\032\0020\00228\020\017\0324\022\024\022\0220\005¢\006\r\b3\022\t\b4\022\005\b\b( \001\022\024\022\0220\005¢\006\r\b3\022\t\b4\022\005\b\b(¡\001\022\004\022\002H\01602H\b\032\037\020¢\001\032\024\022\020\022\016\022\004\022\0020\005\022\004\022\0020\0050\0200\037*\0020\002H\007\032T\020¢\001\032\b\022\004\022\002H#0\037\"\004\b\000\020#*\0020\00228\020\017\0324\022\024\022\0220\005¢\006\r\b3\022\t\b4\022\005\b\b( \001\022\024\022\0220\005¢\006\r\b3\022\t\b4\022\005\b\b(¡\001\022\004\022\002H#02H\b¨\006£\001"}, d2={"all", "", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "chunked", "", "", "size", "", "R", "chunkedSequence", "count", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAtOrElse", "index", "defaultValue", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", "first", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "flatMap", "flatMapTo", "", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fold", "initial", "operation", "acc", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "none", "onEach", "S", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "partition", "random", "Lkotlin/random/Random;", "reduce", "reduceIndexed", "reduceRight", "reduceRightIndexed", "reversed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sumBy", "sumByDouble", "", "take", "takeLast", "takeLastWhile", "takeWhile", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toSet", "", "windowed", "step", "partialWindows", "windowedSequence", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt___StringsKt
  extends StringsKt___StringsJvmKt
{
  public static final boolean all(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean any(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$any");
    int i;
    if (paramCharSequence.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    return i ^ 0x1;
  }
  
  public static final boolean any(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static final Iterable<Character> asIterable(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$asIterable");
    if ((paramCharSequence instanceof String))
    {
      int i;
      if (paramCharSequence.length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return (Iterable)CollectionsKt.emptyList();
      }
    }
    (Iterable)new Iterable()
    {
      public Iterator<Character> iterator()
      {
        return (Iterator)StringsKt.iterator(this.$this_asIterable$inlined);
      }
    };
  }
  
  public static final Sequence<Character> asSequence(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$asSequence");
    if ((paramCharSequence instanceof String))
    {
      int i;
      if (paramCharSequence.length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return SequencesKt.emptySequence();
      }
    }
    (Sequence)new Sequence()
    {
      public Iterator<Character> iterator()
      {
        return (Iterator)StringsKt.iterator(this.$this_asSequence$inlined);
      }
    };
  }
  
  public static final <K, V> Map<K, V> associate(CharSequence paramCharSequence, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramCharSequence.length()), 16));
    int i = 0;
    while (i < paramCharSequence.length())
    {
      Pair localPair = (Pair)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  public static final <K> Map<K, Character> associateBy(CharSequence paramCharSequence, Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramCharSequence.length()), 16));
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      localMap.put(paramFunction1.invoke(Character.valueOf(c)), Character.valueOf(c));
      i += 1;
    }
    return localMap;
  }
  
  public static final <K, V> Map<K, V> associateBy(CharSequence paramCharSequence, Function1<? super Character, ? extends K> paramFunction1, Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramCharSequence.length()), 16));
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      localMap.put(paramFunction1.invoke(Character.valueOf(c)), paramFunction11.invoke(Character.valueOf(c)));
      i += 1;
    }
    return localMap;
  }
  
  public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(CharSequence paramCharSequence, M paramM, Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      paramM.put(paramFunction1.invoke(Character.valueOf(c)), Character.valueOf(c));
      i += 1;
    }
    return paramM;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(CharSequence paramCharSequence, M paramM, Function1<? super Character, ? extends K> paramFunction1, Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      paramM.put(paramFunction1.invoke(Character.valueOf(c)), paramFunction11.invoke(Character.valueOf(c)));
      i += 1;
    }
    return paramM;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(CharSequence paramCharSequence, M paramM, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      Pair localPair = (Pair)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  public static final <V> Map<Character, V> associateWith(CharSequence paramCharSequence, Function1<? super Character, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateWith");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramCharSequence.length()), 16));
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      ((Map)localLinkedHashMap).put(Character.valueOf(c), paramFunction1.invoke(Character.valueOf(c)));
      i += 1;
    }
    return (Map)localLinkedHashMap;
  }
  
  public static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(CharSequence paramCharSequence, M paramM, Function1<? super Character, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateWithTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      paramM.put(Character.valueOf(c), paramFunction1.invoke(Character.valueOf(c)));
      i += 1;
    }
    return paramM;
  }
  
  public static final List<String> chunked(CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$chunked");
    return StringsKt.windowed(paramCharSequence, paramInt, paramInt, true);
  }
  
  public static final <R> List<R> chunked(CharSequence paramCharSequence, int paramInt, Function1<? super CharSequence, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$chunked");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return StringsKt.windowed(paramCharSequence, paramInt, paramInt, true, paramFunction1);
  }
  
  public static final Sequence<String> chunkedSequence(CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$chunkedSequence");
    return StringsKt.chunkedSequence(paramCharSequence, paramInt, (Function1)chunkedSequence.1.INSTANCE);
  }
  
  public static final <R> Sequence<R> chunkedSequence(CharSequence paramCharSequence, int paramInt, Function1<? super CharSequence, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$chunkedSequence");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return StringsKt.windowedSequence(paramCharSequence, paramInt, paramInt, true, paramFunction1);
  }
  
  private static final int count(CharSequence paramCharSequence)
  {
    return paramCharSequence.length();
  }
  
  public static final int count(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int k;
    for (int j = 0; i < paramCharSequence.length(); j = k)
    {
      k = j;
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static final CharSequence drop(CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$drop");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramCharSequence.subSequence(RangesKt.coerceAtMost(paramInt, paramCharSequence.length()), paramCharSequence.length());
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Requested character count ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public static final String drop(String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$drop");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramString = paramString.substring(RangesKt.coerceAtMost(paramInt, paramString.length()));
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("Requested character count ");
    paramString.append(paramInt);
    paramString.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
  
  public static final CharSequence dropLast(CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$dropLast");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return StringsKt.take(paramCharSequence, RangesKt.coerceAtLeast(paramCharSequence.length() - paramInt, 0));
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Requested character count ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public static final String dropLast(String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$dropLast");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return StringsKt.take(paramString, RangesKt.coerceAtLeast(paramString.length() - paramInt, 0));
    }
    paramString = new StringBuilder();
    paramString.append("Requested character count ");
    paramString.append(paramInt);
    paramString.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
  
  public static final CharSequence dropLastWhile(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = StringsKt.getLastIndex(paramCharSequence);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return paramCharSequence.subSequence(0, i + 1);
      }
      i -= 1;
    }
    return (CharSequence)"";
  }
  
  public static final String dropLastWhile(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = StringsKt.getLastIndex((CharSequence)paramString);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue())
      {
        paramString = paramString.substring(0, i + 1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return paramString;
      }
      i -= 1;
    }
    return "";
  }
  
  public static final CharSequence dropWhile(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return paramCharSequence.subSequence(i, paramCharSequence.length());
      }
      i += 1;
    }
    return (CharSequence)"";
  }
  
  public static final String dropWhile(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = ((CharSequence)paramString).length();
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue())
      {
        paramString = paramString.substring(i);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        return paramString;
      }
      i += 1;
    }
    return "";
  }
  
  private static final char elementAtOrElse(CharSequence paramCharSequence, int paramInt, Function1<? super Integer, Character> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= StringsKt.getLastIndex(paramCharSequence))) {
      return paramCharSequence.charAt(paramInt);
    }
    return ((Character)paramFunction1.invoke(Integer.valueOf(paramInt))).charValue();
  }
  
  private static final Character elementAtOrNull(CharSequence paramCharSequence, int paramInt)
  {
    return StringsKt.getOrNull(paramCharSequence, paramInt);
  }
  
  public static final CharSequence filter(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Appendable localAppendable = (Appendable)new StringBuilder();
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      i += 1;
    }
    return (CharSequence)localAppendable;
  }
  
  public static final String filter(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    Appendable localAppendable = (Appendable)new StringBuilder();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      i += 1;
    }
    paramString = ((StringBuilder)localAppendable).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "filterTo(StringBuilder(), predicate).toString()");
    return paramString;
  }
  
  public static final CharSequence filterIndexed(CharSequence paramCharSequence, Function2<? super Integer, ? super Character, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Appendable localAppendable = (Appendable)new StringBuilder();
    int j = 0;
    int i = 0;
    while (j < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(j);
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      j += 1;
      i += 1;
    }
    return (CharSequence)localAppendable;
  }
  
  public static final String filterIndexed(String paramString, Function2<? super Integer, ? super Character, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    paramString = (CharSequence)paramString;
    Appendable localAppendable = (Appendable)new StringBuilder();
    int j = 0;
    int i = 0;
    while (j < paramString.length())
    {
      char c = paramString.charAt(j);
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      j += 1;
      i += 1;
    }
    paramString = ((StringBuilder)localAppendable).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "filterIndexedTo(StringBu…(), predicate).toString()");
    return paramString;
  }
  
  public static final <C extends Appendable> C filterIndexedTo(CharSequence paramCharSequence, C paramC, Function2<? super Integer, ? super Character, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int j = 0;
    int i = 0;
    while (j < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(j);
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(c))).booleanValue()) {
        paramC.append(c);
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  public static final CharSequence filterNot(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Appendable localAppendable = (Appendable)new StringBuilder();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      i += 1;
    }
    return (CharSequence)localAppendable;
  }
  
  public static final String filterNot(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    Appendable localAppendable = (Appendable)new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      i += 1;
    }
    paramString = ((StringBuilder)localAppendable).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "filterNotTo(StringBuilder(), predicate).toString()");
    return paramString;
  }
  
  public static final <C extends Appendable> C filterNotTo(CharSequence paramCharSequence, C paramC, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        paramC.append(c);
      }
      i += 1;
    }
    return paramC;
  }
  
  public static final <C extends Appendable> C filterTo(CharSequence paramCharSequence, C paramC, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        paramC.append(c);
      }
      i += 1;
    }
    return paramC;
  }
  
  private static final Character find(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i += 1;
    }
    return null;
  }
  
  private static final Character findLast(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    int i = paramCharSequence.length();
    char c;
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      c = paramCharSequence.charAt(i);
    } while (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue());
    return Character.valueOf(c);
    return null;
  }
  
  public static final char first(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$first");
    int i;
    if (paramCharSequence.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return paramCharSequence.charAt(0);
    }
    throw ((Throwable)new NoSuchElementException("Char sequence is empty."));
  }
  
  public static final char first(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return c;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Char sequence contains no character matching the predicate."));
  }
  
  public static final Character firstOrNull(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$firstOrNull");
    int i;
    if (paramCharSequence.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    return Character.valueOf(paramCharSequence.charAt(0));
  }
  
  public static final Character firstOrNull(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i += 1;
    }
    return null;
  }
  
  public static final <R> List<R> flatMap(CharSequence paramCharSequence, Function1<? super Character, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i))));
      i += 1;
    }
    return (List)localCollection;
  }
  
  public static final <R, C extends Collection<? super R>> C flatMapTo(CharSequence paramCharSequence, C paramC, Function1<? super Character, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i))));
      i += 1;
    }
    return paramC;
  }
  
  public static final <R> R fold(CharSequence paramCharSequence, R paramR, Function2<? super R, ? super Character, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      paramR = paramFunction2.invoke(paramR, Character.valueOf(paramCharSequence.charAt(i)));
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(CharSequence paramCharSequence, R paramR, Function3<? super Integer, ? super R, ? super Character, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= paramCharSequence.length()) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Character.valueOf(c));
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(CharSequence paramCharSequence, R paramR, Function2<? super Character, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = StringsKt.getLastIndex(paramCharSequence);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Character.valueOf(paramCharSequence.charAt(i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(CharSequence paramCharSequence, R paramR, Function3<? super Integer, ? super Character, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = StringsKt.getLastIndex(paramCharSequence);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(paramCharSequence.charAt(i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final void forEach(CharSequence paramCharSequence, Function1<? super Character, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      i += 1;
    }
  }
  
  public static final void forEachIndexed(CharSequence paramCharSequence, Function2<? super Integer, ? super Character, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= paramCharSequence.length()) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Character.valueOf(c));
      j += 1;
    }
  }
  
  private static final char getOrElse(CharSequence paramCharSequence, int paramInt, Function1<? super Integer, Character> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= StringsKt.getLastIndex(paramCharSequence))) {
      return paramCharSequence.charAt(paramInt);
    }
    return ((Character)paramFunction1.invoke(Integer.valueOf(paramInt))).charValue();
  }
  
  public static final Character getOrNull(CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= StringsKt.getLastIndex(paramCharSequence))) {
      return Character.valueOf(paramCharSequence.charAt(paramInt));
    }
    return null;
  }
  
  public static final <K> Map<K, List<Character>> groupBy(CharSequence paramCharSequence, Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      Object localObject3 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(Character.valueOf(c));
      i += 1;
    }
    return localMap;
  }
  
  public static final <K, V> Map<K, List<V>> groupBy(CharSequence paramCharSequence, Function1<? super Character, ? extends K> paramFunction1, Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      Object localObject3 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(paramFunction11.invoke(Character.valueOf(c)));
      i += 1;
    }
    return localMap;
  }
  
  public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(CharSequence paramCharSequence, M paramM, Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      Object localObject3 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject2 = paramM.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject3, localObject1);
      }
      ((List)localObject1).add(Character.valueOf(c));
      i += 1;
    }
    return paramM;
  }
  
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(CharSequence paramCharSequence, M paramM, Function1<? super Character, ? extends K> paramFunction1, Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      Object localObject3 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject2 = paramM.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject3, localObject1);
      }
      ((List)localObject1).add(paramFunction11.invoke(Character.valueOf(c)));
      i += 1;
    }
    return paramM;
  }
  
  public static final <K> Grouping<Character, K> groupingBy(CharSequence paramCharSequence, final Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupingBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    (Grouping)new Grouping()
    {
      public K keyOf(char paramAnonymousChar)
      {
        return (K)paramFunction1.invoke(Character.valueOf(paramAnonymousChar));
      }
      
      public Iterator<Character> sourceIterator()
      {
        return (Iterator)StringsKt.iterator(this.$this_groupingBy);
      }
    };
  }
  
  public static final int indexOfFirst(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final char last(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$last");
    int i;
    if (paramCharSequence.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return paramCharSequence.charAt(StringsKt.getLastIndex(paramCharSequence));
    }
    throw ((Throwable)new NoSuchElementException("Char sequence is empty."));
  }
  
  public static final char last(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramCharSequence.length();
    char c;
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      c = paramCharSequence.charAt(i);
    } while (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue());
    return c;
    throw ((Throwable)new NoSuchElementException("Char sequence contains no character matching the predicate."));
  }
  
  public static final Character lastOrNull(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastOrNull");
    int i;
    if (paramCharSequence.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    return Character.valueOf(paramCharSequence.charAt(paramCharSequence.length() - 1));
  }
  
  public static final Character lastOrNull(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramCharSequence.length();
    char c;
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      c = paramCharSequence.charAt(i);
    } while (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue());
    return Character.valueOf(c);
    return null;
  }
  
  public static final <R> List<R> map(CharSequence paramCharSequence, Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramCharSequence.length());
    int i = 0;
    while (i < paramCharSequence.length())
    {
      localCollection.add(paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i))));
      i += 1;
    }
    return (List)localCollection;
  }
  
  public static final <R> List<R> mapIndexed(CharSequence paramCharSequence, Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramCharSequence.length());
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= paramCharSequence.length()) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Character.valueOf(c)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  public static final <R> List<R> mapIndexedNotNull(CharSequence paramCharSequence, Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapIndexedNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = 0;
    int i = 0;
    while (j < paramCharSequence.length())
    {
      Object localObject = paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(paramCharSequence.charAt(j)));
      if (localObject != null) {
        localCollection.add(localObject);
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  public static final <R, C extends Collection<? super R>> C mapIndexedNotNullTo(CharSequence paramCharSequence, C paramC, Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapIndexedNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = 0;
    int i = 0;
    while (j < paramCharSequence.length())
    {
      Object localObject = paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(paramCharSequence.charAt(j)));
      if (localObject != null) {
        paramC.add(localObject);
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(CharSequence paramCharSequence, C paramC, Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= paramCharSequence.length()) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Character.valueOf(c)));
      j += 1;
    }
    return paramC;
  }
  
  public static final <R> List<R> mapNotNull(CharSequence paramCharSequence, Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      Object localObject = paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      if (localObject != null) {
        localCollection.add(localObject);
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  public static final <R, C extends Collection<? super R>> C mapNotNullTo(CharSequence paramCharSequence, C paramC, Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      Object localObject = paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      if (localObject != null) {
        paramC.add(localObject);
      }
      i += 1;
    }
    return paramC;
  }
  
  public static final <R, C extends Collection<? super R>> C mapTo(CharSequence paramCharSequence, C paramC, Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      paramC.add(paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i))));
      i += 1;
    }
    return paramC;
  }
  
  public static final Character max(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$max");
    int i = paramCharSequence.length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    char c2 = c1;
    if (1 <= k)
    {
      i = j;
      for (c2 = c1;; c2 = c1)
      {
        char c3 = paramCharSequence.charAt(i);
        c1 = c2;
        if (c2 < c3) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return Character.valueOf(c2);
  }
  
  public static final <R extends Comparable<? super R>> Character maxBy(CharSequence paramCharSequence, Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int i = paramCharSequence.length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    if (k == 0) {
      return Character.valueOf(c1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Character.valueOf(c1));
    char c2 = c1;
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        c2 = paramCharSequence.charAt(i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(Character.valueOf(c2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          c1 = c2;
          localObject2 = localComparable;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    return Character.valueOf(c2);
  }
  
  public static final Character maxWith(CharSequence paramCharSequence, Comparator<? super Character> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    int i = paramCharSequence.length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    char c2 = c1;
    if (1 <= k)
    {
      i = j;
      for (c2 = c1;; c2 = c1)
      {
        char c3 = paramCharSequence.charAt(i);
        c1 = c2;
        if (paramComparator.compare(Character.valueOf(c2), Character.valueOf(c3)) < 0) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return Character.valueOf(c2);
  }
  
  public static final Character min(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$min");
    int i = paramCharSequence.length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    char c2 = c1;
    if (1 <= k)
    {
      i = j;
      for (c2 = c1;; c2 = c1)
      {
        char c3 = paramCharSequence.charAt(i);
        c1 = c2;
        if (c2 > c3) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return Character.valueOf(c2);
  }
  
  public static final <R extends Comparable<? super R>> Character minBy(CharSequence paramCharSequence, Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int i = paramCharSequence.length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    if (k == 0) {
      return Character.valueOf(c1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Character.valueOf(c1));
    char c2 = c1;
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        c2 = paramCharSequence.charAt(i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(Character.valueOf(c2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          c1 = c2;
          localObject2 = localComparable;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    return Character.valueOf(c2);
  }
  
  public static final Character minWith(CharSequence paramCharSequence, Comparator<? super Character> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    int i = paramCharSequence.length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    char c2 = c1;
    if (1 <= k)
    {
      i = j;
      for (c2 = c1;; c2 = c1)
      {
        char c3 = paramCharSequence.charAt(i);
        c1 = c2;
        if (paramComparator.compare(Character.valueOf(c2), Character.valueOf(c3)) > 0) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return Character.valueOf(c2);
  }
  
  public static final boolean none(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$none");
    return paramCharSequence.length() == 0;
  }
  
  public static final boolean none(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final <S extends CharSequence> S onEach(S paramS, Function1<? super Character, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramS, "$this$onEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int i = 0;
    while (i < paramS.length())
    {
      paramFunction1.invoke(Character.valueOf(paramS.charAt(i)));
      i += 1;
    }
    return paramS;
  }
  
  public static final Pair<CharSequence, CharSequence> partition(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localStringBuilder1.append(c);
      } else {
        localStringBuilder2.append(c);
      }
      i += 1;
    }
    return new Pair(localStringBuilder1, localStringBuilder2);
  }
  
  public static final Pair<String, String> partition(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localStringBuilder1.append(c);
      } else {
        localStringBuilder2.append(c);
      }
      i += 1;
    }
    return new Pair(localStringBuilder1.toString(), localStringBuilder2.toString());
  }
  
  private static final char random(CharSequence paramCharSequence)
  {
    return StringsKt.random(paramCharSequence, (Random)Random.Default);
  }
  
  public static final char random(CharSequence paramCharSequence, Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    int i;
    if (paramCharSequence.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return paramCharSequence.charAt(paramRandom.nextInt(paramCharSequence.length()));
    }
    throw ((Throwable)new NoSuchElementException("Char sequence is empty."));
  }
  
  public static final char reduce(CharSequence paramCharSequence, Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = paramCharSequence.length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      char c2 = paramCharSequence.charAt(0);
      int k = StringsKt.getLastIndex(paramCharSequence);
      char c1 = c2;
      if (1 <= k)
      {
        i = j;
        for (;;)
        {
          c2 = ((Character)paramFunction2.invoke(Character.valueOf(c2), Character.valueOf(paramCharSequence.charAt(i)))).charValue();
          c1 = c2;
          if (i == k) {
            break;
          }
          i += 1;
        }
      }
      return c1;
    }
    throw ((Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced."));
  }
  
  public static final char reduceIndexed(CharSequence paramCharSequence, Function3<? super Integer, ? super Character, ? super Character, Character> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = paramCharSequence.length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      char c2 = paramCharSequence.charAt(0);
      int k = StringsKt.getLastIndex(paramCharSequence);
      char c1 = c2;
      if (1 <= k)
      {
        i = j;
        for (;;)
        {
          c2 = ((Character)paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(c2), Character.valueOf(paramCharSequence.charAt(i)))).charValue();
          c1 = c2;
          if (i == k) {
            break;
          }
          i += 1;
        }
      }
      return c1;
    }
    throw ((Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced."));
  }
  
  public static final char reduceRight(CharSequence paramCharSequence, Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = StringsKt.getLastIndex(paramCharSequence);
    if (j >= 0)
    {
      int i = j - 1;
      char c = paramCharSequence.charAt(j);
      while (i >= 0)
      {
        c = ((Character)paramFunction2.invoke(Character.valueOf(paramCharSequence.charAt(i)), Character.valueOf(c))).charValue();
        i -= 1;
      }
      return c;
    }
    throw ((Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced."));
  }
  
  public static final char reduceRightIndexed(CharSequence paramCharSequence, Function3<? super Integer, ? super Character, ? super Character, Character> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = StringsKt.getLastIndex(paramCharSequence);
    if (j >= 0)
    {
      int i = j - 1;
      char c = paramCharSequence.charAt(j);
      while (i >= 0)
      {
        c = ((Character)paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(paramCharSequence.charAt(i)), Character.valueOf(c))).charValue();
        i -= 1;
      }
      return c;
    }
    throw ((Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced."));
  }
  
  public static final CharSequence reversed(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reversed");
    paramCharSequence = new StringBuilder(paramCharSequence).reverse();
    Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "StringBuilder(this).reverse()");
    return (CharSequence)paramCharSequence;
  }
  
  private static final String reversed(String paramString)
  {
    if (paramString != null) {
      return StringsKt.reversed((CharSequence)paramString).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  public static final char single(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$single");
    int i = paramCharSequence.length();
    if (i != 0)
    {
      if (i == 1) {
        return paramCharSequence.charAt(0);
      }
      throw ((Throwable)new IllegalArgumentException("Char sequence has more than one element."));
    }
    throw ((Throwable)new NoSuchElementException("Char sequence is empty."));
  }
  
  public static final char single(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Character localCharacter = (Character)null;
    int i = 0;
    int k;
    for (int j = 0; i < paramCharSequence.length(); j = k)
    {
      char c = paramCharSequence.charAt(i);
      k = j;
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        if (j == 0)
        {
          localCharacter = Character.valueOf(c);
          k = 1;
        }
        else
        {
          throw ((Throwable)new IllegalArgumentException("Char sequence contains more than one matching element."));
        }
      }
      i += 1;
    }
    if (j != 0)
    {
      if (localCharacter != null) {
        return localCharacter.charValue();
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
    }
    throw ((Throwable)new NoSuchElementException("Char sequence contains no character matching the predicate."));
  }
  
  public static final Character singleOrNull(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$singleOrNull");
    if (paramCharSequence.length() == 1) {
      return Character.valueOf(paramCharSequence.charAt(0));
    }
    return null;
  }
  
  public static final Character singleOrNull(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Character localCharacter = (Character)null;
    int i = 0;
    int k;
    for (int j = 0; i < paramCharSequence.length(); j = k)
    {
      char c = paramCharSequence.charAt(i);
      k = j;
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue())
      {
        if (j != 0) {
          return null;
        }
        localCharacter = Character.valueOf(c);
        k = 1;
      }
      i += 1;
    }
    if (j == 0) {
      return null;
    }
    return localCharacter;
  }
  
  public static final CharSequence slice(CharSequence paramCharSequence, Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return (CharSequence)"";
    }
    StringBuilder localStringBuilder = new StringBuilder(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localStringBuilder.append(paramCharSequence.charAt(((Number)paramIterable.next()).intValue()));
    }
    return (CharSequence)localStringBuilder;
  }
  
  public static final CharSequence slice(CharSequence paramCharSequence, IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return (CharSequence)"";
    }
    return StringsKt.subSequence(paramCharSequence, paramIntRange);
  }
  
  private static final String slice(String paramString, Iterable<Integer> paramIterable)
  {
    if (paramString != null) {
      return StringsKt.slice((CharSequence)paramString, paramIterable).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  public static final String slice(String paramString, IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return "";
    }
    return StringsKt.substring(paramString, paramIntRange);
  }
  
  public static final int sumBy(CharSequence paramCharSequence, Function1<? super Character, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int i = 0;
    int j = 0;
    while (i < paramCharSequence.length())
    {
      j += ((Number)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final double sumByDouble(CharSequence paramCharSequence, Function1<? super Character, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int i = 0;
    while (i < paramCharSequence.length())
    {
      d += ((Number)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  public static final CharSequence take(CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$take");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramCharSequence.subSequence(0, RangesKt.coerceAtMost(paramInt, paramCharSequence.length()));
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Requested character count ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public static final String take(String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$take");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramString = paramString.substring(0, RangesKt.coerceAtMost(paramInt, paramString.length()));
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("Requested character count ");
    paramString.append(paramInt);
    paramString.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
  
  public static final CharSequence takeLast(CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$takeLast");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = paramCharSequence.length();
      return paramCharSequence.subSequence(i - RangesKt.coerceAtMost(paramInt, i), i);
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Requested character count ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public static final String takeLast(String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$takeLast");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = paramString.length();
      paramString = paramString.substring(i - RangesKt.coerceAtMost(paramInt, i));
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("Requested character count ");
    paramString.append(paramInt);
    paramString.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
  
  public static final CharSequence takeLastWhile(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = StringsKt.getLastIndex(paramCharSequence);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return paramCharSequence.subSequence(i + 1, paramCharSequence.length());
      }
      i -= 1;
    }
    return paramCharSequence.subSequence(0, paramCharSequence.length());
  }
  
  public static final String takeLastWhile(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = StringsKt.getLastIndex((CharSequence)paramString);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue())
      {
        paramString = paramString.substring(i + 1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        return paramString;
      }
      i -= 1;
    }
    return paramString;
  }
  
  public static final CharSequence takeWhile(CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return paramCharSequence.subSequence(0, i);
      }
      i += 1;
    }
    return paramCharSequence.subSequence(0, paramCharSequence.length());
  }
  
  public static final String takeWhile(String paramString, Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue())
      {
        paramString = paramString.substring(0, i);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return paramString;
      }
      i += 1;
    }
    return paramString;
  }
  
  public static final <C extends Collection<? super Character>> C toCollection(CharSequence paramCharSequence, C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      paramC.add(Character.valueOf(paramCharSequence.charAt(i)));
      i += 1;
    }
    return paramC;
  }
  
  public static final HashSet<Character> toHashSet(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toHashSet");
    return (HashSet)StringsKt.toCollection(paramCharSequence, (Collection)new HashSet(MapsKt.mapCapacity(paramCharSequence.length())));
  }
  
  public static final List<Character> toList(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toList");
    int i = paramCharSequence.length();
    if (i != 0)
    {
      if (i != 1) {
        return StringsKt.toMutableList(paramCharSequence);
      }
      return CollectionsKt.listOf(Character.valueOf(paramCharSequence.charAt(0)));
    }
    return CollectionsKt.emptyList();
  }
  
  public static final List<Character> toMutableList(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toMutableList");
    return (List)StringsKt.toCollection(paramCharSequence, (Collection)new ArrayList(paramCharSequence.length()));
  }
  
  public static final Set<Character> toSet(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toSet");
    int i = paramCharSequence.length();
    if (i != 0)
    {
      if (i != 1) {
        return (Set)StringsKt.toCollection(paramCharSequence, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramCharSequence.length())));
      }
      return SetsKt.setOf(Character.valueOf(paramCharSequence.charAt(0)));
    }
    return SetsKt.emptySet();
  }
  
  public static final List<String> windowed(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$windowed");
    return StringsKt.windowed(paramCharSequence, paramInt1, paramInt2, paramBoolean, (Function1)windowed.1.INSTANCE);
  }
  
  public static final <R> List<R> windowed(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean, Function1<? super CharSequence, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$windowed");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    SlidingWindowKt.checkWindowSizeStep(paramInt1, paramInt2);
    int k = paramCharSequence.length();
    int m = k / paramInt2;
    int j = 0;
    if (k % paramInt2 == 0) {
      i = 0;
    } else {
      i = 1;
    }
    ArrayList localArrayList = new ArrayList(m + i);
    int i = j;
    while ((i >= 0) && (k > i))
    {
      m = i + paramInt1;
      if (m >= 0)
      {
        j = m;
        if (m <= k) {}
      }
      else
      {
        if (!paramBoolean) {
          break;
        }
        j = k;
      }
      localArrayList.add(paramFunction1.invoke(paramCharSequence.subSequence(i, j)));
      i += paramInt2;
    }
    return (List)localArrayList;
  }
  
  public static final Sequence<String> windowedSequence(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$windowedSequence");
    return StringsKt.windowedSequence(paramCharSequence, paramInt1, paramInt2, paramBoolean, (Function1)windowedSequence.1.INSTANCE);
  }
  
  public static final <R> Sequence<R> windowedSequence(CharSequence paramCharSequence, final int paramInt1, int paramInt2, boolean paramBoolean, final Function1<? super CharSequence, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$windowedSequence");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    SlidingWindowKt.checkWindowSizeStep(paramInt1, paramInt2);
    IntRange localIntRange;
    if (paramBoolean) {
      localIntRange = StringsKt.getIndices(paramCharSequence);
    } else {
      localIntRange = RangesKt.until(0, paramCharSequence.length() - paramInt1 + 1);
    }
    SequencesKt.map(CollectionsKt.asSequence((Iterable)RangesKt.step((IntProgression)localIntRange, paramInt2)), (Function1)new Lambda(paramCharSequence)
    {
      public final R invoke(int paramAnonymousInt)
      {
        int j = paramInt1 + paramAnonymousInt;
        int i;
        if (j >= 0)
        {
          i = j;
          if (j <= this.$this_windowedSequence.length()) {}
        }
        else
        {
          i = this.$this_windowedSequence.length();
        }
        return (R)paramFunction1.invoke(this.$this_windowedSequence.subSequence(paramAnonymousInt, i));
      }
    });
  }
  
  public static final Iterable<IndexedValue<Character>> withIndex(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$withIndex");
    (Iterable)new IndexingIterable((Function0)new Lambda(paramCharSequence)
    {
      public final CharIterator invoke()
      {
        return StringsKt.iterator(this.$this_withIndex);
      }
    });
  }
  
  public static final List<Pair<Character, Character>> zip(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Character.valueOf(paramCharSequence1.charAt(i)), Character.valueOf(paramCharSequence2.charAt(i))));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  public static final <V> List<V> zip(CharSequence paramCharSequence1, CharSequence paramCharSequence2, Function2<? super Character, ? super Character, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Character.valueOf(paramCharSequence1.charAt(i)), Character.valueOf(paramCharSequence2.charAt(i))));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  public static final List<Pair<Character, Character>> zipWithNext(CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$zipWithNext");
    int j = paramCharSequence.length() - 1;
    if (j < 1) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      char c = paramCharSequence.charAt(i);
      i += 1;
      localArrayList.add(TuplesKt.to(Character.valueOf(c), Character.valueOf(paramCharSequence.charAt(i))));
    }
    return (List)localArrayList;
  }
  
  public static final <R> List<R> zipWithNext(CharSequence paramCharSequence, Function2<? super Character, ? super Character, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$zipWithNext");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramCharSequence.length() - 1;
    if (j < 1) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      char c = paramCharSequence.charAt(i);
      i += 1;
      localArrayList.add(paramFunction2.invoke(Character.valueOf(c), Character.valueOf(paramCharSequence.charAt(i))));
    }
    return (List)localArrayList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\StringsKt___StringsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */