CC = gcc
CFLAGS = -Wall -Wextra -Wpointer-arith -Wstrict-prototypes -std=gnu89 -g -fPIC -L. -lpthread
LDFLAGS = -shared

all: libaccount mytests

mytests: mytests.o account.o
	$(CC) $(CFLAGS) $^ -o $@ 

libaccount:account.o
	$(CC) $(CFLAGS) $(LDFLAGS) $^ -o $@.so

clean:
	rm -f *.o *.d a.out mytests libaccount.so
