package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\001\n\000\n\002\020 \n\000\n\002\020\021\n\000\n\002\020\013\n\002\020\030\n\002\020\005\n\002\020\022\n\002\020\f\n\002\020\031\n\002\020\006\n\002\020\023\n\002\020\007\n\002\020\024\n\002\020\b\n\002\020\025\n\002\020\t\n\002\020\026\n\002\020\n\n\002\020\027\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\f\n\002\020\016\n\002\b\027\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\020\037\n\002\b\005\n\002\020\036\n\002\b\004\n\002\020\017\n\002\b\006\n\002\030\002\n\002\b\f\032#\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\003¢\006\002\020\004\032\020\020\000\032\b\022\004\022\0020\0050\001*\0020\006\032\020\020\000\032\b\022\004\022\0020\0070\001*\0020\b\032\020\020\000\032\b\022\004\022\0020\t0\001*\0020\n\032\020\020\000\032\b\022\004\022\0020\0130\001*\0020\f\032\020\020\000\032\b\022\004\022\0020\r0\001*\0020\016\032\020\020\000\032\b\022\004\022\0020\0170\001*\0020\020\032\020\020\000\032\b\022\004\022\0020\0210\001*\0020\022\032\020\020\000\032\b\022\004\022\0020\0230\001*\0020\024\032U\020\025\032\0020\017\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\006\020\026\032\002H\0022\032\020\027\032\026\022\006\b\000\022\002H\0020\030j\n\022\006\b\000\022\002H\002`\0312\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017¢\006\002\020\034\0329\020\025\032\0020\017\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\006\020\026\032\002H\0022\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017¢\006\002\020\035\032&\020\025\032\0020\017*\0020\b2\006\020\026\032\0020\0072\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020\025\032\0020\017*\0020\n2\006\020\026\032\0020\t2\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020\025\032\0020\017*\0020\f2\006\020\026\032\0020\0132\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020\025\032\0020\017*\0020\0162\006\020\026\032\0020\r2\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020\025\032\0020\017*\0020\0202\006\020\026\032\0020\0172\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020\025\032\0020\017*\0020\0222\006\020\026\032\0020\0212\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020\025\032\0020\017*\0020\0242\006\020\026\032\0020\0232\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\0322\020\036\032\0020\005\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\016\020\037\032\n\022\006\b\001\022\002H\0020\003H\f¢\006\004\b \020!\032\"\020\"\032\0020\017\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\003H\b¢\006\004\b#\020$\032\"\020%\032\0020&\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\003H\b¢\006\004\b'\020(\0320\020)\032\0020\005\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\016\020\037\032\n\022\006\b\001\022\002H\0020\003H\f¢\006\002\020!\032\025\020)\032\0020\005*\0020\0062\006\020\037\032\0020\006H\f\032\025\020)\032\0020\005*\0020\b2\006\020\037\032\0020\bH\f\032\025\020)\032\0020\005*\0020\n2\006\020\037\032\0020\nH\f\032\025\020)\032\0020\005*\0020\f2\006\020\037\032\0020\fH\f\032\025\020)\032\0020\005*\0020\0162\006\020\037\032\0020\016H\f\032\025\020)\032\0020\005*\0020\0202\006\020\037\032\0020\020H\f\032\025\020)\032\0020\005*\0020\0222\006\020\037\032\0020\022H\f\032\025\020)\032\0020\005*\0020\0242\006\020\037\032\0020\024H\f\032 \020*\032\0020\017\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\003H\b¢\006\002\020$\032\r\020*\032\0020\017*\0020\006H\b\032\r\020*\032\0020\017*\0020\bH\b\032\r\020*\032\0020\017*\0020\nH\b\032\r\020*\032\0020\017*\0020\fH\b\032\r\020*\032\0020\017*\0020\016H\b\032\r\020*\032\0020\017*\0020\020H\b\032\r\020*\032\0020\017*\0020\022H\b\032\r\020*\032\0020\017*\0020\024H\b\032 \020+\032\0020&\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\003H\b¢\006\002\020(\032\r\020+\032\0020&*\0020\006H\b\032\r\020+\032\0020&*\0020\bH\b\032\r\020+\032\0020&*\0020\nH\b\032\r\020+\032\0020&*\0020\fH\b\032\r\020+\032\0020&*\0020\016H\b\032\r\020+\032\0020&*\0020\020H\b\032\r\020+\032\0020&*\0020\022H\b\032\r\020+\032\0020&*\0020\024H\b\032Q\020,\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\f\020-\032\b\022\004\022\002H\0020\0032\b\b\002\020.\032\0020\0172\b\b\002\020/\032\0020\0172\b\b\002\0200\032\0020\017H\007¢\006\002\0201\0322\020,\032\0020\006*\0020\0062\006\020-\032\0020\0062\b\b\002\020.\032\0020\0172\b\b\002\020/\032\0020\0172\b\b\002\0200\032\0020\017H\007\0322\020,\032\0020\b*\0020\b2\006\020-\032\0020\b2\b\b\002\020.\032\0020\0172\b\b\002\020/\032\0020\0172\b\b\002\0200\032\0020\017H\007\0322\020,\032\0020\n*\0020\n2\006\020-\032\0020\n2\b\b\002\020.\032\0020\0172\b\b\002\020/\032\0020\0172\b\b\002\0200\032\0020\017H\007\0322\020,\032\0020\f*\0020\f2\006\020-\032\0020\f2\b\b\002\020.\032\0020\0172\b\b\002\020/\032\0020\0172\b\b\002\0200\032\0020\017H\007\0322\020,\032\0020\016*\0020\0162\006\020-\032\0020\0162\b\b\002\020.\032\0020\0172\b\b\002\020/\032\0020\0172\b\b\002\0200\032\0020\017H\007\0322\020,\032\0020\020*\0020\0202\006\020-\032\0020\0202\b\b\002\020.\032\0020\0172\b\b\002\020/\032\0020\0172\b\b\002\0200\032\0020\017H\007\0322\020,\032\0020\022*\0020\0222\006\020-\032\0020\0222\b\b\002\020.\032\0020\0172\b\b\002\020/\032\0020\0172\b\b\002\0200\032\0020\017H\007\0322\020,\032\0020\024*\0020\0242\006\020-\032\0020\0242\b\b\002\020.\032\0020\0172\b\b\002\020/\032\0020\0172\b\b\002\0200\032\0020\017H\007\032$\0202\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\003H\b¢\006\002\0203\032.\0202\032\n\022\006\022\004\030\001H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\0204\032\0020\017H\b¢\006\002\0205\032\r\0202\032\0020\006*\0020\006H\b\032\025\0202\032\0020\006*\0020\0062\006\0204\032\0020\017H\b\032\r\0202\032\0020\b*\0020\bH\b\032\025\0202\032\0020\b*\0020\b2\006\0204\032\0020\017H\b\032\r\0202\032\0020\n*\0020\nH\b\032\025\0202\032\0020\n*\0020\n2\006\0204\032\0020\017H\b\032\r\0202\032\0020\f*\0020\fH\b\032\025\0202\032\0020\f*\0020\f2\006\0204\032\0020\017H\b\032\r\0202\032\0020\016*\0020\016H\b\032\025\0202\032\0020\016*\0020\0162\006\0204\032\0020\017H\b\032\r\0202\032\0020\020*\0020\020H\b\032\025\0202\032\0020\020*\0020\0202\006\0204\032\0020\017H\b\032\r\0202\032\0020\022*\0020\022H\b\032\025\0202\032\0020\022*\0020\0222\006\0204\032\0020\017H\b\032\r\0202\032\0020\024*\0020\024H\b\032\025\0202\032\0020\024*\0020\0242\006\0204\032\0020\017H\b\0326\0206\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020\032\032\0020\0172\006\020\033\032\0020\017H\b¢\006\004\b7\0208\032\"\0206\032\0020\006*\0020\0062\006\020\032\032\0020\0172\006\020\033\032\0020\017H\b¢\006\002\b7\032\"\0206\032\0020\b*\0020\b2\006\020\032\032\0020\0172\006\020\033\032\0020\017H\b¢\006\002\b7\032\"\0206\032\0020\n*\0020\n2\006\020\032\032\0020\0172\006\020\033\032\0020\017H\b¢\006\002\b7\032\"\0206\032\0020\f*\0020\f2\006\020\032\032\0020\0172\006\020\033\032\0020\017H\b¢\006\002\b7\032\"\0206\032\0020\016*\0020\0162\006\020\032\032\0020\0172\006\020\033\032\0020\017H\b¢\006\002\b7\032\"\0206\032\0020\020*\0020\0202\006\020\032\032\0020\0172\006\020\033\032\0020\017H\b¢\006\002\b7\032\"\0206\032\0020\022*\0020\0222\006\020\032\032\0020\0172\006\020\033\032\0020\017H\b¢\006\002\b7\032\"\0206\032\0020\024*\0020\0242\006\020\032\032\0020\0172\006\020\033\032\0020\017H\b¢\006\002\b7\0325\0209\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020\032\032\0020\0172\006\020\033\032\0020\017H\001¢\006\004\b6\0208\032!\0209\032\0020\006*\0020\0062\006\020\032\032\0020\0172\006\020\033\032\0020\017H\001¢\006\002\b6\032!\0209\032\0020\b*\0020\b2\006\020\032\032\0020\0172\006\020\033\032\0020\017H\001¢\006\002\b6\032!\0209\032\0020\n*\0020\n2\006\020\032\032\0020\0172\006\020\033\032\0020\017H\001¢\006\002\b6\032!\0209\032\0020\f*\0020\f2\006\020\032\032\0020\0172\006\020\033\032\0020\017H\001¢\006\002\b6\032!\0209\032\0020\016*\0020\0162\006\020\032\032\0020\0172\006\020\033\032\0020\017H\001¢\006\002\b6\032!\0209\032\0020\020*\0020\0202\006\020\032\032\0020\0172\006\020\033\032\0020\017H\001¢\006\002\b6\032!\0209\032\0020\022*\0020\0222\006\020\032\032\0020\0172\006\020\033\032\0020\017H\001¢\006\002\b6\032!\0209\032\0020\024*\0020\0242\006\020\032\032\0020\0172\006\020\033\032\0020\017H\001¢\006\002\b6\032(\020:\032\002H\002\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\006\020;\032\0020\017H\b¢\006\002\020<\032\025\020:\032\0020\005*\0020\0062\006\020;\032\0020\017H\b\032\025\020:\032\0020\007*\0020\b2\006\020;\032\0020\017H\b\032\025\020:\032\0020\t*\0020\n2\006\020;\032\0020\017H\b\032\025\020:\032\0020\013*\0020\f2\006\020;\032\0020\017H\b\032\025\020:\032\0020\r*\0020\0162\006\020;\032\0020\017H\b\032\025\020:\032\0020\017*\0020\0202\006\020;\032\0020\017H\b\032\025\020:\032\0020\021*\0020\0222\006\020;\032\0020\017H\b\032\025\020:\032\0020\023*\0020\0242\006\020;\032\0020\017H\b\0327\020=\032\0020>\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020\026\032\002H\0022\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017¢\006\002\020?\032&\020=\032\0020>*\0020\0062\006\020\026\032\0020\0052\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020=\032\0020>*\0020\b2\006\020\026\032\0020\0072\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020=\032\0020>*\0020\n2\006\020\026\032\0020\t2\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020=\032\0020>*\0020\f2\006\020\026\032\0020\0132\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020=\032\0020>*\0020\0162\006\020\026\032\0020\r2\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020=\032\0020>*\0020\0202\006\020\026\032\0020\0172\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020=\032\0020>*\0020\0222\006\020\026\032\0020\0212\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032&\020=\032\0020>*\0020\0242\006\020\026\032\0020\0232\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032-\020@\032\b\022\004\022\002HA0\001\"\004\b\000\020A*\006\022\002\b\0030\0032\f\020B\032\b\022\004\022\002HA0C¢\006\002\020D\032A\020E\032\002HF\"\020\b\000\020F*\n\022\006\b\000\022\002HA0G\"\004\b\001\020A*\006\022\002\b\0030\0032\006\020-\032\002HF2\f\020B\032\b\022\004\022\002HA0C¢\006\002\020H\032,\020I\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020\026\032\002H\002H\002¢\006\002\020J\0324\020I\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\016\020K\032\n\022\006\b\001\022\002H\0020\003H\002¢\006\002\020L\0322\020I\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\f\020K\032\b\022\004\022\002H\0020MH\002¢\006\002\020N\032\025\020I\032\0020\006*\0020\0062\006\020\026\032\0020\005H\002\032\025\020I\032\0020\006*\0020\0062\006\020K\032\0020\006H\002\032\033\020I\032\0020\006*\0020\0062\f\020K\032\b\022\004\022\0020\0050MH\002\032\025\020I\032\0020\b*\0020\b2\006\020\026\032\0020\007H\002\032\025\020I\032\0020\b*\0020\b2\006\020K\032\0020\bH\002\032\033\020I\032\0020\b*\0020\b2\f\020K\032\b\022\004\022\0020\0070MH\002\032\025\020I\032\0020\n*\0020\n2\006\020\026\032\0020\tH\002\032\025\020I\032\0020\n*\0020\n2\006\020K\032\0020\nH\002\032\033\020I\032\0020\n*\0020\n2\f\020K\032\b\022\004\022\0020\t0MH\002\032\025\020I\032\0020\f*\0020\f2\006\020\026\032\0020\013H\002\032\025\020I\032\0020\f*\0020\f2\006\020K\032\0020\fH\002\032\033\020I\032\0020\f*\0020\f2\f\020K\032\b\022\004\022\0020\0130MH\002\032\025\020I\032\0020\016*\0020\0162\006\020\026\032\0020\rH\002\032\025\020I\032\0020\016*\0020\0162\006\020K\032\0020\016H\002\032\033\020I\032\0020\016*\0020\0162\f\020K\032\b\022\004\022\0020\r0MH\002\032\025\020I\032\0020\020*\0020\0202\006\020\026\032\0020\017H\002\032\025\020I\032\0020\020*\0020\0202\006\020K\032\0020\020H\002\032\033\020I\032\0020\020*\0020\0202\f\020K\032\b\022\004\022\0020\0170MH\002\032\025\020I\032\0020\022*\0020\0222\006\020\026\032\0020\021H\002\032\025\020I\032\0020\022*\0020\0222\006\020K\032\0020\022H\002\032\033\020I\032\0020\022*\0020\0222\f\020K\032\b\022\004\022\0020\0210MH\002\032\025\020I\032\0020\024*\0020\0242\006\020\026\032\0020\023H\002\032\025\020I\032\0020\024*\0020\0242\006\020K\032\0020\024H\002\032\033\020I\032\0020\024*\0020\0242\f\020K\032\b\022\004\022\0020\0230MH\002\032,\020O\032\b\022\004\022\002H\0020\003\"\004\b\000\020\002*\b\022\004\022\002H\0020\0032\006\020\026\032\002H\002H\b¢\006\002\020J\032\035\020P\032\0020>\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\003¢\006\002\020Q\032*\020P\032\0020>\"\016\b\000\020\002*\b\022\004\022\002H\0020R*\n\022\006\b\001\022\002H\0020\003H\b¢\006\002\020S\0321\020P\032\0020>\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017¢\006\002\020T\032\n\020P\032\0020>*\0020\b\032\036\020P\032\0020>*\0020\b2\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032\n\020P\032\0020>*\0020\n\032\036\020P\032\0020>*\0020\n2\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032\n\020P\032\0020>*\0020\f\032\036\020P\032\0020>*\0020\f2\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032\n\020P\032\0020>*\0020\016\032\036\020P\032\0020>*\0020\0162\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032\n\020P\032\0020>*\0020\020\032\036\020P\032\0020>*\0020\0202\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032\n\020P\032\0020>*\0020\022\032\036\020P\032\0020>*\0020\0222\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\032\n\020P\032\0020>*\0020\024\032\036\020P\032\0020>*\0020\0242\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017\0329\020U\032\0020>\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\032\020\027\032\026\022\006\b\000\022\002H\0020\030j\n\022\006\b\000\022\002H\002`\031¢\006\002\020V\032M\020U\032\0020>\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\032\020\027\032\026\022\006\b\000\022\002H\0020\030j\n\022\006\b\000\022\002H\002`\0312\b\b\002\020\032\032\0020\0172\b\b\002\020\033\032\0020\017¢\006\002\020W\032-\020X\032\b\022\004\022\002H\0020Y\"\016\b\000\020\002*\b\022\004\022\002H\0020R*\n\022\006\b\001\022\002H\0020\003¢\006\002\020Z\032?\020X\032\b\022\004\022\002H\0020Y\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\032\020\027\032\026\022\006\b\000\022\002H\0020\030j\n\022\006\b\000\022\002H\002`\031¢\006\002\020[\032\020\020X\032\b\022\004\022\0020\0050Y*\0020\006\032\020\020X\032\b\022\004\022\0020\0070Y*\0020\b\032\020\020X\032\b\022\004\022\0020\t0Y*\0020\n\032\020\020X\032\b\022\004\022\0020\0130Y*\0020\f\032\020\020X\032\b\022\004\022\0020\r0Y*\0020\016\032\020\020X\032\b\022\004\022\0020\0170Y*\0020\020\032\020\020X\032\b\022\004\022\0020\0210Y*\0020\022\032\020\020X\032\b\022\004\022\0020\0230Y*\0020\024\032\025\020\\\032\b\022\004\022\0020\0050\003*\0020\006¢\006\002\020]\032\025\020\\\032\b\022\004\022\0020\0070\003*\0020\b¢\006\002\020^\032\025\020\\\032\b\022\004\022\0020\t0\003*\0020\n¢\006\002\020_\032\025\020\\\032\b\022\004\022\0020\0130\003*\0020\f¢\006\002\020`\032\025\020\\\032\b\022\004\022\0020\r0\003*\0020\016¢\006\002\020a\032\025\020\\\032\b\022\004\022\0020\0170\003*\0020\020¢\006\002\020b\032\025\020\\\032\b\022\004\022\0020\0210\003*\0020\022¢\006\002\020c\032\025\020\\\032\b\022\004\022\0020\0230\003*\0020\024¢\006\002\020d¨\006e"}, d2={"asList", "", "T", "", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "binarySearch", "element", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "fromIndex", "toIndex", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "contentDeepEquals", "other", "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepHashCode", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepToString", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentEquals", "contentHashCode", "contentToString", "copyInto", "destination", "destinationOffset", "startIndex", "endIndex", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRange", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "elementAt", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", "fill", "", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "filterIsInstance", "R", "klass", "Ljava/lang/Class;", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "filterIsInstanceTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "plusElement", "sort", "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;II)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toSortedSet", "Ljava/util/SortedSet;", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "toTypedArray", "([Z)[Ljava/lang/Boolean;", "([B)[Ljava/lang/Byte;", "([C)[Ljava/lang/Character;", "([D)[Ljava/lang/Double;", "([F)[Ljava/lang/Float;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([S)[Ljava/lang/Short;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/ArraysKt")
class ArraysKt___ArraysJvmKt
  extends ArraysKt__ArraysKt
{
  public static final List<Byte> asList(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains(byte paramAnonymousByte)
      {
        return ArraysKt.contains(this.$this_asList, paramAnonymousByte);
      }
      
      public Byte get(int paramAnonymousInt)
      {
        return Byte.valueOf(this.$this_asList[paramAnonymousInt]);
      }
      
      public int getSize()
      {
        return this.$this_asList.length;
      }
      
      public int indexOf(byte paramAnonymousByte)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousByte);
      }
      
      public boolean isEmpty()
      {
        return this.$this_asList.length == 0;
      }
      
      public int lastIndexOf(byte paramAnonymousByte)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousByte);
      }
    };
  }
  
  public static final List<Character> asList(char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains(char paramAnonymousChar)
      {
        return ArraysKt.contains(this.$this_asList, paramAnonymousChar);
      }
      
      public Character get(int paramAnonymousInt)
      {
        return Character.valueOf(this.$this_asList[paramAnonymousInt]);
      }
      
      public int getSize()
      {
        return this.$this_asList.length;
      }
      
      public int indexOf(char paramAnonymousChar)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousChar);
      }
      
      public boolean isEmpty()
      {
        return this.$this_asList.length == 0;
      }
      
      public int lastIndexOf(char paramAnonymousChar)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousChar);
      }
    };
  }
  
  public static final List<Double> asList(double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains(double paramAnonymousDouble)
      {
        return ArraysKt.contains(this.$this_asList, paramAnonymousDouble);
      }
      
      public Double get(int paramAnonymousInt)
      {
        return Double.valueOf(this.$this_asList[paramAnonymousInt]);
      }
      
      public int getSize()
      {
        return this.$this_asList.length;
      }
      
      public int indexOf(double paramAnonymousDouble)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousDouble);
      }
      
      public boolean isEmpty()
      {
        return this.$this_asList.length == 0;
      }
      
      public int lastIndexOf(double paramAnonymousDouble)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousDouble);
      }
    };
  }
  
  public static final List<Float> asList(float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains(float paramAnonymousFloat)
      {
        return ArraysKt.contains(this.$this_asList, paramAnonymousFloat);
      }
      
      public Float get(int paramAnonymousInt)
      {
        return Float.valueOf(this.$this_asList[paramAnonymousInt]);
      }
      
      public int getSize()
      {
        return this.$this_asList.length;
      }
      
      public int indexOf(float paramAnonymousFloat)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousFloat);
      }
      
      public boolean isEmpty()
      {
        return this.$this_asList.length == 0;
      }
      
      public int lastIndexOf(float paramAnonymousFloat)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousFloat);
      }
    };
  }
  
  public static final List<Integer> asList(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains(int paramAnonymousInt)
      {
        return ArraysKt.contains(this.$this_asList, paramAnonymousInt);
      }
      
      public Integer get(int paramAnonymousInt)
      {
        return Integer.valueOf(this.$this_asList[paramAnonymousInt]);
      }
      
      public int getSize()
      {
        return this.$this_asList.length;
      }
      
      public int indexOf(int paramAnonymousInt)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousInt);
      }
      
      public boolean isEmpty()
      {
        return this.$this_asList.length == 0;
      }
      
      public int lastIndexOf(int paramAnonymousInt)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousInt);
      }
    };
  }
  
  public static final List<Long> asList(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains(long paramAnonymousLong)
      {
        return ArraysKt.contains(this.$this_asList, paramAnonymousLong);
      }
      
      public Long get(int paramAnonymousInt)
      {
        return Long.valueOf(this.$this_asList[paramAnonymousInt]);
      }
      
      public int getSize()
      {
        return this.$this_asList.length;
      }
      
      public int indexOf(long paramAnonymousLong)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousLong);
      }
      
      public boolean isEmpty()
      {
        return this.$this_asList.length == 0;
      }
      
      public int lastIndexOf(long paramAnonymousLong)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousLong);
      }
    };
  }
  
  public static final <T> List<T> asList(T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$asList");
    paramArrayOfT = ArraysUtilJVM.asList(paramArrayOfT);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "ArraysUtilJVM.asList(this)");
    return paramArrayOfT;
  }
  
  public static final List<Short> asList(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains(short paramAnonymousShort)
      {
        return ArraysKt.contains(this.$this_asList, paramAnonymousShort);
      }
      
      public Short get(int paramAnonymousInt)
      {
        return Short.valueOf(this.$this_asList[paramAnonymousInt]);
      }
      
      public int getSize()
      {
        return this.$this_asList.length;
      }
      
      public int indexOf(short paramAnonymousShort)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousShort);
      }
      
      public boolean isEmpty()
      {
        return this.$this_asList.length == 0;
      }
      
      public int lastIndexOf(short paramAnonymousShort)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousShort);
      }
    };
  }
  
  public static final List<Boolean> asList(boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$asList");
    (List)new AbstractList()
    {
      public boolean contains(boolean paramAnonymousBoolean)
      {
        return ArraysKt.contains(this.$this_asList, paramAnonymousBoolean);
      }
      
      public Boolean get(int paramAnonymousInt)
      {
        return Boolean.valueOf(this.$this_asList[paramAnonymousInt]);
      }
      
      public int getSize()
      {
        return this.$this_asList.length;
      }
      
      public int indexOf(boolean paramAnonymousBoolean)
      {
        return ArraysKt.indexOf(this.$this_asList, paramAnonymousBoolean);
      }
      
      public boolean isEmpty()
      {
        return this.$this_asList.length == 0;
      }
      
      public int lastIndexOf(boolean paramAnonymousBoolean)
      {
        return ArraysKt.lastIndexOf(this.$this_asList, paramAnonymousBoolean);
      }
    };
  }
  
  public static final int binarySearch(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfByte, paramInt1, paramInt2, paramByte);
  }
  
  public static final int binarySearch(char[] paramArrayOfChar, char paramChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfChar, paramInt1, paramInt2, paramChar);
  }
  
  public static final int binarySearch(double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfDouble, paramInt1, paramInt2, paramDouble);
  }
  
  public static final int binarySearch(float[] paramArrayOfFloat, float paramFloat, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfFloat, paramInt1, paramInt2, paramFloat);
  }
  
  public static final int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfInt, paramInt2, paramInt3, paramInt1);
  }
  
  public static final int binarySearch(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfLong, paramInt1, paramInt2, paramLong);
  }
  
  public static final <T> int binarySearch(T[] paramArrayOfT, T paramT, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfT, paramInt1, paramInt2, paramT);
  }
  
  public static final <T> int binarySearch(T[] paramArrayOfT, T paramT, Comparator<? super T> paramComparator, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$binarySearch");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return Arrays.binarySearch(paramArrayOfT, paramInt1, paramInt2, paramT, paramComparator);
  }
  
  public static final int binarySearch(short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfShort, paramInt1, paramInt2, paramShort);
  }
  
  private static final <T> boolean contentDeepEqualsInline(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.contentDeepEquals(paramArrayOfT1, paramArrayOfT2);
    }
    return Arrays.deepEquals(paramArrayOfT1, paramArrayOfT2);
  }
  
  private static final <T> int contentDeepHashCodeInline(T[] paramArrayOfT)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.contentDeepHashCode(paramArrayOfT);
    }
    return Arrays.deepHashCode(paramArrayOfT);
  }
  
  private static final <T> String contentDeepToStringInline(T[] paramArrayOfT)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.contentDeepToString(paramArrayOfT);
    }
    paramArrayOfT = Arrays.deepToString(paramArrayOfT);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.deepToString(this)");
    return paramArrayOfT;
  }
  
  private static final boolean contentEquals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private static final boolean contentEquals(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    return Arrays.equals(paramArrayOfChar1, paramArrayOfChar2);
  }
  
  private static final boolean contentEquals(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    return Arrays.equals(paramArrayOfDouble1, paramArrayOfDouble2);
  }
  
  private static final boolean contentEquals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  private static final boolean contentEquals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
  }
  
  private static final boolean contentEquals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
  }
  
  private static final <T> boolean contentEquals(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    return Arrays.equals(paramArrayOfT1, paramArrayOfT2);
  }
  
  private static final boolean contentEquals(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    return Arrays.equals(paramArrayOfShort1, paramArrayOfShort2);
  }
  
  private static final boolean contentEquals(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    return Arrays.equals(paramArrayOfBoolean1, paramArrayOfBoolean2);
  }
  
  private static final int contentHashCode(byte[] paramArrayOfByte)
  {
    return Arrays.hashCode(paramArrayOfByte);
  }
  
  private static final int contentHashCode(char[] paramArrayOfChar)
  {
    return Arrays.hashCode(paramArrayOfChar);
  }
  
  private static final int contentHashCode(double[] paramArrayOfDouble)
  {
    return Arrays.hashCode(paramArrayOfDouble);
  }
  
  private static final int contentHashCode(float[] paramArrayOfFloat)
  {
    return Arrays.hashCode(paramArrayOfFloat);
  }
  
  private static final int contentHashCode(int[] paramArrayOfInt)
  {
    return Arrays.hashCode(paramArrayOfInt);
  }
  
  private static final int contentHashCode(long[] paramArrayOfLong)
  {
    return Arrays.hashCode(paramArrayOfLong);
  }
  
  private static final <T> int contentHashCode(T[] paramArrayOfT)
  {
    return Arrays.hashCode(paramArrayOfT);
  }
  
  private static final int contentHashCode(short[] paramArrayOfShort)
  {
    return Arrays.hashCode(paramArrayOfShort);
  }
  
  private static final int contentHashCode(boolean[] paramArrayOfBoolean)
  {
    return Arrays.hashCode(paramArrayOfBoolean);
  }
  
  private static final String contentToString(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = Arrays.toString(paramArrayOfByte);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.toString(this)");
    return paramArrayOfByte;
  }
  
  private static final String contentToString(char[] paramArrayOfChar)
  {
    paramArrayOfChar = Arrays.toString(paramArrayOfChar);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.toString(this)");
    return paramArrayOfChar;
  }
  
  private static final String contentToString(double[] paramArrayOfDouble)
  {
    paramArrayOfDouble = Arrays.toString(paramArrayOfDouble);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.toString(this)");
    return paramArrayOfDouble;
  }
  
  private static final String contentToString(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Arrays.toString(paramArrayOfFloat);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.toString(this)");
    return paramArrayOfFloat;
  }
  
  private static final String contentToString(int[] paramArrayOfInt)
  {
    paramArrayOfInt = Arrays.toString(paramArrayOfInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.toString(this)");
    return paramArrayOfInt;
  }
  
  private static final String contentToString(long[] paramArrayOfLong)
  {
    paramArrayOfLong = Arrays.toString(paramArrayOfLong);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.toString(this)");
    return paramArrayOfLong;
  }
  
  private static final <T> String contentToString(T[] paramArrayOfT)
  {
    paramArrayOfT = Arrays.toString(paramArrayOfT);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.toString(this)");
    return paramArrayOfT;
  }
  
  private static final String contentToString(short[] paramArrayOfShort)
  {
    paramArrayOfShort = Arrays.toString(paramArrayOfShort);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.toString(this)");
    return paramArrayOfShort;
  }
  
  private static final String contentToString(boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean = Arrays.toString(paramArrayOfBoolean);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.toString(this)");
    return paramArrayOfBoolean;
  }
  
  public static final byte[] copyInto(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "destination");
    System.arraycopy(paramArrayOfByte1, paramInt2, paramArrayOfByte2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfByte2;
  }
  
  public static final char[] copyInto(char[] paramArrayOfChar1, char[] paramArrayOfChar2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar2, "destination");
    System.arraycopy(paramArrayOfChar1, paramInt2, paramArrayOfChar2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfChar2;
  }
  
  public static final double[] copyInto(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble2, "destination");
    System.arraycopy(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfDouble2;
  }
  
  public static final float[] copyInto(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat2, "destination");
    System.arraycopy(paramArrayOfFloat1, paramInt2, paramArrayOfFloat2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfFloat2;
  }
  
  public static final int[] copyInto(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "destination");
    System.arraycopy(paramArrayOfInt1, paramInt2, paramArrayOfInt2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfInt2;
  }
  
  public static final long[] copyInto(long[] paramArrayOfLong1, long[] paramArrayOfLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "destination");
    System.arraycopy(paramArrayOfLong1, paramInt2, paramArrayOfLong2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfLong2;
  }
  
  public static final <T> T[] copyInto(T[] paramArrayOfT1, T[] paramArrayOfT2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT2, "destination");
    System.arraycopy(paramArrayOfT1, paramInt2, paramArrayOfT2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfT2;
  }
  
  public static final short[] copyInto(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "destination");
    System.arraycopy(paramArrayOfShort1, paramInt2, paramArrayOfShort2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfShort2;
  }
  
  public static final boolean[] copyInto(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean2, "destination");
    System.arraycopy(paramArrayOfBoolean1, paramInt2, paramArrayOfBoolean2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfBoolean2;
  }
  
  private static final byte[] copyOf(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfByte;
  }
  
  private static final byte[] copyOf(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfByte;
  }
  
  private static final char[] copyOf(char[] paramArrayOfChar)
  {
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, paramArrayOfChar.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfChar;
  }
  
  private static final char[] copyOf(char[] paramArrayOfChar, int paramInt)
  {
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfChar;
  }
  
  private static final double[] copyOf(double[] paramArrayOfDouble)
  {
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramArrayOfDouble.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfDouble;
  }
  
  private static final double[] copyOf(double[] paramArrayOfDouble, int paramInt)
  {
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfDouble;
  }
  
  private static final float[] copyOf(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfFloat;
  }
  
  private static final float[] copyOf(float[] paramArrayOfFloat, int paramInt)
  {
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfFloat;
  }
  
  private static final int[] copyOf(int[] paramArrayOfInt)
  {
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfInt;
  }
  
  private static final int[] copyOf(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfInt;
  }
  
  private static final long[] copyOf(long[] paramArrayOfLong)
  {
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfLong;
  }
  
  private static final long[] copyOf(long[] paramArrayOfLong, int paramInt)
  {
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfLong;
  }
  
  private static final <T> T[] copyOf(T[] paramArrayOfT)
  {
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfT;
  }
  
  private static final <T> T[] copyOf(T[] paramArrayOfT, int paramInt)
  {
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfT;
  }
  
  private static final short[] copyOf(short[] paramArrayOfShort)
  {
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfShort;
  }
  
  private static final short[] copyOf(short[] paramArrayOfShort, int paramInt)
  {
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfShort;
  }
  
  private static final boolean[] copyOf(boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean = Arrays.copyOf(paramArrayOfBoolean, paramArrayOfBoolean.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfBoolean;
  }
  
  private static final boolean[] copyOf(boolean[] paramArrayOfBoolean, int paramInt)
  {
    paramArrayOfBoolean = Arrays.copyOf(paramArrayOfBoolean, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfBoolean;
  }
  
  public static final byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfByte.length);
    paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfByte;
  }
  
  public static final char[] copyOfRange(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfChar.length);
    paramArrayOfChar = Arrays.copyOfRange(paramArrayOfChar, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfChar;
  }
  
  public static final double[] copyOfRange(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfDouble.length);
    paramArrayOfDouble = Arrays.copyOfRange(paramArrayOfDouble, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfDouble;
  }
  
  public static final float[] copyOfRange(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfFloat.length);
    paramArrayOfFloat = Arrays.copyOfRange(paramArrayOfFloat, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfFloat;
  }
  
  public static final int[] copyOfRange(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfInt.length);
    paramArrayOfInt = Arrays.copyOfRange(paramArrayOfInt, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfInt;
  }
  
  public static final long[] copyOfRange(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfLong.length);
    paramArrayOfLong = Arrays.copyOfRange(paramArrayOfLong, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfLong;
  }
  
  public static final <T> T[] copyOfRange(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfT.length);
    paramArrayOfT = Arrays.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfT;
  }
  
  public static final short[] copyOfRange(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfShort.length);
    paramArrayOfShort = Arrays.copyOfRange(paramArrayOfShort, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfShort;
  }
  
  public static final boolean[] copyOfRange(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfBoolean.length);
    paramArrayOfBoolean = Arrays.copyOfRange(paramArrayOfBoolean, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfBoolean;
  }
  
  private static final byte[] copyOfRangeInline(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    }
    if (paramInt2 <= paramArrayOfByte.length)
    {
      paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      return paramArrayOfByte;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramArrayOfByte.length);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final char[] copyOfRangeInline(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfChar, paramInt1, paramInt2);
    }
    if (paramInt2 <= paramArrayOfChar.length)
    {
      paramArrayOfChar = Arrays.copyOfRange(paramArrayOfChar, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      return paramArrayOfChar;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramArrayOfChar.length);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final double[] copyOfRangeInline(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfDouble, paramInt1, paramInt2);
    }
    if (paramInt2 <= paramArrayOfDouble.length)
    {
      paramArrayOfDouble = Arrays.copyOfRange(paramArrayOfDouble, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      return paramArrayOfDouble;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramArrayOfDouble.length);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final float[] copyOfRangeInline(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfFloat, paramInt1, paramInt2);
    }
    if (paramInt2 <= paramArrayOfFloat.length)
    {
      paramArrayOfFloat = Arrays.copyOfRange(paramArrayOfFloat, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      return paramArrayOfFloat;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramArrayOfFloat.length);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final int[] copyOfRangeInline(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfInt, paramInt1, paramInt2);
    }
    if (paramInt2 <= paramArrayOfInt.length)
    {
      paramArrayOfInt = Arrays.copyOfRange(paramArrayOfInt, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      return paramArrayOfInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramArrayOfInt.length);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final long[] copyOfRangeInline(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfLong, paramInt1, paramInt2);
    }
    if (paramInt2 <= paramArrayOfLong.length)
    {
      paramArrayOfLong = Arrays.copyOfRange(paramArrayOfLong, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      return paramArrayOfLong;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramArrayOfLong.length);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final <T> T[] copyOfRangeInline(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
    }
    if (paramInt2 <= paramArrayOfT.length)
    {
      paramArrayOfT = Arrays.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      return paramArrayOfT;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramArrayOfT.length);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final short[] copyOfRangeInline(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfShort, paramInt1, paramInt2);
    }
    if (paramInt2 <= paramArrayOfShort.length)
    {
      paramArrayOfShort = Arrays.copyOfRange(paramArrayOfShort, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      return paramArrayOfShort;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramArrayOfShort.length);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final boolean[] copyOfRangeInline(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfBoolean, paramInt1, paramInt2);
    }
    if (paramInt2 <= paramArrayOfBoolean.length)
    {
      paramArrayOfBoolean = Arrays.copyOfRange(paramArrayOfBoolean, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      return paramArrayOfBoolean;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramArrayOfBoolean.length);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  private static final byte elementAt(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt];
  }
  
  private static final char elementAt(char[] paramArrayOfChar, int paramInt)
  {
    return paramArrayOfChar[paramInt];
  }
  
  private static final double elementAt(double[] paramArrayOfDouble, int paramInt)
  {
    return paramArrayOfDouble[paramInt];
  }
  
  private static final float elementAt(float[] paramArrayOfFloat, int paramInt)
  {
    return paramArrayOfFloat[paramInt];
  }
  
  private static final int elementAt(int[] paramArrayOfInt, int paramInt)
  {
    return paramArrayOfInt[paramInt];
  }
  
  private static final long elementAt(long[] paramArrayOfLong, int paramInt)
  {
    return paramArrayOfLong[paramInt];
  }
  
  private static final <T> T elementAt(T[] paramArrayOfT, int paramInt)
  {
    return paramArrayOfT[paramInt];
  }
  
  private static final short elementAt(short[] paramArrayOfShort, int paramInt)
  {
    return paramArrayOfShort[paramInt];
  }
  
  private static final boolean elementAt(boolean[] paramArrayOfBoolean, int paramInt)
  {
    return paramArrayOfBoolean[paramInt];
  }
  
  public static final void fill(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$fill");
    Arrays.fill(paramArrayOfByte, paramInt1, paramInt2, paramByte);
  }
  
  public static final void fill(char[] paramArrayOfChar, char paramChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$fill");
    Arrays.fill(paramArrayOfChar, paramInt1, paramInt2, paramChar);
  }
  
  public static final void fill(double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$fill");
    Arrays.fill(paramArrayOfDouble, paramInt1, paramInt2, paramDouble);
  }
  
  public static final void fill(float[] paramArrayOfFloat, float paramFloat, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$fill");
    Arrays.fill(paramArrayOfFloat, paramInt1, paramInt2, paramFloat);
  }
  
  public static final void fill(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$fill");
    Arrays.fill(paramArrayOfInt, paramInt2, paramInt3, paramInt1);
  }
  
  public static final void fill(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$fill");
    Arrays.fill(paramArrayOfLong, paramInt1, paramInt2, paramLong);
  }
  
  public static final <T> void fill(T[] paramArrayOfT, T paramT, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$fill");
    Arrays.fill(paramArrayOfT, paramInt1, paramInt2, paramT);
  }
  
  public static final void fill(short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$fill");
    Arrays.fill(paramArrayOfShort, paramInt1, paramInt2, paramShort);
  }
  
  public static final void fill(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$fill");
    Arrays.fill(paramArrayOfBoolean, paramInt1, paramInt2, paramBoolean);
  }
  
  public static final <R> List<R> filterIsInstance(Object[] paramArrayOfObject, Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "$this$filterIsInstance");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    return (List)ArraysKt.filterIsInstanceTo(paramArrayOfObject, (Collection)new ArrayList(), paramClass);
  }
  
  public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Object[] paramArrayOfObject, C paramC, Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "$this$filterIsInstanceTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if (paramClass.isInstance(localObject)) {
        paramC.add(localObject);
      }
      i += 1;
    }
    return paramC;
  }
  
  public static final byte[] plus(byte[] paramArrayOfByte, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$plus");
    int i = paramArrayOfByte.length;
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, i + 1);
    paramArrayOfByte[i] = paramByte;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "result");
    return paramArrayOfByte;
  }
  
  public static final byte[] plus(byte[] paramArrayOfByte, Collection<Byte> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfByte.length;
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfByte[i] = ((Number)paramCollection.next()).byteValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "result");
    return paramArrayOfByte;
  }
  
  public static final byte[] plus(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "elements");
    int i = paramArrayOfByte1.length;
    int j = paramArrayOfByte2.length;
    paramArrayOfByte1 = Arrays.copyOf(paramArrayOfByte1, i + j);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte1, "result");
    return paramArrayOfByte1;
  }
  
  public static final char[] plus(char[] paramArrayOfChar, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$plus");
    int i = paramArrayOfChar.length;
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, i + 1);
    paramArrayOfChar[i] = paramChar;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "result");
    return paramArrayOfChar;
  }
  
  public static final char[] plus(char[] paramArrayOfChar, Collection<Character> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfChar.length;
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfChar[i] = ((Character)paramCollection.next()).charValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "result");
    return paramArrayOfChar;
  }
  
  public static final char[] plus(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar2, "elements");
    int i = paramArrayOfChar1.length;
    int j = paramArrayOfChar2.length;
    paramArrayOfChar1 = Arrays.copyOf(paramArrayOfChar1, i + j);
    System.arraycopy(paramArrayOfChar2, 0, paramArrayOfChar1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar1, "result");
    return paramArrayOfChar1;
  }
  
  public static final double[] plus(double[] paramArrayOfDouble, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$plus");
    int i = paramArrayOfDouble.length;
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, i + 1);
    paramArrayOfDouble[i] = paramDouble;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "result");
    return paramArrayOfDouble;
  }
  
  public static final double[] plus(double[] paramArrayOfDouble, Collection<Double> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfDouble.length;
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfDouble[i] = ((Number)paramCollection.next()).doubleValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "result");
    return paramArrayOfDouble;
  }
  
  public static final double[] plus(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble2, "elements");
    int i = paramArrayOfDouble1.length;
    int j = paramArrayOfDouble2.length;
    paramArrayOfDouble1 = Arrays.copyOf(paramArrayOfDouble1, i + j);
    System.arraycopy(paramArrayOfDouble2, 0, paramArrayOfDouble1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble1, "result");
    return paramArrayOfDouble1;
  }
  
  public static final float[] plus(float[] paramArrayOfFloat, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$plus");
    int i = paramArrayOfFloat.length;
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, i + 1);
    paramArrayOfFloat[i] = paramFloat;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "result");
    return paramArrayOfFloat;
  }
  
  public static final float[] plus(float[] paramArrayOfFloat, Collection<Float> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfFloat.length;
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfFloat[i] = ((Number)paramCollection.next()).floatValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "result");
    return paramArrayOfFloat;
  }
  
  public static final float[] plus(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat2, "elements");
    int i = paramArrayOfFloat1.length;
    int j = paramArrayOfFloat2.length;
    paramArrayOfFloat1 = Arrays.copyOf(paramArrayOfFloat1, i + j);
    System.arraycopy(paramArrayOfFloat2, 0, paramArrayOfFloat1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat1, "result");
    return paramArrayOfFloat1;
  }
  
  public static final int[] plus(int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$plus");
    int i = paramArrayOfInt.length;
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, i + 1);
    paramArrayOfInt[i] = paramInt;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "result");
    return paramArrayOfInt;
  }
  
  public static final int[] plus(int[] paramArrayOfInt, Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfInt.length;
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfInt[i] = ((Number)paramCollection.next()).intValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "result");
    return paramArrayOfInt;
  }
  
  public static final int[] plus(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "elements");
    int i = paramArrayOfInt1.length;
    int j = paramArrayOfInt2.length;
    paramArrayOfInt1 = Arrays.copyOf(paramArrayOfInt1, i + j);
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt1, "result");
    return paramArrayOfInt1;
  }
  
  public static final long[] plus(long[] paramArrayOfLong, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$plus");
    int i = paramArrayOfLong.length;
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, i + 1);
    paramArrayOfLong[i] = paramLong;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "result");
    return paramArrayOfLong;
  }
  
  public static final long[] plus(long[] paramArrayOfLong, Collection<Long> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfLong.length;
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfLong[i] = ((Number)paramCollection.next()).longValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "result");
    return paramArrayOfLong;
  }
  
  public static final long[] plus(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "elements");
    int i = paramArrayOfLong1.length;
    int j = paramArrayOfLong2.length;
    paramArrayOfLong1 = Arrays.copyOf(paramArrayOfLong1, i + j);
    System.arraycopy(paramArrayOfLong2, 0, paramArrayOfLong1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong1, "result");
    return paramArrayOfLong1;
  }
  
  public static final <T> T[] plus(T[] paramArrayOfT, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$plus");
    int i = paramArrayOfT.length;
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, i + 1);
    paramArrayOfT[i] = paramT;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "result");
    return paramArrayOfT;
  }
  
  public static final <T> T[] plus(T[] paramArrayOfT, Collection<? extends T> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfT.length;
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfT[i] = paramCollection.next();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "result");
    return paramArrayOfT;
  }
  
  public static final <T> T[] plus(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT2, "elements");
    int i = paramArrayOfT1.length;
    int j = paramArrayOfT2.length;
    paramArrayOfT1 = Arrays.copyOf(paramArrayOfT1, i + j);
    System.arraycopy(paramArrayOfT2, 0, paramArrayOfT1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT1, "result");
    return paramArrayOfT1;
  }
  
  public static final short[] plus(short[] paramArrayOfShort, Collection<Short> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfShort.length;
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfShort[i] = ((Number)paramCollection.next()).shortValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "result");
    return paramArrayOfShort;
  }
  
  public static final short[] plus(short[] paramArrayOfShort, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$plus");
    int i = paramArrayOfShort.length;
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, i + 1);
    paramArrayOfShort[i] = paramShort;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "result");
    return paramArrayOfShort;
  }
  
  public static final short[] plus(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "elements");
    int i = paramArrayOfShort1.length;
    int j = paramArrayOfShort2.length;
    paramArrayOfShort1 = Arrays.copyOf(paramArrayOfShort1, i + j);
    System.arraycopy(paramArrayOfShort2, 0, paramArrayOfShort1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort1, "result");
    return paramArrayOfShort1;
  }
  
  public static final boolean[] plus(boolean[] paramArrayOfBoolean, Collection<Boolean> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfBoolean.length;
    paramArrayOfBoolean = Arrays.copyOf(paramArrayOfBoolean, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfBoolean[i] = ((Boolean)paramCollection.next()).booleanValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "result");
    return paramArrayOfBoolean;
  }
  
  public static final boolean[] plus(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$plus");
    int i = paramArrayOfBoolean.length;
    paramArrayOfBoolean = Arrays.copyOf(paramArrayOfBoolean, i + 1);
    paramArrayOfBoolean[i] = paramBoolean;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "result");
    return paramArrayOfBoolean;
  }
  
  public static final boolean[] plus(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean2, "elements");
    int i = paramArrayOfBoolean1.length;
    int j = paramArrayOfBoolean2.length;
    paramArrayOfBoolean1 = Arrays.copyOf(paramArrayOfBoolean1, i + j);
    System.arraycopy(paramArrayOfBoolean2, 0, paramArrayOfBoolean1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean1, "result");
    return paramArrayOfBoolean1;
  }
  
  private static final <T> T[] plusElement(T[] paramArrayOfT, T paramT)
  {
    return ArraysKt.plus(paramArrayOfT, paramT);
  }
  
  public static final void sort(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sort");
    if (paramArrayOfByte.length > 1) {
      Arrays.sort(paramArrayOfByte);
    }
  }
  
  public static final void sort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sort");
    Arrays.sort(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static final void sort(char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sort");
    if (paramArrayOfChar.length > 1) {
      Arrays.sort(paramArrayOfChar);
    }
  }
  
  public static final void sort(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sort");
    Arrays.sort(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public static final void sort(double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sort");
    if (paramArrayOfDouble.length > 1) {
      Arrays.sort(paramArrayOfDouble);
    }
  }
  
  public static final void sort(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sort");
    Arrays.sort(paramArrayOfDouble, paramInt1, paramInt2);
  }
  
  public static final void sort(float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sort");
    if (paramArrayOfFloat.length > 1) {
      Arrays.sort(paramArrayOfFloat);
    }
  }
  
  public static final void sort(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sort");
    Arrays.sort(paramArrayOfFloat, paramInt1, paramInt2);
  }
  
  public static final void sort(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sort");
    if (paramArrayOfInt.length > 1) {
      Arrays.sort(paramArrayOfInt);
    }
  }
  
  public static final void sort(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sort");
    Arrays.sort(paramArrayOfInt, paramInt1, paramInt2);
  }
  
  public static final void sort(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sort");
    if (paramArrayOfLong.length > 1) {
      Arrays.sort(paramArrayOfLong);
    }
  }
  
  public static final void sort(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sort");
    Arrays.sort(paramArrayOfLong, paramInt1, paramInt2);
  }
  
  private static final <T extends Comparable<? super T>> void sort(T[] paramArrayOfT)
  {
    if (paramArrayOfT != null)
    {
      ArraysKt.sort((Object[])paramArrayOfT);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
  }
  
  public static final <T> void sort(T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sort");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT);
    }
  }
  
  public static final <T> void sort(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sort");
    Arrays.sort(paramArrayOfT, paramInt1, paramInt2);
  }
  
  public static final void sort(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sort");
    if (paramArrayOfShort.length > 1) {
      Arrays.sort(paramArrayOfShort);
    }
  }
  
  public static final void sort(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sort");
    Arrays.sort(paramArrayOfShort, paramInt1, paramInt2);
  }
  
  public static final <T> void sortWith(T[] paramArrayOfT, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT, paramComparator);
    }
  }
  
  public static final <T> void sortWith(T[] paramArrayOfT, Comparator<? super T> paramComparator, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    Arrays.sort(paramArrayOfT, paramInt1, paramInt2, paramComparator);
  }
  
  public static final SortedSet<Byte> toSortedSet(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfByte, (Collection)new TreeSet());
  }
  
  public static final SortedSet<Character> toSortedSet(char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfChar, (Collection)new TreeSet());
  }
  
  public static final SortedSet<Double> toSortedSet(double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfDouble, (Collection)new TreeSet());
  }
  
  public static final SortedSet<Float> toSortedSet(float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfFloat, (Collection)new TreeSet());
  }
  
  public static final SortedSet<Integer> toSortedSet(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfInt, (Collection)new TreeSet());
  }
  
  public static final SortedSet<Long> toSortedSet(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfLong, (Collection)new TreeSet());
  }
  
  public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfT, (Collection)new TreeSet());
  }
  
  public static final <T> SortedSet<T> toSortedSet(T[] paramArrayOfT, Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toSortedSet");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfT, (Collection)new TreeSet(paramComparator));
  }
  
  public static final SortedSet<Short> toSortedSet(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfShort, (Collection)new TreeSet());
  }
  
  public static final SortedSet<Boolean> toSortedSet(boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfBoolean, (Collection)new TreeSet());
  }
  
  public static final Boolean[] toTypedArray(boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toTypedArray");
    Boolean[] arrayOfBoolean = new Boolean[paramArrayOfBoolean.length];
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      arrayOfBoolean[i] = Boolean.valueOf(paramArrayOfBoolean[i]);
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  public static final Byte[] toTypedArray(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toTypedArray");
    Byte[] arrayOfByte = new Byte[paramArrayOfByte.length];
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Byte.valueOf(paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static final Character[] toTypedArray(char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toTypedArray");
    Character[] arrayOfCharacter = new Character[paramArrayOfChar.length];
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      arrayOfCharacter[i] = Character.valueOf(paramArrayOfChar[i]);
      i += 1;
    }
    return arrayOfCharacter;
  }
  
  public static final Double[] toTypedArray(double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toTypedArray");
    Double[] arrayOfDouble = new Double[paramArrayOfDouble.length];
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = Double.valueOf(paramArrayOfDouble[i]);
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public static final Float[] toTypedArray(float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toTypedArray");
    Float[] arrayOfFloat = new Float[paramArrayOfFloat.length];
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFloat[i] = Float.valueOf(paramArrayOfFloat[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static final Integer[] toTypedArray(int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toTypedArray");
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  public static final Long[] toTypedArray(long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toTypedArray");
    Long[] arrayOfLong = new Long[paramArrayOfLong.length];
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = Long.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static final Short[] toTypedArray(short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toTypedArray");
    Short[] arrayOfShort = new Short[paramArrayOfShort.length];
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = Short.valueOf(paramArrayOfShort[i]);
      i += 1;
    }
    return arrayOfShort;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\ArraysKt___ArraysJvmKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */