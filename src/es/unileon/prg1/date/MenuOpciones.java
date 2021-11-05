package es.unileon.prg1.date;
//menu de opciones
public class MenuOpciones{


    public MenuOpciones() throws DateException{
        Date date1;
		
        int selector = 0;
        boolean exit = false;
        //repeticion hasta finalizar
        while (!exit){ 
            //seleccion funcionamiento
            System.out.println("\n\n¿que desea hacer?");
            System.out.println("1=>comparar fechas\t 2=> conocer nombre de mes\t 3=>verificar dia");
            System.out.println("4=>conocer la estacion\t 5=> meses restantes\t 6=>fechas restantes");
            System.out.println("7=> mismo numero de dias\t 8=>Nº dias restantes\t  9=>Nº intentos fecha aleatoria");
            System.out.println("10=> dia de la semana conociendo el primer dia del anio\t 11=>salir");
            selector = Teclado.readInteger();

            if(selector == 1){ //compara fechas
                Date date2;
                
                //primera fecha
                System.out.println("introduce la primera fecha");
                date1 = generateDate();

                //segunda fecha
                System.out.println("introduce la segunda fecha");
                date2 = generateDate();
        
                //compara fechas
                System.out.println("¿son la primera y la segunda fecha iguales? "+date1.isSame(date2));

            }else if(selector == 2){//conocer nombre de mes

                System.out.println("introduce la fecha");
                date1 = generateDate();

                //imprime el nombre del mes
                System.out.println(date1.monthName());

            }else if (selector == 3){//comprueba que el dia sea correcto

                System.out.println("introduce la fecha");
                date1 = generateDate();

                //comprueba el dia
                System.out.println("¿es valido el dia introducido? =>"+ date1.checkDay());
            }else if (selector == 4){//imprime la estacion del anio segun la fecha introducida

                System.out.println("introduce la fecha");
                date1 = generateDate();
                
                //extrae la estacion
                System.out.println("la estacion es "+ date1.seasonDate());
            }else if(selector == 5){ // imprime los meses restantes hasta final de anio
                
                System.out.println("introduce la fecha");
                date1 = generateDate();

                System.out.println("quedan "+ date1.monthsLeft()+ " meses para acbar el mes");
            }else if(selector == 6){//imprime los dias restantes hasta acabar el mes  

                System.out.println("introduce la fecha");
                date1 = generateDate();

                
                System.out.println("quedan "+ date1.daysLeft()+ " dias para acbar el mes");
            }else if(selector ==7){//imprime los meses con el mismo numero de dias que el introducido

                System.out.println("introduce la fecha");
                date1 = generateDate();

                date1.sameNDays(); 
            }else if (selector == 8){//imprime los dias restantes hasta finalizar el anio

                System.out.println("introduce la fecha");
                date1 = generateDate();


            }else if (selector == 9){//imprime el numero de intentos hasta que genera aleatoriamente la misma fecha que introduciste 

                System.out.println("introduce la fecha");
                date1 = generateDate(); 

                date1.randomGenerate();
                date1.randomGenerateDo();
            }

            else if (selector == 11) {
                exit = true;
            }
        }
    }

    public Date generateDate() throws DateException {
        Date date;
        int day = 0, month = 0, year = 0;

        System.out.println("introduce el dia");
        day = Teclado.readInteger();

        System.out.println("introduce el mes");
        month = Teclado.readInteger();

        System.out.println("introduce el año");
        year = Teclado.readInteger();

        date = new Date(day,month,year);
        System.out.println(date);
        return date;
    }
}