


#include "stdafx.h"
#include <stdint.h>
#include <stdlib.h>
#include "FreeImage.h"
#include <string>
#include "lzw.hh"
#include <map>
#include <direct.h>
//! Byte swap unsigned short
#include "common.h"
#include "pathext.h"

bool WriteToImage( int& bit, unsigned short*& loc, short& data )
{
   if ( bit == 4 ) {
      short d2;
      d2 = swap_int16( data );
      *loc = d2;

      data = 0;
      bit = 0;
      loc++;
      return 1;
   }

   return 0;
}

void ReadFrameInfo( sHeader& h, FILE*& fp )
{
   fread( &h.unk, sizeof( short ), 1, fp );
   h.unk = swap_int16( h.unk );
   printf( "frames: %d depth?:%d\n", h.frames, h.unk );
   sFrame sf;

   for ( int f = 0; f < h.frames; f++ ) {
      fread( &sf.width, sizeof( short ), 1, fp );
      fread( &sf.height, sizeof( short ), 1, fp );
      fread( &sf.flags, sizeof( short ), 1, fp );
      sf.width = swap_int16( sf.width );	
      sf.height = swap_int16( sf.height );
      sf.flags = swap_int16( sf.flags );
      printf( "\tFrame: %d: %d,%d:%d\n", f, sf.width, sf.height, sf.flags );
      h.vFrames.push_back( sf );
   }
}

void ReadPalette( sHeader& h, FILE*& fp, char* name )
{
   FIBITMAP* dib = nullptr;
   dib = FreeImage_Allocate( 32, 32, 32 );

   for ( int i = 0; i < 32; i++ ) {
      fread( &h.pal[i], 2, 1, fp );
      //printf( "COL: %d %02d %02d %02d %X%X%X\n", i, h.pal[i].red, h.pal[i].green, h.pal[i].blue, h.pal[i].red, h.pal[i].green, h.pal[i].blue );
      RGBQUAD RGB;
      RGB.rgbRed = h.pal[i].red << 4;
      RGB.rgbGreen = h.pal[i].green << 4;
      RGB.rgbBlue = h.pal[i].blue << 4;

      //rgb = ( h.pal[colorIndex].red << 2 )
      for ( int x = 0; x < 32; x++ )
      { FreeImage_SetPixelColor( dib, x, i, &RGB ); }
   }

   char str[256];
   sprintf( str, "%s\\pal.bmp", name );
   FreeImage_FlipVertical( dib );
   FreeImage_Save( FIF_BMP, dib, str );
   FreeImage_Unload( dib );
}

