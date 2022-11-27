package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv={1, 0, 3}, d1={"\000~\n\000\n\002\020\b\n\000\n\002\020$\n\002\b\003\n\002\030\002\n\002\030\002\n\000\n\002\020\021\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\006\n\002\020%\n\000\n\002\020&\n\002\b\003\n\002\020\013\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\f\n\002\030\002\n\002\b\n\n\002\020(\n\002\020)\n\002\020'\n\002\b\n\n\002\020\034\n\002\030\002\n\000\n\002\020\002\n\002\b\026\032\036\020\002\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005\0321\020\006\032\036\022\004\022\002H\004\022\004\022\002H\0050\007j\016\022\004\022\002H\004\022\004\022\002H\005`\b\"\004\b\000\020\004\"\004\b\001\020\005H\b\032_\020\006\032\036\022\004\022\002H\004\022\004\022\002H\0050\007j\016\022\004\022\002H\004\022\004\022\002H\005`\b\"\004\b\000\020\004\"\004\b\001\020\0052*\020\t\032\026\022\022\b\001\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130\n\"\016\022\004\022\002H\004\022\004\022\002H\0050\013¢\006\002\020\f\0321\020\r\032\036\022\004\022\002H\004\022\004\022\002H\0050\016j\016\022\004\022\002H\004\022\004\022\002H\005`\017\"\004\b\000\020\004\"\004\b\001\020\005H\b\032_\020\r\032\036\022\004\022\002H\004\022\004\022\002H\0050\016j\016\022\004\022\002H\004\022\004\022\002H\005`\017\"\004\b\000\020\004\"\004\b\001\020\0052*\020\t\032\026\022\022\b\001\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130\n\"\016\022\004\022\002H\004\022\004\022\002H\0050\013¢\006\002\020\020\032\020\020\021\032\0020\0012\006\020\022\032\0020\001H\001\032!\020\023\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005H\b\032O\020\023\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\0052*\020\t\032\026\022\022\b\001\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130\n\"\016\022\004\022\002H\004\022\004\022\002H\0050\013¢\006\002\020\024\032!\020\025\032\016\022\004\022\002H\004\022\004\022\002H\0050\026\"\004\b\000\020\004\"\004\b\001\020\005H\b\032O\020\025\032\016\022\004\022\002H\004\022\004\022\002H\0050\026\"\004\b\000\020\004\"\004\b\001\020\0052*\020\t\032\026\022\022\b\001\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130\n\"\016\022\004\022\002H\004\022\004\022\002H\0050\013¢\006\002\020\024\032*\020\027\032\002H\004\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\030H\n¢\006\002\020\031\032*\020\032\032\002H\005\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\030H\n¢\006\002\020\031\0329\020\033\032\0020\034\"\t\b\000\020\004¢\006\002\b\035\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\006\020\036\032\002H\004H\n¢\006\002\020\037\0321\020 \032\0020\034\"\t\b\000\020\004¢\006\002\b\035*\016\022\006\b\001\022\002H\004\022\002\b\0030\0032\006\020\036\032\002H\004H\b¢\006\002\020\037\0327\020!\032\0020\034\"\004\b\000\020\004\"\t\b\001\020\005¢\006\002\b\035*\016\022\004\022\002H\004\022\004\022\002H\0050\0032\006\020\"\032\002H\005H\b¢\006\002\020\037\032S\020#\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\036\020$\032\032\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\030\022\004\022\0020\0340%H\b\032G\020&\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\022\020$\032\016\022\004\022\002H\004\022\004\022\0020\0340%H\b\032S\020'\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\036\020$\032\032\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\030\022\004\022\0020\0340%H\b\032n\020(\032\002H)\"\004\b\000\020\004\"\004\b\001\020\005\"\030\b\002\020)*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\026*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\006\020*\032\002H)2\036\020$\032\032\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\030\022\004\022\0020\0340%H\b¢\006\002\020+\032n\020,\032\002H)\"\004\b\000\020\004\"\004\b\001\020\005\"\030\b\002\020)*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\026*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\006\020*\032\002H)2\036\020$\032\032\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\030\022\004\022\0020\0340%H\b¢\006\002\020+\032G\020-\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\022\020$\032\016\022\004\022\002H\005\022\004\022\0020\0340%H\b\032;\020.\032\004\030\001H\005\"\t\b\000\020\004¢\006\002\b\035\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\006\020\036\032\002H\004H\n¢\006\002\020/\032@\0200\032\002H\005\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\0032\006\020\036\032\002H\0042\f\0201\032\b\022\004\022\002H\00502H\b¢\006\002\0203\032@\0204\032\002H\005\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\0032\006\020\036\032\002H\0042\f\0201\032\b\022\004\022\002H\00502H\b¢\006\002\0203\032@\0205\032\002H\005\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\0262\006\020\036\032\002H\0042\f\0201\032\b\022\004\022\002H\00502H\b¢\006\002\0203\0321\0206\032\002H\005\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\0032\006\020\036\032\002H\004H\007¢\006\002\020/\032<\0207\032\002H8\"\024\b\000\020)*\n\022\002\b\003\022\002\b\0030\003*\002H8\"\004\b\001\0208*\002H)2\f\0201\032\b\022\004\022\002H802H\b¢\006\002\0209\032'\020:\032\0020\034\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\003H\b\032:\020;\032\0020\034\"\004\b\000\020\004\"\004\b\001\020\005*\022\022\006\b\001\022\002H\004\022\004\022\002H\005\030\0010\003H\b\002\016\n\f\b\000\022\002\030\001\032\004\b\003\020\000\0329\020<\032\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0300=\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\003H\n\032<\020<\032\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050?0>\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\026H\n¢\006\002\b@\032Y\020A\032\016\022\004\022\002H8\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005\"\004\b\002\0208*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\036\020B\032\032\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\030\022\004\022\002H80%H\b\032t\020C\032\002H)\"\004\b\000\020\004\"\004\b\001\020\005\"\004\b\002\0208\"\030\b\003\020)*\022\022\006\b\000\022\002H8\022\006\b\000\022\002H\0050\026*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\006\020*\032\002H)2\036\020B\032\032\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\030\022\004\022\002H80%H\b¢\006\002\020+\032Y\020D\032\016\022\004\022\002H\004\022\004\022\002H80\003\"\004\b\000\020\004\"\004\b\001\020\005\"\004\b\002\0208*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\036\020B\032\032\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\030\022\004\022\002H80%H\b\032t\020E\032\002H)\"\004\b\000\020\004\"\004\b\001\020\005\"\004\b\002\0208\"\030\b\003\020)*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H80\026*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\006\020*\032\002H)2\036\020B\032\032\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\030\022\004\022\002H80%H\b¢\006\002\020+\032@\020F\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\006\020\036\032\002H\004H\002¢\006\002\020G\032H\020F\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\016\020H\032\n\022\006\b\001\022\002H\0040\nH\002¢\006\002\020I\032A\020F\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\f\020H\032\b\022\004\022\002H\0040JH\002\032A\020F\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\f\020H\032\b\022\004\022\002H\0040KH\002\0322\020L\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\0262\006\020\036\032\002H\004H\n¢\006\002\020N\032:\020L\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\0262\016\020H\032\n\022\006\b\001\022\002H\0040\nH\n¢\006\002\020O\0323\020L\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\0262\f\020H\032\b\022\004\022\002H\0040JH\n\0323\020L\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\0262\f\020H\032\b\022\004\022\002H\0040KH\n\0320\020P\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\003H\000\0323\020Q\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\004\022\002H\004\022\004\022\002H\005\030\0010\003H\b\032T\020R\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\032\020\t\032\026\022\022\b\001\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130\nH\002¢\006\002\020S\032G\020R\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\022\020T\032\016\022\004\022\002H\004\022\004\022\002H\0050\013H\002\032M\020R\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\030\020\t\032\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130JH\002\032I\020R\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\024\020U\032\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\003H\002\032M\020R\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\030\020\t\032\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130KH\002\032J\020V\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\0262\032\020\t\032\026\022\022\b\001\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130\nH\n¢\006\002\020W\032=\020V\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\0262\022\020T\032\016\022\004\022\002H\004\022\004\022\002H\0050\013H\n\032C\020V\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\0262\030\020\t\032\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130JH\n\032=\020V\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\0262\022\020U\032\016\022\004\022\002H\004\022\004\022\002H\0050\003H\n\032C\020V\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\0262\030\020\t\032\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130KH\n\032G\020X\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\0262\032\020\t\032\026\022\022\b\001\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130\n¢\006\002\020W\032@\020X\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\0262\030\020\t\032\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130J\032@\020X\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\0262\030\020\t\032\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130K\032;\020Y\032\004\030\001H\005\"\t\b\000\020\004¢\006\002\b\035\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0262\006\020\036\032\002H\004H\b¢\006\002\020/\032:\020Z\032\0020M\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\0262\006\020\036\032\002H\0042\006\020\"\032\002H\005H\n¢\006\002\020[\032;\020\\\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\026\022\022\b\001\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130\n¢\006\002\020\024\032Q\020\\\032\002H)\"\004\b\000\020\004\"\004\b\001\020\005\"\030\b\002\020)*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\026*\026\022\022\b\001\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130\n2\006\020*\032\002H)¢\006\002\020]\0324\020\\\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130J\032O\020\\\032\002H)\"\004\b\000\020\004\"\004\b\001\020\005\"\030\b\002\020)*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\026*\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130J2\006\020*\032\002H)¢\006\002\020^\0322\020\\\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\003H\007\032M\020\\\032\002H)\"\004\b\000\020\004\"\004\b\001\020\005\"\030\b\002\020)*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\026*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\0032\006\020*\032\002H)H\007¢\006\002\020_\0324\020\\\032\016\022\004\022\002H\004\022\004\022\002H\0050\003\"\004\b\000\020\004\"\004\b\001\020\005*\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130K\032O\020\\\032\002H)\"\004\b\000\020\004\"\004\b\001\020\005\"\030\b\002\020)*\022\022\006\b\000\022\002H\004\022\006\b\000\022\002H\0050\026*\024\022\020\022\016\022\004\022\002H\004\022\004\022\002H\0050\0130K2\006\020*\032\002H)¢\006\002\020`\0322\020a\032\016\022\004\022\002H\004\022\004\022\002H\0050\026\"\004\b\000\020\004\"\004\b\001\020\005*\020\022\006\b\001\022\002H\004\022\004\022\002H\0050\003H\007\0321\020b\032\016\022\004\022\002H\004\022\004\022\002H\0050\013\"\004\b\000\020\004\"\004\b\001\020\005*\016\022\004\022\002H\004\022\004\022\002H\0050\030H\b\"\016\020\000\032\0020\001XT¢\006\002\n\000¨\006c"}, d2={"INT_MAX_POWER_OF_TWO", "", "emptyMap", "", "K", "V", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "mapCapacity", "expectedSize", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "contains", "", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "filter", "predicate", "Lkotlin/Function1;", "filterKeys", "filterNot", "filterNotTo", "M", "destination", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "ifEmpty", "R", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "iterator", "", "", "", "mutableIterator", "mapKeys", "transform", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "Lkotlin/sequences/Sequence;", "minusAssign", "", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "pair", "map", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/MapsKt")
class MapsKt__MapsKt
  extends MapsKt__MapsJVMKt
{
  private static final int INT_MAX_POWER_OF_TWO = 1073741824;
  
  private static final <K, V> K component1(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "$this$component1");
    return (K)paramEntry.getKey();
  }
  
  private static final <K, V> V component2(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "$this$component2");
    return (V)paramEntry.getValue();
  }
  
  private static final <K, V> boolean contains(Map<? extends K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$contains");
    return paramMap.containsKey(paramK);
  }
  
  private static final <K> boolean containsKey(Map<? extends K, ?> paramMap, K paramK)
  {
    if (paramMap != null) {
      return paramMap.containsKey(paramK);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
  }
  
  private static final <K, V> boolean containsValue(Map<K, ? extends V> paramMap, V paramV)
  {
    return paramMap.containsValue(paramV);
  }
  
  public static final <K, V> Map<K, V> emptyMap()
  {
    EmptyMap localEmptyMap = EmptyMap.INSTANCE;
    if (localEmptyMap != null) {
      return (Map)localEmptyMap;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
  }
  
  public static final <K, V> Map<K, V> filter(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Map localMap = (Map)new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)paramFunction1.invoke(localEntry)).booleanValue()) {
        localMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localMap;
  }
  
  public static final <K, V> Map<K, V> filterKeys(Map<? extends K, ? extends V> paramMap, Function1<? super K, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterKeys");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)paramFunction1.invoke(localEntry.getKey())).booleanValue()) {
        localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return (Map)localLinkedHashMap;
  }
  
  public static final <K, V> Map<K, V> filterNot(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Map localMap = (Map)new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!((Boolean)paramFunction1.invoke(localEntry)).booleanValue()) {
        localMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localMap;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(Map<? extends K, ? extends V> paramMap, M paramM, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!((Boolean)paramFunction1.invoke(localEntry)).booleanValue()) {
        paramM.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return paramM;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(Map<? extends K, ? extends V> paramMap, M paramM, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)paramFunction1.invoke(localEntry)).booleanValue()) {
        paramM.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return paramM;
  }
  
  public static final <K, V> Map<K, V> filterValues(Map<? extends K, ? extends V> paramMap, Function1<? super V, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$filterValues");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)paramFunction1.invoke(localEntry.getValue())).booleanValue()) {
        localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return (Map)localLinkedHashMap;
  }
  
  private static final <K, V> V get(Map<? extends K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$get");
    return (V)paramMap.get(paramK);
  }
  
  private static final <K, V> V getOrElse(Map<K, ? extends V> paramMap, K paramK, Function0<? extends V> paramFunction0)
  {
    paramMap = paramMap.get(paramK);
    if (paramMap != null) {
      return paramMap;
    }
    return (V)paramFunction0.invoke();
  }
  
  public static final <K, V> V getOrElseNullable(Map<K, ? extends V> paramMap, K paramK, Function0<? extends V> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$getOrElseNullable");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "defaultValue");
    Object localObject = paramMap.get(paramK);
    if ((localObject == null) && (!paramMap.containsKey(paramK))) {
      return (V)paramFunction0.invoke();
    }
    return (V)localObject;
  }
  
  public static final <K, V> V getOrPut(Map<K, V> paramMap, K paramK, Function0<? extends V> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$getOrPut");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "defaultValue");
    Object localObject2 = paramMap.get(paramK);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramFunction0.invoke();
      paramMap.put(paramK, localObject1);
    }
    return (V)localObject1;
  }
  
  public static final <K, V> V getValue(Map<K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$getValue");
    return (V)MapsKt.getOrImplicitDefaultNullable(paramMap, paramK);
  }
  
  private static final <K, V> HashMap<K, V> hashMapOf()
  {
    return new HashMap();
  }
  
  public static final <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    HashMap localHashMap = new HashMap(MapsKt.mapCapacity(paramVarArgs.length));
    MapsKt.putAll((Map)localHashMap, paramVarArgs);
    return localHashMap;
  }
  
  private static final <M extends Map<?, ?>,  extends R, R> R ifEmpty(M paramM, Function0<? extends R> paramFunction0)
  {
    Object localObject = paramM;
    if (paramM.isEmpty()) {
      localObject = paramFunction0.invoke();
    }
    return (R)localObject;
  }
  
  private static final <K, V> boolean isNotEmpty(Map<? extends K, ? extends V> paramMap)
  {
    return paramMap.isEmpty() ^ true;
  }
  
  private static final <K, V> boolean isNullOrEmpty(Map<? extends K, ? extends V> paramMap)
  {
    return (paramMap == null) || (paramMap.isEmpty());
  }
  
  private static final <K, V> Iterator<Map.Entry<K, V>> iterator(Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$iterator");
    return paramMap.entrySet().iterator();
  }
  
  private static final <K, V> LinkedHashMap<K, V> linkedMapOf()
  {
    return new LinkedHashMap();
  }
  
  public static final <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    return (LinkedHashMap)MapsKt.toMap(paramVarArgs, (Map)new LinkedHashMap(MapsKt.mapCapacity(paramVarArgs.length)));
  }
  
  public static final int mapCapacity(int paramInt)
  {
    if (paramInt < 3) {
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return paramInt + paramInt / 3;
    }
    return Integer.MAX_VALUE;
  }
  
  public static final <K, V, R> Map<R, V> mapKeys(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapKeys");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(MapsKt.mapCapacity(paramMap.size()));
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramMap.next();
      localMap.put(paramFunction1.invoke(localObject), ((Map.Entry)localObject).getValue());
    }
    return localMap;
  }
  
  public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(Map<? extends K, ? extends V> paramMap, M paramM, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapKeysTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramMap.next();
      paramM.put(paramFunction1.invoke(localObject), ((Map.Entry)localObject).getValue());
    }
    return paramM;
  }
  
  private static final <K, V> Map<K, V> mapOf()
  {
    return MapsKt.emptyMap();
  }
  
  public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    if (paramVarArgs.length > 0) {
      return MapsKt.toMap(paramVarArgs, (Map)new LinkedHashMap(MapsKt.mapCapacity(paramVarArgs.length)));
    }
    return MapsKt.emptyMap();
  }
  
  public static final <K, V, R> Map<K, R> mapValues(Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapValues");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(MapsKt.mapCapacity(paramMap.size()));
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramMap.next();
      localMap.put(((Map.Entry)localObject).getKey(), paramFunction1.invoke(localObject));
    }
    return localMap;
  }
  
  public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(Map<? extends K, ? extends V> paramMap, M paramM, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapValuesTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramMap.next();
      paramM.put(((Map.Entry)localObject).getKey(), paramFunction1.invoke(localObject));
    }
    return paramM;
  }
  
  public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> paramMap, Iterable<? extends K> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "keys");
    paramMap = MapsKt.toMutableMap(paramMap);
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramIterable);
    return MapsKt.optimizeReadOnlyMap(paramMap);
  }
  
  public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minus");
    paramMap = MapsKt.toMutableMap(paramMap);
    paramMap.remove(paramK);
    return MapsKt.optimizeReadOnlyMap(paramMap);
  }
  
  public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> paramMap, Sequence<? extends K> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramSequence, "keys");
    paramMap = MapsKt.toMutableMap(paramMap);
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramSequence);
    return MapsKt.optimizeReadOnlyMap(paramMap);
  }
  
  public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> paramMap, K[] paramArrayOfK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfK, "keys");
    paramMap = MapsKt.toMutableMap(paramMap);
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramArrayOfK);
    return MapsKt.optimizeReadOnlyMap(paramMap);
  }
  
  private static final <K, V> void minusAssign(Map<K, V> paramMap, Iterable<? extends K> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minusAssign");
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramIterable);
  }
  
  private static final <K, V> void minusAssign(Map<K, V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minusAssign");
    paramMap.remove(paramK);
  }
  
  private static final <K, V> void minusAssign(Map<K, V> paramMap, Sequence<? extends K> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minusAssign");
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramSequence);
  }
  
  private static final <K, V> void minusAssign(Map<K, V> paramMap, K[] paramArrayOfK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minusAssign");
    CollectionsKt.removeAll((Collection)paramMap.keySet(), paramArrayOfK);
  }
  
  private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(Map<K, V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$iterator");
    return paramMap.entrySet().iterator();
  }
  
  private static final <K, V> Map<K, V> mutableMapOf()
  {
    return (Map)new LinkedHashMap();
  }
  
  public static final <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "pairs");
    Map localMap = (Map)new LinkedHashMap(MapsKt.mapCapacity(paramVarArgs.length));
    MapsKt.putAll(localMap, paramVarArgs);
    return localMap;
  }
  
  public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$optimizeReadOnlyMap");
    int i = paramMap.size();
    if (i != 0)
    {
      if (i != 1) {
        return paramMap;
      }
      return MapsKt.toSingletonMap(paramMap);
    }
    return MapsKt.emptyMap();
  }
  
  private static final <K, V> Map<K, V> orEmpty(Map<K, ? extends V> paramMap)
  {
    if (paramMap != null) {
      return paramMap;
    }
    return MapsKt.emptyMap();
  }
  
  public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> paramMap, Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "pairs");
    if (paramMap.isEmpty()) {
      return MapsKt.toMap(paramIterable);
    }
    paramMap = (Map)new LinkedHashMap(paramMap);
    MapsKt.putAll(paramMap, paramIterable);
    return paramMap;
  }
  
  public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2)
  {
    Intrinsics.checkParameterIsNotNull(paramMap1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramMap2, "map");
    paramMap1 = new LinkedHashMap(paramMap1);
    paramMap1.putAll(paramMap2);
    return (Map)paramMap1;
  }
  
  public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> paramMap, Pair<? extends K, ? extends V> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramPair, "pair");
    if (paramMap.isEmpty()) {
      return MapsKt.mapOf(paramPair);
    }
    paramMap = new LinkedHashMap(paramMap);
    paramMap.put(paramPair.getFirst(), paramPair.getSecond());
    return (Map)paramMap;
  }
  
  public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> paramMap, Sequence<? extends Pair<? extends K, ? extends V>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramSequence, "pairs");
    paramMap = (Map)new LinkedHashMap(paramMap);
    MapsKt.putAll(paramMap, paramSequence);
    return MapsKt.optimizeReadOnlyMap(paramMap);
  }
  
  public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> paramMap, Pair<? extends K, ? extends V>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "pairs");
    if (paramMap.isEmpty()) {
      return MapsKt.toMap(paramArrayOfPair);
    }
    paramMap = (Map)new LinkedHashMap(paramMap);
    MapsKt.putAll(paramMap, paramArrayOfPair);
    return paramMap;
  }
  
  private static final <K, V> void plusAssign(Map<? super K, ? super V> paramMap, Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    MapsKt.putAll(paramMap, paramIterable);
  }
  
  private static final <K, V> void plusAssign(Map<? super K, ? super V> paramMap, Map<K, ? extends V> paramMap1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    paramMap.putAll(paramMap1);
  }
  
  private static final <K, V> void plusAssign(Map<? super K, ? super V> paramMap, Pair<? extends K, ? extends V> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    paramMap.put(paramPair.getFirst(), paramPair.getSecond());
  }
  
  private static final <K, V> void plusAssign(Map<? super K, ? super V> paramMap, Sequence<? extends Pair<? extends K, ? extends V>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    MapsKt.putAll(paramMap, paramSequence);
  }
  
  private static final <K, V> void plusAssign(Map<? super K, ? super V> paramMap, Pair<? extends K, ? extends V>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$plusAssign");
    MapsKt.putAll(paramMap, paramArrayOfPair);
  }
  
  public static final <K, V> void putAll(Map<? super K, ? super V> paramMap, Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$putAll");
    Intrinsics.checkParameterIsNotNull(paramIterable, "pairs");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Pair localPair = (Pair)paramIterable.next();
      paramMap.put(localPair.component1(), localPair.component2());
    }
  }
  
  public static final <K, V> void putAll(Map<? super K, ? super V> paramMap, Sequence<? extends Pair<? extends K, ? extends V>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$putAll");
    Intrinsics.checkParameterIsNotNull(paramSequence, "pairs");
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Pair localPair = (Pair)paramSequence.next();
      paramMap.put(localPair.component1(), localPair.component2());
    }
  }
  
  public static final <K, V> void putAll(Map<? super K, ? super V> paramMap, Pair<? extends K, ? extends V>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$putAll");
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "pairs");
    int j = paramArrayOfPair.length;
    int i = 0;
    while (i < j)
    {
      Pair<? extends K, ? extends V> localPair = paramArrayOfPair[i];
      paramMap.put(localPair.component1(), localPair.component2());
      i += 1;
    }
  }
  
  private static final <K, V> V remove(Map<? extends K, V> paramMap, K paramK)
  {
    if (paramMap != null) {
      return (V)TypeIntrinsics.asMutableMap(paramMap).remove(paramK);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
  }
  
  private static final <K, V> void set(Map<K, V> paramMap, K paramK, V paramV)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$set");
    paramMap.put(paramK, paramV);
  }
  
  public static final <K, V> Map<K, V> toMap(Iterable<? extends Pair<? extends K, ? extends V>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toMap");
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      int i = localCollection.size();
      if (i != 0)
      {
        if (i != 1) {
          return MapsKt.toMap(paramIterable, (Map)new LinkedHashMap(MapsKt.mapCapacity(localCollection.size())));
        }
        if ((paramIterable instanceof List)) {
          paramIterable = ((List)paramIterable).get(0);
        } else {
          paramIterable = paramIterable.iterator().next();
        }
        return MapsKt.mapOf((Pair)paramIterable);
      }
      return MapsKt.emptyMap();
    }
    return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(paramIterable, (Map)new LinkedHashMap()));
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> paramIterable, M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$toMap");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    MapsKt.putAll(paramM, paramIterable);
    return paramM;
  }
  
  public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toMap");
    int i = paramMap.size();
    if (i != 0)
    {
      if (i != 1) {
        return MapsKt.toMutableMap(paramMap);
      }
      return MapsKt.toSingletonMap(paramMap);
    }
    return MapsKt.emptyMap();
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Map<? extends K, ? extends V> paramMap, M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toMap");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    paramM.putAll(paramMap);
    return paramM;
  }
  
  public static final <K, V> Map<K, V> toMap(Sequence<? extends Pair<? extends K, ? extends V>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toMap");
    return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(paramSequence, (Map)new LinkedHashMap()));
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Sequence<? extends Pair<? extends K, ? extends V>> paramSequence, M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$toMap");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    MapsKt.putAll(paramM, paramSequence);
    return paramM;
  }
  
  public static final <K, V> Map<K, V> toMap(Pair<? extends K, ? extends V>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "$this$toMap");
    int i = paramArrayOfPair.length;
    if (i != 0)
    {
      if (i != 1) {
        return MapsKt.toMap(paramArrayOfPair, (Map)new LinkedHashMap(MapsKt.mapCapacity(paramArrayOfPair.length)));
      }
      return MapsKt.mapOf(paramArrayOfPair[0]);
    }
    return MapsKt.emptyMap();
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Pair<? extends K, ? extends V>[] paramArrayOfPair, M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "$this$toMap");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    MapsKt.putAll(paramM, paramArrayOfPair);
    return paramM;
  }
  
  public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toMutableMap");
    return (Map)new LinkedHashMap(paramMap);
  }
  
  private static final <K, V> Pair<K, V> toPair(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    return new Pair(paramEntry.getKey(), paramEntry.getValue());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\MapsKt__MapsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */