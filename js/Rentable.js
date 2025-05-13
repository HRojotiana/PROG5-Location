class Rentable {
    constructor(name) {
        this.name = name;
        this.rented = false;
        this.duration = 0;
    }

    rent(duration) {
        if (duration <= 0) {
            console.log("Please enter a positive duration");
        } else {
            if (!this.rented) {
                this.rented = true;
                this.duration = duration;
                const availableDate = this.countDays(duration);
                console.log("You rented a " + this.name + " for " + duration + " days until " + availableDate);
            } else {
                console.log("This item is not available");
            }
        }
    }

    countDays(duration) {
        const today = new Date();
        today.setDate(today.getDate() + Number(duration));
        return today.toLocaleString(); 
    }

    getAvailability() {
        if (!this.rented) {
            return "This item is currently available.";
        } else {
            return `This item will not be available until: ${this.countDays(this.duration)}`;
        }
    }
}

module.exports = Rentable;