void ReadFrame( sHeader& h, int f, FILE*& fp, char* name )
{
   FIBITMAP* dib = nullptr;
   h.width = h.vFrames[f].width;
   h.height = h.vFrames[f].height;
   unsigned char* bitmap = ( unsigned char* ) malloc( h.width * h.height * 5 );
   unsigned short* loc = ( unsigned short* )bitmap;
   dib = FreeImage_Allocate( h.width, h.height, 32 );
   std::map<unsigned char, int> lzw;
   std::vector<unsigned char> decoded;
   int x = 0;
   int y = 0;
   int bit = 0;
   short data = 0;
   uint8_t d;
   signed short times;
   int ds = 0;
   int rASSIZE = RASSIZE( h.width, h.height );
   int fSize = 0;

   while ( fSize < ( 2.5 * rASSIZE )/*!feof( fp )*/ ) {

      unsigned char p;

      //memcpy( &p, &c[i], sizeof( pixel ) );
      fread( &p, 1, 1, fp );
      //unsigned char cmd = p >> 4;
      //printf( "CMD: 0x%02x \n", p );
      uint8_t cmd = p & 0xF0;

      if ( cmd == 0x00 ) {
         ProcessFill( d, p, times );
      } else if ( cmd == 0xF0 ) {
         ProcessFill( d, p, times );
      } else
      { times = 0xFF; }

      if ( times == 0xff ) {
         d = p;
         uint8_t db = d >> 4;
         data = data << 4;
         data |= db;
         bit++;

         if ( WriteToImage( bit, loc, data ) ) {
            fSize ++;
         }

         db = d & 0x0f;

         data = data << 4;
         data |= db;
         bit++;

         if ( WriteToImage( bit, loc, data ) ) {
            fSize ++;
         }


      } else {
         while ( --times >= 0 ) {



            data = data << 4;
            data |= d;
            bit++;

            if ( WriteToImage( bit, loc, data ) ) {
               fSize ++;
            }

         }
      }

      /*if ( cmd == 0x0 ) {
      times = p & 0x0F;
      times++;
      d = 0x0;
      ds = 1;
      printf( "fill 0's %d Times\n", times );

      } else if ( cmd == 0xF ) {
      times = p & 0x0F;
      times++;
      d = 0xF;
      ds = 1;
      printf( "fill 1's %d Times\n", times );

      } else {
      times = 2;
      d = p;
      ds = 1;
      printf( "Copy Data, %02x\n", d );
      }

      while ( times > 0 ) {
      AppendData( data, d, bit, loc, ds );
      times--;
      }*/
   }



   for ( int i = 0; i < 5; i++ ) {

      h.Planes[i] = ( PLANEPTR )malloc( rASSIZE );
   }

   uint8_t* read_ptr;
   read_ptr = ( uint8_t* )bitmap;

   for ( int i = 0; i < 5; i++, read_ptr += ( rASSIZE ) ) {
      memcpy( ( uint8_t* )h.Planes[i], ( void* )read_ptr, rASSIZE );
      /*uint8_t* start = read_ptr;
      uint8_t* dest = h.Planes[i];

      for ( int y = 0; y < h.height; y++ ) {
      memcpy( ( uint8_t* )dest, ( void* )start, ( ( h.width )  + 15 ) >> 3 & 0xFFFE );
      dest += ( ( h.width ) + 15 ) >> 3 & 0xFFFE;
      start += ( ( h.width ) ) >> 3 & 0xFFFE;

      }*/
   }

   for ( int y = 0; y < h.height; y++ )
      for ( int x = 0; x < h.width; x++ ) {
         //unsigned char bitPlanes[5][8000];

         int bytePos = x / 8 + y * ( ( ( h.width ) + 15 ) >> 3 & 0xFFFE );
         int bitPos = 7 - x & 7;
         unsigned char colorIndex = ( ( !!( h.Planes[0][bytePos] & ( 1 << bitPos ) ) ) << 0 ) |
                                    ( ( !!( h.Planes[1][bytePos] & ( 1 << bitPos ) ) ) << 1 ) |
                                    ( ( !!( h.Planes[2][bytePos] & ( 1 << bitPos ) ) ) << 2 ) |
                                    ( ( !!( h.Planes[3][bytePos] & ( 1 << bitPos ) ) ) << 3 ) |
                                    ( ( !!( h.Planes[4][bytePos] & ( 1 << bitPos ) ) ) << 4 );
         //unsigned short paletteValue = palette[colorIndex];
         RGBQUAD rgb;
         rgb.rgbRed = h.pal[colorIndex].red << 4;
         rgb.rgbGreen = h.pal[colorIndex].green << 4;
         rgb.rgbBlue = h.pal[colorIndex].blue << 4;
         FreeImage_SetPixelColor( dib, x, y, &rgb );
      }

   char str[256];
   sprintf( str, "%s\\%d.bmp", name, f );
   FreeImage_FlipVertical( dib );
   FreeImage_Save( FIF_BMP, dib, str );
   FreeImage_Unload( dib );
}

struct sMaze {
   int size;
   BYTE* data;
   BYTE mapData[256];
   BYTE colData[256];
};

std::vector<sMaze*> vecMazes;

void ReadLevelData( short size, FILE*& fp, int offset )
{
   sMaze* s = new sMaze();
   s->data = new BYTE[size];
   s->size = size;
   int curLoc = ftell( fp );
   fseek( fp, offset, SEEK_SET );
   fread( s->data, size, 1, fp );
   fseek( fp, curLoc, SEEK_SET );

   vecMazes.push_back( s );
}

