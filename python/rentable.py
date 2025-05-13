from datetime import datetime, timedelta

class Rentable:
    def __init__(self, name):
        self.name = name
        self.rented = False
        self.duration = 0

    @property
    def name(self):
        return self.__name
    
    @name.setter
    def name(self, value):
        if(value == ""):
            raise ValueError("Please, enter a name");
        else:
            self.__name = value

    @property
    def rented(self):
        return self.__rented
    
    @rented.setter
    def rented(self, value):
        self.__rented = value
    
    def countDays(self, duration):
        today = datetime.now()
        newDate = today + timedelta(days=duration)
        return newDate.strftime("%Y-%m-%d")

    
    def rent(self, duration):
        if(duration <= 0):
            raise ValueError("Please, enter a positive duration")
        else:
            if(self.rented == False):
                self.rented = True
                self.duration = duration
                print(f"You rented a {self.name} for {duration} days")
            else:
                print(f"This item is already rented")
        availableDate = self.countDays(duration)
        print((f"The rental will be terminated until {availableDate}"))

    def getAvailability(self):
        if(self.rented == False):
            print(f"The {self.name} is available")
        else:
            print(f"The {self.name} is on {self.countDays(self.duration)}")