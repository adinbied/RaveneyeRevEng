package dji.midware.media.mp4;

public class MP4MovieBox
  extends MP4Box
{
  public Movie_Header_Box mvhd = new Movie_Header_Box();
  public Track_Box trak = new Track_Box();
  public User_Data_Box udta = new User_Data_Box();
  
  public boolean parseData(byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public class Movie_Header_Box
    extends MP4Box
  {
    public int create_time;
    public int duration;
    public byte[] flags = new byte[3];
    public final int length = 108;
    public byte[] matrix = new byte[36];
    public int modification_time;
    public int next_track_id;
    public byte[] pre_defined = new byte[24];
    public double rate;
    public byte[] reserved = new byte[10];
    public int time_scale;
    public final MP4BoxType type = MP4BoxType.mvhd;
    public byte version;
    public short volume;
    
    public Movie_Header_Box() {}
    
    public boolean parseData(byte[] paramArrayOfByte, int paramInt)
    {
      return false;
    }
  }
  
  public class Track_Box
    extends MP4Box
  {
    public MP4Box edts = new MP4Box(MP4BoxType.edts, 36);
    public Media_Box mdia = new Media_Box();
    public Track_Header_Box tkhd = new Track_Header_Box();
    public final MP4BoxType type = MP4BoxType.trak;
    
    public Track_Box() {}
    
    public boolean parseData(byte[] paramArrayOfByte, int paramInt)
    {
      return false;
    }
    
    public class Media_Box
      extends MP4Box
    {
      public MP4Box hdlr = new MP4Box(MP4BoxType.hdlr, 49);
      public MP4Box mdhd = new MP4Box(MP4BoxType.mdhd, 32);
      public Media_Information_Box minf = new Media_Information_Box();
      public final MP4BoxType type = MP4BoxType.mdia;
      
      public Media_Box() {}
      
      public boolean parseData(byte[] paramArrayOfByte, int paramInt)
      {
        return false;
      }
      
      public class Media_Information_Box
        extends MP4Box
      {
        public MP4Box dinf = new MP4Box(MP4BoxType.dinf, 36);
        public Sample_Table_Box stbl = new Sample_Table_Box();
        public final MP4BoxType type = MP4BoxType.minf;
        public MP4Box vmhd = new MP4Box(MP4BoxType.vmhd, 20);
        
        public Media_Information_Box() {}
        
        public boolean parseData(byte[] paramArrayOfByte, int paramInt)
        {
          return false;
        }
        
        public class Sample_Table_Box
          extends MP4Box
        {
          public MP4Box ctts = new MP4Box();
          public Chunk_Offset_Box stco = new Chunk_Offset_Box();
          public MP4Box stsc = new MP4Box();
          public Sample_Description_Box stsd = new Sample_Description_Box();
          public Sync_Sample_Box stss = new Sync_Sample_Box();
          public Sample_Size_Box stsz = new Sample_Size_Box();
          public MP4Box stts = new MP4Box();
          public final MP4BoxType type = MP4BoxType.stbl;
          
          public Sample_Table_Box() {}
          
          public boolean parseData(byte[] paramArrayOfByte, int paramInt)
          {
            return false;
          }
          
          public class Chunk_Offset_Box
            extends MP4Box
          {
            public int[] chunk_offset_list;
            public int entry_count;
            public byte[] flags = new byte[3];
            public final MP4BoxType type = MP4BoxType.stco;
            public byte version;
            
            public Chunk_Offset_Box() {}
            
            public boolean parseData(byte[] paramArrayOfByte, int paramInt)
            {
              return false;
            }
          }
          
          public class Sample_Description_Box
            extends MP4Box
          {
            public AVC_Sample_Entrty avc1 = new AVC_Sample_Entrty();
            public byte[] flags = new byte[3];
            public int reserved;
            public final MP4BoxType type = MP4BoxType.stsd;
            public byte version;
            
            public Sample_Description_Box() {}
            
            public boolean parseData(byte[] paramArrayOfByte, int paramInt)
            {
              return false;
            }
            
            public class AVC_Sample_Entrty
              extends MP4Box
            {
              public AVC_Decoder_Configuration_Record avcC = new AVC_Decoder_Configuration_Record();
              public int height;
              public int horiz_resolution;
              public final MP4BoxType type = MP4BoxType.avc1;
              public int ver_resolution;
              public int width;
              
              public AVC_Sample_Entrty() {}
              
              public boolean parseData(byte[] paramArrayOfByte, int paramInt)
              {
                return false;
              }
              
              public class AVC_Decoder_Configuration_Record
                extends MP4Box
              {
                public byte[] pps = new byte[4];
                public byte[] sps;
                public final MP4BoxType type = MP4BoxType.avcC;
                
                public AVC_Decoder_Configuration_Record() {}
                
                public boolean parseData(byte[] paramArrayOfByte, int paramInt)
                {
                  return false;
                }
              }
            }
          }
          
          public class Sample_Size_Box
            extends MP4Box
          {
            public byte[] flags = new byte[3];
            public int sample_count;
            public int sample_size;
            public int[] sample_size_list;
            public final MP4BoxType type = MP4BoxType.stsz;
            public byte version;
            
            public Sample_Size_Box() {}
            
            public boolean parseData(byte[] paramArrayOfByte, int paramInt)
            {
              return false;
            }
          }
          
          public class Sync_Sample_Box
            extends MP4Box
          {
            public int entry_count;
            public byte[] flags = new byte[3];
            public int[] iframe_sample_number;
            public final MP4BoxType type = MP4BoxType.stss;
            public byte version;
            
            public Sync_Sample_Box() {}
            
            public boolean parseData(byte[] paramArrayOfByte, int paramInt)
            {
              return false;
            }
          }
        }
      }
    }
    
    public class Track_Header_Box
      extends MP4Box
    {
      public short alternate_group = 0;
      public int create_time;
      public int duration;
      public byte[] flags = new byte[3];
      public int height;
      public short layer;
      public final int length = 92;
      public byte[] matrix = new byte[36];
      public int modification_time;
      public int reserved;
      public byte[] reserved_2 = new byte[8];
      public short reserved_3;
      public int track_id;
      public final MP4BoxType type = MP4BoxType.tkhd;
      public byte version;
      public short volume;
      public int width;
      
      public Track_Header_Box() {}
      
      public boolean parseData(byte[] paramArrayOfByte, int paramInt)
      {
        return false;
      }
    }
  }
  
  public class User_Data_Box
    extends MP4Box
  {
    public final int length = 2048;
    public final MP4BoxType type = MP4BoxType.udta;
    
    public User_Data_Box() {}
    
    public boolean parseData(byte[] paramArrayOfByte, int paramInt)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\mp4\MP4MovieBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */