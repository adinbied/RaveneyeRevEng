package dji.midware.media.mp4;

public enum MP4BoxType
{
  private String value = "";
  
  static
  {
    mdat = new MP4BoxType("mdat", 2, "mdat");
    moov = new MP4BoxType("moov", 3, "moov");
    mvhd = new MP4BoxType("mvhd", 4, "mvhd");
    udta = new MP4BoxType("udta", 5, "udta");
    trak = new MP4BoxType("trak", 6, "trak");
    tkhd = new MP4BoxType("tkhd", 7, "tkhd");
    edts = new MP4BoxType("edts", 8, "edts");
    mdia = new MP4BoxType("mdia", 9, "mdia");
    mdhd = new MP4BoxType("mdhd", 10, "mdhd");
    hdlr = new MP4BoxType("hdlr", 11, "hdlr");
    minf = new MP4BoxType("minf", 12, "minf");
    vmhd = new MP4BoxType("vmhd", 13, "vmhd");
    dinf = new MP4BoxType("dinf", 14, "dinf");
    stbl = new MP4BoxType("stbl", 15, "stbl");
    stsd = new MP4BoxType("stsd", 16, "stsd");
    avc1 = new MP4BoxType("avc1", 17, "avc1");
    avcC = new MP4BoxType("avcC", 18, "avcC");
    stts = new MP4BoxType("stts", 19, "stts");
    ctts = new MP4BoxType("ctts", 20, "ctts");
    stsc = new MP4BoxType("stsc", 21, "sysc");
    stsz = new MP4BoxType("stsz", 22, "stsz");
    stco = new MP4BoxType("stco", 23, "stco");
    stss = new MP4BoxType("stss", 24, "stss");
    MP4BoxType localMP4BoxType = new MP4BoxType("OTHER", 25, "other");
    OTHER = localMP4BoxType;
    $VALUES = new MP4BoxType[] { ftyp, wide, mdat, moov, mvhd, udta, trak, tkhd, edts, mdia, mdhd, hdlr, minf, vmhd, dinf, stbl, stsd, avc1, avcC, stts, ctts, stsc, stsz, stco, stss, localMP4BoxType };
  }
  
  private MP4BoxType(String paramString)
  {
    this.value = paramString;
  }
  
  public static MP4BoxType find(String paramString)
  {
    MP4BoxType localMP4BoxType = OTHER;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramString)) {
        return values()[i];
      }
      i += 1;
    }
    return localMP4BoxType;
  }
  
  public boolean _equals(String paramString)
  {
    return this.value.equals(paramString);
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\mp4\MP4BoxType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */