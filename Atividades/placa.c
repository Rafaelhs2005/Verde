#include <stdio.h>
#include <string.h>

int main(){
    char placa[8];
    scanf("%s", placa);
    int n = strlen(placa);
    if (n < 7 || n > 8) {
        printf("0\n");
    }
    else{
        if (placa[3] == '-')
        {
            printf("1\n");
        }
        else{
            printf("2\n");
        }
        
    }   
}