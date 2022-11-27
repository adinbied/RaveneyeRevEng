package com.drew.metadata.iptc;

import com.drew.metadata.Directory;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class IptcDirectory
  extends Directory
{
  public static final int TAG_ACTION_ADVISED = 554;
  public static final int TAG_APPLICATION_RECORD_VERSION = 512;
  public static final int TAG_ARM_IDENTIFIER = 376;
  public static final int TAG_ARM_VERSION = 378;
  public static final int TAG_AUDIO_DURATION = 665;
  public static final int TAG_AUDIO_OUTCUE = 666;
  public static final int TAG_AUDIO_SAMPLING_RATE = 663;
  public static final int TAG_AUDIO_SAMPLING_RESOLUTION = 664;
  public static final int TAG_AUDIO_TYPE = 662;
  public static final int TAG_BY_LINE = 592;
  public static final int TAG_BY_LINE_TITLE = 597;
  public static final int TAG_CAPTION = 632;
  public static final int TAG_CAPTION_WRITER = 634;
  public static final int TAG_CATEGORY = 527;
  public static final int TAG_CITY = 602;
  public static final int TAG_CODED_CHARACTER_SET = 346;
  public static final int TAG_CONTACT = 630;
  public static final int TAG_CONTENT_LOCATION_CODE = 538;
  public static final int TAG_CONTENT_LOCATION_NAME = 539;
  public static final int TAG_COPYRIGHT_NOTICE = 628;
  public static final int TAG_COUNTRY_OR_PRIMARY_LOCATION_CODE = 612;
  public static final int TAG_COUNTRY_OR_PRIMARY_LOCATION_NAME = 613;
  public static final int TAG_CREDIT = 622;
  public static final int TAG_DATE_CREATED = 567;
  public static final int TAG_DATE_SENT = 326;
  public static final int TAG_DESTINATION = 261;
  public static final int TAG_DIGITAL_DATE_CREATED = 574;
  public static final int TAG_DIGITAL_TIME_CREATED = 575;
  public static final int TAG_EDITORIAL_UPDATE = 520;
  public static final int TAG_EDIT_STATUS = 519;
  public static final int TAG_ENVELOPE_NUMBER = 296;
  public static final int TAG_ENVELOPE_PRIORITY = 316;
  public static final int TAG_ENVELOPE_RECORD_VERSION = 256;
  public static final int TAG_EXPIRATION_DATE = 549;
  public static final int TAG_EXPIRATION_TIME = 550;
  public static final int TAG_FILE_FORMAT = 276;
  public static final int TAG_FILE_VERSION = 278;
  public static final int TAG_FIXTURE_ID = 534;
  public static final int TAG_HEADLINE = 617;
  public static final int TAG_IMAGE_ORIENTATION = 643;
  public static final int TAG_IMAGE_TYPE = 642;
  public static final int TAG_JOB_ID = 696;
  public static final int TAG_KEYWORDS = 537;
  public static final int TAG_LANGUAGE_IDENTIFIER = 647;
  public static final int TAG_LOCAL_CAPTION = 633;
  public static final int TAG_MASTER_DOCUMENT_ID = 697;
  public static final int TAG_OBJECT_ATTRIBUTE_REFERENCE = 516;
  public static final int TAG_OBJECT_CYCLE = 587;
  public static final int TAG_OBJECT_NAME = 517;
  public static final int TAG_OBJECT_PREVIEW_DATA = 714;
  public static final int TAG_OBJECT_PREVIEW_FILE_FORMAT = 712;
  public static final int TAG_OBJECT_PREVIEW_FILE_FORMAT_VERSION = 713;
  public static final int TAG_OBJECT_TYPE_REFERENCE = 515;
  public static final int TAG_ORIGINAL_TRANSMISSION_REFERENCE = 615;
  public static final int TAG_ORIGINATING_PROGRAM = 577;
  public static final int TAG_OWNER_ID = 700;
  public static final int TAG_PRODUCT_ID = 306;
  public static final int TAG_PROGRAM_VERSION = 582;
  public static final int TAG_PROVINCE_OR_STATE = 607;
  public static final int TAG_RASTERIZED_CAPTION = 637;
  public static final int TAG_REFERENCE_DATE = 559;
  public static final int TAG_REFERENCE_NUMBER = 562;
  public static final int TAG_REFERENCE_SERVICE = 557;
  public static final int TAG_RELEASE_DATE = 542;
  public static final int TAG_RELEASE_TIME = 547;
  public static final int TAG_SERVICE_ID = 286;
  public static final int TAG_SHORT_DOCUMENT_ID = 698;
  public static final int TAG_SOURCE = 627;
  public static final int TAG_SPECIAL_INSTRUCTIONS = 552;
  public static final int TAG_SUBJECT_REFERENCE = 524;
  public static final int TAG_SUB_LOCATION = 604;
  public static final int TAG_SUPPLEMENTAL_CATEGORIES = 532;
  public static final int TAG_TIME_CREATED = 572;
  public static final int TAG_TIME_SENT = 336;
  public static final int TAG_UNIQUE_DOCUMENT_ID = 699;
  public static final int TAG_UNIQUE_OBJECT_NAME = 356;
  public static final int TAG_URGENCY = 522;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(256), "Enveloped Record Version");
    _tagNameMap.put(Integer.valueOf(261), "Destination");
    _tagNameMap.put(Integer.valueOf(276), "File Format");
    _tagNameMap.put(Integer.valueOf(278), "File Version");
    _tagNameMap.put(Integer.valueOf(286), "Service Identifier");
    _tagNameMap.put(Integer.valueOf(296), "Envelope Number");
    _tagNameMap.put(Integer.valueOf(306), "Product Identifier");
    _tagNameMap.put(Integer.valueOf(316), "Envelope Priority");
    _tagNameMap.put(Integer.valueOf(326), "Date Sent");
    _tagNameMap.put(Integer.valueOf(336), "Time Sent");
    _tagNameMap.put(Integer.valueOf(346), "Coded Character Set");
    _tagNameMap.put(Integer.valueOf(356), "Unique Object Name");
    _tagNameMap.put(Integer.valueOf(376), "ARM Identifier");
    _tagNameMap.put(Integer.valueOf(378), "ARM Version");
    _tagNameMap.put(Integer.valueOf(512), "Application Record Version");
    _tagNameMap.put(Integer.valueOf(515), "Object Type Reference");
    _tagNameMap.put(Integer.valueOf(516), "Object Attribute Reference");
    _tagNameMap.put(Integer.valueOf(517), "Object Name");
    _tagNameMap.put(Integer.valueOf(519), "Edit Status");
    _tagNameMap.put(Integer.valueOf(520), "Editorial Update");
    _tagNameMap.put(Integer.valueOf(522), "Urgency");
    _tagNameMap.put(Integer.valueOf(524), "Subject Reference");
    _tagNameMap.put(Integer.valueOf(527), "Category");
    _tagNameMap.put(Integer.valueOf(532), "Supplemental Category(s)");
    _tagNameMap.put(Integer.valueOf(534), "Fixture Identifier");
    _tagNameMap.put(Integer.valueOf(537), "Keywords");
    _tagNameMap.put(Integer.valueOf(538), "Content Location Code");
    _tagNameMap.put(Integer.valueOf(539), "Content Location Name");
    _tagNameMap.put(Integer.valueOf(542), "Release Date");
    _tagNameMap.put(Integer.valueOf(547), "Release Time");
    _tagNameMap.put(Integer.valueOf(549), "Expiration Date");
    _tagNameMap.put(Integer.valueOf(550), "Expiration Time");
    _tagNameMap.put(Integer.valueOf(552), "Special Instructions");
    _tagNameMap.put(Integer.valueOf(554), "Action Advised");
    _tagNameMap.put(Integer.valueOf(557), "Reference Service");
    _tagNameMap.put(Integer.valueOf(559), "Reference Date");
    _tagNameMap.put(Integer.valueOf(562), "Reference Number");
    _tagNameMap.put(Integer.valueOf(567), "Date Created");
    _tagNameMap.put(Integer.valueOf(572), "Time Created");
    _tagNameMap.put(Integer.valueOf(574), "Digital Date Created");
    _tagNameMap.put(Integer.valueOf(575), "Digital Time Created");
    _tagNameMap.put(Integer.valueOf(577), "Originating Program");
    _tagNameMap.put(Integer.valueOf(582), "Program Version");
    _tagNameMap.put(Integer.valueOf(587), "Object Cycle");
    _tagNameMap.put(Integer.valueOf(592), "By-line");
    _tagNameMap.put(Integer.valueOf(597), "By-line Title");
    _tagNameMap.put(Integer.valueOf(602), "City");
    _tagNameMap.put(Integer.valueOf(604), "Sub-location");
    _tagNameMap.put(Integer.valueOf(607), "Province/State");
    _tagNameMap.put(Integer.valueOf(612), "Country/Primary Location Code");
    _tagNameMap.put(Integer.valueOf(613), "Country/Primary Location Name");
    _tagNameMap.put(Integer.valueOf(615), "Original Transmission Reference");
    _tagNameMap.put(Integer.valueOf(617), "Headline");
    _tagNameMap.put(Integer.valueOf(622), "Credit");
    _tagNameMap.put(Integer.valueOf(627), "Source");
    _tagNameMap.put(Integer.valueOf(628), "Copyright Notice");
    _tagNameMap.put(Integer.valueOf(630), "Contact");
    _tagNameMap.put(Integer.valueOf(632), "Caption/Abstract");
    _tagNameMap.put(Integer.valueOf(633), "Local Caption");
    _tagNameMap.put(Integer.valueOf(634), "Caption Writer/Editor");
    _tagNameMap.put(Integer.valueOf(637), "Rasterized Caption");
    _tagNameMap.put(Integer.valueOf(642), "Image Type");
    _tagNameMap.put(Integer.valueOf(643), "Image Orientation");
    _tagNameMap.put(Integer.valueOf(647), "Language Identifier");
    _tagNameMap.put(Integer.valueOf(662), "Audio Type");
    _tagNameMap.put(Integer.valueOf(663), "Audio Sampling Rate");
    _tagNameMap.put(Integer.valueOf(664), "Audio Sampling Resolution");
    _tagNameMap.put(Integer.valueOf(665), "Audio Duration");
    _tagNameMap.put(Integer.valueOf(666), "Audio Outcue");
    _tagNameMap.put(Integer.valueOf(696), "Job Identifier");
    _tagNameMap.put(Integer.valueOf(697), "Master Document Identifier");
    _tagNameMap.put(Integer.valueOf(698), "Short Document Identifier");
    _tagNameMap.put(Integer.valueOf(699), "Unique Document Identifier");
    _tagNameMap.put(Integer.valueOf(700), "Owner Identifier");
    _tagNameMap.put(Integer.valueOf(712), "Object Data Preview File Format");
    _tagNameMap.put(Integer.valueOf(713), "Object Data Preview File Format Version");
    _tagNameMap.put(Integer.valueOf(714), "Object Data Preview Data");
  }
  
  public IptcDirectory()
  {
    setDescriptor(new IptcDescriptor(this));
  }
  
  private Date getDate(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public Date getDateCreated()
  {
    return null;
  }
  
  public Date getDateSent()
  {
    return null;
  }
  
  public Date getDigitalDateCreated()
  {
    return null;
  }
  
  public Date getExpirationDate()
  {
    return null;
  }
  
  public List<String> getKeywords()
  {
    return null;
  }
  
  public String getName()
  {
    return "IPTC";
  }
  
  public Date getReleaseDate()
  {
    return null;
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\iptc\IptcDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */