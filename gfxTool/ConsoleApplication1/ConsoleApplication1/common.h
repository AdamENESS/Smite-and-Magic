#pragma once

#define IS_EVEN(x) (x%2?false:true)
#define IS_ODD(x) (x%2?true:false)

uint16_t swap_uint16( uint16_t val )
{
   return ( val << 8 ) | ( val >> 8 );
}

//! Byte swap short
int16_t swap_int16( int16_t val )
{
   return ( val << 8 ) | ( ( val >> 8 ) & 0xFF );
}

//! Byte swap unsigned int
uint32_t swap_uint32( uint32_t val )
{
   val = ( ( val << 8 ) & 0xFF00FF00 ) | ( ( val >> 8 ) & 0xFF00FF );
   return ( val << 16 ) | ( val >> 16 );
}

//! Byte swap int
int32_t swap_int32( int32_t val )
{
   val = ( ( val << 8 ) & 0xFF00FF00 ) | ( ( val >> 8 ) & 0xFF00FF );
   return ( val << 16 ) | ( ( val >> 16 ) & 0xFFFF );
}
#define BYTE4_TO_BINARY_PATTERN "%c%c%c%c"
#define BYTE4_TO_BINARY(byte)  \
   (byte & 0x08 ? '1' : '0'), \
   (byte & 0x04 ? '1' : '0'), \
   (byte & 0x02 ? '1' : '0'), \
   (byte & 0x01 ? '1' : '0')

#define BYTE_TO_BINARY_PATTERN "%c%c%c%c%c%c%c%c"
#define BYTE_TO_BINARY(byte)  \
   (byte & 0x80 ? '1' : '0'), \
   (byte & 0x40 ? '1' : '0'), \
   (byte & 0x20 ? '1' : '0'), \
   (byte & 0x10 ? '1' : '0'), \
   (byte & 0x08 ? '1' : '0'), \
   (byte & 0x04 ? '1' : '0'), \
   (byte & 0x02 ? '1' : '0'), \
   (byte & 0x01 ? '1' : '0')


typedef struct {

   unsigned red : 4, pad: 4, blue: 4, green : 4;
   // unsigned short a, b;


} Color4;                      /*   Amiga RAM format.  Not filed.  */

typedef struct {

   unsigned stride: 4, colour: 4;

} pixel;

typedef struct {
   unsigned char red, pad1, blue, green ;
} Color4a;                      /*   Amiga RAM format.  Not filed.  */

typedef unsigned char* PLANEPTR;
struct sFrame {
   unsigned short width;
   unsigned short height;
   unsigned short flags;
};
struct sHeader {
   unsigned short frames;
   unsigned short unk;
   unsigned short width;
   unsigned short height;
   unsigned short unk2;

   std::vector< sFrame> vFrames;
   //short a, b, c, d;
   Color4 pal[32];

   PLANEPTR Planes[5];

};


bool unpackRow( FILE* file, unsigned char* bitlinebuf, int32_t bytesNeeded )
{
   bool success = TRUE;

   while ( bytesNeeded > 0 ) {
      /*gint  ch = fgetc( file );*/
      int8_t  ch = fgetc( file );

      if ( EOF == ch ) {
         //printf( "Got EOF while decrunching!\n" );
         return 0;
      }

      ch = ( int8_t ) ch;

      if ( ch >= 0 ) {
         int  skip = 0;

         ++ch;

         if ( ch > bytesNeeded ) {
            skip = ch - bytesNeeded;
            //printf( "Bad compr.: %u byte(s) too much in row. Skipping.\n", skip );
            ch = bytesNeeded;
            success = 0;
         }

         if ( fread( bitlinebuf, ch, 1, file ) != 1 ) {
            //printf( "Error reading compressed data, image might look confused.\n" );
            success = 0;
         }

         if ( skip ) {
            if ( fseek( file, skip, SEEK_CUR ) ) {
               //printf( "Error skipping extraneous bytes in stream.\n" );
               success = 0;
            }
         }

         bitlinebuf += ch;
         bytesNeeded -= ch;
      } else if ( ch != -128 ) {
         int32_t val;
         ch = -ch + 1;
         val = fgetc( file );

         if ( EOF == val ) {
            //printf( "Got EOF while decrunching!\n" );

            return FALSE;
         } else {
            if ( ch > bytesNeeded ) {
               //printf( "Bad compr.: %u byte(s) too much in row.\n", ch - bytesNeeded );
               ch = bytesNeeded;
               success = 0;
            }

            memset( bitlinebuf, val, ch );
            bitlinebuf += ch;
         }

         bytesNeeded -= ch;
      } else {
         /*fputs("unpackRow: Got -128!\n", stderr); */
         /* Amiga inc. says that -128 is "NOP". */
      }
   }

   if ( bytesNeeded < 0 )
   { success = 0; }

   return success;
}

#define  FFMAX(a, b)   ((a) > (b) ? (a) : (b))
#define  FFMAX3(a, b, c)   FFMAX(FFMAX(a,b),c)
#define  FFMIN(a, b)   ((a) > (b) ? (b) : (a))
#define  FFMIN3(a, b, c)   FFMIN(FFMIN(a,b),c)

