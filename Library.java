// Enter role (admin/user): admin
// Enter username: admin
// Enter password: password
// Logged in as admin   

// 1.Add Book
// 2.Update Book        
// 3.Delete Book        
// 4.Add Members        
// 5.Display All Books  
// 6.Display All Members
// 7.Logout
// Enter your choice: 1 
// Enter title: C++
// Enter author: Bjarne Stroustrup
// Enter genre: Programming
// Book Added Successfully

// 1.Add Book
// 2.Update Book
// 3.Delete Book
// 4.Add Members
// 5.Display All Books
// 6.Display All Members
// 7.Logout
// Enter your choice: 1
// Enter title: Java
// Enter author: James 
// Enter genre: Program
// Book Added Successfully

// 1.Add Book
// 2.Update Book
// 3.Delete Book
// 4.Add Members
// 5.Display All Books
// 6.Display All Members
// 7.Logout
// Enter your choice: 1
// Enter title: test
// Enter author: test
// Enter genre: test
// Book Added Successfully

// 1.Add Book
// 2.Update Book
// 3.Delete Book
// 4.Add Members
// 5.Display All Books
// 6.Display All Members
// 7.Logout
// Enter your choice: 2
// Enter title: Java
// Enter new author: James Gosling 
// Enter new genre: Programming
// Book Updated Successfully

// 1.Add Book
// 2.Update Book
// 3.Delete Book
// 4.Add Members
// 5.Display All Books
// 6.Display All Members
// 7.Logout
// Enter your choice: 3
// Enter title: test
// Book Deleted Sucessfully

// 1.Add Book
// 2.Update Book
// 3.Delete Book
// 4.Add Members
// 5.Display All Books
// 6.Display All Members
// 7.Logout
// Enter your choice: 5
// Title: C++, Author: Bjarne Stroustrup, Genre: Programming, Available: true
// Title: Java, Author: James Gosling, Genre: Programming, Available: true

// 1.Add Book
// 2.Update Book
// 3.Delete Book
// 4.Add Members
// 5.Display All Books
// 6.Display All Members
// 7.Logout
// Enter your choice: 4
// Enter name: Santhosh
// Member Added Successfully

// 1.Add Book
// 2.Update Book
// 3.Delete Book
// 4.Add Members
// 5.Display All Books
// 6.Display All Members
// 7.Logout
// Enter your choice: 4        
// Enter name: Leo Das
// Member Added Successfully

// 1.Add Book
// 2.Update Book
// 3.Delete Book
// 4.Add Members
// 5.Display All Books
// 6.Display All Members
// 7.Logout
// Enter your choice: 7
// Logged out as admin

// Enter role (admin/user): user
// Enter username: Santhosh
// Logged in as Santhosh

// 1.Borrow
// 2.Return
// 3.Display All Books
// 4.Display All Members
// 5.Logout
// Enter your choice: 1
// Enter title: C++
// Book Borrowed Successfullly

// 1.Borrow
// 2.Return
// 3.Display All Books
// 4.Display All Members
// 5.Logout
// Enter your choice: 3
// Title: C++, Author: Bjarne Stroustrup, Genre: Programming, Available: false
// Title: Java, Author: James Gosling, Genre: Programming, Available: true

// 1.Borrow
// 2.Return
// 3.Display All Books
// 4.Display All Members
// 5.Logout
// Enter your choice: 4
// Name: Santhosh, Borrowed: 1
// Name: Leo Das, Borrowed: 0

// 1.Borrow
// 2.Return
// 3.Display All Books
// 4.Display All Members
// 5.Logout
// Enter your choice: 2
// Enter title: C++
// Book Returned Successfullly

// 1.Borrow
// 2.Return
// 3.Display All Books
// 4.Display All Members
// 5.Logout
// Enter your choice: 4
// Name: Santhosh, Borrowed: 0
// Name: Leo Das, Borrowed: 0

// 1.Borrow
// 2.Return
// 3.Display All Books
// 4.Display All Members
// 5.Logout
// Enter your choice: 5
// Logged out as Santhosh

import java.util.*;

class Book
{
    String title;
    String author;
    String genre;
    boolean available;

    public Book(String title,String author,String genre)
    {
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.available=true;
    }
}

class Member
{
    String username;
    List<Book>borrowed=new ArrayList<>();

    public Member(String username)
    {
        this.username=username;
    }
}

public class Library
{
    static Scanner sc=new Scanner(System.in);
    static List<Book>books=new ArrayList<>();
    static List<Member>members=new ArrayList<>();

    public static void main(String args[])
    {
        while(true)
        {
            System.out.print("Enter role (admin/user): ");
            String role=sc.nextLine();
            if(role.equals("admin"))
            {
                adminLogin();
            }
            else if(role.equals("user"))
            {
                userLogin();
            }
        }
    }

