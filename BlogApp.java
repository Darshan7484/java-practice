import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

class Blog {

    int id;
    String title;
    String content;
    String author;
    String category;
    Date date;

    Blog(int id, String title, String content, String author, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
        this.date = new Date();
    }

    void display() {
        System.out.println("\nID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Date: " + date);
    }
}


class BlogService {

    ArrayList<Blog> blogs = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int idCounter = 1;


    void createBlog() {

        sc.nextLine();

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter content: ");
        String content = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        Blog blog = new Blog(idCounter++, title, content, author, category);

        blogs.add(blog);

        System.out.println("Blog created successfully!");
    }

    void editBlog() {

        System.out.print("Enter Blog ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Blog b : blogs) {

            if (b.id == id) {

                System.out.print("Enter new title: ");
                b.title = sc.nextLine();

                System.out.print("Enter new content: ");
                b.content = sc.nextLine();

                System.out.print("Enter new category: ");
                b.category = sc.nextLine();

                System.out.println("Blog updated successfully!");
                return;
            }
        }

        System.out.println("Blog not found!");
    }

    void deleteBlog() {

        System.out.print("Enter Blog ID: ");
        int id = sc.nextInt();

        Iterator<Blog> it = blogs.iterator();

        while (it.hasNext()) {

            Blog b = it.next();

            if (b.id == id) {

                it.remove();

                System.out.println("Blog deleted successfully!");
                return;
            }
        }

        System.out.println("Blog not found!");
    }


    // View All Blogs
    void viewAllBlogs() {

        if (blogs.isEmpty()) {
            System.out.println("No blogs available.");
            return;
        }

        for (Blog b : blogs) {
            b.display();
        }
    }
    void viewById() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Blog b : blogs) {

            if (b.id == id) {

                b.display();
                return;
            }
        }

        System.out.println("Blog not found!");
    }

    void searchByTitle() {

        sc.nextLine();

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        boolean found = false;

        for (Blog b : blogs) {

            if (b.title.toLowerCase().contains(title.toLowerCase())) {

                b.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("No matching blogs.");
    }

    void filterByCategory() {

        sc.nextLine();

        System.out.print("Enter category: ");
        String cat = sc.nextLine();

        boolean found = false;

        for (Blog b : blogs) {

            if (b.category.equalsIgnoreCase(cat)) {

                b.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("No blogs in this category.");
    }
}

public class BlogApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BlogService service = new BlogService();

        while (true) {

            System.out.println("\nSelect Role:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            int role = sc.nextInt();

            switch (role) {

                case 1:
                    adminMenu(service);
                    break;

                case 2:
                    userMenu(service);
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }


    static void adminMenu(BlogService service) {

        while (true) {

            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Create Blog");
            System.out.println("2. Edit Blog");
            System.out.println("3. Delete Blog");
            System.out.println("4. View All Blogs");
            System.out.println("5. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.createBlog();
                    break;

                case 2:
                    service.editBlog();
                    break;

                case 3:
                    service.deleteBlog();
                    break;

                case 4:
                    service.viewAllBlogs();
                    break;

                case 5:
                    return;
            }
        }
    }


    static void userMenu(BlogService service) {

        while (true) {

            System.out.println("\n--- User Menu ---");
            System.out.println("1. View All Blogs");
            System.out.println("2. View Blog by ID");
            System.out.println("3. Search by Title");
            System.out.println("4. Filter by Category");
            System.out.println("5. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.viewAllBlogs();
                    break;

                case 2:
                    service.viewById();
                    break;

                case 3:
                    service.searchByTitle();
                    break;

                case 4:
                    service.filterByCategory();
                    break;

                case 5:
                    return;
            }
        }
    }
}