static int decode_byterun( uint8_t* dst, int dst_size,
                           const uint8_t* buf, const uint8_t* const buf_end )
{
   const uint8_t* const buf_start = buf;
   unsigned x;

   for ( x = 0; x < dst_size && buf < buf_end; ) {
      unsigned length;
      const int8_t value = *buf++;

      if ( value >= 0 ) {
         length = value + 1;
         memcpy( dst + x, buf, FFMIN3( length, dst_size - x, buf_end - buf ) );
         buf += length;
      } else if ( value > -128 ) {
         length = -value + 1;
         memset( dst + x, *buf++, FFMIN( length, dst_size - x ) );
      } else { // noop
         continue;
      }

      x += length;
   }

   return buf - buf_start;
}


#define RASSIZE(w,h) ((h)*( ((w)+15)>>3&0xFFFE))

void WRFD( int& cpixel, sHeader& h, int& y, int& plane, bool& b, int& offset )
{
   if ( cpixel >= h.width ) {
      cpixel -= h.width;

      y++;
      printf( "\n" );

      if ( y > h.height ) {
         plane++;
         y = 0;
         printf( "NEW PLANE: %d\n", plane );
      }
   }


   //h.Planes[plane][offset] = p.colour << ( IS_ODD( b ) ? 4 : 0 );



   if ( IS_ODD( b ) )
   { offset++; }

   b = !b;




   /*int y = offset / h.width;
   int  x = offset - ( y * h.width );

   if ( x < h.width )
   {  };

   RGBQUAD RGB;

   RGB.rgbRed = h.pal[p.colour].red << 4;

   RGB.rgbGreen = h.pal[p.colour].green << 4;

   RGB.rgbBlue = h.pal[p.colour].blue << 4;

   FreeImage_SetPixelColor( dib, x, y, &RGB );*/

   //printf( "X:%d Y:%d\n", x, y );
}


void IncAndCheck( int& x, sHeader& h, int& y )
{
   x++;

   if ( x >= h.width ) {
      printf( "\n" );
      x = 0;
      y++;
   }


}

void AppendData( short& data, uint8_t& d, int& bit, unsigned short*& loc, short datasize )
{
   data = data << 4;
   data |= ( d & 0xF0 ) >> 4;
   d = d << 4;
   bit += datasize;

   if ( bit == 4 ) {
      /*short sd = swap_int16( data );
      *loc = 0;
      *loc |= ( sd & 0xFF );
      sd = sd << 8;
      *loc |= ( sd & 0xFF );*/
      *loc = data;
      data = 0;
      bit = 0;
      loc++;
   }
}

void ProcessFill( uint8_t& d, unsigned char p, signed short& times )
{
   d = p & 0xF0;
   d = d >> 4;
   times = p & 0xF;
   times++;
}


uint16_t
crunch1_get_command( const uint8_t* data,
                     uint16_t    n,
                     uint8_t     command_size )
{
   uint16_t mem, cmd, mask, pos;
   uint8_t shift, rshift;

   pos = n * command_size / 8;
   shift = n * command_size % 8;
   mask = 0xFFFF << ( 16 - command_size );

   mem = swap_int16( *( ( uint16_t* )( data + pos ) ) );

   if ( ( command_size + shift ) <= 16 ) {
      rshift = 16 - command_size - shift;
      cmd = ( mem & ( mask >> shift ) ) >> rshift;
   } else {
      rshift = 24 - command_size - shift;
      cmd = ( mem & ( mask >> shift ) );
      mem = *( ( uint8_t* )( data + pos + 2 ) );
      cmd = ( cmd << ( 8 - rshift ) ) | ( mem >> rshift );
   }

   return cmd;
}

void
crunch1_command( const uint8_t*  data,
                 uint8_t**    buffer,
                 uint16_t     command,
                 uint8_t      command_size,
                 bool         jump )
{
   if ( command & 0xFF00 ) {
      uint16_t index = command - 0x100;
      uint16_t new_cmd = crunch1_get_command( data, index, command_size );
      crunch1_command( data, buffer, new_cmd, command_size, jump );

      if ( jump ) {
         new_cmd = crunch1_get_command( data, index + 1, command_size );
         crunch1_command( data, buffer, new_cmd, command_size, false );
      }
   } else {
      **buffer = command & 0xFF;
      ( *buffer )++;
   }
}



void
crunch1( const uint8_t* data,
         void*       buffer,
         uint8_t     command_size )
{
   uint8_t* dst;
   uint16_t cmd, n_cmd, stop;

   if ( !data || !buffer )
   { return; }

   n_cmd = 0;
   stop = 0xFFFF >> ( 16 - command_size );
   dst = ( uint8_t* ) buffer;

   cmd = crunch1_get_command( data, n_cmd++, command_size );

   while ( cmd != stop ) {
      crunch1_command( data, &dst, cmd, command_size, true );
      cmd = crunch1_get_command( data, n_cmd++, command_size );
   }
}