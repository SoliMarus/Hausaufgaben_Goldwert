import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Goldpreis {
    private ArrayList <Goldtagespreis> list = new ArrayList<>();
    List<String> lines;

    
    public Goldpreis(String Dateiname)
    {
        try {
     String currentDate= "";
     double currentPrice=0;
     lines = Files.readAllLines(Path.of(Dateiname));
        for(String s : lines)
        {
            if(s.contains("kein Nachweis"))
            {
                list.add(new Goldtagespreis("00-00-0000", -1));
                continue;
            }
            currentDate = s.substring(0,10);
            currentPrice = Double.parseDouble(s.substring(11,17));
            list.add(new Goldtagespreis(currentDate,currentPrice));
        }
    }
    catch (IOException e){
        System.out.println("Datei ungültig");
        System.exit(1);}
    }
    
     public double getPreis(String datum)
    {
        
        Pattern p = Pattern.compile("[\\d]{4}\\-[\\d]{2}\\-[\\d]{2}");
        Matcher m = p.matcher(datum);
        boolean b = m.matches();

        if(b){
        for(int i= 0;i<list.size();i++)
        {
            if(datum.equals( list.get(i).Datum))
            {
                return list.get(i).Preis*1000;
            }
        }
        return -1;}
        else throw new NumberFormatException(datum);
    
    }


    public void printMinMax()
    {
        double groestes = 0;
        double kleinstes = list.get(0).Preis;

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).Preis < kleinstes && list.get(i).Preis != -1) kleinstes = list.get(i).Preis;
            if(groestes < list.get(i).Preis) groestes = list.get(i).Preis;
        }
        System.out.println("Den niedrigsten Goldpreis von "+ kleinstes*1000 +" gab es an folgenden Tagen: ");

        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i).Preis ==kleinstes) System.out.println(list.get(i).Datum + ", ");
        }
        System.out.println("Den hoechsten Goldpreis von "+ groestes*1000 +" gab es an folgenden Tagen: ");
        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i).Preis ==groestes) System.out.println(list.get(i).Datum + ", ");
        }
    }

}