void processMaze( const sMaze* pMaze )
{
   for ( int i = 0; i < pMaze->size; ++i ) {
      printf( "0x%02x ", pMaze->data[i] );
   }

   for ( int i = 0; i < pMaze->size; ++i ) {
      printf( "%c", pMaze->data[i] );
   }

   printf( "\n\n" );
}

void DrawMapdata( BYTE walldata, FIBITMAP* dib, int offset, int x, int y )
{
   RGBQUAD rgb;
   rgb.rgbRed = rgb.rgbGreen = rgb.rgbBlue = 0;

   if ( walldata & 0x03 ) {
      BYTE _walldata = walldata & 0x03;

      for ( int a = 0; a < 16; a++ ) {
         if ( _walldata == 0x01 ) {
            rgb.rgbRed =  255;
         } else if ( _walldata == 0x02 ) {
            rgb.rgbBlue =  255;
         } else if ( _walldata == 0x03 ) {
            rgb.rgbGreen =  255;
         }

         FreeImage_SetPixelColor( dib, offset + ( x * 16 ), a + ( y * 16 ), &rgb );
      }
   }

   rgb.rgbRed = rgb.rgbGreen = rgb.rgbBlue = 0;

   if ( walldata & 0x0c ) {
      BYTE _walldata = ( walldata >> 2 ) & 0x03;

      for ( int a = 0; a < 16; a++ ) {
         if ( _walldata == 0x01 ) {
            rgb.rgbRed =  255;
         } else if ( _walldata == 0x02 ) {
            rgb.rgbBlue =  255;
         } else if ( _walldata == 0x03 ) {
            rgb.rgbGreen =  255;
         }

         for ( int a = 0; a < 16; a++ ) {
            FreeImage_SetPixelColor( dib, offset + a + ( x * 16 ), 15 + ( y * 16 ), &rgb );
         }
      }

   }

   rgb.rgbRed = rgb.rgbGreen = rgb.rgbBlue = 0;

   if ( walldata & 0x30 ) {
      BYTE _walldata = ( walldata >> 4 ) & 0x03;

      for ( int a = 0; a < 16; a++ ) {
         if ( _walldata == 0x01 ) {
            rgb.rgbRed =  255;
         } else if ( _walldata == 0x02 ) {
            rgb.rgbBlue =  255;
         } else if ( _walldata == 0x03 ) {
            rgb.rgbGreen =  255;
         }

         FreeImage_SetPixelColor( dib, offset + 15 + ( x * 16 ), a + ( y * 16 ), &rgb );
      }
   }

   rgb.rgbRed = rgb.rgbGreen = rgb.rgbBlue = 0;

   if ( walldata & 0xc0 ) {
      BYTE _walldata = ( walldata >> 6 ) & 0x03;

      for ( int a = 0; a < 16; a++ ) {
         if ( _walldata == 0x01 ) {
            rgb.rgbRed =  255;
         } else if ( _walldata == 0x02 ) {
            rgb.rgbBlue =  255;
         } else if ( _walldata == 0x03 ) {
            rgb.rgbGreen =  255;
         }

         FreeImage_SetPixelColor( dib, offset + a + ( x * 16 ), ( y * 16 ), &rgb );
      }
   }
}

struct sMonster {
   char name[15];
   unsigned short HP;
   unsigned short EXP;
   BYTE AC;
   BYTE Abilities[3];
   BYTE Ability[2];
   int Experience;
   int gold;
   int gems;
   int MagicRes;
   //int Damage[2];
   BYTE Damage;
   BYTE Picture;
   bool Undead;
   bool Flee;
   int speed;
   char other[10];
};
void loadMonsters( FILE*& fp, const char* name )
{
   fp = fopen( name, "rb" );

   if ( fp == nullptr ) { return; }

   fseek( fp, 0, SEEK_END );
   int fsize = ftell( fp );
   int mons = fsize / 26;
   fseek( fp, 0, SEEK_SET );

   sMonster* pMon;

   for ( int m = 0; m < mons; m++ ) {
      pMon = new sMonster();
      pMon->name[14] = 0;
      fread( pMon->name, 14, 1, fp );


      for ( int c = 0; c < 14; c++ ) {
         pMon->name[c] -= 0x80;
      }

	  BYTE hpTemp;
      fread( &hpTemp, 1, 1, fp );

	  if (hpTemp < 71)
	  {
		  pMon->HP = hpTemp + 1;
	  }
	  else if (hpTemp > 70 && hpTemp < 134)
	  {
		  pMon->HP = 70 + ((hpTemp - 70) * 10);
	  }
	  else if (hpTemp > 133 && hpTemp < 178)
	  {
		  pMon->HP = 700 + ((hpTemp - 134) * 100);
	  }
	  else
	  {
		  pMon->HP = 64000 - (255 - hpTemp) * 1000;
	  }

	  //fseek( fp, 10, SEEK_CUR );
      //pMon->HP = swap_int16( pMon->HP );

	  BYTE tempExp;
	  fread(&tempExp, 1, 1, fp);
	  pMon->Experience = tempExp;
	  fread(&pMon->gold, 1, 1, fp);
	  fread(&pMon->Abilities, 1, 3, fp); 
	  fread(&pMon->speed, 1, 1, fp);
	  fread(&pMon->Picture, 1, 1, fp);
      fread( &pMon->AC, 1, 1, fp );
	  fread(&pMon->Damage, 1, 1, fp);
	  fread(&pMon->other[0], 1, 1, fp);
	  fread(&pMon->MagicRes, 1, 1, fp);
	  if (pMon->Picture > 128)
	  {
		  pMon->Picture = -128 + pMon->Picture;
	  }
      printf( "%s AC: %d", pMon->name, pMon->AC );
      printf( " HP:%d %d %d",pMon->HP, pMon->Damage, pMon->Picture );
      printf( "\n\t" );
	  printf("%d, %d, $d", pMon->Abilities[0], pMon->Abilities[1], pMon->Abilities[2]);
	  printf("\n");


   }

 }

void loadMap( FILE*& fp, const char* name )
{
   fp = fopen( name, "rb" );
   mkdir( remove_ext( ( char* )name, '.', '/' ) );

   if ( fp == nullptr ) { return; }

   fseek( fp, 0, SEEK_END );
   int fsize = ftell( fp );
   int maps = fsize / 512.f;
   fseek( fp, 0, SEEK_SET );

   // each map is 512bytes in size.
   // broken into a mapdata, and col data.
   for ( int i = 0; i < maps; i++ ) {
      fread( vecMazes[i]->mapData, 256, 1, fp );
      fread( vecMazes[i]->colData, 256, 1, fp );

      FIBITMAP* dib = nullptr;
      dib = FreeImage_Allocate( 512, 256, 32 );


      for ( int y = 0; y <= 15; y++ ) {

         for ( int x = 0; x <= 15; x++ ) {

            BYTE walldata = vecMazes[i]->mapData[x + 16 * ( 15 - y )];

            DrawMapdata( walldata, dib, 0, x, y );
            walldata = vecMazes[i]->colData[x + 16 * ( 15 - y )];

            DrawMapdata( walldata, dib, 256, x, y );

         }
      }

      char str[256];
      sprintf( str, "%s\\map_%d.bmp", remove_ext( ( char* )name, '.', '/' ), i );
      FreeImage_FlipVertical( dib );
      FreeImage_Save( FIF_BMP, dib, str );
      FreeImage_Unload( dib );
   }

}

void loadEvent( FILE*& fp, const char* name )
{
   fp = fopen( name, "rb" );

   if ( fp == nullptr ) { return; }

   fseek( fp, 0, SEEK_SET );

   BYTE b;
   int offset;
   short  size;

   fread( &offset, sizeof( int ), 1, fp );
   fread( &size, sizeof( short ), 1, fp );
   offset = swap_int32( offset );
   size = swap_int16( size );

   int foff = offset;
   ReadLevelData( size, fp, offset );
   int index = 0;
   //printf( "%d:%04x %02x\n", index, offset, size );

   while ( ftell( fp ) != foff ) {
      index++;

      fread( &offset, sizeof( int ), 1, fp );
      fread( &size, sizeof( short ), 1, fp );

      offset = swap_int32( offset );
      size = swap_int16( size );
      ReadLevelData( size, fp, offset );

      printf( "%d:%04x %02x\n", index, offset, size );
   }

   fclose( fp );

   /*
   for ( auto pMaze : vecMazes ) {
      processMaze( pMaze );

   }
   */

}


void LoadImage32( FILE*& fp, const char* cname, unsigned char*& c )
{
   sHeader h;

   char* name = remove_ext( ( char* )cname, '.', '/' );
   mkdir( name );
   fp = fopen( cname, "rb" );

   if ( fp == nullptr ) { return; }

   fseek( fp, 0, SEEK_END );

   long size = ftell( fp );
   fseek( fp, 0, SEEK_SET );
   // c = new unsigned char[size * 200];
   // memset( c, 0, size * 200 );

   //fread( c, 1, size, fp );

   //memcpy( &h, c, sizeof( header ) );
   printf( "\n\n\n%s\n", name );
   fread( &h.frames, sizeof( short ), 1, fp );
   h.frames = swap_int16( h.frames );

   if ( h.frames == 0 ) {
      fseek( fp, 0, SEEK_SET );
      BYTE* animHeader = new BYTE[32];
      fread( animHeader, 1, 32, fp );
      BYTE pSkip;

      while ( !feof( fp ) ) {
         fread( &pSkip, 1, 1, fp );
         int imgStart = ftell( fp );

         if ( pSkip == 0xFF ) {

            BYTE pNext;
            fread( &pNext, 1, 1, fp );

            if ( pNext == 0x00 ) {
               
               // Validate size for false positives.
               fseek( fp, imgStart + 4, SEEK_SET );
               short width, height;
               fread( &width, sizeof( short ), 1, fp );
               fread( &height, sizeof( short ), 1, fp );
               width = swap_int16( width );
               height = swap_int16( height );

               if ( width != 0x54 && height != 0x55 ) {
                  fseek( fp, imgStart, SEEK_SET );
                  continue;

               }

               fseek( fp, imgStart, SEEK_SET );
               fread( &h.frames, sizeof( short ), 1, fp );
               h.frames = swap_int16( h.frames );
               ReadFrameInfo( h, fp );
               break;
            }
         }
      }

      if ( feof( fp ) )
      { return; }
   } else {
      ReadFrameInfo( h, fp );
   }

   //fseek( fp, 2 * sizeof( short ) + ( h.frames * 3 * sizeof( short ) ), SEEK_SET );
   //printf( "a: %d b:%d c:%d d:%d\n", h.a, h.b, h.c, h.d );

   ReadPalette( h, fp, name );





   for ( int f = 0; f < h.frames; f++ ) {
      ReadFrame( h, f, fp, name );

   }

}


int _tmain( int argc, _TCHAR* argv[] )
{
   unsigned char* c, *d;
   FILE* fp, *fo;
   loadMonsters( fp, "E:/amiga/_MM2_/monsters.dat" );
   loadEvent( fp, "E:/amiga/_MM2_/event.dat" );
   loadMap( fp, "E:/amiga/_MM2_/map.dat" );
   loadMap( fp, "E:/amiga/_MM2_/MAZEDATA.dta" );
   return 0;
   LoadImage32( fp, "E:/amiga/_MM2_/nwcp.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/outb.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/throw.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/sky.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/introclips.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/intro.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/endgame.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/book.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/tundra.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/swamp.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/ocean.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/desert.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/outf.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/outdoor3.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/outdoor2.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/outdoor1.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/castlet.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/castlef.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/castle.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/cavet.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/cavef.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/cave.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/townt.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/townf.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/townb.32", c );
   LoadImage32( fp, "E:/amiga/_MM2_/town.32", c );;

   for ( int i = 1; i < 75; i++ ) {
      char str[256];
      sprintf( str, "E:\\amiga\\_MM2_\\%02d.anm", i );
      LoadImage32( fp, str, c );
   }

   return 0;
}

