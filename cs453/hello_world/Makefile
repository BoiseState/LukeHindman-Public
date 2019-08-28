all: helloworld

helloworld: helloworld.o
	gcc $^ -o $@

helloworldv2:
	gcc -E helloworld.c -o helloworld.i
	gcc -S helloworld.i -o helloworld.s
	as helloworld.s -o helloworld.o
	ld /usr/lib64/crti.o /usr/lib64/crtn.o /usr/lib64/crt1.o /usr/lib64/libc.so helloworld.o -dynamic-linker /lib64/ld-linux-x86-64.so.2 -o helloworldv2

clean:
	rm -f helloworld.i helloworld.s helloworld.o helloworld helloworldv2
