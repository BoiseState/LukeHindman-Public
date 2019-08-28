CC = gcc
CFLAGS = -Wall -Wextra -Wpointer-arith -Wstrict-prototypes -std=gnu89 -O2 -fPIC -L.
LDFLAGS = -shared

all: mytests libgreeter mylibtests

mytests: mytests.o greeter.o
	$(CC) $(CFLAGS) $^ -o $@ 

libgreeter: greeter.o
	$(CC) $(CFLAGS) $(LDFLAGS) $^ -o $@.so


# Note: For this test to run, the current directory
#   must be added to the LD_LIBRARY_PATH
#
#   export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:.
#
mylibtests: mytests.o
	$(CC) $(CFLAGS) $^ -o $@ -lgreeter 

clean:
	rm -f *.o *.d a.out mytests mylibtests libgreeter.so
