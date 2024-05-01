import random

def main():
    names = []
    lat = 22
    lng = 88

    f = open("names.txt", "r")
    for line in f.readlines():
        names.append(line.replace("\n", "").strip())

    n = len(names) - 1
    for i in range(100000):
        f = random.randint(0, n)
        l = random.randint(0, n)

        firstname = names[f]
        lastname = names[l]

        if firstname == lastname:
            continue
        # 22.625000, 88.438600 C
        # 22.500000, 88.345900 W
        # 22.643700, 88.377700 N
        # 22.575400, 88.479800 E
        loc_lat = lat + (random.randint(50000, 65000) / 100000)
        loc_lng = lng + (random.randint(30000, 50000) / 100000)

        print("{} {} {} {}".format(firstname, lastname, loc_lat, loc_lng))

if __name__ == "__main__":
    main()