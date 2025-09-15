# CalculadoraImpostoAmericano

Calculadora de impostos de importação para produtos nos Estados Unidos.  
Permite calcular o CIF, aplicar alíquotas (USMCA, categorias especiais e tabela de produtos gerais) e exibir o valor final do produto.

---

## Como usar o projeto

Siga estes passos para executar a Calculadora de Impostos Americana:

1. **Abra o projeto no IntelliJ IDEA.**
2. **Execute a classe `Main`.**
3. **Insira os dados do produto:**
    - **Descrição:** nome do produto
    - **Origem:** escolha entre China, União Europeia, Japão, Coreia do Sul, Vietnã, Tailândia, Canadá, México ou Outros
    - **Categoria:** Geral, Fármacos, Semicondutores, Cobre, Madeira, Energia/Minerais ou Bullion
    - **Valor da mercadoria (USD)** e **valor do frete (USD)**
    - **USMCA:** apenas se a origem for Canadá ou México (`true`/`false`)
4. **Confira o resultado:**
    - CIF (Mercadoria + Frete)
    - Alíquota aplicada (%)
    - Imposto (USD)
    - Valor final do produto (USD)

> 💡 **Dica:** siga exatamente as opções listadas para origem e categoria para que o cálculo seja correto.

---

## Exemplos de Testes

| Produto | Origem | Categoria | Valor | Frete | CIF | Alíquota | Imposto |
|---------|--------|-----------|-------|-------|-----|----------|---------|
| Produto A | China | Geral | 200 | 20 | 220 | 34% | 74,80 |
| Produto B | União Europeia | Semicondutores | 500 | 50 | 550 | 10% | 55,00 |
| Produto C | Canadá | USMCA=True | 300 | 30 | 330 | 0% | 0,00 |
| Produto D | México | USMCA=False, Geral | 400 | 40 | 440 | 25% | 110,00 |
| Produto E | Brasil | Geral | 120 | 10 | 130 | 10% | 13,00 |

---

## Tecnologias

- Java
- IntelliJ IDEA
- Git / GitHub

---

## Observações

- Arquivos de configuração do IntelliJ (`.idea/` e `.iml`) estão no `.gitignore` para manter o repositório limpo.
- Todos os valores exibidos são em USD com **2 casas decimais**.  
