#include "greeter.h"


char *hello(void)
{
	char msg[] = "Hello World";
	
	size_t msg_len = 11;
	
	char * buffer = (char *) malloc ((msg_len + 1) * sizeof(char));

	strncpy(buffer, msg, msg_len);

	return buffer;
}
