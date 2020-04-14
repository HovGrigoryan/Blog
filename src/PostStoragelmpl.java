public interface PostStoragelmpl {
    void add(Post post);

    Post getPostByTitle(String title);

    void searchPostsByKeyword(String keyword);

    void printAllPosts();

    void printPostsByCategory(String category);
}
