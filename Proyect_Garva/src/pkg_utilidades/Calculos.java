
package pkg_utilidades;


public class Calculos {
    
   public static java.sql.Date convertFecha(java.util.Date date)
   {
       java.sql.Date format= new java.sql.Date(date.getTime());
       return format;
   }
}
