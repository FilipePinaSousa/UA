//Seu código parece estar bem próximo de ser uma implementação do Crivo de Eratóstenes
// para encontrar números primos até um limite especificado.
// No entanto, há um pequeno erro no loop de inicialização do array sieve.
// O limite do loop deve ser i < limit em vez de i <= limit,

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  const int limit = 1000000;
  int *sieve = (int *)malloc((size_t)limit);
  if(sieve == NULL)
    return 1;
  for(int i = 0;i <= limit;i++)
    sieve[i] = 0;
  sieve[0] = sieve[1] = 1; // 0 and 1 are not prime
  for(int p = 2;p * p <= limit;p++)
    if(sieve[p] == 0)
      for(int i = p * p;i <= limit;i += p)
        sieve[i] = 1; // i is not prime
  int c = 0;
  for(int i = 0;i <= limit;i++)
    if(sieve[i] == 0)
      c++;
  printf("There are %d prime numbers up to %d\n",c,limit);
  free(sieve);
  return 0;
}
