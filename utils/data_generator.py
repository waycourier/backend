import random

# create dummy package data in kolkata loc
def main():
    names = []
    items = []
    lat = 22
    lng = 88

    # load user names
    f = open("names.txt", "r")
    for line in f.readlines():
        names.append(line.replace("\n", "").strip())

    # load item names
    f = open("items.txt", "r")
    for line in f.readlines():
        items.append(line.replace("\n", "").strip())

    with open("package_data.txt", "w") as file:
        for i in range(1000):
            i = random.randint(0, len(names)-1)
            firstname = names[i]

            i = random.randint(0, len(items)-1)
            item = items[i]

            # 22.625000, 88.438600 C
            # 22.500000, 88.345900 W
            # 22.643700, 88.377700 N
            # 22.575400, 88.479800 E
            src_lat = lat + (random.randint(50000, 65000) / 100000)
            src_lng = lng + (random.randint(30000, 50000) / 100000)
            dest_lat = lat + (random.randint(50000, 65000) / 100000)
            dest_lng = lng + (random.randint(30000, 50000) / 100000)

            data = "{} {} {} {} {} {}\n".format(item, src_lat, src_lng, dest_lat, dest_lng, firstname)
            file.write(data)

if __name__ == "__main__":
    main()