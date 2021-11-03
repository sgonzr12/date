package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
    
    boolean isSameDayIf(date){
        boolean isSameDay = false;
        if (this.day == date.getDay()){
            isSameDay = true;
        }
        return isSameDay;
    }

    boolean isSameMonthIf(date){
        boolean isSameMonth = false;
        if (this.month == date.getmonth()){
            isSameMonth = true;
        } 
        return isSameMonth;
    }

    boolean isSameYearIf(date){
        boolean isSameYear = false;
        if(this.year == date.getYear()){
            isSameYear = true;
        }
        return isSameYear;
    }

    boolean isSameIf(date){
        boolean isSame = false;
        if (isSameDay && isSameMonth && isSameYear){
            isSame = true;
        }
        return isSame;
    }

    boolean isSameDay(date){
        return (this.day == date.getDay());
    }

    boolean isSameMonth(date){
        return (this.month == date.getmonth());
    }
    
    boolean isSameYear(date){
        return (this.year == date.getYear());
    }

    boolean isSame(date){
        return (isSameDay && isSameMonth && isSameYear);
    }

    String monthName(){

    }

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
