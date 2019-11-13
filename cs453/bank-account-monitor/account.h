#ifndef __account_h
#define __account_h
#include <stdio.h>
#include <stdlib.h>

struct account{
        int balance;
        int finished;
        pthread_mutex_t mutex;
        pthread_cond_t deposit;
};

void init_account(struct account *act);
void deposit(struct account *act, int amount);
void withdrawl(struct account *act, int amount);
void destroy_account(struct account *act);
void finish(struct account *act);





#endif /* __account_h */

