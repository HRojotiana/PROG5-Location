from datetime import datetime, timedelta

class Rentable:
    def __init__(self, name):
        self.name = name
        self.rented = False

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
                print(f"You rented a {self.name} for {duration} days")
            else:
                print(f"This item is already rented")
        availableDate = self.countDays(duration)
        print((f"The rental will be terminated until {availableDate}"))