with open('pg3333.txt', 'r', encoding='utf-8') as text:
    letters = {}
    for line in text:
        for letra in line:
            if letra.isalpha():
                letra = letra.lower()
                if letra in letters:
                    letters[letra] += 1
                else:
                    letters[letra] = 1

for letra in sorted(letters):
    print(letra, letters[letra])
