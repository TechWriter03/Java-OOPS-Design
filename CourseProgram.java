import java.util.*;

class Course
{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handsOn;

    public Course(int id,String name,String admin,int qz,int ho)
    {
        courseId=id;
        courseName=name;
        courseAdmin=admin;
        quiz=qz;
        handsOn=ho;
    }

    public int getCourseId()
    {
        return courseId;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public String getCourseAdmin()
    {
        return courseAdmin;
    }

    public int getQuiz()
    {
        return quiz;
    } 

    public int getHandsOn()
    {
        return handsOn;
    }
}

public class CourseProgram
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=4;
        Course courses[]=new Course[n];
        for(int i=0;i<n;i++)
        {
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            String admin=sc.nextLine();
            int quiz=sc.nextInt();
            int handsOn=sc.nextInt();
            courses[i]=new Course(id,name,admin,quiz,handsOn);
        }

        sc.nextLine();
        String admin=sc.nextLine();
        int maxHandsOn=sc.nextInt();
        int avg=findAvgOfQuizByAdmin(courses,admin);

        if(avg==0)
            System.out.println("No Course found.");
        else
            System.out.println(avg);

        Course sortedCourses[]=sortCourseByHandsOn(courses,maxHandsOn);
        if(sortedCourses==null)
            System.out.println("No Course found with mentioned attribute.");
        else
            for(int i=0;i<sortedCourses.length;i++)
                System.out.println(sortedCourses[i].getCourseName());
    }

    public static int findAvgOfQuizByAdmin(Course courses[],String admin)
    {
        int sum=0,total=0;
        for(int i=0;i<courses.length;i++)
        {
            if(courses[i].getCourseAdmin().equals(admin))
            {
                sum+=courses[i].getQuiz();
                total++;
            }
        }
        if(sum==0)
            return 0;
        return sum/total;
    }

    public static Course[] sortCourseByHandsOn(Course courses[],int maxHandsOn)
    {
        int count=0;
        HashMap<Integer,Course>courseHandsOn=new HashMap<>();
        for(int i=0;i<courses.length;i++)
        {
            if(courses[i].getHandsOn()<maxHandsOn)
                count++;
            courseHandsOn.put(courses[i].getHandsOn(),courses[i]);
        }
        if(count==0)
            return null;
        int sortedHandsOn[]=new int[count];
        int ptr=0;
        for(int i=0;i<courses.length;i++)
            if(courses[i].getHandsOn()<maxHandsOn)
                sortedHandsOn[ptr++]=courses[i].getHandsOn();
        Arrays.sort(sortedHandsOn);
        Course sortedCourses[]=new Course[count];
        int ptr2=0;;
        for(int i=0;i<count;i++)
            sortedCourses[ptr2++]=courseHandsOn.get(sortedHandsOn[i]);
        return sortedCourses;
    }
}
