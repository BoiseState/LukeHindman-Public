#ifndef GREETER_H_
#define GREETER_H_

#ifdef __cplusplus
extern "C" {
#endif

#include <stdio.h>
#include <string.h>

/* 
 * This function returns a pointer to a string containing the standard greeting,
 * Hello World. The memory allocated by this method must be freed by the caller.
 * Allocating memory within a library call be dangerous and is a fantastic way to 
 * create memory leaks which happens to be exactly why it is being done this way. :)
 */  
char *hello(void);

#ifdef __cplusplus
}
#endif

#endif //GREETER_H_
