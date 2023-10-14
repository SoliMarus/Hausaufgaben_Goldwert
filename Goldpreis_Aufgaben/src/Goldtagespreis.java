public class Goldtagespreis {
    public String Datum;
    public double Preis;
    public boolean b;
    //public Pattern p = Pattern.compile("([\\d]{2}\\-[\\d]{2}\\-[\\d]{4})");
   
    public Goldtagespreis(String datum, double preis) 
    {
        
       // Matcher m = p.matcher(datum);
        //b = m.matches();
        //if(b)
        //{
            Datum = datum;
            Preis = preis;
        //}
        //else throw new IOException ("Given date doesnt match the pattern xx.xx.xxxx");
    }
    public String toString()
    {
        return this.Datum + "   "+this.Preis;
    }

}
