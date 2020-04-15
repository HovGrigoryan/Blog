import exception.CategoryNotFoundException;
import exception.PostNotFoundException;

import java.util.Date;
import java.util.Scanner;

public class BlogMain implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static PostStorage postStorage = new PostStorage();


    public static void main(String[] args) throws CategoryNotFoundException {
        boolean isRun = true;
        while (isRun) {
            princommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please Input number!");
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    System.out.println("BYE BYE");
                    break;
                case ADD_POST:
                    addPost();
                    break;
                case SEARCH_POST:
                    searchPost();
                    break;
                case POSTS_BY_CATEGORY:
                    postsByCategory();
                    break;
                case ALL_POSTS:
                    allPosts();
                    break;
            }
        }
    }

    private static void allPosts() {
        postStorage.printAllPosts();

    }

    private static void postsByCategory() throws CategoryNotFoundException {
        System.out.println("Please input Category for search");
        try {
            String category = scanner.nextLine();
            postStorage.printPostsByCategory(category);
//        }catch (NumberFormatException e){
//            System.out.println("Incorrect value! Please try again");
//            postsByCategory();
        }
        catch (CategoryNotFoundException e){
            System.out.println(e.getMessage());
        }



    }

    private static void searchPost() {
        System.out.println("Please input Title for search");
        try {
            String title = scanner.nextLine();
            Post seachrPost = postStorage.getPostByTitle(title);
            System.out.println(seachrPost);
        } catch (PostNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void addPost() {
        try {
            System.out.println("Please Input Posts info: Title, Text, Category  ");
            String posts = scanner.nextLine();
            String[] postsone = posts.split(",");
            Post post = new Post();
            Date date = new Date();
            post.setTitle(postsone[0]);
            post.setText(postsone[1]);
            post.setCategory(postsone[2]);
            post.setDate(date);
            postStorage.add(post);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception");
            addPost();
        }

    }

    private static void princommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_POST + " for Add");
        System.out.println("Please input " + SEARCH_POST + " for Search by Title");
        System.out.println("Please input " + POSTS_BY_CATEGORY + " Search by Category");
        System.out.println("Please input " + ALL_POSTS + " for All posts");
    }
}
