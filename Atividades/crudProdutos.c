#include <stdio.h>
#include <string.h>

typedef struct produto {
    int id;
    char nome[50];
    float preco;
    int qtd;
} produto;

produto cadastrarProduto() {
    produto prod;
    printf("Digite o ID: ");
    scanf("%d", &prod.id);
    getchar();

    printf("Digite o nome: ");
    fgets(prod.nome, sizeof(prod.nome), stdin);
    prod.nome[strcspn(prod.nome, "\n")] = 0;

    printf("Digite o preco: ");
    scanf("%f", &prod.preco);

    printf("Informe a quantidade: ");
    scanf("%d", &prod.qtd);

    return prod;
}

void editaProduto(produto produtos[], int *n){
    int id;
    printf("Digite o ID do produto que quer alterar: ");
    scanf("%d", &id);

    int found = 0;

    for(int i = 0; i < *n; i++){
        if(produtos[i].id == id){

            found = 1;

            printf("Digite o ID: ");
            scanf("%d", &produtos[i].id);
            getchar();

            printf("Digite o nome: ");
            fgets(produtos[i].nome, sizeof(produtos[i].nome), stdin);
            produtos[i].nome[strcspn(produtos[i].nome, "\n")] = 0;

            printf("Digite o preco: ");
            scanf("%f", &produtos[i].preco);

            printf("Informe a quantidade: ");
            scanf("%d", &produtos[i].qtd);

            printf("Produto com ID %d atualizado com sucesso.\n", id);
            break;
        }
    }

    if(!found){
        printf("Produto com ID %d nao encontrado.\n", id);
    }
}

void vendeProduto(produto produtos[], int *n){
    int id, quantidade;
    printf("Digite o ID do produto que sera vendido: ");
    scanf("%d", &id);

    int found = 0;
    for(int i = 0; i < *n; i++){
        if(produtos[i].id == id){
            found = 1;

            printf("digite a quantidade que sera vendida: ");
            scanf("%d", &quantidade);

            if(produtos[i].qtd >= quantidade){
                float totalVendas = produtos[i].preco * quantidade;

                produtos[i].qtd -= quantidade;

                printf("Venda realizada com sucesso!\n");
                printf("Produto: %s\n", produtos[i].nome);
                printf("Quantidade vendida: %d\n", quantidade);
                printf("Valor total da venda: R$%.2f\n", totalVendas);
                printf("Quantidade restante em estoque: %d\n", produtos[i].qtd);

            }

            else{
                printf("Estoque insuiciente para realizar a venda! \n");
            }

            break;
        }
    }

    if(!found){
        printf("Produtos com ID: %d nao encontrado. \n", id);
    }
}

void deleteProduto(produto produtos[], int *n){
    int id;
    printf("Digite o ID do produto que quer deletar: ");
    scanf("%d", &id);

    int found = 0;
    for(int i = 0; i < *n; i++){
        if(produtos[i].id == id){
            found = 1;

            for(int j = i; j < *n - 1; j++){
                produtos[j] = produtos[j + 1];
            }
            (*n)--;
            printf("Produto com ID: %d deletado", id);
            break;

        }
    }

    if(!found){
        printf("ID nao existente");
    }

}

void adicionaProduto(produto produtos[],int *n){
    produto novoProd;

    printf("Digite o ID do novo produto: ");
    scanf("%d", &novoProd.id);
    getchar();  

    printf("Digite o nome do novo produto: ");
    fgets(novoProd.nome, sizeof(novoProd.nome), stdin);
    novoProd.nome[strcspn(novoProd.nome, "\n")] = 0;  

    printf("Digite o preco do novo produto: ");
    scanf("%f", &novoProd.preco);

    printf("Informe a quantidade do novo produto: ");
    scanf("%d", &novoProd.qtd);

    produtos[*n] = novoProd;

    (*n)++;

    printf("Produto adicionado com sucesso!\n");
}

int main() {
    int n;
    printf("Informe a quantidade de produtos: ");
    scanf("%d", &n);

    produto produtos[n];

    for (int i = 0; i < n; i++) {
        produtos[i] = cadastrarProduto();
    }

    printf("\nProdutos cadastrados:\n");
    for (int i = 0; i < n; i++) {
        printf("ID: %d, Nome: %s, Preco: R$%.2f, Quantidade: %d\n",
               produtos[i].id, produtos[i].nome, produtos[i].preco, produtos[i].qtd);
    }

    printf("===============================================================================================\n");

    editaProduto(produtos, &n);
    printf("\nProdutos cadastrados apos a alteracao:\n");
    for (int i = 0; i < n; i++) {
        printf("ID: %d, Nome: %s, Preco: R$%.2f, Quantidade: %d\n",
               produtos[i].id, produtos[i].nome, produtos[i].preco, produtos[i].qtd);
    }

    printf("===============================================================================================\n");

    vendeProduto(produtos, &n);

    printf("===============================================================================================\n");

    deleteProduto(produtos, &n);

    printf("\nProdutos restantes:\n");
    for (int i = 0; i < n; i++) {
        printf("ID: %d, Nome: %s, Preco: R$%.2f, Quantidade: %d\n",
               produtos[i].id, produtos[i].nome, produtos[i].preco, produtos[i].qtd);
    }

    printf("===============================================================================================\n");

    adicionaProduto(produtos, &n);
    printf("\nProdutos cadastrados:\n");
    for (int i = 0; i < n; i++) {
        printf("ID: %d, Nome: %s, Preco: R$%.2f, Quantidade: %d\n",
               produtos[i].id, produtos[i].nome, produtos[i].preco, produtos[i].qtd);
    }

}

