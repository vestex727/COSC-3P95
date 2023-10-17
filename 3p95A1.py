# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


testCases = [
    [[1, 2, 3, 4, 5, 6], -999, [2]],
    [[1, 2, 3, 4, 5, 6], 4, [2, 3]],
    [[1, 2, 3, 4, 5, 6], 7, []],
    [[1, 2, 3], 3, [2]]
]


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


def process_string(input_str):
    output_str = ""
    for char in input_str:
        if char.isupper():
            output_str += char.lower()
        elif char.isnumeric():
            output_str += char
        else:
            output_str += char.upper()

    return output_str


def filter_data1(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index > len(data):
        item = data[index]
        if item in exceptions:
            modified_item = item + "_EXCEPTION"
        elif item > limit:
            modified_item = item * 2
        else:
            modified_item = item / limit

        filtered_data.append(modified_item)
        index += 1

    return filtered_data


def filter_data2(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index == len(data):
        item = data[index]
        if item in exceptions:
            modified_item = item + "_EXCEPTION"
        elif item > limit:
            modified_item = item * 2
        else:
            modified_item = item / limit

        filtered_data.append(modified_item)
        index += 1

    return filtered_data


def filter_data3(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if not item in exceptions:
            modified_item = item + "_EXCEPTION"
        elif item > limit:
            modified_item = item * 2
        else:
            modified_item = item / limit

        filtered_data.append(modified_item)
        index += 1
    return filtered_data


def filter_data4(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if item in exceptions:
            modified_item = item + "_EXCEPTION"
        elif item <= limit:
            modified_item = item * 2
        else:
            modified_item = item / limit

        filtered_data.append(modified_item)
        index += 1
    return filtered_data


def filter_data5(data, exceptions):
    filtered_data = []
    index = 0
    limit = 0
    while index < len(data):
        item = data[index]
        if item in exceptions:
            modified_item = item + "_EXCEPTION"
        elif item > limit:
            modified_item = item * 2
        else:
            modified_item = item / limit

        filtered_data.append(modified_item)
        index += 1
    return filtered_data


def filter_data6(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if item in exceptions:
            modified_item = item + "_EXCEPTION"
        elif item > limit:
            modified_item = item * 2
        else:
            modified_item = item / limit

        filtered_data.append(modified_item)
        index += 1

    return exceptions


def test_data():
    for x in range(0, len(testCases)):
        filter_data1(testCases[1], testCases[2], testCases[3])
        filter_data2(testCases[1], testCases[2], testCases[3])
        filter_data3(testCases[1], testCases[2], testCases[3])
        filter_data4(testCases[1], testCases[2], testCases[3])
        filter_data5(testCases[1], testCases[2])
        filter_data6(testCases[1], testCases[2], testCases[3])


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    test_data()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