    public static void adminLogin()
    {
        System.out.print("Enter username: ");
        String username=sc.nextLine();
        System.out.print("Enter password: ");
        String password=sc.nextLine();
        if(username.equals("admin") && password.equals("password"))
        {
            System.out.println("Logged in as admin");
            System.out.println();
            while (true)
            {
                System.out.println("1.Add Book\n2.Update Book\n3.Delete Book\n4.Add Members");
                System.out.println("5.Display All Books\n6.Display All Members\n7.Logout");
                System.out.print("Enter your choice: ");
                int choice=sc.nextInt();
                sc.nextLine();
                switch (choice)
                {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        updateBook();
                        break;
                    case 3:
                        deleteBook();
                        break;
                    case 4:
                        addMember();
                        break;
                    case 5:
                        displayBooks();
                        break;
                    case 6:
                        displayMembers();
                        break;
                    case 7:
                        System.out.println("Logged out as admin");
                        System.out.println();
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                if(choice==7)
                    break;
            }
        }
        else
        {
            System.out.println("Invalid Credentials");
            System.out.println();
        }
    }

    public static void userLogin()
    {
        System.out.print("Enter username: ");
        String username=sc.nextLine();
        Member currentUser=null;
        for(Member member:members)
        {
            if(member.username.equals(username))
            {
                currentUser=member;
                break;
            }
        }
        if(currentUser!=null)
        {
            System.out.println("Logged in as "+currentUser.username);
            System.out.println();
            while (true)
            {
                System.out.println("1.Borrow\n2.Return");
                System.out.println("3.Display All Books\n4.Display All Members\n5.Logout");
                System.out.print("Enter your choice: ");
                int choice=sc.nextInt();
                sc.nextLine();
                switch (choice)
                {
                    case 1:
                        borrowBook(currentUser);
                        break;
                    case 2:
                        returnBook(currentUser);
                        break;
                    case 3:
                        displayBooks();
                        break;
                    case 4:
                        displayMembers();
                        break;
                    case 5:
                        System.out.println("Logged out as "+currentUser.username);
                        System.out.println();
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                if(choice==5)
                    break;
            }
        }
        else
        {
            System.out.println("User not found");
            System.out.println();
        }
    }

    public static void addBook()
    {
        System.out.print("Enter title: ");
        String title=sc.nextLine();
        System.out.print("Enter author: ");
        String author=sc.nextLine();
        System.out.print("Enter genre: ");
        String genre=sc.nextLine();
        books.add(new Book(title,author,genre));
        System.out.println("Book Added Successfully");
        System.out.println();
    }

    public static void updateBook()
    {
        System.out.print("Enter title: ");
        String title=sc.nextLine();
        for(Book book:books)
        {
            if(book.title.equals(title))
            {
                System.out.print("Enter new author: ");
                String author=sc.nextLine();
                System.out.print("Enter new genre: ");
                String genre=sc.nextLine();
                book.author=author;
                book.genre=genre;
                System.out.println("Book Updated Successfully");
                System.out.println();
                return;
            }
        }
        System.out.println("There is no book with this title");
    }

    public static void deleteBook()
    {
        System.out.print("Enter title: ");
        String title=sc.nextLine();
        for(int i=0;i<books.size();i++)
        {
            if(books.get(i).title.equals(title))
            {
                books.remove(i);
                System.out.println("Book Deleted Sucessfully");
                System.out.println();
                return;
            }
        }
        System.out.println("There is no book with this title");
    }
    
    public static void addMember()
    {
        System.out.print("Enter name: ");
        String username=sc.nextLine();
        members.add(new Member(username));
        System.out.println("Member Added Successfully");
        System.out.println();
    }

    public static void borrowBook(Member currentUser)
    {
        if(currentUser.borrowed.size()<5)
        {
            System.out.print("Enter title: ");
            String title=sc.nextLine();
            for(Book book:books)
            {
                if(book.available && book.title.equals(title))
                {
                    book.available=false;
                    currentUser.borrowed.add(book);
                    System.out.println("Book Borrowed Successfullly");
                    System.out.println();
                }
            }
        }
        else
        {
            System.out.println("Either limit reached or book not available");
            System.out.println();
        }
    }
    
    public static void returnBook(Member currentUser)
    {
        if(!currentUser.borrowed.isEmpty())
        {
            System.out.print("Enter title: ");
            String title=sc.nextLine();
            for(Book book:books)
            {
                if(book.title.equals(title))
                {
                    book.available=true;
                    currentUser.borrowed.remove(book);
                    System.out.println("Book Returned Successfullly");
                    System.out.println();
                }
            }
        }
        else
        {
            System.out.println("No book is borrowed");
            System.out.println();
        }
    }

    public static void displayBooks()
    {
        for(Book book:books)
        {
            System.out.print("Title: "+book.title);
            System.out.print(", Author: "+book.author);
            System.out.print(", Genre: "+book.genre);
            System.out.println(", Available: "+book.available);
        }
        System.out.println();
    }

    public static void displayMembers()
    {
        for(Member member:members)
        {
            System.out.print("Name: "+member.username);
            System.out.println(", Borrowed: "+member.borrowed.size());
        }
        System.out.println();
    }
}
