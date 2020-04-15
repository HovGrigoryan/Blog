import exception.CategoryNotFoundException;
import exception.PostNotFoundException;

public interface PostStoragelmpl {
    void add(Post post);

    Post getPostByTitle(String title) throws PostNotFoundException;

    void searchPostsByKeyword(String keyword) throws CategoryNotFoundException;

    void printAllPosts();

    void printPostsByCategory(String category) throws CategoryNotFoundException;
}
