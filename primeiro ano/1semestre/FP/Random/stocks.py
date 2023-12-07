def printStocks(stocks):
    print("{:10} | {:^10} | {:^10} | {:^10} | {:^10}| {:^10}".format("Empresa", "Cidade",
                                                                     "Preço-de-abertura", "Preço-de-fecho", "Volume", "Valorização"))
    for value in stocks:
        valorizacao = ((value[3] - value[2])/value[2])*100
        print("{:10} | {:^10} | {:^17} | {:^14} | {:^10}| {:7.2f}%".format(
            value[0], value[1], value[2], value[3], value[4], valorizacao))


def main():
    stocks = [("INTC", "London", 34.249, 34.451, 1792860),
              ("TSLA", "London", 221.33, 229.63, 398520),
              ("EA", "Paris", 72.63, 68, 98, 1189510),
              ("INTC", "Tokyo", 33.22001, 34.28909, 4589110),
              ("TSLA", "Paris", 217.35, 217.75, 252500),
              ("ATML", "Frankfurt", 8.23, 8.36, 810440)]

    stocks2 = sorted(stocks, key=lambda stock: (
        stock[0], stocks[4]), reverse=True)

    print(stocks2)


if __name__ == "__main__":
    main()
