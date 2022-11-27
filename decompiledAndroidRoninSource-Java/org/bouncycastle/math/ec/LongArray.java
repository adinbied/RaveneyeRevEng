package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

class LongArray
  implements Cloneable
{
  private static final short[] INTERLEAVE2_TABLE = { 0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845 };
  private static final int[] INTERLEAVE3_TABLE = { 0, 1, 8, 9, 64, 65, 72, 73, 512, 513, 520, 521, 576, 577, 584, 585, 4096, 4097, 4104, 4105, 4160, 4161, 4168, 4169, 4608, 4609, 4616, 4617, 4672, 4673, 4680, 4681, 32768, 32769, 32776, 32777, 32832, 32833, 32840, 32841, 33280, 33281, 33288, 33289, 33344, 33345, 33352, 33353, 36864, 36865, 36872, 36873, 36928, 36929, 36936, 36937, 37376, 37377, 37384, 37385, 37440, 37441, 37448, 37449, 262144, 262145, 262152, 262153, 262208, 262209, 262216, 262217, 262656, 262657, 262664, 262665, 262720, 262721, 262728, 262729, 266240, 266241, 266248, 266249, 266304, 266305, 266312, 266313, 266752, 266753, 266760, 266761, 266816, 266817, 266824, 266825, 294912, 294913, 294920, 294921, 294976, 294977, 294984, 294985, 295424, 295425, 295432, 295433, 295488, 295489, 295496, 295497, 299008, 299009, 299016, 299017, 299072, 299073, 299080, 299081, 299520, 299521, 299528, 299529, 299584, 299585, 299592, 299593 };
  private static final int[] INTERLEAVE4_TABLE = { 0, 1, 16, 17, 256, 257, 272, 273, 4096, 4097, 4112, 4113, 4352, 4353, 4368, 4369, 65536, 65537, 65552, 65553, 65792, 65793, 65808, 65809, 69632, 69633, 69648, 69649, 69888, 69889, 69904, 69905, 1048576, 1048577, 1048592, 1048593, 1048832, 1048833, 1048848, 1048849, 1052672, 1052673, 1052688, 1052689, 1052928, 1052929, 1052944, 1052945, 1114112, 1114113, 1114128, 1114129, 1114368, 1114369, 1114384, 1114385, 1118208, 1118209, 1118224, 1118225, 1118464, 1118465, 1118480, 1118481, 16777216, 16777217, 16777232, 16777233, 16777472, 16777473, 16777488, 16777489, 16781312, 16781313, 16781328, 16781329, 16781568, 16781569, 16781584, 16781585, 16842752, 16842753, 16842768, 16842769, 16843008, 16843009, 16843024, 16843025, 16846848, 16846849, 16846864, 16846865, 16847104, 16847105, 16847120, 16847121, 17825792, 17825793, 17825808, 17825809, 17826048, 17826049, 17826064, 17826065, 17829888, 17829889, 17829904, 17829905, 17830144, 17830145, 17830160, 17830161, 17891328, 17891329, 17891344, 17891345, 17891584, 17891585, 17891600, 17891601, 17895424, 17895425, 17895440, 17895441, 17895680, 17895681, 17895696, 17895697, 268435456, 268435457, 268435472, 268435473, 268435712, 268435713, 268435728, 268435729, 268439552, 268439553, 268439568, 268439569, 268439808, 268439809, 268439824, 268439825, 268500992, 268500993, 268501008, 268501009, 268501248, 268501249, 268501264, 268501265, 268505088, 268505089, 268505104, 268505105, 268505344, 268505345, 268505360, 268505361, 269484032, 269484033, 269484048, 269484049, 269484288, 269484289, 269484304, 269484305, 269488128, 269488129, 269488144, 269488145, 269488384, 269488385, 269488400, 269488401, 269549568, 269549569, 269549584, 269549585, 269549824, 269549825, 269549840, 269549841, 269553664, 269553665, 269553680, 269553681, 269553920, 269553921, 269553936, 269553937, 285212672, 285212673, 285212688, 285212689, 285212928, 285212929, 285212944, 285212945, 285216768, 285216769, 285216784, 285216785, 285217024, 285217025, 285217040, 285217041, 285278208, 285278209, 285278224, 285278225, 285278464, 285278465, 285278480, 285278481, 285282304, 285282305, 285282320, 285282321, 285282560, 285282561, 285282576, 285282577, 286261248, 286261249, 286261264, 286261265, 286261504, 286261505, 286261520, 286261521, 286265344, 286265345, 286265360, 286265361, 286265600, 286265601, 286265616, 286265617, 286326784, 286326785, 286326800, 286326801, 286327040, 286327041, 286327056, 286327057, 286330880, 286330881, 286330896, 286330897, 286331136, 286331137, 286331152, 286331153 };
  private static final int[] INTERLEAVE5_TABLE = { 0, 1, 32, 33, 1024, 1025, 1056, 1057, 32768, 32769, 32800, 32801, 33792, 33793, 33824, 33825, 1048576, 1048577, 1048608, 1048609, 1049600, 1049601, 1049632, 1049633, 1081344, 1081345, 1081376, 1081377, 1082368, 1082369, 1082400, 1082401, 33554432, 33554433, 33554464, 33554465, 33555456, 33555457, 33555488, 33555489, 33587200, 33587201, 33587232, 33587233, 33588224, 33588225, 33588256, 33588257, 34603008, 34603009, 34603040, 34603041, 34604032, 34604033, 34604064, 34604065, 34635776, 34635777, 34635808, 34635809, 34636800, 34636801, 34636832, 34636833, 1073741824, 1073741825, 1073741856, 1073741857, 1073742848, 1073742849, 1073742880, 1073742881, 1073774592, 1073774593, 1073774624, 1073774625, 1073775616, 1073775617, 1073775648, 1073775649, 1074790400, 1074790401, 1074790432, 1074790433, 1074791424, 1074791425, 1074791456, 1074791457, 1074823168, 1074823169, 1074823200, 1074823201, 1074824192, 1074824193, 1074824224, 1074824225, 1107296256, 1107296257, 1107296288, 1107296289, 1107297280, 1107297281, 1107297312, 1107297313, 1107329024, 1107329025, 1107329056, 1107329057, 1107330048, 1107330049, 1107330080, 1107330081, 1108344832, 1108344833, 1108344864, 1108344865, 1108345856, 1108345857, 1108345888, 1108345889, 1108377600, 1108377601, 1108377632, 1108377633, 1108378624, 1108378625, 1108378656, 1108378657 };
  private static final long[] INTERLEAVE7_TABLE = { 0L, 1L, 128L, 129L, 16384L, 16385L, 16512L, 16513L, 2097152L, 2097153L, 2097280L, 2097281L, 2113536L, 2113537L, 2113664L, 2113665L, 268435456L, 268435457L, 268435584L, 268435585L, 268451840L, 268451841L, 268451968L, 268451969L, 270532608L, 270532609L, 270532736L, 270532737L, 270548992L, 270548993L, 270549120L, 270549121L, 34359738368L, 34359738369L, 34359738496L, 34359738497L, 34359754752L, 34359754753L, 34359754880L, 34359754881L, 34361835520L, 34361835521L, 34361835648L, 34361835649L, 34361851904L, 34361851905L, 34361852032L, 34361852033L, 34628173824L, 34628173825L, 34628173952L, 34628173953L, 34628190208L, 34628190209L, 34628190336L, 34628190337L, 34630270976L, 34630270977L, 34630271104L, 34630271105L, 34630287360L, 34630287361L, 34630287488L, 34630287489L, 4398046511104L, 4398046511105L, 4398046511232L, 4398046511233L, 4398046527488L, 4398046527489L, 4398046527616L, 4398046527617L, 4398048608256L, 4398048608257L, 4398048608384L, 4398048608385L, 4398048624640L, 4398048624641L, 4398048624768L, 4398048624769L, 4398314946560L, 4398314946561L, 4398314946688L, 4398314946689L, 4398314962944L, 4398314962945L, 4398314963072L, 4398314963073L, 4398317043712L, 4398317043713L, 4398317043840L, 4398317043841L, 4398317060096L, 4398317060097L, 4398317060224L, 4398317060225L, 4432406249472L, 4432406249473L, 4432406249600L, 4432406249601L, 4432406265856L, 4432406265857L, 4432406265984L, 4432406265985L, 4432408346624L, 4432408346625L, 4432408346752L, 4432408346753L, 4432408363008L, 4432408363009L, 4432408363136L, 4432408363137L, 4432674684928L, 4432674684929L, 4432674685056L, 4432674685057L, 4432674701312L, 4432674701313L, 4432674701440L, 4432674701441L, 4432676782080L, 4432676782081L, 4432676782208L, 4432676782209L, 4432676798464L, 4432676798465L, 4432676798592L, 4432676798593L, 562949953421312L, 562949953421313L, 562949953421440L, 562949953421441L, 562949953437696L, 562949953437697L, 562949953437824L, 562949953437825L, 562949955518464L, 562949955518465L, 562949955518592L, 562949955518593L, 562949955534848L, 562949955534849L, 562949955534976L, 562949955534977L, 562950221856768L, 562950221856769L, 562950221856896L, 562950221856897L, 562950221873152L, 562950221873153L, 562950221873280L, 562950221873281L, 562950223953920L, 562950223953921L, 562950223954048L, 562950223954049L, 562950223970304L, 562950223970305L, 562950223970432L, 562950223970433L, 562984313159680L, 562984313159681L, 562984313159808L, 562984313159809L, 562984313176064L, 562984313176065L, 562984313176192L, 562984313176193L, 562984315256832L, 562984315256833L, 562984315256960L, 562984315256961L, 562984315273216L, 562984315273217L, 562984315273344L, 562984315273345L, 562984581595136L, 562984581595137L, 562984581595264L, 562984581595265L, 562984581611520L, 562984581611521L, 562984581611648L, 562984581611649L, 562984583692288L, 562984583692289L, 562984583692416L, 562984583692417L, 562984583708672L, 562984583708673L, 562984583708800L, 562984583708801L, 567347999932416L, 567347999932417L, 567347999932544L, 567347999932545L, 567347999948800L, 567347999948801L, 567347999948928L, 567347999948929L, 567348002029568L, 567348002029569L, 567348002029696L, 567348002029697L, 567348002045952L, 567348002045953L, 567348002046080L, 567348002046081L, 567348268367872L, 567348268367873L, 567348268368000L, 567348268368001L, 567348268384256L, 567348268384257L, 567348268384384L, 567348268384385L, 567348270465024L, 567348270465025L, 567348270465152L, 567348270465153L, 567348270481408L, 567348270481409L, 567348270481536L, 567348270481537L, 567382359670784L, 567382359670785L, 567382359670912L, 567382359670913L, 567382359687168L, 567382359687169L, 567382359687296L, 567382359687297L, 567382361767936L, 567382361767937L, 567382361768064L, 567382361768065L, 567382361784320L, 567382361784321L, 567382361784448L, 567382361784449L, 567382628106240L, 567382628106241L, 567382628106368L, 567382628106369L, 567382628122624L, 567382628122625L, 567382628122752L, 567382628122753L, 567382630203392L, 567382630203393L, 567382630203520L, 567382630203521L, 567382630219776L, 567382630219777L, 567382630219904L, 567382630219905L, 72057594037927936L, 72057594037927937L, 72057594037928064L, 72057594037928065L, 72057594037944320L, 72057594037944321L, 72057594037944448L, 72057594037944449L, 72057594040025088L, 72057594040025089L, 72057594040025216L, 72057594040025217L, 72057594040041472L, 72057594040041473L, 72057594040041600L, 72057594040041601L, 72057594306363392L, 72057594306363393L, 72057594306363520L, 72057594306363521L, 72057594306379776L, 72057594306379777L, 72057594306379904L, 72057594306379905L, 72057594308460544L, 72057594308460545L, 72057594308460672L, 72057594308460673L, 72057594308476928L, 72057594308476929L, 72057594308477056L, 72057594308477057L, 72057628397666304L, 72057628397666305L, 72057628397666432L, 72057628397666433L, 72057628397682688L, 72057628397682689L, 72057628397682816L, 72057628397682817L, 72057628399763456L, 72057628399763457L, 72057628399763584L, 72057628399763585L, 72057628399779840L, 72057628399779841L, 72057628399779968L, 72057628399779969L, 72057628666101760L, 72057628666101761L, 72057628666101888L, 72057628666101889L, 72057628666118144L, 72057628666118145L, 72057628666118272L, 72057628666118273L, 72057628668198912L, 72057628668198913L, 72057628668199040L, 72057628668199041L, 72057628668215296L, 72057628668215297L, 72057628668215424L, 72057628668215425L, 72061992084439040L, 72061992084439041L, 72061992084439168L, 72061992084439169L, 72061992084455424L, 72061992084455425L, 72061992084455552L, 72061992084455553L, 72061992086536192L, 72061992086536193L, 72061992086536320L, 72061992086536321L, 72061992086552576L, 72061992086552577L, 72061992086552704L, 72061992086552705L, 72061992352874496L, 72061992352874497L, 72061992352874624L, 72061992352874625L, 72061992352890880L, 72061992352890881L, 72061992352891008L, 72061992352891009L, 72061992354971648L, 72061992354971649L, 72061992354971776L, 72061992354971777L, 72061992354988032L, 72061992354988033L, 72061992354988160L, 72061992354988161L, 72062026444177408L, 72062026444177409L, 72062026444177536L, 72062026444177537L, 72062026444193792L, 72062026444193793L, 72062026444193920L, 72062026444193921L, 72062026446274560L, 72062026446274561L, 72062026446274688L, 72062026446274689L, 72062026446290944L, 72062026446290945L, 72062026446291072L, 72062026446291073L, 72062026712612864L, 72062026712612865L, 72062026712612992L, 72062026712612993L, 72062026712629248L, 72062026712629249L, 72062026712629376L, 72062026712629377L, 72062026714710016L, 72062026714710017L, 72062026714710144L, 72062026714710145L, 72062026714726400L, 72062026714726401L, 72062026714726528L, 72062026714726529L, 72620543991349248L, 72620543991349249L, 72620543991349376L, 72620543991349377L, 72620543991365632L, 72620543991365633L, 72620543991365760L, 72620543991365761L, 72620543993446400L, 72620543993446401L, 72620543993446528L, 72620543993446529L, 72620543993462784L, 72620543993462785L, 72620543993462912L, 72620543993462913L, 72620544259784704L, 72620544259784705L, 72620544259784832L, 72620544259784833L, 72620544259801088L, 72620544259801089L, 72620544259801216L, 72620544259801217L, 72620544261881856L, 72620544261881857L, 72620544261881984L, 72620544261881985L, 72620544261898240L, 72620544261898241L, 72620544261898368L, 72620544261898369L, 72620578351087616L, 72620578351087617L, 72620578351087744L, 72620578351087745L, 72620578351104000L, 72620578351104001L, 72620578351104128L, 72620578351104129L, 72620578353184768L, 72620578353184769L, 72620578353184896L, 72620578353184897L, 72620578353201152L, 72620578353201153L, 72620578353201280L, 72620578353201281L, 72620578619523072L, 72620578619523073L, 72620578619523200L, 72620578619523201L, 72620578619539456L, 72620578619539457L, 72620578619539584L, 72620578619539585L, 72620578621620224L, 72620578621620225L, 72620578621620352L, 72620578621620353L, 72620578621636608L, 72620578621636609L, 72620578621636736L, 72620578621636737L, 72624942037860352L, 72624942037860353L, 72624942037860480L, 72624942037860481L, 72624942037876736L, 72624942037876737L, 72624942037876864L, 72624942037876865L, 72624942039957504L, 72624942039957505L, 72624942039957632L, 72624942039957633L, 72624942039973888L, 72624942039973889L, 72624942039974016L, 72624942039974017L, 72624942306295808L, 72624942306295809L, 72624942306295936L, 72624942306295937L, 72624942306312192L, 72624942306312193L, 72624942306312320L, 72624942306312321L, 72624942308392960L, 72624942308392961L, 72624942308393088L, 72624942308393089L, 72624942308409344L, 72624942308409345L, 72624942308409472L, 72624942308409473L, 72624976397598720L, 72624976397598721L, 72624976397598848L, 72624976397598849L, 72624976397615104L, 72624976397615105L, 72624976397615232L, 72624976397615233L, 72624976399695872L, 72624976399695873L, 72624976399696000L, 72624976399696001L, 72624976399712256L, 72624976399712257L, 72624976399712384L, 72624976399712385L, 72624976666034176L, 72624976666034177L, 72624976666034304L, 72624976666034305L, 72624976666050560L, 72624976666050561L, 72624976666050688L, 72624976666050689L, 72624976668131328L, 72624976668131329L, 72624976668131456L, 72624976668131457L, 72624976668147712L, 72624976668147713L, 72624976668147840L, 72624976668147841L };
  private static final String ZEROES = "0000000000000000000000000000000000000000000000000000000000000000";
  static final byte[] bitLengths = { 0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };
  private long[] m_ints;
  
  public LongArray(int paramInt)
  {
    this.m_ints = new long[paramInt];
  }
  
  public LongArray(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0))
    {
      if (paramBigInteger.signum() == 0)
      {
        this.m_ints = new long[] { 0L };
        return;
      }
      paramBigInteger = paramBigInteger.toByteArray();
      int j = paramBigInteger.length;
      int i;
      if (paramBigInteger[0] == 0)
      {
        j -= 1;
        i = 1;
      }
      else
      {
        i = 0;
      }
      int k = (j + 7) / 8;
      this.m_ints = new long[k];
      int m = k - 1;
      int n = j % 8 + i;
      k = i;
      j = m;
      long l;
      if (i < n)
      {
        l = 0L;
        while (i < n)
        {
          l = l << 8 | paramBigInteger[i] & 0xFF;
          i += 1;
        }
        this.m_ints[m] = l;
        j = m - 1;
        k = i;
      }
      while (j >= 0)
      {
        l = 0L;
        i = 0;
        while (i < 8)
        {
          l = l << 8 | paramBigInteger[k] & 0xFF;
          i += 1;
          k += 1;
        }
        this.m_ints[j] = l;
        j -= 1;
      }
      return;
    }
    throw new IllegalArgumentException("invalid F2m field value");
  }
  
  public LongArray(long[] paramArrayOfLong)
  {
    this.m_ints = paramArrayOfLong;
  }
  
  public LongArray(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == paramArrayOfLong.length))
    {
      this.m_ints = paramArrayOfLong;
      return;
    }
    long[] arrayOfLong = new long[paramInt2];
    this.m_ints = arrayOfLong;
    System.arraycopy(paramArrayOfLong, paramInt1, arrayOfLong, 0, paramInt2);
  }
  
  private static void add(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = paramInt1 + i;
      paramArrayOfLong1[j] ^= paramArrayOfLong2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  private static void add(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, long[] paramArrayOfLong3, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < paramInt4)
    {
      paramArrayOfLong1[(paramInt1 + i)] ^= paramArrayOfLong2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  private static void addBoth(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, long[] paramArrayOfLong3, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < paramInt4)
    {
      int j = paramInt1 + i;
      paramArrayOfLong1[j] ^= paramArrayOfLong2[(paramInt2 + i)] ^ paramArrayOfLong3[(paramInt3 + i)];
      i += 1;
    }
  }
  
  private void addShiftedByBitsSafe(LongArray paramLongArray, int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt1 + 63 >>> 6;
    int i = paramInt2 >>> 6;
    paramInt2 &= 0x3F;
    if (paramInt2 == 0)
    {
      add(this.m_ints, i, paramLongArray.m_ints, 0, paramInt1);
      return;
    }
    long l = addShiftedUp(this.m_ints, i, paramLongArray.m_ints, 0, paramInt1, paramInt2);
    if (l != 0L)
    {
      paramLongArray = this.m_ints;
      paramInt1 += i;
      paramLongArray[paramInt1] = (l ^ paramLongArray[paramInt1]);
    }
  }
  
  private static long addShiftedDown(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    long l2;
    for (long l1 = 0L;; l1 = l2 << 64 - paramInt4)
    {
      paramInt3 -= 1;
      if (paramInt3 < 0) {
        break;
      }
      l2 = paramArrayOfLong2[(paramInt2 + paramInt3)];
      int i = paramInt1 + paramInt3;
      paramArrayOfLong1[i] = ((l1 | l2 >>> paramInt4) ^ paramArrayOfLong1[i]);
    }
    return l1;
  }
  
  private static long addShiftedUp(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = 0L;
    int i = 0;
    while (i < paramInt3)
    {
      long l2 = paramArrayOfLong2[(paramInt2 + i)];
      int j = paramInt1 + i;
      paramArrayOfLong1[j] = ((l1 | l2 << paramInt4) ^ paramArrayOfLong1[j]);
      l1 = l2 >>> 64 - paramInt4;
      i += 1;
    }
    return l1;
  }
  
  private static int bitLength(long paramLong)
  {
    int j = 32;
    int k = (int)(paramLong >>> 32);
    int i = k;
    if (k == 0)
    {
      i = (int)paramLong;
      j = 0;
    }
    k = i >>> 16;
    if (k == 0)
    {
      k = i >>> 8;
      if (k == 0) {
        i = bitLengths[i];
      } else {
        i = bitLengths[k] + 8;
      }
    }
    else
    {
      i = k >>> 8;
      if (i == 0) {
        i = bitLengths[k] + 16;
      } else {
        i = bitLengths[i] + 24;
      }
    }
    return j + i;
  }
  
  private int degreeFrom(int paramInt)
  {
    paramInt = paramInt + 62 >>> 6;
    int i;
    long l;
    do
    {
      if (paramInt == 0) {
        return 0;
      }
      long[] arrayOfLong = this.m_ints;
      i = paramInt - 1;
      l = arrayOfLong[i];
      paramInt = i;
    } while (l == 0L);
    return (i << 6) + bitLength(l);
  }
  
  private static void distribute(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < paramInt4)
    {
      long l = paramArrayOfLong[(paramInt1 + i)];
      int j = paramInt2 + i;
      paramArrayOfLong[j] ^= l;
      j = paramInt3 + i;
      paramArrayOfLong[j] = (l ^ paramArrayOfLong[j]);
      i += 1;
    }
  }
  
  private static void flipBit(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    paramInt1 += (paramInt2 >>> 6);
    paramArrayOfLong[paramInt1] ^= 1L << (paramInt2 & 0x3F);
  }
  
  private static void flipVector(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 += (paramInt4 >>> 6);
    paramInt4 &= 0x3F;
    if (paramInt4 == 0)
    {
      add(paramArrayOfLong1, paramInt1, paramArrayOfLong2, paramInt2, paramInt3);
      return;
    }
    paramArrayOfLong1[paramInt1] = (addShiftedDown(paramArrayOfLong1, paramInt1 + 1, paramArrayOfLong2, paramInt2, paramInt3, 64 - paramInt4) ^ paramArrayOfLong1[paramInt1]);
  }
  
  private static void flipWord(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    paramInt1 += (paramInt2 >>> 6);
    paramInt2 &= 0x3F;
    if (paramInt2 == 0)
    {
      paramArrayOfLong[paramInt1] ^= paramLong;
      return;
    }
    paramArrayOfLong[paramInt1] ^= paramLong << paramInt2;
    paramLong >>>= 64 - paramInt2;
    if (paramLong != 0L)
    {
      paramInt1 += 1;
      paramArrayOfLong[paramInt1] = (paramLong ^ paramArrayOfLong[paramInt1]);
    }
  }
  
  private static void interleave(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 != 3)
    {
      if (paramInt4 != 5)
      {
        if (paramInt4 != 7)
        {
          interleave2_n(paramArrayOfLong1, paramInt1, paramArrayOfLong2, paramInt2, paramInt3, bitLengths[paramInt4] - 1);
          return;
        }
        interleave7(paramArrayOfLong1, paramInt1, paramArrayOfLong2, paramInt2, paramInt3);
        return;
      }
      interleave5(paramArrayOfLong1, paramInt1, paramArrayOfLong2, paramInt2, paramInt3);
      return;
    }
    interleave3(paramArrayOfLong1, paramInt1, paramArrayOfLong2, paramInt2, paramInt3);
  }
  
  private static long interleave2_32to64(int paramInt)
  {
    short[] arrayOfShort = INTERLEAVE2_TABLE;
    int i = arrayOfShort[(paramInt & 0xFF)];
    int j = arrayOfShort[(paramInt >>> 8 & 0xFF)];
    int k = arrayOfShort[(paramInt >>> 16 & 0xFF)];
    long l = arrayOfShort[(paramInt >>> 24)] << 16 | k;
    return (i | j << 16) & 0xFFFFFFFF | (l & 0xFFFFFFFF) << 32;
  }
  
  private static long interleave2_n(long paramLong, int paramInt)
  {
    while (paramInt > 1)
    {
      paramInt -= 2;
      l1 = interleave4_16to64((int)paramLong & 0xFFFF);
      long l2 = interleave4_16to64((int)(paramLong >>> 16) & 0xFFFF);
      long l3 = interleave4_16to64((int)(paramLong >>> 32) & 0xFFFF);
      paramLong = interleave4_16to64((int)(paramLong >>> 48) & 0xFFFF) << 3 | l2 << 1 | l1 | l3 << 2;
    }
    long l1 = paramLong;
    if (paramInt > 0)
    {
      l1 = interleave2_32to64((int)paramLong);
      l1 = interleave2_32to64((int)(paramLong >>> 32)) << 1 | l1;
    }
    return l1;
  }
  
  private static void interleave2_n(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfLong2[(paramInt2 + i)] = interleave2_n(paramArrayOfLong1[(paramInt1 + i)], paramInt4);
      i += 1;
    }
  }
  
  private static long interleave3(long paramLong)
  {
    long l1 = interleave3_21to63((int)paramLong & 0x1FFFFF);
    long l2 = interleave3_21to63((int)(paramLong >>> 21) & 0x1FFFFF);
    return interleave3_21to63((int)(paramLong >>> 42) & 0x1FFFFF) << 2 | 0x8000000000000000 & paramLong | l1 | l2 << 1;
  }
  
  private static void interleave3(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfLong2[(paramInt2 + i)] = interleave3(paramArrayOfLong1[(paramInt1 + i)]);
      i += 1;
    }
  }
  
  private static long interleave3_13to65(int paramInt)
  {
    int[] arrayOfInt = INTERLEAVE5_TABLE;
    int i = arrayOfInt[(paramInt & 0x7F)];
    long l = arrayOfInt[(paramInt >>> 7)];
    return i & 0xFFFFFFFF | (l & 0xFFFFFFFF) << 35;
  }
  
  private static long interleave3_21to63(int paramInt)
  {
    int[] arrayOfInt = INTERLEAVE3_TABLE;
    int i = arrayOfInt[(paramInt & 0x7F)];
    int j = arrayOfInt[(paramInt >>> 7 & 0x7F)];
    long l1 = arrayOfInt[(paramInt >>> 14)];
    long l2 = j;
    return i & 0xFFFFFFFF | (l1 & 0xFFFFFFFF) << 42 | (l2 & 0xFFFFFFFF) << 21;
  }
  
  private static long interleave4_16to64(int paramInt)
  {
    int[] arrayOfInt = INTERLEAVE4_TABLE;
    int i = arrayOfInt[(paramInt & 0xFF)];
    long l = arrayOfInt[(paramInt >>> 8)];
    return i & 0xFFFFFFFF | (l & 0xFFFFFFFF) << 32;
  }
  
  private static long interleave5(long paramLong)
  {
    long l1 = interleave3_13to65((int)paramLong & 0x1FFF);
    long l2 = interleave3_13to65((int)(paramLong >>> 13) & 0x1FFF);
    long l3 = interleave3_13to65((int)(paramLong >>> 26) & 0x1FFF);
    long l4 = interleave3_13to65((int)(paramLong >>> 39) & 0x1FFF);
    return interleave3_13to65((int)(paramLong >>> 52) & 0x1FFF) << 4 | l1 | l2 << 1 | l3 << 2 | l4 << 3;
  }
  
  private static void interleave5(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfLong2[(paramInt2 + i)] = interleave5(paramArrayOfLong1[(paramInt1 + i)]);
      i += 1;
    }
  }
  
  private static long interleave7(long paramLong)
  {
    long[] arrayOfLong = INTERLEAVE7_TABLE;
    long l1 = arrayOfLong[((int)paramLong & 0x1FF)];
    long l2 = arrayOfLong[((int)(paramLong >>> 9) & 0x1FF)];
    long l3 = arrayOfLong[((int)(paramLong >>> 18) & 0x1FF)];
    long l4 = arrayOfLong[((int)(paramLong >>> 27) & 0x1FF)];
    long l5 = arrayOfLong[((int)(paramLong >>> 36) & 0x1FF)];
    long l6 = arrayOfLong[((int)(paramLong >>> 45) & 0x1FF)];
    return arrayOfLong[((int)(paramLong >>> 54) & 0x1FF)] << 6 | 0x8000000000000000 & paramLong | l1 | l2 << 1 | l3 << 2 | l4 << 3 | l5 << 4 | l6 << 5;
  }
  
  private static void interleave7(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfLong2[(paramInt2 + i)] = interleave7(paramArrayOfLong1[(paramInt1 + i)]);
      i += 1;
    }
  }
  
  private static void multiplyWord(long paramLong, long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2)
  {
    if ((paramLong & 1L) != 0L) {
      add(paramArrayOfLong2, paramInt2, paramArrayOfLong1, 0, paramInt1);
    }
    int i = 1;
    for (;;)
    {
      paramLong >>>= 1;
      if (paramLong == 0L) {
        break;
      }
      if ((paramLong & 1L) != 0L)
      {
        long l = addShiftedUp(paramArrayOfLong2, paramInt2, paramArrayOfLong1, 0, paramInt1, i);
        if (l != 0L)
        {
          int j = paramInt2 + paramInt1;
          paramArrayOfLong2[j] = (l ^ paramArrayOfLong2[j]);
        }
      }
      i += 1;
    }
  }
  
  private static void reduceBit(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    flipBit(paramArrayOfLong, paramInt1, paramInt2);
    paramInt3 = paramInt2 - paramInt3;
    paramInt2 = paramArrayOfInt.length;
    for (;;)
    {
      paramInt2 -= 1;
      if (paramInt2 < 0) {
        break;
      }
      flipBit(paramArrayOfLong, paramInt1, paramArrayOfInt[paramInt2] + paramInt3);
    }
    flipBit(paramArrayOfLong, paramInt1, paramInt3);
  }
  
  private static void reduceBitWise(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    for (;;)
    {
      int i = paramInt2 - 1;
      if (i < paramInt3) {
        break;
      }
      paramInt2 = i;
      if (testBit(paramArrayOfLong, paramInt1, i))
      {
        reduceBit(paramArrayOfLong, paramInt1, i, paramInt3, paramArrayOfInt);
        paramInt2 = i;
      }
    }
  }
  
  private static int reduceInPlace(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    int n = paramInt3 + 63 >>> 6;
    if (paramInt2 < n) {
      return paramInt2;
    }
    int i = paramInt2 << 6;
    int k = Math.min(i, (paramInt3 << 1) - 1);
    i -= k;
    while (i >= 64)
    {
      paramInt2 -= 1;
      i -= 64;
    }
    int j = paramArrayOfInt.length;
    int m = paramArrayOfInt[(j - 1)];
    if (j > 1) {
      j = paramArrayOfInt[(j - 2)];
    } else {
      j = 0;
    }
    m = Math.max(paramInt3, m + 64);
    int i1 = i + Math.min(k - m, paramInt3 - j) >> 6;
    i = k;
    j = paramInt2;
    if (i1 > 1)
    {
      i = paramInt2 - i1;
      reduceVectorWise(paramArrayOfLong, paramInt1, paramInt2, i, paramInt3, paramArrayOfInt);
      while (paramInt2 > i)
      {
        paramInt2 -= 1;
        paramArrayOfLong[(paramInt1 + paramInt2)] = 0L;
      }
      i <<= 6;
      j = paramInt2;
    }
    if (i > m)
    {
      reduceWordWise(paramArrayOfLong, paramInt1, j, m, paramInt3, paramArrayOfInt);
      i = m;
    }
    if (i > paramInt3) {
      reduceBitWise(paramArrayOfLong, paramInt1, i, paramInt3, paramArrayOfInt);
    }
    return n;
  }
  
  private static LongArray reduceResult(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    return new LongArray(paramArrayOfLong, paramInt1, reduceInPlace(paramArrayOfLong, paramInt1, paramInt2, paramInt3, paramArrayOfInt));
  }
  
  private static void reduceVectorWise(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int i = (paramInt3 << 6) - paramInt4;
    paramInt4 = paramArrayOfInt.length;
    for (;;)
    {
      paramInt4 -= 1;
      if (paramInt4 < 0) {
        break;
      }
      flipVector(paramArrayOfLong, paramInt1, paramArrayOfLong, paramInt1 + paramInt3, paramInt2 - paramInt3, i + paramArrayOfInt[paramInt4]);
    }
    flipVector(paramArrayOfLong, paramInt1, paramArrayOfLong, paramInt1 + paramInt3, paramInt2 - paramInt3, i);
  }
  
  private static void reduceWord(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong, int paramInt3, int[] paramArrayOfInt)
  {
    paramInt3 = paramInt2 - paramInt3;
    paramInt2 = paramArrayOfInt.length;
    for (;;)
    {
      paramInt2 -= 1;
      if (paramInt2 < 0) {
        break;
      }
      flipWord(paramArrayOfLong, paramInt1, paramArrayOfInt[paramInt2] + paramInt3, paramLong);
    }
    flipWord(paramArrayOfLong, paramInt1, paramInt3, paramLong);
  }
  
  private static void reduceWordWise(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int i = paramInt3 >>> 6;
    for (;;)
    {
      paramInt2 -= 1;
      if (paramInt2 <= i) {
        break;
      }
      int j = paramInt1 + paramInt2;
      l = paramArrayOfLong[j];
      if (l != 0L)
      {
        paramArrayOfLong[j] = 0L;
        reduceWord(paramArrayOfLong, paramInt1, paramInt2 << 6, l, paramInt4, paramArrayOfInt);
      }
    }
    paramInt2 = paramInt3 & 0x3F;
    i = paramInt1 + i;
    long l = paramArrayOfLong[i] >>> paramInt2;
    if (l != 0L)
    {
      paramArrayOfLong[i] ^= l << paramInt2;
      reduceWord(paramArrayOfLong, paramInt1, paramInt3, l, paramInt4, paramArrayOfInt);
    }
  }
  
  private long[] resizedInts(int paramInt)
  {
    long[] arrayOfLong1 = new long[paramInt];
    long[] arrayOfLong2 = this.m_ints;
    System.arraycopy(arrayOfLong2, 0, arrayOfLong1, 0, Math.min(arrayOfLong2.length, paramInt));
    return arrayOfLong1;
  }
  
  private static long shiftUp(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = 0L;
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramInt1 + i;
      long l2 = paramArrayOfLong[j];
      paramArrayOfLong[j] = (l1 | l2 << paramInt3);
      l1 = l2 >>> 64 - paramInt3;
      i += 1;
    }
    return l1;
  }
  
  private static long shiftUp(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = 0L;
    int i = 0;
    while (i < paramInt3)
    {
      long l2 = paramArrayOfLong1[(paramInt1 + i)];
      paramArrayOfLong2[(paramInt2 + i)] = (l1 | l2 << paramInt4);
      l1 = l2 >>> 64 - paramInt4;
      i += 1;
    }
    return l1;
  }
  
  private static void squareInPlace(long[] paramArrayOfLong, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    paramInt2 = paramInt1 << 1;
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      long l = paramArrayOfLong[paramInt1];
      paramInt2 -= 1;
      paramArrayOfLong[paramInt2] = interleave2_32to64((int)(l >>> 32));
      paramInt2 -= 1;
      paramArrayOfLong[paramInt2] = interleave2_32to64((int)l);
    }
  }
  
  private static boolean testBit(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    return (paramArrayOfLong[(paramInt1 + (paramInt2 >>> 6))] & 1L << (paramInt2 & 0x3F)) != 0L;
  }
  
  public LongArray addOne()
  {
    if (this.m_ints.length == 0) {
      return new LongArray(new long[] { 1L });
    }
    long[] arrayOfLong = resizedInts(Math.max(1, getUsedLength()));
    arrayOfLong[0] = (1L ^ arrayOfLong[0]);
    return new LongArray(arrayOfLong);
  }
  
  public void addShiftedByWords(LongArray paramLongArray, int paramInt)
  {
    int i = paramLongArray.getUsedLength();
    if (i == 0) {
      return;
    }
    int j = i + paramInt;
    if (j > this.m_ints.length) {
      this.m_ints = resizedInts(j);
    }
    add(this.m_ints, paramInt, paramLongArray.m_ints, 0, i);
  }
  
  public Object clone()
  {
    return new LongArray(Arrays.clone(this.m_ints));
  }
  
  public int degree()
  {
    int i = this.m_ints.length;
    int j;
    long l;
    do
    {
      if (i == 0) {
        return 0;
      }
      long[] arrayOfLong = this.m_ints;
      j = i - 1;
      l = arrayOfLong[j];
      i = j;
    } while (l == 0L);
    return (j << 6) + bitLength(l);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LongArray)) {
      return false;
    }
    paramObject = (LongArray)paramObject;
    int j = getUsedLength();
    if (((LongArray)paramObject).getUsedLength() != j) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (this.m_ints[i] != paramObject.m_ints[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int getLength()
  {
    return this.m_ints.length;
  }
  
  public int getUsedLength()
  {
    return getUsedLengthFrom(this.m_ints.length);
  }
  
  public int getUsedLengthFrom(int paramInt)
  {
    long[] arrayOfLong = this.m_ints;
    int i = Math.min(paramInt, arrayOfLong.length);
    if (i < 1) {
      return 0;
    }
    paramInt = i;
    if (arrayOfLong[0] != 0L)
    {
      do
      {
        i -= 1;
      } while (arrayOfLong[i] == 0L);
      return i + 1;
    }
    do
    {
      i = paramInt - 1;
      if (arrayOfLong[i] != 0L) {
        return i + 1;
      }
      paramInt = i;
    } while (i > 0);
    return 0;
  }
  
  public int hashCode()
  {
    int k = getUsedLength();
    int j = 1;
    int i = 0;
    while (i < k)
    {
      long l = this.m_ints[i];
      j = (j * 31 ^ (int)l) * 31 ^ (int)(l >>> 32);
      i += 1;
    }
    return j;
  }
  
  public boolean isOne()
  {
    long[] arrayOfLong = this.m_ints;
    if (arrayOfLong[0] != 1L) {
      return false;
    }
    int i = 1;
    while (i < arrayOfLong.length)
    {
      if (arrayOfLong[i] != 0L) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean isZero()
  {
    long[] arrayOfLong = this.m_ints;
    int i = 0;
    while (i < arrayOfLong.length)
    {
      if (arrayOfLong[i] != 0L) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public LongArray modInverse(int paramInt, int[] paramArrayOfInt)
  {
    int i = degree();
    if (i != 0)
    {
      if (i == 1) {
        return this;
      }
      Object localObject1 = (LongArray)clone();
      int j = paramInt + 63 >>> 6;
      Object localObject2 = new LongArray(j);
      reduceBit(((LongArray)localObject2).m_ints, 0, paramInt, paramInt, paramArrayOfInt);
      LongArray localLongArray1 = new LongArray(j);
      localLongArray1.m_ints[0] = 1L;
      LongArray localLongArray2 = new LongArray(j);
      paramArrayOfInt = new int[2];
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = (paramInt + 1);
      LongArray[] arrayOfLongArray = new LongArray[2];
      arrayOfLongArray[0] = localObject1;
      arrayOfLongArray[1] = localObject2;
      localObject1 = new int[2];
      Object tmp126_124 = localObject1;
      tmp126_124[0] = 1;
      Object tmp130_126 = tmp126_124;
      tmp130_126[1] = 0;
      tmp130_126;
      localObject2 = new LongArray[2];
      localObject2[0] = localLongArray1;
      localObject2[1] = localLongArray2;
      paramInt = paramArrayOfInt[1];
      j = localObject1[1];
      int k = paramInt - paramArrayOfInt[0];
      int i2 = 1;
      for (;;)
      {
        i = j;
        int i1 = k;
        int m = i2;
        int n = paramInt;
        if (k < 0)
        {
          i1 = -k;
          paramArrayOfInt[i2] = paramInt;
          localObject1[i2] = j;
          m = 1 - i2;
          n = paramArrayOfInt[m];
          i = localObject1[m];
        }
        localLongArray1 = arrayOfLongArray[m];
        paramInt = 1 - m;
        localLongArray1.addShiftedByBitsSafe(arrayOfLongArray[paramInt], paramArrayOfInt[paramInt], i1);
        j = arrayOfLongArray[m].degreeFrom(n);
        if (j == 0) {
          return localObject2[paramInt];
        }
        k = localObject1[paramInt];
        localObject2[m].addShiftedByBitsSafe(localObject2[paramInt], k, i1);
        k += i1;
        if (k > i)
        {
          paramInt = k;
        }
        else
        {
          paramInt = i;
          if (k == i) {
            paramInt = localObject2[m].degreeFrom(i);
          }
        }
        k = i1 + (j - n);
        i = j;
        j = paramInt;
        i2 = m;
        paramInt = i;
      }
    }
    throw new IllegalStateException();
  }
  
  public LongArray modMultiply(LongArray paramLongArray, int paramInt, int[] paramArrayOfInt)
  {
    int j = degree();
    if (j == 0) {
      return this;
    }
    int i = paramLongArray.degree();
    if (i == 0) {
      return paramLongArray;
    }
    if (j > i)
    {
      k = j;
      localObject1 = this;
      localObject2 = paramLongArray;
      paramLongArray = (LongArray)localObject1;
      localObject1 = localObject2;
      j = i;
      i = k;
    }
    else
    {
      localObject1 = this;
    }
    int n = j + 63 >>> 6;
    int k = i + 63 >>> 6;
    int i1 = j + i + 62 >>> 6;
    long l;
    if (n == 1)
    {
      l = localObject1.m_ints[0];
      if (l == 1L) {
        return paramLongArray;
      }
      localObject1 = new long[i1];
      multiplyWord(l, paramLongArray.m_ints, k, (long[])localObject1, 0);
      return reduceResult((long[])localObject1, 0, i1, paramInt, paramArrayOfInt);
    }
    int m = i + 7 + 63 >>> 6;
    int[] arrayOfInt = new int[16];
    i = m << 4;
    Object localObject2 = new long[i];
    arrayOfInt[1] = m;
    System.arraycopy(paramLongArray.m_ints, 0, localObject2, m, k);
    j = 2;
    k = m;
    paramLongArray = (LongArray)localObject2;
    while (j < 16)
    {
      k += m;
      arrayOfInt[j] = k;
      if ((j & 0x1) == 0)
      {
        shiftUp(paramLongArray, k >>> 1, paramLongArray, k, m, 1);
      }
      else
      {
        localObject2 = paramLongArray;
        add((long[])localObject2, m, paramLongArray, k - m, (long[])localObject2, k, m);
      }
      j += 1;
    }
    localObject2 = new long[i];
    shiftUp(paramLongArray, 0, (long[])localObject2, 0, i, 4);
    Object localObject1 = ((LongArray)localObject1).m_ints;
    k = i1 << 3;
    long[] arrayOfLong = new long[k];
    i = 0;
    j = k;
    if (i < n)
    {
      l = localObject1[i];
      j = i;
      for (;;)
      {
        int i2 = (int)l;
        l >>>= 4;
        int i3 = (int)l;
        addBoth(arrayOfLong, j, paramLongArray, arrayOfInt[(i2 & 0xF)], (long[])localObject2, arrayOfInt[(i3 & 0xF)], m);
        l >>>= 4;
        if (l == 0L)
        {
          i += 1;
          break;
        }
        j += i1;
      }
    }
    for (;;)
    {
      j -= i1;
      if (j == 0) {
        break;
      }
      addShiftedUp(arrayOfLong, j - i1, arrayOfLong, j, i1, 8);
    }
    return reduceResult(arrayOfLong, 0, i1, paramInt, paramArrayOfInt);
  }
  
  public LongArray modMultiplyAlt(LongArray paramLongArray, int paramInt, int[] paramArrayOfInt)
  {
    int j = degree();
    if (j == 0) {
      return this;
    }
    int i = paramLongArray.degree();
    if (i == 0) {
      return paramLongArray;
    }
    if (j > i)
    {
      k = j;
      localObject2 = this;
      localObject1 = paramLongArray;
      paramLongArray = (LongArray)localObject2;
      j = i;
      i = k;
    }
    else
    {
      localObject1 = this;
    }
    int k = j + 63 >>> 6;
    int i1 = i + 63 >>> 6;
    int i3 = j + i + 62 >>> 6;
    if (k == 1)
    {
      l = localObject1.m_ints[0];
      if (l == 1L) {
        return paramLongArray;
      }
      localObject1 = new long[i3];
      multiplyWord(l, paramLongArray.m_ints, i1, (long[])localObject1, 0);
      return reduceResult((long[])localObject1, 0, i3, paramInt, paramArrayOfInt);
    }
    int n = 15;
    int i4 = i + 15 + 63 >>> 6;
    int m = i4 * 8;
    Object localObject2 = new int[16];
    localObject2[0] = k;
    j = k + m;
    localObject2[1] = j;
    i = 2;
    for (;;)
    {
      j += i3;
      if (i >= 16) {
        break;
      }
      localObject2[i] = j;
      i += 1;
    }
    long[] arrayOfLong = new long[j + 1];
    Object localObject1 = ((LongArray)localObject1).m_ints;
    i = m;
    interleave((long[])localObject1, 0, arrayOfLong, 0, k, 4);
    System.arraycopy(paramLongArray.m_ints, 0, arrayOfLong, k, i1);
    m = k;
    j = 1;
    while (j < 8)
    {
      m += i4;
      shiftUp(arrayOfLong, k, arrayOfLong, m, i4, j);
      j += 1;
    }
    m = 0;
    j = n;
    n = 0;
    label331:
    long l = arrayOfLong[n];
    i1 = k;
    l >>>= m;
    int i2 = 0;
    for (;;)
    {
      int i5 = (int)l & j;
      if (i5 != 0) {
        add(arrayOfLong, localObject2[i5] + n, arrayOfLong, i1, i4);
      }
      i2 += 1;
      if (i2 == 8)
      {
        n += 1;
        if (n >= k)
        {
          m += 32;
          if (m >= 64)
          {
            if (m >= 64)
            {
              i = 16;
              for (;;)
              {
                i -= 1;
                if (i <= 1) {
                  break;
                }
                if ((i & 1L) == 0L) {
                  addShiftedUp(arrayOfLong, localObject2[(i >>> 1)], arrayOfLong, localObject2[i], i3, 16);
                } else {
                  distribute(arrayOfLong, localObject2[i], localObject2[(i - 1)], localObject2[1], i3);
                }
              }
              return reduceResult(arrayOfLong, localObject2[1], i3, paramInt, paramArrayOfInt);
            }
            n = j & j << 4;
            j = 60;
          }
          else
          {
            n = j;
            j = m;
          }
          shiftUp(arrayOfLong, k, i, 8);
          m = j;
          j = n;
          break;
        }
        break label331;
      }
      i1 += i4;
      l >>>= 4;
    }
  }
  
  public LongArray modMultiplyLD(LongArray paramLongArray, int paramInt, int[] paramArrayOfInt)
  {
    int j = degree();
    if (j == 0) {
      return this;
    }
    int i = paramLongArray.degree();
    if (i == 0) {
      return paramLongArray;
    }
    if (j > i)
    {
      k = j;
      localObject1 = this;
      localObject2 = paramLongArray;
      paramLongArray = (LongArray)localObject1;
      localObject1 = localObject2;
      j = i;
      i = k;
    }
    else
    {
      localObject1 = this;
    }
    int n = j + 63 >>> 6;
    int k = i + 63 >>> 6;
    int i1 = j + i + 62 >>> 6;
    if (n == 1)
    {
      long l = localObject1.m_ints[0];
      if (l == 1L) {
        return paramLongArray;
      }
      localObject1 = new long[i1];
      multiplyWord(l, paramLongArray.m_ints, k, (long[])localObject1, 0);
      return reduceResult((long[])localObject1, 0, i1, paramInt, paramArrayOfInt);
    }
    int m = i + 7 + 63 >>> 6;
    int[] arrayOfInt = new int[16];
    i = m << 4;
    Object localObject2 = new long[i];
    arrayOfInt[1] = m;
    System.arraycopy(paramLongArray.m_ints, 0, localObject2, m, k);
    j = 2;
    k = m;
    paramLongArray = (LongArray)localObject2;
    while (j < 16)
    {
      k += m;
      arrayOfInt[j] = k;
      if ((j & 0x1) == 0)
      {
        shiftUp(paramLongArray, k >>> 1, paramLongArray, k, m, 1);
      }
      else
      {
        localObject2 = paramLongArray;
        add((long[])localObject2, m, paramLongArray, k - m, (long[])localObject2, k, m);
      }
      j += 1;
    }
    localObject2 = new long[i];
    shiftUp(paramLongArray, 0, (long[])localObject2, 0, i, 4);
    Object localObject1 = ((LongArray)localObject1).m_ints;
    long[] arrayOfLong = new long[i1];
    i = 56;
    while (i >= 0)
    {
      j = 1;
      while (j < n)
      {
        k = (int)(localObject1[j] >>> i);
        addBoth(arrayOfLong, j - 1, paramLongArray, arrayOfInt[(k & 0xF)], (long[])localObject2, arrayOfInt[(k >>> 4 & 0xF)], m);
        j += 2;
      }
      shiftUp(arrayOfLong, 0, i1, 8);
      i -= 8;
    }
    i = 56;
    while (i >= 0)
    {
      j = 0;
      while (j < n)
      {
        k = (int)(localObject1[j] >>> i);
        addBoth(arrayOfLong, j, paramLongArray, arrayOfInt[(k & 0xF)], (long[])localObject2, arrayOfInt[(k >>> 4 & 0xF)], m);
        j += 2;
      }
      if (i > 0) {
        shiftUp(arrayOfLong, 0, i1, 8);
      }
      i -= 8;
    }
    return reduceResult(arrayOfLong, 0, i1, paramInt, paramArrayOfInt);
  }
  
  public LongArray modReduce(int paramInt, int[] paramArrayOfInt)
  {
    long[] arrayOfLong = Arrays.clone(this.m_ints);
    return new LongArray(arrayOfLong, 0, reduceInPlace(arrayOfLong, 0, arrayOfLong.length, paramInt, paramArrayOfInt));
  }
  
  public LongArray modSquare(int paramInt, int[] paramArrayOfInt)
  {
    int i = getUsedLength();
    if (i == 0) {
      return this;
    }
    int j = i << 1;
    long[] arrayOfLong = new long[j];
    i = 0;
    while (i < j)
    {
      long l = this.m_ints[(i >>> 1)];
      int k = i + 1;
      arrayOfLong[i] = interleave2_32to64((int)l);
      i = k + 1;
      arrayOfLong[k] = interleave2_32to64((int)(l >>> 32));
    }
    return new LongArray(arrayOfLong, 0, reduceInPlace(arrayOfLong, 0, j, paramInt, paramArrayOfInt));
  }
  
  public LongArray modSquareN(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int j = getUsedLength();
    if (j == 0) {
      return this;
    }
    int k = paramInt2 + 63 >>> 6 << 1;
    long[] arrayOfLong = new long[k];
    System.arraycopy(this.m_ints, 0, arrayOfLong, 0, j);
    int i = paramInt1;
    for (paramInt1 = j;; paramInt1 = reduceInPlace(arrayOfLong, 0, k, paramInt2, paramArrayOfInt))
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      squareInPlace(arrayOfLong, paramInt1, paramInt2, paramArrayOfInt);
    }
    return new LongArray(arrayOfLong, 0, paramInt1);
  }
  
  public LongArray multiply(LongArray paramLongArray, int paramInt, int[] paramArrayOfInt)
  {
    int i = degree();
    if (i == 0) {
      return this;
    }
    paramInt = paramLongArray.degree();
    if (paramInt == 0) {
      return paramLongArray;
    }
    if (i > paramInt)
    {
      j = i;
      paramArrayOfInt = this;
      localObject = paramLongArray;
      paramLongArray = paramArrayOfInt;
      paramArrayOfInt = (int[])localObject;
      i = paramInt;
      paramInt = j;
    }
    else
    {
      paramArrayOfInt = this;
    }
    int m = i + 63 >>> 6;
    int j = paramInt + 63 >>> 6;
    int n = i + paramInt + 62 >>> 6;
    long l;
    if (m == 1)
    {
      l = paramArrayOfInt.m_ints[0];
      if (l == 1L) {
        return paramLongArray;
      }
      paramArrayOfInt = new long[n];
      multiplyWord(l, paramLongArray.m_ints, j, paramArrayOfInt, 0);
      return new LongArray(paramArrayOfInt, 0, n);
    }
    int k = paramInt + 7 + 63 >>> 6;
    int[] arrayOfInt = new int[16];
    paramInt = k << 4;
    Object localObject = new long[paramInt];
    arrayOfInt[1] = k;
    System.arraycopy(paramLongArray.m_ints, 0, localObject, k, j);
    i = 2;
    j = k;
    paramLongArray = (LongArray)localObject;
    while (i < 16)
    {
      j += k;
      arrayOfInt[i] = j;
      if ((i & 0x1) == 0)
      {
        shiftUp(paramLongArray, j >>> 1, paramLongArray, j, k, 1);
      }
      else
      {
        localObject = paramLongArray;
        add((long[])localObject, k, (long[])localObject, j - k, paramLongArray, j, k);
      }
      i += 1;
    }
    localObject = new long[paramInt];
    shiftUp(paramLongArray, 0, (long[])localObject, 0, paramInt, 4);
    paramArrayOfInt = paramArrayOfInt.m_ints;
    j = n << 3;
    long[] arrayOfLong = new long[j];
    paramInt = 0;
    i = j;
    if (paramInt < m)
    {
      l = paramArrayOfInt[paramInt];
      i = paramInt;
      for (;;)
      {
        int i1 = (int)l;
        l >>>= 4;
        int i2 = (int)l;
        addBoth(arrayOfLong, i, paramLongArray, arrayOfInt[(i1 & 0xF)], (long[])localObject, arrayOfInt[(i2 & 0xF)], k);
        l >>>= 4;
        if (l == 0L)
        {
          paramInt += 1;
          break;
        }
        i += n;
      }
    }
    for (;;)
    {
      i -= n;
      if (i == 0) {
        break;
      }
      addShiftedUp(arrayOfLong, i - n, arrayOfLong, i, n, 8);
    }
    return new LongArray(arrayOfLong, 0, n);
  }
  
  public void reduce(int paramInt, int[] paramArrayOfInt)
  {
    long[] arrayOfLong = this.m_ints;
    paramInt = reduceInPlace(arrayOfLong, 0, arrayOfLong.length, paramInt, paramArrayOfInt);
    if (paramInt < arrayOfLong.length)
    {
      paramArrayOfInt = new long[paramInt];
      this.m_ints = paramArrayOfInt;
      System.arraycopy(arrayOfLong, 0, paramArrayOfInt, 0, paramInt);
    }
  }
  
  public LongArray square(int paramInt, int[] paramArrayOfInt)
  {
    paramInt = getUsedLength();
    if (paramInt == 0) {
      return this;
    }
    int i = paramInt << 1;
    paramArrayOfInt = new long[i];
    paramInt = 0;
    while (paramInt < i)
    {
      long l = this.m_ints[(paramInt >>> 1)];
      int j = paramInt + 1;
      paramArrayOfInt[paramInt] = interleave2_32to64((int)l);
      paramInt = j + 1;
      paramArrayOfInt[j] = interleave2_32to64((int)(l >>> 32));
    }
    return new LongArray(paramArrayOfInt, 0, i);
  }
  
  public boolean testBitZero()
  {
    long[] arrayOfLong = this.m_ints;
    int i = arrayOfLong.length;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if ((1L & arrayOfLong[0]) != 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public BigInteger toBigInteger()
  {
    int i2 = getUsedLength();
    if (i2 == 0) {
      return ECConstants.ZERO;
    }
    Object localObject = this.m_ints;
    int i3 = i2 - 1;
    long l = localObject[i3];
    localObject = new byte[8];
    int i1 = 0;
    int k = 7;
    int j = 0;
    int m = 0;
    while (k >= 0)
    {
      int i = (byte)(int)(l >>> k * 8);
      int n;
      if (m == 0)
      {
        n = j;
        if (i == 0) {}
      }
      else
      {
        localObject[j] = i;
        n = j + 1;
        m = 1;
      }
      k -= 1;
      j = n;
    }
    byte[] arrayOfByte = new byte[i3 * 8 + j];
    k = i1;
    while (k < j)
    {
      arrayOfByte[k] = localObject[k];
      k += 1;
    }
    m = i2 - 2;
    k = j;
    j = m;
    while (j >= 0)
    {
      l = this.m_ints[j];
      m = 7;
      while (m >= 0)
      {
        arrayOfByte[k] = ((byte)(int)(l >>> m * 8));
        m -= 1;
        k += 1;
      }
      j -= 1;
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public String toString()
  {
    int i = getUsedLength();
    if (i == 0) {
      return "0";
    }
    Object localObject = this.m_ints;
    i -= 1;
    localObject = new StringBuffer(Long.toBinaryString(localObject[i]));
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      String str = Long.toBinaryString(this.m_ints[i]);
      int j = str.length();
      if (j < 64) {
        ((StringBuffer)localObject).append("0000000000000000000000000000000000000000000000000000000000000000".substring(j));
      }
      ((StringBuffer)localObject).append(str);
    }
    return ((StringBuffer)localObject).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\LongArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */