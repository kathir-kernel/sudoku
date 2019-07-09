#include <stdio.h>

typedef enum
{
	ROW_SIZE = 9,
	COLUMN_SIZE = 9
}E_sudokuTableSize;

typedef signed char sint8;
typedef unsigned char uint8;
typedef signed char* psint8;
typedef signed int sint32;
typedef unsigned int uint32;

sint32 data[ROW_SIZE][COLUMN_SIZE] = {0};

void getInputData( void );
void printData( void );
void createTable( uint8 row, uint8 column );
sint8 convertCharToVal( psint8 val );

void main( sint32 argc, psint8 argV[] )
{
	uint8 rowSize = 0;
	uint8 columnSize = 0;

	printf( "Welcome to SUDOKU program\n" );

	rowSize = convertCharToVal( argV[1] );
	columnSize = convertCharToVal( argV[2] );

//	createTable( ROW_SIZE, COLUMN_SIZE );
	createTable( rowSize, columnSize );

//	createTable( argV[1], argV[2] );

	for( uint8 i = 0; i < argc; i++ )
	{
		printf("argV[%d] = %s\n",i, argV[i]);
	}
	//getInputData();
	//printData();

}

sint8 convertCharToVal( psint8 val )
{
	sint8 retVal = 0;
	uint8 index = 0;

	while ( val[index] != '\0' )
	{
		retVal = ( val[ index ] - '0' );
		index++;
	}

	return retVal;
}

void createTable( uint8 rowSize, uint8 columnSize )
{
	for ( uint8 rowIndex = 0; rowIndex < rowSize; rowIndex++ )
	{
		printf( " _ " );
	}
	printf("\n");
	for( uint8 rowIndex = 0; rowIndex < rowSize; rowIndex++ )
	{
		for( uint8 columnIndex = 0; columnIndex < columnSize; columnIndex++ )
		{
			printf( "|_|" );
		}
		printf( "\n" );
	}
	printf("\n%d x %d Table Created\n", rowSize, columnSize);
}


void getInputData( void )
{
	printf( "Feed SUDOKU data\n" );
        
	for( uint8 rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++ )
        {
           for ( uint8 columnIndex = 0; columnIndex < COLUMN_SIZE; columnIndex++ )
           {
              scanf( "%d", & data[ rowIndex ][ columnIndex ] );
           }
        }
}

void printData( void )
{
	printf("------Print Data-------\n");
        for( uint8 rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++ )
        {
           for ( uint8 columnIndex = 0; columnIndex < COLUMN_SIZE; columnIndex++ )
           {
		printf( "%d %d\n", rowIndex, columnIndex );
	      if ( columnIndex % COLUMN_SIZE == 0 )
	      {
		      printf( "\n--------\n" );
	      }
           }
        }
}
