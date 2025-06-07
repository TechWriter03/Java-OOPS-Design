// Input:
// 101 
// Rakki Cinemas        
// 1500
// 200.0
// 4
// 102
// Rohini Silver Screens
// 2000
// 300.0
// 5
// 103
// PVR Cinemas
// 1700
// 150.0
// 4
// 104
// Venkateshwara Talkies
// 700
// 100.0
// 3
// 102
// Output:
// Premium
// Rakki Cinemas

import java.util.*;

public class TheatreManagement
{
    public static void main(String args[])
    {
        int noOfTheatres=4;
        Theatre theatres[]=new Theatre[noOfTheatres];

        Scanner sc=new Scanner(System.in);
        for(int i=0;i<noOfTheatres;i++)
        {
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            int capacity=sc.nextInt();
            double rate=sc.nextDouble();
            int rating=sc.nextInt();
            Theatre theatre=new Theatre();
            theatre.setTheatreId(id);
            theatre.setTheatreName(name);
            theatre.setSeatCapacity(capacity);
            theatre.setTicketRate(rate);
            theatre.setRating(rating);
            theatres[i]=theatre;
        }

        int id=sc.nextInt();
        String category=findCategory(theatres, id);
        Theatre secondHighestTicket=findSecondHighestTicket(theatres);

        if(category!=null)
            System.out.println(category);
        else
            System.out.println("There is no theatre with the given theatreId");
            
        if(secondHighestTicket!=null)
            System.out.println(secondHighestTicket.getTheatreName());
        else
            System.out.println("Only low rating theatres are available");

    }

    public static String findCategory(Theatre theatres[],int id)
    {
        for(int i=0;i<theatres.length;i++)
        {
            Theatre current=theatres[i];
            if(current.getTheatreId()==id)
            {
                if(current.getSeatCapacity()>1000 && current.getRating()>=4)
                    return "Premium";
                else
                    return "Non-Premium";
            }
        }
        return null;
    }

    public static Theatre findSecondHighestTicket(Theatre theatres[])
    {
        double max1=0,max2=0;
        for(int i=0;i<theatres.length;i++)
        {
            Theatre current=theatres[i];
            double rate=current.getTicketRate();
            if(current.getRating()>=2)
            {
                if(rate>max1)
                {
                    max2=max1;
                    max1=rate;
                }
                else if(rate<max1 && rate>max2)
                {
                    max2=rate;
                }
            }
        }

        for(int i=0;i<theatres.length;i++)
        {
            if(theatres[i].getTicketRate()==max2)
                return theatres[i];
        }
        return null;
    }
}

class Theatre
{
    private int theatreId;
    private String theatreName;
    private int seatCapacity;
    private double ticketRate;
    private int rating;

    public void setTheatreId(int id)
    {
        theatreId=id;
    }

    public void setTheatreName(String name)
    {
        theatreName=name;
    }

    public void setSeatCapacity(int capacity)
    {
        seatCapacity=capacity;
    }

    public void setTicketRate(double rate)
    {
        ticketRate=rate;
    }

    public void setRating(int rating)
    {
        this.rating=rating;
    }

    public int getTheatreId()
    {
        return theatreId;
    }

    public String getTheatreName()
    {
        return theatreName;
    }

    public int getSeatCapacity()
    {
        return seatCapacity;
    }

    public double getTicketRate()
    {
        return ticketRate;
    }

    public int getRating()
    {
        return rating;
    }
}
