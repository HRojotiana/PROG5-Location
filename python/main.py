from rentable import Rentable

def main():
    name = input("What do you want to rent?\n")
    duration = int(input("How many days will be the rental?\n"))
    rentable = Rentable(name)
    rentable.rent(duration)
if __name__ == "__main__":
    main()
        