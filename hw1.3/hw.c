/*
MIDN 1/C Jeongwon Park
HW 1.3 Problem 2B
*/
#include <stdio.h>

int foo(int a){
    // int sqr = a*a;
    // return sqr;
    return a*a;
}

int main()
{
    int x;
    printf("Enter a number: ");
    scanf(" %d", &x);
    // x = x + 3;
    // x = foo(x);
    x = foo(x+3);
    printf("%d\n", x);
    
    return 0;
}