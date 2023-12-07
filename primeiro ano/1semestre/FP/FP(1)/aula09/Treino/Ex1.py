with open('pg3333.txt', 'r', encoding='utf-8') as file:
    letters = {}
    for line in file:
        for letter in line:
            if letter.isalpha():
                letter = letter.lower()
                if letter not in letters:
                    letters[letter] = 1
                else:
                    letters[letter] += 1

for letra in sorted(letters, key=lambda x: letters[x], reverse=True):
    print(letra, letters[letra])
