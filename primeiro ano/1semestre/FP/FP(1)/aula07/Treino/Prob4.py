from _typeshed import IdentityFunction


teams = []

while True:
    team = input('Equipa: ')
    if team == '':
        break
    else:
        teams.append(team)

games = []

for team1 in teams:
    for team2 in teams:
        if team1 != team2:
            games.append((team1, team2))

results = {}
table = {}

for team in teams:
    table[team] = [0, 0, 0, 0, 0, 0]


for game in games:
    print()
    print('Resultado', game, '?')
    x = int(input('{}:').format(game[0]))
    y = int(input('{}:').format(game[1]))
    results[game] = (x, y)

    table[game[0]][3] += x
    table[game[0]][4] += y
    table[game[1]][3] += y
    table[game[1]][4] += x

    if x > y:
        table[game[0]][0] += 1
        table[game[0]][5] += 3
        table[game[1]][2] += 1
    elif x < y:
        table[game[1]][0] += 1
        table[game[1]][5] += 3
        table[game[0]][2] += 1
    else:
        table[game[0]][1] += 1
        table[game[0]][5] += 1
        table[game[1]][1] += 1
        table[game[1]][5] += 1
