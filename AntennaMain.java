import java.util.*;

public class AntennaMain
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=4;
        Antenna antennas[]=new Antenna[n];
        for(int i=0;i<n;i++)
        {
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            String lead=sc.nextLine();
            double vswr=sc.nextDouble();
            antennas[i]=new Antenna(id,name,lead,vswr);
        }

        sc.nextLine();
        String searchName=sc.nextLine();
        int reqId=searchAntennaByName(antennas,searchName);
        
        double searchVSWR=sc.nextDouble();
        Antenna reqAntennas[]=sortAntennaByVSWR(antennas,searchVSWR);

        if(reqId!=0)
            System.out.println(reqId);
        else
            System.out.println("There is no antenna with the given parameter");

        if(reqAntennas!=null)
        {
            for(Antenna antenna:reqAntennas)
                System.out.println(antenna.getLead());
        }
        else
        {
            System.out.println("No antenna found");
        }
    }

    public static int searchAntennaByName(Antenna antennas[],String searchName)
    {
        for(Antenna antenna:antennas)
        {
            if(antenna.getName().equalsIgnoreCase(searchName))
                return antenna.getId();
        }
        return 0;
    }

    public static Antenna[] sortAntennaByVSWR(Antenna antennas[],double searchVSWR)
    {
        int count=0;
        for(Antenna a:antennas)
        {
            if(a.getVSWR()<searchVSWR)
                count++;
        }
        if(count==0)
            return null;
        Antenna ans[]=new Antenna[count];
        int p=0;
        for(Antenna a:antennas)
        {
            if(a.getVSWR()<searchVSWR)
                ans[p++]=a;
        }
        for(int i=0;i<count-1;i++)
        {
            for(int j=i+1;j<count;j++)
            {
                if(ans[j].getVSWR()<ans[i].getVSWR())
                {
                    Antenna temp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=temp;
                }
            }
        }
        return ans;
    } 
}

class Antenna
{
    private int antennaId;
    private String antennaName,projectLead;
    private double antennaVSWR;

    public Antenna(int id,String name,String lead,double vswr)
    {
        antennaId=id;
        antennaName=name;
        projectLead=lead;
        antennaVSWR=vswr;
    }

    public int getId()
    {
        return antennaId;
    }

    public String getName()
    {
        return antennaName;
    }

    public String getLead()
    {
        return projectLead;
    }

    public double getVSWR()
    {
        return antennaVSWR;
    }
}
