def insertionSort(lst, key=lambda v: v):
    i = 1  
    while i < len(lst):
        x = lst[i]  
        k = i-1
        while k >= 0 and key(lst[k]) > key(x):
            lst[k+1] = lst[k]
            k -= 1
        lst[k+1] = x
        i += 1


def main():
    lst0 = ["paulo", "augusto", "maria", "paula", "bernardo", "tito"]
    print("lst0", lst0)

    lst = lst0.copy()
    insertionSort(lst)
    print("lst1", lst)
    assert lst == sorted(lst0)

    lst = lst0.copy()
    insertionSort(lst, key=len)
    print("lst2", lst)
    assert lst == sorted(lst0, key=len)

    myorder = lambda s:(len(s), s)
    lst = lst0.copy()
    insertionSort(lst, key=myorder)
    print("lst3", lst)
    assert lst == sorted(lst0, key=myorder)

    print("All tests OK!")

if __name__ == "__main__":
    main()