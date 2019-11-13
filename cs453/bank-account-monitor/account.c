#include "account.h"
#include <pthread.h>

void init_account(struct account *act)
{
        act->balance = 0;
        act->finished = 0;
        pthread_mutex_init(&act->mutex,NULL);
        pthread_cond_init(&act->deposit,NULL);
}

void destroy_account(struct account *act)
{
        pthread_mutex_destroy(&act->mutex);
        pthread_cond_destroy(&act->deposit);
}

void finish(struct account *act)
{
        pthread_mutex_lock(&act->mutex);
        fprintf(stderr, "Finishing simulation\n");
        act->finished = 1;
        pthread_cond_broadcast(&act->deposit);
        pthread_mutex_unlock(&act->mutex);
}

void deposit(struct account *act, int amount)
{
        pthread_mutex_lock(&act->mutex);
        fprintf(stderr, "Deposit: $%d.00\n",amount);
        act->balance += amount;
        pthread_cond_broadcast(&act->deposit);
        pthread_mutex_unlock(&act->mutex);
}

void withdrawl(struct account *act, int amount)
{
        pthread_mutex_lock(&act->mutex);
        
        while(act->balance < amount && !act->finished){
                fprintf(stderr, "Withdrawl: $%d.00 Insufficient funds - Balance is $%d.00 so you must wait for a deposit!\n", amount, act->balance);
                pthread_cond_wait(&(act->deposit), &act->mutex);
        }
        if (act->balance < amount && act->finished) {
                fprintf(stderr, "Withdrawl: $%d.00 Insufficient funds, you've been cut off - Remaining balance is $%d.00\n", amount, act->balance);
        } else {
                fprintf(stderr, "Withdrawl: $%d.00 - Completed Successfully\n",amount);
                act->balance -= amount;
        }
        pthread_mutex_unlock(&act->mutex);
}








