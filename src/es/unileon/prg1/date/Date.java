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
    
	public int getDay(){
            return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
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
    private int getDaysOfMonth(int month) {
		int numDays;
		
		numDays = 0;
		switch (month) {
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
     //compara dia
    public boolean isSameDayIf(Date fecha){
        boolean isSameDay = false;
        if (this.day == fecha.getDay()){
            isSameDay = true;
        }
        return isSameDay;
    }
     //compara mes
    public boolean isSameMonthIf(Date fecha){
        boolean isSameMonth = false;
        if (this.month == fecha.getMonth()){
            isSameMonth = true;
        } 
        return isSameMonth;
    }
     //compara anio
    public boolean isSameYearIf(Date fecha){
        boolean isSameYear = false;
        if(this.year == fecha.getYear()){
            isSameYear = true;
        }
        return isSameYear;
    }
     //compara fecha
    public boolean isSameIf(Date fecha){
        boolean isSame = false;
        if (isSameDay(fecha) && isSameMonth(fecha) && isSameYear(fecha)){
            isSame = true;
        }
        return isSame;
    }
     //compara dia
    public boolean isSameDay(Date fecha){
        return (this.day == fecha.getDay());
    }
     //compara mes
    public boolean isSameMonth(Date fecha){
        return (this.month == fecha.getMonth());
    }
     //compara anio
    public boolean isSameYear(Date fecha){
        return (this.year == fecha.getYear());
    }
     //compara fecha
    public boolean isSame(Date fecha){
        return (isSameDay(fecha) && isSameMonth(fecha) && isSameYear(fecha));
    }
     //extrae nombre del mes
    public String monthName() throws DateException{
        String monthName = "";
        switch(this.month){
            case 1:
                monthName = "Enero";
                break;
            case 2:
                monthName = "Febrero";             
                break;
            case 3:
                monthName = "Marzo";   
                break;
            case 4:
                monthName = "Abril";
                break;
            case 5:
                monthName = "Mayo";    
                break;
            case 6:
                monthName = "Junio";    
                break;
            case 7:
                monthName = "Julio";    
                break;  
            case 8:
                monthName = "Agosto";    
                break;
            case 9:
                monthName = "Septiembre";    
                break;
            case 10:
                monthName = "Octubre";    
                break;  
            case 11:
                monthName = "Noviembre";    
                break;
            case 12:
                monthName = "Diciembre";    
                break;
            default:
                throw new DateException("Date error: Month " + month + " not valid");
        } 
        return monthName;
    }
    public boolean checkDay(){
        boolean rightDay;
        if(this.day<getDaysOfMonth()){
            rightDay = true;
        }else{
            rightDay = false;
        }
        return rightDay;
    }

    public String seasonDate()throws DateException{
        String seasonDate;
        switch(this.month){
            case 1:
            case 2:
            case 12:
                seasonDate = "invierno";
                break;
            case 3:
            case 4:
            case 5:
                seasonDate = "primavera";
                break;
            case 6:
            case 7:
            case 8:
                seasonDate = "verano";
                break;
            case 9:
            case 10:
            case 11:
                seasonDate = "oto??o";
                break;
            default:
                throw new DateException("Date error: Month " + month + " not valid");
        }
        return seasonDate;
    }

    public int monthsLeft()throws DateException{//imprime los meses restantes hasta finalizar el anio

        int monthsLeft = 0;
        for (int i=this.month; i<=12; i++){
            setMonth(i);
            monthsLeft++;
           
        }
        return monthsLeft;
    }
    public int daysLeft(){//imprime los dias restantes hasta final de mes 
        int daysLeft = 0;
        
        for(int i = this.day; i <= getDaysOfMonth(); i++){
            daysLeft++;
        }
        return daysLeft;
    }
    public void sameNDays() throws DateException{//imprime los meses con el mismo numero de dias 
        //variable que recoge el numero de dias del mes introducido
        int days = getDaysOfMonth();

        for(int i = 0;i < 12; i++){

            setMonth(i+1);
            if (days == getDaysOfMonth()){
            System.out.println(monthName());
            }
        }
    }

    public void daysUntilYear()throws DateException{//calcula los dias restantes del a??o
        int counter = 0, month = this.month;
        //cuenta los dias hata terminar el mes 
        counter = daysLeft();
        //cuenta los dias de los meses restantes
        for (; month<12;){
            month += 1;
            setMonth(month);
            for(int i=0; i<getDaysOfMonth();i++){
                counter++;
            }
        }
        System.out.println("quedan "+ counter+ " dias hasta finalizar el a??o");
    }


     public void randomGenerate()throws DateException{//cuenrta los intentos hasta acertar la fecha dada de manera aleatoria
        boolean goal = false;
        int counter = 0;
        while (!goal){
            int day = 0,month = 0, year = this.year;
            day = (int)(Math.random()*getDaysOfMonth() +1);
            month = (int)(Math.random()* 12+1);
            Date randomDate = new Date(day, month, year);
            if (isSame(randomDate)){
                goal = true;
            }else{
                goal = false;
            }
            counter ++;
        }
        System.out.println("la fecha ha sido hacertada en "+ counter+ " intentos");
    } 
    
    public void randomGenerateDo()throws DateException{//cuenrta los intentos hasta acertar la fecha dada de manera aleatoria usando do while
        boolean goal = false;
        int counter = 0;
        do{
            int day = 0,month = 0, year = this.year;
            day = (int)(Math.random()*getDaysOfMonth() +1);
            month = (int)(Math.random()* 12+1);
            Date randomDate = new Date(day, month, year);
            if (isSame(randomDate)){
                goal = true;
            }else{
                goal = false;
            }
            counter ++;
        }while (!goal);
        System.out.println("la fecha ha sido hacertada en "+ counter+ " intentos");
    }

    public void getDayWeek()throws DateException{//calcula el dia de la semana de una fecha a partir del primer dia del anio
        int nDaysMonth = 0, daysWeek;
        //solicita al usuario el dia de la semana del primeer dia del anio
        System.out.println("introduce el dia de la semana del primer dia del a??o");
        System.out.println("0=> domingo\t 1=> lunes\t 2=> martes\t 3=> miercoles\n 4=> jueves\t 5=> viernes\t 6=> sabado");
        daysWeek = Teclado.readInteger();
        //comprueba que el dia introducido sea correcto
        if (daysWeek<0||daysWeek>6){
            throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");
        }
        // cuenta los dias transcurridos del anio
        for (int i = 1; i < this.month;i++) {
            nDaysMonth += getDaysOfMonth(i);
        }
       
        nDaysMonth += this.day;
       //recorre los dias transcurridos hasta el dia introducido
        for (int i = 0; i < nDaysMonth - 1; i++) {
            daysWeek++;
            //si el dia de la semana llega al maximo lo reinicia a cero
            if (daysWeek == 7) {
                daysWeek = 0;
            }
        }
        //imprime el dia de la semana de la fecha solicitada
        switch(daysWeek){
            case 0:
                System.out.println("el dia de la semana de la fecha "+ toString()+ " es domingo");
                break;
            case 1:
                System.out.println("el dia de la semana de la fecha "+ toString()+ " es lunes");
                break;
            case 2:
                System.out.println("el dia de la semana de la fecha "+ toString()+ " es martes");
                break;
            case 3:
                System.out.println("el dia de la semana de la fecha "+ toString()+ " es miercoles");
                break;
            case 4:
                System.out.println("el dia de la semana de la fecha "+ toString()+ " es jueves");
                break;
            case 5:
                System.out.println("el dia de la semana de la fecha "+ toString()+ " es viernes");
                break;
            case 6:
                System.out.println("el dia de la semana de la fecha "+ toString()+ " es sabado");
                break;
            default:
                throw new DateException("Date error: Day of the week " + daysWeek + " not valid");
        }
       
    }

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
