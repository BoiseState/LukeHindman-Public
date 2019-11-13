
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <time.h>
#include "account.h"


static int num_iterations;

static void* withdrawl_worker(void *arg);
static void* deposit_worker(void *arg);

int main(int argc, char** argv)
{
        if(argc !=  2){
                printf("%s <num iterations>\n",argv[0]);
                return 0;
        }

        num_iterations = atoi(argv[1]);
        pthread_t t;
        pthread_t t1;
        struct account act;
        init_account(&act);
        printf("Running %d iterations\n",num_iterations);

        pthread_create(&t,NULL,deposit_worker,&act);
        pthread_create(&t1,NULL,withdrawl_worker,&act);
        pthread_join(t,NULL);
        pthread_join(t1,NULL);
        printf("Final balance is: $%d.00\n",act.balance);
        destroy_account(&act);
        return 0;
}


static void* withdrawl_worker(void *arg)
{
        struct account *act = (struct account *)arg;
        int amt = 0;
        int i = 0;
        int iterations = num_iterations;
        unsigned int seed = time(0);

        for(i = 0;i < iterations; i++){
                amt = rand_r(&seed)%80;
                //amt = 100;
                withdrawl(act,amt);
                usleep(20000);
        }
        fprintf(stderr,"Withdrawl thread finished\n");
        return NULL;
}

static void* deposit_worker(void *arg)
{
        struct account *act = (struct account *)arg;
        int amt = 1;
        int i = 0;
        int iterations = num_iterations;
        unsigned int seed = time(0);
        for(i = 0;i < iterations; i++){
                amt = rand_r(&seed)%40;
                // amt = 100;
                deposit(act,amt);
                usleep(20000);
        }
        finish(act);
        fprintf(stderr,"Deposit thread finished\n");
        return NULL;
}