#include <stdio.h>
#include <string.h>
#include <ctype.h>


void toLowerCase(char str[]) {
    for (int i = 0; str[i]; i++) {
        str[i] = tolower(str[i]);
    }
}


int containsWord(char str[], char target[]) {
    return strstr(str, target) != NULL;  
}

int main() {
    int n;
    scanf("%d", &n);
    getchar();  

    char target[100];
    fgets(target, sizeof(target), stdin);
    target[strcspn(target, "\n")] = 0;  
    toLowerCase(target); 

    int count = 0;
    char str[100];

    for (int i = 0; i < n; i++) {
        fgets(str, sizeof(str), stdin);
        str[strcspn(str, "\n")] = 0; 
        toLowerCase(str); 

        if (containsWord(str, target)) {
            count++;
        }
    }

    printf("%d\n", count); 

    return 0;
}
