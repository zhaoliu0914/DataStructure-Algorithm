
def sorted_function():
    list = [2, 1, 3, 4]
    new_list = sorted(list, reverse=True)
    print(new_list)

    new_list = sorted(range(5), )
    print(new_list)

    a = ("Jenifer", "Sally", "Jane")
    x = sorted(a)
    print(x)

    a = ("Jenifer", "Sally", "Jane")
    x = sorted(a, key=len)
    print(x)

    target = sorted(range(len(list)), key=lambda i: list[i], reverse=True)
    print(target)


def lambda_function():
    double = lambda x: x * 2
    print(double(11))

    check_num = lambda x: "Even" if x%2 == 0 else "Odd"
    print(check_num(7))


if __name__ == '__main__':
    # for i in range(10, 0, -1):
    #     print(i)

    #sorted_function()

    #lambda_function()

    list1 = [3, 2, 0, 1, 4, 6, 7, 8, 10]
    for i in range(len(list1)-2, -1, -2):
        print(list1[i])

    # arr = list(range(5))
    # print(arr)

