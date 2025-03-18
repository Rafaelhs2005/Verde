#include <stdio.h>

char combinador(char str1, char str2){
    
    char resp[200];

    for(int i = 0; i < 200; i++){
        resp[i] = str1[i];
        resp[i+1] = str2[i]; 
    }

    return resp;
    
}

int main(){
    char str1[100], str2[100], resp[200];
    scanf("%s", &str1);    
    scanf("%s", &str2);

    resp = combinador(str1, str2); 
    
}