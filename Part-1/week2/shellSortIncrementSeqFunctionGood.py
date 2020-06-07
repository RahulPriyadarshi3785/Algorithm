def shellSortIncrementSeqFunctionGood():
    limit = int(input("No. of sequence : "))
    print("For shellSort increment sequence : ")
    j = 0
    k = 2
    for i in range(limit):
        m = function1shellSort(j)
        res = function2shellSort(k)
        if(m < res):
            res = m
            j += 1
        else:
            k += 1
        print(i + 1, " -> ", res)


def function1shellSort(arg):
    return 9 * (4 ** arg) - 9 * (2 ** arg) + 1


def function2shellSort(arg):
    return (4 ** arg) - 3 * (2 ** arg) + 1

shellSortIncrementSeqFunctionGood()
