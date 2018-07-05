#ifndef HEADER_H
#define HEADER_H

#define M_STR 10

typedef struct
{
	char name[M_STR], retv[M_STR], params[30];
} function;

typedef struct
{
	char name[10], type[10];
} variable;

typedef struct
{
	variable fields[10];
} struct_;

typedef struct
{
	
} header;

#endif
